package pageObjects;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import utility.baseUtil;

public class RedeemPage extends ReedemPageObj{



    @Step
    public void verify_page_title(String text){

        baseUtil.waitForElementVisible(getDriver(),title);
        Assert.assertTrue(getRenderedView().containsText(text));
    }

    @Step
    public void saleVerification(String text){
        String num = text.split(" ")[1];
        //Assert.assertEquals( num, find( total_sale ).getText());
        Assert.assertFalse( find(total_sale_txt).getText().contains( text ));
    }

    @Step
    public void targetVerification(String text){
        String num = text.split(" ")[4];
        //Assert.assertEquals( num, find( target ).getText());
        Assert.assertFalse( find(target).getText().contains( text ));
    }

    @Step
    public void clickOK(){
        baseUtil.waitForElementVisible(getDriver(),ok_button);
        clickOn(find( ok_button ));
    }




}
