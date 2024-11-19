Feature: Compare
  Background:
    Given user at home screen and click on login button
    When user enters "mohamed005@yahoo.com" address
    And user enters "654321"
    And user click on login button
    Given user at the home screen and enter product name in search bar
    When user click on search button
    And user select category
    And user click on product title

    Scenario: Compare products
      Given user click on compare button
      When navigate to compare screen
      And user add second product to compare list
      And user comparing products
      And taps on remove button
      Then placeholder message should appear to user