import { Given, Then, When } from "@badeball/cypress-cucumber-preprocessor";
import LoginPageActions from "../pages/LoginPageActions";
import HomePageActions from "../pages/HomePageActions";
import { passwordStep, usernameStep } from "./SignupPageDefinitions";

const objLoginPage = new LoginPageActions;
const objHomePage = new HomePageActions;

Given("El usuario está en la página PRODUCT STORE {string}", (url: string) => {
   cy.visit(url);
})

When("El usuario ingresa el nombre de usuario como {string} y la contraseña como {string}", (usuario: string, clave: string) => {
    objHomePage.clickBotonLogin();
    objLoginPage.typeTextoUsuario(usuario);
    objLoginPage.typeTextoClave(clave);
    objLoginPage.clickBotonLogin();
})

When("El usuario inicia sesion ingresado el nombre de usuario como {string} y la contraseña como {string}",(username: string, password: string) => {
    objHomePage.clickBotonLogin();
    objLoginPage.typeTextoUsuario(username);
    objLoginPage.typeTextoClave(password);
    objLoginPage.clickBotonLogin();

    cy.wait(3000);
})

Then("El usuario debería poder ver su usuario {string}", (username: string) => {
    cy.wait(3000);
    objHomePage.getUsuario().should('contain', "Welcome " + username);
    cy.screenshot({capture : 'runner'})
})

Then("El usuario debería poder ver el mensaje de error {string}", (msg: string) => {
    cy.on('window:alert', (message: string) => {
        expect(message).to.equal(msg);
    });
    cy.wait(2000);
})

Then("El usuario debería poder ver un mensaje {string}", (msg: string) => {
    cy.on('window:alert', (message: string) => {
        expect(message).to.equal(msg);
    });
    objLoginPage.clickBotonLogin();
})

Then("El usuario inicia sesion", () => {
    objHomePage.clickBotonLogin();
    objLoginPage.typeTextoUsuario(usernameStep);
    objLoginPage.typeTextoClave(passwordStep);
    objLoginPage.clickBotonLogin();
})