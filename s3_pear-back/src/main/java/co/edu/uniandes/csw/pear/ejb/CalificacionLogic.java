/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.ejb;

import co.edu.uniandes.csw.pear.entities.CalificacionEntity;
import co.edu.uniandes.csw.pear.entities.DietaTipoEntity;
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
    
    @Inject 
    private DietaTipoLogic dietaLogic;
    
    public CalificacionEntity createCalificacion(Long idDieta, CalificacionEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de calificacion");
        if(entity.getPuntuacion()>10)
        {
            throw new BusinessLogicException("la calificación no puede ser más de 10, si consideras que obtuvo un gran servicio puedes compartir tu historia en caso exito");
        }
        if(entity.getPuntuacion()<0)
        {
            throw new BusinessLogicException("La calificación no puede ser menos de 0, si considera que obtuvo un mal servicio puedes realizar tus quejas y reclamos");
        }
        DietaTipoEntity dieta = dietaLogic.getDieta(idDieta);
        entity.setDieta(dieta);
        LOGGER.info("Termina proceso de creación de calificacion");
        return persistence.create(entity);
    }

    public List<CalificacionEntity> getCalificaciones(Long idDieta) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de consultar todas las calificaciones");
        DietaTipoEntity dieta = dietaLogic.getDieta(idDieta);
        if(dieta.getCalificaciones()==null){
             throw new BusinessLogicException("La dieta que consulta aún no tiene calificaciones");
        }
        if(dieta.getCalificaciones().isEmpty()){
             throw new BusinessLogicException("La dieta que consulta aún no tiene calificaciones");
        }
        return persistence.findAll(idDieta);
    }

    public CalificacionEntity getCalificacion(Long dietaId, Long id) {
        return persistence.find(dietaId,id);
    }

    public CalificacionEntity updateCalificacion(Long dietaId,CalificacionEntity entity) throws BusinessLogicException  {
        
         LOGGER.info("Inicia proceso de actualizar ");
        DietaTipoEntity dieta = dietaLogic.getDieta(dietaId);
        entity.setDieta(dieta);
        return persistence.update(entity);
    }
    
    public void deleteCalificacion(Long dietaid, Long id) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de borrar ");
        CalificacionEntity old = getCalificacion(dietaid, id);
        persistence.delete(old.getId());
    }
}
