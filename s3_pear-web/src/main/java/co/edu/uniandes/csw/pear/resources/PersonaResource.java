/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.resources;

import co.edu.uniandes.csw.pear.dtos.PersonaDetailDTO;
import javax.ws.rs.*;
import java.util.*;
import javax.enterprise.context.RequestScoped;

/**
 * @author pa.suarezm
 */
@Path("personas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class PersonaResource {
    
    /**
     * <h1>POST TODOLaRuta : Crear una persona.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link PersonaDetailDTO}.
     * 
     * Crea una nueva persona (cliente/paciente) con la información que
     * se recibe en el cuerpo de la petición y se devuelve un objeto
     * idéntico con un id auto-generado por la base de datos.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo cliente.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precondition Failed: Esta persona ya está registrada.
     * </code>
     * </pre>
     * @param persona {@link PersonaDetailDTO} - La persona que se 
     * quiere registrar.
     * @return JSON {@link PersonaDetailDTO} - La persona registrada con
     * el atributo id autogenerado.
     */
    @POST
    public PersonaDetailDTO createPersona(PersonaDetailDTO persona){
        return persona;
    }
    
    /**
     * <h1>GET /api/personas : Obtener todas las personas</h1>
     * 
     * <pre>Busca y devuelve todas las personas que existen en la
     * aplicación.
     * 
     * Códigos de respuesta:<br>
     * <code style="color:mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todas las personas registradas.</code>
     * </pre>
     * @return JSONArray {@link PersonaDetailDTO} - Las personas
     * encontradas
     */
    @GET
    public List<PersonaDetailDTO> getPersonas(){
        return new ArrayList<PersonaDetailDTO>(); //TODO
    }
    
    /**
     * <h1>GET /api/personas/{id} _ Obtener persona por id.</h1>
     * 
     * <pre>Busca la persona con el id asociado recibido en la URL y la
     * devuelve.
     * 
     * Códigos de respuesta:<br>
     * <code style="color:mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la persona correspondiente al id.
     * </code>
     * </pre>
     * @param id Identificador de la persona que se está buscando. Este
     * debe ser una cadena de dígitos.
     * @return JSON {@link PersonaDetailDTO} - La persona buscada
     */
    @GET
    @Path("{id: \\d+}")
    public PersonaDetailDTO getPersona(@PathParam("id") Long id){
        return null; //TODO
    }
    
    /**
     * <h1>PUT /api/personas/{id} : Actualizar persona con el id dado.</h1>
     * <pre> Cuerpo de petición: JSON {@link PersonaDetailDTO}.
     * 
     * Actualiza la persona con el id recibido en la URL con la
     * información que se recibe en el cuerpo de la petición.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la persona con el id dado con la información
     * enviada como parámetro. Devuelve un objeto idéntico.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una persona con el id dado.
     * </code>
     * </pre>
     * @param id Identificador de la persona que se desea actualizar.
     * Este debe ser una cadena de dígitos.
     * @param persona {@link PersonaDetailDTO} La persona que se desea
     * actualizar.
     * @return JSON {@link PersonaDetailDTO} - La persona actualizada
     */
    @PUT
    @Path("{id: \\d+}")
    public PersonaDetailDTO updatePersona(@PathParam("id") Long id, PersonaDetailDTO persona){
        return persona; //TODO
    }

    /**
     * <h1>DELETE /api/personas/{id} : Borrar persona por id. </h1>
     * 
     * <pre>Borra la persona con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina la persona con el id dado. </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una persona con el id dado.
     * </code>
     * </pre>
     * @param id Identificador de la persona que se desea borrar. Este
     * debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deletePersona(@PathParam("id") Long id){
        //TODO (?)
    }
}
