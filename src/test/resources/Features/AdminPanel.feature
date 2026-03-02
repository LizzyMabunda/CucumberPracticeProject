@AdminPanel
Feature: Admin panel tests

  Background:
    Given I am on the login page
    When I login as admin

  Scenario: Admin approve pending user
    When I navigate to Admin panel page
    And I navigate to the pending users section
    And I approve a pending user
    And the successful pop-up message should be displayed
    And I navigate back to main page
    Then I log-out

  Scenario: Make registered user an admin
    When I navigate to Admin panel page
    And I navigate to the user management section
    And I make the user an admin
    And the successful pop-up message should be displayed for role change
    And I navigate back to main page
    And I log-out

    When I Login as new admin
    When I navigate to Admin panel page



