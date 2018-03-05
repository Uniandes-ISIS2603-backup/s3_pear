/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.test.logic;

import co.edu.uniandes.csw.pear.ejb.EnvioLogic;
import co.edu.uniandes.csw.pear.entities.EnvioEntity;
import co.edu.uniandes.csw.pear.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.pear.persistence.EnvioPersistence;
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
public class EnvioLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();
          
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private UserTransaction utx;
    
    private List<EnvioEntity> data = new ArrayList<EnvioEntity>();
      
    @Inject 
    private EnvioLogic logic;
    
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(EnvioEntity.class.getPackage())
                .addPackage(EnvioLogic.class.getPackage())
                .addPackage(EnvioPersistence.class.getPackage())
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
            EnvioEntity entity = factory.manufacturePojo(EnvioEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear un Envio
     */
    @Test
    public void createTest() throws BusinessLogicException {
        EnvioEntity newEntity = factory.manufacturePojo(EnvioEntity.class);
        EnvioEntity result = logic.createEnvio(newEntity);
        Assert.assertNotNull(result);
        EnvioEntity entity = em.find(EnvioEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());
    }
    
    /**
     * Prueba para consultar la lista de Envios
     */
    @Test
    public void getListTest() {
        List<EnvioEntity> list = logic.getEnvios();
        Assert.assertEquals( data.size(), list.size());
        for (EnvioEntity entity : list) {
            boolean found = false;
            for (EnvioEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
        
    }
    /**
     * Prueba para consultar un Envio
     */
    @Test
    public void getComidaTest() {
        EnvioEntity entity = data.get(0);
        EnvioEntity resultEntity = logic.getEnvio(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getName(), resultEntity.getName());
    }
    
    
    /**
     * Prueba para eliminar un Envio
     */
    @Test
    public void deleteComidaTest() throws BusinessLogicException
    {
        EnvioEntity entity = data.get(0);
        logic.delete(entity.getId());
        EnvioEntity deleted = em.find(EnvioEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    /**
     * Prueba para actualizar un Envio
     */
    @Test
    public void updateComidaTest() throws BusinessLogicException 
            {
        EnvioEntity entity = data.get(0);
        EnvioEntity pojoEntity = factory.manufacturePojo(EnvioEntity.class);

        pojoEntity.setId(entity.getId());

        logic.updateEnvio(pojoEntity.getId(), pojoEntity);

        EnvioEntity resp = em.find(EnvioEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getName(), resp.getName());
        
    }
    
}
