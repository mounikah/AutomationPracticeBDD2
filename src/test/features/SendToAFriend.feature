@Regression1
Feature:User can refer an item to friend in automation practice website
As a user
I want to see send to a friend option
so that I can refer an item to friend
#Happy path scenario
@ValidDetails
Scenario Outline:User can able to select an item and refer to friend

Given User is on the home page
When User mouse hover to Faded Short Sleeve T-shirts item
And click on more button
Then User should see the more page of that selected item
When click on send to a friend
Then user should see send to a friend page
  When enter name as "<name>" and email as "<email>" and click on send button
Then user should see email sent confirmation message
  Examples:
    | name     | email                |
    | Archana  | archana123@gmail.com |
    | prathima | prathi.1@gmail.com   |


#Unhappy path scenario
@InvalidDetails
Scenario Outline:User should see the error message when invalid details entered

Given User is on the home page
When User mouse hover to Faded Short Sleeve T-shirts item
And click on more button
Then User should see the more page of that selected item
When click on send to a friend
Then user should see send to a friend page
  When enter name as "<name>" and email as "<email>" and click on send button
Then user should see error message
  Examples:
    | name | email |
    |      |       |
    |      | asd   |
    | ana  |       |


