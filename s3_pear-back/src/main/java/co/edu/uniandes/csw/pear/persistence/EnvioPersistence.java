/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.persistence;

import co.edu.uniandes.csw.pear.entities.EnvioEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author js.cabra
 */
public class EnvioPersistence {
        /**
     * Constante LOGGER para mantener registro de lo que se hace
     */
    private static final Logger LOGGER = Logger.getLogger(DietaTipoPersistence.class.getName());
    
    @PersistenceContext(unitName = "PearPU") //mismo nombre que en persistence.xml
    protected EntityManager em;
    
    /**
     * Busca una EnvioEntity dado su ID
     * @param id de tipo long
     * @return envio de tipo entity
     */
    public EnvioEntity find( Long id ) {
        LOGGER.log(Level.INFO, "Consultando envio con id={0}", id);
        return em.find(EnvioEntity.class, id);
        
    }

    
    /**
     * Busca todas las envios de tipo ComidaEntity
     * @return todas las cocinas
     */
    public List<EnvioEntity> findAll( ) {
        LOGGER.info("Consultando todos los envios");
        Query q = em.createQuery("select u from EnvioEntity u");
        return q.getResultList();
    }
    
    /**
     * Crea un nuevo envio a partir de una Entity dada
     * @param entity de tipo EnvioEntity
     * @return la entidad creada
     */
    public EnvioEntity create ( EnvioEntity entity ) {
        LOGGER.info("Creando un nuevo envio");
        em.persist(entity);
        LOGGER.info("Envio creado");
        return entity;
    }
    
    /**
     * Actualiza un envio a partir de la entidad
     * @param entity de tipo EnvioEntity
     * @return el envio actualizada
     */
    public EnvioEntity update( EnvioEntity entity ) {
        LOGGER.log(Level.INFO, "Actualizando envio con id={0}", entity.getId());
        return em.merge(entity);
    }
    
    /**
     * Elimina una envio dado su ID
     * @param id de tipo Long
     */
    public void delete( Long id ) {
        LOGGER.log(Level.INFO, "Borrando el envio con id={0}", id);
        EnvioEntity entity = em.find(EnvioEntity.class, id);
        em.remove(entity);
    }
    
}
