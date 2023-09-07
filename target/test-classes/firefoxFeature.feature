@smoke
Feature: Login Test
      
  Scenario: Login Test
  	Given set driver "<headless>"
    And click on login button
    And type email
    And type password
    And click on submit button
    And click on My Addresses
    And click on Add a new address
    And type address "<Address>"
    And type City
    And select State from dropdown
    And scroll down
    And type Zip Code
    And type Home Phone
    And type Address Name
    And Click On Save button
    Then verify message
 		Examples:
			|Address|headless|
			|adress1|false|