Feature: Check admin modification possibilities

Scenario: Change some permissions
  Given an admin
  When he wants to check if he has access to modifications
  Then he wants to change the access to charts
  
Scenario: Promote to admin
	Given an admin
 	 When he is logged in
  	And wants to make another user admin
  	Then he modifies the corresponding property