--Job automático para el cálculo del promedio de pagos del cliente a fin de mes
BEGIN
  SYS.DBMS_SCHEDULER.CREATE_JOB
    (
       job_name        => 'calculo_promedio'
      ,start_date      => to_date('17/03/2021 17:00:00', 'DD/MM/YYYY HH24:MI:SS')
      ,repeat_interval => 'FREQ=MONTHLY;BYMONTHDAY=-1;BYHOUR=00;'
      ,end_date        => NULL
      ,job_type        => 'STORED_PROCEDURE'
      ,job_action      => 'promedio'
      ,comments        => 'Cálculo mensual del promedio de pagos de cada cliente, como condición para la asignación de promociones.'
      ,enabled         => TRUE
      ,auto_drop       => FALSE
    );
END;