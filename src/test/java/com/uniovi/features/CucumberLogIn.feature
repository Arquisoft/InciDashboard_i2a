Feature: Login page

Scenario: Let an admin log in
  Given a list of users:
      | name    | password |
      | fireman1@gmail.com    | 123456   |
  When I login with name "fireman1@gmail.com " and password "123456"
  Then admin is logged in