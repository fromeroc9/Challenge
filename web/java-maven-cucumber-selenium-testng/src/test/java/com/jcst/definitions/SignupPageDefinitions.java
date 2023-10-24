package com.jcst.definitions;

import com.jcst.actions.HomePageActions;
import com.jcst.actions.SignupPageActions;
import com.jcst.utils.HelperUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class SignupPageDefinitions {

    HomePageActions objHomePage = new HomePageActions();
    SignupPageActions objSignupPage = new SignupPageActions();
    public static String usernameStep = "";
    public static String passwordStep = "";

    @When("El usuario ingresa su nombre de usuario como {string}")
    public void elUsuarioIngresaSuNombreDeUsuarioComo(String username) {
        objHomePage.clickBotonSignOut();

        if (username.contains("_random")) {
            username = username.replace("random", HelperUtils.generateRandomString(5));
        }

        objSignupPage.typeTextUsuario(username);
    }

    @And("El usuario ingresa su contraseña como {string}")
    public void elUsuarioIngresaSuContrasenaComo(String password) {
        objSignupPage.typeTextClave(password);
    }

    @And("El usuario hace clic en el botón Sign up")
    public void elUsuarioHaceClicEnElBotonSignUp() {
        objSignupPage.clickBotonSignOut();
    }

    @When("El usuario se registra ingresando el nombre de usuario como {string} y la contraseña como {string}")
    public void elUsuarioSeRegistraIngresandoElNombreDeUsuarioComoYLaContrasenaComo(String username, String password) {
        objHomePage.clickBotonSignOut();

        if (username.contains("_random")) {
            username = username.replace("random", HelperUtils.generateRandomString(5));
        }

        usernameStep = username;
        passwordStep = password;

        objSignupPage.typeTextUsuario(username);

        objSignupPage.typeTextClave(password);

        objSignupPage.clickBotonSignOut();

        HelperUtils.sleep(1);

        objSignupPage.alertaError();
    }
}
