#Readme de la Aplicación

##Detalles de la Aplicación

Nuestra aplicación permite la conexión entre una base de datos y una interfaz web a través de una API Restful construida en 
JPA, haciendo uso del diseño Modelo-Vista-Controlador, en donde el modelo es nuestra base de datos generada y administrada 
en Oracle DB, el controlador se gestiona por medio del Framework Spring Tools y está escrito en lenguaje Java, haciendo la 
definición e implementación de una API en JPA que requiere de su configuración a través de Gradle, para gestar la base de 
datos. Finalmente la vista se define y estructura en Angular haciendo uso del lenguaje TypeScript.

##Objetivo y Función de la Aplicación:

A manera explicativa, esta aplicación permite la administración y asignacón de promociones para la compañia Tele-Iquitos, 
la cual busca por medio de dichas promociones la fidelización de sus clientes, dándoles descuentos en los pagos mensuales
de sus servicios, siempre y cuando dichos clientes cumplan con las siguientes condiciones:

	- Las promociones solo se asignan a los clientes que se encuentren al día con sus pagos, es decir, para aquellos 
	  clientes que no tengan un saldo vencido.
	- Una promoción solo se puede asignar una vez al cliente durante la vigencia de la promoción.
	- La empresa saca promociones de forma mensual.
	- Si varias promociones aplican para un cliente, se le debe asignar aquella que sea más favorable (en valor del 
	  descuento). En caso de que más de una promoción tenga el mismo descuento, debe asignarse la promoción de 
	  vigencia más antigua.
	- Una misma promoción puede estar vigente en diferentes periodos en un año. La empresa quiere que el número de 
	  veces por año que una misma promoción se asigne a un cliente se permita diferenciar de acuerdo a la actividad 
	  económica del cliente.

##Especificaciones de la Aplicación:

Para poder hacer uso, adminitración y control de nuestra aplicación es necesario que se haga la instalación de los 
siguientes componentes:

	- Oracle Database (versión 18C Express)
	- DBeaver (versión 7.3.3) como herramienta para la administración de la base de datos
	- Java (JDK versión 11.0.10 y JRE)
	- NodeJS (versión 14.15.4)
	- Spring Tools (versión 4.4.9.0)
	- Gradel (versión 6.7.1)
	- Angular (versión 10.2.1)

Nuestro primer paso es crear la base de datos, especificando el esquema, TableSpace y DataFile a utilizar, así como 
la creación de las tablas a utilizar y los procedimientos a implementar. Adicionalmente, se deberá especificar las 
referencias y conexiones entre las tablas.

Para la creación de la base de datos por favor referirse al archivo Readme.txt que se encuentra en la carpeta DB, así como 
consultar la totalidad del contendio de dicha carpeta.

La API se encuentra el carpeta llamada API y contiene toda la información requerida para su implementación. Sólo será 
necesario descargar el proyecto en su totalidad y cargarlo, abrirlo o leerlo desde el Framework Spring Boot. También
se ha definido un archivo Readme.txt para entender con mayor claridad la API Restful a utilizar.

Finalmente, en cuanto a la parte visual de nuestra aplicación, consultar el contenido de la carpeta Front en donde 
encontrará todo lo relacionado con Angular. Para mayor detalle, consultar el archivo Readme.txt que se ubica en dicha
carpeta.

Es importante recordar que para que la conexión entre Front y base de datos sea efectiva, es necesario que la API se 
encuentre corriendo desde Spring Tools, así como también que el servidor de Angular debe estar activo haciendo uso del 
comando 'ng serve'.

Los servidores locales en donde corren estas dos herramientas son:

http://localhost:8080/ - API Restful JPA
http://localhost:4200/ - Angular

En la API se hizo uso de Swagger para realizar el contrato que gesta los métodos HTTP y las rutas funcionales de la misma.
Esta información se puede consultar al ejecutar la aplicación en Spring Boot e ingresar en la ruta:
http://localhost:8080/swagger-ui.html#/