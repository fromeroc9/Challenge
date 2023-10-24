package com.jcst.definitions;

import com.jcst.actions.HomePageActions;
import com.jcst.actions.ProductPageActions;
import com.jcst.utils.HelperClass;
import com.jcst.utils.HelperUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.List;

public class AddCartPageDefinitions {

    HomePageActions objHomePage = new HomePageActions();
    ProductPageActions objProductPage = new ProductPageActions();
    String producto = "";

    @And("El usuario selecciona la categoria {string}")
    public void elUsuarioSeleccionaLaCategoria(String category) {
        objHomePage.clickSelectCategoria(category);
    }

    @And("El usuario selecciona el producto {string}")
    public void elUsuarioSeleccionaElProducto(String product) {
        producto = product;
        objHomePage.clickSelectProducto(product);
    }

    @And("El usuario agrega el producto al carrito")
    public void elUsuarioAgregaElProductoAlCarrito() {
        objProductPage.clickBotonAddCart();
        objProductPage.alertaError();
        HelperUtils.sleep(1);
    }

    @Then("El usuario valida su producto agregado en el carrito")
    public void elUsuarioValidaSuProductoAgregadoEnElCarrito() {
        objProductPage.clickBotonCart();

        List<String> productos = objProductPage.getNombreProductos();
        Assert.assertTrue(productos.contains(producto));
    }
}
