Feature: User Login

    Scenario Outline: User Login - Successful
        Given I am on "<url>"
        When I navigate to the login page
        And I provide valid "<username>" and "<password>"
        And I complete the login process
        Then I should be logged in successfully as "<username>"

    Examples:
    |                  url                      |   username    |   password    |
    |   https://www.demoblaze.com/index.html    |   username    |   password    |
    |   https://www.demoblaze.com/index.html    |   12345678    |   12345678    |