Feature: Customer login
  In order to user can log in, I want to see my profile so I can log in easily

  Background:
    Given Open website https://www.way2automation.com/angularjs-protractor/banking/#/login

  Scenario Outline: User can login website
    When I click on Login Customer button to login
    And I choose account of user as <name>
    And I click button Login
    Then Verify information of user logged correctly with account as <name>

    Examples:
      | name        |
      | Harry Potter|