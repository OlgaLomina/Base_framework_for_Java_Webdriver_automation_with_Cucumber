@Task1
Feature: Google Map - check the fastest time
  Scenario: User can get the fastest time for route
    Given I open the "https://www.google.com/maps" page
    When I click on create route
    Then I fill out field From "San Francisco California"
    Then I fill out field To "San Jose California"
    Then I click on search route
    Then I verify the fastest route
