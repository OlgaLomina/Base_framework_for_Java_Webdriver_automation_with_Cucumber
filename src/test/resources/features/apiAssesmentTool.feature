@api
Feature: API

  @api1
  Scenario: Validate sign in api
    Given Create api request for sign_in
    When Call sign_in by post method
    Then Validate sign-in api response