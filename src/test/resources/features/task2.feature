@Task2
  Feature: Role Teacher
    Scenario: User can login and logout
      Given I open the page
      When  I login with credentials as "teacher"
      Then  I validate the user "Iryna Valadimirova" and "TEACHER"
      And   I validate list of menu items
      Then  I logout from the page