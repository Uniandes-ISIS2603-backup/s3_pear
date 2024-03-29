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
     */
    
    public EnvioDetailDTO()
    {
        super();
    }
    
        /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entidad La entidad de Envio a partir de la cual se construye el objeto
     */
    
    public EnvioDetailDTO(EnvioEntity entidad) {
        super(entidad);
        if(entidad!=null)
        {
           if(entidad.getDia()!=null)
            {
                dia = new DiaDTO(entidad.getDia());
            }
            else 
            {
                dia = null;
            }
        }
    }
    
      /**
     * Transformar un DTO a un Entity
     *
     * @return  La entidad construida a partir del DTO.
     */
    @Override
    public EnvioEntity toEntity() {
        EnvioEntity en = super.toEntity();
         if(this.getDia()!= null)
        {
            en.setDia(this.getDia().toEntity());
        }  

        
        return en;
    }
         /**
     *
     * @return el dia en que se va a entregar la comida.
     */
    public DiaDTO getDia() {
        return dia;
    }
    
     /**
     * Cambia la comida
     *
     * @param pDia nuevo dia
     */
    public void setDia(DiaDTO pDia) {
        dia = pDia;
    }  
    
}
