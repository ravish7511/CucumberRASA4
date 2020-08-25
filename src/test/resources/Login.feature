Feature: Login functionality

@it
Scenario: To verify login functionality with valid Credentials

Given  user is on Login Page
When  user enters valid username "admin" and password "manager"
And  clicks on Login button



@ft
Scenario Outline: To test login functionality with multiple data sets

Given user is on Login Page
When user enters valid username "<UserName>" and password "<PassWord>"
And  clicks on Login button
Then  Message should be displayed as login successfull "<Expected_Result>"

Examples:
|UserName |PassWord | Expected_Result |
|admin    | manager |actiTIME - Enter Time-Track|
|admin1   | manager1|actiTIME - Login|
|admin    | manager1|actiTIME - Login |
|admin1   | manager |actiTIME - Login |

@smoke
Scenario: to verify order is placed
Given select payment "mode" type
Then order is placed successfully

|mode       |discount| cashback |
|credit card| 10% |   1000|
|debit card|   5% |   500 |
|cod       | no discount| no cashback |






