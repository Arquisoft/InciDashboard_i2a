package cucumber.steps;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import javax.annotation.Resource;

import org.hamcrest.MatcherAssert;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.uniovi.controllers.OperatorController;
import com.uniovi.cucumber.AbstractSteps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WrongLoginSteps extends AbstractSteps {

	@Mock
	private OperatorController oController;
	private MockMvc mockMvc;
	private MockHttpServletResponse result;
	@Resource
    private FilterChainProxy springSecurityFilterChain;
 
    @Resource
    private WebApplicationContext webApplicationContext;


	
	@Given("a list of operators:$")
	public void a_list_of_users(DataTable arg) throws Exception {
		  MongoClientURI uri = new
		  MongoClientURI("mongodb://admin:aswadmin2018@ds159489.mlab.com:59489/aswdb");
		  //step not dup
		  MongoClient mongoClient = new MongoClient(uri); 
		  @SuppressWarnings("deprecation")
		  DB db = mongoClient.getDB("aswdb"); 
		  DBCollection agents = db.getCollection("operators");
		  
		  BasicDBObject query = new BasicDBObject();
		  query.put("email", "fireman1@gmail.com");
		  if(!(agents.find(query).size()>0)) {
			  mongoClient.close();
			  throw new Exception("Operator not in the system");
		  }
		  
		 mongoClient.close();
		 
	}
	@When("He tries with name \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void login_with_name_and_password(String name, String password) throws Exception {
		MockitoAnnotations.initMocks(this);
		 InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	        viewResolver.setPrefix("/WEB-INF/jsp/view/");
	        viewResolver.setSuffix(".jsp");
	 
	    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
	                .addFilter(springSecurityFilterChain)
	                .build();

		mockMvc.perform(get("http://localhost:8082"));
		MockHttpServletRequestBuilder request = post("/login").param("username", name).param("password", password);

		result = mockMvc.perform(request).andReturn().getResponse();
		
	}


	@Then("^the client is not authorized$")
	public void operatorNotLogged() throws Exception {
		MatcherAssert.assertThat(result.getStatus(), equalTo(302));
	}
	
}
