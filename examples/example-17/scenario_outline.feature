Feature: Scenario Outline

    Scenario Outline: The user does not log in successfully
        Given the user navigates to the home page
        When the user "<invalid user>" logs in
        Then the user is not signed in
    Examples:
    | invalid user |
    |  bad user 1  |
    |  bad user 2  |
    |  bad user 3  |