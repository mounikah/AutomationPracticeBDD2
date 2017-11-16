package automationPractice;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import java.util.concurrent.TimeUnit;

public class StepDefinitions {
    public static WebDriver driver;
    public static String baseURL="http://automationpractice.com/index.php ";
    public static String expectedConfirmationMsg="Your e-mail has been sent successfully";
    @Before
      public static void startBrowser(){

        System.setProperty("webdriver.chrome.driver", "src/main/resources/Newchromedriver.exe");
        driver=new ChromeDriver();
        driver.navigate().to(baseURL);
        driver.manage().window().maximize();
    }
    @After
    public static void closeBrowser(){
          driver.close();
    }
    //***************************  Happy path scenario for send to a friend feature **********************
    @Given("^User is on the home page$")
    public void verifyIsUserOnTheHomePage(){
        Assert.assertTrue(driver.getTitle().equalsIgnoreCase("My Store"));
    }
    @When("^User mouse hover to Faded Short Sleeve T-shirts item$")
    public void mouseHoverToFadedTShirtItem()  {
        Actions action=new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath( "//*[@id='homefeatured']/li[1]/div/div[1]/div/a[1]/img"))).perform();
    }
    @And("^click on more button$")
    public void clickMoreButton()  {
        driver.findElement(By.xpath("//*[@id='homefeatured']/li[1]/div/div[2]/div[2]/a[2]/span")).click();
    }
    @Then("^User should see the more page of that selected item$")
    public void isUserOnTheMorePageOfTheSelectedItem()  {
        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()=\"Faded Short Sleeve T-shirts\"]")).isDisplayed());
    }
    @When("^click on send to a friend$")
    public void clickOnSendToFriend()  {
        driver.findElement(By.cssSelector("#send_friend_button")).click();
    }
    @Then("^user should see send to a friend page$")
    public void isUserOnSendToFriendPage() {
       WebElement sendToFriendHeader=driver.findElement(By.cssSelector("#send_friend_form"));
       Utils.waitForElementVisible(sendToFriendHeader,3000);
        Assert.assertTrue(driver.findElement(By.cssSelector("#send_friend_form")).isDisplayed());
    }
    @When("^enter name as \"([^\"]*)\" and email as \"([^\"]*)\" and click on send button$")
    public void enterNameEmailAndClickSendButton(String name, String email)
    {
        driver.findElement(By.cssSelector("input[id='friend_name']")).sendKeys(name);
        driver.findElement(By.cssSelector("input[name='friend_email']")).sendKeys(email);
        driver.findElement(By.cssSelector("#sendEmail")).click();
    }
    @Then("^user should see email sent confirmation message$")
    public void isConfirmationMessageDisplayed()  {
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
       String actual_Msg=driver.findElement(By.xpath("//body[@id='product']/div[2]/div/div/div/p[1]")).getText();
        Assert.assertEquals(actual_Msg,expectedConfirmationMsg);
    }
    //******************** Unhappy path scenario for refer to friend feature ****************************
   /* @When("^enter name as \"([^\"]*)\" and email as \"([^\"]*)\" and click on send button$")
    public void setNameAndEmail(String name,String email)  {
        driver.findElement(By.cssSelector("input[id='friend_name']")).sendKeys(name);
        driver.findElement(By.cssSelector("input[name='friend_email']")).sendKeys(email);
        driver.findElement(By.cssSelector("#sendEmail")).click();
    }*/
    @Then("^user should see error message$")
    public void verifyErrorMsgDisplayed()  {
        Assert.assertTrue(driver.findElement(By.cssSelector("#send_friend_form_error")).isDisplayed());

    }
      //*********************** Navigate to Tops page from home page feature *****************************

    @When("^user click on women link$")
    public void user_click_on_women_link()  {
     driver.findElement(By.xpath("//a[text()='Women']")).click();

    }
    @Then("^user should see the womens page$")
    public void isUserOnWomensPage(){
        Assert.assertEquals(driver.getTitle(),"Women - My Store");
    }
    @When("^click on tops link$")
    public void clickOnTopsLink()  {
        driver.findElement(By.xpath("//*[@id='subcategories']/ul/li[1]/h5/a")).click();

    }
    @Then("^user should be on the tops page successfully$")
    public void isUserOnTopsPage() {
        Assert.assertEquals(driver.getTitle(),"Tops - My Store");

    }
    // ********************************** Checkout Feature ***********************************************
       //********************************* Payment By Bank wire scenario *******************************
    @When("^select add to cart button$")
    public void setAddToCart(){
        driver.findElement(By.xpath("//*[@id='homefeatured']/li[1]/div/div[2]/div[2]/a[1]/span")).click();
    }
   @Then("^item should be added to cart$")
    public void isUserOnAddToCartPage()  {
        WebElement addToCartPageHeader=driver.findElement(By.xpath("//div[@id='layer_cart']/div[1]/div[1]/h2"));
        Utils.waitForElementVisible(addToCartPageHeader,3000);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='layer_cart']/div[1]/div[1]/h2")).isDisplayed());
    }
    @When("^User proceed to checkout button on checkout page$")
    public void setProceedToCheckoutOnCheckoutPage()  {
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.findElement(By.xpath("//div[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")).click();
    }
    @Then("^User should see the summary page$")
    public void isUserOnTheSummaryPage()  {
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='cart_title']")).isDisplayed());
    }
    @When("^User proceed to checkout button on summary page$")
    public void setProceedToCheckoutOnSummaryPage()  {
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.findElement(By.linkText("Proceed to checkout")).click();
    }
    @Then("^User should see the Authentication page$")
    public void isUserOnTheAuthenticationPage()  {
        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()=\"Authentication\"]")).isDisplayed());
    }
    @When("^User enter email  as \"([^\"]*)\" password as \"([^\"]*)\" and select Signin button$")
    public void setEmailPasswordAndSubmit(String email, String password)  {
        driver.findElement(By.cssSelector("#email")).sendKeys(email);
        driver.findElement(By.cssSelector("#passwd")).sendKeys(password);
        driver.findElement(By.cssSelector("#SubmitLogin")).click();
    }
    @Then("^User should see the address page$")
    public void isUserOnTheAddressOnThePage() {
        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()=\"Addresses\"]")).isDisplayed());
    }
    @When("^User select proceed to checkout button on Address page$")
    public void setProceedToCheckoutOnAddressPage()  {
        WebElement proceedToCheckOutOnAddressPage=driver.findElement(By.xpath("//div[@id='center_column']/form/p/button"));
        Utils.waitForElementVisible(proceedToCheckOutOnAddressPage,3000);
        driver.findElement(By.xpath("//div[@id='center_column']/form/p/button")).click();
    }
    @Then("^user should see the shipping page$")
    public void isUserOnTheShippingPage()  {
        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()=\"Shipping\"]")).isDisplayed());
    }
    @When("^selects terms of service checkbox$")
    public void setTermsOfServiceCheckbox()  {
        driver.findElement(By.cssSelector("#cgv")).click();
    }
    @When("^select proceed to checkout button on shipping page$")
    public void setProceedToCheckoutButtonOnShippingPage()  {
        WebElement proceedToCheckoutOnShippingPage=driver.findElement(By.xpath("//form[@id='form']/p/button"));
        Utils.waitForElementVisible(proceedToCheckoutOnShippingPage,3000);
        driver.findElement(By.xpath("//form[@id='form']/p/button")).click();

    }
    @Then("^user should see the payment page$")
    public void isUserOnThePaymentPage()  {
        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()=\"Please choose your payment method\"]")).isDisplayed());
    }
    @When("^User selects pay by bank wire option$")
    public void setPayByBankWireOption()  {
        driver.findElement(By.xpath("//div[@id='HOOK_PAYMENT']/div[1]/div/p/a")).click();
    }
    @Then("^user should see bank wire payment page$")
    public void isUserOnTheBankWirePaymentPage()  {
       Assert.assertTrue(driver.findElement(By.xpath("//div[@id='center_column']/form/div/h3")).isDisplayed());
    }
    @When("^user selects I confirm my order button$")
    public void setConfirmOrder()  {
      driver.findElement(By.xpath("//p[@id='cart_navigation']/button")) .click();
    }
    @Then("^user should see order confirmation message successfully$")
    public void verifyUserShouldSeeOrderConfirmationMessage()  {
        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()=\"Order confirmation\"]")).isDisplayed());
    }
       //*********************** Payment by check scenario ***************************************

    @When("^User selects pay by check option$")
    public void setPayByCheckOption()  {
        driver.findElement(By.xpath("//div[@id='HOOK_PAYMENT']/div[2]/div/p/a")).click();
    }
    @Then("^user should see check payment page$")
    public void isUserOnPaymentByCheckPage()  {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='center_column']/form/div/h3")).isDisplayed());
    }
    //********************* Update Address feature **************************************************
    @When("^User selects My Addresses link$")
    public void setMyAddressLinkOnHomePage()  {
    driver.findElement(By.linkText("My addresses")).click();
    }
    @Then("^User should see his name as \"([^\"]*)\"$")
    public void isUserLoggedIn(String name) {
        Assert.assertEquals(driver.findElement(By.cssSelector("a.account")).getText(),name);
    }
    @When("^User selects My Addresses link on My Account page$")
    public void setMyAddressLinkOnMyAccountPage()  {
        driver.findElement(By.cssSelector("i.icon-building")).click();

    }
    @Then("^User Should see My Addresses page$")
    public void isUserOnMyAddressesPage()  {
        Assert.assertEquals(driver.findElement(By.cssSelector(".page-heading")).getText(),"MY ADDRESSES");

    }
    @When("^User selects update button$")
    public void setUpdateButton()  {
        driver.findElement(By.xpath("//div[@id='center_column']/div[1]/div/div/ul/li[9]/a[1]/span")).click();

    }
    @Then("^User should see Your Addresses$")
    public void isUserOnYourAddressesPage()  {
        Assert.assertEquals(driver.findElement(By.cssSelector(".page-subheading")).getText(),"YOUR ADDRESSES");
    }

    @When("^update address as \"([^\"]*)\"$")
    public void setUpdateAddress(String address)  {
        driver.findElement(By.xpath("//input[@id='address1']")).clear();
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(address);

    }
    @And("^User selects save button$")
    public void setSaveButton()  {
        driver.findElement(By.cssSelector("#submitAddress")).click();

    }
    @Then("^User should see updated address as \"([^\"]*)\"$")
    public void verifyUpdatedAddress(String showUpdatedAddress) {
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='center_column']/div[1]/div/div/ul/li[4]")).getText(),showUpdatedAddress);

    }
    //**********************************************SignIn Feature *************************
    @When("^User selects SignIn link$")
    public void setsigninlink()  {
        driver.findElement(By.cssSelector(".login")).click();

    }

    @Then("^User should see the Login Page$")
    public void isUserOnTheloginpage() {
        Assert.assertEquals("Login - My Store",driver.getTitle());

    }

    @Then("^User should see the feedback \"([^\"]*)\"$")
    public void user_should_see_the_feedback_something(String message)  {
        Assert.assertEquals(message,driver.findElement(By.cssSelector("div.alert.alert-danger ol li")).getText());

    }
}




































