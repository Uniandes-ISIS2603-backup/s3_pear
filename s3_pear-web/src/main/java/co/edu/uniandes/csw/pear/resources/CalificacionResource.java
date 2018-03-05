/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.resources;
import co.edu.uniandes.csw.pear.dtos.CalificacionDTO;
import co.edu.uniandes.csw.pear.dtos.CalificacionDetailDTO;
import co.edu.uniandes.csw.pear.ejb.CalificacionLogic;
import co.edu.uniandes.csw.pear.entities.CalificacionEntity;
import co.edu.uniandes.csw.pear.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.pear.mappers.BusinessLogicExceptionMapper;
import co.edu.uniandes.csw.pear.persistence.CalificacionPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
/**
 *
 * @author ga.bejarano10
 */
@Path("calificaciones")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class CalificacionResource
{
    @Inject
    private CalificacionLogic logica;
    /**
     * <h1>POST /api/calificaciones : crear una calificacion.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link CalificaciobDitaillDTO}.
     * 
     * Crea una nueva calificacion con la informacion que se recibe en el cuerpo 
     * de la petición y se regresa un objeto identico.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó la nueva calificacion .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe la calificacion.
     * </code>
     * </pre>
     * @param calificacion {@link CalificacionDetailDTO} - La Calificacion que se desea guardar.
     * @return JSON {@link CalificacionDetailDTO}  - Calificacion guardada con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe la ciudad.
     */
    @POST
    public CalificacionDetailDTO createCalificacion(CalificacionDetailDTO calificacion) throws BusinessLogicException {
       

        return new CalificacionDetailDTO(logica.createCalificacion(calificacion.toEntity()));
        
    }
     /**
     * <h1>GET /api/calificaciones : Obtener todas las calificaciones.</h1>
     * 
     * <pre>Busca y devuelve todas las calificaciones que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todas las calificaciones de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link CalificacionDetailDTO} - Las calificaciones en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<CalificacionDetailDTO> getCalificaciones() 
    {
       List<CalificacionDetailDTO> calificaciones = new ArrayList();
       List listaEntity = logica.getCalificaciones();
       for(int i=0; i<listaEntity.size();i++)
       {
           CalificacionEntity entidad = (CalificacionEntity) listaEntity.get(i);
           calificaciones.add(new CalificacionDetailDTO(entidad));
       }
       return calificaciones;
    }
    /**
     * <h1>GET /api/calificaciones/{id} : Obtener queja y reclamo por id.</h1>
     * 
     * <pre>Busca la calificacion con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la calificacion correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe una calificacion con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la queja y reclamo que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link CalificacionDetailDTO} - La ciudad buscada
     */
    @GET
    @Path("{id: \\d+}")
    public CalificacionDetailDTO getCalificacion(@PathParam("id") Long id) throws BusinessLogicException {
        CalificacionEntity entidad = logica.getCalificacion(id);
        if(entidad==null)
        {
            throw new BusinessLogicException("La calificacion no existe");
        }
        return new CalificacionDetailDTO(logica.getCalificacion(id));
    }
    
    /**
     * <h1>PUT /api/calificaciones/{id} : Actualizar calificacion con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link CalificacionDetailDTO}.
     * 
     * Actualiza la calificacion con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la calificacion con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una queja con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la calificacion que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param calificacion {@link CalificacionDetailDTO} La queja que se desea guardar.
     * @return JSON {@link CalificacionDetailDTO} - La queja guardada.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar la ciudad porque ya existe una con ese nombre.
     */
    
    @PUT
    @Path("{id: \\d+}")
    public CalificacionDetailDTO updateQuejayReclamo(@PathParam("id") Long id, CalificacionDetailDTO calificacion) throws BusinessLogicException {
        calificacion.setId(id);
        if(logica.getCalificacion(id)==null)
        {
            throw new BusinessLogicException("La calificacion que desea actualizar no existe");
        }
        if(logica.getCalificacion(id).getPuntuacion()>=0&& logica.getCalificacion(id).getPuntuacion()<11)
        {
             return new CalificacionDetailDTO(logica.updateCalificacion(calificacion.toEntity()));
        }
        throw new BusinessLogicException ("la calificacion debe estar entre 0 y  10");
    }
    
    /**
     * <h1>DELETE /api/calificacion/{id} : Borrar calificacion por id.</h1>
     * 
     * <pre>Borra la calificacion con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina la calificacion correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una calificacion con el id dado.
     * </code>
     * </pre>
     * @param id Identificador de la calificacion que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
     public void deleteCalificaion(@PathParam("id") Long id) throws BusinessLogicException {
         CalificacionEntity entidad = logica.getCalificacion(id);
        if(entidad==null)
        {
            throw new BusinessLogicException("La calificación que desea eliminar no existe");
        }
        logica.deleteCalificacion(entidad);
    }
     
    
}
