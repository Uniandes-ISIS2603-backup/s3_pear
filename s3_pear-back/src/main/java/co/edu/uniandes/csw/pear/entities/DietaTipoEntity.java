/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.entities;

import java.io.Serializable;
import java.util.List;

/**
 * Clase que representa la entidad de una Dieta
 * @author js.garcial1
 */
public class DietaTipoEntity extends BaseEntity implements Serializable {
    
    private String objetivo;
    
    private String descripcion;
    
    // QUITAR COMENTARIO CUANDO SE CREEN LAS CLASES SEMANA Y CUENTADECOBRO
    //private CuentaDeCobro cuentaCobro;
    
    //private List<Semana> semanas;
    
    
    //-----------------------------------------------------------
    //Metodos
    //-----------------------------------------------------------

    /**
     * Objetivo o meta de la dieta
     * @return objetivo
     */
    public String getObjetivo() {
        return objetivo;
    }

    /**
     * Cambia el objetivo de la dieta
     * @param objetivo 
     */
    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    /**
     * Descripcion detallada de la dieta (calorias, alimentos, semanas, etc)
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Cambia la descripcion de la dieta
     * @param descripcion 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Cueta de cobro asociada a la dieta. Cotiene la informacion sobre el costo total de la dieta.
     * @return cuenta de cobro
     */
//    public CuentaDeCobro getCuentaCobro() {
//        return cuentaCobro;
//    }
//
//    /**
//     * Cambia la cuenta de cobro
//     * @param cuentaCobro 
//     */
//    public void setCuentaCobro(CuentaDeCobro cuentaCobro) {
//        this.cuentaCobro = cuentaCobro;
//    }
//
//    /**
//     * Semanas, duracion de la dieta
//     * @return lista de tipo Semana
//     */
//    public List<Semana> getSemanas() {
//        return semanas;
//    }
//
//    /**
//     * Cambia la lista de semanas
//     * @param semanas 
//     */
//    public void setSemanas(List<Semana> semanas) {
//        this.semanas = semanas;
//    }
    
    
    public static void main(String [] args)
	{
            System.out.println("AXBAJS");
            
            
	}
    
    
}
