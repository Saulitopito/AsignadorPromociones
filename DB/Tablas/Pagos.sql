CREATE TABLE pagos (
	id integer PRIMARY KEY NOT NULL, 
	fecha DATE NOT NULL, 
	valor NUMBER(10,2), 
	cliente_id integer NOT NULL);