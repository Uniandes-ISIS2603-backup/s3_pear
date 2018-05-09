/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.ejb;

import co.edu.uniandes.csw.pear.entities.DiaEntity;
import co.edu.uniandes.csw.pear.entities.SemanaEntity;
import co.edu.uniandes.csw.pear.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.pear.persistence.SemanaPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Clase que implementa la conexión con la persistencia para la entidad SemanaEntity
 * @author v.chacon
 */

@Stateless
public class SemanaLogic {
    
    /**
     * Constante que representa el logger
     */
    private static final Logger LOGGER = Logger.getLogger(SemanaLogic.class.getName());
    
     /**
     * Conexion con la Persistencia
     */
    @Inject
    private SemanaPersistence persistence;
    
    
    //----------------------------------------------------------------
    //Metodos
    //----------------------------------------------------------------
    
    /**
     * Retorna todas las SemanaEntity que se encuentran en la base de datos
     * @return lista con las entidades
     */
    public List<SemanaEntity> getSemanas() {
        LOGGER.info("Inicia consulta de todas las semanas");
        List<SemanaEntity>  semanas =  persistence.findAll();
        LOGGER.info("Termina la consulta de todas las semanas");
        return semanas;
    }
    
    /**
     * Retorna la SemanaEntity que tiene el identificador que entra como parametro  
     * @param id identificador de la semana que se quiere buscar
     * @return semana con identificador dado
     */
    public SemanaEntity getSemana( Long id ) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia consulta de la semana con id = {0}", id);
        SemanaEntity semana = persistence.find(id);
        if ( semana ==  null ){
            LOGGER.log(Level.INFO, "No existe una semana  con el id = {0}", id);
            throw new BusinessLogicException("no existe una semana con ese identificador");
        }
        LOGGER.log(Level.INFO, "Termina la consulta de la semana con id = {0}", id);
        return semana;
    }
    
    
    /**
     * Retorna una lista con los dias de la semana
     * @param id identificador de la semana
     * @return lista de dias tipo entity de la semana
     */
    public List<DiaEntity> getDiasSemana(Long id) throws BusinessLogicException{
      LOGGER.log(Level.INFO, "Inicia proceso de consultar todas los dias de la semana con id = {0}", id);
      return this.getSemana(id).getDias();
    }
    
    
    /**
     * Retorna un dia especifico de una semana especifica
     * @param idDia identificador del dia
     * @param idSemana identificador de la semana
     * @return dia con el id dado que corresponde a la semana dada
     */
    public DiaEntity getDiaSemana(Long idDia, Long idSemana) throws BusinessLogicException{
         LOGGER.log(Level.INFO, "Inicia proceso de consultar el Dia con id = {0} de la Semana con id = {1}", new Object[]{idDia, idSemana});           
         List<DiaEntity> listaDias =this.getSemana(idSemana).getDias();
         DiaEntity dia = new DiaEntity();
         dia.setId(idDia);
         int index = listaDias.indexOf(dia);
         if (index >= 0) 
            return listaDias.get(index);
        return null;     
    }
    
    /**
     * Crea una Semana y la guarda en la base de datos
     * @param entity de semana a persistir
     * @return entidad de semana  persistida
     * @throws co.edu.uniandes.csw.pear.exceptions.BusinessLogicException
     */
    public SemanaEntity createSemana( SemanaEntity entity ) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de creacion de una semana con id = {0}", entity.getId());

//        if(entity.getListaDias().size()!= 7){
//            throw new BusinessLogicException("No pueden haber mas de 7 dias en una semana");
//        }
        if(persistence.find(entity.getId())!= null){
            throw new BusinessLogicException("Ya existe una semana con ese identificador");
        }
        if(entity.getFechaLunes() == null || entity.getFechaLunes() == ""){
            throw new BusinessLogicException("La fecha no puede ser vacia");
        }
        persistence.create(entity);
        LOGGER.log(Level.INFO, "Termina proceso de creacion de una semana con id = {0}", entity.getId());
        return entity;
    } 
    
    
    /**
     * Actualiza una Semana segun su identificador
     * @param id de tipo Long, representa  el id de la semana que se va a actualizar
     * @param entity SemanaEntity con los cambios deseados
     * @return la entidad de semana luego de ser actualizada
     * @throws co.edu.uniandes.csw.pear.exceptions.BusinessLogicException
     */
    public SemanaEntity updateSemana( Long id, SemanaEntity entity ) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inica proceso de actualizacion de la semana con id = {0} " , id);

//        if(entity.getListaDias().size()== 7){
//            throw new BusinessLogicException("Ya hay 7 dias en la semana");
//        }
        if(persistence.find(id) == null || entity.getId() == null){
            throw new BusinessLogicException("No existe una semana con ese identificador");
        }
        SemanaEntity actualizado = persistence.update(entity);
        LOGGER.log( Level.INFO, "Termina proceso de actualizacion de la semana, id = {0}", entity.getId() );
        return actualizado;
    }
    
    
    public DiaEntity addDiaToSemana(Long idDia, Long idSemana) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de asociar un Dia con id = {0} con una Semana con id = {1}", new Object[] {idDia, idSemana});
        DiaEntity di = new DiaEntity();
        di.setId(idDia);
        this.getSemana(idSemana).getDias().add(di);
        return this.getDiaSemana(idDia, idSemana);
        }
    /**
     * Elimina una semana segun su identificador
     * @param id identificador de la semana que se quiere eliminar
     * @throws co.edu.uniandes.csw.pear.exceptions.BusinessLogicException
     */
    public void deleteSemana( Long id ) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia el proceso de eliminacion de una semana con id = {0} " , id);
        if(persistence.find(id) == null){
            throw new BusinessLogicException("No existe un dia con ese identificador");
        }
        persistence.delete(id);
        LOGGER.log( Level.INFO, "La semana con id = {0} fue eliminada. ", id );
    }
    
    
}
