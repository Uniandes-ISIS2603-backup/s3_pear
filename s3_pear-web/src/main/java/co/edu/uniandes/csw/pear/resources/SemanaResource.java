/*
MIT License

Copyright (c) 2017 ISIS2603

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
CITYS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package co.edu.uniandes.csw.pear.resources;
import co.edu.uniandes.csw.pear.dtos.SemanaDetailDTO;
import co.edu.uniandes.csw.pear.ejb.SemanaLogic;
import co.edu.uniandes.csw.pear.entities.SemanaEntity;
import co.edu.uniandes.csw.pear.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;

/**
 * <pre>Clase que implementa el recurso "semanas".
 * URL: /api/semanas
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "semanas".</i>
 *
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio). 
 * </pre>
 * @author v.chacon
 */

/**
 *  El formato JSON de este objeto es el siguiente:
 * {
 *  "id": 123,
 *  "fechaLunes": "14/02/2018",
 *  "dias":[
 *      {    "SeEnvia": true,
 *           "recomendacion": "evitar la sal",
 *           "fecha": "14/02/2018"
 *      }
 *         ]
 * }
*/

@Path("semanas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped

public class SemanaResource {
    
   
    /**
     * Conexion con la logica
     */
    @Inject
    SemanaLogic logic;
    
    
     
    /**
     * <h1>POST /api/semanas : Crear una semana.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link SemanaDetailDTO}.
     * 
     * Crea una nueva semana con la informacion que se recibe en el cuerpo 
     * de la petición y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó la nueva semana .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe la semana.
     * </code>
     * </pre>
     * @param semana {@link SemanaDetailDTO} - La semana que se desea guardar.
     * @return JSON {@link SemanaDetailDTO}  - La semana guardada con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe la semana.
     */
    @POST
    public SemanaDetailDTO createSemana(SemanaDetailDTO semana) throws BusinessLogicException {
        return new SemanaDetailDTO(logic.createSemana(semana.toEntity()));
    }
    
    
     /**
     * <h1>GET /api/semanas : Obtener todas las semanas.</h1>
     * 
     * <pre>Busca y devuelve todas las semanas que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todas las semanas de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link SemanaDetailDTO} - Las semanas encontradas en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<SemanaDetailDTO> getSemanas() {
         List<SemanaDetailDTO> dtos = new ArrayList<>();
         List<SemanaEntity> x = logic.getSemanas();
         
         
        logic.getSemanas().forEach( sem -> { 
            dtos.add(new SemanaDetailDTO(sem));
        });
        return dtos;
    }

    /**
     * <h1>GET /api/semanas/{id} : Obtener semana por id.</h1>
     * 
     * <pre>Busca la semana con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la semana correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe una semana con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la semana que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link SemanaDetailDTO} - La semana buscada
     */
    @GET
    @Path("{id: \\d+}")
    public SemanaDetailDTO getSemana(@PathParam("id") Long id) throws BusinessLogicException {
        SemanaEntity buscado = logic.getSemana(id);
        if ( buscado == null ) 
            throw new WebApplicationException("El recurso /semanas/" + id + " no existe.", 404);
        return new SemanaDetailDTO(buscado);
    }
    
    /**
     * <h1>PUT /api/semanas/{id} : Actualizar semana con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link SemanaDetailDTO}.
     * 
     * Actualiza la semana con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la semana con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una semana con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la semana que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param semana {@link SemanaDetailDTO} La semana que se desea guardar.
     * @return JSON {@link SemanaDetailDTO} - La semana guardada.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar la semana porque ya existe una con ese nombre.
     */
    @PUT
    @Path("{id: \\d+}")
    public SemanaDetailDTO updateSemana(@PathParam("id") Long id, SemanaDetailDTO semana) throws BusinessLogicException {
        if ( logic.getSemana(id) == null ) 
            throw new WebApplicationException("El recurso /semanas/" + id + " no existe.", 404);
        
        semana.setId(id);
        return new SemanaDetailDTO(logic.updateSemana(id, semana.toEntity()));
    }
    
    /**
     * <h1>DELETE /api/semanas/{id} : Borrar semana por id.</h1>
     * 
     * <pre>Borra la semana con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina la semana correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una semana con el id dado.
     * </code>
     * </pre>
     * @param id Identificador de la semana que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
     public void deleteSemana(@PathParam("id") Long id) throws BusinessLogicException {
         if ( logic.getSemana(id) == null )
            throw new WebApplicationException("El recurso /semanas/" + id + " no existe.", 404);
        logic.deleteSemana(id);
    }
    
    
}
