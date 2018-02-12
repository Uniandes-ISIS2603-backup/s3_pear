/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.CocinaEntity;
import co.edu.uniandes.csw.pear.entities.DietaTipoEntity;
import java.util.List;

/**
 *
 * @author js.garcial1
 */
public class DietaTipoDetailDTO extends DietaTipoDTO {
    
    private CuentaCobroDTO cuentaCobro;
    
    private List<SemanaDTO> semanas;
    
    
    /**
     * Constructo de DietaTipoDetailDTO 
     */
    public DietaTipoDetailDTO( ) {
        super();
    }
    
    public DietaTipoDetailDTO( DietaTipoEntity entity ) {
        super(entity);
        this.cuentaCobro = new CuentaCobroDTO(entity.getCuentaCobro());
    }
    
  
}
