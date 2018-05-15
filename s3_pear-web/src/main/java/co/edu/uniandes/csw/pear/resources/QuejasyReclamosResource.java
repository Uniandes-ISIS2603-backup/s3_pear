/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.resources;

import co.edu.uniandes.csw.pear.dtos.CalificacionDetailDTO;
import co.edu.uniandes.csw.pear.dtos.QuejasyReclamosDetailDTO;
import co.edu.uniandes.csw.pear.ejb.QuejasyReclamosLogic;
import co.edu.uniandes.csw.pear.entities.CalificacionEntity;
import co.edu.uniandes.csw.pear.entities.QuejasyReclamosEntity;
import co.edu.uniandes.csw.pear.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.pear.mappers.BusinessLogicExceptionMapper;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * <pre>Clase que implementa el recurso "quejas y reclamos".
 * URL: /api/quejasyreclamos
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta
 * "/api" y este recurso tiene la ruta "cities".</i>
 *
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio).
 * </pre>
 *
 * @author ga.bejarano10
 */
@Path("dietas/{idDieta: \\d+}/quejasyreclamos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class QuejasyReclamosResource {

    @Inject
    private QuejasyReclamosLogic logica;

    /**
     * <h1>POST /api/quejasyreclamos : Crear una queja y reclamo.</h1>
     *
     * <pre>Cuerpo de petición: JSON {@link CityDetailDTO}.
     *
     * Crea una nueva calificacion con la informacion que se recibe en el cuerpo
     * de la petición y se regresa un objeto identico.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó la nueva queja y reclamo .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe la queja y reclammo.
     * </code>
     * </pre>
     *
     * @param idDieta
     * @param quejayreclamo {@link quejayreclamoDetailDTO} - La queja y reclamo
     * que se desea guardar.
     * @return JSON {@link QuejasyReclamosDetailDTO} - La queja y reclamo
     * guardada con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando ya existe la ciudad.
     */
    @POST
    public QuejasyReclamosDetailDTO createQuejayReclamo(@PathParam("idDieta")Long idDieta, QuejasyReclamosDetailDTO quejayreclamo) throws BusinessLogicException {

        return new QuejasyReclamosDetailDTO(logica.createQuejasyReclamos(idDieta, quejayreclamo.toEntity()));

    }

    /**
     * <h1>GET /api/quejasyreclamaos : Obtener todas las quejas y reclamos.</h1>
     *
     * <pre>Busca y devuelve todas las quejas y reclamos que existen en la aplicacion.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todas las quejas y reclamos de la aplicacion.</code>
     * </pre>
     *
     * @param idDieta
     * @return JSONArray {@link CityDetailDTO} - Las quejas y reclamos
     * encontradas en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<QuejasyReclamosDetailDTO> getQuejasyReclamos(@PathParam("idDieta") Long idDieta) {
        List<QuejasyReclamosDetailDTO> quejasyreclamos = new ArrayList();
        List listaEntity = logica.getQuejasyReclamos(idDieta);
        for (int i = 0; i < listaEntity.size(); i++) {
            QuejasyReclamosEntity entidad = (QuejasyReclamosEntity) listaEntity.get(i);
            quejasyreclamos.add(new QuejasyReclamosDetailDTO(entidad));
        }
        return quejasyreclamos;
    }

    /**
     * <h1>GET /api/quejasyreclamos/{id} : Obtener queja y reclamo por id.</h1>
     *
     * <pre>Busca la queja y reclamo con el id asociado recibido en la URL y la devuelve.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la queja y reclamo correspondiente al id.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe una queja y reclamo con el id dado.
     * </code>
     * </pre>
     *
     * @param id Identificador de la queja y reclamo que se esta buscando. Este
     * debe ser una cadena de dígitos.
     * @return JSON {@link CityDetailDTO} - La ciudad buscada
     */
    @GET
    @Path("{id: \\d+}")
    public QuejasyReclamosDetailDTO getQuejayReclamo(@PathParam("idDieta") Long idDieta,@PathParam("id") Long id) throws BusinessLogicException {
        QuejasyReclamosEntity entidad = logica.getQuejayReclamo(idDieta,id);
        if (entidad == null) {
         
            throw new BusinessLogicException("la queja o reclamo no existe");
        }
        return new QuejasyReclamosDetailDTO(entidad);
    }

    /**
     * <h1>PUT /api/quejasyreclamos/{id} : Actualizar queja y reclamo con el id
     * dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link QuejasyReclamosDetailDTO}.
     *
     * Actualiza la queja con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la queja con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una queja con el id dado.
     * </code>
     * </pre>
     *
     * @param id Identificador de la queja que se desea actualizar.Este debe ser
     * una cadena de dígitos.
     * @param quejayreclamo {@link QuejassyReclamosDetailDTO} La queja que se
     * desea guardar.
     * @return JSON {@link QuejasyReclamosDetailDTO} - La queja guardada.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera al no poder actualizar la ciudad porque ya
     * existe una con ese nombre.
     */
    @PUT
    @Path("{id: \\d+}")
    public QuejasyReclamosDetailDTO updateQuejayReclamo(@PathParam("idDieta") Long idDieta,@PathParam("id") Long id, QuejasyReclamosDetailDTO quejayreclamo) throws BusinessLogicException {
        quejayreclamo.setId(id);
        QuejasyReclamosEntity entidad = logica.getQuejayReclamo(idDieta,id);
        if (entidad == null) {
      
            throw new BusinessLogicException("La queja o reclamo que desea actualizar no existe");
        }
        return new QuejasyReclamosDetailDTO(logica.updateQuejayReclamo(idDieta,quejayreclamo.toEntity()));
    }

    /**
     * <h1>DELETE /api/quejasyreclamos/{id} : Borrar ciudad por id.</h1>
     *
     * <pre>Borra la queja con el id asociado recibido en la URL.
     *
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina la queja correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una queja con el id dado.
     * </code>
     * </pre>
     *
     * @param id Identificador de la queja que se desea borrar. Este debe ser
     * una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteQuejayReclamo(@PathParam("idDieta") Long idDieta,@PathParam("id") Long id) throws BusinessLogicException {
        QuejasyReclamosEntity entidad = logica.getQuejayReclamo(idDieta,id);
        if (entidad == null) {
         
            throw new BusinessLogicException("no se encontro la queja o reclamo que desea eliminar");
        }
        logica.deleteQuejayReclamo(idDieta,id);
    }

}
