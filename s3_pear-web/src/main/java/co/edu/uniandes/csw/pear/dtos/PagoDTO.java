/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.PagoEntity;

/**
 * CuentaCobroDTO modela el objeto que se transfiere entre el cliente y el
 * servidor en formato JSON.
 *
 * El formato JSON de este objeto es el siguiente: { "montoIncial": 0.1,
 * "montoFinal" : 0.1, "medioPago" :{ "medioPagoActual": "baloto" "personas": []
 *
 * }
 * }
 *
 * @author jp.campos
 */
public class PagoDTO {

    private Long id;
    private Double montoInicial;
    private Double montoFinal;

    /**
     * Contructor por defecto
     */
    public PagoDTO() {
         //constructor por defecto.
    }

    public PagoDTO(PagoEntity entity) {

        if (entity != null) {
            montoInicial = entity.getMontoInicial();
            montoFinal = entity.getMontoFinal();
            id = entity.getId();
        }
    }

    /**
     * @return El ID del pago
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
     * @return montoIncial
     */
    public Double getMontoInicial() {
        return montoInicial;
    }

    /**
     * Cambia el monto inicial
     *
     * @param pMonto
     */
    public void setMontoInicial(Double pMonto) {
        montoInicial = pMonto;
    }

    /**
     *
     * @return Monto Final
     */
    public Double getMontoFinal() {
        return montoFinal;

    }

    /**
     * Cambia el monto final
     *
     * @param pMonto
     */
    public void setMontoFinal(Double pMonto) {
        montoFinal = pMonto;
    }

    /**
     * Convierte este objeto DTO a una entidad
     *
     * @return Un nuevo entity con los valores del DTO
     */
    public PagoEntity toEntity() {
        PagoEntity entidad = new PagoEntity();
        entidad.setId(this.id);
        entidad.setMontoFinal(this.montoFinal);
        entidad.setMontoInicial(this.montoInicial);

        return entidad;
    }

}
