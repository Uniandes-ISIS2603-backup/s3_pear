/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.resources;




import co.edu.uniandes.csw.pear.dtos.EnvioDetailDTO;
import co.edu.uniandes.csw.pear.ejb.EnvioLogic;
import co.edu.uniandes.csw.pear.entities.EnvioEntity;
import co.edu.uniandes.csw.pear.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;

/**
 * El formato JSON de este objeto es el siguiente:
 
 
  {
  "id": 123,
  "duracion": 200,
  "recibido" : "false"
  
    ]
  }
 

 * 
 * @author js.cabra
 */
@Path("eventos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class EnvioResource {
    
     /**
     * Conexion con la Logica
     */
    @Inject
    private EnvioLogic logic;
    
    
    
    /**
     * <h1>POST /api/comida : Crear un evento.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link EnvioDetailDTO}.
     * 
     * Crea un nuevo envio con la informacion que se recibe en el cuerpo 
     * de la petición y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó la nueva comida .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe el envio.
     * </code>
     * </pre>
     * @param envio {@link EnvioDetailDTO} -El envio que se desea guardar.
     * @return JSON {@link EnvioDetailDTO}  - El envio guardada con el atributo id autogenerado.
     */
     @POST
     
     public EnvioDetailDTO crearEvento(EnvioDetailDTO envio)throws BusinessLogicException
     {
          return new EnvioDetailDTO(logic.createEnvio(envio.toEntity()));
     }
             /**
     * <h1>GET /api/envios : Obtener todos envios.</h1>
     * 
     * <pre>Busca y devuelve todos los envios que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los envios de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link EnvioDetailDTO} - Los envios encontradas en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET   
    public List<EnvioDetailDTO> getEnvios() {
        List<EnvioDetailDTO> dtos = new ArrayList<>();
        logic.getEnvios().forEach( envio -> { 
            dtos.add(new EnvioDetailDTO(envio));
        });
        return dtos;
    }
      /**
     * <h1>GET /api/eventos/{id} : Obtener evento por id.</h1>
     * 
     * <pre>Busca el evento con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el evento correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un evento con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de el evento que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link EventoDetailDTO} - La cocina buscada
     */
    @GET
     @Path("{id: \\d+}")
    public EnvioDetailDTO getEnvio (@PathParam("id") Long id) {
        EnvioEntity buscado = logic.getEnvio(id);
        if ( buscado == null ) 
            throw new WebApplicationException("El recurso /envios/" + id + " no existe.", 404);
        return new EnvioDetailDTO(buscado);
    }
    
    
    /**
     * <h1>PUT /api/eventos/{id} : Actualizar envio con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link EnvioDetailDTO}.
     * 
     * Actualiza el evento con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el evento con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una cocina con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de el evento que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param comida {@link EnvioDetailDTO} El evento que se desea guardar.
     * @return JSON {@link EnvioDetailDTO} - El evento guardada.
     */
    @PUT
    @Path("{id: \\d+}")
    public EnvioDetailDTO updateEvento (@PathParam("id") Long id, EnvioDetailDTO envio)throws BusinessLogicException {
        if ( logic.getEnvio(id) == null ) 
            throw new WebApplicationException("El recurso /envios/" + id + " no existe.", 404);
        return new EnvioDetailDTO(logic.updateEnvio(id, envio.toEntity()));
    }
    
    
    /**
     * <h1>DELETE /api/evento/{id} : Borrar evento por id.</h1>
     * 
     * <pre>Borra evento con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el evento correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un evento con el id dado.
     * </code>
     * </pre>
     * @param id Identificador de la evento que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
     public void deleteEvento(@PathParam("id") Long id)throws BusinessLogicException {
        if ( logic.getEnvio(id) == null )
            throw new WebApplicationException("El recurso /envios/" + id + " no existe.", 404);
        logic.delete(id);

    }
    
}
