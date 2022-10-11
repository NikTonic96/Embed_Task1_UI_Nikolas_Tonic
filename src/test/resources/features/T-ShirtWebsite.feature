@E2E
Feature: Buying a T-Shirt on the website

  Scenario: end to end testing the functionality positive testing
    Given the user is on the web page
    And the user selects size "<L>"
    And the user adds the item into the cart
    When the user clicks the checkout button
    And the user sees the notification
    Then the user clicks the ok button


  Scenario: end to end with empty cart to check the alert message
    Given the user is on the web page
    And the user selects size "<L>"
    And the user click the open cart button
    When the user clicks the checkout button
    And the user sees the error message in the notification
    Then the user clicks the ok button


  Scenario: end to end test with adding quantity
    Given the user is on the web page
    And the user adds the item into the cart
    And the user increases the quantity by 1
    When the user clicks the checkout button
    And the user sees the notification
    Then the user clicks the ok button


