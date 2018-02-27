/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.ejb;

import co.edu.uniandes.csw.pear.entities.CalificacionEntity;
import co.edu.uniandes.csw.pear.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.pear.persistence.CalificacionPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ga.bejarano10
 */
@Stateless
public class CalificacionLogic {
    private static final Logger LOGGER = Logger.getLogger(CalificacionLogic.class.getName());

    @Inject
    private CalificacionPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias. 
     public CalificacionEntity createCalificacion(CalificacionEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de calificacion");
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de calificacion");
        return entity;
    }

    public List<CalificacionEntity> getCalificaciones() {
        LOGGER.info("Inicia proceso de consultar todas las calificaciones");
     
        List<CalificacionEntity> lista = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las calificaciones");
        return lista;
    }

    public CalificacionEntity getCalificacion(Long id) {
        return persistence.find(id);
    }

    public CalificacionEntity updateCalificacion(CalificacionEntity entity) throws BusinessLogicException  {
        
        return persistence.update(entity);
    }
    
    public void deleteCalificacion(CalificacionEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar calificacion con id={0}", entity.getId());    
        persistence.delete(entity.getId());
        LOGGER.log(Level.INFO, "Termina proceso de borrar calificacion con id={0}", entity.getId());
    }
}
