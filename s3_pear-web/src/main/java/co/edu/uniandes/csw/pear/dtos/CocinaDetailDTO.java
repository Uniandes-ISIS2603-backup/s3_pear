/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.CocinaEntity;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author js.garcial1
 */
public class CocinaDetailDTO extends CocinaDTO {
    
    private List<DietaTipoDTO> dietas;
    
    /**
     * Constructor CocinaDetail con paramatros
     * @param ubicacion
     * @param capacidad
     * @param dietas 
     */
    public CocinaDetailDTO(  ) {
        super();
    }
    
    public CocinaDetailDTO( CocinaEntity entity ) {
        super(entity);
    }

    public List<DietaTipoDTO> getDietas() {
        return dietas;
    }

    public void setDietas(List<DietaTipoDTO> dietas) {
        this.dietas = dietas;
    }
    
    
    
    
}
