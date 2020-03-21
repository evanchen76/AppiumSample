package stepdefinations;

import com.sun.source.tree.AssertTree;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.RegisterPage;
import pages.ResultPage;
import utility.Hook;

public class RegisterScenario {

    private RegisterPage registerPage;
    private ResultPage resultPage;

    public RegisterScenario() {
        this.registerPage = new RegisterPage(Hook.getDriver());
        this.resultPage = new ResultPage(Hook.getDriver());
    }

    @Given("^我開啟註冊頁面")
    public void i_open_the_application() throws Throwable {

    }
    @When("我在帳號輸入 (\\S+)")
    public void i_type_on_loginId(String loginId) throws Throwable {
        this.registerPage.loginId.sendKeys(loginId);
    }

    @And("我在密碼輸入 (\\S+)")
    public void i_type_on_password(String password) throws Throwable {
        this.registerPage.loginPassword.sendKeys(password);
    }

    @And("^點擊註冊按鈕")
    public void i_tap_login() throws Throwable {
        this.registerPage.send.click();
    }

    @Then("^我會看到註冊成功的畫面")
    public void i_validate_result() throws Throwable {
        Assert.assertEquals("註冊成功", this.resultPage.result.getText());
    }

    @Then("^我會看到註冊失敗的提醒")
    public void i_saw_fail() throws Throwable {
        String title = Hook.getDriver().findElement(By.id("android:id/message")).getText();
        Assert.assertEquals("帳號至少要6碼，第1碼為英文", title);
    }
}
