--Job autom�tico para la desasignaci�n de promociones
BEGIN
  SYS.DBMS_SCHEDULER.CREATE_JOB
    (
       job_name        => 'desasignacion_promociones'
      ,start_date      => to_date('16/03/2021 17:00:00', 'DD/MM/YYYY HH24:MI:SS')
      ,repeat_interval => 'FREQ=DAILY;BYHOUR=00;'
      ,end_date        => NULL
      ,job_type        => 'STORED_PROCEDURE'
      ,job_action      => 'desasignarPromociones'
      ,comments        => 'Validaci�n diaria de qu� promociones dejan de estar en vigencia, y realiza la desasignaci�n de dichas promociones a los clientes que las tengan asignadas.'
      ,enabled         => TRUE
      ,auto_drop       => FALSE
    );
END;
