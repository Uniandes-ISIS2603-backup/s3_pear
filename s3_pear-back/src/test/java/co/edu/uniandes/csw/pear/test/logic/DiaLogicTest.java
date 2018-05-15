/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.test.logic;

import co.edu.uniandes.csw.pear.ejb.DiaLogic;
import co.edu.uniandes.csw.pear.entities.DiaEntity;
import co.edu.uniandes.csw.pear.entities.EnvioEntity;
import co.edu.uniandes.csw.pear.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.pear.persistence.DiaPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
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
   
    private List<DiaEntity> data = new ArrayList<>();
    
    private List<EnvioEntity> envios = new ArrayList<>();
    
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
        } catch (IllegalStateException | SecurityException | HeuristicMixedException | HeuristicRollbackException | NotSupportedException | RollbackException | SystemException e) {
            try {
                utx.rollback();
            } catch (IllegalStateException | SecurityException | SystemException e1) {
            }
        }
    }
    
    /**
     * Limpia las tablas que están implicadas en la prueba.
     */
    private void clearData() {
        em.createQuery("delete from DiaEntity").executeUpdate();
        em.createQuery("delete from EnvioEntity").executeUpdate(); 
    }
    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        
        EnvioEntity envioEntity = factory.manufacturePojo(EnvioEntity.class);
        envios.add(envioEntity);
        for (int i = 0; i < 3; i++) {
            DiaEntity entity = factory.manufacturePojo(DiaEntity.class);
            if(i == 0)
            {
                entity.setEnvios(envios);
            }
            
            em.persist(envioEntity); 
            em.persist(entity);
            data.add(entity);
        }
    }
    
    
    /**
     * Prueba para crear un Dia
     * @throws BusinessLogicException
     */
    @Test
    public void createDiaTest() throws BusinessLogicException {
        DiaEntity newEntity = factory.manufacturePojo(DiaEntity.class);
        DiaEntity result = logic.createDia(newEntity);
        Assert.assertNotNull(result);
        DiaEntity entity = em.find(DiaEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getFecha(), entity.getFecha());
        Assert.assertEquals(newEntity.getRecomendacion(),entity.getRecomendacion());
        Assert.assertEquals(newEntity.getSeEnvia(),entity.getSeEnvia());
        Assert.assertEquals(newEntity.getSemana(), entity.getSemana());
        Assert.assertEquals(newEntity.getEnvios(), entity.getEnvios());
        
     
        try 
        {
            logic.createDia(data.get(0)); 
        }catch( BusinessLogicException e)
        {
            Assert.assertEquals("Ya existe un dia con ese identificador", e.getMessage());
        }
        
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
     * @throws co.edu.uniandes.csw.pear.exceptions.BusinessLogicException
     */
    @Test
    public void getDiaTest() throws BusinessLogicException {
        DiaEntity entity = data.get(0);
        DiaEntity resultEntity = logic.getDia(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getName(), resultEntity.getName());
        Assert.assertEquals(entity.getFecha(), resultEntity.getFecha());
        Assert.assertEquals(entity.getRecomendacion(),resultEntity.getRecomendacion());
        Assert.assertEquals(entity.getSeEnvia(),resultEntity.getSeEnvia());
        
        try 
        {
            logic.getDia(new Long(12)); 
        }catch(BusinessLogicException e )
        {
            Assert.assertEquals("no existe un dia con ese identificador", e.getMessage()); 
        }
    }
    
    
   
 
    
    /**
     * Prueba para eliminar un Dia
     * @throws co.edu.uniandes.csw.pear.exceptions.BusinessLogicException
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
     * @throws co.edu.uniandes.csw.pear.exceptions.BusinessLogicException
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
        Assert.assertEquals(pojoEntity.getEnvios(), resp.getEnvios());  
    }
}
