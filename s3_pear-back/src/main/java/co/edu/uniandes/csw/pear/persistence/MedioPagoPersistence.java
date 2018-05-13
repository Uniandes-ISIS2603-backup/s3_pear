/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.persistence;

import co.edu.uniandes.csw.pear.entities.MedioPagoEntity;

import java.util.List;
import java.util.logging.Level;
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
     * Busca si hay algun medio de pago con el nombre que se envía de argumento
     *
     * @param name: Nombre del medio de pago que se está buscando
     * @return null si no existe ningun medio de pago con el nombre del argumento. Si
     * existe alguna devuelve la primera.
     */
    public MedioPagoEntity findByName(String name) {
        LOGGER.log(Level.INFO, "Consultando cuenta por nombre ", name);

        // Se crea un query para buscar mediosDePagos con el nombre que recibe el método como argumento. ":name" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From MedioPagoEntity e where e.name = :name", MedioPagoEntity.class);
        // Se remplaza el placeholder ":name" con el valor del argumento 
        query = query.setParameter("name", name);
        // Se invoca el query se obtiene la lista resultado
        List<MedioPagoEntity> sameName = query.getResultList();
        if (sameName.isEmpty()) {
            return null;
        } else {
            return sameName.get(0);
        }
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
     * @param entity 
     */
    public void delete(Long id) {
        MedioPagoEntity entity = em.find(MedioPagoEntity.class, id);
        em.remove(entity);
    }
    
    
}
