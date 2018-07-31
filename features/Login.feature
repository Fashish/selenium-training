Feature: Test the login functionality on SDET Univerity

  #Scenario: The user should be able to login with correct username and correct password
  #Given user is on the login page
  #When user enters correct username and correct password
  #Then user gets confirmation
  Scenario Outline: User should be able to login
    Given user is on the login page
    When user enters email <username>
    And user enters password <password>
    And user clicks submit
    Then user gets confirmation

    Examples: 
      | username          | password |
      | tim@testemail.com | pass     |
      | jv@testemail.com  | pass     |
      | rw@testemail.com  | pass     |
