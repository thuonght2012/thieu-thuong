Feature: Customer transactions
  In order to user can log in, I want to see my profile so I can log in easily

  Background:
    Given Open website https://www.way2automation.com/angularjs-protractor/banking/#/login

  Scenario Outline: User can see transactions table
    When I can login successfully with the account as <name>
    And I deposited into account <deposit>
    And I deposited extra into account <deposit>
    And I withdrawal into account <withdrawal>
    And I click on Transactions button
    Then I verify table is appeared and show deposit success as <deposit>
    When I click button Reset to delete all transactions
    Then I verify reset table successfully
    And I click button Back to back Account page
    And I verify balance amount and reset successfully

    Examples:
      | name         | deposit | withdrawal |
      | Harry Potter | 3000    | 2000       |