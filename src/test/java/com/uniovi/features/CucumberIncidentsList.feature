Feature: List all incidents belonging to an operator
	The operator must be logged in	

Scenario: Show the operator's incidents
  Given an operator  
  When logged in
  And has assigned incidents
  Then operator's incidents are shown