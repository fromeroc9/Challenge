import ProductPageLocators from "../locators/ProductPageLocators";

class ProductPageActions {
    productPageLocator: ProductPageLocators;

    constructor() {
        this.productPageLocator = new ProductPageLocators();
    }

    clickBotonAddCart(){
        cy.get(this.productPageLocator.btnAddToCart).click()
    }

    clickBotonCart(){
        cy.get(this.productPageLocator.btnCart).click()
    }

    getProductName(value: string){
        let action =  cy.get(this.productPageLocator.listProducto).contains(value)
        return action.then(e => { return e.text()} )
    }
}
export default ProductPageActions;