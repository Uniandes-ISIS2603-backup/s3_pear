/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.CuentaCobroEntity;
//TODO DONE: borrar lo que no se necesita


/**
 * CuentaCobroDTO modela el objeto que se transfiere entre el cliente y el
 * servidor en formato JSON.
 *
 * El formato JSON de este objeto es el siguiente: { "valorAPagar": 15.0, "id":
 * 1, "pago" : { "montoInicial":7.0, "montoFinal": 8.0 } }
 *
 * @author jp.campos
 */
public class CuentaCobroDTO {

    //-----------------------------------------------------------
    //Atributos
    //-----------------------------------------------------------
    private Long id;

    // TODO DONE: el ditpo debe ser Double e igualmente en el set/get
    private Double valorAPagar;

    /**
     * Contructor por defecto
     */
    public CuentaCobroDTO() {

    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de ciudad a partir de la cual se construye el
     * objeto
     */
    public CuentaCobroDTO(CuentaCobroEntity entity) {

        //TODO DONE: entity puede ser null
        if(entity!= null){
        
        this.valorAPagar = entity.getValorAPagar();
        this.id = entity.getId();
        }
    }

    /**
     * @return El ID de la cuenta
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id El nuevo ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return valor a pagar
     */
    public Double getValorAPagar() {
        return valorAPagar;
    }

    /**
     * @param pValorAPagar nuevo valor para asignar
     */
    public void setValorAPagar(Double pValorAPagar) {
        valorAPagar = pValorAPagar;
    }

    /**
     * Convierte este objeto DTO a una entidad
     *
     * @return Un nuevo entity con los valores del DTO
     */
    public CuentaCobroEntity toEntity() {
        CuentaCobroEntity entidad = new CuentaCobroEntity();
        entidad.setId(this.id);
        entidad.setValorAPagar(this.valorAPagar);

        return entidad;
    }

}
