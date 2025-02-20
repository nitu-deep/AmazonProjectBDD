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
Feature: Module_Your Address
  I want to use this template for my feature file

  @tag1
  Scenario: Your Address_TC37_Add address button
  Given YourAddress_User is on the Amazon sign-in page by clicking on the URL
  When YourAddress_User enters the valid email
  And YourAddress_clicks the continue button
  And YourAddress_enters the valid password
  And YourAddress_clicks the sign-in button
  And YourAddress_enters security question
  And YourAddress_mousehover to Account and list
  And YourAddress_Click on YourAccount
  And YourAddress_Click on YourAdress
  And YourAddress_Click on AddAddress
  And YourAddress_Enter FirstandLastName
  And YourAddress_Enter Phonenumber
  And YourAddress_Enter Address
  And YourAddress_Enter City
  And YourAddress_Enter Postal code
  And YourAddress_Enter Province
  And YourAddress_Click on Add Address button
  Then Show Address
  
  
  @tag2
  Scenario: Your Address_TC28_empty Full name
  Given YourAddress_User is on the Amazon sign-in page by clicking on the URL
  When YourAddress_User enters the valid email
  And YourAddress_clicks the continue button
  And YourAddress_enters the valid password
  And YourAddress_clicks the sign-in button
  And YourAddress_enters security question
  And YourAddress_mousehover to Account and list
  And YourAddress_Click on YourAccount
  And YourAddress_Click on YourAdress
  And YourAddress_Click on AddAddress
  And YourAddress_Enter Phonenumber
  And YourAddress_Enter Address
  And YourAddress_Enter City
  And YourAddress_Enter Postal code
  And YourAddress_Enter Province
  And YourAddress_Click on Add Address button
  Then Show FullName_Error
  