/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;
import co.edu.uniandes.csw.pear.entities.DiaEntity;
import co.edu.uniandes.csw.pear.entities.SemanaEntity;
import co.edu.uniandes.csw.pear.entities.DietaTipoEntity;
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
    
    private List<DietaTipoDTO> dietas;
    //-----------------------------------------------------------
    //Constructor
    //-----------------------------------------------------------
    
    public SemanaDetailDTO(SemanaEntity entity){
        super(entity);
        if(entity != null){
            if(entity.getDias() != null){
            dias =  new ArrayList<>();
            entity.getDias().forEach(di -> {
                dias.add(new DiaDTO(di));
            });
            
        }
        else{
            dias = new ArrayList<>();
            }
        if(entity != null){
            if(entity.getDietas() != null){
            dietas =  new ArrayList<>();
            entity.getDietas().forEach(di -> {
                dietas.add(new DietaTipoDTO(di));
            });  
        }
        else{
            dietas = new ArrayList<>();
            }
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
    
    public void setDietas(List<DietaTipoDTO> di){
        dietas = di;
    }
    
    public List<DietaTipoDTO> getDietas(){
        return dietas;
    }
    
    
    
    @Override
    public SemanaEntity toEntity(){
        
        SemanaEntity entity = super.toEntity();
        if(this.getDias()!= null){
            List<DiaEntity> dias = new ArrayList<>();
            this.getDias().forEach(di -> {
                dias.add(di.toEntity());
            });
            entity.setDias(dias);
        }
        if(this.getDietas()!= null){
            List<DietaTipoEntity> dietas = new ArrayList<>();
            this.getDietas().forEach(dit -> {
                dietas.add(dit.toEntity());
            });
            entity.setDietas(dietas);
        }
        return entity;
    }  
}
