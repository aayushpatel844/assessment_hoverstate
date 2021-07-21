package pageObjects;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utility.baseUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LandingPage extends LandingPageObj {


    @Step
    public void verifyTitleDisplayed(String expectedTitle) {
        getDriver().switchTo().frame(0);
        // title
        Assert.assertTrue( getRenderedView().containsText(expectedTitle) );
    }

    @Step
    public void verifyTextDisplayed(String expectedTitle) {
        Assert.assertTrue( getRenderedView().containsText(expectedTitle) );
    }




    // ******* Search contract steps ***********

    public boolean verifySeachOptions(String type) {
        String type1 = type.toLowerCase();
        switch (type1) {
            case "name":
                return find(radio_name).isDisplayed();
            case "email":
                return find(radio_email).isDisplayed();
            case "phone":
                return find(radio_phone).isDisplayed();
            case "contract number":
                return find(radio_contract).isDisplayed();
            default:
                return find(radio_vin).isDisplayed();
        }
    }

    @Step
    public void selectRadio(String type) {

        String type1 = type.toLowerCase();

        switch (type1) {
            case "name":
                baseUtil.jsClick(getDriver(), radio_name);
                break;
            case "email":
                baseUtil.jsClick(getDriver(), radio_email);
                break;
            case "phone":
                baseUtil.jsClick(getDriver(), radio_phone);
                break;
            case "contract number":
                baseUtil.jsClick(getDriver(), radio_contract);
                break;
            default:
                if (!find(radio_vin).isSelected())
                    baseUtil.jsClick(getDriver(), radio_vin);
        }
    }


    @Step
    public void searchInput(String value) {
        baseUtil.waitForElementClickable(getDriver(),searchInput);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        baseUtil.jsSendKey(getDriver(),searchInput,value);
    }

    @Step
    public void clickOnSearchBtn() {
        clickOn(find(search));
    }

    @Step
    public void verifySearchResult(String resp) {
        Assert.assertTrue(getRenderedView().containsText(resp));
    }

    @Step
    public void verifyContractNotFound() {
        String text = "";
        try {
            text = find(contract_text).getText();
            System.out.println(text);
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }
        Assert.assertTrue(text.isEmpty());
    }

    @Step
    public void selectContractByName(String contractName) {
        List<WebElement> contractList = getDriver().findElements(contract_products);
        for (WebElement element : contractList) {
            if (element.getText().contains(contractName)) {
                element.click();
                break;
            }
        }
    }

    @Step
    public void selectByContractNo(String contractNo) {
        List<WebElement> productList = getDriver().findElements(contract_number);
        for (WebElement element : productList) {
            if (element.getText().contains(contractNo)) {
                element.click();
                break;
            }
        }
    }


    @Step
    public void verifyContractDisplayed(String name) {
        List<WebElement> element_list = getDriver().findElements(contract_name);
        Set<String> unique_names = new HashSet<String>();
        for (WebElement ele : element_list) {
            unique_names.add(ele.getText().toLowerCase());
        }
        Assert.assertTrue(unique_names.contains(name.toLowerCase()));
    }

    @Step
    public void verifyTotalContract(int count) {
        find(contract_text).containsText(String.valueOf(count));
    }

    @Step
    public boolean isContractFound() {
        List<WebElement> element_list = getDriver().findElements(contract_number);
        if (element_list.size() == 0) {
            return false;
        } else {
            return true;
        }
    }




    // ******* product  steps ***********

    @Step
    public void verifyItemListed(List<String> expList) {
        List<String> actualList = new ArrayList<>();
        //collectElements
        List<WebElement> elementList = getDriver().findElements(product_list);

        //collect textValue of elements
        elementList.forEach(e -> actualList.add(e.getText()));

        // verify list of exp with actual
        expList.forEach(e -> actualList.contains(e));
    }


    @Step
    public void seeAllOtherProdcut() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", getDriver().findElement(seeAll));
    }

    @Step
    public void addNewProduct(String ProductType) {

        //collectElements
        List<WebElement> elementList = getDriver().findElements(product_list);

        for (WebElement e : elementList) {
            if (e.getText().equalsIgnoreCase(ProductType)) {
                clickOn(e);
                break;
            }
        }
        typeInto(find(service_date), "07/01/2021");
    }

    @Step
    public void type_RO(String arg0){
        typeInto(find(input_RO_seeAll), arg0);
    }





    // ******* Redeem service/product steps ***********

    @Step
    public void selectProductToReedem(String serviceName, String arg0){
        int k= getRowID(serviceName)+ 1;
        find(By.xpath("//tr["+ k + service_checkbox )).click();
    }

    @Step
    public void typeRO_redeem(String value) {
        typeInto(find(input_RO_prepaidSevice), value);
    }

    @Step
    public void verifyReedemItemCount(String serviceName, int count){
        find(By.xpath(before_path + getRowID(serviceName) + after_redeem_Path)).getText().contains(String.valueOf(count));
    }

    @Step
    public void verifyAvailableItemCount(String serviceName, int count){
        find(By.xpath(before_path + getRowID(serviceName) + after_available_Path)).getText().contains(String.valueOf(count));
    }

    @Step
    public void verifyProductdetail(String productName, int count1, int count2) {
        verifyAvailableItemCount(productName,count1);
        verifyReedemItemCount(productName,count2);
    }

    @Step
    public void verifyRedeemSuccess(){
        find(sucessTxt).isDisplayed();
    }

    @Step
    public void verifyRedeemptionHistory(String service, String RO_number){

        // failure as portal not showing redeemption record every now and then
        baseUtil.scrollToElement(getDriver(), find(service_redeemed));

        find(service_redeemed).getText().contains(service);
        find(service_ro).getText().contains(RO_number);

        find(deleteItem).click();
        find(deleteBtn).click();
    }

    int setIndex=0;
    @Step
    public int getRowID(String serviceName) {
        List<WebElement> serviceList = getDriver().findElements(service_desc);
        for (int i = 1; i <= serviceList.size(); i++) {
            String actualService = serviceList.get(i-1).getText();
            if (actualService.equals(serviceName)) {
                setIndex = i;
                break;
            }
        }
        return setIndex;
    }






    // ******* Sell contract steps ***********

    @Step
    public void verifySellContractText(String text) {
//          Assert.assertTrue( getRenderedView().containsText(text));
        Assert.assertTrue(find(sell_contract).getText().equalsIgnoreCase(text));
    }

    @Step
    public void clickContract(String productType) {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].click();", find(product_AC_Delco));
    }

    @Step
    public boolean createContract(List<String> data){
        boolean contractExist = true;
        try{
            find(firstName).isDisplayed();
            contractExist = false;
        } catch ( Exception e) {
            System.out.println( "Contract exist for customer");
        }

        if( !contractExist){
            typeInto(find(firstName), data.get(0).split(" ")[0]);
            typeInto(find(lastname), data.get(0).split(" ")[1]);
            typeInto(find(address), data.get(1));
            typeInto(find(city), data.get(2));
            selectFromDropdown(find(dropdown), data.get(3));
            typeInto(find(zip), data.get(4));
            typeInto(find(email), data.get(5));
            typeInto(find(phone), data.get(6));
        }
        return contractExist;
    }

    @Step
    public void verifyContractInfo(String arg0) {
        baseUtil.scrollToElement(getDriver(), find(contract_details_title));
        find(contract_details_title).isDisplayed();
    }

    @Step
    public void verifyProductList(String product1, String product2) {
        List<String> product_list = new ArrayList<>();
        List<WebElement> productList = getDriver().findElements(service_desc);
        for (WebElement element : productList) {
            product_list.add(element.getText());
        }
        Assert.assertTrue(product_list.contains(product1));
        Assert.assertTrue(product_list.contains(product2));
    }

    @Step
    public void clickOnSellBtn() {
        clickOn(find(sell_btn));
    }

}
