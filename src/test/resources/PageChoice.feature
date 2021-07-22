# Login with parameters

Feature: Page choice with parameters feature
    In order to change a page
    As a User
    I get to the chosen page

   Scenario Outline: Page choice parametrized

        Given I am in the Orange HRM dashboard page
        When I click <linkname>
        Then I get <pagename> page name

       Examples:
           | linkname | pagename               |
           | "Admin"  | "System Users"         |
           | "PIM"    | "Employee Information" |
