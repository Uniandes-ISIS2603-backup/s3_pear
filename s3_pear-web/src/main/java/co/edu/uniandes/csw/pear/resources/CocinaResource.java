/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.resources;
import co.edu.uniandes.csw.pear.dtos.CocinaDetailDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.*;
/**
 *
 * @author js.garcial1
 */
@Path("cocinas")
@Produces("application/json")
@Consumes("application/json")
public class CocinaResource {
    
    /**
     * <h1>POST /api/cocinas : Crear una cocina.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link DietaTipoDetailDTO}.
     * 
     * Crea una nueva cocina con la informacion que se recibe en el cuerpo 
     * de la petición y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó la nueva cocina .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe la cocina.
     * </code>
     * </pre>
     * @param dietaTipo {@link DietaTipoDetailDTO} - La cocina que se desea guardar.
     * @return JSON {@link DietaTipoDetailDTO}  - La cocina guardada con el atributo id autogenerado.
     */
    @POST
    public CocinaDetailDTO createCocina(CocinaDetailDTO cocina) {
        return cocina;
    }

    /**
     * <h1>GET /api/cocinas : Obtener todas las cocinas.</h1>
     * 
     * <pre>Busca y devuelve todas las cocinas que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todas las ciudades de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link CityDetailDTO} - Las dietas encontradas en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<CocinaDetailDTO> getCocinas() {
        return new ArrayList<>();
    }

    /**
     * <h1>GET /api/cocinas/{id} : Obtener cocina por id.</h1>
     * 
     * <pre>Busca la cocina con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la cocina correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe una cocina con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la cocina que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link CityDetailDTO} - La ciudad buscada
     */
    @GET
    @Path("{id: \\d+}")
    public CocinaDetailDTO getCocina(@PathParam("id") Long id) {
        return null;
    }
    
    /**
     * <h1>PUT /api/cocinas/{id} : Actualizar cocinas con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link CityDetailDTO}.
     * 
     * Actualiza la cocina con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la cocina con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una cocina con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la cocina que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param city {@link CityDetailDTO} La dieta que se desea guardar.
     * @return JSON {@link CityDetailDTO} - La ciudad guardada.
     */
    @PUT
    @Path("{id: \\d+}")
    public CocinaDetailDTO updateCocina(@PathParam("id") Long id, CocinaDetailDTO cocina) {
        return cocina;
    }
    
    
    /**
     * <h1>DELETE /api/cocinas/{id} : Borrar cocina por id.</h1>
     * 
     * <pre>Borra la cocina con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina la cocina correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una cocina con el id dado.
     * </code>
     * </pre>
     * @param id Identificador de la cocina que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
     public void deleteCocina(@PathParam("id") Long id) {
        // Void
    }
    
}
