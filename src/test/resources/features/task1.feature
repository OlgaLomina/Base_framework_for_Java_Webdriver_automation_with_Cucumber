@Task1
Feature: Google Map - check the fastest time
  Scenario: User can get the fastest time for rout
    Given I open the "https://www.google.com/maps" page
    When I click on create rout
    Then I fill out field From
    Then I fill out field To
    Then I click on search rout
    Then I verify the fastest rout
