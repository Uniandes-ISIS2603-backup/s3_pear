/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.resources;

import co.edu.uniandes.csw.pear.dtos.MedioPagoDTO;
import co.edu.uniandes.csw.pear.dtos.MedioPagoDetailDTO;
import co.edu.uniandes.csw.pear.ejb.MedioPagoLogic;
import co.edu.uniandes.csw.pear.entities.MedioPagoEntity;
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
@Path("mediopagos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class MedioPagoResource {
    
    @Inject
    MedioPagoLogic logic;

    /**
     * <h1>POST /api/medioagos : Crea una pago.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link MedioPagoDetailDTO}.
     * 
     * Crea un nuevo medio de pago con la informacion que se recibe en la cuerpo 
     * de la petición y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó la nueva pago .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe el medio de pago.
     * </code>
     * </pre>
     * @param pago {@link MedioPagoDetailDTO} - el medio de pago que se desea guardar.
     * @return JSON {@link MedioPagoDetailDTO}  - el medio de pago con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe la pago.
     */
    @POST
    public MedioPagoDetailDTO createMedioPago(MedioPagoDTO pago) throws BusinessLogicException {
        return new MedioPagoDetailDTO(logic.createMedioPago(pago.toEntity()));
    }

      /**
     * Convierte una lista de MedioPagoEntity a una lista de MedioPagoDetailDTO.
     *
     * @param entityList Lista de MedioPago a convertir.
     * @return Lista de MedioPagoDetailDTO convertida.
     * 
     */
    private List<MedioPagoDetailDTO> listEntity2DTO(List<MedioPagoEntity> entityList) {
        List<MedioPagoDetailDTO> list = new ArrayList<>();
        for (MedioPagoEntity entity : entityList) {
            list.add(new MedioPagoDetailDTO(entity));
        }
        return list;
    }
    
    /**
     * <h1>GET /api/mediospago : Obtener todas los medios de pago.</h1>
     * 
     * <pre>Busca y devuelve todos los medios de pago que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los medios de pago de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link MedioPagoDetailDTO} - las medios de pago encontrados en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<MedioPagoDetailDTO> getMediosDePago() {
        return listEntity2DTO(logic.getMediosPago());
    }
    
    
    /**
     * <h1>GET /api/mediospago/{id} : Obtener pago por id.</h1>
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
     * @return JSON {@link MedioPagoDTO} - la pago buscada
     */
    @GET
    @Path("{id: \\d+}")
    public MedioPagoDTO getMedioDePago(@PathParam("id") Long id) {
          MedioPagoEntity entity = logic.getMedioPago(id);
        if (entity == null) {
            throw new WebApplicationException("El author no existe", 404);
        }
        return new MedioPagoDetailDTO(entity);
    }
    
    
    /**
     * <h1>PUT /api/mediospago/{id} : Actualizar el medio de pago con la id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link MedioPagodDTO}.
     * 
     * Actualiza la pago con la id recibido en la URL con la informacion que se recibe en la cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el medio de pago con la id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un medio pago con la id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la pago que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param medioPago {@link MedioPagoDetailDTO} el medio de pago que se desea guardar.
     * @return JSON {@link MedioPagoDetailDTO} - el medio de pago guardado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar el medio de pago porque ya existe una con ese nombre.
     */
    @PUT
    @Path("{id: \\d+}")
    public MedioPagoDTO updateMedioPago(@PathParam("id") Long id, MedioPagoDetailDTO medioPago) throws BusinessLogicException {
        MedioPagoEntity entity = medioPago.toEntity();
        entity.setId(id);
        MedioPagoEntity oldEntity = logic.getMedioPago(id);
        if (oldEntity == null) {
            throw new WebApplicationException("El author no existe", 404);
        }
        entity.setPersonas(oldEntity.getPersonas());
        return new MedioPagoDetailDTO(logic.updateMedioPago(entity));
    }
    
    
     /**
     * <h1>DELETE /api/mediospago/{id} : Borrar pago por id.</h1>
     * 
     * <pre>Borra el medio de pago con la id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK elimina  pago correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un medio de pago con la id dado.
     * </code>
     * </pre>
     * @param id Identificador del medio de pago que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
     public void deleteMedioPago(@PathParam("id") Long id) {
       MedioPagoEntity entity = logic.getMedioPago(id);
        if (entity == null) {
            throw new WebApplicationException("El author no existe", 404);
        }
        logic.delete(id);
    }
    
}
