package com.jcst.definitions;

import com.jcst.actions.HomePageActions;
import com.jcst.utils.HelperUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class LogoutPageDefinitions {

    HomePageActions objHomePage = new HomePageActions();

    @And("El usuario da clic en el botón de cerrar sesión")
    public void elUsuarioDaClicEnElBotonDeCerrarSesion() {
        objHomePage.clickBotonLogOut();
        HelperUtils.sleep(2);
    }

    @Then("El usuario no debería poder ver su usuario en la parte superior derecha de la página")
    public void elUsuarioNoDeberiaPoderVerSuUsuario() {
        boolean inicio = objHomePage.showBotonLogin();
        Assert.assertTrue(inicio, "El usuario se encuentra deslogeado");
    }
}
