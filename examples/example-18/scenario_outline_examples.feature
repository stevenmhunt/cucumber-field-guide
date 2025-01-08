Feature: Scenario Outline Examples

    Scenario Outline: The user does not log in successfully
        Given the user navigates to the home page
        When the user "<invalid user>" logs in
        Then the user is not signed in

    @APP-STORY-001
    Examples:
    | invalid user |
    |  bad user 1  |

    @APP-STORY-002
    Examples:
    | invalid user |
    |  bad user 2  |

    @APP-STORY-003
    Examples:
    | invalid user |
    |  bad user 3  |