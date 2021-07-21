package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class baseUtil {

    public static void waitForElementVisible(WebDriver driver,By by ){
        WebDriverWait wait  = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementClickable(WebDriver driver, By by ){
        WebDriverWait wait  = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }


    public static void jsClick( WebDriver driver, By by) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();", driver.findElement(by));
    }

    public static void jsClick(WebDriver driver, WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();", element);
    }

    public static void scrollToElement(WebDriver driver, WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void jsSendKey(WebDriver driver, By by, String input){
        String arg= "arguments[0].value='"+ input+"'";
        ((JavascriptExecutor)driver).executeScript(arg, driver.findElement(by) );
    }

    public static void waitForElementPresence(WebDriver driver, By by){
        WebDriverWait wait  = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
