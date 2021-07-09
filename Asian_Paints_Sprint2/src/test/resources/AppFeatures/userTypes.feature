Feature: Types of users

  Scenario Outline: Selecting user types
    Given the user is in the home page of Asian Paints
    And user clicks the dropdown in the header
    And user selects the type as "<user>"
    Then user is navigated to that page

    Examples: 
      | user       |
      | ARCHITECTS |
      | KITCHENS   |
      | INDUSTRIAL |
