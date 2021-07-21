package pageObjects;

import net.thucydides.core.annotations.Step;

public class NavigationSteps {

    NavigationPage navigation;

    @Step
    public void navigateTo(){
        navigation.open();
    }
}
