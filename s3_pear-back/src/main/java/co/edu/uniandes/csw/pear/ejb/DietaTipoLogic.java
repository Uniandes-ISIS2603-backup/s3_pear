/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.ejb;

import co.edu.uniandes.csw.pear.entities.DietaTipoEntity;
import co.edu.uniandes.csw.pear.persistence.DietaTipoPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Clase que implementa la conexion con la persistencia para la entidad de DietaTipo.
 * @author js.garcial1  
 */
@Stateless
public class DietaTipoLogic {
    
    /**
     * Constante que representa el logger
     */
    private static final Logger LOGGER = Logger.getLogger(DietaTipoLogic.class.getName());

    /**
     * Conexion con la Persistencia
     */
    @Inject
    private DietaTipoPersistence persistence;
    
    
    /**
     * METODOS 
     */
    
    
    /**
     * Retorna todas las Dietas Entities que se encuentran en la base de datos
     * @return 
     */
    public List<DietaTipoEntity> getDietas() {
        LOGGER.info("Inicia consulta de todas las dietas");
        List<DietaTipoEntity> dietas =  persistence.findAll();
        LOGGER.info("Termina la consulta de todas las dietas");
        return dietas;
    }
    
    /**
     * Retorna una Dieta Entity  
     * @param id
     * @return 
     */
    public DietaTipoEntity getDieta( Long id ) {
        LOGGER.log(Level.INFO, "Inicia consulta de dieta con id = {0}", id);
        DietaTipoEntity dieta = persistence.find(id);
        if ( dieta ==  null )
            LOGGER.log(Level.INFO, "No existe una Dieta con el id = {0}", id);
        LOGGER.log(Level.INFO, "Termina la consulta de dieta con id = {0}", id);
        return dieta;
    }
    
    /**
     * Crea una Dieta y la guarda en la base de datos
     * @param entity de dieta a persistir
     * @return entidad de dieta persistida
     */
    public DietaTipoEntity createDieta( DietaTipoEntity entity ) {
        LOGGER.log(Level.INFO, "Inicia proceso de creacion de una dieta con id = {0}", entity.getId());
        persistence.create(entity);
        LOGGER.log(Level.INFO, "Termina proceso de creacion de una dieta con id = {0}", entity.getId());
        return entity;
    } 
    
    /**
     * Actualiza una Dieta por id
     * @param id de tipo Long, representa la dieta que se va a actualizar
     * @param entity de Dieta con los cambios deseados
     * @return la entidad de Dieta luego de ser actualizada
     */
    public DietaTipoEntity updateDieta( Long id, DietaTipoEntity entity ) {
        LOGGER.log(Level.INFO, "Inica proceso de actualizacion de la dieta con id = {0} " , id);
        DietaTipoEntity actualizado = persistence.update(entity);
        LOGGER.log( Level.INFO, "Termina proceso de actualizacion de la dieta, id = {0}", entity.getId() );
        return actualizado;
    }
    
    public void delete( Long id ) {
        LOGGER.log(Level.INFO, "Inicia eliminacion de la dieta con id = {0} " , id);
        persistence.delete(id);
        LOGGER.log( Level.INFO, "Dieta con id = {0} eliminada. ", id );
    }
    
}
