/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.ejb;

import co.edu.uniandes.csw.pear.entities.MedioPagoEntity;
import co.edu.uniandes.csw.pear.entities.PersonaEntity;
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
     * Asocia una persona existente a un medio de pago
     *
     * @param medioPagoId Identificador de la instancia de medio de pago
     * @param personaId Identificador de la instancia de persona
     * @return Instancia de PersonaEntity que fue asociada a medioPago
     * 
     */
    public PersonaEntity addPersona(Long medioPagoId, Long personaId) {
        LOGGER.log(Level.INFO, "Inicia proceso de asociar una persona a un medio de pago con id = {0}", medioPagoId);
        MedioPagoEntity medioPagoEntity = getMedioPago(medioPagoId);
        PersonaEntity personaEntity = new PersonaEntity();
        personaEntity.setId(personaId  );
        medioPagoEntity.getPersonas().add(personaEntity);
        return getPersona(medioPagoId, personaId);
    }
    
    

    /**
     * Obtiene una instancia de PersonaEntity asociada a una instancia de medioPago
     *
     * @param medioPagoId Identificador de la instancia de medio de pago
     * @param personaId Identificador de la instancia de persona
     * @return La entidad de la persona asociada al medio de pago
     */
    public PersonaEntity getPersona(Long medioPagoId, Long personaId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar una persona con el li con id = {0}", medioPagoId);
        List<PersonaEntity> list = getMedioPago(medioPagoId).getPersonas();
        PersonaEntity personaEntity = new PersonaEntity();
        personaEntity.setId(personaId);
        int index = list.indexOf(personaEntity);
        if (index >= 0) {
            return list.get(index);
        }
        return null;
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
        if(!verificarMedioPago(entity.getMedioActual()))
        {
            throw new BusinessLogicException("El medio de pago no es uno aceptado");
        }else
        {
            persistence.create(entity);
        }
        LOGGER.log(Level.INFO, "Termina proceso de creacion de un medio pago con id = {0}", entity.getId());
        return entity;
    } 
    
    /**
     * Actualiza un medio Pago por id
     * @param id de tipo Long, representa el medio de pago que se va a actualizar
     * @param entity de medio de  pago con los cambios deseados
     * @return la entidad de medio de pago luego de ser actualizada
     */
    public MedioPagoEntity updatePago( Long id, MedioPagoEntity entity ) {
        LOGGER.log(Level.INFO, "Inica proceso de actualizacion del medio de pago con id = {0} " , id);
        MedioPagoEntity actualizado = persistence.update(entity);
        LOGGER.log( Level.INFO, "Termina proceso de actualizacion del medio de pago, id = {0}", entity.getId() );
        return actualizado;
    }
    
    public boolean verificarMedioPago(String medioPago)
    {
        if(medioPago.equals("Crédito")||medioPago.equals("Débito")||medioPago.equals("Efectivo")||medioPago.equals("Baloto"))
        {
            return true; 
        }
        
        return false; 
    }
    
     /**
     * Desasocia una Persona existente de un medio de pago existente
     *
     * @param medioPagoId Identificador de la instancia de medio de pago
     * @param personaId Identificador de la instancia de persona
     * 
     */
    public void removePersona(Long medioPagoId, Long personaId) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un autor del libro con id = {0}", medioPagoId);
        MedioPagoEntity entity = getMedioPago(medioPagoId);
        PersonaEntity personaEntity = new PersonaEntity();
        personaEntity.setId(personaId);
        entity.getPersonas().remove(personaEntity);
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
