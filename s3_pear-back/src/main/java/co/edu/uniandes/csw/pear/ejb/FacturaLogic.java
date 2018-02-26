/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.ejb;

import co.edu.uniandes.csw.pear.entities.FacturaEntity;
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
    private static final Logger LOGGER = Logger.getLogger(DietaTipoLogic.class.getName());
    
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
     * Crea una Factura y la guarda en la base de datos
     * @param entity de factura a persistir
     * @return entidad de factura  persistida
     */
    public FacturaEntity createFactura( FacturaEntity entity ) {
        LOGGER.log(Level.INFO, "Inicia proceso de creacion de una factura con id = {0}", entity.getId());
        persistence.create(entity);
        LOGGER.log(Level.INFO, "Termina proceso de creacion de una factura con id = {0}", entity.getId());
        return entity;
    } 
    
    /**
     * Actualiza una Factura segun su identificador
     * @param id de tipo Long, representa  el id de la factura que se va a actualizar
     * @param entity FacturaEntity con los cambios deseados
     * @return la entidad de factura luego de ser actualizada
     */
    public FacturaEntity updateFactura( Long id, FacturaEntity entity ) {
        LOGGER.log(Level.INFO, "Inica proceso de actualizacion de la factura con id = {0} " , id);
        FacturaEntity actualizado = persistence.update(entity);
        LOGGER.log( Level.INFO, "Termina proceso de actualizacion de la factura, id = {0}", entity.getId() );
        return actualizado;
    }
    
     /**
     * Elimina una factura segun su identificador
     * @param id identificador de la factura que se quiere eliminar
     */
    public void delete( Long id ) {
        LOGGER.log(Level.INFO, "Inicia el proceso de eliminacion de una factura con id = {0} " , id);
        persistence.delete(id);
        LOGGER.log( Level.INFO, "La factura con id = {0} fue eliminada. ", id );
    }
    
}
