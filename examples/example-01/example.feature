@all-scenarios-will-have-this-tag
Feature: Customers can sign in to the online store.
    I can type whatever I want here, this is for humans.

@scenario-specific-tag @some @more @tags
Scenario: The user logs in and types in the chat box.
    Given the user navigates to the home page
    And the user "test user 1" logs in
    When the user types the following into the chat box:
    """
    This is a long string that may have more
    than one line of text in it...
    """
    Then the chat box should contain text
    And the following fields should be visible on the screen:
    |  name  | value |
    | field1 | val1  |
    | field2 | val2  |
    | field3 | val3  |

# you can write comments like this...

  @ruletag
  Rule: Scenarios can be organized into rules

    Scenario: A scenario within a rule
      Given the user navigates to the home page
      When the user "test user 1" logs in
      Then the user should be logged in


@another-tag
Scenario Outline: The user does not log in successfully
    Given the user navigates to the home page
    When the user "<invalid user>" logs in
    Then the user should not be logged in
Examples:
| invalid user |
|  bad user 1  |
|  bad user 2  |
|  bad user 3  |