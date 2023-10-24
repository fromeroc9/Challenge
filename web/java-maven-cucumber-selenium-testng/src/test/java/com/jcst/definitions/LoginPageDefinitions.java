package com.jcst.definitions;

import com.jcst.actions.HomePageActions;
import com.jcst.actions.LoginPageActions;
import com.jcst.utils.HelperClass;
import com.jcst.utils.HelperUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginPageDefinitions {

    HomePageActions objHomePage = new HomePageActions();
    LoginPageActions objLoginPage = new LoginPageActions();

    @Given("El usuario está en la página PRODUCT STORE {string}")
    public void elUsuarioEstaEnLaPaginaPRODUCTSTORE(String url) {
        HelperClass.openPage(url);
    }

    @When("El usuario ingresa el nombre de usuario como {string} y la contraseña como {string}")
    public void elUsuarioIngresaElNombreDeUsuarioComoYLaContrasenaComo(String username, String password) {
        objHomePage.clickBotonLogin();
        objLoginPage.typeTextUsuario(username);
        objLoginPage.typeTextClave(password);
        objLoginPage.clickBotonLogin();
    }

    @When("El usuario inicia sesion ingresado el nombre de usuario como {string} y la contraseña como {string}")
    public void elUsuarioIniciaSesionIngresadoElNombreDeUsuarioComoYLaContrasenaComo(String username, String password) {
        objHomePage.clickBotonLogin();
        objLoginPage.typeTextUsuario(username);
        objLoginPage.typeTextClave(password);
        objLoginPage.clickBotonLogin();
    }

    @Then("El usuario debería poder ver su usuario {string}")
    public void elUsuarioDeberiaPoderVerSuUsuario(String username) {
        String usuarioObtenido = objHomePage.getUsuario();
        Assert.assertEquals(usuarioObtenido, "Welcome " + username);
    }

    @Then("El usuario debería poder ver el mensaje de error {string}")
    public void elUsuarioDeberiaPoderVerElMensajeDeError(String message) {
        String mensajeObtenido = objLoginPage.alertaError();
        Assert.assertEquals(mensajeObtenido, message);
    }

    @Then("El usuario debería poder ver un mensaje {string}")
    public void elUsuarioDeberiaPoderVerUnMensaje(String message) {
        String mensajeObtenido = objLoginPage.alertaError();
        Assert.assertEquals(mensajeObtenido, message);
    }

    @And("El usuario inicia sesion")
    public void elUsuarioIniciaSesion() {
        objHomePage.clickBotonLogin();
        objLoginPage.typeTextUsuario(SignupPageDefinitions.usernameStep);
        objLoginPage.typeTextClave(SignupPageDefinitions.passwordStep);
        objLoginPage.clickBotonLogin();
        HelperUtils.sleep(1);
    }
}



