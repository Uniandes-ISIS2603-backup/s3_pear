/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.ejb;

import co.edu.uniandes.csw.pear.entities.CocinaEntity;
import co.edu.uniandes.csw.pear.persistence.CocinaPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 * Clase que implementa la conexion con la persistencia para la entidad de Cocina.
 * @author js.garcial1
 */
@Stateless
public class CocinaLogic {
    
    /**
     * Constante que representa el logger
     */
    private static final Logger LOGGER = Logger.getLogger(CocinaLogic.class.getName());
    
    /**
     * Conexion con Persistencia
     */
    private CocinaPersistence persistence;
    
    
    /**
     * METODOS 
     */
    
    
    
    /**
     * Retorna todas las Cocinas Entities que se encuentran en la base de datos
     * @return 
     */
    public List<CocinaEntity> getCocinas() {
        LOGGER.info("Inicia consulta de todas las cocinas");
        List<CocinaEntity> cocinas =  persistence.findAll();
        LOGGER.info("Termina la consulta de todas las cocinas");
        return cocinas;
    }
    
    /**
     * Retorna una Cocina Entity por id
     * @param id
     * @return 
     */
    public CocinaEntity getCocina( Long id ) {
        LOGGER.log(Level.INFO, "Inicia consulta de cocina con id = {0}", id);
        CocinaEntity cocina = persistence.find(id);
        if ( cocina ==  null )
            LOGGER.log(Level.INFO, "No existe una Cocina con el id = {0}", id);
        LOGGER.log(Level.INFO, "Termina la consulta de cocina con id = {0}", id);
        return cocina;
    }
    
    /**
     * Crea una Cocina y la guarda en la base de datos
     * @param entity de cocina a persistir
     * @return entidad de cocina persistida
     */
    public CocinaEntity createCocina( CocinaEntity entity ) {
        LOGGER.log(Level.INFO, "Inicia proceso de creacion de una cocina con id = {0}", entity.getId());
        persistence.create(entity);
        LOGGER.log(Level.INFO, "Termina proceso de creacion de una cocina con id = {0}", entity.getId());
        return entity;
    } 
    
    /**
     * Actualiza una Cocina por id
     * @param id de tipo Long, representa la cocina que se va a actualizar
     * @param entity de Cocina con los cambios deseados
     * @return la entidad de Cocina luego de ser actualizada
     */
    public CocinaEntity updateCocina( Long id, CocinaEntity entity ) {
        LOGGER.log(Level.INFO, "Inica proceso de actualizacion de la cocina con id = {0} " , id);
        CocinaEntity actualizado = persistence.update(entity);
        LOGGER.log( Level.INFO, "Termina proceso de actualizacion de la cocina, id = {0}", entity.getId() );
        return actualizado;
    }
    
    /**
     * Elimina una Cocina por id
     * @param id 
     */
    public void delete( Long id ) {
        LOGGER.log(Level.INFO, "Inicia eliminacion de la cocina con id = {0} " , id);
        persistence.delete(id);
        LOGGER.log( Level.INFO, "Cocina con id = {0} eliminada. ", id );
    }
    
}
