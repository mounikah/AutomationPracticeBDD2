@Regression2
Feature:Updating an address in automation practice site
As a user
I want to see update an address option
so that I can update my address

  Scenario Outline:verify user can update address from my addresses link
Given User is on the home page
When User selects My Addresses link
Then User should see the Authentication page
When User enter email  as "qamasters@mailinator.com" password as "Password1" and select Signin button
Then User should see his name as "QA Masters"
When User selects My Addresses link on My Account page
Then User Should see My Addresses page
When User selects update button
Then User should see Your Addresses
    When update address as "<updatedAddress>"
And User selects save button
    Then User should see updated address as "<showUpdatedAddress>"
    Examples:
      | updatedAddress                   | showUpdatedAddress                           |
      | 109 Observatory Street Ann Arbor | 109 Observatory Street Ann Arbor Test Street |
      | 115 Observatory Street Ann Arbor | 115 Observatory Street Ann Arbor Test Street |