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
    
    private CalificacionDTO calificacion;
    
    private DietaTipoDTO dieta;
    
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
    public void setCalificacion(CalificacionDTO pCalificacion){
        calificacion = pCalificacion;
    }
    
    /**
     * @return dieta asignada a la persona
     */
    public DietaTipoDTO getDieta(){
        return dieta;
    }
    
    /**
     * @param pDieta nueva dieta asignada para la persona
     */
    public void setDieta(DietaTipoDTO pDieta){
        dieta = pDieta;
    }
}
