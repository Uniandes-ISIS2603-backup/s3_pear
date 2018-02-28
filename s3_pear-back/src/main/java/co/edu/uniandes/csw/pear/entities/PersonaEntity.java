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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;
/**
 * @author pa.suarezm
 */
@Entity
public class PersonaEntity extends BaseEntity implements Serializable{
    
    //-----------------------------------------------------------
    //Atributos
    //-----------------------------------------------------------
    
    private String nombre;
    
    private String apellido;
    
    private Integer edad;
    
    private String direccion;
    
    private String correo;
    
    private Boolean subscrito;
    
    private String identificacion;
    
    @PodamExclude
    @OneToOne (cascade = CascadeType.PERSIST)
    private CalificacionEntity calificacion;
    
    @PodamExclude
    @OneToOne (cascade = CascadeType.PERSIST, orphanRemoval = true)
    private DietaTipoEntity dieta;
    
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<QuejasyReclamosEntity> quejas;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    private MedioPagoEntity medioPago;
    
    @OneToMany(mappedBy = "persona")
    List<FacturaEntity> facturas;
    
    //-----------------------------------------------------------
    //Metodos
    //-----------------------------------------------------------
    
    /**
     * @return lista de facturas
     */
    public List<FacturaEntity> getFacturas(){
        return facturas;
    }
    
    /**
     * @param list lista de facturas
     */
    public void setFacturas(List<FacturaEntity> list){
        facturas = list;
    }
    
    /**
     * @return el medio de pago
     */
    public MedioPagoEntity getMedioPago(){
        return medioPago;
    }
    
    /**
     * @param entity Medio de pago
     */
    public void setMedioPago(MedioPagoEntity entity){
        medioPago = entity;
    }
    
    /**
     * @return nombre de la persona
     */    
    public String getNombre(){
        return nombre;
    }
    
    /**
     * @param pNombre nuevo nombre para asignar
     */
    public void setNombre(String pNombre){
        nombre = pNombre;
    }
    
    /**
     * @return apellido de la persona
     */
    public String getApellido(){
        return apellido;
    }
    
    /**
     * @param pApellido nuevo apellido para asignar
     */
    public void setApellido(String pApellido){
        apellido = pApellido;
    }
    
    /**
     * @return edad de la personam
     */
    public Integer getEdad(){
        return edad;
    }
    
    /**
     * @param pEdad nueva edad para asignar
     */
    public void setEdad(Integer pEdad){
        edad = pEdad;
    }
    
    /**
     * @return direccion fisica de la persona
     */
    public String getDireccion(){
        return direccion;
    }
    
    /**
     * @param pDireccion nueva direccion fisica
     */
    public void setDireccion(String pDireccion){
        direccion = pDireccion;
    }
    
    /**
     * @return correo electrónico de la persona
     */
    public String getCorreo(){
        return correo;
    }
    
    /**
     * @param pCorreo nuevo correo electrónico
     */
    public void setCorreo(String pCorreo){
        correo = pCorreo;
    }
    
    /**
     * @return booleano indicando si la persona está subscrita o no
     */
    public Boolean isSubscrito(){
        return subscrito;
    }
    
    /**
     * @param pSubscrito cambia el indicador de subscripción de la persona
     */
    public void setSubscrito(Boolean pSubscrito){
        subscrito = pSubscrito;
    }
    
    /**
     * @return identificacion de la persona
     */
    public String getIdentificacion(){
        return identificacion;
    }
    
    /**
     * @param pIdentificacion nueva identificacion para la persona
     */
    public void setIdentificacion(String pIdentificacion){
        identificacion = pIdentificacion;
    }
    
    /**
     * @return calificacion que otorga la persona
     */
    public CalificacionEntity getCalificacion(){
        return calificacion;
    }
    
    /**
     * @param pCalificacion nueva calificacion otorgada por la persona
     */
    public void setCalificacion(CalificacionEntity pCalificacion){
        calificacion = pCalificacion;
    }
    
    /**
     * @return dieta asignada para la persona
     */
    public DietaTipoEntity getDieta(){
        return dieta;
    }
    
    /**
     * @param pDieta nueva dieta asignada a la persona
     */
    public void setDieta(DietaTipoEntity pDieta){
        dieta = pDieta;
    }
    
    /**
     * @return las quejas que tiene la persona
     */
    public List<QuejasyReclamosEntity> getQuejas(){
        return quejas;
    }
    
    /**
     * @param pQuejas asigna las quejas que tiene la persona
     */
    public void setQuejas(List<QuejasyReclamosEntity> pQuejas){
        quejas = pQuejas;
    }
}
