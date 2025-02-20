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
Feature: Module_Your Account
  I want to use this template for my feature file

  @tag1
  Scenario: Your Account_TC_23_Sub list Options
  Given MyAccount_User is on the Amazon sign-in page by clicking on the URL
  When MyAccount_User enters the valid email
  And MyAccount_clicks the continue button
  And MyAccount_enters the valid password
  And MyAccount_clicks the sign-in button
  And MyAccount_enters security question
  And MyAccount_mousehover to Account and list
  Then Click on YourAccount

  