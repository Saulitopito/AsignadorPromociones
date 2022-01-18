--Desasignar promociones
CREATE OR REPLACE PROCEDURE desasignarPromociones IS 
	CURSOR ids IS SELECT /*+ ALL ROWS INDEX(clientes, promo_id) */ ID, PROMO_ID FROM CLIENTES WHERE PROMO_ID IS NOT NULL;
	hoy DATE;
	fecha_promo DATE;
BEGIN
	--Toma la fecha del día para verificar si la promoción ya venció y desasignarla
	SELECT CURRENT_TIMESTAMP INTO hoy FROM dual;
	FOR cliente IN ids LOOP
		SELECT /*+ INDEX(promociones, fecha_fin) */ fecha_fin INTO fecha_promo FROM PROMOCIONES WHERE ID = cliente.promo_id;
		--Si la promoción ya está vencida, la desasigna del cliente en cuestión
		IF hoy >= fecha_promo THEN
			UPDATE CLIENTES SET PROMO_ID = NULL WHERE id = cliente.id;
		END IF;
	END LOOP;
	COMMIT;
EXCEPTION
	WHEN no_data_found THEN
		DBMS_OUTPUT.PUT_LINE('No hay promociones asignadas');
		ROLLBACK;
END;
