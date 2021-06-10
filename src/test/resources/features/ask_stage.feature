@Login
  Feature: Test Login

    @Test
    Scenario Outline: Validate login and password
      Given I open "stage" page
      When I login with <user_id> and <password_id>
      Then I validate dashboard info <user_name> <role_name>


      Examples:
        | user_id              | password_id | user_name      | role_name |
        | "teacher1@gmail.com" | "12345Abc"  | "Anna Pavlova" | "TEACHER" |
        | "teacher2@gmail.com" | "12345Abc"  | "Diana Brown"  | "TEACHER" |


#    Steps to automate:
#    1) Navigate to http://ask-stage.portnov.com/#/home
#    2) Login with provided credentials
#    3) Validate the role and name
#    4) Validate list of menu items
#    5) Logout from the webpage

