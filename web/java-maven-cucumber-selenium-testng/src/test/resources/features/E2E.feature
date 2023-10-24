Feature: Flujo completo
  Background:
    Given El usuario está en la página PRODUCT STORE "https://www.demoblaze.com/"

    #Usuario se da de Alta
    #Usuario inicia sesión
    #Usuario selecciona categoria y producto
    #Usuario se deslogea
  @e2e
  Scenario Outline: Validar que se realice todos los ejemplos anteriores
    When El usuario se registra ingresando el nombre de usuario como "<username>" y la contraseña como "<password>"
    And El usuario inicia sesion
    When El usuario selecciona la categoria "<category>"
    And El usuario selecciona el producto "<product>"
    And El usuario agrega el producto al carrito
    Then El usuario valida su producto agregado en el carrito
    And El usuario da clic en el botón de cerrar sesión
    And El usuario no debería poder ver su usuario en la parte superior derecha de la página
    Examples:
    | username    | password      | category | product     |
    | user_random | claveuser2010 | Laptop   | MacBook Pro |