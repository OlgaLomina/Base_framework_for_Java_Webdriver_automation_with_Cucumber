@task1
Feature: Automate Google Maps Destinations From - To

  @task1
  Scenario Outline: Google Maps Destinations From - To
    Given I open "googlemaps" page
    When I fill out Destinations From <search_input_to> To <search_input_from>
    Then I verify the <expected_res>

    Examples:
      | search_input_to | search_input_from | expected_res    |
      | "Redmond WA"    | "San Diego CA"    | "Fastest route" |
      | "Redmond WA"    | "Las Vegas NV"    | "Fastest route" |
