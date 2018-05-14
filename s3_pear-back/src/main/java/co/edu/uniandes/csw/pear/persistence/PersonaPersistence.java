/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.persistence;

import co.edu.uniandes.csw.pear.entities.CasoExitoEntity;
import co.edu.uniandes.csw.pear.entities.PersonaEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * @author pa.suarezm
 */
@Stateless 
public class PersonaPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(PersonaPersistence.class.getName());
    
    @PersistenceContext(unitName="PearPU")
    protected EntityManager em;
    
    /**
     * @param entity Entidada de tipo Persona que se creará en la base de datos
     * @return Devuelve la entidad creada con un id dado por la base
     */
    public PersonaEntity create(PersonaEntity entity){
        LOGGER.info("Creando una nueva persona");
        em.persist(entity);
        LOGGER.info("Se creó una nueva persona");
        return entity;
    }
    

    
    /**
     * Recupera todas las personas dentro del sistema
     * 
     * @return Lista con todas las entidades en la base de datos
     */
    public List<PersonaEntity> findAll(){
        LOGGER.info("Consultando todas las personas");
        TypedQuery query = em.createQuery("Select u from PersonaEntity u", PersonaEntity.class);
        return query.getResultList();
    }
    
    /**
     * Recupera la persona identificada con el id que entra por parámetro
     * @param id Identificador a buscar
     * @return Persona con el identificador id
     */
    public PersonaEntity find(Long id){
        return em.find(PersonaEntity.class, id);
    }
    
    /**
     * Actualiza los datos de la persona
     * @param entity Nuevo entity a actualizar
     * @return Nuevo entity actualizado
     */
    public PersonaEntity update(PersonaEntity entity){
        return em.merge(entity);
    }
    
    /**
     * Elimina la persona
     * @param id Identificador de la persona a eliminar
     */
    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando persona con id={0}", id);
        PersonaEntity entity = em.find(PersonaEntity.class, id);
        em.remove(entity);
    }
}
