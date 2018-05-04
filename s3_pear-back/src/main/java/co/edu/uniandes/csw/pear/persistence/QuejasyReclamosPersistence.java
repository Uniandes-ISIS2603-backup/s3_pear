/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.persistence;

import co.edu.uniandes.csw.pear.entities.CalificacionEntity;
import co.edu.uniandes.csw.pear.entities.QuejasyReclamosEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author ga.bejarano10
 */
@Stateless
public class QuejasyReclamosPersistence 
{
    private static final Logger LOGGER = Logger.getLogger(QuejasyReclamosPersistence.class.getName());  
    @PersistenceContext(unitName = "PearPU")
    protected EntityManager em;
    
    public QuejasyReclamosEntity create(QuejasyReclamosEntity entity) {
        LOGGER.info("Creando una queja y/o reclamo nuevo");
        em.persist(entity);
        LOGGER.info("queja y/o reclamo creado");
        return entity;
    }
    public List<QuejasyReclamosEntity> findAll(Long dietaid) {
        LOGGER.info("Consultando todas las calificaciones");
        TypedQuery query = em.createQuery("select u from QuejasyReclamosEntity u where (u.dieta.id=:dietaid)", QuejasyReclamosEntity.class);
        query.setParameter("dietaid", dietaid);
        return query.getResultList();
    }
    public QuejasyReclamosEntity update(QuejasyReclamosEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando queja y/o reclamo con id={0}", entity.getId());
        return em.merge(entity);
    }
    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando employee con id={0}", id);
        QuejasyReclamosEntity entity = em.find(QuejasyReclamosEntity.class, id);
        em.remove(entity);
    }
    public  QuejasyReclamosEntity find( Long dietaid ,Long id){
        TypedQuery<QuejasyReclamosEntity> q = em.createQuery("select p from QuejasyReclamosEntity p where (p.dieta.id = :dietaid) and (p.id = :id)", QuejasyReclamosEntity.class);
        q.setParameter("dietaid", dietaid);
        q.setParameter("id", id);
        List<QuejasyReclamosEntity> results = q.getResultList();
        QuejasyReclamosEntity queja = null;
        if (results == null) {
            queja = null;

        } else if (results.isEmpty()) {
            queja= null;
        } else if (results.size() >= 1) {
            queja = results.get(0);
        }

        
        return queja;
    }
    
    
    
    
}
