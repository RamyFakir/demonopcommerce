
Feature: F04_Search feature | User could search for a certain product

  #Search using product name
  Scenario Outline: Login functionality for a social networking site.
    When user enter "<productName>"
    And user click on search button
    Then current url contains "https://demo.nopcommerce.com/search?q="
    And relevant product objects appear
    Examples:
              | productName |
              | book |
              | laptop |
              | nike |

  # Search using sku
  Scenario Outline: Login functionality for a social networking site.
    When user enter "<productSku>"
    And user click on search button
    And user click on relevant product
    Then product sku is the same as what user entered

    Examples:
      | productSku |
      | SCI_FAITH |
      | APPLE_CAM |
      | SF_PRO_11 |