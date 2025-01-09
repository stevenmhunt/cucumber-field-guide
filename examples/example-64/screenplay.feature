Feature: Screenplay Scenarios

@screenplay
Scenario: the user can search with a query with screenplay
    Given the homepage is opened with screenplay
    When "something" is typed into the search box with screenplay
    And the "Search" button is pressed with screenplay
    Then the results should display "Results for: something" with screenplay