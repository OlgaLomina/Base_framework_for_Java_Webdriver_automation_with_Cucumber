@GoogleMaps
Feature: Google Maps fastest from the list

    @GoogleMaps1
      Scenario: Maps find the fastest from the list
      Given Navigate to the "Google" maps landing page
      When I enter "San Jose" as the destination
      And I find directions from "San Francisco"
      Then I will find the shortest distance
