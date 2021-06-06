@GoogleMaps
  Feature: Tests for GM (not General Motors)

    @ShortestPath
    Scenario: Validate shortest path
      Given I open "Google Maps" page
      When I input "San Jose" into search field
      And I press "Direction" button
      And I input "San Diego" into starting point field
      Then I validate "Fastest route" in results
      And I confirm that distance equals "460" miles