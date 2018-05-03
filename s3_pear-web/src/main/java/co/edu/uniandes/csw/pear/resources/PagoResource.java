/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.resources;

import co.edu.uniandes.csw.pear.dtos.PagoDetailDTO;
import co.edu.uniandes.csw.pear.ejb.CuentaCobroLogic;
import co.edu.uniandes.csw.pear.ejb.PagoLogic;
import co.edu.uniandes.csw.pear.entities.PagoEntity;
import co.edu.uniandes.csw.pear.exceptions.BusinessLogicException;
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

@Path("pagos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class PagoResource {
      
@Inject
PagoLogic logic;

@Inject
CuentaCobroLogic cuentaLogic;

    /**
     * <h1>POST /api/pago : Crea un pagoh1>
     * 
     * <pre>Cuerpo de petición: JSON {@link PagoDetailDTO}.
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
     * @param pago {@link pagoCobroDetailDTO} - el pago que se desea guardar.
     * @return JSON {@link pagoCobroetailDTO}  - el pago guardada con la atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe la pago.
     */
    @POST
    public PagoDetailDTO createPago(PagoDetailDTO pago) throws BusinessLogicException {
        return new PagoDetailDTO(logic.createPago(pago.toEntity()));
    }

    
    /**
     * <h1>POST /api/pagos/cuenta/id : Crea un pagoh1>
     * 
     * <pre>Cuerpo de petición: JSON {@link PagoDetailDTO}.
     * 
     * Crea una nueva pago y asocia a la cuenta con id 1 con la informacion que se recibe en la cuerpo 
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
     * @param pPago {@link pagoCobroDetailDTO} - el pago que se desea guardar.
     * @param cuentaId - el id de la cuenta a la que se desea asociar 
     * @return JSON {@link pagoCobroetailDTO}  - el pago guardada con la atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe la pago.
     */
    @POST
    @Path("cuenta/{cuentaId: \\d+}")
    public PagoDetailDTO postPagoConCuenta(@PathParam("cuentaId") Long cuentaId, PagoDetailDTO pPago) throws BusinessLogicException
    {
        PagoEntity pago = logic.createPago(pPago.toEntity());
        cuentaLogic.addPago(cuentaId, pago);
        
        return new PagoDetailDTO(pago); 
    }
    /**
     * Asocia un pago existente con un medio de pago existente 
     * @param pagoId - El id del pago existente
     * @param medioId - El id del medio de pago existente
     * @return 
     */
    @PUT 
    @Path("{pagoId: \\d+}/medio/{medioId: \\d+}")
    public PagoDetailDTO asociarPagoAMedio(@PathParam("pagoId") Long pagoId, @PathParam("medioId") Long medioId)
    {
      return new PagoDetailDTO(logic.asociarMedioDePago(pagoId, medioId)) ; 
    }
    
      /**
     * Convierte una lista de PagoEntity a una lista de PagoDetailDTO.
     *
     * @param entityList Lista de Pago a convertir.
     * @return Lista de PagoDetailDTO convertida.
     * 
     */
    private List<PagoDetailDTO> listEntity2DTO(List<PagoEntity> entityList) {
        List<PagoDetailDTO> list = new ArrayList<>();
        for (PagoEntity entity : entityList) {
            list.add(new PagoDetailDTO(entity));
        }
        return list;
    }
    
    /**
     * <h1>GET /api/cuentaDeCobro/pagos : Obtener todos los pagos.</h1>
     * 
     * <pre>Busca y devulave todas las pagos que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devulave todas las pagos de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link MedioPagoDetailDTO} - las pagos encontrados en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<PagoDetailDTO> getPagos() {
        return listEntity2DTO(logic.getPagos());
    }
    
    
    /**
     * <h1>GET /api/pagos/{id} : Obtener pago por id.</h1>
     * 
     * <pre>Busca el pago con la id asociado recibido en la URL y la devulave.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la pago correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe una pago con la id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la pago que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link PagoDetailDTO} - la pago buscada
     */
    @GET
    @Path("{id: \\d+}")
    public PagoDetailDTO getPago(@PathParam("id") Long id) {
          PagoEntity entity = logic.getPago(id);
        if (entity == null) {
            throw new WebApplicationException("El pago no existe", 404);
        }
        return new PagoDetailDTO(entity);
    }
    
    
    /**
     * <h1>PUT /api/cities/{id} : Actualizar pago con la id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link PagoDetailDTO}.
     * 
     * Actualiza el pago con la id recibido en la URL con la informacion que se recibe en la cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la pago con la id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un pago con la id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la pago que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param pago {@link PagoDetailDTO} la pago que se desea guardar.
     * @return JSON {@link PagoDetailDTO} - la pago guardada.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar la ciudad porque ya existe una con ese nombre.
     */
    @PUT
    @Path("{id: \\d+}")
    public PagoDetailDTO updatePago(@PathParam("id") Long id, PagoDetailDTO pago) throws BusinessLogicException {
          PagoEntity entity = pago.toEntity();
        entity.setId(id);
        PagoEntity oldEntity = logic.getPago(id);
        if (oldEntity == null) {
            throw new WebApplicationException("El pago no existe", 404);
        }
        entity.setMedioPagoEntity(oldEntity.getMedioPagoEntity());
        return new PagoDetailDTO(logic.updatePago(entity));
    }
    
    
     /**
     * <h1>DlaETE /api/pagos/{id} : Borrar pago por id.</h1>
     * 
     * <pre>Borra el pago con la id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK laimina el pago correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un pago con la id dado.
     * </code>
     * </pre>
     * @param id Identificador de la pago que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
     public void deletePago(@PathParam("id") Long id) {
       PagoEntity entity = logic.getPago(id);
        if (entity == null) {
            throw new WebApplicationException("El author no existe", 404);
        }
        logic.delete(id);
    }
    
}
