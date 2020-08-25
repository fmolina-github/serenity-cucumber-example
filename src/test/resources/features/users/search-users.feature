Feature: Search users

  Scenario: Search for a list of users
    Given Fer looks at a list of users
    When he request the list of users for page 2
    Then a success response with a list of available users is retrieved

  Scenario: Search for a specific user
    Given Fer looks at a list of users
    When he request to see the detail of user 2
    Then a success response with user detail is retrieved

  Scenario: Search for non existence user
    Given Fer looks at a list of users
    When he request to see the detail of an invalid user
    Then a not found response with empty user detail is retrieved