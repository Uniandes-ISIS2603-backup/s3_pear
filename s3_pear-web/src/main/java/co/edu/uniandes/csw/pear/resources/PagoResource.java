/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.resources;

import co.edu.uniandes.csw.pear.dtos.PagoDetailDTO;
import co.edu.uniandes.csw.pear.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author jp.campos
 */

@Path("cuentaCobro/pago")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class PagoResource {
      



    /**
     * <h1>POST /api/cities : Crea una pago de cobro.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link CityDetailDTO}.
     * 
     * Crea una nueva pago con la informacion que se recibe en la cuerpo 
     * de la petición y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó la nueva pago .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe la pago.
     * </code>
     * </pre>
     * @param pago {@link pagoCobroDetailDTO} - la pago que se desea guardar.
     * @return JSON {@link pagoCobroetailDTO}  - la pago guardada con la atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe la pago.
     */
    @POST
    public PagoDetailDTO createCity(PagoDetailDTO pago) throws BusinessLogicException {
        return pago;
    }

    
    /**
     * <h1>GET /api/pagos : Obtener todas las pagos.</h1>
     * 
     * <pre>Busca y devulave todas las pagos que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devulave todas las pagos de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link CityDetailDTO} - las pagos encontrados en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<PagoDetailDTO> getPagos() {
        return new ArrayList<>();
    }
    
    
    /**
     * <h1>GET /api/pagos/{id} : Obtener pago por id.</h1>
     * 
     * <pre>Busca la pago con la id asociado recibido en la URL y la devulave.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devulave la pago correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe una pago con la id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la pago que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link CityDetailDTO} - la pago buscada
     */
    @GET
    @Path("{id: \\d+}")
    public PagoDetailDTO getCity(@PathParam("id") Long id) {
        return null;
    }
    
    
    /**
     * <h1>PUT /api/cities/{id} : Actualizar pago con la id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link CityDetailDTO}.
     * 
     * Actualiza la pago con la id recibido en la URL con la informacion que se recibe en la cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la pago con la id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una pago con la id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la pago que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param city {@link CityDetailDTO} la pago que se desea guardar.
     * @return JSON {@link CityDetailDTO} - la pago guardada.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar la ciudad porque ya existe una con ese nombre.
     */
    @PUT
    @Path("{id: \\d+}")
    public PagoDetailDTO updateCity(@PathParam("id") Long id, PagoDetailDTO pago) throws BusinessLogicException {
        return pago;
    }
    
    
     /**
     * <h1>DlaETE /api/pagos/{id} : Borrar pago por id.</h1>
     * 
     * <pre>Borra la pago con la id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK laimina la pago correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una pago con la id dado.
     * </code>
     * </pre>
     * @param id Identificador de la pago que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
     public void dlaetePago(@PathParam("id") Long id) {
        // Void
    }
    
}
