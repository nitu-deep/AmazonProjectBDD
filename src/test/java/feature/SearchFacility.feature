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
Feature: Module_Search Facility
  I want to use this template for my feature file

  @tag1
  Scenario: Search_TC62_Products per page
    Given Search_User is on the Amazon sign-in page by clicking on the URL
	  When Search_User enters the valid email
	  And Search_User clicks the continue button
	  And Search_User enters the valid password
	  And Search_User clicks the sign-in button
	  And Search_User enters security question
  	And Search_User Enter the data in Search Textbox
    And Search_User Click search button
		Then Display list of items

  