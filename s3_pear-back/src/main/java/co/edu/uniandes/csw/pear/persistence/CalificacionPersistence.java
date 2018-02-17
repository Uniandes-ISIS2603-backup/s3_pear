/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.persistence;

/**
 *
 * @author ga.bejarano10
 */
import co.edu.uniandes.csw.pear.entities.CalificacionEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class CalificacionPersistence 
{
    private static final Logger LOGGER = Logger.getLogger(CalificacionPersistence.class.getName());  
  
    @PersistenceContext(unitName = "PearPU")
    protected EntityManager em;
    
    public CalificacionEntity create(CalificacionEntity entidad)
    {
        LOGGER.info("Creando una calificacion nueva");
        em.persist(entidad);
        LOGGER.info("Creando una calificacacion nueva");
        return entidad;
    }   
     public List<CalificacionEntity> findAll() {
        LOGGER.info("Consultando todas las calificaciones");
        TypedQuery query = em.createQuery("select u from CalificacionEntity u", CalificacionEntity.class);
        return query.getResultList();
    }
     public CalificacionEntity update(CalificacionEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando calificacion con id={0}", entity.getId());
        return em.merge(entity);
    }
     
    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando calificacion con id={0}", id);
        CalificacionEntity entity = em.find(CalificacionEntity.class, id);
        em.remove(entity);
    }
    
}
