/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.PersonaEntity;
/**
 * @author pa.suarezm
 */
public class PersonaDetailDTO extends PersonaDTO{
    
    //-----------------------------------------------------------
    //Atributos
    //-----------------------------------------------------------
    
    private CalificacionDetailDTO calificacion;
    
    private DietaTipoDetailDTO dieta;
    
    //-----------------------------------------------------------
    //Constructor
    //-----------------------------------------------------------
    
    public PersonaDetailDTO(PersonaEntity entidad){
        super(entidad);
    }
    
    //-----------------------------------------------------------
    //Metodos
    //-----------------------------------------------------------
    
    /**
     * @return calificacion que otorga la persona
     */
    public CalificacionDTO getCalificacion(){
        return calificacion;
    }
    
    /**
     * @param pCalificacion nueva calificacion otorgada por la persona
     */
    public void setCalificacion(CalificacionDetailDTO pCalificacion){
        calificacion = pCalificacion;
    }
    
    /**
     * @return dieta asignada a la persona
     */
    public DietaTipoDetailDTO getDieta(){
        return dieta;
    }
    
    /**
     * @param pDieta nueva dieta asignada para la persona
     */
    public void setDieta(DietaTipoDetailDTO pDieta){
        dieta = pDieta;
    }
}
