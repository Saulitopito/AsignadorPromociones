--Quitar todas las promociones
CREATE OR REPLACE PROCEDURE quitarPromociones IS
	promo NUMBER;
	CURSOR ids IS SELECT /*+ ALL_ROWS */ id FROM CLIENTES;
BEGIN
	FOR cliente IN ids LOOP
		SELECT /*+ ROW_ID(clientes) */ promo_id INTO promo FROM CLIENTES WHERE ID = cliente.id FOR UPDATE;
		IF promo > 0 THEN
			UPDATE CLIENTES SET PROMO_ID = NULL WHERE id = cliente.id;
		ELSE	
			CONTINUE;
		END IF;
	END LOOP;
	COMMIT;
EXCEPTION
	WHEN no_data_found THEN
		DBMS_OUTPUT.PUT_LINE('No hay promociones asignadas');
		ROLLBACK;
END;