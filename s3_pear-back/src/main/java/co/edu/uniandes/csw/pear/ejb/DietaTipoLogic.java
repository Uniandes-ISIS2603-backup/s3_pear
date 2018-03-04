/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.ejb;

import co.edu.uniandes.csw.pear.entities.CuentaCobroEntity;
import co.edu.uniandes.csw.pear.entities.DietaTipoEntity;
import co.edu.uniandes.csw.pear.entities.SemanaEntity;
import co.edu.uniandes.csw.pear.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.pear.persistence.DietaTipoPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Clase que implementa la conexion con la persistencia para la entidad de DietaTipo.
 * @author js.garcial1  
 */
@Stateless
public class DietaTipoLogic {
    
    /**
     * Constante que representa el logger
     */
    private static final Logger LOGGER = Logger.getLogger(DietaTipoLogic.class.getName());

    /**
     * Conexion con la Persistencia
     */
    @Inject
    private DietaTipoPersistence persistence;
    
    
    /**
     * METODOS 
     */
    
    
    /**
     * Retorna todas las Dietas Entities que se encuentran en la base de datos
     * @return 
     */
    public List<DietaTipoEntity> getDietas() {
        LOGGER.info("Inicia consulta de todas las dietas");
        List<DietaTipoEntity> dietas =  persistence.findAll();
        LOGGER.info("Termina la consulta de todas las dietas");
        return dietas;
    }
    
    /**
     * Retorna una Dieta Entity  
     * @param id
     * @return 
     */
    public DietaTipoEntity getDieta( Long id ) {
        LOGGER.log(Level.INFO, "Inicia consulta de dieta con id = {0}", id);
        DietaTipoEntity dieta = persistence.find(id);
        if ( dieta ==  null )
            LOGGER.log(Level.INFO, "No existe una Dieta con el id = {0}", id);
        LOGGER.log(Level.INFO, "Termina la consulta de dieta con id = {0}", id);
        return dieta;
    }
    
