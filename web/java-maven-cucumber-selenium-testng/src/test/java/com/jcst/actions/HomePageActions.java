package com.jcst.actions;

import com.jcst.locators.HomePageLocators;
import com.jcst.utils.HelperClass;
import com.jcst.utils.HelperUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePageActions {

    HomePageLocators homePageLocators = null;
    WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));

    public HomePageActions() {
        this.homePageLocators = new HomePageLocators();
        PageFactory.initElements(HelperClass.getDriver(), homePageLocators);
    }

    public void clickBotonLogin(){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(homePageLocators.btnLogIn));
        element.click();
        HelperUtils.sleep(1);
    }

    public boolean showBotonLogin(){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(homePageLocators.btnLogIn));
        return element.isDisplayed();
    }

    public String getUsuario(){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(homePageLocators.btnUsuario));
        return element.getText();
    }

    public void clickBotonSignOut(){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(homePageLocators.btnSignUp));
        element.click();
    }

    public void clickBotonLogOut(){
        HelperUtils.sleep(2);
        WebElement element = wait.until(ExpectedConditions.visibilityOf(homePageLocators.btnLogOut));
        element.click();
    }

    public void clickSelectCategoria(String categoria){
        HelperUtils.sleep(2);
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElements(homePageLocators.listCategoria));
        HelperUtils.clickElement2(elements, categoria);
    }

    public void clickSelectProducto(String producto){
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElements(homePageLocators.listProducto));

        HelperUtils.sleep(2);
        HelperUtils.clickElement(elements, producto);
    }
}
