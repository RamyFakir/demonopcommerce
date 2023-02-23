@smoke
Feature: F08_Wishlist | user can add products to wishlist

  Scenario: User can add an item to the wishlist successfully
    When user click on the wishlist button
    Then a success message "the product has been added to your wishlist" appears
    And the message has a green background

  Scenario: User can add an item to the wishlist successfully and check qty
    When user click on the wishlist button
    Then after success message disappears user click on wishlist
    And Qty is more than zero