import { Actividad } from './actividad';
import { Calificacion } from './calificacion';
import { Ciudad } from './ciudad';
import { Plan } from './plan';

export class Promociones {

    idDTO: number;
    nombreDTO: string;
    fecha_inicioDTO: Date;
    fecha_finDTO: Date;
    descuentoDTO: number;
    min_valDTO: number;
    actividadDTO: Actividad[];
    calificacionDTO: Calificacion[];
    planDTO: Plan[];
    ciudadDTO: Ciudad[];

    //Constructor necesario para crear el DTO que viaja a la API
    constructor(nombreDTO: string, fecha_inicioDTO: Date, fecha_finDTO: Date, descuentoDTO: number,
                min_valDTO: number, actividadDTO: Actividad[], calificacionDTO: Calificacion[],
                planDTO: Plan[], ciudadDTO: Ciudad[]){
        this.nombreDTO = nombreDTO;
        this.fecha_inicioDTO = fecha_inicioDTO;
        this.fecha_finDTO = fecha_finDTO;
        this.descuentoDTO = descuentoDTO;
        this.min_valDTO = min_valDTO;
        this.actividadDTO = actividadDTO;
        this.calificacionDTO = calificacionDTO;
        this.planDTO = planDTO;
        this.ciudadDTO = ciudadDTO;
    }


}
