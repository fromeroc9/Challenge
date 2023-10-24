@all @LogOut
Feature: Cerrar de sesión en la aplicación

  Background: 
    Given El usuario está en la página PRODUCT STORE "https://www.demoblaze.com/"
    When El usuario inicia sesion ingresado el nombre de usuario como "Demo2010" y la contraseña como "demo123"

  @CerrarSesion
  Scenario: Cerrar sesión en la aplicación
    And El usuario da clic en el botón de cerrar sesión
    Then El usuario no debería poder ver su usuario en la parte superior derecha de la página