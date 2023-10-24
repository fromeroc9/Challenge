import SignupPageLocators from "../locators/SignupPageLocators";

class SignupPageActions {

    signupPageLocators: SignupPageLocators;

    constructor() {
        this.signupPageLocators = new SignupPageLocators();
    }

    typeTextoUsuario(value: string) {
        if (value) {
            cy.get(this.signupPageLocators.txtUsuario).type(value, { force: true });
        }
    }

    typeTextoClave(value: string) {
        if (value) {
            cy.get(this.signupPageLocators.txtClave).type(value, { force: true });
        }
    }

    clickBotonSignOut() {
        cy.get(this.signupPageLocators.btnSignUp).click();
    }

}
export default SignupPageActions