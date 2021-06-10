@issu
Feature: Test Search

  @issu1
  Scenario Outline: Required fields for quote
    Given Navigate to main Page
    When Search for the word <search_input>
    Then Verify that result set contains <expected_result>

    Examples:
      | search_input          | expected_result       |
      | "National Geographic" | "National Geographic" |
      | "Forbes"              | "Other"               |
      | "Aviation"            | "Different"           |
