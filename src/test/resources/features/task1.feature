@Task1
  Feature: Automate Google Maps Destinations From - To and check the fastest time is actually fastest from the list
    @Test
    Scenario: Automate Google Maps
      Given I open "googlemaps" page
      When I type destination address "San Francisco, California"
      And I click destination button
      And I type stating point "San Jose, California"
      Then I verify the fastest time is actually fastest from the list