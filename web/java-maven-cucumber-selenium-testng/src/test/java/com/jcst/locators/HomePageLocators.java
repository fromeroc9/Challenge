package com.jcst.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePageLocators {

    @FindBy(id = "login2")
    public WebElement btnLogIn;

    @FindBy(id = "nameofuser")
    public WebElement btnUsuario;

    @FindBy(id = "signin2")
    public WebElement btnSignUp;

    @FindBy(id = "logout2")
    public WebElement btnLogOut;

    @FindBy(id = "itemc")
    public List<WebElement> listCategoria;

    @FindBy(css = ".hrefch")
    public List<WebElement> listProducto;

}
