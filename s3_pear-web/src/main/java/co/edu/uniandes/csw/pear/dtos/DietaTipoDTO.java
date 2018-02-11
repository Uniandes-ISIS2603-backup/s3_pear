/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.DietaTipoEntity;
import java.util.List;

/**
 * DietaTipoDTO modela el objeto que se transfiere entre el cliente y el servidor 
 * en formato JSON.
 * 
 * El formato JSON de este objeto es el siguiente:
 * {
 *  "objetivo": String,
 *  "descripcion": String,
 *  "cuentaDeCobro": {
 *                    "valorAPagar": double
 *                  }
 * }
 * @author js.garcial1
 */
public class DietaTipoDTO {
    
    private String objetivo;
    
    private String descripcion;
    
    private CuentaCobroDetailDTO cuentaCobro;
    
    //private List<SemanaDetailDTO> semanas;
    
    
    
    //-----------------------------------------------------------
    //Metodos
    //-----------------------------------------------------------
    
    
    /**
     * Contructor de DietaTipoDTO
     * @param entidad DietaTipoEntity
     */
    public DietaTipoDTO( DietaTipoEntity entidad ) {
        this.objetivo = entidad.getObjetivo();
        this.descripcion = entidad.getDescripcion();
        this.cuentaCobro = new CuentaCobroDetailDTO(entidad.getCuentaCobro());
        //this.semanas = entidad.semanas();
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CuentaCobroDetailDTO getCuentaCobro() {
        return cuentaCobro;
    }

    public void setCuentaCobro(CuentaCobroDetailDTO cuentaCobro) {
        this.cuentaCobro = cuentaCobro;
    }

//    public List<SemanaDetailDTO> getSemanas() {
//        return semanas;
//    }
//
//    public void setSemanas(List<SemanaDetailDTO> semanas) {
//        this.semanas = semanas;
//    }
    

    public DietaTipoEntity toEntity() {
        DietaTipoEntity en = new DietaTipoEntity();
        en.setDescripcion(this.descripcion);
        en.setObjetivo(this.objetivo);
        en.setCuentaCobro(this.cuentaCobro.toEntity());
        // FALTA SEMANA    <<<<<<<<<<<<<
        return en;
    }

    
}
