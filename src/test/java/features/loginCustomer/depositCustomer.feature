Feature: Deposit
  In order to user can log in, I want to see my profile so I can log in easily

  Background:
    Given Open website https://www.way2automation.com/angularjs-protractor/banking/#/login

  Scenario Outline: User can deposit
    When I login successfully with account as <name>
    And I click on Deposit button
    And I type amount to be Deposited as <amount>
    And I click on the Deposit button to submit deposit
    Then I verify user deposit successfully with amount as <amount>

    Examples:
      | name         | amount |
      | Harry Potter | 2000   |