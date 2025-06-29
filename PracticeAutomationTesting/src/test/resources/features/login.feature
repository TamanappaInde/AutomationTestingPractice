
@Login
Feature: Login Functionality
  
  @Validlogin
  Scenario: Verify Login functionality with valid credentials
    Given User launches the application and is on the login page
    And User enters valid "Username" and "Password"
    When User clicks on the login button
    Then User should see the my profile page
  @Invalidlogin
  Scenario Outline: Verify login functionality with invalid credentials 
    Given User launches the application and is on the login page
    And User enters invalid email "<email>" and password "<password>"
    When User clicks on the login button
    Then User should see error message "<expectedError>"
  Examples:
  |email|password|expectedError|
  |indetama@gmail.com|Inde4221|Error: A user could not be found with this email address.|
  |tamanappa@gmail.com|Inde45621|Error: A user could not be found with this email address.|
  |indesuraj@gmail.com|         |Error: Password is required.|
  |              |Inde@4221|Error: Username is required.|
    