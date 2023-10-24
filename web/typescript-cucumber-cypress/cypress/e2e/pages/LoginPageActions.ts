import LoginPageLocatos from "../locators/LoginPageLocators";

class LoginPageActions {

  loginPageLocators: LoginPageLocatos;

  constructor() {
    this.loginPageLocators = new LoginPageLocatos();
  }

  typeTextoUsuario(value: string) {
    if (value) {
      cy.get(this.loginPageLocators.txtUsuario).type(value, { force: true });
    }
  }

  typeTextoClave(value: string) {
    if (value) {
      cy.get(this.loginPageLocators.txtClave).type(value, { force: true });
    }
  }

  clickBotonLogin() {
    cy.get(this.loginPageLocators.btnLogIn).click()
  }
}
export default LoginPageActions;