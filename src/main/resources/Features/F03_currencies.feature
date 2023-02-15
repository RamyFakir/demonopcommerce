@smoke
Feature: F03_currencies | users could change currency


  Scenario: users change currency to Euro
    When user change currency to Euro
    Then currency changes to Euro
