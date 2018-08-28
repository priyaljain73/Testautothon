Feature: Test multi platform

  Scenario: Verify Multi platform invokation
    Given google returns result for samsung
    When user runs dummy api
    Then data is passed to different env