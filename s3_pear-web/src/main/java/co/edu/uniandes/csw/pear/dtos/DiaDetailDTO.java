/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.ComidaEntity;
import co.edu.uniandes.csw.pear.entities.DiaEntity;
import java.util.ArrayList;
import java.util.List;

/**
  * El formato JSON de este objeto es el siguiente:
 * {"SeEnvia": true,
 *  "recomendacion": "Evitar la sal",
 *  "fecha": "14/02/2018",
 *  "comida": [
 *       {
 *              "cantidad": 2,
 *              "alimentos": "1 Zanahoria, 1 Tomate",
 *              "direccion": "Calle 48",
 *              "tipo":  "ADELGAZAR"
 *       }
 *            ]
 * }
 * @author v.chacon
 */
public class DiaDetailDTO extends DiaDTO{
    
    //-----------------------------------------------------------
    //Atributos
    //-----------------------------------------------------------
    
    private List<ComidaDTO> comidas;

    private SemanaDTO semana;
    //-----------------------------------------------------------
    //Constructor
    //-----------------------------------------------------------
    
    /**
     * Constructor de la clase 
     * @param entity entidad a apartir de la cual se construye el dto
     */
    public DiaDetailDTO(DiaEntity entity){
        super(entity);
        if(entity!= null){
        if(entity.getComidas() != null){
            comidas = new ArrayList<>();
        for(ComidaEntity y : entity.getComidas()){
            comidas.add(new ComidaDTO(y));
        }
        }
        else{
            comidas = new ArrayList<>();
        }
        if(entity.getSemana() != null){
            semana =  new SemanaDTO(entity.getSemana());
        }
        else{
            semana = null;
        }
        }
        
    }
    
    /**
     * Constructor de la clase DiaDetailDTO
     */
    public DiaDetailDTO(){
        super();
    }
    
    //-----------------------------------------------------------
    //Metodos
    //-----------------------------------------------------------
    
    public void setSemana(SemanaDTO sem){
        semana = sem;
    }
    
    public SemanaDTO getSemana(){
        return semana;
    }
    /**
     * Determina las comidas programadas para ese dia
     * @param pComidas comidas programadas
     */
    public void setComidas(List<ComidaDTO> pComidas){
        comidas = pComidas;
    }
    
    /**
     * @return las comidas programadas ese dia para el cliente
     */
    public List<ComidaDTO> getComidas(){
        return comidas;
    }
    
    @Override
    public DiaEntity toEntity(){
        DiaEntity entity = super.toEntity();
        if(entity != null){
            if(this.getComidas() != null){
            List<ComidaEntity> listaComidas = new ArrayList<>();
            for(ComidaEntity y: entity.getComidas()){
                listaComidas.add(y);
            }
            entity.setComidas(listaComidas);
        }
        if(this.getSemana() != null){
            entity.setSemana(this.getSemana().toEntity());
         }
        }
        return entity;
    }
}
