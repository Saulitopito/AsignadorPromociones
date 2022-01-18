--Cálculo de valor después de porcentaje
CREATE OR REPLACE PROCEDURE valor_real IS 
	desct NUMBER;
	val NUMBER;
	rel NUMBER;
	CURSOR ids IS SELECT /*+ ALL_ROWS */ id FROM CLIENTES;
BEGIN 
	FOR cliente IN ids LOOP
		SELECT /*+ ROW_ID(clientes) */ PROMO_ID INTO rel FROM clientes WHERE id = cliente.id;
		--Si hay promoción asosiada al cliente, trae el descuento, sino lo pone en 0
		IF rel > 0 THEN
			SELECT /*+ INDEX(clientes, promo_id) INDEX(promociones, dcto) */ promociones.DESCUENTO INTO desct FROM PROMOCIONES JOIN CLIENTES ON clientes.PROMO_ID = promociones.ID WHERE clientes.id = cliente.id FOR UPDATE;
		ELSE
			DESCT := 0;
		END IF;
		--Obtiene el valor del producto del cliente
		SELECT /*+ LEADING(productos) INDEX(productos, val) */ productos.VALOR INTO val FROM PRODUCTOS JOIN PROD_CLIENTE ON prod_cliente.PRODUCTO_ID = productos.ID JOIN CLIENTES ON clientes.ID = prod_cliente.CLIENTE_ID WHERE clientes.id = cliente.id FOR UPDATE;
		--Actualiza el valor real a pagar por el cliente, contemplando el descuento (cuando aplica)
		UPDATE PROD_CLIENTE SET VALOR_AJUSTADO = (val*(1-desct)) WHERE prod_cliente.CLIENTE_ID = cliente.id;
	END LOOP;
	COMMIT;
EXCEPTION
	WHEN no_data_found THEN
		DBMS_OUTPUT.PUT_LINE('Validar la existencia de promociones y clientes');
		ROLLBACK;
END;