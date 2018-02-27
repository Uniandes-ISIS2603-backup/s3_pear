/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.test.logic;

import co.edu.uniandes.csw.pear.ejb.CocinaLogic;
import co.edu.uniandes.csw.pear.entities.CocinaEntity;
import co.edu.uniandes.csw.pear.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.pear.persistence.CocinaPersistence;
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
 * @author sebastian
 */
@RunWith(Arquillian.class)
public class CocinaLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();
          
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private UserTransaction utx;
    
    private List<CocinaEntity> data = new ArrayList<CocinaEntity>();
      
    @Inject 
    private CocinaLogic logic;
    
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CocinaEntity.class.getPackage())
                .addPackage(CocinaLogic.class.getPackage())
                .addPackage(CocinaPersistence.class.getPackage())
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
        em.createQuery("delete from CocinaEntity").executeUpdate();
    }
    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            CocinaEntity entity = factory.manufacturePojo(CocinaEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
    
    /**
     * Prueba para crear una Cocinas
     */
    @Test
    public void createTest() throws BusinessLogicException {
        CocinaEntity newEntity = factory.manufacturePojo(CocinaEntity.class);
        CocinaEntity result = logic.createCocina(newEntity);
        Assert.assertNotNull(result);
        CocinaEntity entity = em.find(CocinaEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());
    }
    
    /**
     * Prueba para consultar la lista de Cocinas
     */
    @Test
    public void getListTest() {
        List<CocinaEntity> list = logic.getCocinas();
        Assert.assertEquals( data.size(), list.size());
        for (CocinaEntity entity : list) {
            boolean found = false;
            for (CocinaEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    
    /**
     * Prueba para consultar una Cocina
     */
    @Test
    public void getBookTest() {
        CocinaEntity entity = data.get(0);
        CocinaEntity resultEntity = logic.getCocina(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getName(), resultEntity.getName());
    }
    
    
    /**
     * Prueba para eliminar una Cocina
     */
    @Test
    public void deleteBookTest() {
        CocinaEntity entity = data.get(0);
        logic.delete(entity.getId());
        CocinaEntity deleted = em.find(CocinaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    /**
     * Prueba para actualizar una Cocina
     */
    @Test
    public void updateBookTest() throws BusinessLogicException {
        CocinaEntity entity = data.get(0);
        CocinaEntity pojoEntity = factory.manufacturePojo(CocinaEntity.class);

        pojoEntity.setId(entity.getId());

        logic.updateCocina(pojoEntity.getId(), pojoEntity);

        CocinaEntity resp = em.find(CocinaEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getName(), resp.getName());
        
    }
    
}
