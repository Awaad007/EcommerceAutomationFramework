Feature: Checkout
  Background:
    Given user at home screen and click on login button
    When user enters "mohamed005@yahoo.com" address
    And user enters "654321"
    And user click on login button
    Given user at the home screen and enter product name in search bar
    When user click on search button
    And user select category
    And user click on product title
    And  user at product screen and click on add to cart button
    And user click on shopping cart link
    Scenario:
      Given user at cart screen and tapping on checkout button
      When user navigated to checkout screen and user confirm billing details
      And user taps on continue button
      And user confirm delivery details
      And user confirm delivery method
      And user accept terms and confirm payment method
      And user confirm order
      Then order should be placed successfully