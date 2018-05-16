/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.ejb;

import co.edu.uniandes.csw.pear.entities.CuentaCobroEntity;
import co.edu.uniandes.csw.pear.entities.PagoEntity;
import co.edu.uniandes.csw.pear.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.pear.persistence.CuentaCobroPersistence;
import java.util.ArrayList;
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
public class CuentaCobroLogic {
    
    
      /**
     * Constante que representa el logger
     */
    private static final Logger LOGGER = Logger.getLogger(CuentaCobroLogic.class.getName());

    /**
     * Conexion con la Persistencia
     */
    @Inject
    private CuentaCobroPersistence persistence;
    
    
    /**
     * METODOS 
     */
    
    
    /**
     * Retorna todas los cuentaCobro  Entities que se encuentran en la base de datos
     * @return 
     */
    public List<CuentaCobroEntity> getCuentas() {
        LOGGER.info("Inicia consulta de todas las cuentas de cobro");
        List<CuentaCobroEntity> todascuentasCobro =  persistence.findAll();
        List<CuentaCobroEntity> cuentasCobro = new ArrayList<>();
        for (CuentaCobroEntity cuentaCobroEntity : todascuentasCobro) {
           
            
            if ( cuentaCobroEntity.getValorAPagar() != null);
            {
                cuentasCobro.add(cuentaCobroEntity); 
            }
            
        }
        LOGGER.info("Termina la consulta de todas las cuentas de cobro");
        return cuentasCobro;
    }
    
    /**
     * Retorna una cuenta de cobro entity 
     * @param id
     * @return 
     */
    public CuentaCobroEntity getCuenta( Long id ) {
        LOGGER.log(Level.INFO, "Inicia consulta de una cuenta con id = {0}", id);
        CuentaCobroEntity cuentaCobro = persistence.find(id);
        if ( cuentaCobro ==  null )
            LOGGER.log(Level.INFO, "No existe un medio de una cuenta con el id = {0}", id);
        LOGGER.log(Level.INFO, "Termina la consulta una cuenta con id = {0}", id);
        return cuentaCobro;
    }
    
    /**
     * Crea una cuenta de cobro y la guarda en la base de datos
     * @param entity de pago a persistir
     * @return entidad de pago persistida
     * @throws co.edu.uniandes.csw.pear.exceptions.BusinessLogicException
     */
    public CuentaCobroEntity createCuenta( CuentaCobroEntity entity ) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de creacion de una cuenta de cobro con id = {0}", entity.getId());
        persistence.create(entity); 
        LOGGER.log(Level.INFO, "Termina proceso de creacion de una cuenta de cobro con id = {0}", entity.getId());
        return entity;
    } 
    
    

    
    /**
     * Actualiza una cuenta de cobro por id
     * @param entity de cuenta de cobro con los cambios deseados
     * @return la entidad de  cuenta de cobro luego de ser actualizada
     */
    public CuentaCobroEntity updateCuenta( CuentaCobroEntity entity ) {
        LOGGER.log(Level.INFO, "Inica proceso de actualizacion de la cuenta con id = {0} " );
        CuentaCobroEntity actualizado = persistence.update(entity);
        LOGGER.log( Level.INFO, "Termina proceso de actualizacion de la cuenta com  id = {0}", entity.getId() );
        return actualizado;
    }
    
    
      /**
     * Asocia un pago existente a una cuenta
     *
     * @param cuentaId Identificador de la instancia de libro
     * @param pagoEntity Identificador de la instancia de autor
     * @return Instancia de AuthorEntity que fue asociada a Book
     * 
     */
    public PagoEntity addPago(Long cuentaId, PagoEntity pagoEntity) {
        LOGGER.log(Level.INFO, "Inicia proceso de asociar un pago a la cuenta con id = {0}", cuentaId);
        CuentaCobroEntity cuentaEntity = getCuenta(cuentaId);
        cuentaEntity.setPagoEntity(pagoEntity);
        return pagoEntity;
    }
    
    /**
     * Retorna el pago de una cuenta
     * @param cuentaId
     * @return Pago
     */
    public PagoEntity getPago(Long cuentaId){
        CuentaCobroEntity cuentaEntity = getCuenta(cuentaId);
        return cuentaEntity.getPagoEntity();          
    }
    
    /**
     * Elimina la cuenta con el id dado
     * @param id 
     */
    public void delete( Long id ) {
        LOGGER.log(Level.INFO, "Inicia eliminacion la cuenta con id = {0} " , id);
        persistence.delete(id);
        LOGGER.log( Level.INFO, "Cuenta con id = {0} eliminada. ", id );
    }


    
    
    
}
