/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.resources;
import co.edu.uniandes.csw.pear.dtos.DietaTipoDetailDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.*;
/**
 *
 * @author js.garcial1
 */
@Path("dietas")
@Produces("application/json")
@Consumes("application/json")
public class DietaTipoResource {
    
    /**
     * <h1>POST /api/cities : Crear una dieta.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link DietaTipoDetailDTO}.
     * 
     * Crea una nueva dieta con la informacion que se recibe en el
     * cuerpo de la petición y se regresa un objeto identico con un
     * id auto-generado por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó la nueva dieta.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe la ciudad.
     * </code>
     * </pre>
     * @param dietaTipo {@link DietaTipoDetailDTO} - La dieta que se 
     * desea guardar.
     * @return JSON {@link DietaTipoDetailDTO}  - La dieta guardada
     * con el atributo id autogenerado.
     */
    @POST
    public DietaTipoDetailDTO createDietaTipo(DietaTipoDetailDTO dietaTipo) {
        return dietaTipo;
    }

    /**
     * <h1>GET /api/dietas : Obtener todas las dietas.</h1>
     * 
     * <pre>Busca y devuelve todas las dietas que existen en la
     * aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todas las ciudades de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link CityDetailDTO} - Las dietas encontradas en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<DietaTipoDetailDTO> getDietas() {
        return new ArrayList<>();
    }

    /**
     * <h1>GET /api/dietas/{id} : Obtener dieta por id.</h1>
     * 
     * <pre>Busca la dieta con el id asociado recibido en la URL y la
     * devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la dieta correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe una dieta con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la dieta que se esta buscando. Este
     * debe ser una cadena de dígitos.
     * @return JSON {@link CityDetailDTO} - La ciudad buscada
     */
    @GET
    @Path("{id: \\d+}")
    public DietaTipoDetailDTO getDieta(@PathParam("id") Long id) {
        return null;
    }
    
    /**
     * <h1>PUT /api/dietas/{id} : Actualizar dieta con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link CityDetailDTO}.
     * 
     * Actualiza la dieta con el id recibido en la URL con la
     * informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la dieta con el id dado con la información
     * enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una ciudad con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la dieta que se desea actualizar.
     * Este debe ser una cadena de dígitos.
     * @param city {@link CityDetailDTO} La dieta que se desea guardar.
     * @return JSON {@link CityDetailDTO} - La ciudad guardada.
     */
    @PUT
    @Path("{id: \\d+}")
    public DietaTipoDetailDTO updateCity(@PathParam("id") Long id, DietaTipoDetailDTO city) {
        return city;
    }
    
    
    /**
     * <h1>DELETE /api/dietas/{id} : Borrar dieta por id.</h1>
     * 
     * <pre>Borra la dieta con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina la dieta correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una dieta con el id dado.
     * </code>
     * </pre>
     * @param id Identificador de la dieta que se desea borrar. Este
     * debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
     public void deleteDieta(@PathParam("id") Long id) {
        // Void
    }
}
