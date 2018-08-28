Feature: Login feature
  Scenario: Valid user login
    Given a user with valid credentials
    When Tries to login
    Then User should be able to login successfully

