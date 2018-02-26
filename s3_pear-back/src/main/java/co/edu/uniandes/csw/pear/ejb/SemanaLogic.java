/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.ejb;

import co.edu.uniandes.csw.pear.entities.SemanaEntity;
import co.edu.uniandes.csw.pear.persistence.SemanaPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Clase que implementa la conexión con la persistencia para la entidad SemanaEntity
 * @author v.chacon
 */

@Stateless
public class SemanaLogic {
    
    /**
     * Constante que representa el logger
     */
    private static final Logger LOGGER = Logger.getLogger(DietaTipoLogic.class.getName());
    
     /**
     * Conexion con la Persistencia
     */
    @Inject
    private SemanaPersistence persistence;
    
    
    //----------------------------------------------------------------
    //Metodos
    //----------------------------------------------------------------
    
    /**
     * Retorna todas las SemanaEntity que se encuentran en la base de datos
     * @return lista con las entidades
     */
    public List<SemanaEntity> getSemanas() {
        LOGGER.info("Inicia consulta de todas las semanas");
        List<SemanaEntity>  semanas =  persistence.findAll();
        LOGGER.info("Termina la consulta de todas las semanas");
        return semanas;
    }
    
    /**
     * Retorna la SemanaEntity que tiene el identificador que entra como parametro  
     * @param id identificador de la semana que se quiere buscar
     * @return semana con identificador dado
     */
    public SemanaEntity getSemana( Long id ) {
        LOGGER.log(Level.INFO, "Inicia consulta de la semana con id = {0}", id);
        SemanaEntity semana = persistence.find(id);
        if ( semana ==  null )
            LOGGER.log(Level.INFO, "No existe una semana  con el id = {0}", id);
        LOGGER.log(Level.INFO, "Termina la consulta de la semana con id = {0}", id);
        return semana;
    }
    
    /**
     * Crea una Semana y la guarda en la base de datos
     * @param entity de semana a persistir
     * @return entidad de semana  persistida
     */
    public SemanaEntity createSemana( SemanaEntity entity ) {
        LOGGER.log(Level.INFO, "Inicia proceso de creacion de una semana con id = {0}", entity.getId());
        persistence.create(entity);
        LOGGER.log(Level.INFO, "Termina proceso de creacion de una semana con id = {0}", entity.getId());
        return entity;
    } 
    
    
    /**
     * Actualiza una Semana segun su identificador
     * @param id de tipo Long, representa  el id de la semana que se va a actualizar
     * @param entity SemanaEntity con los cambios deseados
     * @return la entidad de semana luego de ser actualizada
     */
    public SemanaEntity updateSemana( Long id, SemanaEntity entity ) {
        LOGGER.log(Level.INFO, "Inica proceso de actualizacion de la semana con id = {0} " , id);
        SemanaEntity actualizado = persistence.update(entity);
        LOGGER.log( Level.INFO, "Termina proceso de actualizacion de la semana, id = {0}", entity.getId() );
        return actualizado;
    }
    
    
    /**
     * Elimina una semana segun su identificador
     * @param id identificador de la semana que se quiere eliminar
     */
    public void delete( Long id ) {
        LOGGER.log(Level.INFO, "Inicia el proceso de eliminacion de una semana con id = {0} " , id);
        persistence.delete(id);
        LOGGER.log( Level.INFO, "La semana con id = {0} fue eliminada. ", id );
    }
    
    
}
