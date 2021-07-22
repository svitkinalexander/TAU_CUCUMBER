# This is a comment

Feature: Login functionality feature
    In order to log in
    As an Admin
    I want to login successfully

    Scenario: Successful login

        Given I am in the Orange HRM main page
        When I enter valid credentials
        Then I get to the Dashboard page

    # Highlighted may be defined:
    # Create step definition
    # But run to get better definitions