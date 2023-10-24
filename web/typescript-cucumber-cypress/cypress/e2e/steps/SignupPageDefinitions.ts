import { When, Then } from "@badeball/cypress-cucumber-preprocessor";
import HomePageActions from "../pages/HomePageActions";
import { generateRandomString } from "../utility/HelperUtils";
import SignupPageActions from "../pages/SignupPageActions";
import { wait } from "../actions/Actions";

export let usernameStep = "";
export let passwordStep = "";

const objHomePage = new HomePageActions;
const objSignupPage = new SignupPageActions;

When("El usuario ingresa su nombre de usuario como {string}", (username: string) => {
    objHomePage.clickBotonSignOut();

    if (username.includes("_random")) {
        username = username.replace("random", generateRandomString(5));
    }

    objSignupPage.typeTextoUsuario(username);
})

When("El usuario ingresa su contraseña como {string}", (password: string) => {
    objSignupPage.typeTextoClave(password);
})

When("El usuario hace clic en el botón Sign up", () => {
    objSignupPage.clickBotonSignOut();
})

Then("El usuario deberia poder ver un mensaje {string}", (msg: string) => {
    cy.on('window:alert', (message: string) => {
        expect(message).to.equal(msg);
    });
    cy.wait(2000);
})


When("El usuario se registra ingresando el nombre de usuario como {string} y la contraseña como {string}", (username: string, password: string) => {
    objHomePage.clickBotonSignOut();

    if (username.includes("_random")) {
        username = username.replace("random", generateRandomString(5));
    }

    usernameStep = username;
    passwordStep = password;

    objSignupPage.typeTextoUsuario(username);

    objSignupPage.typeTextoClave(password);

    objSignupPage.clickBotonSignOut();

    cy.wait(1000);
})