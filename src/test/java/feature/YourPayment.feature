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
Feature: Module_Payment
  I want to use this template for my feature file

  @tag1
  Scenario: Payment_TC39_Default method
  Given YourPayment_User is on the Amazon sign-in page by clicking on the URL
  When YourPayment_User enters the valid email
  And YourPayment_clicks the continue button
  And YourPayment_enters the valid password
  And YourPayment_clicks the sign-in button
  And YourPayment_enters security question
  And YourPayment_mousehover to Account and list
  And YourPayment_Clcik on YourAccount
  And YourPayment_Click on YourPayments
  And YourPayment_Click on Add the payment method
  And YourPayment_Click on Add debit or credit card
  And YourPayment_Enter Credit Card number
  And YourPayment_Enter expiry date
  And YourPayment_Enter security Code
  And YourPayment_Name on the Card
  And YourPayment_Click on Add and Continue
  Then Select Card

  