/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.test.logic;

import co.edu.uniandes.csw.pear.ejb.DietaTipoLogic;
import co.edu.uniandes.csw.pear.entities.DietaTipoEntity;
import co.edu.uniandes.csw.pear.entities.SemanaEntity;
import co.edu.uniandes.csw.pear.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.pear.persistence.DietaTipoPersistence;
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
 * Test de logica
 * @author sebastian
 */
@RunWith(Arquillian.class)
public class DietaTipoLogicTest {
    
    
    private PodamFactory factory = new PodamFactoryImpl();
      
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private UserTransaction utx;
    
    private List<DietaTipoEntity> data = new ArrayList<>();
          
    @Inject
    private DietaTipoLogic logic;
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(DietaTipoEntity.class.getPackage())
                .addPackage(DietaTipoLogic.class.getPackage())
                .addPackage(DietaTipoPersistence.class.getPackage())
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
        em.createQuery("delete from DietaTipoEntity").executeUpdate();
    }
    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            DietaTipoEntity entity = factory.manufacturePojo(DietaTipoEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
    
    /**
     * Prueba para crear una Dieta
     */
    @Test
    public void createTest() throws BusinessLogicException {
        DietaTipoEntity newEntity = factory.manufacturePojo(DietaTipoEntity.class);
        DietaTipoEntity result = logic.createDieta(newEntity);
        Assert.assertNotNull(result);
        DietaTipoEntity entity = em.find(DietaTipoEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getObjetivo(), entity.getObjetivo());
   
        
    
    }
    
    /**
     * Prueba para consultar la lista de Dietas
     */
    @Test
    public void getListTest() {
        List<DietaTipoEntity> list = logic.getDietas();
        Assert.assertEquals( data.size(), list.size());
        for (DietaTipoEntity entity : list) {
            boolean found = false;
            for (DietaTipoEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    
    /**
     * Prueba para consultar una Dieta
     */
    @Test
    public void getDietaTest() {
        DietaTipoEntity entity = data.get(0);
        DietaTipoEntity resultEntity = logic.getDieta(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getName(), resultEntity.getName());
    }
    
    
 
    
    /**
     * Prueba para eliminar una Dieta
     */
    @Test
    public void deleteDietaTest() {
        DietaTipoEntity entity = data.get(0);
        logic.deleteDieta(entity.getId());
        DietaTipoEntity deleted = em.find(DietaTipoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    /**
     * Prueba para actualizar una Dieta
     */
    @Test
    public void updateDietaTest() throws BusinessLogicException {
        DietaTipoEntity entity = data.get(0);
        DietaTipoEntity pojoEntity = factory.manufacturePojo(DietaTipoEntity.class);

        pojoEntity.setId(entity.getId());

        logic.updateDieta(pojoEntity.getId(), pojoEntity);

        DietaTipoEntity resp = em.find(DietaTipoEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getName(), resp.getName());
        
    }
    
    
}
