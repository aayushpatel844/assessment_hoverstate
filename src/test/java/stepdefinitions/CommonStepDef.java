package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.apache.commons.net.util.Base64;
import pageObjects.LoginPageObj;
import pageObjects.NavigationSteps;

import java.util.Map;

public class CommonStepDef {

    @Steps
    NavigationSteps navigation;

    @Steps
    LoginPageObj login;

    @Given("I navigate to {string}")
    public void i_navigate_to(String string) {
        navigation.navigateTo();
    }

    @When("I type my credentials")
    public void i_type_my_credentials(DataTable dataTable) {
        Map<String,String> cred = dataTable.asMap(String.class, String.class);
        login.typeUsername(cred.get("uid"));
        login.typePasword(new String(Base64.decodeBase64(cred.get("pw")) ));
    }

    @Then("I click on [login]")
    public void i_click_on_login() {
        login.clickLogin();
    }

}
