Feature: Lookup samsung in google

  Scenario: Verify google search
    Given the user is on the google home page
    When the user searches for 'samsung'
    Then search results should come up
