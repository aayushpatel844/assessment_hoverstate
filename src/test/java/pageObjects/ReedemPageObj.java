package pageObjects;

import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;

public class ReedemPageObj extends UIInteractionSteps {

    By title = By.xpath("//div[text()='Service Redemption Successful!']");
    By total_sale = By.xpath("//div[@style='text-align: center;']/span[2]");
    By total_sale_txt = By.xpath("//div[@style='text-align: center;']/span[3]");
    By target = By.xpath("//span[contains(text(),'sales this month')]");
    By ok_button = By.xpath("//button[contains(text(),'OK')]");


}
