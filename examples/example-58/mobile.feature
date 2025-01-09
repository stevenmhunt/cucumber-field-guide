Feature: Mobile App Test

@mobile
Scenario: the user can see the shopping cart
    Given the app is opened
    When the "cart badge" is clicked
    Then the "cart screen" should be displayed