/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.CasoExitoEntity;

/**
 * CasoExitoDTO modela el objeto que se transfiere entre el cliente y el
 * servidor en formato JSON.
 * 
 * El formato JSON de este objeto es el siguiente:
 * {
 *  "comentario": String,
 *  "fotoAntes": String,
 *  "fotoDespues":String,
 *  "testimonio": String,
 *  "dieta": {
 *            "objetivo": String,
 *            "descripcion": String,
 *            "cuentaDeCobro": {
 *                              "valor a pagar": double
 *                             }
 * }
 * @author pa.suarezm
 */
public class CasoExitoDTO {
    
    //-----------------------------------------------------------
    //Atributos
    //-----------------------------------------------------------
    
    private Long id;
    
    private String comentario;
    
    private String testimonio;
    
    private String fotoAntesyDespues;
    
    //-----------------------------------------------------------
    //Constructor
    //-----------------------------------------------------------
    
    /**
     * Constructor de un dto de caso exito a partir de un entity
     * @param entidad Entidad a partir de la cual se construye el dto
     */
    public CasoExitoDTO(CasoExitoEntity entidad){
        //DONE: entidad puede ser null
        if(entidad != null){
            id = entidad.getId();
            
            comentario = entidad.getComentario();
        
            testimonio = entidad.getTestimonio();
            
            fotoAntesyDespues= entidad.getFotoAntesyDespues();
        
        }
    }
    
    /**
     * Constructor vacío para propósitos de persistencia
     */
    public CasoExitoDTO(){
        //Constructor para propositos de persistencia
    }
    
    //-----------------------------------------------------------
    //Metodos
    //-----------------------------------------------------------
    
    /**
     * @return el id del caso
     */
    public Long getId(){
        return id;
    }
    
    /**
     * @param pId nuevo id
     */
    public void setId(Long pId){
        id = pId;
    }
    
    /**
     * @return El comentario asociado al caso
     */
    public String getComentario(){
        return comentario;
    }
    
    /**
     * @param pComentario Nuevo comentario asociado al caso
     */
    public void setComentario(String pComentario){
        comentario = pComentario;
    }
    
    /**
     * @return El testimonio del caso
     */
    public String getTestimonio(){
        return testimonio;
    }
    
    /**
     * @param pTestimonio Nuevo testimonio del caso 
     */
    public void setTestimonio(String pTestimonio){
        testimonio = pTestimonio;
    }

    public String getFotoAntesyDespues() {
        return fotoAntesyDespues;
    }

    public void setFotoAntesyDespues(String fotoAntesyDespues) {
        this.fotoAntesyDespues = fotoAntesyDespues;
    }
    
   
   
  
    /**
     * Convierte este objeto DTO a una entidad
     * @return Un nuevo entity con los valores del DTO
     */
    public CasoExitoEntity toEntity(){
        CasoExitoEntity entidad = new CasoExitoEntity();
        
        entidad.setId(id);
        entidad.setComentario(comentario);
        entidad.setTestimonio(testimonio);
        entidad.setFotoAntesyDespues(fotoAntesyDespues);
      
        
        return entidad;
    }
}
