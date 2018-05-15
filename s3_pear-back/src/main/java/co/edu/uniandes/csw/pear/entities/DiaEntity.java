/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;
/**
 * Clase que representa la entidad de un dia
 * @author v.chacon
 */

@Entity
public class DiaEntity extends BaseEntity implements Serializable {
    
    //-----------------------------------------------------------
    //Atributos
    //-----------------------------------------------------------
    
    private Boolean seEnvia;
 
    private String recomendacion;
    
    private String fecha;
    
    
    @PodamExclude
    @OneToMany(mappedBy = "dia", cascade = CascadeType.ALL)
    private List<EnvioEntity> envios;
    
    @PodamExclude
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name="DIAS_SEMANAS", 
        joinColumns=@JoinColumn(name="diaID"),
        inverseJoinColumns=@JoinColumn(name="semanaId")
    )
    private SemanaEntity semana;
    
    //-----------------------------------------------------------
    // Metodos
    //-----------------------------------------------------------
    
    public SemanaEntity getSemana(){
        return semana;
    }
    public void setSemana(SemanaEntity sem){
        semana  = sem;
    }
    /**
     * Determina si la comida se envia o no (Esto varia segun la disponibilidad del cliente)
     * @param pSeEnvia boolean para indicar si se debe o no enviar la comida programada
     */
    public void setSeEnvia (Boolean pSeEnvia){
        seEnvia = pSeEnvia;
    }
    
    /**
     * @return si se debe o no enviar la comida ese dia
     */
    public Boolean getSeEnvia(){
        return seEnvia;
    }
    /**
     * Determina las recomendaciones adicionales que hay para el cliente
     * @param rec las recomendaciones
     */
    public void setRecomendacion(String rec){
        recomendacion  = rec;
    }
    
    /**
     * @return las recomendaciones que se le deben entregar al cliente ese dia
     */
    public String getRecomendacion(){
        return recomendacion;
    }
    
    /**
     * Determina las comidas programadas para ese dia
     * @param pEnvios comidas programadas
     */
    public void setEnvios(List<EnvioEntity> pEnvios){
        envios = pEnvios;
    }
    
    /**
     * @return las comidas programadas ese dia para el cliente
     */
    public List<EnvioEntity> getEnvios(){
        return envios;
    } 
    
    /**
     * Determina la fecha de este dia
     * @param pFecha 
     */
    public void setFecha(String pFecha){
        fecha = pFecha;
    }
    
    /**
     * @return fecha del dia
     */
    public String getFecha(){
        return fecha;
    }
}
