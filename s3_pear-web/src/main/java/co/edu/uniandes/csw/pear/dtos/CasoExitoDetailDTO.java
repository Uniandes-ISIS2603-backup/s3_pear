/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

/**
 *
 * @author pa.suarezm
 */
public class CasoExitoDetailDTO {
    
    //----------------------------------------
    //Atributos
    //----------------------------------------
    
    private DietaTipoDetailDTO dieta;
    
    //----------------------------------------
    //Constructor
    //----------------------------------------
    
    public CasoExitoDetailDTO(){
        
    }
    
    //----------------------------------------
    //Metodos
    //----------------------------------------
    
     /**
     * @return Dieta para la cual el caso fue exitoso 
     */
    public DietaTipoDetailDTO getDieta(){
        return dieta;
    }
    
    /**
     * @param pDieta Nueva dieta asociada al caso exitoso
     */
    public void setDieta(DietaTipoDetailDTO pDieta){
        dieta = pDieta;
    }
}
