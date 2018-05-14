/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.persistence;

import co.edu.uniandes.csw.pear.entities.CasoExitoEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * @author pa.suarezm
 */
@Stateless
public class CasoExitoPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(CasoExitoPersistence.class.getName());
    
    @PersistenceContext(unitName = "PearPU")
    protected EntityManager em;
    
    /**
     * @param entity Entidada de tipo CasoExito que se creará en la base de datos
     * @return Devuelve la entidad creada con un id dado por la base
     */
    public CasoExitoEntity create(CasoExitoEntity entity){
        LOGGER.info("Creando un nuevo caso exito");
        em.persist(entity);
        LOGGER.info("Se creó un nuevo caso");       
        return entity;
    }
    
  
    
    /**
     * Recupera todos los casos dentro del sistema
     * 
     * @return Lista con todas las entidades en la base de datos
     */
    public List<CasoExitoEntity> findAll(){
        LOGGER.info("Consultando todos los casos");
        TypedQuery query = em.createQuery("Select u from CasoExitoEntity u", CasoExitoEntity.class);
        return query.getResultList();
    }
    
    /**
     * Recupera el caso identificado con el id que entra por parámetro
     * @param id Identificador a buscar
     * @return Caso con el identificador id
     */
    public CasoExitoEntity find(Long id){
        return em.find(CasoExitoEntity.class, id);
    }
    
    /**
     * Actualiza los datos del caso
     * @param entity Nuevo entity a actualizar
     * @return Nuevo entity actualizado
     */
    public CasoExitoEntity update(CasoExitoEntity entity){
        return em.merge(entity);
    }
    
    /**
     * Elimina el caso
     * @param id Identificador de la entidad a eliminar
     */
    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando caso exito con id={0}", id);
        CasoExitoEntity entity = em.find(CasoExitoEntity.class, id);
        em.remove(entity);
    }

}
