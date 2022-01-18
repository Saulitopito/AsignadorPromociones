import { Actividad } from './actividad';
import { Calificacion } from './calificacion';
import { Ciudad } from './ciudad';
import { Plan } from './plan';
import { Promociones } from './promociones';

export class Clientes {

    idDTO: number;
    nombreDTO: string;
    direccionDTO: string;
    telefonoDTO: number;
    moraDTO: string;
    promedioDTO: number;
    ciudadDTO: Ciudad;
    planDTO: Plan;
    actividadDTO: Actividad;
    calificacionDTO: Calificacion;
    promocionDTO: Promociones;

}
