CREATE TABLE promociones (
	id integer PRIMARY KEY NOT NULL, 
	nombre varchar2(40) NOT NULL, 
	fecha_inicio DATE NOT NULL, 
	fecha_fin DATE NOT NULL, 
	descuento NUMBER(5,4) NOT NULL, 
	min_val number(15,2) NOT NULL, 
	estado numer(1) NOT NULL, 
	fecha_inactiva DATE);
