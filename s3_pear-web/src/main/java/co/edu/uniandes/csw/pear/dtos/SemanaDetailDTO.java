/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;
import co.edu.uniandes.csw.pear.entities.SemanaEntity;

/**
 *
 * @author v.chacon
 */
public class SemanaDetailDTO extends SemanaDTO {
    
    //-----------------------------------------------------------
    //Constructor
    //-----------------------------------------------------------
    
    public SemanaDetailDTO(SemanaEntity entity){
        super(entity);
    }
    
}
