#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Module_Sign in or Create Account-Alerady exising customer
  
@tag1
Scenario: Sign in or Create Account_TC18_Correct Password 
  Given User is on the Amazon sign-in page by clicking on the URL
  When User enters the valid email
  And clicks the continue button
  And enters the valid password
  And clicks the sign-in button
  And enters security question
  Then User should be redirected to the Amazon homepage

@tag2
Scenario: Sign in or Create Account_TC15_invalid email-id 
  Given User is on the Amazon sign-in page by clicking on the URL
  When User enters an invalid email
  And clicks the invalid email continue button
  Then The email ID field should display an error message and not accept the invalid value

@tag3
Scenario: Sign in or Create Account_TC19_InCorrect Password
  Given User is on the Amazon sign-in page by clicking on the URL
  When User enters the valid email
  And clicks the continue button
  And enters the invalid password
  And clicks the sign-in button
  Then User should be presented password error
  