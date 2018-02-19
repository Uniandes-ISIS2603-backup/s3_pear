/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.persistence;

import co.edu.uniandes.csw.pear.entities.DiaEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author v.chacon
 */
public class DiaPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(DiaPersistence.class.getName());

    @PersistenceContext(unitName = "PearPU")
    protected EntityManager em;
    
    /**
     * Crea un nuevo dia a partir de una entidad dada
     * @param entity objeto dia que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    
    public DiaEntity create(DiaEntity entity){
        LOGGER.info("Creando un dia nueva");
        em.persist(entity);
        LOGGER.info("Creando un dia nueva");
        return entity;
    }
    
      /**
     * Busca si hay algun dia con el nombre que entra por parametro
     * @param name: Nombre del dia que se está buscando
     * @return  el primer dia que se encuentra.
     */
    public DiaEntity findByName(String name) {
       LOGGER.log(Level.INFO, "Consultando el dia con name= ", name);
        TypedQuery<DiaEntity> q = em.createQuery("select u from DiaEntity u where u.name = :name", DiaEntity.class);
        q = q.setParameter("name", name);
        return q.getSingleResult();
    }
    /**
     * Busca todos los dias de tipo DiaEntity
     * @return lista con todas los dias
     */
    public List<DiaEntity> findAll() {
        LOGGER.info("Consultando todos los dias");
        TypedQuery query = em.createQuery("select u from DiaEntity u", DiaEntity.class);
        return query.getResultList();
    }
        
    /**
     * Busca un DiaEntity con el identificador dado por parametro
     * @param id identificador de un DiaEntity
     * @return el dia con ese identificador
     */
     public DiaEntity find(Long id) {
        return em.find(DiaEntity.class, id);
    }
    
     /**
      * Actualiza un dia de acuerdo a una entidad
      * @param entity entidad de tipo DiaEntity
      * @return el dia actualizado
      */
    public DiaEntity update(DiaEntity entity) {
        
         LOGGER.log(Level.INFO, "Actualizando dia con id={0}", entity.getId());
         return em.merge(entity);
    }
    
    
    /**
     * Elimina un dia segun su identificador
     * @param id identificador del dia a eliminar
     */
    public void delete(Long id) {
        
        LOGGER.log(Level.INFO, "Borrando el dia con id={0}", id);
        DiaEntity entity = em.find(DiaEntity.class, id);
        em.remove(entity);
    }
      
    
}
