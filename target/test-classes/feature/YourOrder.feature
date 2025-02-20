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
Feature: Module_Your order
  I want to use this template for my feature file
  
  @tag1
  Scenario: Your order_TC_24_Different options 
  Given Yourorder_User is on the Amazon sign-in page by clicking on the URL
  When Yourorder_User enters the valid email
  And Yourorder_clicks the continue button
  And Yourorder_enters the valid password
  And Yourorder_clicks the sign-in button
  And Yourorder_enters security question
  And Yourorder_mousehover to Account and list
  And Yourorder_Click on Your Account
  And Yourorder_Clck on Your order
  Then Shows different options
  
  @tag2
  Scenario: Your order_TC55_Options
  Given Yourorder_User is on the Amazon sign-in page by clicking on the URL
  When Yourorder_User enters the valid email
  And Yourorder_clicks the continue button
  And Yourorder_enters the valid password
  And Yourorder_clicks the sign-in button
  And Yourorder_enters security question
  And Yourorder_mousehover to Account and list
  And Yourorder_Click on Your Account
  And Yourorder_Clck on Your order
  And Yourorder_Cllick on Buyagain
  Then Shows Buy again options
  
  @tag3
  Scenario: Your order_TC57_Not yet shipped
  Given Yourorder_User is on the Amazon sign-in page by clicking on the URL
  When Yourorder_User enters the valid email
  And Yourorder_clicks the continue button
  And Yourorder_enters the valid password
  And Yourorder_clicks the sign-in button
  And Yourorder_enters security question
  And Yourorder_mousehover to Account and list
  And Yourorder_Click on Your Account
  And Yourorder_Clck on Your order
  And Yourorder_Cllick on NotyetShipped
  Then Shows different options
  
  @tag4
  Scenario: Your order_TC58_Cancelled Order
  Given Yourorder_User is on the Amazon sign-in page by clicking on the URL
  When Yourorder_User enters the valid email
  And Yourorder_clicks the continue button
  And Yourorder_enters the valid password
  And Yourorder_clicks the sign-in button
  And Yourorder_enters security question
  And Yourorder_mousehover to Account and list
  And Yourorder_Click on Your Account
  And Yourorder_Clck on Your order
  And Yourorder_Cancelled orders
  Then Shows different options

  
