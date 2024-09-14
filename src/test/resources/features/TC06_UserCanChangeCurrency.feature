@Run
Feature: Change Currency
  Scenario: TC06 User Can Change Currency From DropDown
    Given user at home page and click on currency dropdown
    When user select euro as new currency
    Then website currency should be updated to euro successfully