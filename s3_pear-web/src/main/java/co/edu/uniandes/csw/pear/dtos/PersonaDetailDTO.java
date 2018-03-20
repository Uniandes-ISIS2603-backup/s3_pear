/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.FacturaEntity;
import co.edu.uniandes.csw.pear.entities.PersonaEntity;
import co.edu.uniandes.csw.pear.entities.QuejasyReclamosEntity;
import java.util.List;
import java.util.ArrayList;

/**
 * @author pa.suarezm
 */
public class PersonaDetailDTO extends PersonaDTO {

    //-----------------------------------------------------------
    //Atributos
    //-----------------------------------------------------------
    private CalificacionDTO calificacion;

    private DietaTipoDTO dieta;

    private List<QuejasyReclamosDTO> quejas;

    private List<FacturaDTO> facturas;

    //-----------------------------------------------------------
    //Constructor
    //-----------------------------------------------------------
    public PersonaDetailDTO() {
        super();
    }

    public PersonaDetailDTO(PersonaEntity entidad) {
        //DONE: Sin terminar 
        super(entidad);
        if(entidad != null){
           quejas = new ArrayList<QuejasyReclamosDTO>();
           for(QuejasyReclamosEntity qyr: entidad.getQuejas()){
               if(qyr != null)
                   quejas.add(new QuejasyReclamosDTO(qyr));
           }
           
           facturas = new ArrayList<FacturaDTO>();
           for(FacturaEntity f: entidad.getFacturas()){
               if(f != null)
                   facturas.add(new FacturaDTO(f));
           }
        }
    }

    //-----------------------------------------------------------
    //Metodos
    //-----------------------------------------------------------
    /**
     * @return lista de facturas
     */
    public List<FacturaDTO> getFacturas() {
        return facturas;
    }

    /**
     * @param list lista de facturas
     */
    public void setFacturas(List<FacturaDTO> list) {
        facturas = list;
    }

    /**
     * @return calificacion que otorga la persona
     */
    public CalificacionDTO getCalificacion() {
        return calificacion;
    }

    /**
     * @param pCalificacion nueva calificacion otorgada por la persona
     */
    public void setCalificacion(CalificacionDTO pCalificacion) {
        calificacion = pCalificacion;
    }

    /**
     * @return dieta asignada a la persona
     */
    public DietaTipoDTO getDieta() {
        return dieta;
    }

    /**
     * @param pDieta nueva dieta asignada para la persona
     */
    public void setDieta(DietaTipoDTO pDieta) {
        dieta = pDieta;
    }

    /**
     * @return quejas que tiene la persona
     */
    public List<QuejasyReclamosDTO> getQuejas() {
        return quejas;
    }

    /**
     * @param pQuejas nueva lista de quejas
     */
    public void setQuejas(List<QuejasyReclamosDTO> pQuejas) {
        quejas = pQuejas;
    }

    @Override
    public PersonaEntity toEntity() {
        //DONE: Sin terminar 
        PersonaEntity entidad = super.toEntity();
        if(entidad != null){
            entidad.setDieta(dieta.toEntity());
            
            List<QuejasyReclamosEntity> qyrE = new ArrayList<QuejasyReclamosEntity>();
            for(QuejasyReclamosDTO qyr: quejas){
                if(qyr != null)
                    qyrE.add(qyr.toEntity());
            }
            entidad.setQuejas(qyrE);
            
            List<FacturaEntity> fE = new ArrayList<FacturaEntity>();
            for(FacturaDTO f: facturas){
                if(f != null)
                    fE.add(f.toEntity());
            }
            entidad.setFacturas(fE);
        }
        return entidad;
    }

}
