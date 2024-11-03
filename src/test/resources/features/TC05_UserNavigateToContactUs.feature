@Run
Feature: contact us
  Scenario: TC05-User navigate to contact us page
    Given user at home screen and click on contact us button
    When user enter full name
    And user enter email
    And user enter enquiry
    And user click on submit button
    Then user message should be received successfully