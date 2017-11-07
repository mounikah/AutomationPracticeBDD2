@Regression1
Feature:User can refer an item to friend in automation practice website
As a user
I want to see send to a friend option
so that I can refer an item to friend
#Happy path scenario
@ValidDetails
Scenario:User can able to select an item and refer to friend

Given User is on the home page
When User mouse hover to Faded Short Sleeve T-shirts item
And click on more button
Then User should see the more page of that selected item
When click on send to a friend
Then user should see send to a friend page
When enter name as "Archana" and email as "archana123@gmail.com" and click on send button
Then user should see email sent confirmation message

#Unhappy path scenario
@InvalidDetails
Scenario:User should see the error message when invalid details entered

Given User is on the home page
When User mouse hover to Faded Short Sleeve T-shirts item
And click on more button
Then User should see the more page of that selected item
When click on send to a friend
Then user should see send to a friend page
When enter name and email as blank and click on send button
Then user should see error message


