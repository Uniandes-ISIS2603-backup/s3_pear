/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.ejb;

import co.edu.uniandes.csw.pear.entities.DiaEntity;
import co.edu.uniandes.csw.pear.persistence.DiaPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *Clase que implementa la conexión con la persistencia para la entidad DiaEntity
 * @author v.chacon
 */

@Stateless
public class DiaLogic {
    
    /**
     * Constante que representa el logger
     */
    private static final Logger LOGGER = Logger.getLogger(DietaTipoLogic.class.getName());
    
    /**
     * Conexion con la Persistencia
     */
    @Inject
    private DiaPersistence persistence;   
    
    //----------------------------------------------------------------
    //Metodos
    //----------------------------------------------------------------
    
    /**
     * Retorna todas las DiaEntity que se encuentran en la base de datos
     * @return lista con las entidades
     */
    public List<DiaEntity> getDias() {
        LOGGER.info("Inicia consulta de todos los dias");
        List<DiaEntity>  dias =  persistence.findAll();
        LOGGER.info("Termina la consulta de todos los dias");
        return dias;
    }
    
    /**
     * Retorna la DiaEntity que tiene el identificador que entra como parametro  
     * @param id identificador del dia que se quiere buscar
     * @return dia con identificador dado
     */
    public DiaEntity getDia( Long id ) {
        LOGGER.log(Level.INFO, "Inicia consulta del dia con id = {0}", id);
        DiaEntity dia = persistence.find(id);
        if ( dia ==  null )
            LOGGER.log(Level.INFO, "No existe un dia con el id = {0}", id);
        LOGGER.log(Level.INFO, "Termina la consulta del dia con id = {0}", id);
        return dia;
    }
    
     /**
     * Crea un Dia y lo guarda en la base de datos
     * @param entity de dia a persistir
     * @return entidad de dia persistida
     */
    public DiaEntity createDia( DiaEntity entity ) {
        LOGGER.log(Level.INFO, "Inicia proceso de creacion de un dia con id = {0}", entity.getId());
        persistence.create(entity);
        LOGGER.log(Level.INFO, "Termina proceso de creacion de un dia con id = {0}", entity.getId());
        return entity;
    } 
     
    /**
     * Actualiza un dia segun su identificador
     * @param id de tipo Long, representa  el id del dia que se va a actualizar
     * @param entity DiaEntity con los cambios deseados
     * @return la entidad de Dia luego de ser actualizada
     */
    public DiaEntity updateDia( Long id, DiaEntity entity ) {
        LOGGER.log(Level.INFO, "Inica proceso de actualizacion del dia con id = {0} " , id);
        DiaEntity actualizado = persistence.update(entity);
        LOGGER.log( Level.INFO, "Termina proceso de actualizacion del dia, id = {0}", entity.getId() );
        return actualizado;
    }
    
    /**
     * Elimina una dia segun su identificador
     * @param id identificador del dia que se quiere eliminar
     */
    public void delete( Long id ) {
        LOGGER.log(Level.INFO, "Inicia el proceso de eliminacion de un dia con id = {0} " , id);
        persistence.delete(id);
        LOGGER.log( Level.INFO, "El dia con id = {0} fue eliminada. ", id );
    }
}
