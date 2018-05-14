/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.persistence;


import co.edu.uniandes.csw.pear.entities.CuentaCobroEntity;
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
public class CuentaCobroPersistence {
    
    
     private static final Logger LOGGER = Logger.getLogger(CuentaCobroPersistence.class.getName());

    @PersistenceContext(unitName = "PearPU")
    protected EntityManager em;

    /**
     *
     * @param entity objeto cuentaCobro que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public CuentaCobroEntity create(CuentaCobroEntity entity) {
        LOGGER.info("Creando una cuentaCobro nueva");
        em.persist(entity);
       
        LOGGER.info("Creando una cuentaCobro nueva");
        return entity;
    }

    /**
     * Busca si hay alguna cuentaCobro con el nombre que se envía de argumento
     *
     * @param name: Nombre de la cuenta de cobro que se está buscando
     * @return null si no existe ninguna city con el nombre del argumento. Si
     * existe alguna devuelve la primera.
     */
    public CuentaCobroEntity findByName(String name) {
        LOGGER.log(Level.INFO, "Consultando cuenta por nombre ", name);

        // Se crea un query para buscar cuentas de cobro con el nombre que recibe el método como argumento. ":name" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From CuentaCobroEntity e where e.name = :name", CuentaCobroEntity.class);
        // Se remplaza el placeholder ":name" con el valor del argumento 
        query = query.setParameter("name", name);
        // Se invoca el query se obtiene la lista resultado
        List<CuentaCobroEntity> sameName = query.getResultList();
        if (sameName.isEmpty()) {
            return null;
        } else {
            return sameName.get(0);
        }
    }

    /**
     * 
     * @return Devuelve todas las cuentas de cobro
     */
    public List<CuentaCobroEntity> findAll() {
        LOGGER.info("Consultando todos las cuentas de cobro");
        Query query = em.createQuery("select u from CuentaCobroEntity u");
        return query.getResultList();
    }

    /**
     * Encuentra una cuenta de cobro basándose en el id
     * @param id
     * @return La entidad de la cuenta de cobro
     */
    public CuentaCobroEntity find(Long id) {
        return em.find(CuentaCobroEntity.class, id);
    }

    /**
     * Actualiza la entidad de la cuenta de cobro
     * @param entity
     * @return La entidad de la cuenta de cobro
     */
    public CuentaCobroEntity update(CuentaCobroEntity entity) {
         return em.merge(entity);
    }
    
    /**
     * Elimina la entidad pasada por parámetro
     * @param id 
     */
    public void delete(Long id) {
       CuentaCobroEntity entity = em.find(CuentaCobroEntity.class, id);
        em.remove(entity);
    }
    
}
