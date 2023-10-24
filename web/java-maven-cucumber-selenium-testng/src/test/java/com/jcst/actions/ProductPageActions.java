package com.jcst.actions;

import com.jcst.locators.ProductPageLocators;
import com.jcst.utils.HelperClass;
import com.jcst.utils.HelperUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPageActions {

    ProductPageLocators productPageLocators = null;
    WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));

    public ProductPageActions() {
        this.productPageLocators = new ProductPageLocators();
        PageFactory.initElements(HelperClass.getDriver(), productPageLocators);
    }

    public void clickBotonAddCart() {
        HelperUtils.sleep(3);
        WebElement element = wait.until(ExpectedConditions.visibilityOf(productPageLocators.btnAddToCart));
        element.click();
    }

    public void clickBotonCart() {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(productPageLocators.btnCart));
        element.click();
        HelperUtils.sleep(5);
    }

    public List<String> getNombreProductos() {
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElements(productPageLocators.listProducto));
        return HelperUtils.getElement(elements);
    }

    public String alertaError(){
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = HelperClass.getDriver().switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

}
