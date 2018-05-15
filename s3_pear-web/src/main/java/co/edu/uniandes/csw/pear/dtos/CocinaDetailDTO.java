/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.CocinaEntity;
import co.edu.uniandes.csw.pear.entities.DietaTipoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * {
 * "id": 123, "ubicacion": "Una ubicacion", "capacidad": "una capacidad",
 * "dietas": [
 *
 * {
 * "objetivo": "un objetivo", "descripcion": "una descripcion", "cuentaDeCobro":
 * { "valorAPagar": 23.00 }, "semanas":[ {
 * "fechaLunes":"2012-04-23T18:25:43.511Z", "dias":[ { "SeEnvia": true,
 * "recomendacion": "una recomendacion", "fecha": "2012-04-23T18:25:43.511Z" } ]
 * } ] }
 *
 *
 * ]
 * }
 *
 * @author js.garcial1
 */
public class CocinaDetailDTO extends CocinaDTO {

    private List<DietaTipoDTO> dietas;

    /**
     * Constructor CocinaDetail con paramatros
     */
    public CocinaDetailDTO() {
        super();
    }

    public CocinaDetailDTO(CocinaEntity entity) {
        super(entity);

        if (entity != null) {

            if (entity.getDietas() != null) {

                dietas = new ArrayList<>();

                for (DietaTipoEntity dieta : entity.getDietas()) {

                    dietas.add(new DietaTipoDTO(dieta));

                }

            } else {
                this.dietas = new ArrayList<>();
            }
        }
    }

    public List<DietaTipoDTO> getDietas() {
        return dietas;
    }

    public void setDietas(List<DietaTipoDTO> dietas) {
        this.dietas = dietas;
    }

    @Override
    public CocinaEntity toEntity() {
        CocinaEntity en = super.toEntity();
        if(en != null){
            if(this.getDietas() !=  null){
                List<DietaTipoEntity> dts = new ArrayList<>();
                for(DietaTipoEntity y: en.getDietas()){
                    dts.add(y);
                }
                en.setDietas(dts);
            }
        }
        return en;
    }
}
