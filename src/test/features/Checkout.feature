@Smoke1
Feature:Add an item to cart and make an order with different payment options
        As a User
        I want to see checkout option
        So that I can make my order successfully

Scenario:User can able to add an item to cart and checkout with Pay by bank wire payment option
        Given User is on the home page

         When User mouse hover to Faded Short Sleeve T-shirts item
         And select add to cart button
         Then item should be added to cart


         When User proceed to checkout button on checkout page
         Then User should see the summary page

         When User proceed to checkout button on summary page
         Then User should see the Authentication page

         When User enter email  as "qamasters@mailinator.com" password as "Password1" and select Signin button
         Then User should see the address page

         When User select proceed to checkout button on Address page
         Then user should see the shipping page

         When selects terms of service checkbox
         And select proceed to checkout button on shipping page
         Then user should see the payment page

         When User selects pay by bank wire option
         Then user should see bank wire payment page

         When user selects I confirm my order button
         Then user should see order confirmation message successfully

Scenario:User can able to add an item to cart and checkout with Pay by check payment option
         Given User is on the home page

         When User mouse hover to Faded Short Sleeve T-shirts item
         And select add to cart button
         Then item should be added to cart

         When User proceed to checkout button on checkout page
         Then User should see the summary page

         When User proceed to checkout button on summary page
         Then User should see the Authentication page

         When User enter email  as "qamasters@mailinator.com" password as "Password1" and select Signin button
         Then User should see the address page

         When User select proceed to checkout button on Address page
         Then user should see the shipping page

         When selects terms of service checkbox
         And select proceed to checkout button on shipping page
         Then user should see the payment page

         When User selects pay by check option
         Then user should see check payment page

         When user selects I confirm my order button
         Then user should see order confirmation message successfully
