-- Promociones b�sicas (5)
INSERT INTO PROMOCIONES (ID, NOMBRE, FECHA_INICIO, FECHA_FIN, DESCUENTO, MIN_VAL, ESTADO) VALUES (sec_promo.nextval, 'Promo1', (select TO_date('28/02/2021', 'DD/MM/YYYY') FROM dual), (select TO_date('31/03/2021', 'DD/MM/YYYY') FROM dual), 0.1, 80000, 1);
INSERT INTO PROMO_ACTIVIDAD (ID, PROMO_ID, ACTIVIDAD_ID) VALUES (sec_promo_actividad.nextval, 1, 3);
INSERT INTO PROMO_PLAN (ID, PROMO_ID, PLAN_ID) VALUES (sec_promo_plan.nextval, 1, 1);
INSERT INTO PROMO_CIUDAD (ID, PROMO_ID, CIUDAD_ID) VALUES (sec_promo_ciudad.nextval, 1, 1);
INSERT INTO PROMO_CALIFICACION (ID, PROMO_ID, CALIFICACION_ID) VALUES (sec_promo_calificacion.nextval, 1, 1);

INSERT INTO PROMOCIONES (ID, NOMBRE, FECHA_INICIO, FECHA_FIN, DESCUENTO, MIN_VAL, ESTADO) VALUES (sec_promo.nextval, 'Promo2', (select TO_date('28/02/2021', 'DD/MM/YYYY') FROM dual), (select TO_date('30/04/2021', 'DD/MM/YYYY') FROM dual), 0.2, 100000, 1);
INSERT INTO PROMO_ACTIVIDAD (ID, PROMO_ID, ACTIVIDAD_ID) VALUES (sec_promo_actividad.nextval, 2, 2);
INSERT INTO PROMO_ACTIVIDAD (ID, PROMO_ID, ACTIVIDAD_ID) VALUES (sec_promo_actividad.nextval, 2, 4);
INSERT INTO PROMO_PLAN (ID, PROMO_ID, PLAN_ID) VALUES (sec_promo_plan.nextval, 2, 2);
INSERT INTO PROMO_CIUDAD (ID, PROMO_ID, CIUDAD_ID) VALUES (sec_promo_ciudad.nextval, 2, 4);
INSERT INTO PROMO_CIUDAD (ID, PROMO_ID, CIUDAD_ID) VALUES (sec_promo_ciudad.nextval, 2, 3);
INSERT INTO PROMO_CIUDAD (ID, PROMO_ID, CIUDAD_ID) VALUES (sec_promo_ciudad.nextval, 2, 7);
INSERT INTO PROMO_CALIFICACION (ID, PROMO_ID, CALIFICACION_ID) VALUES (sec_promo_calificacion.nextval, 2, 1);

INSERT INTO PROMOCIONES (ID, NOMBRE, FECHA_INICIO, FECHA_FIN, DESCUENTO, MIN_VAL, ESTADO) VALUES (sec_promo.nextval, 'Promo3', (select TO_date('05/03/2021', 'DD/MM/YYYY') FROM dual), (select TO_date('05/04/2021', 'DD/MM/YYYY') FROM dual), 0.15, 70000, 1);
INSERT INTO PROMO_ACTIVIDAD (ID, PROMO_ID, ACTIVIDAD_ID) VALUES (sec_promo_actividad.nextval, 3, 5);
INSERT INTO PROMO_PLAN (ID, PROMO_ID, PLAN_ID) VALUES (sec_promo_plan.nextval, 3, 4);
INSERT INTO PROMO_PLAN (ID, PROMO_ID, PLAN_ID) VALUES (sec_promo_plan.nextval, 3, 3);
INSERT INTO PROMO_CIUDAD (ID, PROMO_ID, CIUDAD_ID) VALUES (sec_promo_ciudad.nextval, 3, 2);
INSERT INTO PROMO_CIUDAD (ID, PROMO_ID, CIUDAD_ID) VALUES (sec_promo_ciudad.nextval, 3, 6);
INSERT INTO PROMO_CALIFICACION (ID, PROMO_ID, CALIFICACION_ID) VALUES (sec_promo_calificacion.nextval, 3, 4);
INSERT INTO PROMO_CALIFICACION (ID, PROMO_ID, CALIFICACION_ID) VALUES (sec_promo_calificacion.nextval, 3, 3);

