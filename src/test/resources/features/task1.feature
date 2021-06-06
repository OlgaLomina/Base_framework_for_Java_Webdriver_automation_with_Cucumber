@task1
Feature: Automate Google Maps Destinations From - To

  @task1
  Scenario: Google Maps Destinations From - To
    Given I open "googlemaps" page
    When I fill out Destinations From "Redmond WA" To "San Diego CA"
    Then I verify the "Fastest route"