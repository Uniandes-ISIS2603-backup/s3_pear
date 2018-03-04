/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.ejb;

import co.edu.uniandes.csw.pear.entities.CityEntity;
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
    
    public QuejasyReclamosEntity createQuejasyReclamos(QuejasyReclamosEntity entity) throws BusinessLogicException {
        
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
          persistence.create(entity);
          LOGGER.info("Termina proceso de creación de quejas y reclamos");
          return entity;   
        }
        
         throw new BusinessLogicException("El asunto no corresponde a los 2 unicos disponibles : recomendacion o queja"); 
    }

    public List<QuejasyReclamosEntity> getQuejasyReclamos() {
        LOGGER.info("Inicia proceso de consultar todas las quejas y reclamos");
     
        List<QuejasyReclamosEntity> lista = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las quejas y reclamos");
        return lista;
    }

    public QuejasyReclamosEntity getQuejayReclamo(Long id) {
        return persistence.find(id);
    }

    public QuejasyReclamosEntity updateQuejayReclamo(QuejasyReclamosEntity entity) throws BusinessLogicException  {
        
        return persistence.update(entity);
    }
    
    public void deleteQuejayReclamo(QuejasyReclamosEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar queja y reclamo con id={0}", entity.getId());    
        persistence.delete(entity.getId());
        LOGGER.log(Level.INFO, "Termina proceso de borrar queja y reclamo con id={0}", entity.getId());
    }
}
