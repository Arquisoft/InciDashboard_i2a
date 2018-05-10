Feature: Login page

Scenario: Let an operator log in
  Given a list of users as:
      | name    | password |
      | fireman2@gmail.com    | 123456   |
  When operator logs in with name "fireman2@gmail.com " and password "123456"
  Then operator is logged in