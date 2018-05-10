Feature: Wrong login
Scenario: Deny access to strangers
	Given a list of operators:
      | name    | password |
      | fireman1@gmail.com    | 123456   |
  When He tries with name "fireman1@gmail.com " and password "546546456546"
  Then the client is not authorized