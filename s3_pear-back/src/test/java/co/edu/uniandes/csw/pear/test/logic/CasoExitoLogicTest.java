/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.test.logic;

import co.edu.uniandes.csw.pear.ejb.CasoExitoLogic;
import co.edu.uniandes.csw.pear.entities.CasoExitoEntity;
import co.edu.uniandes.csw.pear.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.pear.persistence.CasoExitoPersistence;
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
 * @author pa.suarezm
 */
@RunWith(Arquillian.class)
public class CasoExitoLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private UserTransaction utx;
    
    private List<CasoExitoEntity> data = new ArrayList<CasoExitoEntity>();
      
    @Inject 
    private CasoExitoLogic logic;
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CasoExitoEntity.class.getPackage())
                .addPackage(CasoExitoLogic.class.getPackage())
                .addPackage(CasoExitoPersistence.class.getPackage())
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
        em.createQuery("delete from CasoExitoEntity").executeUpdate();
    }
    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            CasoExitoEntity entity = factory.manufacturePojo(CasoExitoEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
    
    /**
     * Prueba para crear un Caso
     * @throws BusinessLogicException
     */
    @Test
    public void createTest() throws BusinessLogicException {
        CasoExitoEntity newEntity = factory.manufacturePojo(CasoExitoEntity.class);
        CasoExitoEntity result = logic.createCasoExito(newEntity);
        Assert.assertNotNull(result);
        CasoExitoEntity entity = em.find(CasoExitoEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getComentario(), entity.getComentario());
        Assert.assertEquals(newEntity.getTestimonio(), entity.getTestimonio());
    }
    
    /**
     * Prueba para consultar la lista de Casos
     */
    @Test
    public void getListTest() {
        List<CasoExitoEntity> list = logic.getCasosExito();
        Assert.assertEquals( data.size(), list.size());
        for (CasoExitoEntity entity : list) {
            boolean found = false;
            for (CasoExitoEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    /**
     * Prueba para consultar un Caso
     */
    @Test
    public void getCasoTest() {
        CasoExitoEntity entity = data.get(0);
        CasoExitoEntity resultEntity = logic.getCasoExito(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(resultEntity.getId(), entity.getId());
        Assert.assertEquals(resultEntity.getComentario(), entity.getComentario());
        Assert.assertEquals(resultEntity.getTestimonio(), entity.getTestimonio());
    }
    
    /**
     * Prueba para eliminar un Caso
     */
    @Test
    public void deleteCasoTest(){
        CasoExitoEntity entity = data.get(0);
        logic.deleteCasoExito(entity.getId());
        CasoExitoEntity deleted = em.find(CasoExitoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    /**
     * Prueba para actualizar un Caso
     */
    @Test
    public void updateBookTest() throws BusinessLogicException{
        CasoExitoEntity entity = data.get(0);
        CasoExitoEntity pojoEntity = factory.manufacturePojo(CasoExitoEntity.class);

        pojoEntity.setId(entity.getId());

        logic.updateCasoExito(pojoEntity);

        CasoExitoEntity resp = em.find(CasoExitoEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getComentario(), resp.getComentario());
        Assert.assertEquals(pojoEntity.getTestimonio(), resp.getTestimonio());
    }
}
