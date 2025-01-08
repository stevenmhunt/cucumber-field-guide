# language: en
# the language comment at the top is used to set the language (default is "en")

@feature-tag
Feature: This is where you describe a feature of the application being tested.
    I can type whatever I want here, this is for humans.

# use a Background to run these steps before any scenario in the feature file.
Background:
    Given the user navigates to the home page

@scenario-tag
Scenario: The user logs in and types in the chat box.
    Scenarios (or Examples) represent an individual test case.

    # steps can accept inline parameters:    
    When the user "test user 1" logs in

    # steps can accept docstring parameters:
    And the user types the following into the chat box:
    """
    This is a long string that may have more
    than one line of text in it...
    """

    # steps can accept data table parameters:
    Then the chat box should contain text
    And the following fields should be visible on the screen:
    |  name  | value |
    | field1 | val1  |
    | field2 | val2  |

  @rule-tag
  Rule: Scenarios can be organized into rules
    This allows more organization within a feature file.
    
    Background:
      When the user "test user 1" logs in

    Scenario: A scenario within a rule
      Then the user should be logged in

@scenario-outline-tag
Scenario Outline: The user does not log in successfully
    A scenario outline is a repeatable scenario with parameters.
    It can accept multiple examples via the Examples statement(s) below.

    When the user "<invalid user>" logs in
    Then the user should not be logged in

Examples:
| invalid user |
|  bad user 1  |

@scenario-example-tag
Examples:
| invalid user |
|  bad user 2  |