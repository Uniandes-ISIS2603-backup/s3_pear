/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;
import co.edu.uniandes.csw.pear.entities.MedioPagoEntity;
import co.edu.uniandes.csw.pear.entities.PersonaEntity;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author jp.campos
 */
public class MedioPagoDetailDTO extends MedioPagoDTO{
    
    
    private ArrayList<PersonaDTO> personas;
    
     /**
     * Constructor por defecto
     */
    public MedioPagoDetailDTO() {
        
        
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
     * Cambia la lista de personas que usan el medio de pago
     * @param pPersonas 
     */
    public void setPersonas(ArrayList<PersonaDTO> pPersonas)
    {
       personas = pPersonas; 
    }
   
    
    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de ciudad a partir de la cual se construye el objeto
     */
    public MedioPagoDetailDTO(MedioPagoEntity entity) {
        super(entity);
        if(entity != null)
        {
            personas = new ArrayList<>(); 
            for (PersonaEntity persona : entity.getPersonas()) {
                personas.add( new PersonaDTO(persona));
            }
        }
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return  La entidad construida a partir del DTO.
     */
    @Override
    public MedioPagoEntity toEntity() {
        MedioPagoEntity entity = super.toEntity();
        
        if(personas != null)
        {
            List<PersonaEntity> personasEntity = new ArrayList<>();
            for (PersonaDTO persona : personas) {
                personasEntity.add(persona.toEntity());
            }
        }
        return entity;
    }

    
    
}
