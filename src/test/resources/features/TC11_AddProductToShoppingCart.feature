
  Feature: ShoppingCart
    Background:
      Given user at home screen and click on login button
      When user enters "mohamed005@yahoo.com" address
      And user enters "654321"
      And user click on login button
      Given user at the home screen and enter product name in search bar
      When user click on search button
      And user select category
      And user click on product title

      Scenario:
        Given user at product screen and click on add to cart button
        When user click on shopping cart link
        And user update product quantity
        And user click on update button
        And user set shipping estimation and taxes
        And user check radio button
        And user click on apply shipping
        Then shipping estimation should be applied successfully
