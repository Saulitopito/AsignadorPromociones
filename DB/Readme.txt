#Readme de la Base de Datos

Para la gestión de la base de datos se hace uso de Oracle DB, junto con DBeaver como herramienta para la administración 
de la base de datos.

En cuanto al contenido de esta sección tenemos:

##Índices:
En esta parte se encuentra el detalle de los índices creados para mejorar el rendimiento de las consultas a nuestra base
de datos, sin incluir las llaves primarias de cada tabla, pues éstos se crean desde el momento en que se define cada una
de ellas.

##Paquetes:
Acá ubicamos lo relacionado con los procedimientos y trabajos programados para que sean ejecutados de manera automática o 
por llamado desde nuestra aplicación, en caso de ser necesario.

Los procedimientos definidos son:

	- promedio: procedimiento que no recibe parámetros y que calcula el promedio de pagos de cada cliente, para que
		    dicha información sea contemplada al momento de hacer la asignación de promociones
	- valor_real: procedimiento que no recibe parámetros y que calcula el nuevo valor a pagar por un cliente por un 
		      su producto, tras la asignación de las promociones, apicando su respectivo porcentaje de descuento
	- asignarPromociones: procedimiento que no recibe parámetros y que se encarga de hacer la validación respectiva
			      a cada cliente existente, para verificar si con sus condiciones a éste se le puede asignar
			      una promoción; y en caso de poder hacer, gestar dicha asignación en la base de datos
	- desasignarPromociones: procedimiento que no recibe parámetros y que de manera programada desasigna las 
				 promociones al cumplir éstas con sus fechas de vigencia
	- quitarPromociones: procedimiento que no recibe parámetros y que elimina todas las asociaciones entre clientes
			     y promociones. Su uso es sólo a manera de ejercicio para simular una desasignación formal
			     de promociones

Para su correcta definición en la base de datos, en necesario que sea seleccionado procedimiento por procedimiento en su 
totalidad, para que la sentencia SQL se ejecute de manera correcta, al momento de crearlos.

Adicionalmente, cuenta con la definición de 3 Jobs o trabajos programados, que se encargan de realizar las siguientes 
funciones:

	- calculo_promedio: cálculo mensual del promedio de pagos de cada cliente, como condición para la asignación de 
			    promociones
	- asignacion_promociones: asignación mensual de las promociones a los clientes que están habilitados para ello
	- desasignacion_promociones: validación diaria de qué promociones dejan de estar en vigencia, para realizar la 
				     desasignación de dichas promociones a los clientes que las tengan asignadas

Cada procedimiento y trabajo está especificado en su propio archivo con extensión .sql, siendo un total de 5 procedimientos
y 3 jobs o trabajos programados.

##Referencias:
En la carpeta de referencias encontraremos todas las relaciones definidas entre las diferentes tablas, haciendo uso de sus 
respectivas llaves foráneas y llaves primarias.

##Tablas:
Acá se especifican las sentencias SQL necesarias para la creación de las tablas que componen nuestra base de datos, y que 
se encargarán de almacenar toda la información de nuestra aplicación.

El cuerpo y estructura de cada tabla estará detallado en su respectivo archivo con extensión .sql.

##Data:
En esta carpeta se encuentra un conjunto de sentencias sugeridas para crear clientes, promociones, pagos de clientes, 
actividades económicas, planes comerciales, ciudades, calificaciones, productos y asignación de productos a clientes, con
el finde poder utilizar esta información en nuestra aplicación

##Sys:
En esta carpeta detallamos la información necesaria para crear el usuario y el espacio en el que se gestionará la base de 
datos de nuestra aplicación.

###Datafile:
Contiene el archivo PROYECTO01.dbf que abarca toda la información de nuestra base de datos. Su capacidad es incremental 
hasta un máximo de 500Mb.

###Permisos:
Acá se detallan y definen los permisos que debe tener el usuario para poder gestionar la base de datos de manera correcta.

###TableSpace:
Especifica la creación y asignación de la unidad de almacenamiento lógico en donde el usuario que gestionará la base de 
datos podrá administrar su capacidad y disponibilidad.

###Usuarios:
Acá se crean los respectivos usuarios o esquemas que gestionarán la base datos.



Para la preparación de la base de datos, inicialmente se crea el usuario o esquema, asignando sus respectivos permisos, y 
posteriormente se crea el TableSpace así como el Datafile que lo compone, y se asigna este TableSpace al usuario creado.
Por último se gestiona la creación de las tablas y sus referencias, así como sus índices, junto con los procedimientos y 
jobs. Se recomienda seguir este orden para evitar inconsistencias con información que aún no existe en nuestra base de 
datos.
