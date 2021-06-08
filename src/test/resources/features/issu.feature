@issu
Feature: Test Search

  @issu1
  Scenario: Required fields for quote
    Given Navigate to main Page
    When Search for the word "National Geographic"
    Then Verify that result set contains "National Geographic"
