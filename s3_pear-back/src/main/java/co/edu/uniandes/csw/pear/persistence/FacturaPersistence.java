/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.persistence;


import co.edu.uniandes.csw.pear.entities.FacturaEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *Representa la clase de Persistencia de datos de Factura
 * @author v.chacon
 */

@Stateless
public class FacturaPersistence {
    
     private static final Logger LOGGER = Logger.getLogger(FacturaPersistence.class.getName());

    @PersistenceContext(unitName = "PearPU")
    protected EntityManager em;
    
    /**
     *Crea una nueva factura a partir de una entidad dada
     * @param entity objeto factura que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    
    public FacturaEntity create(FacturaEntity entity){
        LOGGER.info("Creando una factura nueva");
        em.persist(entity);
        LOGGER.info("Creando una factura nueva");
        return entity;
    }
    
      /**
     * Busca si hay alguna factura con el nombre que entra por parametro
     *
     * @param name: Nombre de la factura que se está buscando
     * @return la primera factura
     */
    public FacturaEntity findByName(String name) {
       LOGGER.log(Level.INFO, "Consultando la factura con name= ", name);
        TypedQuery<FacturaEntity> q = em.createQuery("select u from FacturaEntity u where u.name = :name", FacturaEntity.class);
        q = q.setParameter("name", name);
        return q.getSingleResult();
    }
    /**
     * Busca todas las facturas de tipo FacturaEntity
     * @return lista con todas las facturas
     */
    public List<FacturaEntity> findAll() {
        LOGGER.info("Consultando todas las facturas");
        TypedQuery query = em.createQuery("select u from FacturaEntity u", FacturaEntity.class);
        return query.getResultList();
    }
        
    /**
     * Busca una FacturaEntity con el identificador dado por parametro
     * @param id identificador de una FacturaEntity
     * @return la factura con ese identificador
     */
     public FacturaEntity find(Long id) {
        return em.find(FacturaEntity.class, id);
    }
    
     /**
      * Actualiza  una factura de acuerdo a una entidad
      * @param entity entidad de tipo FacturaEntity
      * @return la factura actualizada
      */
    public FacturaEntity update(FacturaEntity entity) {
        
         LOGGER.log(Level.INFO, "Actualizando factura con id={0}", entity.getId());
         return em.merge(entity);
    }
    
    
    /**
     * Elimina una factura segun su identificador
     * @param id identificador de la factura a eliminar
     */
    public void delete(Long id) {
        
        LOGGER.log(Level.INFO, "Borrando la factura con id={0}", id);
        FacturaEntity entity = em.find(FacturaEntity.class, id);
        em.remove(entity);
    }
        
}
