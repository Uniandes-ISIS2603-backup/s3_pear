/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.resources;

import co.edu.uniandes.csw.pear.dtos.CocinaDetailDTO;
import co.edu.uniandes.csw.pear.dtos.DietaTipoDTO;
import co.edu.uniandes.csw.pear.dtos.DietaTipoDetailDTO;
import co.edu.uniandes.csw.pear.ejb.CocinaLogic;
import co.edu.uniandes.csw.pear.ejb.DietaTipoLogic;
import co.edu.uniandes.csw.pear.entities.CocinaEntity;
import co.edu.uniandes.csw.pear.entities.DietaTipoEntity;
import co.edu.uniandes.csw.pear.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;

/**
 * El formato JSON de este objeto es el siguiente:
 *
 *
 * {
 * "ubicacion": "Una ubicacion", "capacidad": "una capacidad", "dietas": [
 *
 * {
 * "objetivo": "un objetivo", "descripcion": "una descripcion", "cuentaDeCobro":
 * { "valorAPagar": 23.00 }, "semanas":[ {
 * "fechaLunes":"2012-04-23T18:25:43.511Z", "dias":[ { "SeEnvia": true,
 * "recomendacion": "una recomendacion", "fecha": "2012-04-23T18:25:43.511Z" } ]
 * } ] }
 *
 *
 * ]
 * }
 *
 *
 *
 *
 *
 * @author js.garcial1
 */
@Path("cocinas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class CocinaResource {

    /**
     * Conexion con la Logica
     */
    @Inject
    private CocinaLogic logic;
    
    @Inject
    private DietaTipoLogic logic_dieta;

    /**
     * <h1>POST /api/cocinas : Crear una cocina.</h1>
     *
     * <pre>Cuerpo de petición: JSON {@link CocinaDetailDTO}.
     *
     * Crea una nueva cocina con la informacion que se recibe en el cuerpo
     * de la petición y se regresa un objeto identico con un id auto-generado
     * por la base de datos.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó la nueva cocina .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe la cocina.
     * </code>
     * </pre>
     *
     * @param cocina {@link CocinaDetailDTO} - La cocina que se desea guardar.
     * @return JSON {@link CocinaDetailDTO} - La cocina guardada con el atributo
     * id autogenerado.
     * @throws co.edu.uniandes.csw.pear.exceptions.BusinessLogicException
     */
    @POST
    public CocinaDetailDTO createCocina(CocinaDetailDTO cocina) throws BusinessLogicException {
        return new CocinaDetailDTO(logic.createCocina(cocina.toEntity()));
    }

    /**
     * <h1>GET /api/cocinas : Obtener todas las cocinas.</h1>
     *
     * <pre>Busca y devuelve todas las cocinas que existen en la aplicacion.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todas las cocinas de la aplicacion.</code>
     * </pre>
     *
     * @return JSONArray {@link CocinaDetailDTO} - Las cocinas encontradas en la
     * aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<CocinaDetailDTO> getCocinas() {
        List<CocinaDetailDTO> dtos = new ArrayList<>();
        logic.getCocinas().forEach(cocina -> {
            dtos.add(new CocinaDetailDTO(cocina));
        });
        return dtos;
    }
    
    /**
     *
     * @param id
     * @return
     */
    @GET
    @Path("{id: \\d+}/dietas")
    public List<DietaTipoDetailDTO> getDietasCocina ( @PathParam("id") Long id ) {
        CocinaEntity cocina = logic.getCocina(id);
        List<DietaTipoEntity> dietas = cocina.getDietas();
        List<DietaTipoDetailDTO> ds = new ArrayList<>();
        dietas.forEach((en) -> {
            ds.add(new DietaTipoDetailDTO(en));
        });
        return ds;
    }
    
    /**
     * 
     * @param dieta_id
     * @param cocina_id
     * @return 
     */
    @PUT
    @Path("/{cocina_id: \\d+}/dietas/{dieta_id: \\d+}")
    public CocinaDetailDTO putDieta_enCocina ( @PathParam("dieta_id") Long dieta_id, @PathParam("cocina_id") Long cocina_id ) {
        DietaTipoEntity dieta = logic_dieta.getDieta(dieta_id);
        CocinaEntity cocina = logic.getCocina(cocina_id);
        cocina.add_dieta(dieta);
        return new CocinaDetailDTO(cocina);
    }
    
    
    

    /**
     * <h1>GET /api/cocinas/{id} : Obtener cocina por id.</h1>
     *
     * <pre>Busca la cocina con el id asociado recibido en la URL y la devuelve.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la cocina correspondiente al id.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe una cocina con el id dado.
     * </code>
     * </pre>
     *
     * @param id Identificador de la cocina que se esta buscando. Este debe ser
     * una cadena de dígitos.
     * @return JSON {@link CocinaDetailDTO} - La cocina buscada
     */
    @GET
    @Path("{id: \\d+}")
    public CocinaDetailDTO getCocina(@PathParam("id") Long id) {
        CocinaEntity buscado = logic.getCocina(id);
        if (buscado == null) {
            throw new WebApplicationException("El recurso /cocinas/" + id + " no existe.", 404);
        }
        return new CocinaDetailDTO(buscado);
    }

    /**
     * <h1>PUT /api/cocinas/{id} : Actualizar cocinas con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link CocinaDetailDTO}.
     *
     * Actualiza la cocina con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la cocina con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una cocina con el id dado.
     * </code>
     * </pre>
     *
     * @param id Identificador de la cocina que se desea actualizar.Este debe
     * ser una cadena de dígitos.
     * @param cocina {@link CityDetailDTO} La cocina que se desea guardar.
     * @return JSON {@link CityDetailDTO} - La cocina guardada.
     * @throws co.edu.uniandes.csw.pear.exceptions.BusinessLogicException
     */
    @PUT
    @Path("{id: \\d+}")
    public CocinaDetailDTO updateCocina(@PathParam("id") Long id, CocinaDetailDTO cocina) throws BusinessLogicException {
        if (logic.getCocina(id) == null) {
            throw new WebApplicationException("El recurso cocinas/" + id + " no existe", 404);
        }

        cocina.setId(id);
        return new CocinaDetailDTO(logic.updateCocina(id, cocina.toEntity()));
    }

    /**
     * <h1>DELETE /api/cocinas/{id} : Borrar cocina por id.</h1>
     *
     * <pre>Borra la cocina con el id asociado recibido en la URL.
     *
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina la cocina correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una cocina con el id dado.
     * </code>
     * </pre>
     *
     * @param id Identificador de la cocina que se desea borrar. Este debe ser
     * una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteCocina(@PathParam("id") Long id) {
        if (logic.getCocina(id) == null) {
            throw new WebApplicationException("El recurso /dietas/" + id + " no existe.", 404);
        }
        logic.delete(id);
    }

}
