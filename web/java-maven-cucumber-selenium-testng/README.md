## Requisitos Previos
Antes de utilizar este proyecto, solo necesita tener JDK 11 y Maven instalado en su computadora.

https://maven.apache.org/download.cgi

https://www.oracle.com/pe/java/technologies/javase/jdk11-archive-downloads.html

## Clonación del Proyecto
Abra su terminal, ubiquese en un carpeta e ingrese el command line de git
```
git clone https://github.com/fromeroc9/Challenge
cd Challenge/web/java-maven-cucumber-selenium-testng
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

En su terminal escriba el siguiente comando, si usa windows agrege "--%" despues de clean. @all hace referencia a cualquier tag mencionado en la parte superior.
```
mvn test clean -Dcucumber.filter.tags="@all"
```
Si desea ejecutar todo escriba el siguiente comando
```
mvn test clean -Dcucumber.filter.tags="@all"
or
mvn test
```

## Reportes
Se dejan los reportes con Cucumber Master y Cucumber Report.
Su ubicación en el proyecto esta en el directorio principal

1. ./reporte/cucumber-html-report.html
2. ./reporte/cucumber-html-reports/overview-features.html


