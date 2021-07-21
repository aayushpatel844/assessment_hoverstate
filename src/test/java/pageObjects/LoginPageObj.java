package pageObjects;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class LoginPageObj  extends UIInteractionSteps {



        By username = By.cssSelector("#txtUserID");
        By password = By.cssSelector("#txtPassword");
        By loginbtn = By.xpath("//button[@id='sub']");

       @Step
       public void typeUsername(String userID){
           typeInto(find(username), userID);
       }

       @Step
       public void typePasword(String passWord){
              typeInto(find(password), passWord);
       }

       @Step
       public void clickLogin(){
              clickOn( find(loginbtn));
       }
}

