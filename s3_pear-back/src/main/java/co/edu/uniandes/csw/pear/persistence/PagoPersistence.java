/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.persistence;
import co.edu.uniandes.csw.pear.entities.PagoEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author jp.campos
 */
@Stateless
public class PagoPersistence {
    
        
     private static final Logger LOGGER = Logger.getLogger(PagoPersistence.class.getName());

    @PersistenceContext(unitName = "PearPU")
    protected EntityManager em;

    /**
     *
     * @param entity objeto pago que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public PagoEntity create(PagoEntity entity) {
        LOGGER.info("Creando un nuevo pago");
        em.persist(entity);
       
        return entity;
    }

    /**
     * 
     * @return Devuelve todos los pagos
     */
    public List<PagoEntity> findAll() {
        LOGGER.info("Consultando todos los pagos");
        Query query = em.createQuery("select u from PagoEntity u");
        return query.getResultList();
    }

    /**
     * Encuentra un pago basándose en el id
     * @param id
     * @return La entidad de la cuenta de cobro
     */
    public PagoEntity find(Long id) {
        return em.find(PagoEntity.class, id);
    }

    /**
     * Actualiza la entidad del pago
     * @param entity
     * @return La entidad del pago
     */
    public PagoEntity update(PagoEntity entity) {
         return em.merge(entity);
    }
    
    /**
     * Elimina la entidad pasada por parámetro
     * @param id 
     */
    public void delete(Long id) {
       PagoEntity entity = em.find(PagoEntity.class, id);
        em.remove(entity);
    }
    
}
