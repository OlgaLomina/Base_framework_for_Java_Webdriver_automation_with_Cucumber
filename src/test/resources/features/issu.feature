@issu
Feature: Test Search

  @issu1
  Scenario: Required fields for quote
    Given Navigate to main Page
    When Search for the word "National Geographic"
    Then Verify that result set contains "National Geographic"

  @issu2
  Scenario Outline: Required fields for quote2
    Given Navigate to main Page
    When Search for the word <searchtxt>
    Then Verify that result set contains <verifytxt>
    Examples:
      | searchtxt | verifytxt |
      | SAP       | SAP       |
      | PayPal    | PayPal    |


  @issu3
  Scenario Outline: Required fields for quote3
    Given Navigate to main Page
    When Search for the word <search_input>
    Then Verify that result set contains <expected_result>
    Examples:
      | search_input          | expected_result       |
      | "National Geographic" | "National Geographic" |
      | "Forbes"              | "Other"               |
      | "Aviation"            | "Different"           |