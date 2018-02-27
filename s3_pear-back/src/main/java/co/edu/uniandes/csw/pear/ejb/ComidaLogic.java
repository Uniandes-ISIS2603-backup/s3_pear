/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.ejb;
import co.edu.uniandes.csw.pear.entities.ComidaEntity;
import co.edu.uniandes.csw.pear.persistence.ComidaPersistence;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Clase que implementa la conexion con la persistencia para la entidad de Comida.
 * @author js.cabra
 */
@Stateless
public class ComidaLogic {
    
    /**
     * Constante que representa el logger
     */
    private static final Logger LOGGER = Logger.getLogger(ComidaLogic.class.getName());
    
    /**
     * Conexion con Persistencia
     */
    @Inject
    private ComidaPersistence persistence;
    
    
    /**
     * METODOS 
     */
    
    
    
    /**
     * Retorna todas las Comidas Entities que se encuentran en la base de datos
     * @return 
     */
    public List<ComidaEntity> getComidas() {
        LOGGER.info("Inicia consulta de todas las comidas");
        List<ComidaEntity> comidas =  persistence.findAll();
        LOGGER.info("Termina la consulta de todas las comidas");
        return comidas;
    }
    
    /**
     * Retorna una Comida Entity por id
     * @param id
     * @return 
     */
    public ComidaEntity getComida( Long id ) {
        LOGGER.log(Level.INFO, "Inicia consulta de comida con id = {0}", id);
        ComidaEntity comida = persistence.find(id);
        if ( comida ==  null )
            LOGGER.log(Level.INFO, "No existe una Comida con el id = {0}", id);
        LOGGER.log(Level.INFO, "Termina la consulta de comida con id = {0}", id);
        return comida;
    }
    
    /**
     * Crea una Comida y la guarda en la base de datos
     * @param entity de comida a persistir
     * @return entidad de comida persistida
     */
    public ComidaEntity createComida( ComidaEntity entity ) {
        LOGGER.log(Level.INFO, "Inicia proceso de creacion de una comida con id = {0}", entity.getId());
        persistence.create(entity);
        LOGGER.log(Level.INFO, "Termina proceso de creacion de una comida con id = {0}", entity.getId());
        return entity;
    } 
    
    /**
     * Actualiza una Comida por id
     * @param id de tipo Long, representa la comida que se va a actualizar
     * @param entity de Comida con los cambios deseados
     * @return la entidad de Comida luego de ser actualizada
     */
    public ComidaEntity updateComida( Long id, ComidaEntity entity ) {
        LOGGER.log(Level.INFO, "Inica proceso de actualizacion de la comida con id = {0} " , id);
        ComidaEntity actualizado = persistence.update(entity);
        LOGGER.log( Level.INFO, "Termina proceso de actualizacion de la comida, id = {0}", entity.getId() );
        return actualizado;
    }
    
    /**
     * Elimina una Comida por id
     * @param id 
     */
    public void delete( Long id ) {
        LOGGER.log(Level.INFO, "Inicia eliminacion de la comida con id = {0} " , id);
        persistence.delete(id);
        LOGGER.log( Level.INFO, "Comida con id = {0} eliminada. ", id );
    }
    
}
