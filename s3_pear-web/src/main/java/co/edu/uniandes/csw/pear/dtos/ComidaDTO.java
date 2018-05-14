/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;
import co.edu.uniandes.csw.pear.entities.ComidaEntity;
import co.edu.uniandes.csw.pear.entities.DiaEntity;


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
public class ComidaDTO {

    private Integer cantidad;

    private String alimentos;

    private String Tipo;

    private Long id;
    
    private DiaEntity dia;
    

    /**
     * Constructor ComidaDTO a partir de la Entity
     *
     * @param entidad
     */
    public ComidaDTO(ComidaEntity entidad) {
        if(entidad != null) {
        cantidad = entidad.getCantidad();
        alimentos = entidad.getAlimentos();
        Tipo = entidad.getTipo();
        
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
        return Tipo;
    }

    /**
     *
     * @param pTipo nuevo tipo.
     */
    public void setTIPO(String pTipo) {
        Tipo = pTipo;
    }
    
     public DiaEntity getDia()
    {
        return dia;
    }
    /**
     * Cambia el dia de la comdia
     * @param pDia
     */
    public void setDia(DiaEntity pDia)
    {
        dia = pDia;
    }
       
        /**
     * Imagen de la comida 
     * @return image
     
    public String getImage()
    {
        return image;
    }
    /**
     * Cambia la imagen de la comida
    public void setImage(String pImage)
    {
        image = pImage;
    }*/

    public ComidaEntity toEntity() {
        ComidaEntity en = new ComidaEntity();
        en.setAlimentos(this.alimentos);
        en.setCantidad(this.cantidad);
        en.setId(this.id);
       // en.setImage(this.image);
        if (Tipo.equalsIgnoreCase("desayuno")) {
            en.setTIPO("desayuno");
        } else if (Tipo.equalsIgnoreCase("almuerzo")) {
            en.setTIPO("almuerzo");
        } else if (Tipo.equalsIgnoreCase("cena")) {
            en.setTIPO("cena");
        } else if (Tipo.equalsIgnoreCase("adicional")) {
            en.setTIPO("adicional");
        }
        en.setDia(this.dia);
       
        return en;
    }
}
