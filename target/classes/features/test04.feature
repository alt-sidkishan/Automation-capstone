Feature: Validate Menus and Count links

Scenario Outline: Validate Menus
	Given I am on login page
	When I enter "<username>" and "<password>" and logged in
	Then I count number of menu links
	And I click on each link one by one
	And I click on logout
	
	Examples:
	|username|password|
	|whistler.dummyemail@gmail.com|Sid@123|