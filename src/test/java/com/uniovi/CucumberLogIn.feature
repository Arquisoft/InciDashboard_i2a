Feature: Let an operator log in the system
		The operator must belong to the system
		The email and the password must be correct	

Scenario: Let an operator log in
  Given an operator  
  When operator is in home page
  And clicks on Log In
  And fills in correctly the email and password
  Then operator is logged in