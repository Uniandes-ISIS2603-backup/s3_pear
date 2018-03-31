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
import co.edu.uniandes.csw.pear.dtos.DiaDetailDTO;
import co.edu.uniandes.csw.pear.ejb.DiaLogic;
import co.edu.uniandes.csw.pear.entities.DiaEntity;
import co.edu.uniandes.csw.pear.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;

/**
 * <pre>Clase que implementa el recurso "dias".
 * URL: /api/dias
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "facturas".</i>
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
 * * El formato JSON de este objeto es el siguiente:
 * {"SeEnvia": true,
 *  "recomendacion": "Evitar la sal",
 *  "fecha": "14/02/2018",
 *  "comida": [
 *       {
 *              "cantidad": 2,
 *              "alimentos": "1 Zanahoria, 1 Tomate",
 *              "direccion": "Calle 48",
 *              "tipo":  "ADELGAZAR"
 *       }
 *            ]
 * }
 */

@Path("dias")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped

public class DiaResource {
    
      /**
     * Conexion con la logica
     */
    @Inject
    DiaLogic logic;
    
    
    
    /**
     * <h1>POST /api/dias : Crear un dia.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link DiaDetailDTO}.
     * 
     * Crea un nuevo dia con la informacion que se recibe en el cuerpo 
     * de la petición y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo dia .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe el dia.
     * </code>
     * </pre>
     * @param dia {@link DiaDetailDTO} - El dia que se desea guardar.
     * @return JSON {@link DiaDetailDTO}  - El dia guardado con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe la factura.
     */
    @POST
    public DiaDetailDTO createDia (DiaDetailDTO dia) throws BusinessLogicException {
        return new DiaDetailDTO(logic.createDia(dia.toEntity()));
    }
    
    
     /**
     * <h1>GET /api/dias : Obtener todos los dias.</h1>
     * 
     * <pre>Busca y devuelve todos los dias que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los dias de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link DiaDetailDTO} - Los dias encontrados en la aplicación. Si no hay ninguno retorna una lista vacía.
     */
    @GET
    public List<DiaDetailDTO> getDias() {
        List<DiaDetailDTO> dtos = new ArrayList<>();
        logic.getDias().forEach( di -> { 
            dtos.add(new DiaDetailDTO(di));
        });
        return dtos;
    }

    /**
     * <h1>GET /api/dias/{id} : Obtener dia por id.</h1>
     * 
     * <pre>Busca el dia con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el dia correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un dia con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del dia que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link DiaDetailDTO} - El dia buscado
     */
    @GET
    @Path("{id: \\d+}")
    public DiaDetailDTO getDia(@PathParam("id") Long id) throws BusinessLogicException {
        DiaEntity buscado = logic.getDia(id);
        if ( buscado == null ) 
            throw new WebApplicationException("El recurso /dias/" + id + " no existe.", 404);
        return new DiaDetailDTO(buscado);
    }
    
    /**
     * <h1>PUT /api/dias/{id} : Actualizar dia con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link DiaDetailDTO}.
     * 
     * Actualiza el dia con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el dia con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un dia con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del dia que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param dia {@link DiaDetailDTO} El dia que se desea guardar.
     * @return JSON {@link DiaDetailDTO} - El dia guardado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar el dia porque ya existe una con ese nombre.
     */
    @PUT
    @Path("{id: \\d+}")
    public DiaDetailDTO updateDia(@PathParam("id") Long id, DiaDetailDTO dia) throws BusinessLogicException  {
        if ( logic.getDia(id) == null ) 
            throw new WebApplicationException("El recurso /dias/" + id + " no existe.", 404);
        dia.setId(id);
        return new DiaDetailDTO(logic.updateDia(id, dia.toEntity()));
    }
    
    /**
     * <h1>DELETE /api/dias/{id} : Borrar dia por id.</h1>
     * 
     * <pre>Borra el dia con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el dia correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un dia con el id dado.
     * </code>
     * </pre>
     * @param id Identificador del dia que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
     public void deleteDia(@PathParam("id") Long id) throws BusinessLogicException {
        if ( logic.getDia(id) == null )
            throw new WebApplicationException("El recurso /dias/" + id + " no existe.", 404);
        logic.deleteDia(id);
    }
    
    
}
