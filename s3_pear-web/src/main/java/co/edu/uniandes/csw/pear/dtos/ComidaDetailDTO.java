/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;


import co.edu.uniandes.csw.pear.entities.ComidaEntity;
import java.util.ArrayList;
import java.util.List;

/**
/**
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      *      "cantidad": number,
 *      "alimentos":string,
 *      "direccion: string,
 *      "tipo": string
 *   }
 *  Por ejemplo una comida se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "cantidad": 360 gramos,
 *       "alimentos":"arroz intregra 100 gramos, 200 gramos de carne de rez y aguacate 60 gramos",
 *      "direccion: "Bogota DC, calle 106 # 19-20 casa 120",
 *      "tipo": "desayuno"
 *   }
 *
 * </pre>
 * @author js.cabra
 */
public class ComidaDetailDTO extends ComidaDTO{
    
    /**
     * Constructor vacio
     */
    public ComidaDetailDTO()
    {
        super();
    }
    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de comida a partir de la cual se construye el objeto
     */
    public ComidaDetailDTO(ComidaEntity entidad) {
        super(entidad);
    }
    
       /**
     * Transformar un DTO a un Entity
     *
     * @return  La entidad construida a partir del DTO.
     */
        @Override
    public ComidaEntity toEntity() {
        ComidaEntity en = super.toEntity();
        
           
        
        return en;
    }
}
