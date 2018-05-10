Feature: Test the login page

Scenario: Let an operator log in
  Given somebody is in home page
  When clicks on Log In
  Then fills in correctly the email and password
  Then operator is logged in
  
Scenario: Deny access to strangers
	Given somebody is in home page
	When clicks on Log In
	Then fills in incorrectly the email and password
	Then he is not logged in