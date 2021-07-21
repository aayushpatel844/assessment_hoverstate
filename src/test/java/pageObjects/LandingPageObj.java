package pageObjects;

import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;

public class LandingPageObj extends UIInteractionSteps {

    By title = By.xpath("//div[text()='Service Lane']");
    By sell_contract= By.xpath("//span[contains(text(),'Sell Contract')]");

    // search options
    By radio_vin = By.xpath("//input[@value='VINnumber']");
    By radio_name = By.xpath("//input[@value='Name']");
    By radio_phone = By.xpath("//input[@value='Phone']");
    By radio_email = By.xpath("//input[@value='Email']");
    By radio_contract = By.xpath("//input[@value='Contract']");
    By searchInput = By.xpath("//input[contains(@name,'SearchContract')]");
    By search = By.xpath("//button[text()='Search']");


    // listed product
    By product_list = By.xpath("//div[contains(@class,'product_title_dataLabelWrite')]");
    By product_AC_Delco= By.xpath("//td[@headers='a5']/child::div[span='AC Delco']");
    By contract_vin = By.xpath("//td[@headers='a2']/child::div");
    By contract_name = By.xpath("//td[@headers='a3']/child::div");
    By contract_status = By.xpath("//td[@headers='a4']/child::div");
    By contract_products = By.xpath("//td[@headers='a5']/child::div");
    By contract_number = By.xpath("//td[@headers='a6']/child::div");
    By contract_expiry = By.xpath("//td[@headers='a7']/child::div");

    // contract details
    By contract_text= By.xpath("//span[contains(text(),'Contracts Found')]");
    By contract_details_title=By.xpath("//div[text()='Contract Details']");
    By service_desc = By.xpath("//td[contains(@data-attribute-name,'Service Description')]");
    String before_path = "//tr[@pl_index='";
    String after_redeem_Path = "']//td[contains(@data-attribute-name,'Redeem')]";
    String after_available_Path = "']//td[contains(@data-attribute-name,'Available')]";
    String after_service_Path = "']//td[contains(@data-attribute-name,'Service Description')]";

    //redeem
    String after_service_redeemed="']//td[contains(@data-attribute-name,'Service Redeemed')]";
    String after_service_RO="']//td[contains(@data-attribute-name,'RO Number')]";
    String after_service_checkbox_path = "']//td[contains(@data-attribute-name,'Select')]";
    By service_redeemed = By.xpath("//td[contains(@data-attribute-name,'Service Redeemed')]/child::div/span");
    By service_ro = By.xpath("//td[contains(@data-attribute-name,'RO Number')]/child::div/span");
    By sucessTxt = By.cssSelector(".standard_medium_text");
    By input_RO_prepaidSevice = By.id("c1afef4b");
    String service_checkbox = "]//input[@type='checkbox']";
    By deleteItem = By.cssSelector(".gridCell:nth-child(8) img");
    By deleteBtn= By.cssSelector(".field-item .Secondary_Blue_Button");

    // new product
    By service_date=By.id("f7b6593d");
    By input_RO_seeAll = By.id("8b0b202f");
    By seeAll = By.cssSelector(".Secondary_Blue_Button");

    // new member/contract
    By firstName = By.xpath("//label[text()='First name']//following-sibling::div/span/input");
    By lastname = By.xpath("//label[text()='Last Name']//following-sibling::div/span/input");
    By address = By.xpath("//label[text()='Address']//following-sibling::div/span/input");
    By city = By.xpath("//label[text()='City']//following-sibling::div/span/input");
    By zip = By.xpath("//label[text()='Zip']//following-sibling::div/span/input");
    By email = By.xpath("//label[text()='Email']//following-sibling::div/span/input");
    By phone = By.xpath("//input[contains(@name,'PrimaryPhoneNumber')]");
    By dropdown = By.tagName("select");
    By sell_btn = By.xpath("//div[normalize-space()='Sell']");



}
