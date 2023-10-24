## Requisitos Previos
Antes de utilizar este proyecto, solo necesita tener node JS y Cypress instalado en su computadora.

https://nodejs.org/es/download

https://docs.cypress.io/guides/getting-started/installing-cypress

## Clonación del Proyecto
Abra su terminal, ubiquese en un carpeta e ingrese el command line de git
```bash
git clone https://github.com/fromeroc9/Challenge
cd Challenge/web/typescript-cucumber-cypress
```

## Ejecución por CLI
Se escribieron 5 features, se dejan los tags disponible
1. AddCart.feature
    - @AddCart
    - @AgregaProductoSesionActiva 
    - @AgregaProductoSesionInactiva
2. E2E.feature
    - @e2e
3. LogIn.feature
    - @Login
    - @CredencialesValidos
    - @CredencialesInvalidos
    - @FaltaUsuarioOClave
4. LogOut.feature
    - @LogOut
    - @CerrarSesion
5. SigUp.feature
    - @Signup
    - @UsuarioValido @UsuarioInvalido @UsuarioVacio @ClaveVacio

En su terminal escriba el siguiente comando. Se hace referencia @alls a todos los tags mencionado anteriormente.

```java
// Ejecución Iterativa
npx cypress open

// Ejecución Headless
npx cypress run

// Generar Reporte despues de ejecución
npm run report:mulple
npm run report:simple

// Ejecución por tags
npx cypres run tags="@alls"
```

## Reportes
Se dejan los reportes con Cucumber, Multiple Report Cucumber, Simple Report Cucumber.
Su ubicación en el proyecto esta en el directorio principal

1. ./cypress/target/reports/multiple-reporte/index.html
2. ./cypress/target/reports/simple-repot/simple-report.html
3. ./cypress/target/cucumber/cucumber-report.html

## Video
Se dejan como evidencia los videos de ejecución por CLI ubicado en
cypress/target/video.

## Screenshots
Se dejan como evidencia solo una captura de evidencia el motivo es con los videos ya pesa demasiado el proyecto.