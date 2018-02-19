/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.persistence;

import co.edu.uniandes.csw.pear.entities.DietaTipoEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 * Representa la clase de Persistencia de datos de DietaTipo
 * @author js.garcial1
 */
@Stateless
public class DietaTipoPersistence {
    
    /**
     * Constante LOGGER para mantener registro de lo que se hace
     */
    private static final Logger LOGGER = Logger.getLogger(DietaTipoPersistence.class.getName());
    
    @PersistenceContext(unitName = "PearPU") //mismo nombre que en persistence.xml
    protected EntityManager em;
    
    /**
     * Busca una DietaEntity dado su ID
     * @param id de tipo long
     * @return dieta de tipo entity
     */
    public DietaTipoEntity find( Long id ) {
        LOGGER.log(Level.INFO, "Consultando dieta con id={0}", id);
        return em.find(DietaTipoEntity.class, id);
    }
    
    /**
     * Busca una DietaEntity dado su nombre
     * @param name de tipo string
     * @return dieta de tipo entity
     */
    public DietaTipoEntity findByName( String name ) {
        LOGGER.log(Level.INFO, "Consultando la dieta con name= ", name);
        TypedQuery<DietaTipoEntity> q = em.createQuery("select u from DietaTipoEntity u where u.name = :name", DietaTipoEntity.class);
        q = q.setParameter("name", name);
        return q.getSingleResult();
    }
    
    /**
     * Busca todas las dietas de tipo DietaEntity
     * @return todas las dietas
     */
    public List<DietaTipoEntity> findAll( ) {
        LOGGER.info("Consultando todas las dietas");
        Query q = em.createQuery("select u from DietaTipoEntity u");
        return q.getResultList();
    }
    
    /**
     * Crea una nueva dieta a partir de una Entity dada
     * @param entity de tipo DietaTipoEntity
     * @return la entidad creada
     */
    public DietaTipoEntity create ( DietaTipoEntity entity ) {
        LOGGER.info("Creando una nueva dieta");
        em.persist(entity);
        LOGGER.info("Dieta creada");
        return entity;
    }
    
    /**
     * Actualiza una dieta a partir de la entidad
     * @param entity de tipo DietaTipoEntity
     * @return la dieta actualizada
     */
    public DietaTipoEntity update( DietaTipoEntity entity ) {
        LOGGER.log(Level.INFO, "Actualizando dieta con id={0}", entity.getId());
        return em.merge(entity);
    }
    
    /**
     * Elimina una dieta dado su ID
     * @param id de tipo Long
     */
    public void delete( Long id ) {
        LOGGER.log(Level.INFO, "Borrando la dieta con id={0}", id);
        DietaTipoEntity entity = em.find(DietaTipoEntity.class, id);
        em.remove(entity);
    }
}
