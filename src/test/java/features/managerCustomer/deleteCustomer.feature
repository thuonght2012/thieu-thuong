Feature: Delete customer
  Background:
    Given Open website https://www.way2automation.com/angularjs-protractor/banking/#/manager/list

  Scenario Outline: Delete customer successfully
    When I click delete button with first name as <firstName>, last name as <lastName>, post code as <postCode> and account number as <accountNumber>
    Then I verify customer delete successfully with first name as <firstName>, last name as <lastName>, post code as <postCode> and account number as <accountNumber>

    Examples:
      | firstName | lastName | postCode | accountNumber |
      | Harry     | Potter   | E725JB   | 1004          |

  Scenario Outline: Delete customer unsuccessfully
    When I click delete button with first name as <firstName>, last name as <lastName>, post code as <postCode> and account number as <accountNumber>
    Then I verify customer delete unsuccessfully with first name as <firstName>, last name as <lastName>, post code as <postCode> and account number as <accountNumber>

    Examples:
      | firstName | lastName | postCode | accountNumber |
      | Thuong     | Potter   | E725JB   | 1004          |