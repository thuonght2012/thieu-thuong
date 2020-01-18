Feature: Search customer

  Background:
    Given Open website https://www.way2automation.com/angularjs-protractor/banking/#/manager

  Scenario Outline: Search customer successfully
    When I click customer tab
    And I type value as <keySearch> on search box
    Then I verify search success with keyword as <keySearch>

    Examples:
      | keySearch |
      | v         |
      | t        |

