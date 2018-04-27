/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.*;
import uk.co.jemos.podam.common.PodamExclude;



/**
 * Clase que representa la entidad de una Semana
 * @author v.chacon
 */

@Entity
public class SemanaEntity  extends BaseEntity implements Serializable{
    
    //-----------------------------------------------------------
    //Atributos
    //-----------------------------------------------------------
    
    private String fechaLunes;
    
    @PodamExclude
    @OneToMany( cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<DiaEntity> dias;
   
    //-----------------------------------------------------------
    // Metodos
    //-----------------------------------------------------------
   
    /**
     * Determina la fecha inicial de la semana
     * @param date fecha inicial
     */
    public void setFechaLunes(String date){
        fechaLunes = date;
    }
    
    /**
     * @return fecha en la que inicion la semana, esta comenzara cada lunes
     */
    public String getFechaLunes(){
        return fechaLunes;
    }
   
    /**
     * Determina los dias que contiene la semana, esta lista siempre tiene que tener 7 elementos. 
     * @param lista de los dias
     */
    public void setListaDias(List<DiaEntity>lista){
        dias = lista;
    }
    
    /**
     * @return lista de los dias que componen la semana
     */
    public List<DiaEntity> getListaDias(){
        return dias;
    }
}
