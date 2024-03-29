/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.dtos;

import co.edu.uniandes.csw.pear.entities.DietaTipoEntity;
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

    private List<DietaTipoDTO> dietas;

    private List<QuejasyReclamosDTO> quejas;

    private List<FacturaDTO> facturas;

    private CuentaCobroDTO cuenta;
    
    

    //-----------------------------------------------------------
    //Constructor
    //-----------------------------------------------------------
    public PersonaDetailDTO() {
        super();
    }

    public PersonaDetailDTO(PersonaEntity entidad) {
        super(entidad);
        if (entidad != null) {
            quejas = new ArrayList<>();
            for (QuejasyReclamosEntity qyr : entidad.getQuejas()) {
                if (qyr != null) {
                    quejas.add(new QuejasyReclamosDTO(qyr));
                }
            }
            facturas = new ArrayList<>();
            for (FacturaEntity f : entidad.getFacturas()) {
                if (f != null) {
                    facturas.add(new FacturaDTO(f));
                }
            }
               
            
            
            if (entidad.getCuenta() != null) {
                this.cuenta = new CuentaCobroDTO(entidad.getCuenta());
            } else {
                this.cuenta = null;
            }
            
            if (entidad.getDietas() != null) {
            dietas = new ArrayList<>();
            for (DietaTipoEntity dieta : entidad.getDietas()){
                dietas.add(new DietaTipoDTO(dieta));
            }
          
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
     *
     * @return
     */
    public List<DietaTipoDTO> getDietas() {
        return dietas;
    }

    /**
     *
     * @param dietas
     */
    public void setDietas(List<DietaTipoDTO> dietas) {
        this.dietas = dietas;
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
        PersonaEntity entidad = super.toEntity();
        if (entidad != null) {

            if (this.getDietas() != null) {
                List<DietaTipoEntity> ds = new ArrayList<>();
                for(DietaTipoDTO y: dietas){
                    ds.add(y.toEntity());
                }
                entidad.setDieta(ds);
            }

            List<QuejasyReclamosEntity> qyrE = new ArrayList<>();

            if (quejas != null) {
                for (QuejasyReclamosDTO qyr : quejas) {
                        qyrE.add(qyr.toEntity());
                }
            }
            entidad.setQuejas(qyrE);
              
            List<FacturaEntity> fE = new ArrayList<>();

            if (facturas != null) {
                for (FacturaDTO f : facturas) {    
                        fE.add(f.toEntity());
                }
            }

            entidad.setFacturas(fE);

            if (getCuenta() != null) {
                entidad.setCuenta(getCuenta().toEntity());
            }

        }
        return entidad;
    }

    /**
     * @return the cuenta
     */
    public CuentaCobroDTO getCuenta() {
        return cuenta;
    }

    /**
     * @param cuenta the cuenta to set
     */
    public void setCuenta(CuentaCobroDTO cuenta) {
        this.cuenta = cuenta;
    }
}
