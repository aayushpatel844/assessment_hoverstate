package pageObjects;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import utility.baseUtil;

public class SalesPage extends SalesPageObj {

    @Step
    public void verify_page_title(String text){
        baseUtil.waitForElementVisible(getDriver(),title);
        Assert.assertTrue(getRenderedView().containsText(text));
    }

    @Step
    public void select_checkbox(String product){
        find( checkbox ).click();
    }

    @Step
    public void clickOnRedeemBtn(){
        baseUtil.waitForElementClickable(getDriver(),redeem);
        find( redeem ).click();
    }

    @Step
    public void clickOnNoMoreLink(String linkText){
        baseUtil.waitForElementPresence(getDriver(),noSell_link);
        find(noSell_link).click();
    }

    @Step
    public void verifyServiceDescription(String serviceDesc){
        getRenderedView().containsText(serviceDesc);
    }

    @Step
    public void verifyReedemed(String redeemed){
        getRenderedView().containsText(redeemed);
    }

    @Step
    public void verifyAvailable(String available){
        getRenderedView().containsText(available);
    }

    @Step
    public void verifyPrice(String price){
        getRenderedView().containsText(price);
    }



}
