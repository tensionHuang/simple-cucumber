Feature: Say Hello to Cucumber

  Scenario Outline: Say hello and make sure cucumber executing correctly.
    Given I got a greeting object called Hello
    When I call greeting method, and give <user> name
    Then print <user> hello!

    Examples:
    | user    |
    | rickey  |
