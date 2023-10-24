import HomePageLocators from '../locators/HomePageLocators';


class HomePageActions {

  private homePageLocators: HomePageLocators;

  constructor() {
    this.homePageLocators = new HomePageLocators();
  }

  clickBotonLogin() {
    cy.get(this.homePageLocators.btnLogIn).click();
  }

  getUsuario() {
    let action = cy.get(this.homePageLocators.btnUsuario)
    return action.then(e => { return e.text()} )
  }

  clickBotonSignOut() {
    cy.get(this.homePageLocators.btnSignUp).click();
  }

  clickBotonLogOut() {
    cy.get(this.homePageLocators.btnLogOut).click();
  }

  clickSelectCategoria(categoria: string) {
    cy.get(this.homePageLocators.listCategoria).contains(categoria).click();
  }

  clickSelectProducto(producto: string) {
    cy.get(this.homePageLocators.listProducto).contains(producto).click();
  }
}

export default HomePageActions;