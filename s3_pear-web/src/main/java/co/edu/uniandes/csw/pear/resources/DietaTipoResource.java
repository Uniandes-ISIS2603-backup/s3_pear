/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.resources;

import co.edu.uniandes.csw.pear.dtos.DietaTipoDetailDTO;
import co.edu.uniandes.csw.pear.dtos.SemanaDetailDTO;
import co.edu.uniandes.csw.pear.ejb.CuentaCobroLogic;
import co.edu.uniandes.csw.pear.ejb.DietaTipoLogic;
import co.edu.uniandes.csw.pear.ejb.SemanaLogic;
import co.edu.uniandes.csw.pear.entities.CuentaCobroEntity;
import co.edu.uniandes.csw.pear.entities.DietaTipoEntity;
import co.edu.uniandes.csw.pear.entities.SemanaEntity;
import co.edu.uniandes.csw.pear.exceptions.BusinessLogicException;
//TODO: DONE borrar lo que no se usa 
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;

/**
 ** El formato JSON de este objeto es el siguiente:
 *
 * {
 * "objetivo": "un objetivo", "descripcion": "una descripcion", "cuentaCobro": {
 * "valorAPagar": 23.00 }, "semanas":[ {
 * "fechaLunes":"2012-04-23T18:25:43.511Z", "dias":[ { "seEnvia": true,
 * "recomendacion": "una recomendacion", "fecha": "2012-04-23T18:25:43.511Z" } ]
 * } ] }
 *
 *
 * @author js.garcial1
 */
