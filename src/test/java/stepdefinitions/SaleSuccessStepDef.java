package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import pageObjects.SalesPage;
import utility.baseUtil;

public class SaleSuccessStepDef {

    @Steps
    SalesPage salesPage;

    @And("the {string} modal currently displays")
    public void theSaleSuccessfulModalCurrentlyDisplays(String title) {
        salesPage.verify_page_title(title);
    }

    @When("I select the checkbox for {string}")
    public void iSelectTheCheckboxFor(String arg0) {
        salesPage.select_checkbox(arg0);
    }

    @And("I click [Redeem]")
    public void iClickRedeem() {
        salesPage.clickOnRedeemBtn();
    }

    @And("I click {string} link")
    public void iClickNoSellContractWithoutRedemption( String linktext) {
        salesPage.clickOnNoMoreLink(linktext);
    }

    @Then("a {string} modal pops-up")
    public void aModalPopsUp(String title) {
        salesPage.verify_page_title(title);
    }

    @And("I can confirm the {string} {string} {string} & {string} information")
    public void iCanConfirmTheInformation(String arg0, String arg1, String arg2, String arg3) {
        salesPage.verifyServiceDescription(arg0);
        salesPage.verifyReedemed(arg1);
        salesPage.verifyAvailable(arg2);
        salesPage.verifyPrice(arg3);
    }

}
