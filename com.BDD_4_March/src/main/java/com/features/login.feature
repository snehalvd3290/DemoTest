Feature: JBK offline application

Scenario: login test

Given user should be on login page
When user enters valid credentials
Then user should be on home page
