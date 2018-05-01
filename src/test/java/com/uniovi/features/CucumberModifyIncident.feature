Feature: Change some properties of an incident

Scenario: Modify an incident
	Given an operator
	When he is logged in
	And wants to modify an incident
	Then he lists all the incidents
	And modifies one of them