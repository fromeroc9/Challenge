package com.jcst.actions;

import com.jcst.locators.LoginPageLocators;
import com.jcst.utils.HelperClass;
import com.jcst.utils.HelperUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageActions {

    LoginPageLocators loginPageLocators = null;
    WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));

    public LoginPageActions() {
        this.loginPageLocators = new LoginPageLocators();
        PageFactory.initElements(HelperClass.getDriver(), loginPageLocators);
    }

    public void typeTextUsuario(String value){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(loginPageLocators.txtUsuario));
        element.sendKeys(value);
    }

    public void typeTextClave(String value){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(loginPageLocators.txtClave));
        element.sendKeys(value);
    }

    public void clickBotonLogin(){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(loginPageLocators.btnLogIn));
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
