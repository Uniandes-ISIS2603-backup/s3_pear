/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.resources;
import co.edu.uniandes.csw.pear.dtos.CuentaCobroDetailDTO;
import co.edu.uniandes.csw.pear.dtos.PagoDetailDTO;
import co.edu.uniandes.csw.pear.ejb.CuentaCobroLogic;
import co.edu.uniandes.csw.pear.entities.CuentaCobroEntity;
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
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author jp.campos
 */
@Path("cuentascobro")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class CuentaCobroResource {
    
    
   @Inject
    CuentaCobroLogic logic;


    /**
     * <h1>POST /api/cuentascobro : Crea una cuenta de cobro.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link CuentaCobroDetailDTO}.
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
    public CuentaCobroDetailDTO createCuentaDeCobro(CuentaCobroDetailDTO cuenta) throws BusinessLogicException {
        System.out.println("En resource valor a pagar " + cuenta.getValorAPagar());
        return new CuentaCobroDetailDTO(logic.createCuenta(cuenta.toEntity()));
    }

      /**
     * Convierte una lista de CuentaCobroEntity a una lista de CuentaCobroDetailDTO.
     *
     * @param entityList Lista de MedioPago a convertir.
     * @return Lista de MedioPagoDetailDTO convertida.
     * 
     */
    private List<CuentaCobroDetailDTO> listEntity2DTO(List<CuentaCobroEntity> entityList) {
        List<CuentaCobroDetailDTO> list = new ArrayList<>();
        for (CuentaCobroEntity entity : entityList) {
            list.add(new CuentaCobroDetailDTO(entity));
        }
        return list;
    }
    
    /**
     * <h1>GET /api/cuentascobro : Obtener todas las cuentas.</h1>
     * 
     * <pre>Busca y devuelve todas las cuentas que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todas las cuentas de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link CuentaDeCobroDetailDTO} - Las cuentas encontradas en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<CuentaCobroDetailDTO> getCuentas() {
         return listEntity2DTO(logic.getCuentas());
    }
    
    
    /**
     * <h1>GET /api/cuentascobro/{id} : Obtener cuenta por id.</h1>
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
     * @return JSON {@link CuentaCobroDetailDTO} - La cuenta buscada
     */
    @GET
    @Path("{id: \\d+}")
    public CuentaCobroDetailDTO getCuentaCobro(@PathParam("id") Long id) {
        CuentaCobroEntity entity = logic.getCuenta(id);
        if (entity == null) {
            throw new WebApplicationException("El author no existe", 404);
        }
        return new CuentaCobroDetailDTO(entity);
    }
    
    
    /**
     * <h1>PUT /api/cuentascobro/{id} : Actualizar cuenta con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link CuentaCobroDetailDTO}.
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
     * @param cuenta( {@link CuentaCobro(DetailDTO} La cuenta que se desea guardar.
     * @return JSON {@link CuentaCobroDetailDTO} - La cuenta guardada.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar la ciudad porque ya existe una con ese nombre.
     */
    @PUT
    @Path("{id: \\d+}")
    public CuentaCobroDetailDTO updateCuentaCobro(@PathParam("id") Long id, CuentaCobroDetailDTO cuenta) throws BusinessLogicException {
        CuentaCobroEntity entity = cuenta.toEntity();
        entity.setId(id);
        CuentaCobroEntity oldEntity = logic.getCuenta(id);
        if (oldEntity == null) {
            throw new WebApplicationException("La cuenta no existe", 404);
        }
        entity.setPagoEntity(oldEntity.getPagoEntity());
        return new CuentaCobroDetailDTO(logic.updateCuenta(entity));
    }
    
    
    
     @POST
    @Path("/cuentascobro/{cuentaId: \\d+}/pagos/{pagoId: \\d+}")
    public PagoDetailDTO addPago(@PathParam("cuentaId") Long cuentaId, @PathParam("pagoId") Long pagoId) {
        return new PagoDetailDTO(logic.addPago(cuentaId, pagoId)); 
    }
    
     /**
     * <h1>DELETE /api/cuentascobro/{id} : Borrar cuenta por id.</h1>
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
         CuentaCobroEntity entity = logic.getCuenta(id);
        if (entity == null) {
            throw new WebApplicationException("La cuenta no existe", 404);
        }
        logic.delete(id);
    }
}
