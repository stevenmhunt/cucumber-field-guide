Feature: Customers can perform actions in the online store.

  Rule: Jim Logs In

    Background:
      Given the user "Jim" logs in
      And the user navigates to the "home" page

    Scenario: Customers can add an item to the cart
      When the user adds an item to their shopping cart
      Then an item should appear in the user's shopping cart

    Scenario: Customers can search for an item
      When the user searches for item "item 1"
      Then item "item 1" should appear in search results