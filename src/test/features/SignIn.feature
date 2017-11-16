@Smoke3
Feature:User can SignIn successfully in Automation Practice Website
  As a User
  I want to see the SignIn page
  So that I can SignIn successfully

  Background:
    Given User is on the home page
    When User selects SignIn link
    Then User should see the Login Page
#Happy Path
  Scenario:User can able to login with valid credentials
    When User enter email  as "qamasters@mailinator.com" password as "Password1" and select Signin button
    Then User should see his name as "QA Masters"


#Unhappy Path

  Scenario Outline:User unable to login with invalid credentials
    When User enter email  as "<Username>" password as "<Password>" and select Signin button
    Then User should see the feedback "<Message>"

    Examples:

      | Username                 | Password  | Message                    |
      |                          | Password1 | An email address required. |
      | qamasters@mailinator.com | asde      | Invalid password.          |
      | qamasters@mailinator     | Password1 | Invalid email address.     |
      | qamasters@mailinator.com |           | Password is required.      |