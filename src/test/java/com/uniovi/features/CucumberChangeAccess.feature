Feature: Check if the admin has access to modification

Scenario: Change some permissions
  Given an admin
  When he wants to check if he has access to modifications
  Then he wants to change the access to charts