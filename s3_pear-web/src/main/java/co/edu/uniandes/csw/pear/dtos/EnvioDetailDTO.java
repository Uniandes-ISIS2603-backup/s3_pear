/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;


import co.edu.uniandes.csw.pear.entities.EnvioEntity;


/**
/**
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "duraciom": number,
 *      "recibidio": boolean,
 *      "direccio":String
 *   }
 *  Por ejemplo un envio  se representa asi:<br>
 * </pre>
 * @author js.cabra
 */
public class EnvioDetailDTO extends EnvioDTO{
    
    private DiaDTO dia;
 
    
      /**
     * Constructor vacio
     * @param entity
     */
    
    public EnvioDetailDTO(EnvioEntity entity)
    {
        super(entity);
        if(entity != null){
            if(entity.getDia() != null){
                dia  = new DiaDTO(entity.getDia());
            }
            else{
                dia = null;
            }
        }
    }
    
        /**
     * Constructor para transformar un Entity a un DTO
     *
     */
    
    public EnvioDetailDTO() {
        super();
    }
    //-----------------------------------------------------------
    //Metodos
    //-----------------------------------------------------------
    
    public void setDia(DiaDTO di){
         dia = di;
    }
    
    public DiaDTO getDia(){
        return dia;
    }           
    
      /**
     * Transformar un DTO a un Entity
     *
     * @return  La entidad construida a partir del DTO.
     */
    @Override
    public EnvioEntity toEntity() {
        EnvioEntity en = super.toEntity();
        if(en != null){
           if(this.getDia() != null) {
               en.setDia(this.getDia().toEntity());
           }  
        }
        return en;
    } 
}
