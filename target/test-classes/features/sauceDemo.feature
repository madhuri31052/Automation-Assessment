@tag
Feature: Check login
  I want to check the login functionality of Sauce Demo page

  @tag1
  Scenario Outline: login functionality
    Given I am on the login page of Sauce Demo
    When I enter <username> and <password>
    And Click on login button
    Then the page should be redirected to inventory page

  # @tag2
  # Scenario Outline: Title of your scenario outline
  #   Given I want to write a step with <name>
  #   When I check for the <value> in step
  #   Then I verify the <status> in step

    Examples: 
      |        username         |   password   | 
      | standard_user           | secret_sauce |
      | locked_out_user         | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | error_user              | secret_sauce |
      | visual_user             | secret_sauce |
