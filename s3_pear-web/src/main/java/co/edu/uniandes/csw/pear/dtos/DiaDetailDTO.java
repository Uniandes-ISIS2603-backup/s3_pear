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
    
    private List<ComidaDetailDTO> comidas;
    //-----------------------------------------------------------
    //Constructor
    //-----------------------------------------------------------
    
    public DiaDetailDTO(DiaEntity entity){
        super(entity);
    }
    
    //-----------------------------------------------------------
    //Metodos
    //-----------------------------------------------------------
    
    /**
     * Determina las comidas programadas para ese dia
     * @param pComidas comidas programadas
     */
    public void setComidas(List<ComidaDetailDTO> pComidas){
        comidas = pComidas;
    }
    
    /**
     * @return las comidas programadas ese dia para el cliente
     */
    public List<ComidaDetailDTO> getComidas(){
        return comidas;
    }
    
    //Es detail o no????????????????!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
}
