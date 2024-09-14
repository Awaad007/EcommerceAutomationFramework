@Run
Feature: Add product review
  Background:
    Given user at home screen and click on login button
    When user enters "mohamed005@yahoo.com" address
    And user enters "654321"
    And user click on login button
    Given user at the home screen and enter product name in search bar
    When user click on search button
    And user select category
    And user click on product title
    Scenario: User can product review
      Given user at product screen and click on write review
      When user type product review
      And  user rate product
      And user click on continue button
      Then review should be submitted successfully