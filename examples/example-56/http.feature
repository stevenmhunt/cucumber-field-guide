Feature: test feature

    @http-ignore-errors
    Scenario: scenario 1
    Given an HTTP "GET" call "/" is made
    Then the HTTP call should have returned an HTTP 401
