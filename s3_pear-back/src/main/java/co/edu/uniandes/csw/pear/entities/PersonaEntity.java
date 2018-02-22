/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.entities;

import java.io.Serializable;
import javax.persistence.Entity;

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
    
    private int edad;
    
    private String direccion;
    
    private String correo;
    
    private boolean subscrito;
    
    private String identificacion;
    
    private CalificacionEntity calificacion;
    
    private DietaTipoEntity dieta;
    
    //-----------------------------------------------------------
    //Metodos
    //-----------------------------------------------------------
    
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
    public int getEdad(){
        return edad;
    }
    
    /**
     * @param pEdad nueva edad para asignar
     */
    public void setEdad(int pEdad){
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
    public boolean isSubscrito(){
        return subscrito;
    }
    
    /**
     * @param pSubscrito cambia el indicador de subscripción de la persona
     */
    public void setSubscrito(boolean pSubscrito){
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
}