    /**
     * Retorna una colection de instancias de Semana asociadas a la Dieta por id
     * @param dieta_id
     * @return lista de semanas tipo entity de la dieta
     */
    public List<SemanaEntity> getSemanasDeDieta( Long dieta_id ) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todas las semanas de la dieta con id = {0}", dieta_id);
        return this.getDieta(dieta_id).getSemanas();
    }
    
    /**
     * Retorna la instacia de Cuenta de Cobro asociada a la Dieta por id
     * @param dieta_id
     * @return cuenta de cobro entity de la dietas
     */
    public CuentaCobroEntity getCuentaCobroDeDieta( Long dieta_id ) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar la Cuenta de Cobro de la Dieta con id = {0}", dieta_id);
        return this.getDieta(dieta_id).getCuentaCobro();
    }
    
    /**
     * Retorna una instancia de Semana por Id asociada a una Dieta por Id
     * @param semana_id
     * @param dieta_id
     * @return semana entity por id asociada a la dieta por id
     */
    public SemanaEntity getSemanaDeDieta( Long semana_id, Long dieta_id ) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar la Semana con id = {0} de la Dieta con id = {1}", new Object[]{semana_id, dieta_id});           
        List<SemanaEntity> list = this.getDieta(dieta_id).getSemanas();
        SemanaEntity semana = new SemanaEntity();
        semana.setId(semana_id);
        int index = list.indexOf(semana);
        if (index >= 0) 
            return list.get(index);
        return null;
    }
    
    /**
     * Crea una Dieta y la guarda en la base de datos
     * @param entity de dieta a persistir
     * @return entidad de dieta persistida
     */
    public DietaTipoEntity createDieta( DietaTipoEntity entity ) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de creacion de una dieta con id = {0}", entity.getId());
        verificaciones(entity);
        persistence.create(entity);
        LOGGER.log(Level.INFO, "Termina proceso de creacion de una dieta con id = {0}", entity.getId());
        return entity;
    } 
    
    /**
     * Verifica las reglas del negocio
     * @param entity a verificar
     */
    private void verificaciones( DietaTipoEntity entity) throws BusinessLogicException {
        if ( !entity.getDescripcion().isEmpty() || entity.getDescripcion() != null) throw new BusinessLogicException( "Descripcion de Dieta invalida" );
        if ( !entity.getObjetivo().isEmpty() || entity.getObjetivo() != null ) throw new BusinessLogicException( "Objetivo de Dieta invalida" ) ;
        //if ( !entity.getName().isEmpty() || entity.getName() != null ) throw new BusinessLogicException( "Nombre de Dieta invalida" ) ;
        if ( entity.getId() != null ) throw new BusinessLogicException( "El ID de la Dieta NO puede ser NULL" )  ;
    }
    
    /**
     * Asocia una Semana existente a una Dieta
     * @param semana_id
     * @param dieta_id
     * @return 
     */
    public SemanaEntity addSemanaToDieta ( Long semana_id, Long dieta_id ) {
        LOGGER.log(Level.INFO, "Inicia proceso de asociar una Semana con id = {0} con una Dieta con id = {1}", new Object[] {semana_id, dieta_id});
        SemanaEntity semanita = new SemanaEntity();
        semanita.setId(semana_id);
        this.getDieta(dieta_id).getSemanas().add(semanita);
        return this.getSemanaDeDieta(semana_id, dieta_id);
    }
    
    /**
     * Asocia una Cuenta de Cobro existente con una Dieta
     * @param cuenta_id
     * @param dieta_id
     * @return 
     */
    public CuentaCobroEntity addCuentaCobroToDieta( Long cuenta_id, Long dieta_id ) {
        LOGGER.log(Level.INFO, "Inicia proceso de asociar una Cuenta de Cobro con id = {0} con una Dieta con id = {1}", new Object[]{cuenta_id, dieta_id});
        CuentaCobroEntity cc = new CuentaCobroEntity();
        cc.setId(dieta_id);
        this.getDieta(dieta_id).setCuentaCobro(cc);
        return this.getCuentaCobroDeDieta(dieta_id);
    }
    
    /**
     * Actualiza una Dieta por id
     * @param id de tipo Long, representa la dieta que se va a actualizar
     * @param entity de Dieta con los cambios deseados
     * @return la entidad de Dieta luego de ser actualizada
     */
    public DietaTipoEntity updateDieta( Long id, DietaTipoEntity entity ) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inica proceso de actualizacion de la dieta con id = {0} " , id);
        verificaciones(entity);
        DietaTipoEntity actualizado = persistence.update(entity);
        LOGGER.log( Level.INFO, "Termina proceso de actualizacion de la dieta, id = {0}", entity.getId() );
        return actualizado;
    }
    
    /**
     * Reemplaza la lista de semanas de una dieta por la que entra como parametro
     * @param semanas
     * @param dieta_id
     * @return 
     */
    public List<SemanaEntity> updateSemanasDeDieta( List<SemanaEntity> semanas, long dieta_id ) {
        LOGGER.log(Level.INFO, "Inicia proceso de reemplazar la lista de semanas de Dieta con id = {0}", new Object[] { dieta_id});
        this.getDieta(dieta_id).setSemanas(semanas);
        return this.getDieta(dieta_id).getSemanas();
    }
    
    /**
     * Actualiza la Cuenta de Cobro por id de una Dieta por id
     * @param cuenta_id
     * @param dieta_id
     * @return 
     */
    public CuentaCobroEntity updateCuentaCobroDeDieta( Long cuenta_id, Long dieta_id ) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar la cuenta de cobro con id = {0} de Dieta con id = {1}", new Object[] { cuenta_id, dieta_id});
        CuentaCobroEntity cc = new CuentaCobroEntity();
        cc.setId(cuenta_id);
        this.getDieta(dieta_id).setCuentaCobro(cc);
        return this.getCuentaCobroDeDieta(dieta_id);
    }
    
    /**
     * Elimina una Dieta por id
     * @param id 
     */
    public void deleteDieta( Long id ) {
        LOGGER.log(Level.INFO, "Inicia eliminacion de la dieta con id = {0} " , id);
        persistence.delete(id);
        LOGGER.log( Level.INFO, "Dieta con id = {0} eliminada. ", id );
    }
    
    /**
     * Elimina una Semana por id de la Dieta por id
     * @param semana_id
     * @param dieta_id 
     */
    public void deleteSemanaDeDieta( Long semana_id, Long dieta_id ) {
        LOGGER.log(Level.INFO, "Inicia proceso de eliminar la Semana con id = {0} de la Dieta con id = {1}", new Object[]{semana_id,dieta_id});
        SemanaEntity semana = new SemanaEntity();
        semana.setId(semana_id);
        this.getDieta(dieta_id).getSemanas().remove(semana);
    }
    
    /**
     * Elimina la Cuenta de Cobro asociada con la Dieta
     * @param dieta_id 
     */
    public void deleteCuentaCobroDeDieta( Long dieta_id ) {
        LOGGER.log(Level.INFO, "La Cuenta de Cobro de la Dieta con id = {0} se va a eliminar", dieta_id);
        this.getDieta(dieta_id).setCuentaCobro(null);
    }
    
}
