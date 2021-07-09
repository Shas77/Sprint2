Feature: Search feature

  Background: Common search steps
    Given user is in the home page of Asian Paints
    When the user clicks on search

  Scenario Outline: Searching the products
    And user enters the search item as "<product>"
    Then user clicks the search button
    Then user selects the product
    And the products are displayed

    Examples: 
      | product    |
      | Canvas     |
      | Water lily |

  Scenario: Invalid search
    And user enters the search as "xyz"
    Then user clicks the search button
    And the invalid search message is displayed
