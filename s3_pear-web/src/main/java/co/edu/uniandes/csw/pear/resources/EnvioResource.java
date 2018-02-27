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

import co.edu.uniandes.csw.pear.dtos.EnvioDetailDTO;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
@Path("envios")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class EnvioResource {
    /**
     * <h1>POST /api/comida : Crear un evento.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link EnvioDetailDTO}.
     * 
     * Crea un nuevo envio con la informacion que se recibe en el cuerpo 
     * de la petición y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó la nueva comida .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe el envio.
     * </code>
     * </pre>
     * @param envio {@link EnvioDetailDTO} -El envio que se desea guardar.
     * @return JSON {@link EnvioDetailDTO}  - El envio guardada con el atributo id autogenerado.
     */
     @POST
     
     public EnvioDetailDTO crearEvento(EnvioDetailDTO envio)
     {
         return envio;
     }
             /**
     * <h1>GET /api/envios : Obtener todos envios.</h1>
     * 
     * <pre>Busca y devuelve todos los envios que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los envios de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link EnvioDetailDTO} - Los envios encontradas en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET   
    public String getEnvios() {
        return "Los envios";
    }
    /**
     * <h1>GET /api/eventos : Obtener todos los eventos.</h1>
     * 
     * <pre>Busca y devuelve todas los eventos que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los eventos de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link EnvioDetailDTO} - Los eventos encontradas en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<EnvioDetailDTO> getEventos() {
        return new ArrayList<>();
    }
    
    /**
     * <h1>GET /api/evento/{id} : Obtener evento por id.</h1>
     * 
     * <pre>Busca el evento con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el evento correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un evento con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de el evento que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link EnvioDetailDTO} - el evento buscada
     */
    @GET
    @Path("{id: \\d+}")
    public EnvioDetailDTO getEvento(@PathParam("id") Long id) {
        return null;
    }
    
    /**
     * <h1>PUT /api/eventos/{id} : Actualizar comida con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link EnvioDetailDTO}.
     * 
     * Actualiza el evento con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el evento con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una cocina con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de el evento que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param comida {@link EnvioDetailDTO} El evento que se desea guardar.
     * @return JSON {@link EnvioDetailDTO} - El evento guardada.
     */
    @PUT
    @Path("{id: \\d+}")
    public EnvioDetailDTO updateEvento (@PathParam("id") Long id, EnvioDetailDTO evento) {
        return evento;
    }
    
    
    /**
     * <h1>DELETE /api/evento/{id} : Borrar evento por id.</h1>
     * 
     * <pre>Borra evento con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el evento correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un evento con el id dado.
     * </code>
     * </pre>
     * @param id Identificador de la evento que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
     public void deleteEvento(@PathParam("id") Long id) {
        // Void
    }
    
}
