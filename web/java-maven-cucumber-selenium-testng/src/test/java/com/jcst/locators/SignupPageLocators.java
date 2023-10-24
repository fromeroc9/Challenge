package com.jcst.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPageLocators {

    @FindBy(id = "sign-username")
    public WebElement txtUsuario;

    @FindBy(id = "sign-password")
    public WebElement txtClave;

    @FindBy(xpath = "//button[text()='Sign up']")
    public WebElement btnSignUp;

}
