/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.CasoExitoEntity;

/**
 *
 * @author pa.suarezm
 */
public class CasoExitoDetailDTO extends CasoExitoDTO {

    //----------------------------------------
    //Atributos
    //----------------------------------------
    private DietaTipoDTO dieta;

    //----------------------------------------
    //Constructor
    //----------------------------------------
    /**
     * Constructor por defecto
     */
    public CasoExitoDetailDTO() {
        super();
    }

    public CasoExitoDetailDTO(CasoExitoEntity entidad) {
        super(entidad);
        //TODO: transformar el valor de dieta
    }

    //----------------------------------------
    //Metodos
    //----------------------------------------
    /**
     * @return Dieta para la cual el caso fue exitoso
     */
    public DietaTipoDTO getDieta() {
        return dieta;
    }

    /**
     * @param pDieta Nueva dieta asociada al caso exitoso
     */
    public void setDieta(DietaTipoDTO pDieta) {
        dieta = pDieta;
    }

    @Override
    public CasoExitoEntity toEntity() {
        return super.toEntity();
        //TODO: transformar el valor de dieta
    }
}
