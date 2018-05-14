/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.DietaTipoEntity;
import co.edu.uniandes.csw.pear.entities.SemanaEntity;
import co.edu.uniandes.csw.pear.entities.CalificacionEntity;
import co.edu.uniandes.csw.pear.entities.PersonaEntity;
import co.edu.uniandes.csw.pear.entities.QuejasyReclamosEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * {
 * "id" : 123, "objetivo": "un objetivo", "descripcion": "una descripcion",
 * "cuentaCobro": { "valorAPagar": 23.00 }, "semanas":[ {
 * "fechaLunes":"2012-04-23T18:25:43.511Z", "dias":[ { "SeEnvia": true,
 * "recomendacion": "una recomendacion", "fecha": "2012-04-23T18:25:43.511Z" } ]
 * } ] }
 *
 * @author js.garcial1
 */
public class DietaTipoDetailDTO extends DietaTipoDTO {

    private List<SemanaDTO> semanas;
    private List<CalificacionDTO> calificaciones;
    private List<QuejasyReclamosDTO> quejas;
    private List<PersonaDTO> personas;

    /**
     * Constructo de DietaTipoDetailDTO
     */
    public DietaTipoDetailDTO() {
        super();
    }

    public DietaTipoDetailDTO(DietaTipoEntity entity) {
        super(entity);

        if (entity.getSemanas() != null) {

            semanas = new ArrayList<>();
            for (SemanaEntity semana : entity.getSemanas()) {
                semanas.add(new SemanaDTO(semana));
            }
        }
        else semanas =  new ArrayList<>();
        if (entity.getCalificaciones() != null) {
            calificaciones = new ArrayList<>();
            for (CalificacionEntity entityCalificacion : entity.getCalificaciones()) {
                calificaciones.add(new CalificacionDTO(entityCalificacion));
            }
        }
        else calificaciones = new ArrayList<>();
        if (entity.getQuejas() != null) {
            quejas = new ArrayList<>();
            for (QuejasyReclamosEntity entityQueja : entity.getQuejas()) {
                quejas.add(new QuejasyReclamosDTO(entityQueja));
            }
        }
        else quejas = new ArrayList<>();
        if (entity.getPersonas()!= null) {
            personas = new ArrayList<>();
            for (PersonaEntity persona : entity.getPersonas()) {
                personas.add(new PersonaDTO(persona));
            }
        }
        else personas =  new ArrayList<>();
    }

    @Override
    public DietaTipoEntity toEntity() {
        DietaTipoEntity en = super.toEntity();

        if (this.getCalificaciones() != null) {
            List<CalificacionEntity> calificacionesEntity = new ArrayList<>();
            for (CalificacionDTO dtoCalificacion : getCalificaciones()) {
                calificacionesEntity.add(dtoCalificacion.toEntity());
            }
            en.setCalificaciones(calificacionesEntity);
        }
        if (quejas != null) {
            List<QuejasyReclamosEntity> quejasEntity = new ArrayList<>();
            for (QuejasyReclamosDTO dtoQueja : quejas) {
                quejasEntity.add(dtoQueja.toEntity());
            }
            en.setQuejas(quejasEntity);
        }
        if (this.getSemanas() != null) {
            List<SemanaEntity> sems = new ArrayList<>();
            this.getSemanas().forEach(semanita -> {
                sems.add(semanita.toEntity());
            });
            en.setSemanas(sems);
        }
        
        if (this.getPersonas()!= null) {
            List<PersonaEntity> pers = new ArrayList<>();
            this.getPersonas().forEach(persona -> {
                pers.add(persona.toEntity());
            });
            en.setPersonas(pers);
        }
        
        return en;
    }

    public List<SemanaDTO> getSemanas() {
        return semanas;
    }

    public void setSemanas(List<SemanaDTO> semanas) {
        this.semanas = semanas;
    }

    public List<CalificacionDTO> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificacon(List<CalificacionDTO> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public List<QuejasyReclamosDTO> getQuejas() {
        return quejas;
    }

    public void setQuejas(List<QuejasyReclamosDTO> quejas) {
        this.quejas = quejas;
    }

    public List<PersonaDTO> getPersonas() {
        return personas;
    }

    public void setPersonas(List<PersonaDTO> personas) {
        this.personas = personas;
    }   

}
