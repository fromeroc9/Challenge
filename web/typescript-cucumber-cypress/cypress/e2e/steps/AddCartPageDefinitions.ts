import { Then, When } from "@badeball/cypress-cucumber-preprocessor";
import HomePageActions from "../pages/HomePageActions";
import ProductPageActions from "../pages/ProductPageActions";

const objHomePage = new HomePageActions;
const objProductPage = new ProductPageActions;
let producto = "";

When("El usuario selecciona la categoria {string}", (category: string) => {
    objHomePage.clickSelectCategoria(category);
    cy.wait(2000);
})

When("El usuario selecciona el producto {string}", (product: string) => {
    producto = product;
    objHomePage.clickSelectProducto(product);
    cy.wait(2000);
})

When("El usuario agrega el producto al carrito", () => {
    objProductPage.clickBotonAddCart();
    cy.on('window:alert', (message: string) => {
        expect(message).contains("Product added");
    });
    cy.wait(2000);
})

Then("El usuario valida su producto agregado en el carrito", () => {
    objProductPage.clickBotonCart();
    cy.wait(5000);

    objProductPage.getProductName(producto).then((value: string) => {
        expect(value).to.equal(producto);
    })

})