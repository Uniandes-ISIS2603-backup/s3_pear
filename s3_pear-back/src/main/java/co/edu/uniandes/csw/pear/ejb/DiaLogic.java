/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.ejb;

import co.edu.uniandes.csw.pear.entities.ComidaEntity;
import co.edu.uniandes.csw.pear.entities.DiaEntity;
import co.edu.uniandes.csw.pear.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.pear.persistence.DiaPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import jdk.nashorn.internal.runtime.regexp.joni.Option;

/**
 *Clase que implementa la conexión con la persistencia para la entidad DiaEntity
 * @author v.chacon
 */

@Stateless
public class DiaLogic {
    
    /**
     * Constante que representa el logger
     */
    private static final Logger LOGGER = Logger.getLogger(DietaTipoLogic.class.getName());
    
    /**
     * Conexion con la Persistencia
     */
    @Inject
    private DiaPersistence persistence;   
    
    //----------------------------------------------------------------
    //Metodos
    //----------------------------------------------------------------
    
    /**
     * Retorna todas las DiaEntity que se encuentran en la base de datos
     * @return lista con las entidades
     */
    public List<DiaEntity> getDias() {
        LOGGER.info("Inicia consulta de todos los dias");
        List<DiaEntity>  dias =  persistence.findAll();
        LOGGER.info("Termina la consulta de todos los dias");
        return dias;
    }
    
    /**
     * Retorna la DiaEntity que tiene el identificador que entra como parametro  
     * @param id identificador del dia que se quiere buscar
     * @return dia con identificador dado
     */
    public DiaEntity getDia( Long id ) {
        LOGGER.log(Level.INFO, "Inicia consulta del dia con id = {0}", id);
        DiaEntity dia = persistence.find(id);
        if ( dia ==  null )
            LOGGER.log(Level.INFO, "No existe un dia con el id = {0}", id);
        LOGGER.log(Level.INFO, "Termina la consulta del dia con id = {0}", id);
        return dia;
    }
    
    
    /**
     * Retorna una lista de instancias de Comida asociadas al Dia segun el identificador
     * @param idDia identificador del dia que tiene la informacion deseada
     * @return lista con las ComidaEntity del dia buscado
     */
    public List<ComidaEntity> getComidasPorDia(Long idDia){
        LOGGER.log(Level.INFO,"Inicia el proceso de consultar todas las comidas del dia con id = {0}",idDia);
        return this.getDia(idDia).getComidas();
    }
    
    
    /**
     * Retorna una intancia comida en un dia especifico
     * @param idComida identificador de la comida que se busca
     * @param idDia dia en el que se quiere buscar la comida
     * @return comida con el identificador dado en el dia dado
     */
    public ComidaEntity getComidaDeDia(Long idComida, Long idDia){
        LOGGER.log(Level.INFO, "Inicia proceso de consulta del Dia con id = {0} de la comida con id = {1}",new Object[]{idDia, idComida});
        List<ComidaEntity> listaComidas = this.getDia(idDia).getComidas();
        ComidaEntity comida = new ComidaEntity();
        comida.setId(idDia);
        int index = listaComidas.indexOf(comida);
        if(index >= 0){
            return listaComidas.get(index); 
        }
        return null;
    }
    
    
     /**
     * Crea un Dia y lo guarda en la base de datos
     * @param entity de dia a persistir
     * @return entidad de dia persistida
     * @throws co.edu.uniandes.csw.pear.exceptions.BusinessLogicException
     */
    public DiaEntity createDia( DiaEntity entity ) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de creacion de un dia con id = {0}", entity.getId());
        if(persistence.findByName(entity.getName())!= null){
            throw new BusinessLogicException("Ya existe un dia con ese nombre");
        }
        if(persistence.find(entity.getId())!= null){
            throw new BusinessLogicException("Ya existe un dia con ese identificador");
        }
        persistence.create(entity);
        LOGGER.log(Level.INFO, "Termina proceso de creacion de un dia con id = {0}", entity.getId());
        return entity;
    } 
     
    /**
     * Actualiza un dia segun su identificador
     * @param id de tipo Long, representa  el id del dia que se va a actualizar
     * @param entity DiaEntity con los cambios deseados
     * @return la entidad de Dia luego de ser actualizada
     */
    public DiaEntity updateDia( Long id, DiaEntity entity ) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inica proceso de actualizacion del dia con id = {0} " , id);
        if(persistence.findByName(entity.getName()) != null){
            throw new BusinessLogicException("Ya existe un dia con ese nombre");
        }
        if(persistence.find(id) == null){
            throw new BusinessLogicException("No existe un dia con ese identificador");
        }
        DiaEntity actualizado = persistence.update(entity);
        LOGGER.log( Level.INFO, "Termina proceso de actualizacion del dia, id = {0}", entity.getId() );
        return actualizado;
    }
    
    public ComidaEntity addComidaToDia(Long idComida, Long idDia){
        LOGGER.log(Level.INFO, "Inicia proceso de asociar una Comida con id = {0} a un Dia con id = {1}", new Object[]{idComida, idDia}); 
    }
    /**
     * Elimina una dia segun su identificador
     * @param id identificador del dia que se quiere eliminar
     */
    public void delete( Long id ) {
        LOGGER.log(Level.INFO, "Inicia el proceso de eliminacion de un dia con id = {0} " , id);
        persistence.delete(id);
        LOGGER.log( Level.INFO, "El dia con id = {0} fue eliminada. ", id );
    }
}
