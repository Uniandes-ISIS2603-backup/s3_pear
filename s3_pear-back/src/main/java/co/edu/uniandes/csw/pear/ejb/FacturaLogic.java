/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.ejb;

import co.edu.uniandes.csw.pear.entities.FacturaEntity;
import co.edu.uniandes.csw.pear.entities.PersonaEntity;
import co.edu.uniandes.csw.pear.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.pear.persistence.FacturaPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *Clase que implementa la conexión con la persistencia para la Entidad FacturaEntity
 * @author v.chacon
 */

@Stateless
public class FacturaLogic {
    
     /**
     * Constante que representa el logger
     */
    private static final Logger LOGGER = Logger.getLogger(FacturaLogic.class.getName());
    
    /**
     * Conexion con la Persistencia
     */
    @Inject
    private FacturaPersistence persistence;
    
    
    //----------------------------------------------------------------
    //Metodos
    //----------------------------------------------------------------
    
    /**
     * Retorna todas las FacturaEntity que se encuentran en la base de datos
     * @return lista con las entidades
     */
    public List<FacturaEntity> getFacturas() {
        LOGGER.info("Inicia consulta de todas las facturas");
        List<FacturaEntity>  facturas =  persistence.findAll();
        LOGGER.info("Termina la consulta de todas las facturas");
        return facturas;
    }
    
    /**
     * Retorna la FacturaEntity que tiene el identificador que entra como parametro  
     * @param id identificador de la factura que se quiere buscar
     * @return factura con identificador dado
     */
    public FacturaEntity getFactura( Long id ) {
        LOGGER.log(Level.INFO, "Inicia consulta de la factura con id = {0}", id);
        FacturaEntity factura = persistence.find(id);
        if ( factura ==  null )
            LOGGER.log(Level.INFO, "No existe una factura  con el id = {0}", id);
        LOGGER.log(Level.INFO, "Termina la consulta de la factur con id = {0}", id);
        return factura;
    }
    
    
    /**
     * Retorna la PersonaEntity de la Factura
     * @param idFactura identificador de la factura 
     * @return la persona dueña de la factura
     */
    public PersonaEntity getPersonaDeFactura(Long idFactura){
        LOGGER.log(Level.INFO, "Inicia proceso de consultar la persona de la factura con id = {0}", idFactura);
        return this.getFactura(idFactura).getPersona();
    }
    /**
     * Crea una Factura y la guarda en la base de datos
     * @param entity de factura a persistir
     * @return entidad de factura  persistida
     * @throws co.edu.uniandes.csw.pear.exceptions.BusinessLogicException
     */
    public FacturaEntity createFactura( FacturaEntity entity ) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de creacion de una factura con id = {0}", entity.getId());
        if(persistence.find(entity.getId())!= null){
            throw new BusinessLogicException("Ya existe una factura con el identificador dado");
        }
        if(entity.getCantidadDeProductos()< 0){
            throw new BusinessLogicException("No puede haber una cantidad negativa de productos");
        }
         if(entity.getNumeroFactura()< 0){
            throw new BusinessLogicException("No puede haber un numero de factura negativo");
        }
        persistence.create(entity);
        LOGGER.log(Level.INFO, "Termina proceso de creacion de una factura con id = {0}", entity.getId());
        return entity;
    } 
    
    /**
     * Actualiza una Factura segun su identificador
     * @param entity FacturaEntity con los cambios deseados
     * @return la entidad de factura luego de ser actualizada
     * @throws co.edu.uniandes.csw.pear.exceptions.BusinessLogicException
     */
    public FacturaEntity updateFactura(FacturaEntity entity ) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inica proceso de actualizacion de la factura con id = {0} " , entity.getId());
        if(persistence.find(entity.getId()) == null ||  entity.getId() == null){
            throw new BusinessLogicException("No existe una factura con ese identificador");
        }
        if(entity.getCantidadDeProductos()< 0){
            throw new BusinessLogicException("No puede haber una cantidad negativa de productos");
        }
        if(entity.getNumeroFactura()< 0){
            throw new BusinessLogicException("No puede haber un numero de factura negativo");
        }
        FacturaEntity actualizado = persistence.update(entity);
        LOGGER.log( Level.INFO, "Termina proceso de actualizacion de la factura, id = {0}", entity.getId() );
        return actualizado;
    }
    
     /**
     * Elimina una factura segun su identificador
     * @param id identificador de la factura que se quiere eliminar
     * @throws co.edu.uniandes.csw.pear.exceptions.BusinessLogicException
     */
    public void deleteFactura( Long id ) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia el proceso de eliminacion de una factura con id = {0} " , id);
        if(persistence.find(id) == null){
            throw new BusinessLogicException("No existe un dia con ese identificador");
        }
        persistence.delete(id);
        LOGGER.log( Level.INFO, "La factura con id = {0} fue eliminada. ", id );
    }
    
}

