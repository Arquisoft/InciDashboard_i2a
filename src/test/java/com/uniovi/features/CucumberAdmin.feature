Feature: Admin features

Scenario: Show the incidents
  	Given a logged in admin
  	When he is in the main page
  	Then incidents are shown
  
Scenario: Modify permissions
	Given a logged in admin
  	When he is in the admin page
  	Then he can change some permissions