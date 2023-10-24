@all @Login
Feature: Inicio de sesión en la aplicación

  Background: 
    Given El usuario está en la página PRODUCT STORE "https://www.demoblaze.com/"

  @CredencialesValidos
  Scenario: Inicie sesión con credenciales válidas
    When El usuario ingresa el nombre de usuario como "Demo2010" y la contraseña como "demo123"
    Then El usuario debería poder ver su usuario "Demo2010"

  @CredencialesInvalidos
  Scenario Outline: Iniciar sesión con credenciales no válidas
    When El usuario ingresa el nombre de usuario como "<username>" y la contraseña como "<password>"
    Then El usuario debería poder ver el mensaje de error "<errorMessage>"
    Examples: 
      | username | password  | errorMessage    |
      | Admin    | admin12$$ | Wrong password. |
      | Admin    | admin123  | Wrong password. |
      | Admin    | xyz$$     | Wrong password. |

  @FaltaUsuarioOClave
  Scenario Outline: Iniciar sesión con nombre de usuario o contraseña vacio
    When El usuario ingresa el nombre de usuario como "<username>" y la contraseña como "<password>"
    Then El usuario debería poder ver un mensaje "Please fill out Username and Password."
    Examples: 
      | username | password  |
      |          | admin123  |
      | Demo2010 |           |

