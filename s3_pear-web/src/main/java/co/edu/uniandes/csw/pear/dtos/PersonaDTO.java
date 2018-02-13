/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.PersonaEntity;

/**
 * PersonaDTO modela el objeto que se transfiere entre el cliente y el servidor 
 * en formato JSON.
 * 
 * El formato JSON de este objeto es el siguiente:
 * {
 *  "nombre": String,
 *  "apellido": String,
 *  "edad": int,
 *  "direccion": String,
 *  "correo": String,
 *  "subscrito": boolean,
 *  "identificacion": String
 *  "calificacion": {
 *                    "puntuacion": double
 *                  },
 *  "dieta": {
 *              "objetivo": String,
 *              "descripcion": String,
 *              "cuentaDeCobro": {
 *                                  "valorAPagar": double
 *                               }
 *           }
 * }
 *  //TODO *******ACTUALIZAR A MEDIDA QUE ESTEN HECHAS LAS DEMAS CLASES********
 * @author pa.suarezm
 */
public class PersonaDTO {
    
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
    
    //-----------------------------------------------------------
    //Constructor
    //-----------------------------------------------------------
    
    /**
     * Constructor de dto de persona a partir de un entity
     * @param entidad Entidad a partir de la cual se construye el dto
     */
    
    public PersonaDTO(PersonaEntity entidad){
        
        nombre = entidad.getNombre();
        
        apellido = entidad.getApellido();
        
        edad = entidad.getEdad();
        
        direccion = entidad.getDireccion();
        
        correo = entidad.getCorreo();
        
        subscrito = entidad.isSubscrito();
        
        identificacion = entidad.getIdentificacion();
    }
    
    /**
     * Constructor vacío para propósitos de persistencia
     */
    public PersonaDTO(){
        
    }
    
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
    public void setSubsccrito(boolean pSubscrito){
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
     * Convierte este objeto DTO a una entidad
     * @return Un nuevo entity con los valores del DTO
     */
    public PersonaEntity toEntity(){
        PersonaEntity entidad = new PersonaEntity();
        
        entidad.setNombre(nombre);
        entidad.setApellido(apellido);
        entidad.setCorreo(correo);
        entidad.setDireccion(direccion);
        entidad.setEdad(edad);
        entidad.setIdentificacion(identificacion);
        entidad.setSubscrito(subscrito);
        
        //TODO Falta que quien sea responsable de DietaTipo implemente el
        //     método toEntity()
        
        return entidad;
    }
}
