/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;
import co.edu.uniandes.csw.pear.entities.DiaEntity;
import co.edu.uniandes.csw.pear.entities.SemanaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 El formato JSON de este objeto es el siguiente:
 * {
 *  "id": 123,
 *  "fechaLunes": "14/02/2018",
 *  "dias":[
 *      {    "SeEnvia": true,
 *           "recomendacion": "evitar la sal",
 *           "fecha": "14/02/2018"
 *      }
 *         ]
 * }
 * @author v.chacon
 */
public class SemanaDetailDTO extends SemanaDTO {
    
    //-----------------------------------------------------------
    //Atributos
    //-----------------------------------------------------------
    private List<DiaDTO> dias;
    
    private DietaTipoDTO dieta;
    //-----------------------------------------------------------
    //Constructor
    //-----------------------------------------------------------
    
    public SemanaDetailDTO(SemanaEntity entity){
        super(entity);
        if(entity != null){
            if(entity.getDias() != null){
            dias =  new ArrayList<>();
            for(DiaEntity y: entity.getDias()) {
                dias.add(new DiaDTO(y));
            }
            }
            else dias = new ArrayList<>();
            if(entity.getDieta() != null){
            dieta =  new DietaTipoDTO(entity.getDieta());
            }
            else{
            dieta = null;
            }
         }    
      }
    
    public SemanaDetailDTO(){
        super();
    }
    //-----------------------------------------------------------
    //Metodos
    //-----------------------------------------------------------
    /**
     * Determina los dias que contiene la semana, esta lista siempre tiene que tener 7 elementos. 
     * @param lista de los dias
     */
    public void setDias(List<DiaDTO> lista){
       dias = lista;
    }
    
    /**
     * @return lista de los dias que componen la semana
     */
    public List<DiaDTO> getDias(){
        return dias;
    }
    
    public void setDieta(DietaTipoDTO di){
        dieta = di;
    }
    
    public DietaTipoDTO getDieta(){
        return dieta;
    }
    
    
    
    @Override
 public SemanaEntity toEntity(){
        
        SemanaEntity entity = super.toEntity();
        if(entity != null){
            if(this.getDias()!= null){
            List<DiaEntity> days = new ArrayList<>();
            for(DiaDTO y: dias){
                days.add(y.toEntity());
            }
            entity.setDias(days);
        }
        if(this.getDieta()!= null){
            entity.setDieta(this.getDieta().toEntity());
        }
       }
        return entity;
    }  
}
