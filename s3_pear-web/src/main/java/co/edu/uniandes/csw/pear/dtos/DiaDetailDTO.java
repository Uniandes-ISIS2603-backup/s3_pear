/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.DiaEntity;
import java.util.List;
/**
 *
 * @author v.chacon
 */
public class DiaDetailDTO extends DiaDTO{
    
    //-----------------------------------------------------------
    //Atributos
    //-----------------------------------------------------------
    
    private List<ComidaDTO> comidas;
    //-----------------------------------------------------------
    //Constructor
    //-----------------------------------------------------------
    
    /**
     * Constructor de la clase 
     * @param entity entidad a apartir de la cual se construye el dto
     */
    public DiaDetailDTO(DiaEntity entity){
        super(entity);
    }
    
    /**
     * Constructor de la clase DiaDetailDTO
     */
    public DiaDetailDTO(){
        super();
    }
    
    //-----------------------------------------------------------
    //Metodos
    //-----------------------------------------------------------
    
//    /**
//     * Determina las comidas programadas para ese dia
//     * @param pComidas comidas programadas
//     */
//    public void setComidas(List<ComidaDTO> pComidas){
//        comidas = pComidas;
//    }
//    
//    /**
//     * @return las comidas programadas ese dia para el cliente
//     */
//    public List<ComidaDTO> getComidas(){
//        return comidas;
//    }
}
