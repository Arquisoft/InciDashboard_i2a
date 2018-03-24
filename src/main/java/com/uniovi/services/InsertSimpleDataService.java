package com.uniovi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Agent;
import com.uniovi.entities.Incident;
import com.uniovi.entities.Operator;
import com.uniovi.entities.types.AgentKind;
import com.uniovi.entities.types.OperatorKind;
import com.uniovi.utils.IncidentCreator;

@Service
public class InsertSimpleDataService {
	@Autowired
	private OperatorService operatorService;
	
	@Autowired 
	private AgentService agentService;
	
	@Autowired
	private IncidentService incidentService;
	
	@Autowired
	private IncidentCreator incidentCreator;
	
	private List<Operator> operators;
	private List<Agent> agents;
	private List<Incident> incidents;
	
	private Random randNum;
	
	@PostConstruct
	public void init() {
		operators = new ArrayList<>();
		agents = new ArrayList<>();
		incidents = new ArrayList<>();
		randNum = new Random();
		
		operators.add(new Operator("fireman@gmail.com", "123456", OperatorKind.FIREMAN));
		operators.add(new Operator("police@gmail.com", "123456", OperatorKind.POLICE));
		operators.add(new Operator("medic@gmail.com", "123456", OperatorKind.MEDIC));
		operators.add(new Operator("rescue@gmail.com", "123456", OperatorKind.RESCUE));
		
		for(Operator op: operators) {
			operatorService.addOperator(op);
		}
		
		agents.add(new Agent("javier@gmail.com", "123456", AgentKind.PERSON));
		agents.add(new Agent("alba@gmail.com", "123456", AgentKind.ENTITY));
		agents.add(new Agent("marcos@gmail.com", "123456", AgentKind.SENSOR));
		
		for(Agent ag: agents) {
			agentService.addAgent(ag);
		}
		
		incidentCreator.setAgents(agents);
		
		for(int i=0; i<15; i++) {
			Incident randIncident = incidentCreator.createIncident();
			randIncident.setOperator(operators.get(randNum.nextInt(operators.size())));
			incidents.add(randIncident);
			incidentService.addIncident(randIncident);
			
		}		
	}
}
