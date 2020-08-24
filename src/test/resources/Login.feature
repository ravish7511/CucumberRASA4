Feature: Login functionality

Scenario: To verify login functionality with valid Credentials

Given  user is on Login Page
When  user enters valid username and password
And  clicks on Login button
Then  Message should be displayed as login successfull