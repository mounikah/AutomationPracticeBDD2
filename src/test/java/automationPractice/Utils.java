package automationPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static automationPractice.StepDefinitions.driver;

public class Utils  {
    public static  WebDriverWait wait;
    public static void waitForElementVisible(WebElement element, int time) {
        wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
