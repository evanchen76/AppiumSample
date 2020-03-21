package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    public RegisterPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(accessibility = "loginId")
    @AndroidFindBy(id = "loginId")
    public MobileElement loginId;

    @iOSXCUITFindBy(accessibility = "password")
    @AndroidFindBy(id = "password")
    public MobileElement loginPassword;

    @iOSXCUITFindBy(accessibility = "send")
    @AndroidFindBy(id = "send")
    public MobileElement send;
}


