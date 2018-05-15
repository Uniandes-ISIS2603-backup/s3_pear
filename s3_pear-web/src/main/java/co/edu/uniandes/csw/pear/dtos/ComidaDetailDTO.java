/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.ComidaEntity;

/**
 *
 * @author js.cabra
 */
public class ComidaDetailDTO extends ComidaDTO
{
    
    private DiaDTO dia;

 /**
     * Constructor vacio
     */
    
    public ComidaDetailDTO()
    {
        super();
    }
    
        /**
     * Constructor para transformar un Entity a un DTO
     * @param entidad La entidad de Envio a partir de la cual se construye el objeto
     */
    
    public ComidaDetailDTO(ComidaEntity entidad) {
        super(entidad);
        if (entidad != null)
            
        {
            if(entidad.getDia()!=null)
            {
                dia = new DiaDTO(entidad.getDia());
            }
            else 
            {
                dia = new DiaDTO();
            }
        }
    }
    
      /**
     * Transformar un DTO a un Entity
     *
     * @return  La entidad construida a partir del DTO.
     */
    @Override
    public ComidaEntity toEntity() {
        ComidaEntity en = super.toEntity();
        if(this.getDia()!=null)
        {
            en.setDia(dia.toEntity());
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
