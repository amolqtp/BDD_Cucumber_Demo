Feature: This feature demostrate basic maths operations

  Scenario Outline: perform addition operation
    Given I have first <number1> and second <number2> number
    When I perform addition operation
    Then I should get correct <result> result

    Examples: 
      | number1 | number2 | result |
      | 10      | 20      | 30     |
      | 100     | 200     | 300    |
      | 20      | 30      | 50     |
      | 200     | 300     | 500    |
