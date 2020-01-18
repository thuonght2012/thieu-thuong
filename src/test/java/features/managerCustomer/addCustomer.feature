
Feature: Add customer

  Background:
    Given Open website http://www.way2automation.com/angularjs-protractor/banking/#/manager/addCust

  Scenario Outline: Add customer successfully
    When  I type first name as <firstname>, last name as <lastname>, post code as <postcode>
    And I click submit
    Then I verify that system is already added customer as <fullname> successfully

    Examples:
      | firstname | lastname | postcode | fullname     |
      | ho        | thieu    | 55000    | ho thieu     |
      | hoang     | thuong   | 55000    | hoang thuong |

  Scenario Outline: Add Customer unsuccessfully
    When I type first name as <firstname>, last name as <lastname>, post code as <postcode>
    And I click submit
    Then I verify that system is already added customer as <fullname> unsuccessfully
    Examples:
      | firstname | lastname | postcode | fullname |
      | hoang     |          | 55000    | hoang    |
      |           | thuong   | 55000    | thuong   |
