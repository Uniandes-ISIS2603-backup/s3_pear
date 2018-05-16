/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.persistence;

import co.edu.uniandes.csw.pear.entities.ComidaEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.*;


/**
 *
 * @author js.cabra
 */
@Stateless
public class ComidaPersistence {
    
    
    /**
     * Constante LOGGER para mantener registro de lo que se hace
     */
    private static final Logger LOGGER = Logger.getLogger(DietaTipoPersistence.class.getName());
    
    @PersistenceContext(unitName = "PearPU") //mismo nombre que en persistence.xml
    protected EntityManager em;
    
    /**
     * Busca una ComidaEntity dado su ID
     * @param id de tipo Long
     * @return comida de tipo entity
     */
    public ComidaEntity find( Long id ) {
        LOGGER.log(Level.INFO, "Consultando comida con id={0}", id);
        return em.find(ComidaEntity.class, id);
        
    }
    
    
    /**
     * Busca todas las comdias de tipo ComidaEntity
     * @return todas las cocinas
     */
    public List<ComidaEntity> findAll( ) {
        LOGGER.info("Consultando todas las comidas");
        Query q = em.createQuery("select u from ComidaEntity u");
        return q.getResultList();
    }
    
    /**
     * Crea una nueva comida a partir de una Entity dada
     * @param entity de tipo ComidaEntity
     * @return la entidad creada
     */
    public ComidaEntity create ( ComidaEntity entity ) {
        LOGGER.info("Creando una nueva comida");
        em.persist(entity);
        LOGGER.info("Comida creada");
        return entity;
    }
    
    /**
     * Actualiza una comida a partir de la entidad
     * @param entity de tipo ComidaEntity
     * @return la comida actualizada
     */
    public ComidaEntity update( ComidaEntity entity ) {
        LOGGER.log(Level.INFO, "Actualizando comida con id={0}", entity.getId());
        return em.merge(entity);
    }
    
    /**
     * Elimina una comida dado su ID
     * @param id de tipo Long
     */
    public void delete( Long id ) {
        LOGGER.log(Level.INFO, "Borrando la comida con id={0}", id);
        ComidaEntity entity = em.find(ComidaEntity.class, id);
        em.remove(entity);
    }
    
}
