/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.test.logic;

import co.edu.uniandes.csw.pear.ejb.DiaLogic;
import co.edu.uniandes.csw.pear.entities.DiaEntity;
import co.edu.uniandes.csw.pear.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.pear.persistence.DiaPersistence;
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
 * @author v.chacon
 */

@RunWith(Arquillian.class)
public class DiaLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();
      
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private UserTransaction utx;
   
    private List<DiaEntity> data = new ArrayList<DiaEntity>();
    
    
    @Inject
    private DiaLogic logic;
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(DiaEntity.class.getPackage())
                .addPackage(DiaLogic.class.getPackage())
                .addPackage(DiaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    /**
     * Configuración inicial de la prueba.
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
     */
    private void clearData() {
        em.createQuery("delete from DiaEntity").executeUpdate();
    }
    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            DiaEntity entity = factory.manufacturePojo(DiaEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
    
    
    /**
     * Prueba para crear un Dia
     * @throws BusinessLogicException
     */
    @Test
    public void createTest() throws BusinessLogicException {
        DiaEntity newEntity = factory.manufacturePojo(DiaEntity.class);
        DiaEntity result = logic.createDia(newEntity);
        Assert.assertNotNull(result);
        DiaEntity entity = em.find(DiaEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getFecha(), entity.getFecha());
        Assert.assertEquals(newEntity.getRecomendacion(),entity.getRecomendacion());
        Assert.assertEquals(newEntity.getSeEnvia(),entity.getSeEnvia());
        //Assert.assertEquals(newEntity.getComidas(), entity.getComidas());
    }
    
    /**
     * Prueba para consultar la lista de comidas
     */
    @Test
    public void getListTest() {
        List<DiaEntity> list = logic.getDias();
        Assert.assertEquals( data.size(), list.size());
        for (DiaEntity entity : list) {
            boolean found = false;
            for (DiaEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
     /**
     * Prueba para consultar un Dia
     */
    @Test
    public void getDiaTest() {
        DiaEntity entity = data.get(0);
        DiaEntity resultEntity = logic.getDia(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getName(), resultEntity.getName());
        Assert.assertEquals(entity.getFecha(), resultEntity.getFecha());
        Assert.assertEquals(entity.getRecomendacion(),resultEntity.getRecomendacion());
        Assert.assertEquals(entity.getSeEnvia(),resultEntity.getSeEnvia());
        //Assert.assertEquals(entity.getComidas(), resultEntity.getComidas());
 
    }
    
    
    /**
     * Prueba para eliminar un Dia
     */
    @Test
    public void deleteDiaTest() throws BusinessLogicException {
        DiaEntity entity = data.get(0);
            logic.deleteDia(entity.getId());
        DiaEntity deleted = em.find(DiaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    /**
     * Prueba para actualizar un Dia
     */
    @Test
    public void updateDiaTest() throws BusinessLogicException {
        DiaEntity entity = data.get(0);
        DiaEntity pojoEntity = factory.manufacturePojo(DiaEntity.class);

        pojoEntity.setId(entity.getId());

        logic.updateDia(pojoEntity.getId(), pojoEntity);

        DiaEntity resp = em.find(DiaEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getName(), resp.getName());
        Assert.assertEquals(pojoEntity.getFecha(), resp.getFecha());
        Assert.assertEquals(pojoEntity.getRecomendacion(),resp.getRecomendacion());
        Assert.assertEquals(pojoEntity.getSeEnvia(),resp.getSeEnvia());
       // Assert.assertEquals(pojoEntity.getComidas(), resp.getComidas());
        
    }
}
