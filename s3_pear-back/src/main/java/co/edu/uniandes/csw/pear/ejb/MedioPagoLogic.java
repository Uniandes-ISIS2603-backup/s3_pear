/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.ejb;

import co.edu.uniandes.csw.pear.entities.MedioPagoEntity;
import co.edu.uniandes.csw.pear.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.pear.persistence.MedioPagoPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author jp.campos
 */
@Stateless
public class MedioPagoLogic {
 
      /**
     * Constante que representa el logger
     */
    private static final Logger LOGGER = Logger.getLogger(MedioPagoLogic.class.getName());

    /**
     * Conexion con la Persistencia
     */
    @Inject
    private MedioPagoPersistence persistence;
    
    
    /**
     * METODOS 
     */
    
    
    /**
     * Retorna todas los medios de pago Entities que se encuentran en la base de datos
     * @return 
     */
    public List<MedioPagoEntity> getMediosPago() {
        LOGGER.info("Inicia consulta de todos los medios de pago");
        List<MedioPagoEntity> mediosPago =  persistence.findAll();
        LOGGER.info("Termina la consulta de todos los medios pago");
        return mediosPago;
    }

    
    

    
    
    /**
     * Busca un medio pago por ID
     * @param id El id del libro a buscar
     * @return El libro encontrado, null si no lo encuentra.
     */
    public MedioPagoEntity getMedioPago(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar medio de pago con id={0}", id);
        MedioPagoEntity medioPago = persistence.find(id);
        if (medioPago == null) {
            LOGGER.log(Level.SEVERE, "El medio de pago con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar medio de pago con id={0}", id);
        return medioPago;
    }

    
    /**
     * Crea un medio de Pago y la guarda en la base de datos
     * @param entity de pago a persistir
     * @return entidad de pago persistida
     */
    public MedioPagoEntity createMedioPago( MedioPagoEntity entity ) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de creacion de un medio pago con id = {0}", entity.getId());
        persistence.create(entity);
        LOGGER.log(Level.INFO, "Termina proceso de creacion de un medio pago con id = {0}", entity.getId());
        return entity;
    } 
    
    /**
     * Actualiza un medio Pago por id
     * @param entity de medio de  pago con los cambios deseados
     * @return la entidad de medio de pago luego de ser actualizada
     */
    public MedioPagoEntity updateMedioPago(MedioPagoEntity entity ) {
        LOGGER.log(Level.INFO, "Inica proceso de actualizacion del medio de pago con id = {0} " );
        MedioPagoEntity actualizado = persistence.update(entity);
        LOGGER.log( Level.INFO, "Termina proceso de actualizacion del medio de pago, id = {0}", entity.getId() );
        return actualizado;
    }
    
  
    

    
    /**
     * Elimina el medio de pago con el id dado
     * @param id 
     */
    public void delete( Long id ) {
        LOGGER.log(Level.INFO, "Inicia eliminacion de medio pago con id = {0} " , id);
        persistence.delete(id);
        LOGGER.log( Level.INFO, "Pago con id = {0} eliminada. ", id );
    }
    
    
}
