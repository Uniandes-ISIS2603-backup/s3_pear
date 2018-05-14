/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.persistence;

import co.edu.uniandes.csw.pear.entities.MedioPagoEntity;

import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author jp.campos
 */
@Stateless
public class MedioPagoPersistence {
    
       
     private static final Logger LOGGER = Logger.getLogger(MedioPagoPersistence.class.getName());

    @PersistenceContext(unitName = "PearPU")
    protected EntityManager em;

    /**
     *
     * @param entity objeto pago que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public MedioPagoEntity create(MedioPagoEntity entity) {
        LOGGER.info("Creando una medio de pago nuevo");
        em.persist(entity);
        LOGGER.info("Creando una medio de pago nuevo");
        return entity;
    }

    /**
     * 
     * @return Devuelve todos los medios de pago
     */
    public List<MedioPagoEntity> findAll() {
        LOGGER.info("Consultando todos los medios de pago");
        TypedQuery query = em.createQuery("select u from MedioPagoEntity u", MedioPagoEntity.class);
        return query.getResultList();
    }

    /**
     * Encuentra un medio de pago basándose en el id
     * @param id
     * @return La entidad de la cuenta de cobro
     */
    public MedioPagoEntity find(Long id) {
        return em.find(MedioPagoEntity.class, id);
    }

    /**
     * Actualiza la entidad del medio de pago
     * @param entity
     * @return La entidad de la cuenta de cobro
     */
    public MedioPagoEntity update(MedioPagoEntity entity) {
         return em.merge(entity);
    }
    
    /**
     * Elimina la entidad pasada por parámetro
     * @param id 
     */
    public void delete(Long id) {
        MedioPagoEntity entity = em.find(MedioPagoEntity.class, id);
        em.remove(entity);
    }
    
    
}
