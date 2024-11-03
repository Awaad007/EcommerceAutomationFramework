@Run
  Feature: search for product
    Background:
      Given user at home screen and click on login button
      When user enters "mohamed001@yahoo.com" address
      And user enters "654321"
      And user click on login button
    Scenario: user can search for product
      Given user at the home screen and enter product name in search bar
      When user click on search button
      And user select category
      And user click on product title
      Then user should be directed to product screen successfully
