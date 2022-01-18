--Cálculo de promedio
CREATE OR REPLACE PROCEDURE promedio IS 
	prom NUMBER;
	CURSOR ids IS SELECT /*+ ALL_ROWS */ id FROM CLIENTES;
BEGIN
	FOR cliente IN ids LOOP
		--Cálculo del promedio de pagos
		SELECT /*+ ALL_ROWS INDEX(pagos, cliente_id) */ AVG(valor) INTO prom FROM PAGOS WHERE CLIENTE_ID = cliente.id;
		IF prom IS NULL THEN
			CONTINUE;
		END IF;
		--Actualización del promedio de pagos
		UPDATE CLIENTES SET PROMEDIO = prom WHERE ID = cliente.id;
	END LOOP;
	COMMIT;
EXCEPTION 
	WHEN no_data_found THEN
		DBMS_OUTPUT.PUT_LINE('Aun no hay clientes definidos');
		ROLLBACK;
END;
