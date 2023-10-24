package com.jcst.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageLocators {

    @FindBy(id = "loginusername")
    public WebElement txtUsuario;

    @FindBy(id = "loginpassword")
    public WebElement txtClave;

    @FindBy(xpath = "//button[text()='Log in']")
    public WebElement btnLogIn;
}
