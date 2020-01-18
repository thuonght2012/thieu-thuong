Feature: Customer Withdrawal Successfully

  Background:
    Given Open website https://www.way2automation.com/angularjs-protractor/banking/#/login

  Scenario Outline: Customer Withdrawal Successfully
    When I login successfully with the account as <name>
    And I deposited into my account <deposit>
    And I click on Withdrawal button
    And I type amount to be Withdrawal as <withdrawal>
    And I click on the Withdrawal button to submit withdrawal
    Then I verify user withdrawal successfully

    Examples:
      | name         | deposit | withdrawal |
      | Harry Potter | 3000    | 1000      |


  Scenario Outline: Customer Withdrawal Unsuccessfully
    When I login successfully with the account as <name>
    And I deposited into my account <deposit>
    And I click on Withdrawal button
    And I type amount to be Withdrawal as <withdrawal>
    And I click on the Withdrawal button to submit withdrawal
    Then I verify user withdrawal unsuccessfully

    Examples:
      | name         | deposit | withdrawal |
      | Harry Potter | 1000    | 3000      |