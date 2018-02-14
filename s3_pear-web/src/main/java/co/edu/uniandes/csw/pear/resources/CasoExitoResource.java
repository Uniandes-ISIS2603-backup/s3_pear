/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.resources;
import co.edu.uniandes.csw.pear.dtos.CasoExitoDetailDTO;
import javax.ws.rs.*;
import java.util.*;

/**
 * @author pa.suarezm
 */
@Path("casos")
@Produces("application/json")
@Consumes("application/json")
public class CasoExitoResource {
    
    /**
     * <h1>POST TODOLaRuta : Crear un caso exitoso.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link CasoExitoDetailDTO}.
     * 
     * Crea un nuevo caso exitoso con la información que se recibe en el cuerpo
     * de la petición y se devuelve un objeto idéntico con un id auto-generado
     * por la base de datos.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo caso.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precondition Failed: Este caso ya fue registrado.
     * </code>
     * </pre>
     * @param caso {@link CasoExitoDetailDTO} - El caso que se 
     * quiere registrar.
     * @return JSON {@link CasoExitoDetailDTO} - El caso registrado con
     * el atributo id autogenerado.
     */
    @POST
    public CasoExitoDetailDTO createCaso(CasoExitoDetailDTO caso){
        return caso;
    }
    
    /**
     * <h1>GET /api/casos : Obtener todos los casos</h1>
     * 
     * <pre>Busca y devuelve todos los casos que existen en la
     * aplicación.
     * 
     * Códigos de respuesta:<br>
     * <code style="color:mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los casos registrados.</code>
     * </pre>
     * @return JSONArray {@link CasoExitoDetailDTO} - Los casos encontrados
     */
    @GET
    public List<CasoExitoDetailDTO> getCasos(){
        return new ArrayList<CasoExitoDetailDTO>(); //TODO
    }
    
    /**
     * <h1>GET /api/casos/{id} _ Obtener un caso por id.</h1>
     * 
     * <pre>Busca el caso con el id asociado recibido en la URL y lo
     * devuelve.
     * 
     * Códigos de respuesta:<br>
     * <code style="color:mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el caso correspondiente al id.
     * </code>
     * </pre>
     * @param id Identificador del caso que se está buscando. Este debe ser una
     * cadena de dígitos.
     * @return JSON {@link CasoExitoDetailDTO} - El caso buscado
     */
    @GET
    @Path("{id: \\d+}")
    public CasoExitoDetailDTO getCaso(@PathParam("id") Long id){
        return null; //TODO
    }
    
    /**
     * <h1>PUT /api/casos/{id} : Actualizar caso con el id dado.</h1>
     * <pre> Cuerpo de petición: JSON {@link CasoExitoDetailDTO}.
     * 
     * Actualiza el caso con el id recibido en la URL con la información que se
     * recibe en el cuerpo de la petición.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el caso con el id dado con la información enviada como
     * parámetro. Devuelve un objeto idéntico.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un casocon el id dado.
     * </code>
     * </pre>
     * @param id Identificador del caso que se desea actualizar. Este debe ser
     * una cadena de dígitos.
     * @param caso {@link CasoExitoDetailDTO} El caso que se desea actualizar.
     * @return JSON {@link CasoExitoDetailDTO} - El caso actualizado
     */
    @PUT
    @Path("{id: \\d+}")
    public CasoExitoDetailDTO updateCaso(@PathParam("id") Long id, CasoExitoDetailDTO caso){
        return caso; //TODO
    }

    /**
     * <h1>DELETE /api/caso/{id} : Borrar caso por id. </h1>
     * 
     * <pre>Borra el caso con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el caso con el id dado. </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un caso con el id dado.
     * </code>
     * </pre>
     * @param id Identificador del caso que se desea borrar. Este debe ser una
     * cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteCaso(@PathParam("id") Long id){
        //TODO (?)
    }
}
