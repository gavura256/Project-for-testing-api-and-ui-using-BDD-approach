Feature: Create User


  Scenario: 1 - Creating user

    Given user has "createUserRQ" request with following parameters
      | username   | firstName | lastName | email         | password  | phone   | userStatus |
      | test321123 | test      | test     | mail@mail.com | 124c1eqwc | 1234567 | 0          |

    When user sends "POST" "createUserRQ" request

    And "createUserRS" code is "200"
    And user has "getUserByUserNameRQ" request with username from "createUserRS" response
    And user sends "GET" "getUserByUserNameRQ" request
    Then "getUserByUserNameRS" code is "200"
    And firstName contains expected 'test':
