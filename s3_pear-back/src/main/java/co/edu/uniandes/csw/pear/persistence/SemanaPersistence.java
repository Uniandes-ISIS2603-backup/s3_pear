/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.persistence;

import co.edu.uniandes.csw.pear.entities.SemanaEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author v.chacon
 */
@Stateless
public class SemanaPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(DiaPersistence.class.getName());

    @PersistenceContext(unitName = "PearPU")
    protected EntityManager em;
    
    /**
     * Busca una SemanaEntity con el identificador dado por parametro
     * @param id identificador de una SemanaEntity
     * @return la semana con ese identificador
     */
     public SemanaEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando semana con id = {0}", id);
        return em.find(SemanaEntity.class, id);
    }
    
    
    /**
     * Busca todos las semanas de tipo SemanaEntity
     * @return lista con todas los dias
     */
    public List<SemanaEntity> findAll() {
        LOGGER.info("Consultando todas las semanas");
        Query query = em.createQuery("select u from SemanaEntity u", SemanaEntity.class);
        return query.getResultList();
    }
    
    
    
    /**
     * Crea una nueva semana a partir de una entidad dada
     * @param entity objeto semana que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    
    public SemanaEntity create(SemanaEntity entity){
        LOGGER.info("Creando una semana nueva");
        em.persist(entity);
        return entity;
    }

     /**
      * Actualiza una semana de acuerdo a una entidad
      * @param entity entidad de tipo SemanaEntity
      * @return la semana actualizada
      */
    public SemanaEntity update(SemanaEntity entity) {
        
         LOGGER.log(Level.INFO, "Actualizando semana con id={0}", entity.getId());
         return em.merge(entity);
    }
    
    
    /**
     * Elimina una semana segun su identificador
     * @param id identificador de la semana a eliminar
     */
    public void delete(Long id) {
        
        LOGGER.log(Level.INFO, "Borrando la semana con id={0}", id);
        SemanaEntity entity = em.find(SemanaEntity.class, id);
        em.remove(entity);
    }
     
    
}
