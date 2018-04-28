/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;
//TODO: DONE borrar loque no se necesita

import co.edu.uniandes.csw.pear.entities.DietaTipoEntity;
import co.edu.uniandes.csw.pear.entities.SemanaEntity;
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

    /**
     * Constructo de DietaTipoDetailDTO
     */
    public DietaTipoDetailDTO() {
        super();
    }

    public DietaTipoDetailDTO(DietaTipoEntity entity) {
        super(entity);
        if (entity != null) {

            if (entity.getSemanas() != null) {

                semanas = new ArrayList<>();

                for (SemanaEntity semana : entity.getSemanas()) {
                    semanas.add(new SemanaDTO(semana));
                }

            } else {
                this.semanas = new ArrayList<>();
            }

        }

    }



    public List<SemanaDTO> getSemanas() {
        return semanas;
    }

    public void setSemanas(List<SemanaDTO> semanas) {
        this.semanas = semanas;
    }

    @Override
    public DietaTipoEntity toEntity() {
        DietaTipoEntity en = super.toEntity();


        if (this.getSemanas() != null) {
            List<SemanaEntity> sems = new ArrayList<>();
            this.getSemanas().forEach(semanita -> {
                sems.add(semanita.toEntity());
            });
            en.setSemanas(sems);
        }
        return en;
    }

}
