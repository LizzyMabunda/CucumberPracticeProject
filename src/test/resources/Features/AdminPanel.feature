@AdminPanel
Feature: Admin panel tests

  Background:
    Given I am on the login page
    When I login as admin

  Scenario: Admin approve pending user
    Given I am logged in as an admin
    When I navigate to the pending users section
    And I approve a pending user
    Then the successful pop-up message should be displayed