@Path("dietas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class DietaTipoResource {

    /**
     * Conexion con la logica
     */
    @Inject
    DietaTipoLogic logic;

    @Inject
    SemanaLogic logic_sem;

    @Inject
    CuentaCobroLogic logic_cuenta;

    /**
     * <h1>POST /api/dietas : Crear una dieta.</h1>
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
     * 412 Precodition Failed: Ya existe la dieta.
     * </code>
     * </pre>
     *
     * @param dietaTipo {@link DietaTipoDetailDTO} - La dieta que se desea
     * guardar.
     * @return JSON {@link DietaTipoDetailDTO} - La dieta guardada con el
     * atributo id autogenerado.
     */
    @POST
    public DietaTipoDetailDTO createDietaTipo(DietaTipoDetailDTO dietaTipo) throws BusinessLogicException {
        return new DietaTipoDetailDTO(logic.createDieta(dietaTipo.toEntity()));
    }

    /**
     * <h1>GET /api/dietas : Obtener todas las dietas.</h1>
     *
     * <pre>Busca y devuelve todas las dietas que existen en la
     * aplicacion.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todas las dietas de la aplicacion.</code>
     * </pre>
     *
     * @return JSONArray {@link DietaTipoDetailDTO} - Las dietas encontradas en
     * la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<DietaTipoDetailDTO> getDietas() {
        List<DietaTipoDetailDTO> dtos = new ArrayList<>();
        logic.getDietas().forEach(dieta -> {
            dtos.add(new DietaTipoDetailDTO(dieta));
        });
        return dtos;
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
     *
     * @param id Identificador de la dieta que se esta buscando. Este debe ser
     * una cadena de dígitos.
     * @return JSON {@link DietaTipoDetailDTO} - La dieta buscada
     */
    @GET
    @Path("{id: \\d+}")
    public DietaTipoDetailDTO getDieta(@PathParam("id") Long id) {
        DietaTipoEntity buscado = logic.getDieta(id);
        if (buscado == null) {
            throw new WebApplicationException("El recurso /dietas/" + id + " no existe.", 404);
        }
        return new DietaTipoDetailDTO(buscado);
    }

    /**
     * <h1>PUT /api/dietas/{id} : Actualizar dieta con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link DietaTipoDetailDTO}.
     *
     * Actualiza la dieta con el id recibido en la URL con la
     * informacion que se recibe en el cuerpo de la petición.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la dieta con el id dado con la información
     * enviada como parámetro. Retorna un objeto identico.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una dieta con el id dado.
     * </code>
     * </pre>
     *
     * @param id Identificador de la dieta que se desea actualizar. Este debe
     * ser una cadena de dígitos.
     * @param dieta {@link DietaTipoDetailDTO} La dieta que se desea guardar.
     * @return JSON {@link DietaTipoDetailDTO} - La dieta guardada.
     */
    @PUT
    @Path("{id: \\d+}")
    public DietaTipoDetailDTO updateDieta(@PathParam("id") Long id, DietaTipoDetailDTO dieta) throws BusinessLogicException {
        if (logic.getDieta(id) == null) {
            throw new WebApplicationException("El recurso dietas/" + id + " no existe", 404);
        }

        dieta.setId(id);
        return new DietaTipoDetailDTO(logic.updateDieta(id, dieta.toEntity()));
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
     *
     * @param id Identificador de la dieta que se desea borrar. Este debe ser
     * una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteDieta(@PathParam("id") Long id) {
        if (logic.getDieta(id) == null) {
            throw new WebApplicationException("El recurso /dietas/" + id + " no existe.", 404);
        }
        logic.deleteDieta(id);
    }

    /**
     *
     * @param id
     * @param id_semana
     * @return
     */
    @PUT
    @Path("/{id_dieta: \\d+}/semanas/{id_semana: \\d+}")
    public DietaTipoDetailDTO addSemana_toDieta(@PathParam("id_dieta") Long id, @PathParam("id_semana") Long id_semana) {
        try {
            DietaTipoEntity dieta = logic.getDieta(id);
            SemanaEntity semana = logic_sem.getSemana(id_semana);

            dieta.add_semana(semana);

            semana.setDieta(dieta);
            
            logic_sem.updateSemana(semana.getId(), semana);

            return new DietaTipoDetailDTO(logic.updateDieta(dieta.getId(), dieta));

        } catch (BusinessLogicException e) {
            return null;
        }
    }

    /**
     *
     * @param id
     * @return
     */
    @GET
    @Path("/{id_dieta: \\d+}/semanas")
    public List<SemanaDetailDTO> getSemanas_Dieta(@PathParam("id_dieta") Long id) {

        DietaTipoEntity dieta = logic.getDieta(id);

        List<SemanaDetailDTO> dtos = new ArrayList<>();
        dieta.getSemanas().forEach(semana -> {
            dtos.add(new SemanaDetailDTO(semana));
        });

        return dtos;

    }

    /**
     * Conexión con el servicio de calificaciones para una dieta.
     * {@link CalificacionResource}
     *
     * Este método conecta la ruta de /dietas con las rutas de /calificaciones
     * que dependen del libro, es una redirección al servicio que maneja el
     * segmento de la URL que se encarga de las reseñas.
     *
     * @param dietasId El ID del libro con respecto al cual se accede al
     * servicio.
     * @return El servicio de calificaciones para esa dieta en paricular.
     */
    @Path("{idDieta: \\d+}/calificaciones")
    public Class<CalificacionResource> getCalificacionResource(@PathParam("idDieta") Long dietasId) {
        DietaTipoEntity entity = logic.getDieta(dietasId);
        if (entity == null) {
            throw new WebApplicationException("El recurso /books/" + dietasId + "/calificaciones no existe.", 404);
        }
        return CalificacionResource.class;
    }

    /**
     * Conexión con el servicio de calificaciones para una dieta.
     * {@link CalificacionResource}
     *
     * Este método conecta la ruta de /dietas con las rutas de /calificaciones
     * que dependen del libro, es una redirección al servicio que maneja el
     * segmento de la URL que se encarga de las reseñas.
     *
     * @param dietasId El ID del libro con respecto al cual se accede al
     * servicio.
     * @return El servicio de calificaciones para esa dieta en paricular.
     */
    @Path("{idDieta: \\d+}/quejasyreclamos")
    public Class<QuejasyReclamosResource> getQuejasResource(@PathParam("idDieta") Long dietasId) {
        DietaTipoEntity entity = logic.getDieta(dietasId);
        if (entity == null) {
            throw new WebApplicationException("El recurso /books/" + dietasId + "/calificaciones no existe.", 404);
        }
        return QuejasyReclamosResource.class;
    }

}
