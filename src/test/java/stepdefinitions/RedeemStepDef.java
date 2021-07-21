package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.RedeemPage;

public class RedeemStepDef {

    RedeemPage redeemPage;

    @Then("the {string} modal appears")
    public void theModalAppears(String arg0) {
        redeemPage.verify_page_title(arg0);
    }

    @And("I can confirm I have {string}")
    public void iCanConfirmIHave(String arg0) {
        redeemPage.saleVerification(arg0);
    }

    @And("I can confirm I am {string}")
    public void iCanConfirmIAm(String arg0) {
        redeemPage.targetVerification(arg0);
    }

    @When("I click [OK]")
    public void iClickOK() {
        redeemPage.clickOK();
    }



}
