/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.ejb;

import co.edu.uniandes.csw.pear.entities.MedioPagoEntity;
import co.edu.uniandes.csw.pear.entities.PagoEntity;
import co.edu.uniandes.csw.pear.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.pear.persistence.PagoPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *Clase que hace la conexión entre la persistencia 
 * @author jp.campos
 */
@Stateless
public class PagoLogic {
    
    
    /**
     * Constante que representa el logger
     */
    private static final Logger LOGGER = Logger.getLogger(PagoLogic.class.getName());

    /**
     * Conexion con la Persistencia
     */
    @Inject
    private PagoPersistence persistence;
    
    
    /**
     * METODOS 
     */
    
    /**
     * Retorna todas los pagos Entities que se encuentran en la base de datos
     * @return 
     */
    public List<PagoEntity> getPagos(){
        LOGGER.info("Inicia consulta de todos los pagos");
        List<PagoEntity> pagos =  persistence.findAll();
        LOGGER.info("Termina la consulta de todos los pagos");
        return pagos;
    }
    
    /**
     * Retorna un pago entity 
     * @param id
     * @return 
     */
    public PagoEntity getPago( Long id ){
        LOGGER.log(Level.INFO, "Inicia consulta de un pago con id = {0}", id);
        PagoEntity pago = persistence.find(id);
        if ( pago ==  null )
            LOGGER.log(Level.INFO, "No existe un pago con el id = {0}", id);
        LOGGER.log(Level.INFO, "Termina la consulta de pago con id = {0}", id);
        return pago;
    }
    
    
    
    /**
     * Retorna el recaudoTotal de pagos
     * @return Pago con el total en el montoIncial.
     */
    
    public PagoEntity  getRecaudoTotal(){
        List<PagoEntity> todosP = getPagos(); 
        Double total = 0.0;
        
        for (PagoEntity pagoEntity : todosP){
            
            total += ( pagoEntity.getMontoFinal() + pagoEntity.getMontoInicial()) ;  
        }
        
        PagoEntity en = new PagoEntity(); 
        
        en.setMontoInicial(total);
        return en; 
    }
    
    /**
     * Retorno el medio de pago entity del pago con el id
     * @param pagoId
     * @return medio pago
     */
    public MedioPagoEntity getMedioPago(Long pagoId){
        return getPago(pagoId).getMedioPagoEntity(); 
    }
    
    
    public PagoEntity asociarMedioDePago(Long idPago, Long idMedio){
        MedioPagoEntity pMedio = new MedioPagoEntity(); 
        pMedio.setId(idMedio);
        PagoEntity pago = getPago(idPago); 
        pago.setMedioPagoEntity(pMedio);
        
        return pago;
    }
    
    /**
     * Crea un Pago y la guarda en la base de datos
     * @param entity de pago a persistir
     * @return entidad de pago persistida
     * @throws co.edu.uniandes.csw.pear.exceptions.BusinessLogicException
     */
    public PagoEntity createPago( PagoEntity entity ) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de creacion de un pago con id = {0}", entity.getId());
     
        validarPago(entity.getMontoFinal(), entity.getMontoInicial()); 
        
        persistence.create(entity);
        
      
        LOGGER.log(Level.INFO, "Termina proceso de creacion de un pago con id = {0}", entity.getId());
        return entity;
    }
    
    
    public boolean validarPago(double valorIncial, double valorFinal) throws BusinessLogicException{
        if(valorIncial < 0){
            throw new BusinessLogicException("El valor inicial es negativo"); 
        }
        if(valorFinal < 0){
            throw new BusinessLogicException("El valor final es negativo ");
        }
        return true; 
    }
    
    /**
     * Actualiza una Pago por id
     * @param entity de pago con los cambios deseados
     * @return la entidad de pago luego de ser actualizada
     */
    public PagoEntity updatePago(  PagoEntity entity ) {
        LOGGER.log(Level.INFO, "Inica proceso de actualizacion del pago con id = {0} " );
        PagoEntity actualizado = persistence.update(entity);
        LOGGER.log( Level.INFO, "Termina proceso de actualizacion del pago, id = {0}", entity.getId() );
        return actualizado;
    }
    
    /**
     * Elimina el pago con el id dado
     * @param id 
     */
    public void delete( Long id ) {
        LOGGER.log(Level.INFO, "Inicia eliminacion del pago con id = {0} " , id);
        persistence.delete(id);
        LOGGER.log( Level.INFO, "Pago con id = {0} eliminada. ", id );
    }
}
