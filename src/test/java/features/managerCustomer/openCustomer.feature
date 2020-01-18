Feature: Open Account

  Background:
    Given Open website http://www.way2automation.com/angularjs-protractor/banking/#/manager/openAccount

  Scenario Outline:  Open Account successfully
    When I choose account as <fullname> and currency as <currency>
    And I click process button
    Then I verify that user is already opened with first name as <firstname> and last name as <lastname>

    Examples:
      | fullname         | currency | firstname | lastname   |
      | Albus Dumbledore | Pound    | Albus     | Dumbledore |