@SignUp
Feature: Create new user

  Scenario: Create new user using valid detail
    Given I am on the login page
    When I click on sign up here link
    Then I should be redirected to the create your account form
    And I generate random user data
    And I enter first name
    And I enter Last name
    And I enter valid email address
    And I enter password {Testing@31}
    And I enter confirm password {Testing@31}
    And Select Your group
    And I click the Create account button
    Then I should get a success registration message pop-up
