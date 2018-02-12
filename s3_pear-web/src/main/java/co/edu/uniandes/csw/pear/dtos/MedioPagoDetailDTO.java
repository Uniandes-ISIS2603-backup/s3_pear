/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;
import co.edu.uniandes.csw.pear.entities.MedioPagoEntity;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author jp.campos
 */
public class MedioPagoDetailDTO extends MedioPagoDTO{
    
    
    private List<PersonaDTO> personas;
    
     /**
     * Constructor por defecto
     */
    public MedioPagoDetailDTO() {
        personas = new ArrayList<>(); 
        
    }
    
    /**
     * Retorna las personas que usen este medio de pago
     * @return personas
     */
    public List<PersonaDTO> getPersonas()
    {
        return personas; 
    }
    
    /**
     * Agrega una persona que este usando este medio de pago
     * @param pPersona 
     */
    public void addPersona(PersonaDTO pPersona)
    {
        personas.add(pPersona); 
    }
    
    /**
     * Elimina a la persona en la posición i
     * @param i 
     */
    public void removePersona(int i)
    {
        personas.remove(i);
    }
    
    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de ciudad a partir de la cual se construye el objeto
     */
    public MedioPagoDetailDTO(MedioPagoEntity entity) {
        super(entity);
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return  La entidad construida a partir del DTO.
     */
    @Override
    public MedioPagoEntity toEntity() {
        MedioPagoEntity entity = super.toEntity();
        return entity;
    }

    
    
}
