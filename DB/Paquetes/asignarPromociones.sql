--Asignación de promociones
CREATE OR REPLACE PROCEDURE asignarPromociones IS 
	CURSOR ids IS SELECT /*+ ALL_ROWS */ id, mora, PROMO_ID FROM CLIENTES;
	--Identifica las promociones asignables por fechas, ciudad, actividad económica, calificación y plan comercial 
	CURSOR asignables( cli_id NUMBER ) IS SELECT /*+ LEADING(promociones) INDEX(promociones, fechas) INDEX(promo_calificacion, promo_cal) INDEX(promo_ciudad, promo_ciudad) INDEX(promo_plan, promo_plan) INDEX(promo_actividad, promo_act) INDEX(promociones, estado) */ DISTINCT promociones.ID, promociones.DESCUENTO FROM PROMOCIONES JOIN PROMO_ACTIVIDAD ON promociones.ID = promo_actividad.PROMO_ID JOIN PROMO_CALIFICACION ON promociones.ID = promo_calificacion.PROMO_ID JOIN PROMO_CIUDAD ON promociones.ID = promo_ciudad.PROMO_ID JOIN PROMO_PLAN ON promociones.ID = promo_plan.PROMO_ID JOIN CLIENTES ON clientes.ACTIVIDAD_ID = promo_actividad.ACTIVIDAD_ID AND clientes.CALIFICACION_ID = promo_calificacion.CALIFICACION_ID AND clientes.CIUDAD_ID = promo_ciudad.CIUDAD_ID AND clientes.PLAN_ID = promo_plan.PLAN_ID AND clientes.PROMEDIO >= promociones.MIN_VAL WHERE promociones.ESTADO = 1 AND TRUNC(promociones.FECHA_INICIO) <= (SELECT CURRENT_DATE FROM dual) AND TRUNC(promociones.FECHA_FIN) >= (SELECT CURRENT_DATE FROM dual) AND clientes.id = cli_id;
	promoAsigna NUMBER;
	promoAux DATE;
	fechaBase DATE;
	asignaTotal NUMBER;
	asignaPosible NUMBER;
	beneficio NUMBER;
	TYPE info IS TABLE OF ids%ROWTYPE;
	info_cliente info;
BEGIN 
	promedio();
	OPEN ids;
	LOOP
		FETCH ids BULK COLLECT INTO info_cliente LIMIT 25;
		FOR i IN 1..info_cliente.count LOOP
			promoAsigna := 0;
			fechaBase := TO_DATE('19113000', 'ddMMyyyy');
			beneficio := 0;
			--Si el cliente está en mora, no aplica promoción
			IF info_cliente(i).mora != 0 THEN
				CONTINUE;
			END IF;
			--Si el cliente ya tiene una promoción asignada, no aplica otra promoción
			IF info_cliente(i).promo_id > 0 THEN
				CONTINUE;
			ELSE
				FOR opcion IN asignables(info_cliente(i).id) LOOP
					--Si no hay promociones asignables, no hace nada
					EXIT WHEN (opcion.id IS NULL);
					--Verifica cuántas veces ha sido asignada la promoción en cuestión al cliente en cuestión, para el año en curso
					SELECT /*+ ALL_ROWS INDEX(registro_asignaciones, info_registro) */ count(id) INTO asignaTotal FROM REGISTRO_ASIGNACIONES WHERE PROMO_ID = opcion.id AND CLIENTE_ID = info_cliente(i).id AND EXTRACT(YEAR FROM fecha) = (SELECT EXTRACT(YEAR FROM sysdate) FROM dual);
					--Valida cuántas veces máximo puede asignar la promoción en cuestión al cliente en cuestión, según actividad económica
					SELECT /*+ ALL_ROWS */ actividad_eco.NUM_MAX INTO asignaPosible FROM ACTIVIDAD_ECO JOIN CLIENTES ON clientes.ACTIVIDAD_ID = ACTIVIDAD_eco.ID WHERE clientes.ID = info_cliente(i).id;
					--Si el cliente no puede volver a contar con la promoción en cuestión, no asigna promoción
					IF asignaTotal >= asignaPosible THEN
						promoAsigna := 0;
						CONTINUE;
					END IF;
					--Toma la fecha de inicio de vigencia de la promoción en cuestión, para verificar en caso de obtener el mismo beneficio con 2 promociones
					SELECT /*+ INDEX(promociones, fecha_inicio) */ fecha_inicio INTO promoAux FROM PROMOCIONES WHERE id = opcion.id;
					----Si el descuento de una promoción es mayor a otra posible, contempla la de mayor beneficio
					IF opcion.descuento > beneficio THEN
						promoAsigna := opcion.id;
						beneficio := opcion.descuento;
						fechabase := promoAux;
						CONTINUE;
					--Si el descuento de 2 promociones es el mismo, verifica las fechas de inicio de vigencia de dichas promociones, para asignar la más antigua
					ELSIF opcion.descuento = beneficio THEN
						IF Trunc(promoAux) < fechaBase THEN
							fechabase := promoAux;
							promoAsigna := opcion.id;
						END IF;
					END IF;
				END LOOP;
				--Si la promoción es asignable, y cumple con las condiciones de asignación, la asigna; en caso contrario no la asigna
				IF promoAsigna != 0 THEN 
					UPDATE CLIENTES SET promo_id = promoAsigna WHERE id = info_cliente(i).id;
					INSERT INTO REGISTRO_ASIGNACIONES (id, fecha, cliente_id, promo_id) VALUES (sec_asigna.nextval, (select CURRENT_TIMESTAMP from dual), info_cliente(i).id, promoAsigna);
				END IF;
			END IF;
		END LOOP;
		EXIT WHEN info_cliente.count = 0;
	END LOOP;
	CLOSE ids;
	--Calcula el nuevo valor a pagar por el cliente, tras hacer el proceso de asignaciones
	VALOR_REAL();
	COMMIT;
EXCEPTION
	WHEN no_data_found THEN
		DBMS_OUTPUT.PUT_LINE('Error inesperado por ausencia de valores');
		ROLLBACK;
END;