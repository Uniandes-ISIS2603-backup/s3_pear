/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.ejb;

import co.edu.uniandes.csw.pear.entities.DietaTipoEntity;
import co.edu.uniandes.csw.pear.entities.PersonaEntity;
import co.edu.uniandes.csw.pear.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.pear.persistence.PersonaPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author pa.suarezm
 */
@Stateless
public class PersonaLogic {
    
    private static final Logger LOGGER = Logger.getLogger(PersonaLogic.class.getName());
    
    @Inject
    private PersonaPersistence persistence;
    
     /**
     * Para crear una persona se deben seguir las siguiente reglas.
     * 1. No puede existir la misma persona dos veces
     * 2. Ningún atributo puede ser null ni vacío
     * @param entity Entidad para crear
     * @return La entidad creada
     * @throws BusinessLogicException Si no se respeta alguna de las reglas de negocio
     */
    public PersonaEntity createPersona(PersonaEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de persona");
        if (entity.getNombre() == null || entity.getApellido() == null || entity.getCorreo() == null){
            throw new BusinessLogicException("La persona no puede tener atributos nulos");
        }
        if( entity.getDireccion() == null || entity.getEdad() == null){
              throw new BusinessLogicException("La persona no puede tener atributos nulos");
        }
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de persona");
        return entity;
    }
    
    /**
     * Da la lista de todas las personas.
     * @return Lista con las personas
     */
    public List<PersonaEntity> getPersonas() {
        LOGGER.info("Inicia proceso de consultar todas las personas");
        List<PersonaEntity> personas = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las personas");
        return personas;
    }
    
    /**
     * Busca una persona por su identificador.
     * @param id Identificador de la persona a buscar.
     * @return Persona encontrada (null si no existe ninguna persona con el id)
     */
    public PersonaEntity getPersona(Long id) {
        return persistence.find(id);
    }
    
    public PersonaEntity aumentarPuntos(Long id) throws BusinessLogicException
    {
        PersonaEntity en = getPersona(id); 
        en.setPuntosFidelidad(en.getPuntosFidelidad() +1);
        
        return updatePersona(en); 
    }
    
    
    /**
     * Actualiza la persona que entra por parametro.
     * @param entity Persona nueva
     * @return Persona actualizada
     * @throws BusinessLogicException Si no existe la persona que se quiere actualizar
     */
    public PersonaEntity updatePersona(PersonaEntity entity) throws BusinessLogicException  {
        if (persistence.find(entity.getId()) == null) {
            throw new BusinessLogicException("La persona que se quiere actualizar no existe");
        }
        return persistence.update(entity);
    }
    
    /**
     * Elimina la relacion a una dieta data por id
     * @param personaId
     * @param dietaId
     * @return 
     */
    public PersonaEntity eliminarDietaPersona(Long personaId, Long dietaId)
    {
        PersonaEntity entity = getPersona(personaId); 
        
        List<DietaTipoEntity> dietas = entity.getDietas(); 
        
        
        for(int i = 0; i < dietas.size(); i++){
            if(dietas.get(i).getId().equals(dietaId)){
                dietas.remove(i);
            }
            
        }
        
        entity.setDieta(dietas);
        persistence.update(entity); 
        
        return entity; 
    }
    
    /**
     * Elimina la persona que entra por parametro
     * @param id Persona a eliminar
     */
    public void deletePersona(Long id){
        LOGGER.log(Level.INFO, "Inicia proceso de borrar persona con id={0}", id);    
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar persona con id={0}", id);
    }
    
}
