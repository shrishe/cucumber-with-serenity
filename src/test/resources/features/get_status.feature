Feature: Get Application status and validate the response

  Scenario: Check rest web service status
    Given The "status" web service  is running
    When User query the "status" web service
    Then I expect a valid response
    And The response content type should be json