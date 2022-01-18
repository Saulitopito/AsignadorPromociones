CREATE TABLE registro_asignaciones (
	id integer PRIMARY KEY NOT NULL, 
	fecha DATE NOT NULL, 
	cliente_id integer NOT NULL, 
	promo_id integer NOT NULL);