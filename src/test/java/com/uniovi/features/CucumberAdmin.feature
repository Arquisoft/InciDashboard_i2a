Feature: Admin features

Scenario: Show the incidents
  	Given a list of operators as:
      | name    | password |
      | fireman1@gmail.com    | 123456   |
    When I login with email "fireman1@gmail.com" and password "123456"
  	Then incidents are shown