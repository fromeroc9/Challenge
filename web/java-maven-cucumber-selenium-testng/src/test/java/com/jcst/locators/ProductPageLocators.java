package com.jcst.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPageLocators {

    @FindBy(css = "div#tbodyid div:nth-of-type(2) a")
    public WebElement btnAddToCart;

    @FindBy(css = "#navbarExample > ul > li:nth-child(4) > a")
    public WebElement btnCart;

    @FindBy(css = "#tbodyid > tr > td")
    public List<WebElement> listProducto;
}
