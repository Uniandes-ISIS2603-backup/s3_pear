/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;
import co.edu.uniandes.csw.pear.entities.CuentaCobroEntity; 

/**
 *
 * @author jp.campos
 */
public class CuentaCobroDetailDTO extends CuentaCobroDTO {
    
      /**
     * Constructor de CuentaCobroailDTO
     * @param entidad 
     */
    public CuentaCobroDetailDTO(CuentaCobroEntity entidad) {
        super(entidad);
    }
    
    /**
     * Transformar un DTO a un Entity
     *
     * @return  La entidad construida a partir del DTO.
     */
    @Override
    public CuentaCobroEntity toEntity() {
        CuentaCobroEntity cityE = super.toEntity();
        return cityE;
    }

}
