/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.BaseEntity;
import co.edu.uniandes.csw.pear.entities.ComidaEntity;
import java.io.Serializable;

/**
 *
 *  * ComidaDTO Objeto de transferencia de datos de comidas. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "cantidad": number,
 *      "alimentos":string,
 *      "direccion: string,
 *      "tipo": string
 *     
 *   }
 * </pre>
 * Por ejemplo una comida se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "cantidad": 360 gramos,
 *       "alimentos":"arroz intregra 100 gramos, 200 gramos de carne de rez y aguacate 60 gramos",
 *      "direccion: "Bogota DC, calle 106 # 19-20 casa 120",
 *      "tipo": "ADELGAZAR"
 *   }
 *
 * </pre>
 * @author js.cabra
 */


public class ComidaDTO

{
    public int cantidad ;
    
    public String alimentos;
    
    public String TIPO;
    
    public Long id;
    
   
    
     /**
     * Constructor ComidaDTO a partir de la Entity
     * @param entidad
     */
    public ComidaDTO(ComidaEntity entidad)    
    {
        cantidad = entidad.getCantidad();
        
        alimentos = entidad.getAlimentos();
        
        TIPO = entidad.getTipo();
        
        
    
    }
     /**
     * Constructor vacio
     */
    public ComidaDTO()
    {
        
    }
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long pId)
          {
        id = pId;
    }
      
          
        /**
     * 
     * @return la cantidad de comida.
     */
    public int getCantidad()
            
    {
        return cantidad;
        
    }
     /**
     * 
     * @param la nueva cantidad.
     */
    public void setCantidad(int pCantidad)
    {
        cantidad = pCantidad;
    }
        /**
     * 
     * @return los alimentos que estan en esta comida.
     */
     public String getAlimentos()
            
    {
        return alimentos;
        
    }
     /**
     * 
     * @param los nuevos alimentos.
     */
    public void setAlimentos(String pAlimentos)
    {
        alimentos = pAlimentos;
    }
        /**
     * 
     * @return el tipo de comida.
     */
    public String getTipo()
    {
        return TIPO;
    }
     /**
     * 
     * @param el nuevo tipo.
     */
    public void setTIPO(String pTipo)
    {
        TIPO = pTipo;
    }
    
    

    
    
      public ComidaEntity toEntity() {
        ComidaEntity en = new ComidaEntity();
        en.setAlimentos(this.alimentos);
        en.setCantidad(this.cantidad);
        
        if(TIPO.equalsIgnoreCase("desayuno"))
        en.setTIPO("desayuno");
        else if(TIPO.equalsIgnoreCase("almuerzo"))
            en.setTIPO("almuerzo");
        else if(TIPO.equalsIgnoreCase("cena"))
            en.setTIPO("cena");
        
        else if (TIPO.equalsIgnoreCase("adicional"))
            en.setTIPO("adicional");
        
        en.setId(this.id);
        return en;
    }
}
