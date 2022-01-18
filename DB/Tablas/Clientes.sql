CREATE TABLE clientes (
	id integer PRIMARY KEY NOT NULL, 
	nombre varchar2(50) NOT NULL, 
	direccion varchar2(30) NOT NULL, 
	telefono NUMBER(10) NOT NULL, 
	mora NUMBER(1), 
	promedio number(10,2), 
	ciudad_id integer NOT NULL, 
	plan_id integer NOT NULL, 
	actividad_id integer NOT NULL, 
	calificacion_id integer NOT NULL, 
	promo_id integer);
