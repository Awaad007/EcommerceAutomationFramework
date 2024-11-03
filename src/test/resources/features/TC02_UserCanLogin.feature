@Run
Feature: Login
  Scenario Outline: user Login with valid and invalid cred:
    Given user at home screen and click on login button
    When user enters "<email>" address
    And user enters "<password>"
    And user click on login button
    Then user should be logged in successfully


    Examples:
      | email |password|
      | mohamed001@yahoo.com | 123456 |
      | mohamed003@yahoo.com | 654321 |