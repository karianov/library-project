# Capa de presentación: Aplicación Web

## Consideraciones tecnológicas

- Proyecto Angular con la versión 11.1.4.

## Entorno de desarrollo y depuración

Este proyecto se desarrolla con el editor de texto [Visual Studio Code](https://code.visualstudio.com/).

## Ejecución local

Si recién se ha clonado este repositorio, basta con ejecutar el comando `npm install` para preparar el entorno de ejecución local. Con el comando `ng serve -o` se ejecuta la aplicación localmente y se abre una ventana del navegador predeterminado con la ejecución.

## Recomendación

- En cuanto a la base de datos, se sugiere utilizar el servidor de base de datos de Oracle en su versión 19c, y correr el [script para el levantamiento de la base de datos](https://github.com/karianov/library-project/blob/main/db/Script.sql).
- En cuanto a la API, se sugiere hacer ejecución en el puerto `8080` del `localhost` para efectos de depuración local, y seguir (o modificar) las configuraciones de conexión a la base de datos que se encuentran en el [archivo de propiedades de la aplicación](https://github.com/karianov/car-center/blob/main/car-center-api/src/main/resources/application.properties).