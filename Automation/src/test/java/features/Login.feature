Feature: Application Login
//Feature is the Bussiness requirement

//A feature file can have multiple scenarios to satisfy the feature

//Given -> prerequsites

//When -> user action

//Then -> expected results

//And ->  positive additional functionality checking

//But -> negative additional functionality checking 

//Natural plugin is required

Scenario: Home page default login
Given User is on net banking landing page
When  User login into application with "jin" and passoword "1234"
Then Home page is populated
And Cards displayed are "true"

Scenario: Home page default login
Given User is on net banking landing page
When  User login into application with "katie" and passoword "123"
Then Home page is populated
And Cards displayed are "false"