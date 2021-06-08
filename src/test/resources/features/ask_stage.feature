@Login
  Feature: Test Login

    @Test
    Scenario: Validate login and password
      Given I open "stage" page
      When I login with "teacher3@gmail.com" and "12345Abc"
      Then I validate dashboard info


#    Steps to automate:
#    1) Navigate to http://ask-stage.portnov.com/#/home
#    2) Login with provided credentials
#    3) Validate the role and name
#    4) Validate list of menu items
#    5) Logout from the webpage

