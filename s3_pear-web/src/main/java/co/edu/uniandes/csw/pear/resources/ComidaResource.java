/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.resources;

/**
   * <pre>Clase que implementa el recurso "comidas".
 * URL: /api/cities
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "cities".</i>
 *
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio). 
 * </pre>
 * @author js.cabra
 */

import co.edu.uniandes.csw.pear.dtos.ComidaDetailDTO;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;

@Path("comidas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class ComidaResource {
    /**
     * <h1>POST /api/comida : Crear una comida.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link ComidaDetailDTO}.
     * 
     * Crea una nueva comida con la informacion que se recibe en el cuerpo 
     * de la petición y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó la nueva comida .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe la comida.
     * </code>
     * </pre>
     * @param comida {@link ComidaDetailDTO} - La comida que se desea guardar.
     * @return JSON {@link ComidaDetailDTO}  - La comida guardada con el atributo id autogenerado.
     */
     @POST
     
     public ComidaDetailDTO crearComida(ComidaDetailDTO comida)
     {
         return comida;
     }
             /**
     * <h1>GET /api/comdas : Obtener todas las comidas.</h1>
     * 
     * <pre>Busca y devuelve todas las comidas que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todas las comidas de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link ComidaDetailDTO} - Las dietas encontradas en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET   
    public String getAlimentos() {
        return "Los alimentos";
    }
    /**
     * <h1>GET /api/comidas : Obtener todas las comidas.</h1>
     * 
     * <pre>Busca y devuelve todas las comdias que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todas las comidas de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link ComidaDetailDTO} - Las comdias encontradas en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<ComidaDetailDTO> getComidass() {
        return new ArrayList<>();
    }
    
    /**
     * <h1>GET /api/comida/{id} : Obtener comida por id.</h1>
     * 
     * <pre>Busca la comida con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la comida correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe una comida con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la comida que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link ComidaDetailDTO} - La comida buscada
     */
    @GET
    @Path("{id: \\d+}")
    public ComidaDetailDTO getComida(@PathParam("id") Long id) {
        return null;
    }
    
    /**
     * <h1>PUT /api/comidas/{id} : Actualizar comida con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link ComidaDetailDTO}.
     * 
     * Actualiza la comida con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la comida con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una cocina con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la comida que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param comida {@link ComidaDetailDTO} La comida que se desea guardar.
     * @return JSON {@link ComidaDetailDTO} - La comida guardada.
     */
    @PUT
    @Path("{id: \\d+}")
    public ComidaDetailDTO updateComida(@PathParam("id") Long id, ComidaDetailDTO comida) {
        return comida;
    }
    
    
    /**
     * <h1>DELETE /api/comida/{id} : Borrar comida por id.</h1>
     * 
     * <pre>Borra la comida con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina la comida correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una comida con el id dado.
     * </code>
     * </pre>
     * @param id Identificador de la comida que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
     public void deleteComida(@PathParam("id") Long id) {
        // Void
    }
    
}
