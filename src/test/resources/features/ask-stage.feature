@Login
  Feature: Test login
    
    @Test
    Scenario: Validate login and main page
      Given I open "ask-stage" page
      When I login From File
#      When I login with "teacher2@gmail.com" and "12345Abc"
      Then I validate dashboard info
      Then I logout