/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.ejb;
import co.edu.uniandes.csw.pear.entities.DiaEntity;
import co.edu.uniandes.csw.pear.entities.EnvioEntity;
import co.edu.uniandes.csw.pear.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.pear.persistence.DiaPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;


/**
 *Clase que implementa la conexión con la persistencia para la entidad DiaEntity
 * @author v.chacon
 */

@Stateless
public class DiaLogic {
    
    /**
     * Constante que representa el logger
     */
    private static final Logger LOGGER = Logger.getLogger(DiaLogic.class.getName());
    
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
     * @throws co.edu.uniandes.csw.pear.exceptions.BusinessLogicException
     */
    public DiaEntity getDia( Long id ) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia consulta del dia con id = {0}", id);
        DiaEntity dia = persistence.find(id);
        if ( dia ==  null ){
            LOGGER.log(Level.INFO, "No existe un dia con el id = {0}", id);
            throw new BusinessLogicException("no existe un dia con ese identificador");
        }
        LOGGER.log(Level.INFO, "Termina la consulta del dia con id = {0}", id);
        return dia;
    }
    
    
    /**
     * Retorna una lista de instancias de Comida asociadas al Dia segun el identificador
     * @param idDia identificador del dia que tiene la informacion deseada
     * @return lista con las ComidaEntity del dia buscado
     * @throws co.edu.uniandes.csw.pear.exceptions.BusinessLogicException
     */
    public List<EnvioEntity> getEnviosPorDia(Long idDia) throws BusinessLogicException{
        LOGGER.log(Level.INFO,"Inicia el proceso de consultar todos los envios del dia con id = {0}",idDia);
        return this.getDia(idDia).getEnvios();
    }
    
    /**
     * Retorna una intancia comida en un dia especifico
     * @param idEnvio identificador del envio que se busca
     * @param idDia dia en el que se quiere buscar la comida
     * @return comida con el identificador dado en el dia dado
     * @throws co.edu.uniandes.csw.pear.exceptions.BusinessLogicException
     */
    public EnvioEntity getEnvioDeDia(Long idEnvio, Long idDia) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de consulta del Dia con id = {0} del envio con id = {1}",new Object[]{idDia, idEnvio});
        List<EnvioEntity> listaEnvios = this.getDia(idDia).getEnvios();
        EnvioEntity envio = new EnvioEntity();
        envio.setId(idEnvio);
        int index = listaEnvios.indexOf(envio);
        if(index >= 0){
            return listaEnvios.get(index); 
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
     * @throws co.edu.uniandes.csw.pear.exceptions.BusinessLogicException
     */
    public DiaEntity updateDia( Long id, DiaEntity entity ) throws BusinessLogicException 
    {
        LOGGER.log(Level.INFO, "Inica proceso de actualizacion del dia con id = {0} " , id);
     
        if(persistence.find(id) == null ){
            throw new BusinessLogicException("No existe un dia con ese identificador");
        }
        DiaEntity actualizado = persistence.update(entity);
        LOGGER.log( Level.INFO, "Termina proceso de actualizacion del dia, id = {0}", entity.getId() );
        return actualizado;
    }
    
    /**
     * Agrega una comida a un dia
     * @param idEnvio identificador del envio
     * @param idDia identificador del dia
     * @return Comida que se agrego al dia
     * @throws co.edu.uniandes.csw.pear.exceptions.BusinessLogicException
     */
    public EnvioEntity addEnvioToDia(Long idEnvio, Long idDia) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de asociar un envio con id = {0} a un Dia con id = {1}", new Object[]{idEnvio, idDia});
        EnvioEntity comid = new EnvioEntity();
        comid.setId(idEnvio);
        this.getDia(idDia).getEnvios().add(comid);
        return this.getEnvioDeDia(idEnvio, idDia);     
    }
    /**
     * Elimina una dia segun su identificador
     * @param id identificador del dia que se quiere eliminar
     * @throws co.edu.uniandes.csw.pear.exceptions.BusinessLogicException
     */
    public void deleteDia( Long id ) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia el proceso de eliminacion de un dia con id = {0} " , id);
       if(persistence.find(id) == null){
            throw new BusinessLogicException("No existe un dia con ese identificador");
        }
        persistence.delete(id);
        LOGGER.log( Level.INFO, "El dia con id = {0} fue eliminada. ", id );
    }
    
    /**
     * Elimina una comida dada de la semana que tiene el identificador que entra por parametro
     * @param idEnvio identificador de la comida que se quiere eliminar
     * @param idDia identificador del dia al que se le eliminara una comida
     * @throws co.edu.uniandes.csw.pear.exceptions.BusinessLogicException
     */
    public void deleteEnvioFromDia(Long idEnvio, Long idDia) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "Inicia proceso de eliminar el envio con id = {0} del Dia con id = {1}", new Object[]{idEnvio,idDia});
        EnvioEntity entity = new EnvioEntity();
        entity.setId(idEnvio);
        this.getDia(idDia).getEnvios().remove(entity);
    }
}
