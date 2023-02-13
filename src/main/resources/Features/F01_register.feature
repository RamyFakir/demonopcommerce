Feature: F01_Registration |New User can create an account

  #Positive scenario
  Scenario: Creating an account using valid data
    Given User go to register page
    When User select male gender
    And User enter "Ramy" & "Fakir"
    And User enter date of birth
    And User enter email "ramy.fakir@demo.com"
    And User enter password "p@ssw0rd"
    And User click on register button
    Then account is created successfully