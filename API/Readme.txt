#Readme de la API Restful

Para la creación de la API se hizo uso de Spring Tools como Framework de Java, en donde se implementó el ORM JPA para la 
mayoría de las conexiones con la base de datos, así como JDBC para la ejecución del procedimiento de asignación de 
promociones creado en Oracle DB, y JPQl para los relacionado con el reporte de asignaciones.

En la carpeta *Proyecto Saul*, que hace parte a su vez de la carpeta JPAAPI, se encuentra toda la información de la API, 
por lo que para hacerla funcionar sólo es necesario descargar o copiar en el equipo de cómputo, la totalidad de los 
componentes de la carpeta, y acceder a ella desde Spring Tools, abriéndola como un proyecto de Spring.

Para activar la API, después de cargada en Spring Tools, sólo basta con seleccionar el proyecto cargado y ejecutarlo
como aplicación de Spring, permitiéndonos la conexión entre el Back End y el Front End.

La API se compone de los siguientes paquetes de Java, los cuales se ubican en la ruta *src/main/java*:

##jpa.promociones: 
En donde se encuentra el ejecutable de la aplicación del Back End.

##jpa.promociones.modelo: 
En donde se definen las entidades, sus relaciones entre ellas y con la base de datos.
El listado de entidades es:
	- ActividadEco
	- Calificacion
	- Ciudades
	- Clientes
	- Pagos
	- PlanComercial
	- ProdCliente
	- Productos
	- PromoActividad
	- PromoCalificacion
	- Promociones
	- PromoCiudad
	- PromoPlan
	- RegistroAsignaciones

##jpa.promociones.DTO: 
En donde se especifican los objetos de transferencia de datos que permiten el envío y recepción de información hacia y 
desde el Front.
Es listado de DTOs es:
	- ActividadDTO
	- CalificacionDTO
	- CiudadDTO
	- ClientePromoDTO
	- PlanDTO
	- PromocionDTO

##jpa.promociones.mapper: 
En donde se detalla el mapeo que se realiza entre entidades y DTOs, de modo que la aplicación se pueda comunicar 
correctamente entre la base de datos y el Front End, podiendo convertir información de entidades en DTOs y viceversa.
El listado de mappers es:
	- ActividadMapper
	- Calificacion
	- CiudadMapper
	- ClienteMapper
	- PlanMapper
	- PromocionMapper

##jpa.promociones.JDBC:
En donde se hace la conexión entre la aplicación y la base de datos por medio de JDBC, y se preparan y ejecutan sentencias
necesarias para hacer el llamado al procedimiento de asignación de promociones definido en PL/SQL en Oracle DB.

##jpa.promociones.repository:
En donde se definen los repositorios del contexto de persistencia para cada tipo de entidad de nuestra aplicación, y en 
donde se definen algunas funciones muy particulares que requieren de ejecución de sentencias SQL nativo o JPQL, para 
definir el correcto funcionamiento de la aplicación.
El listado de repositorios es:
	- ActividadEcoRepository
	- AsignacionesRepository
	- CalificacionRepository
	- CiudadesRepository
	- ClientesRepository
	- PagosRepository
	- PlanComercialRepository
	- ProdClienteRepository
	- ProductosRepository
	- PromoActividadRepository
	- PromoCalificacionRepository
	- PromoCiudadRepository
	- PromoPlanRepository
	- PromocionesRepository

##jpa.promociones.servicios:
En donde se especifican y definen los métodos que se realizarán desde y hacia el Front End, así como desde y hacia la base 
de datos, permitiendo crear, actualizar, eliminar y acceder a registros de información de la aplicación. Se hace uso de 
una interfaz para detallar cuáles serán los métodos obligatorios que se deberán definir para cada tipo de información
que viaje entre las capas de nuestra aplicación; así como una clase que especifica puntualmente cómo será la conformación
de dichos métodos.
El listado de servicios es:
	- ServiciosActividad
	- ServiciosActividadImpl
	- ServiciosCalificacion
	- ServiciosCalificacionImpl
	- ServiciosCiudad
	- ServiciosCiudadImpl
	- ServiciosCliente
	- ServiciosClienteImpl
	- ServiciosPlan
	- ServiciosPlanImpl
	- ServiciosPromociones
	- ServiciosPromocionesImpl

##jpa.promociones.controller:
En donde se detallan las rutas de operación del Back End, así como los métodos HTTP Rest de nuestra API que harán uso de
los diferentes servicios definidos, para administrar la información en base de datos y en el Front End de nuestra 
aplicación.
El listado de controladores es:
	- ActividadController
	- CalificacionController
	- CiudadController
	- ClienteController
	- PlanController
	- PromocionController

##jpa.promociones.swagger:
En donde se especifica la sección de la aplicación en donde se ubican las rutas de la API Restful, para hacer la interfaz 
de ésta.
Esta información se puede consultar al ejecutar la aplicación en Spring Boot e ingresar en la ruta:
http://localhost:8080/swagger-ui.html#/

Adicionalmente, en ruta *src/main/resources*, uno de los archivos importantes a resaltar es el *application.properties*, en
donde se declara la conexión con la base de datos Oracle, así como el usuario y contraseña de acceso a la misma, y demás 
configuración necesaria para que la aplicación se ejecute de la mejora manera posible.