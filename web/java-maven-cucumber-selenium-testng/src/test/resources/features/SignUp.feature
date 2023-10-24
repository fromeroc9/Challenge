@all @Signup
Feature: Registrarse en la aplicación

  Background: 
    Given El usuario está en la página PRODUCT STORE "https://www.demoblaze.com/"

  # use '_random' generate value generic in column username
  @UsuarioValido @UsuarioInvalido @UsuarioVacio @ClaveVacio
  Scenario Outline: Registrarse en la aplicación <message>
    When El usuario ingresa su nombre de usuario como "<username>"
    And El usuario ingresa su contraseña como "<password>"
    And El usuario hace clic en el botón Sign up
    Then El usuario debería poder ver un mensaje "<message>"
    Examples:
      | username        | password      | message                  |
      | user_random     | claveuser2010 | Sign up successful.      |
      | Demo2010        | claveDemo2010 | This user already exist. |
      |                 | admin123      | Please fill out Username and Password. |
      | cmanual123      |               | Please fill out Username and Password. |