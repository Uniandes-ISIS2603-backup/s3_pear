/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.ejb;

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
     * Retorna una instancia de Semana por Id asociada a una Dieta por Id
     * @param semanaId
     * @param dietaId
     * @return semana entity por id asociada a la dieta por id
     */
    public SemanaEntity getSemanaDeDieta( Long semanaId, Long dietaId ) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar la Semana con id = {0} de la Dieta con id = {1}", new Object[]{semanaId, dietaId});           
        List<SemanaEntity> list = this.getDieta(dietaId).getSemanas();
        SemanaEntity semana = new SemanaEntity();
        semana.setId(semanaId);
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
        if ( entity == null) throw new BusinessLogicException( "Dieta ivalida, es null" );
        if ( entity.getDescripcion().isEmpty() || entity.getDescripcion() == null) throw new BusinessLogicException( "Descripcion de Dieta invalida" );
        if ( entity.getObjetivo().isEmpty() || entity.getObjetivo() == null ) throw new BusinessLogicException( "Objetivo de Dieta invalida" ) ;
        //if ( !entity.getName().isEmpty() || entity.getName() != null ) throw new BusinessLogicException( "Nombre de Dieta invalida" ) ;
        //if ( entity.getId() == null ) throw new BusinessLogicException( "El ID de la Dieta NO puede ser NULL" )  ;
    }
    
    /**
     * Asocia una Semana existente a una Dieta
     * @param semanaId
     * @param dietaId
     * @return 
     */
    public SemanaEntity addSemanaToDieta ( Long semanaId, Long dietaId ) {
        LOGGER.log(Level.INFO, "Inicia proceso de asociar una Semana con id = {0} con una Dieta con id = {1}", new Object[] {semanaId, dietaId});
        SemanaEntity semanita = new SemanaEntity();
        semanita.setId(semanaId);
        this.getDieta(dietaId).getSemanas().add(semanita);
        return this.getSemanaDeDieta(semanaId, dietaId);
    }
    
   
    
    /**
     * Actualiza una Dieta por id
     * @param id de tipo Long, representa la dieta que se va a actualizar
     * @param entity de Dieta con los cambios deseados
     * @return la entidad de Dieta luego de ser actualizada
     */
    public DietaTipoEntity updateDieta( Long id, DietaTipoEntity entity ) throws BusinessLogicException {
        if ( persistence.find(entity.getId()) == null ) throw new BusinessLogicException("la dieta que se piensa eliminar no existe. ID = " + entity.getId());
        LOGGER.log(Level.INFO, "Inica proceso de actualizacion de la dieta con id = {0} " , id);
        DietaTipoEntity actualizado = persistence.update(entity);
        verificaciones(actualizado);
        LOGGER.log( Level.INFO, "Termina proceso de actualizacion de la dieta, id = {0}", entity.getId() );
        return actualizado;
    }
    
    
    /**
     * =======================================
     * SI DE VERDAD SE VAN A USAR ESTOS METDOS, 
     * HAY QUE CAMBIAR LA IMPLEMENTACIÓN USANDO 
     * COMO BASE EL METODO updateDieta QUE 
     * SÍ SIRVE Y SE MODIFICO
     * =======================================
     */
    
    
    /**
     * Reemplaza la lista de semanas de una dieta por la que entra como parametro
     * @param semanas
     * @param dietaId
     * @return 
     */
    public List<SemanaEntity> updateSemanasDeDieta( List<SemanaEntity> semanas, long dietaId ) {
        LOGGER.log(Level.INFO, "Inicia proceso de reemplazar la lista de semanas de Dieta con id = {0}", new Object[] { dietaId});
        this.getDieta(dietaId).setSemanas(semanas);
        return this.getDieta(dietaId).getSemanas();
    }
    
  
    
    /**
     * =======================================
     * 
     * =======================================
     */
    
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
     * @param semanaId
     * @param dietaId 
     */
    public void deleteSemanaDeDieta( Long semanaId, Long dietaId ) {
        LOGGER.log(Level.INFO, "Inicia proceso de eliminar la Semana con id = {0} de la Dieta con id = {1}", new Object[]{semanaId,dietaId});
        SemanaEntity semana = new SemanaEntity();
        semana.setId(semanaId);
        this.getDieta(dietaId).getSemanas().remove(semana);
    }
    
    
    
}
