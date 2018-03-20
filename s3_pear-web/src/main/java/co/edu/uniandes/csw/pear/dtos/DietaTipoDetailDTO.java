/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;
//TODO: borrar loque no se necesita

import co.edu.uniandes.csw.pear.entities.CocinaEntity;
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

    private CuentaCobroDTO cuentaCobro;

    private List<SemanaDTO> semanas;

    /**
     * Constructo de DietaTipoDetailDTO
     */
    public DietaTipoDetailDTO() {
        super();
    }

    public DietaTipoDetailDTO(DietaTipoEntity entity) {
        super(entity);
//TODO: entity puede ser null
        if (entity.getCuentaCobro() != null) {
            this.cuentaCobro = new CuentaCobroDTO(entity.getCuentaCobro());
        } else {
            this.cuentaCobro = null;
        }

        if (entity.getSemanas() != null) {
            this.semanas = new ArrayList<>();
            entity.getSemanas().forEach(semanita -> {
                this.semanas.add(new SemanaDTO(semanita));
            });
        } else {
            this.semanas = new ArrayList<>();
        }

    }

    public CuentaCobroDTO getCuentaCobro() {
        return cuentaCobro;
    }

    public void setCuentaCobro(CuentaCobroDTO cuentaCobro) {
        this.cuentaCobro = cuentaCobro;
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
        if (this.getCuentaCobro() != null) {
            en.setCuentaCobro(this.getCuentaCobro().toEntity());
        }
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
