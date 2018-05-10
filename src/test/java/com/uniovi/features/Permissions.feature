#language: en
Feature: Permissions page
Scenario: Modify permissions
	Given a list of operators being:
      | name    | password |
      | fireman1@gmail.com    | 123456   |
    When I login with email "fireman1@gmail.com" and pass "123456"
  	Then permissions are shown
