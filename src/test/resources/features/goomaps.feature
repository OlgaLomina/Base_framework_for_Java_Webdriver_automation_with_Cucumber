@GoogleMaps
  Feature: Tests for GM (not General Motors)

    @ShortestPath
    Scenario Outline: Validate shortest path
      Given I open "Google Maps" page
      When I input "<Destination>" into search field
      And I press "Direction" button
      And I input "<StartingPoint>" into starting point field
      Then I validate "Fastest route" in results
      And I confirm that distance equals <Mileage> miles
      Examples:
      | Destination | StartingPoint | Mileage |
      | San Jose    | San Diego     | 460     |
      | Charlotte   | Boston        | 840     |