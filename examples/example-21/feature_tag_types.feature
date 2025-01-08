@feature-level-tag
Feature: You can place scenario tags in all scenarios within a feature.

  @rule-level-tag
  Rule: You can place scenario tags on all scenarios within a rule.
    Note that rules are optional.

    @scenario-level-tag
    Scenario: You can also place tags directly on a scenario
        # ...

@scenario-outline-level-tag
Scenario Outline: You can place tags on all examples of a scenario outline
    # ...

@scenario-outline-example-level-tag
Examples:
    | param  |
    | value1 |

@scenario-outline-example-level-tag
Examples:
    | param  |
    | value2 |