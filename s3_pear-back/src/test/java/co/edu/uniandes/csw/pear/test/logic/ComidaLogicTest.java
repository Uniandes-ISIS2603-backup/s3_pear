/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.test.logic;


import co.edu.uniandes.csw.pear.ejb.ComidaLogic;
import co.edu.uniandes.csw.pear.entities.ComidaEntity;
import co.edu.uniandes.csw.pear.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.pear.persistence.ComidaPersistence;
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
 * @author js.cabra
 */
@RunWith(Arquillian.class)
public class ComidaLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();
          
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private UserTransaction utx;
    
    private List<ComidaEntity> data = new ArrayList<ComidaEntity>();
      
    @Inject 
    private ComidaLogic logic;
    
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ComidaEntity.class.getPackage())
                .addPackage(ComidaLogic.class.getPackage())
                .addPackage(ComidaPersistence.class.getPackage())
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
        em.createQuery("delete from ComidaEntity").executeUpdate();
    }
    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ComidaEntity entity = factory.manufacturePojo(ComidaEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear una Comida con tipo desayuno
     */
    @Test
    public void createDesayunoTest() throws BusinessLogicException {
        ComidaEntity newEntity = factory.manufacturePojo(ComidaEntity.class);
        newEntity.setTIPO("desayuno");
        ComidaEntity result = logic.createComida(newEntity);
        Assert.assertNotNull(result);
        ComidaEntity entity = em.find(ComidaEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());
    }
    
      /**
     * Prueba para crear una Comida con tipo almuerzo
     */
    @Test
    public void createAlmuerzoTest() throws BusinessLogicException {
        ComidaEntity newEntity = factory.manufacturePojo(ComidaEntity.class);
        newEntity.setTIPO("almuerzo");
        ComidaEntity result = logic.createComida(newEntity);
        Assert.assertNotNull(result);
        ComidaEntity entity = em.find(ComidaEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());
    }
    
      /**
     * Prueba para crear una Comida con tipo cena
     */
    @Test
    public void createCenaTest() throws BusinessLogicException {
        ComidaEntity newEntity = factory.manufacturePojo(ComidaEntity.class);
        newEntity.setTIPO("cena");
        ComidaEntity result = logic.createComida(newEntity);
        Assert.assertNotNull(result);
        ComidaEntity entity = em.find(ComidaEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());
    }
    
      /**
     * Prueba para crear una Comida con tipo adicional
     */
    @Test
    public void createAdicionalTest() throws BusinessLogicException {
        ComidaEntity newEntity = factory.manufacturePojo(ComidaEntity.class);
        newEntity.setTIPO("adicional");
        ComidaEntity result = logic.createComida(newEntity);
        Assert.assertNotNull(result);
        ComidaEntity entity = em.find(ComidaEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());
    }
    /**
     * Prueba para consultar la lista de Comidas
     */
    @Test
    public void getListTest() {
        List<ComidaEntity> list = logic.getComidas();
        Assert.assertEquals( data.size(), list.size());
        for (ComidaEntity entity : list) {
            boolean found = false;
            for (ComidaEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
        
    }
    /**
     * Prueba para consultar una Comida
     */
    @Test
    public void getComidaTest() {
        ComidaEntity entity = data.get(0);
        ComidaEntity resultEntity = logic.getComida(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getName(), resultEntity.getName());
    }
    
    
    /**
     * Prueba para eliminar una Comida
     */
    @Test
    public void deleteComidaTest() throws BusinessLogicException
    {
        ComidaEntity entity = data.get(0);
        logic.delete(entity.getId());
        ComidaEntity deleted = em.find(ComidaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    /**
     * Prueba para actualizar una Comida
     */
    @Test
    public void updateComidaTest() throws BusinessLogicException 
            {
        ComidaEntity entity = data.get(0);
        ComidaEntity pojoEntity = factory.manufacturePojo(ComidaEntity.class);

        pojoEntity.setId(entity.getId());

        logic.updateComida(pojoEntity.getId(), pojoEntity);

        ComidaEntity resp = em.find(ComidaEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getName(), resp.getName());
        
    }
}

