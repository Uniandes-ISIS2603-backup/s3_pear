/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;
import co.edu.uniandes.csw.pear.entities.ComidaEntity;

/**
 *
 * Objeto de transferencia de datos de comidas. Los DTO contienen
 * las represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 *
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "cantidad": number,
 *      "alimentos":string,
 *      "direccion: string,
 *      "tipo": string,
 *      "image": String
 *
 *   }
 * </pre> 
 * @author js.cabra
 */
public class ComidaDTO {

    private Integer cantidad;

    private String alimentos;

    private String tipo;

    private long id;
    
   
    

    /**
     * Constructor ComidaDTO a partir de la Entity
     *
     * @param entidad
     */
    public ComidaDTO(ComidaEntity entidad) {
        if(entidad != null) {
        cantidad = entidad.getCantidad();
        alimentos = entidad.getAlimentos();
        tipo = entidad.getTipo();
        id = entidad.getId();
        
        }
    }

    /**
     * Constructor vacio
     */
    public ComidaDTO() {
        //Constructor para propositos de persistencia
    }

    public long getId() {
        return id;
    }

    public void setId(long pId) {
        id = pId;
    }

    /**
     *
     * @return la cantidad de comida.
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     *
     * @param pCantidad nueva cantidad.
     */
    public void setCantidad(Integer pCantidad) {
        cantidad = pCantidad;
    }

    /**
     *
     * @return los alimentos que estan en esta comida.
     */
    public String getAlimentos() {
        return alimentos;

    }

    /**
     *
     * @param pAlimentos nuevos alimentos.
     */
    public void setAlimentos(String pAlimentos) {
        alimentos = pAlimentos;
    }

    /**
     *
     * @return el tipo de comida.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     *
     * @param pTipo nuevo tipo.
     */
    public void setTIPO(String pTipo) {
        tipo = pTipo;
    }
    
  
 
    public ComidaEntity toEntity() {
        ComidaEntity en = new ComidaEntity();
        en.setAlimentos(this.alimentos);
        en.setCantidad(this.cantidad);
        en.setId(this.id);
        en.setTIPO(this.tipo);

        return en;
    }
}
