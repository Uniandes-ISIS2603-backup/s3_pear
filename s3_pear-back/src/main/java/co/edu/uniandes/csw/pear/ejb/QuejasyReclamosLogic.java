/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.ejb;

import co.edu.uniandes.csw.pear.entities.CityEntity;
import co.edu.uniandes.csw.pear.entities.DietaTipoEntity;
import co.edu.uniandes.csw.pear.entities.QuejasyReclamosEntity;
import co.edu.uniandes.csw.pear.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.pear.persistence.QuejasyReclamosPersistence;
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
public class QuejasyReclamosLogic 
{
   private static final Logger LOGGER = Logger.getLogger(QuejasyReclamosLogic.class.getName());

    @Inject
    private QuejasyReclamosPersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.
 
    @Inject 
    private DietaTipoLogic dietaLogic;
    
    public QuejasyReclamosEntity createQuejasyReclamos(Long idDieta,QuejasyReclamosEntity entity) throws BusinessLogicException {
        
        LOGGER.info("Inicia proceso de creación de quejas y reclamos");
        
        if(entity.getComentario().equals(""))
        {
            throw new BusinessLogicException("El comentario no puede estar vacio");
        }
        if(entity.getAsunto().equals(""))
        {
           throw new BusinessLogicException("El asunto no puede estar vacio");
        }
        if(entity.getAsunto().equals("recomendacion")||entity.getAsunto().equals("queja"))
        {
          DietaTipoEntity dieta = dietaLogic.getDieta(idDieta);
          entity.setDieta(dieta);
          LOGGER.info("Termina proceso de creación de calificacion");
          return persistence.create(entity); 
        }
        
         throw new BusinessLogicException("El asunto no corresponde a los 2 unicos disponibles : recomendacion o queja"); 
    }
    //seguir desde aqui
    public List<QuejasyReclamosEntity> getQuejasyReclamos(Long idDieta) {
        LOGGER.info("Inicia proceso de consultar todas las quejas y reclamos");
        DietaTipoEntity dieta = dietaLogic.getDieta(idDieta);
        LOGGER.info("Termina proceso de consultar todas las quejas y reclamos");
        return dieta.getQuejas();
    }

    public QuejasyReclamosEntity getQuejayReclamo(Long dietaid, Long id) {
        return persistence.find(dietaid, id);
    }

    public QuejasyReclamosEntity updateQuejayReclamo(Long dietaId,QuejasyReclamosEntity entity ) throws BusinessLogicException  {
        
        DietaTipoEntity dieta = dietaLogic.getDieta(dietaId);
        entity.setDieta(dieta);
        return persistence.update(entity);
    }
    
    public void deleteQuejayReclamo(Long dietaid, Long id) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de borrar ");
        QuejasyReclamosEntity old = getQuejayReclamo(dietaid, id);
        persistence.delete(old.getId());
    }
}
