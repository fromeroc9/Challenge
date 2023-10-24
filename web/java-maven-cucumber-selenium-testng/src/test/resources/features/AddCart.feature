@all @AddCart
Feature: Añadir Producto

  Background: 
    Given El usuario está en la página PRODUCT STORE "https://www.demoblaze.com/"

  @AgregaProductoSesionActiva  
  Scenario: Añadir Producto con Inicio de Sesión Activa
    When El usuario inicia sesion ingresado el nombre de usuario como "Demo2010" y la contraseña como "demo123"
    And El usuario selecciona la categoria "Laptop"
    And El usuario selecciona el producto "Sony vaio i5"
    And El usuario agrega el producto al carrito
    Then El usuario valida su producto agregado en el carrito

  @AgregaProductoSesionInactiva
  Scenario: Añadir Producto con Inicio de Sesión Inactiva
    When El usuario selecciona la categoria "Laptops"
    And El usuario selecciona el producto "MacBook Pro"
    And El usuario agrega el producto al carrito
    Then El usuario valida su producto agregado en el carrito
