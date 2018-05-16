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
import co.edu.uniandes.csw.pear.dtos.FacturaDetailDTO;
import co.edu.uniandes.csw.pear.ejb.FacturaLogic;
import co.edu.uniandes.csw.pear.entities.FacturaEntity;
import co.edu.uniandes.csw.pear.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;

/**
 * <pre>Clase que implementa el recurso "facturas".
 * URL: /api/facturas
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
 * FacturaDTO modela el objeto que se transfiere entre el cliente y el servidor 
 * en formato JSON.
 * 
 * El formato JSon que representa el objeto es el siguiente: 
 * {
 *      "cantidadProductos": 2,
 *      "numeroFacturaDeVenta": 12398,
 * }
 * 
 */

@Path("facturas")
@Produces("application/json")
@Consumes("application/json")

@RequestScoped
public class FacturaResource {
    
     /**
     * Conexion con la logica
     */
    @Inject
    FacturaLogic logic;
    
    
    /**
     * <h1>POST /api/facturas : Crear una factura.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link FacturaDetailDTO}.
     * 
     * Crea una nueva factura con la informacion que se recibe en el cuerpo 
     * de la petición y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó la nueva factura .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe la factura.
     * </code>
     * </pre>
     * @param factura {@link FacturaDetailDTO} - La factura que se desea guardar.
     * @return JSON {@link FacturaDetailDTO}  - La factura guardada con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe la factura.
     */
    @POST
    public FacturaDetailDTO createFactura(FacturaDetailDTO factura) throws BusinessLogicException{
        FacturaEntity fc = factura.toEntity();
        FacturaEntity fc2 = logic.createFactura(fc);
        FacturaDetailDTO x = new FacturaDetailDTO(fc2);
        return x;
    }
    
    
     /**
     * <h1>GET /api/facturas : Obtener todas las facturas.</h1>
     * 
     * <pre>Busca y devuelve todas las facturas que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todas las facturas de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link FacturaDetailDTO} - Las facturas encontradas en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<FacturaDetailDTO> getFacturas() {
        List<FacturaDetailDTO> dtos = new ArrayList<>();
        logic.getFacturas().forEach( fac -> { 
            dtos.add(new FacturaDetailDTO(fac));
        });
        return dtos;
    }

    /**
     * <h1>GET /api/facturas/{id} : Obtener factura por id.</h1>
     * 
     * <pre>Busca la factura con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la factura correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe una factura con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la factura que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link FacturaDetailDTO} - La factura buscada
     */
    @GET
    @Path("{id: \\d+}")
    public FacturaDetailDTO getFactura(@PathParam("id") Long id) {
        String constante1= "El recurso /facturas/";
        String constante2= " no existe.";
        FacturaEntity buscado = logic.getFactura(id);
        if ( buscado == null ) 
            throw new WebApplicationException(constante1 + id +constante2 , 404);
        return new FacturaDetailDTO(buscado);
    }
    
    /**
     * <h1>PUT /api/facturas/{id} : Actualizar factura con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link FacturaDetailDTO}.
     * 
     * Actualiza la factura con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la factura con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una factura con el id dado.
     * </code> 
     * </pre>
     * @param factura {@link FacturaDetailDTO} La factura que se desea guardar.
     * @return JSON {@link FacturaDetailDTO} - La factura guardada.
     
     */
    @PUT
    @Path("{id: \\d+}")
    public FacturaDetailDTO updateFactura(@PathParam("id") Long id, FacturaDetailDTO factura) throws BusinessLogicException {
         if ( logic.getFactura(id) == null ) 
            throw new WebApplicationException("El recurso /facturas/" + id + " no existe.", 404);
         
         factura.setId(id);
        return new FacturaDetailDTO(logic.updateFactura(factura.toEntity()));
    }
 
    /**
     * <h1>DELETE /api/facturas/{id} : Borrar factura por id.</h1>
     * 
     * <pre>Borra la factura con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina la factura correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una factura con el id dado.
     * </code>
     * </pre>
     * @param id Identificador de la factura que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
     public void deleteFactura(@PathParam("id") Long id) throws BusinessLogicException {
        if ( logic.getFactura(id) == null )
            throw new WebApplicationException("El recurso /facturas/" + id + " no existe.", 404);
        logic.deleteFactura(id);
    }
    
}
