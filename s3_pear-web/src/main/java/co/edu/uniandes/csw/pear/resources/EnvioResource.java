/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.resources;



/**
  * <pre>Clase que implementa el recurso "envios".
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

import javax.ws.rs.*;

@Path("envios")
@Produces("application/json")
@Consumes("application/json")
public class EnvioResource {
    
     @GET
    public String getComida() {
        return "una comida";
    }
    
}
