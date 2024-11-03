@Run
Feature: Register
  Scenario: TC-01-Register-User can Register to website
    Given user at register screen
    When user enter first name
    And user enter last name
    And user enter email address
    And user enter phone number
    And user enter password
    And user confirm password
    And click on register button
    Then user should be registered successfully
