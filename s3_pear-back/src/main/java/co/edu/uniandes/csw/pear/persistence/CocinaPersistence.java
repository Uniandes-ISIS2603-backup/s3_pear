/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.persistence;

import co.edu.uniandes.csw.pear.entities.CocinaEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 * Representa la clse de Persistencia de datos de Cocina
 * @author js.garcial1
 */
@Stateless
public class CocinaPersistence {
    
    /**
     * Constante LOGGER para mantener registro de lo que se hace
     */
    private static final Logger LOGGER = Logger.getLogger(DietaTipoPersistence.class.getName());
    
    @PersistenceContext(unitName = "PearPU") //mismo nombre que en persistence.xml
    protected EntityManager em;
    
    /**
     * Busca una CocinaEntity dado su ID
     * @param id de tipo long
     * @return cocina de tipo entity
     */
    public CocinaEntity find( Long id ) {
        LOGGER.log(Level.INFO, "Consultando cocina con id={0}", id);
        return em.find(CocinaEntity.class, id);
    }
    
    /**
     * Busca una CocinaEntity dado su nombre
     * @param name de tipo string
     * @return cocina de tipo entity
     */
    public CocinaEntity findByName( String name ) {
        LOGGER.log(Level.INFO, "Consultando la cocina con name= ", name);
        TypedQuery<CocinaEntity> q = em.createQuery("select u from CocinaEntity u where u.name = :name", CocinaEntity.class);
        q = q.setParameter("name", name);
        return q.getSingleResult();
    }
    
    /**
     * Busca todas las cocinas de tipo CocinaEntity
     * @return todas las cocinas
     */
    public List<CocinaEntity> findAll( ) {
        LOGGER.info("Consultando todas las cocinas");
        Query q = em.createQuery("select u from CocinaEntity u");
        return q.getResultList();
    }
    
    /**
     * Crea una nueva cocina a partir de una Entity dada
     * @param entity de tipo CocinaEntity
     * @return la entidad creada
     */
    public CocinaEntity create ( CocinaEntity entity ) {
        LOGGER.info("Creando una nueva cocina");
        em.persist(entity);
        LOGGER.info("Cocina creada");
        return entity;
    }
    
    /**
     * Actualiza una cocina a partir de la entidad
     * @param entity de tipo CocinaEntity
     * @return la cocina actualizada
     */
    public CocinaEntity update( CocinaEntity entity ) {
        LOGGER.log(Level.INFO, "Actualizando cocina con id={0}", entity.getId());
        return em.merge(entity);
    }
    
    /**
     * Elimina una cocina dado su ID
     * @param id de tipo Long
     */
    public void delete( Long id ) {
        LOGGER.log(Level.INFO, "Borrando la dieta con id={0}", id);
        CocinaEntity entity = em.find(CocinaEntity.class, id);
        System.out.println(String.format("Eliminandola entitad de Cocina con ID = { %s } donde la lista tiene < %d > elementos", new Object[]{entity.getId().toString(), this.findAll().size()}));
        em.remove(entity);
        System.out.println( String.format("Ahora la lista debria tener un elemento menos. La lista tiene < %d > elementos ", this.findAll().size()) );
    }
}
