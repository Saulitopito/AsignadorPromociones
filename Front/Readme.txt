#Readme del Front End construido en Angular

Para la construcción de la interfaz web de la aplicación se hizo uso de Angular como Framework para la creación y 
administración de las vistas del Front End.

Adicionalmente, se incluyó en el proyecto de Angular el uso de Angular Material para facilitar el desarrollo de la parte
visual de la interfaz, una librería de Excel para la posibilidad de descarga de un reporte de asignaciones con extensión
.xlsx, y Bootstrap como kit de diseño adicional a Angular Material.

En esta carpeta (Front) sólo se ubica la carpeta src del proyecto en Angular, la cual contiene el detalle de los 
componentes, servicios, clases e imágenes utilizados en el desarrollo de la interfaz web, por lo que para poder hacer uso 
de él es necesario realizar los siguientes pasos:

##1. Crear un nuevo proyecto de Angular, haciendo uso del comando 
     ng new Nombre-Del-Proyecto

##2. Instalar en nuestro proyecto los complementos necesarios para que las funcionalidades adicionales, como Angular 
Material, funcionen correctamente. Para ello ns ubicamos en el proyecto y se ejecutan los siguientes comandos:

	- 'npm install --save @angular/material @angular/cdk @angular/animations hammerjs'
	  Para tener Angular Material y funcionalidades visuales adicionales en nuestra aplicación
	- 'npm install xlsx'
	  Para poder crear documentos de tipo Excel, con extensión .xlsx
	- 'npm install file-saver'
	  Para poder descargar los archivos .xlsx generados desde la aplicación
	- 'npm install ngx-pagination --save'
	  Para poder hacer uso de la paginación de las tablas

##3. Incluir los estilos de Bootstrap para la aplicación. Para ello se debe acceder a la siguiente ruta y se copia el 
vínculo de estilos de Bootstrap: https://getbootstrap.com/docs/4.3/getting-started/introduction/
Una vez obtenido el vínculo de estilos CSS de Bootstrap, se debe ubicar el archivo *index.html* en nuestro proyecto
Angular, y en la sección <head> pegar dicho vínculo.

##4. Finalmente, reemplazar la carpeta *src* del proyecto Angular recién creado, con la carpeta *src* de nuestra 
aplicación.

Tras realizar estos pasos, ya la interfaz web es funcional.

Para dar más detalle sobre el contenido de nuestra aplicación Front End, se detallará acontinuación la composición de la
misma:

##En la carpeta *assets* de la carpeta *src* se encuentran las imágenes que son usadas en la vista principal de la 
aplicación y la en la barra de navegación.

##En la carpeta *app* de la carpeta *src* encontraremos principalmente la siguiente información:

###General:
En esta sección se encuentran los siguientes componentes:
	- principal: componente en donde se define la página principal de la aplicación web
	- header: componente en donde se define la barra de navegación de la apliacción web, que permite el acceso a los
		  3 módulos que la componen: Administración de Promociones, Asignación de Promociones y Reporte de 
		  Asignaciones, así como poder volver a la vista principal
	- footer: componente en donde se define el pie de página de la aplicación web

###Promociones:
En esta sección se encuentran los siguientes componentes:
	- listar-promociones: componenete en donde se listan las promociones existentes, y se definen los botones de acceso
			      a las opciones de crear, editar o eliminar una promoción
	- crear-promocion: componente en donde se pueden crear promociones haciendo uso de un formulario, cuyos campos
			   son todos obligatorios
	- actualizar-promocion: componente en donde se puede modificar la promoción selecciona haciendo uso del mismo
				formulario de creación, pero que en este caso se inicia con los campos ya cargados con la
				información actual de la promoción en cuestión
	- dialogo-eliminar: componente en donde se define una ventana emergente que permite confirmar el proceso de 
			    eliminación de una promoción, o cancelarlo en caso contrario
	- dialogo-carga-creacion: componente en donde se define una ventana emergente que muestra temporalmente un
				  mensaje informativo de que la promoción se está creando
	- dialogo-carga-actualizacion: componente en donde se define una ventana emergente que muestra temporalmente un
				       mensaje informativo de que la promoción se está creando

###Asignacion:
En esta sección se encuentran los siguientes componentes:
	- asignaciones: componente en donde se puede hacer la asignación de las promociones a los clientes que cumplen con
			las condiciones establecidas
	- dialogo-carga: componente en donde se define una ventana emergente que muestra un mensaje de asignación de 
			 promociones, y que inhabilita el uso de la aplicación mientras se termina dicho proceso

###Reportes:
En esta sección se encuentra el siguiente componente:
	- reporte: componente en donde se puede consultar por promoción, qué clientes se encuentran asignados a ésta, y 
		   permite generar un documento en Excel con dicha información

###Modelos:
En esta sección se encuentran todas las clases que corresponden a los DTO recibidos desde el Back End, que permiten el 
mapeo de la información recibida, para que pueda ser utilizada en la interfaz web. Del mismo modo, cada clase define cómo 
debe componerse un objeto que viajará desde el Front End a través de la API Restful, para interactuar con nuestra base de 
datos.

Los modelos existentes son:
	- actividad.ts
	- calificacion.ts
	- ciudad.ts
	- cliente-promo.ts
	- plan.ts
	- promocion-asignada.ts
	- promociones.ts

###Servicios:
En esta sección se encuentran los servicios necesarios para hacer uso de los métodos HTTP, que traigan o envíen información
desde y hacia el Back End por medio de la API Restful, según la configuración de esta última.

Entre los servicios se encuentran:
	- actividades-service.service.ts
	- calificaciones-service.service.ts
	- ciudades-service.service.ts
	- general-service.service.ts
	- planes-service.service.ts
	- promociones-service.service.ts
	- reporte-service.service.ts

El servicio general-service.service.ts es un tanto especial, ya que no gesta ninguna comunicación con el Back End, sino
que permite conectar componentes de Angular, permitiendo el paso de información entre ellos.

###material
En esta sección se encuentra un módulo que centraliza todas las librerías de Angular Material utilizadas en la interfaz
web.