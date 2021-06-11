@Ask
Feature: login Assessment Control
  @Test
  Scenario: login Assessment Control site
  Given I open "Assessment Control" page
  When Login with provided "teacher" credentials
  Then Validate the role "teacher" and name "Olga Wilson"
  And Validate list of menu items
  And Logout from the webpage