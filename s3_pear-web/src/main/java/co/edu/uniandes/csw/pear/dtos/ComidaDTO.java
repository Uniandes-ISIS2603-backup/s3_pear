/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;
//TODO: Borrar lo que no se usa

import co.edu.uniandes.csw.pear.entities.BaseEntity;
import co.edu.uniandes.csw.pear.entities.ComidaEntity;
import java.io.Serializable;

/**
 *
 *  * ComidaDTO Objeto de transferencia de datos de comidas. Los DTO contienen
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
 * </pre> Por ejemplo una comida se representa asi:<br>
 *
 * <pre>
 *
 *   {
 *      "cantidad": 360 gramos,
 *       "alimentos":"arroz intregra 100 gramos, 200 gramos de carne de rez y aguacate 60 gramos",
 *      "direccion: "Bogota DC, calle 106 # 19-20 casa 120",
 *      "tipo": "desayuno",
 *      "image": "https://images.pexels.com/photos/8500/food-dinner-pasta-spaghetti-8500.jpg?cs=srgb&dl=basil-dinner-food-8500.jpg&fm=jpg"
 *   }
 *
 * </pre>
 *
 * @author js.cabra
 */
public class ComidaDTO {//TODO:DONE Esto no puede ser tipo int debe ser Integer. cambiarlo e igualmente el set/get

    public Integer cantidad;

    public String alimentos;

    public String TIPO;

    public Long id;
    
    public String image;

    /**
     * Constructor ComidaDTO a partir de la Entity
     *
     * @param entidad
     */
    public ComidaDTO(ComidaEntity entidad) {
        //TODO:DONE entidad puede ser null
        if(entidad != null) {
        cantidad = entidad.getCantidad();

        alimentos = entidad.getAlimentos();

        TIPO = entidad.getTipo();
        
        image = entidad.getImage();
        }
    }

    /**
     * Constructor vacio
     */
    public ComidaDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long pId) {
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
     * @param la nueva cantidad.
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
     * @param los nuevos alimentos.
     */
    public void setAlimentos(String pAlimentos) {
        alimentos = pAlimentos;
    }

    /**
     *
     * @return el tipo de comida.
     */
    public String getTipo() {
        return TIPO;
    }

    /**
     *
     * @param el nuevo tipo.
     */
    public void setTIPO(String pTipo) {
        TIPO = pTipo;
    }
    
    
       
        /**
     * Imagen de la comida 
     * @return image
     */
    public String getImage()
    {
        return image;
    }
    /**
     * Cambia la imagen de la comida
     * @param pImage
     */
    public void setImage(String pImage)
    {
        image = pImage;
    }

    public ComidaEntity toEntity() {
        ComidaEntity en = new ComidaEntity();
        en.setAlimentos(this.alimentos);
        en.setCantidad(this.cantidad);
        en.setImage(this.image);
        if (TIPO.equalsIgnoreCase("desayuno")) {
            en.setTIPO("desayuno");
        } else if (TIPO.equalsIgnoreCase("almuerzo")) {
            en.setTIPO("almuerzo");
        } else if (TIPO.equalsIgnoreCase("cena")) {
            en.setTIPO("cena");
        } else if (TIPO.equalsIgnoreCase("adicional")) {
            en.setTIPO("adicional");
        }

        en.setId(this.id);
        return en;
    }
}
