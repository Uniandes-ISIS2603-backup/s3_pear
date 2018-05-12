/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.resources;

import co.edu.uniandes.csw.pear.dtos.CuentaCobroDetailDTO;
import co.edu.uniandes.csw.pear.dtos.DietaTipoDetailDTO;
import co.edu.uniandes.csw.pear.dtos.PersonaDetailDTO;
import co.edu.uniandes.csw.pear.ejb.DietaTipoLogic;
import co.edu.uniandes.csw.pear.ejb.PersonaLogic;
import co.edu.uniandes.csw.pear.entities.DietaTipoEntity;
import co.edu.uniandes.csw.pear.entities.PersonaEntity;
import co.edu.uniandes.csw.pear.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @author pa.suarezm
 */
@Path("personas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class PersonaResource {

    @Inject
    PersonaLogic logic;

    @Inject
    DietaTipoLogic logic_dieta;

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
     *
     * @param persona {@link PersonaDetailDTO} - La persona que se quiere
     * registrar.
     * @return JSON {@link PersonaDetailDTO} - La persona registrada con el
     * atributo id autogenerado.
     * @throws co.edu.uniandes.csw.pear.exceptions.BusinessLogicException
     */
    @POST
    public PersonaDetailDTO createPersona(PersonaDetailDTO persona) throws BusinessLogicException {
        return new PersonaDetailDTO(logic.createPersona(persona.toEntity()));
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
     *
     * @return JSONArray {@link PersonaDetailDTO} - Las personas encontradas
     */
    @GET
    public List<PersonaDetailDTO> getPersonas() {
        List<PersonaDetailDTO> dtos = new ArrayList<>();
        logic.getPersonas().forEach(persona -> {
            dtos.add(new PersonaDetailDTO(persona));
        });
        return dtos;
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
     *
     * @param id Identificador de la persona que se está buscando. Este debe ser
     * una cadena de dígitos.
     * @return JSON {@link PersonaDetailDTO} - La persona buscada
     */
    @GET
    @Path("{id: \\d+}")
    public PersonaDetailDTO getPersona(@PathParam("id") Long id) {
        PersonaEntity buscado = logic.getPersona(id);
        if (buscado == null) {
            throw new WebApplicationException("El recurso /personas/" + id + " no existe.", 404);
        }
        return new PersonaDetailDTO(buscado);
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
     *
     * @param id Identificador de la persona que se está buscando. Este debe ser
     * una cadena de dígitos.
     * @return JSON {@link PersonaDetailDTO} - La persona buscada
     */
    @GET
    @Path("{id: \\d+}/dietas")
    public List<DietaTipoDetailDTO> getDietas(@PathParam("id") Long id) {
        PersonaEntity buscado = logic.getPersona(id);
        if (buscado == null) {
            throw new WebApplicationException("El recurso /personas/" + id + " no existe.", 404);
        }

        List<DietaTipoDetailDTO> dtos = new ArrayList<>();
        buscado.getDietas().forEach(dieta -> {
            dtos.add(new DietaTipoDetailDTO(dieta));
        });

        return dtos;

    }

    
    /**
     * <h1>GET /api/personas/{id}/cuenta _ Obtener persona por id.</h1>
     *
     * <pre>Busca la persona con el id asociado recibido en la URL y la
     * devuelve.
     *
     * Códigos de respuesta:<br>
     * <code style="color:mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la persona correspondiente al id.
     * </code>
     * </pre>
     *
     * @param id Identificador de la persona que se está buscando. Este debe ser
     * una cadena de dígitos.
     * @return JSON {@link PersonaDetailDTO} - La persona buscada
     */
    @GET
    @Path("{id: \\d+}/cuenta")
    public CuentaCobroDetailDTO getCuenta(@PathParam("id") Long id) {
        PersonaEntity buscado = logic.getPersona(id);
        if (buscado == null) {
            throw new WebApplicationException("El recurso /personas/" + id + " no existe.", 404);
        }
        CuentaCobroDetailDTO cuenta = null; 
        if(buscado.getCuenta() !=null)
        {
             cuenta = new CuentaCobroDetailDTO(buscado.getCuenta());
        } 
        if(cuenta == null)
        {
            throw new WebApplicationException("El usuario no tiene una cuenta"); 
        }

        return cuenta;

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
     *
     * @param id Identificador de la persona que se está buscando. Este debe ser
     * una cadena de dígitos.
     * @return JSON {@link PersonaDetailDTO} - La persona buscada
     */
    @PUT
    @Path("{id_persona: \\d+}/dietas/{id_dieta: \\d+}")
    public PersonaDetailDTO add_Dieta_toPersona(@PathParam("id_persona") Long id_persona, @PathParam("id_dieta") Long id_dieta) {

        /*SE OBTIENEN LAS ENTIDADDES A BUSCAR*/
        PersonaEntity persona = logic.getPersona(id_persona);
        DietaTipoEntity dieta = logic_dieta.getDieta(id_dieta);

        if (persona == null) {
            throw new WebApplicationException("El recurso /personas/" + id_persona + " no existe.", 404);
        }

        if (dieta == null) {
            throw new WebApplicationException("El recurso /dietas/" + id_dieta + " no existe.", 404);
        }

        persona.addDieta(dieta);
        dieta.addPersona(persona);

        try {

            /*ACTUALIZA LOS VALORES EN LA BASE DE DATOS*/
            this.updatePersona(id_dieta, new PersonaDetailDTO(persona));
            logic_dieta.updateDieta(id_dieta, dieta);

            /*RETORNA LA PERSONA ACTUALIZADA*/
            return new PersonaDetailDTO(persona);

        } catch (BusinessLogicException ex) {
            Logger.getLogger(PersonaResource.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException("El recurso /persona/" + id_persona + " no existe.", 404);
        }

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
     *
     * @param id Identificador de la persona que se desea actualizar. Este debe
     * ser una cadena de dígitos.
     * @param persona {@link PersonaDetailDTO} La persona que se desea
     * actualizar.
     * @return JSON {@link PersonaDetailDTO} - La persona actualizada
     * @throws co.edu.uniandes.csw.pear.exceptions.BusinessLogicException
     */
    @PUT
    @Path("{id: \\d+}")
    public PersonaDetailDTO updatePersona(@PathParam("id") Long id, PersonaDetailDTO persona) throws BusinessLogicException {
        if (logic.getPersona(id) == null) {
            throw new WebApplicationException("El recurso /personas/" + id + " no existe.", 404);
        }
        return new PersonaDetailDTO(logic.updatePersona(persona.toEntity()));
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
     *
     * @param id Identificador de la persona que se desea borrar. Este debe ser
     * una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deletePersona(@PathParam("id") Long id) {
        if (logic.getPersona(id) == null) {
            throw new WebApplicationException("El recurso /personas/" + id + " no existe.", 404);
        }
        logic.deletePersona(id);
    }
}
