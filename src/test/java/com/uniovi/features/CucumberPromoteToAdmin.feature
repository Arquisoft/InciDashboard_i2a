Feature: Promote another user to admin

Scenario: Modify the type of a user to admin
  Given an admin
  When he is logged in
  And wants to make another user admin
  Then he modifies the corresponding property