import { Given, Then } from "@badeball/cypress-cucumber-preprocessor";
import HomePageActions from "../pages/HomePageActions";

const objHomePage = new HomePageActions;

Given("El usuario da clic en el botón de cerrar sesión", () => {
    cy.wait(3000);
    objHomePage.clickBotonLogOut();
})

Then("El usuario no debería poder ver su usuario en la parte superior derecha de la página", () => {
    cy.wait(2000);
    objHomePage.getUsuario().should('contain', "");
})