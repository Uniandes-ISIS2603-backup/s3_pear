/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;
import co.edu.uniandes.csw.pear.entities.ComidaEntity;
import co.edu.uniandes.csw.pear.entities.DiaEntity;
import co.edu.uniandes.csw.pear.entities.EnvioEntity;
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
    
    private List<EnvioDetailDTO> envios;
    
    private List<ComidaDetailDTO> comidas;

    private SemanaDetailDTO semana;
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
        if(entity.getEnvios() != null){
            envios = new ArrayList<>();
        for(EnvioEntity y : entity.getEnvios()){
            envios.add(new EnvioDetailDTO(y));
        }
        }
        else{
            envios = new ArrayList<>();
        }
        if(entity.getComidas() != null){
            comidas = new ArrayList<>();
        for(ComidaEntity y : entity.getComidas()){
            comidas.add(new ComidaDetailDTO(y));
        }
        }
        else{
            comidas = new ArrayList<>();
        }
        if(entity.getSemana() != null){
            semana =  new SemanaDetailDTO(entity.getSemana());
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
    
    public void setSemana(SemanaDetailDTO sem){
        semana = sem;
    }
    
    public SemanaDetailDTO getSemana(){
        return semana;
    }
    /**
     * Determina los envios programados para ese dia
     * @param pEnvios envios programadas
     */
    public void setEnvios(List<EnvioDetailDTO> pEnvios){
        envios = pEnvios;
    }
    
    /**
     * @return los envios programadas ese dia para el cliente
     */
    public List<EnvioDetailDTO> getEnvios(){
        return envios;
    }
    
    /**
     * Determina las comidas para ese dia
     * @param pComidas envios programadas
     */
    public void setComidas(List<ComidaDetailDTO> pComidas){
        comidas = pComidas;
    }
    
    /**
     * @return los envios programadas ese dia para el cliente
     */
    public List<ComidaDetailDTO> getComidas(){
        return comidas;
    }
    
    @Override
    public DiaEntity toEntity(){
        DiaEntity entity = super.toEntity();
        if(entity != null){
            if(this.getEnvios() != null){
            List<EnvioEntity> listaEnvios = new ArrayList<>();
            for(EnvioDTO y: envios){
                listaEnvios.add(y.toEntity());
            }
            entity.setEnvios(listaEnvios);
            }
            if(this.getComidas() != null){
            List<ComidaEntity> listaComidas = new ArrayList<>();
            for(ComidaDTO y: comidas){
                listaComidas.add(y.toEntity());
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
