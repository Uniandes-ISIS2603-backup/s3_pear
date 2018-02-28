/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.ejb;

import co.edu.uniandes.csw.pear.entities.CasoExitoEntity;
import co.edu.uniandes.csw.pear.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.pear.persistence.CasoExitoPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author pa.suarezm
 */
@Stateless
public class CasoExitoLogic {
    
    private static final Logger LOGGER = Logger.getLogger(CasoExitoLogic.class.getName());
    
    @Inject
    private CasoExitoPersistence persistence;
    
    /**
     * Para crear un caso exito se deben seguir las siguiente reglas.
     * 1. Ningún atributo puede ser null ni vacío
     * 2. El caso tiene que estar asociado a una dieta
     * @param entity Entidad para crear
     * @return La entidad creada
     * @throws BusinessLogicException Si no se respeta alguna de las reglas de negocio
     */
    public CasoExitoEntity createCasoExito(CasoExitoEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de casoExito");
        if (entity.getComentario() == null || entity.getTestimonio() == null) {
            throw new BusinessLogicException("El caso exito no puede tener atributos nulos");
        }
        else if(entity.getComentario().equals("") || entity.getTestimonio().equals("")){
            throw new BusinessLogicException("El caso exito no puede tener comentarios ni testimonios vacíos");
        }
        // Invoca la persistencia para crear el caso exito
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de casoExito");
        return entity;
    }
    
    /**
     * Da la lista de todos los casos exito.
     * @return Lista con los casos exito
     */
    public List<CasoExitoEntity> getCasosExito() {
        LOGGER.info("Inicia proceso de consultar todos los casos");
        // Note que, por medio de la inyección de dependencias se llama al método "findAll()" que se encuentra en la persistencia.
        List<CasoExitoEntity> casos = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los casos");
        return casos;
    }
    
    /**
     * Busca un caso exito por su identificador.
     * @param id Identificador del caso a buscar.
     * @return Caso encontrado (null si no existe ningún caso con el id)
     */
    public CasoExitoEntity getCasoExito(Long id) {
        return persistence.find(id);
    }
    
    /**
     * Actualiza el caso que entra por parametro.
     * @param entity Caso nuevo
     * @return Caso actualizado
     * @throws BusinessLogicException Si no existe el caso que se quiere actualizar
     */
    public CasoExitoEntity updateCasoExito(CasoExitoEntity entity) throws BusinessLogicException  {
        if (persistence.find(entity.getId()) == null) {
            throw new BusinessLogicException("El caso que se quiere actualizar no existe");
        }
        return persistence.update(entity);
    }
    
    /**
     * Elimina el caso que entra por parametro
     * @param entity Caso a eliminar
     */
    public void deleteCasoExito(CasoExitoEntity entity){
        LOGGER.log(Level.INFO, "Inicia proceso de borrar caso con id={0}", entity.getId());    
        persistence.delete(entity.getId());
        LOGGER.log(Level.INFO, "Termina proceso de borrar caso con id={0}", entity.getId());
    }
}
