/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.CocinaEntity;
import co.edu.uniandes.csw.pear.entities.DietaTipoEntity;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *{
   "id": 123,
  "ubicacion": "Una ubicacion",
  "capacidad": "una capacidad",
  "dietas": [
              
       {
            "objetivo": "un objetivo",
            "descripcion": "una descripcion",
            "cuentaDeCobro": {
                     "valorAPagar": 23.00
                   },
            "semanas":[
                    {
   		"fechaLunes":"2012-04-23T18:25:43.511Z",
   		"dias":[
   			{
   				"SeEnvia": true,
   				"recomendacion": "una recomendacion",
            	"fecha": "2012-04-23T18:25:43.511Z"
                        }
                    ]
                }
               ]
        }
  
  
    ]
  }
 * @author js.garcial1
 */
public class CocinaDetailDTO extends CocinaDTO {
    
    private List<DietaTipoDTO> dietas;
    
    /**
     * Constructor CocinaDetail con paramatros
     * @param ubicacion
     * @param capacidad
     * @param dietas 
     */
    public CocinaDetailDTO(  ) {
        super();
    }
    
    public CocinaDetailDTO( CocinaEntity entity ) {
        super(entity);
        
        if ( entity.getDietas() != null ) {
            this.dietas = new ArrayList<>();
            entity.getDietas().forEach( dieta -> {
                this.dietas.add(new DietaTipoDTO(dieta));
            });
        }
        else 
            this.dietas = new ArrayList<>();
        
    }

    public List<DietaTipoDTO> getDietas() {
        return dietas;
    }

    public void setDietas(List<DietaTipoDTO> dietas) {
        this.dietas = dietas;
    }
    
    
    
    @Override 
    public CocinaEntity toEntity() {
        CocinaEntity en = super.toEntity();
        if( this.getDietas() != null ) {
            List<DietaTipoEntity> dts = new ArrayList<>();
            this.getDietas().forEach( dieta -> {
                dts.add(dieta.toEntity());
            });
            en.setDietas(dts);
        }
        return en;
    }
    
    
    
    
}
