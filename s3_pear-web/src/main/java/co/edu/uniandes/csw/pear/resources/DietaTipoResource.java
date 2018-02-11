/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.resources;
import javax.ws.rs.*;
/**
 *
 * @author js.garcial1
 */
@Path("dietas")
@Produces("application/json")
@Consumes("application/json")
public class DietaTipoResource {
    
    @GET
    public String getObjetivo() {
        return "un objetivo"; // deberia retornar el objetivo de verdad, no este string
    }
    
    
    // FALTA
    
}
