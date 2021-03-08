@quote
  Feature: Quote OOP

    @quote1
    Scenario: Required fields for quote
      Given I open "quote" page
      When I fill out required fields
      And I submit the form
      Then I verify required fields

