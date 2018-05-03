/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.test.logic;

import co.edu.uniandes.csw.pear.ejb.CalificacionLogic;
import co.edu.uniandes.csw.pear.entities.CalificacionEntity;
import co.edu.uniandes.csw.pear.entities.DietaTipoEntity;
import co.edu.uniandes.csw.pear.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.pear.persistence.CalificacionPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author ga.bejarano10
 */
@RunWith(Arquillian.class)
public class CalificacionLogicTest {
    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private CalificacionLogic calificacionLogic;
    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;
    
     private List<CalificacionEntity> data = new ArrayList<CalificacionEntity>();
     private List<DietaTipoEntity> dataDieta= new ArrayList<DietaTipoEntity>();
     
     @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CalificacionEntity.class.getPackage())
                .addPackage(CalificacionLogic.class.getPackage())
                .addPackage(CalificacionPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    /**
     * Configuración inicial de la prueba.
     *
     *
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * Limpia las tablas que están implicadas en la prueba.
     *
     *
     */
    private void clearData() {
        em.createQuery("delete from CalificacionEntity").executeUpdate();
        em.createQuery("delete from DietaTipoEntity").executeUpdate();
    }
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {

        for (int i = 0; i < 3; i++) {
            DietaTipoEntity entity = factory.manufacturePojo(DietaTipoEntity.class);
            em.persist(entity);
            dataDieta.add(entity);
        }
        for (int i = 0; i < 3; i++) {
            CalificacionEntity entity = factory.manufacturePojo(CalificacionEntity.class);
            entity.setDieta(dataDieta.get(1));
            em.persist(entity);
            data.add(entity);
         
        }

    }
    /**
     * Prueba para crear una calificacion
     *
     *
     */
    @Test
    public void createCalificacionTest() throws BusinessLogicException {
        CalificacionEntity newEntity = factory.manufacturePojo(CalificacionEntity.class);
        CalificacionEntity result = calificacionLogic.createCalificacion(data.get(0).getDieta().getId(), newEntity);
        Assert.assertNotNull(result);
        CalificacionEntity entity = em.find(CalificacionEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        int puntuacionNueva =(int) newEntity.getPuntuacion();
        int puntuacion = (int)  entity.getPuntuacion();
        Assert.assertEquals(puntuacionNueva, puntuacion);
    }
    /**
     * Prueba para consultar la lista de calificaciones
     *
     *
     */
    @Test
    public void getCalificacionesTest() throws BusinessLogicException {
        List<CalificacionEntity> list = calificacionLogic.getCalificaciones(dataDieta.get(1).getId());
        Assert.assertEquals(data.size(), list.size());
        for (CalificacionEntity entity : list) {
            boolean found = false;
            for (CalificacionEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    /**
     * Prueba para consultar una calificacion
     *
     *
     */
    @Test
    public void getCalificacionTest() {
        CalificacionEntity entity = data.get(0);
        CalificacionEntity resultEntity = calificacionLogic.getCalificacion(dataDieta.get(1).getId(),entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        int puntuacionNueva =(int) resultEntity.getPuntuacion();
        int puntuacion = (int)  entity.getPuntuacion();
        Assert.assertEquals(puntuacion, puntuacionNueva);
    }
     /**
     * Prueba para eliminar una calificacoin
     *
     *
     */
    @Test
    public void deleteCalificacionTest() throws BusinessLogicException {
        CalificacionEntity entity = data.get(0);
        calificacionLogic.deleteCalificacion(dataDieta.get(1).getId(),entity.getId());
        CalificacionEntity deleted = em.find(CalificacionEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    /**
     * Prueba para actualizar una calificacion
     *
     *
     */
    @Test
    public void updateCalificacionTest() throws BusinessLogicException {
        CalificacionEntity entity = data.get(0);
        CalificacionEntity pojoEntity = factory.manufacturePojo(CalificacionEntity.class);

        pojoEntity.setId(entity.getId());

        calificacionLogic.updateCalificacion(dataDieta.get(1).getId(),pojoEntity);

        CalificacionEntity resp = em.find(CalificacionEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getName(), resp.getName());
        int pojo=(int) pojoEntity.getPuntuacion();
        int respe=(int) resp.getPuntuacion();
        Assert.assertEquals(pojo, respe);
    }

}
