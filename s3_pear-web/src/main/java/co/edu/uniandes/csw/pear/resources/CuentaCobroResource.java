/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.resources;
import co.edu.uniandes.csw.pear.dtos.CuentaCobroDetailDTO;
import co.edu.uniandes.csw.pear.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.pear.mappers.BusinessLogicExceptionMapper;
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
@Path("cuentaCobro")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class CuentaCobroResource {
    
    
   



    /**
     * <h1>POST /api/cities : Crea una cuenta de cobro.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link CityDetailDTO}.
     * 
     * Crea una nueva cuenta con la informacion que se recibe en el cuerpo 
     * de la petición y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó la nueva cuenta .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe la cuenta.
     * </code>
     * </pre>
     * @param cuenta {@link CuentaCobroDetailDTO} - La cuenta que se desea guardar.
     * @return JSON {@link CuentaCobroetailDTO}  - La cuenta guardada con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe la cuenta.
     */
    @POST
    public CuentaCobroDetailDTO createCity(CuentaCobroDetailDTO cuenta) throws BusinessLogicException {
        return cuenta;
    }

    
    /**
     * <h1>GET /api/cuentas : Obtener todas las cuentas.</h1>
     * 
     * <pre>Busca y devuelve todas las cuentas que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todas las cuentas de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link CityDetailDTO} - Las cuentas encontradas en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<CuentaCobroDetailDTO> getCuentas() {
        return new ArrayList<>();
    }
    
    
    /**
     * <h1>GET /api/cuentas/{id} : Obtener cuenta por id.</h1>
     * 
     * <pre>Busca la cuenta con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la cuenta correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe una cuenta con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la cuenta que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link CityDetailDTO} - La cuenta buscada
     */
    @GET
    @Path("{id: \\d+}")
    public CuentaCobroDetailDTO getCity(@PathParam("id") Long id) {
        return null;
    }
    
    
    /**
     * <h1>PUT /api/cities/{id} : Actualizar cuenta con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link CityDetailDTO}.
     * 
     * Actualiza la cuenta con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la cuenta con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una cuenta con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la cuenta que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param city {@link CityDetailDTO} La cuenta que se desea guardar.
     * @return JSON {@link CityDetailDTO} - La cuenta guardada.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar la ciudad porque ya existe una con ese nombre.
     */
    @PUT
    @Path("{id: \\d+}")
    public CuentaCobroDetailDTO updateCity(@PathParam("id") Long id, CuentaCobroDetailDTO cuenta) throws BusinessLogicException {
        return cuenta;
    }
    
    
     /**
     * <h1>DELETE /api/cuentas/{id} : Borrar cuenta por id.</h1>
     * 
     * <pre>Borra la cuenta con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina la cuenta correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una cuenta con el id dado.
     * </code>
     * </pre>
     * @param id Identificador de la cuenta que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
     public void deleteCuenta(@PathParam("id") Long id) {
        // Void
    }
}
