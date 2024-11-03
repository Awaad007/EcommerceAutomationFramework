Feature: WishList
  Background:
    Given user at home screen and click on login button
    When user enters "mohamed005@yahoo.com" address
    And user enters "654321"
    And user click on login button
    Given user at the home screen and enter product name in search bar
    When user click on search button
    And user select category
    And user click on product title
    
  Scenario: Add product to wishlist
    Given user at product screen and click on add to wishlist button
    When user click on wishlist page link
    And user tap on remove button
    Then success message should appear to user
