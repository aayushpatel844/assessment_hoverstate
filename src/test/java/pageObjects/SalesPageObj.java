package pageObjects;

import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;

public class SalesPageObj extends UIInteractionSteps {

    By title = By.xpath("//div[text()='Sale Successful!']");
    By checkbox=By.id("c3e3ed54");
    By redeem = By.xpath("//button[text()='Redeem']");
    By noSell_link = By.xpath("//a[text()='No, sell contract without redemption']");

}
