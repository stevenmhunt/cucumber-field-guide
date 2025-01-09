Feature: Browser Scenarios

@webdriver
Scenario: the user can search with a query with webdriver
    Given the homepage is opened with webdriver
    When "something" is typed into the search box with webdriver
    And the "Search" button is pressed with webdriver
    Then the results should display "Results for: something" with webdriver