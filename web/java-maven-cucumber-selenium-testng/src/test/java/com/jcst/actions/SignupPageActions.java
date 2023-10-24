package com.jcst.actions;

import com.jcst.locators.LoginPageLocators;
import com.jcst.locators.SignupPageLocators;
import com.jcst.utils.HelperClass;
import com.jcst.utils.HelperUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignupPageActions {

    SignupPageLocators signupPageLocators = null;
    WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));

    public SignupPageActions() {
        this.signupPageLocators = new SignupPageLocators();
        PageFactory.initElements(HelperClass.getDriver(), signupPageLocators);
    }

    public void typeTextUsuario(String value){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(signupPageLocators.txtUsuario));
        element.sendKeys(value);
    }

    public void typeTextClave(String value){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(signupPageLocators.txtClave));
        element.sendKeys(value);
    }

    public void clickBotonSignOut(){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(signupPageLocators.btnSignUp));
        element.click();
        HelperUtils.sleep(1);
    }

    public String alertaError(){
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = HelperClass.getDriver().switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }
}
