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
Feature: Module_Shopping Cart
  I want to use this template for my feature file

  @tag1
  Scenario: Shopping Cart_TC40_Item name
  Given Shopping_Cart_User is on the Amazon sign-in page by clicking on the URL
  When Shopping_Cart_User enters the valid email
  And Shopping_Cart_User click the continue button
  And Shopping_Cart_User enter the valid password
  And Shopping_Cart_User click the sign-in button
  And Shopping_Cart_User enter security question
  And Shopping_Cart_User click on Cart Icon
  Then Lands on Shopping Cart Page
