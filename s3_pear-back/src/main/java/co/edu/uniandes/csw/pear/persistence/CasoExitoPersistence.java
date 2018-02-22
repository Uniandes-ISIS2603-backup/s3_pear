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
        LOGGER.info("Se creó un nuevo caso");        return entity;
    }
    
    /**
     * Busca si hay algun caso con el nombre que se envía de argumento
     * 
     * @param dieta: Nombre de la dieta relacionada al caso
     * @return null si no existe ningún caso con esa dieta asociada
     * Si existe, devuelve la primera
     */
    public CasoExitoEntity findByName(String dieta){
        LOGGER.log(Level.INFO, "Consultando caso por dieta", dieta);
        
        TypedQuery query = em.createQuery("Select e From CasoExitoEntity e where e.dieta = :dieta", CasoExitoEntity.class);
    
        query = query.setParameter("dieta", dieta);
        
        List<CasoExitoEntity> sameDiet = query.getResultList();
        if (sameDiet.isEmpty())
            return null;
        else
            return sameDiet.get(0);
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
     * @param entity Entidad para eliminar
     */
    public void delete(CasoExitoEntity entity){
        em.remove(entity);
    }

}
