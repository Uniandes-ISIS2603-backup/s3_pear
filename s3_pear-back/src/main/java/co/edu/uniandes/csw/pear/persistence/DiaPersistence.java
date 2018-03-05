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

@Stateless
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
       LOGGER.log(Level.INFO, "Consultando dia  por nombre ", name);

        // Se crea un query para buscar editoriales con el nombre que recibe el método como argumento. ":name" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From DiaEntity e where e.name = :name", DiaEntity.class);
        // Se remplaza el placeholder ":name" con el valor del argumento 
        query = query.setParameter("name", name);
        // Se invoca el query se obtiene la lista resultado
        List<DiaEntity> sameName = query.getResultList();
         DiaEntity result = null; 
        if (sameName == null ) {
            result = null;
        } else if (sameName.isEmpty()) {
             result = null;
        } else {
            result =  sameName.get(0);
        }
        return result;
    }
    /**
     * Busca todos los dias de tipo DiaEntity
     * @return lista con todas los dias
     */
    public List<DiaEntity> findAll() {
        LOGGER.info("Consultando todos los dias");
        Query query = em.createQuery("select u from DiaEntity u", DiaEntity.class);
        return query.getResultList();
    }
        
    /**
     * Busca un DiaEntity con el identificador dado por parametro
     * @param id identificador de un DiaEntity
     * @return el dia con ese identificador
     */
     public DiaEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando dia con id = {0}", id);
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
