/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.resources;
import co.edu.uniandes.csw.pear.dtos.CasoExitoDetailDTO;
import co.edu.uniandes.csw.pear.ejb.CasoExitoLogic;
import co.edu.uniandes.csw.pear.entities.CasoExitoEntity;
import co.edu.uniandes.csw.pear.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @author pa.suarezm
 */
@Path("casos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class CasoExitoResource {
    
    @Inject
    CasoExitoLogic logic;
    
    /**
     * <h1>POST: Crear un caso exitoso.</h1>
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
     * @throws BusinessLogicException
     */
    @POST
    public CasoExitoDetailDTO createCaso(CasoExitoDetailDTO caso) throws BusinessLogicException{
        return new CasoExitoDetailDTO(logic.createCasoExito(caso.toEntity()));
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
        List<CasoExitoDetailDTO> dtos = new ArrayList<>();
        logic.getCasosExito().forEach( caso -> { 
            dtos.add(new CasoExitoDetailDTO(caso));
        });
        return dtos;
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
        String constante1="El recurso /casos/";
        String constante2=" no existe.";
        CasoExitoEntity buscado = logic.getCasoExito(id);
        if(buscado == null)
            throw new WebApplicationException( constante1+id+constante2, 404);
        return new CasoExitoDetailDTO(buscado);
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
     * @throws BusinessLogicException
     */
    @PUT
    @Path("{id: \\d+}")
    public CasoExitoDetailDTO updateCaso(@PathParam("id") Long id, CasoExitoDetailDTO caso) throws BusinessLogicException{
        if ( logic.getCasoExito(id) == null ) 
            throw new WebApplicationException("El recurso /casos/" + id + " no existe.", 404);
        return new CasoExitoDetailDTO(logic.updateCasoExito(caso.toEntity()));
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
        if ( logic.getCasoExito(id) == null )
            throw new WebApplicationException("El recurso /casos/" + id + " no existe.", 404);
        logic.deleteCasoExito(id);
    }
}
