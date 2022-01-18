--Job automático para la asignación de promociones
BEGIN
  SYS.DBMS_SCHEDULER.CREATE_JOB
    (
       job_name        => 'asignacion_promociones'
      ,start_date      => to_date('31/03/2021 17:00:00', 'DD/MM/YYYY HH24:MI:SS')
      ,repeat_interval => 'FREQ=MONTHLY;BYMONTHDAY=1;BYHOUR=00;'
      ,end_date        => NULL
      ,job_type        => 'STORED_PROCEDURE'
      ,job_action      => 'asignarPromociones'
      ,comments        => 'Asignación mensual de las promociones a los clientes que etán habilitados para ello'
      ,enabled         => TRUE
      ,auto_drop       => FALSE
    );
END;
