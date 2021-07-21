package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import pageObjects.LandingPage;

import java.util.List;

public class LandingStepDef {

    @Steps
    LandingPage landingPage;

    //title
    @Given("I am logged into the {string}")
    public void i_am_logged_into_the(String text) {
        landingPage.verifyTitleDisplayed(text);
    }

    // return - page verification
    @Then("I am returned to the {string}")
    public void iAmReturnedToThe(String text) {
        landingPage.verifyTextDisplayed(text);
    }

    // search options verification
    @Given("the following search criteria:")
    public void theFollowingSearchCriteria(DataTable dataTable) {
        List<String> searchOptions = dataTable.asList();
        for(String s1: searchOptions){
            Assert.assertTrue(landingPage.verifySeachOptions(s1));
        }
    }

    //search
    @When("I search for a customer by {string} {string}")
    public void i_search_for_a_customer_by(String type, String searchValue) {
        landingPage.selectRadio(type);
        landingPage.searchInput(searchValue);
        landingPage.clickOnSearchBtn();
    }

    //search
    @When("I search by {string} and {string}")
    public void iSearchByFieldAndSearchString(String field , String value) {
        landingPage.selectRadio(field);
        landingPage.searchInput(value);
        landingPage.clickOnSearchBtn();
    }

    //search
    @Given("I searched for {string} {string}")
    public void iSearchedForNameJohnLocke(String field, String value) {
        landingPage.selectRadio(field);
        landingPage.searchInput(value);
        landingPage.clickOnSearchBtn();
    }

    // search result verification
    @Then("I will see {string}")
    public void iWillSeeResponse(String responseText) {
        landingPage.verifySearchResult(responseText);
    }

    // search result verification
    @When("no contracts correspond to that VIN")
    public void no_contracts_correspond_to_that_vin() {
        landingPage.verifyContractNotFound();
    }

    // contract displayed
    @Then("I can locate contracts associated with {string}")
    public void iCanLocateContractsAssociatedWithJohnLocke(String contractName) {
        landingPage.verifyContractDisplayed(contractName);
    }

    // contract count verification
    @And("I confirm {int} contracts have been found")
    public void iConfirmContractsHaveBeenFound(int count) {
        landingPage.verifyTotalContract(count);
    }

    // contract not found
    @But("there are no products associated with my search")
    public void thereAreNoProductsAssociatedWithMySearch() {
        Assert.assertFalse(landingPage.isContractFound());
    }

    // product list for selection
    @Then("I can select the following products:")
    public void i_can_select_the_following_products(io.cucumber.datatable.DataTable dataTable) {
        landingPage.verifyItemListed(dataTable.asList());
    }

    // select existing product
    @When("I select the {string} contract")
    public void iSelectTheACDelcoSyntheticContract(String contractName) {
        landingPage.selectContractByName(contractName);
    }

    // select existing product
    @Given("I have selected {string}")
    public void iHaveSelectedACDelcoSynthetic(String product) {
        landingPage.selectRadio("vin");
        landingPage.searchInput("1FMCU9DGXAKC46617");
        landingPage.clickOnSearchBtn();
        landingPage.selectContractByName(product);
    }

    // verify product details displayed
    @Then("{string} display")
    public void display(String arg0) {
        landingPage.verifyContractInfo(arg0);
    }

    // verify service details
    @And("I can confirm {string} and {string} are available for redemption")
    public void iCanConfirmACDelcoSyntheticAndCarWashAreAvailableForRedemption(String product1, String product2) {
        landingPage.verifyProductList(product1, product2);
    }

    // add new product - service
    @When("I select a {string}")
    public void iSelectA(String arg0) {
        landingPage.addNewProduct(arg0);
    }

    // type RO
    @And("I type a {string}")
    public void iTypeA(String arg0) {
        landingPage.type_RO(arg0);
    }

    //search - select - add service
    @Given("I have sold a {string} contract for {string} {string}")
    public void i_have_sold_a_contract(String productType, String type, String searchValue ){
        landingPage.selectRadio(type);
        landingPage.searchInput(searchValue);
        landingPage.clickOnSearchBtn();
        landingPage.clickContract(productType);
        landingPage.seeAllOtherProdcut();
        landingPage.addNewProduct(productType);
        landingPage.type_RO("R12345");
        landingPage.clickOnSellBtn();
    }

    // item selection for redeem
    @When("I select {string} as a {string} to redeem")
    public void iSelectCarWashAsAToRedeem(String service, String arg1) {
        landingPage.selectProductToReedem(service, arg1);
    }

    // redeem success
    @Then("I can confirm {string} has replaced the [redeem] button")
    public void iCanConfirmServiceRedeemedHasReplacedTheRedeemButton(String arg0) {
        landingPage.verifyRedeemSuccess();
    }

    // service details
    @And("I can confirm {string} has {int} Redeemed and {int} Available")
    public void iCanConfirmHasRedeemedAndAvailable(String arg0, int arg1, int arg2) {
        landingPage.verifyProductdetail( arg0, arg1, arg2);
    }

    //type RO for Redeem
    @And("I type RO number as {string}")
    public void iTypeRONumberAsR(String value) {
        landingPage.typeRO_redeem(value);
    }

    // service details - redeemed
    @And("I can confirm {string} now shows {int} has been Redeemed")
    public void iCanConfirmCarWashNowShowsHasBeenRedeemed(String arg0, int arg1) {
        landingPage.verifyReedemItemCount( arg0, arg1);
    }

    // service details - available
    @And("I can confirm {string} now shows {int} are Available")
    public void iCanConfirmCarWashNowShowsAreAvailable(String arg0 , int arg1) {
        landingPage.verifyAvailableItemCount(arg0, arg1);
    }

    // redemption history
    @And("I can confirm {string} now shows in {string} with RO Number as {string}")
    public void iCanConfirmCarWashNowShowsInWithRONumberAsR(String arg0, String arg1, String arg2) {
        landingPage.verifyRedeemptionHistory(arg0, arg2);
    }

    // sell contract display
    @Then("a {string} is available \\(renders)")
    public void a_is_available_renders(String text) {
        landingPage.verifySellContractText(text);
    }


    // sell contract
    @Given("I have a sell contract for {string} {string}")
    public void iHaveASellContractFor(String arg0, String arg1) {
        landingPage.selectRadio(arg0);
        landingPage.searchInput(arg1);
        landingPage.clickOnSearchBtn();
    }

    // add new customer data
    @And("I have the following customer information:")
    public void iHaveTheFollowingCustomerInformation(DataTable dataTable) {
        List<String> data = dataTable.asList();
        if( landingPage.createContract(data) ) {
            landingPage.clickContract("AC Delco");
            landingPage.seeAllOtherProdcut();
        }
    }

    // sell btn click
    @And("I click [sell]")
    public void iClickSell() {
        landingPage.clickOnSellBtn();
    }




}
