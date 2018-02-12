/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.resources;



/**
 *
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