INSERT INTO PROMOCIONES (ID, NOMBRE, FECHA_INICIO, FECHA_FIN, DESCUENTO, MIN_VAL, ESTADO) VALUES (sec_promo.nextval, 'Promo4', (select TO_date('01/03/2021', 'DD/MM/YYYY') FROM dual), (select TO_date('31/03/2021', 'DD/MM/YYYY') FROM dual), 0.25, 200000, 1);
INSERT INTO PROMO_ACTIVIDAD (ID, PROMO_ID, ACTIVIDAD_ID) VALUES (sec_promo_actividad.nextval, 4, 2);
INSERT INTO PROMO_ACTIVIDAD (ID, PROMO_ID, ACTIVIDAD_ID) VALUES (sec_promo_actividad.nextval, 4, 3);
INSERT INTO PROMO_ACTIVIDAD (ID, PROMO_ID, ACTIVIDAD_ID) VALUES (sec_promo_actividad.nextval, 4, 4);
INSERT INTO PROMO_PLAN (ID, PROMO_ID, PLAN_ID) VALUES (sec_promo_plan.nextval, 4, 1);
INSERT INTO PROMO_PLAN (ID, PROMO_ID, PLAN_ID) VALUES (sec_promo_plan.nextval, 4, 2);
INSERT INTO PROMO_CIUDAD (ID, PROMO_ID, CIUDAD_ID) VALUES (sec_promo_ciudad.nextval, 4, 1);
INSERT INTO PROMO_CIUDAD (ID, PROMO_ID, CIUDAD_ID) VALUES (sec_promo_ciudad.nextval, 4, 3);
INSERT INTO PROMO_CIUDAD (ID, PROMO_ID, CIUDAD_ID) VALUES (sec_promo_ciudad.nextval, 4, 5);
INSERT INTO PROMO_CIUDAD (ID, PROMO_ID, CIUDAD_ID) VALUES (sec_promo_ciudad.nextval, 4, 6);
INSERT INTO PROMO_CALIFICACION (ID, PROMO_ID, CALIFICACION_ID) VALUES (sec_promo_calificacion.nextval, 4, 1);

INSERT INTO PROMOCIONES (ID, NOMBRE, FECHA_INICIO, FECHA_FIN, DESCUENTO, MIN_VAL, ESTADO) VALUES (sec_promo.nextval, 'Promo5', (select TO_date('01/04/2021', 'DD/MM/YYYY') FROM dual), (select TO_date('01/06/2021', 'DD/MM/YYYY') FROM dual), 0.1, 90000, 1);
INSERT INTO PROMO_ACTIVIDAD (ID, PROMO_ID, ACTIVIDAD_ID) VALUES (sec_promo_actividad.nextval, 5, 1);
INSERT INTO PROMO_PLAN (ID, PROMO_ID, PLAN_ID) VALUES (sec_promo_plan.nextval, 5, 3);
INSERT INTO PROMO_CIUDAD (ID, PROMO_ID, CIUDAD_ID) VALUES (sec_promo_ciudad.nextval, 5, 7);
INSERT INTO PROMO_CIUDAD (ID, PROMO_ID, CIUDAD_ID) VALUES (sec_promo_ciudad.nextval, 5, 2);
INSERT INTO PROMO_CALIFICACION (ID, PROMO_ID, CALIFICACION_ID) VALUES (sec_promo_calificacion.nextval, 5, 4);
INSERT INTO PROMO_CALIFICACION (ID, PROMO_ID, CALIFICACION_ID) VALUES (sec_promo_calificacion.nextval, 5, 3);
INSERT INTO PROMO_CALIFICACION (ID, PROMO_ID, CALIFICACION_ID) VALUES (sec_promo_calificacion.nextval, 5, 2);
INSERT INTO PROMO_CALIFICACION (ID, PROMO_ID, CALIFICACION_ID) VALUES (sec_promo_calificacion.nextval, 5, 1);