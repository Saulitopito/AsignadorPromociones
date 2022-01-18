CREATE TABLE prod_cliente (
	id integer PRIMARY KEY NOT NULL, 
	valor_ajustado NUMBER(10, 2) NOT NULL, 
	producto_id integer NOT NULL, 
	cliente_id integer NOT NULL);
