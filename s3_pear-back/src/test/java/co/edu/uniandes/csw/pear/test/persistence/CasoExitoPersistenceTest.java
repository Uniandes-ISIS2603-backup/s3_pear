/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.test.persistence;

import co.edu.uniandes.csw.pear.entities.CasoExitoEntity;
import co.edu.uniandes.csw.pear.persistence.CasoExitoPersistence;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.junit.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * @author pa.suarezm
 */
@RunWith(Arquillian.class)
public class CasoExitoPersistenceTest {
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CasoExitoEntity.class.getPackage())
                .addPackage(CasoExitoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private CasoExitoPersistence casoExitoPersistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
    
    /**
     * Configuración de la prueba
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
            em.joinTransaction();
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
    
    
    private List<CasoExitoEntity> data = new ArrayList<CasoExitoEntity>();
    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            CasoExitoEntity entity = factory.manufacturePojo(CasoExitoEntity.class);
            
            em.persist(entity);
            data.add(entity);
        }
    }
    
    /**
     * Prueba para crear un CasoExito.
     */
    @Test
    public void createCasoExitoTest() {
        PodamFactory factory = new PodamFactoryImpl();
        CasoExitoEntity newEntity = factory.manufacturePojo(CasoExitoEntity.class);
        CasoExitoEntity result = casoExitoPersistence.create(newEntity);

        Assert.assertNotNull(result);

        CasoExitoEntity entity = em.find(CasoExitoEntity.class, result.getId());

        Assert.assertEquals(newEntity.getComentario(), entity.getComentario());
        Assert.assertEquals(newEntity.getTestimonio(), entity.getTestimonio());
        Assert.assertEquals(newEntity.getDieta(), entity.getDieta());
    }
    
    /**
     * Prueba para consultar la lista de CasosExito.
     */
    @Test
    public void getCasosExitoTest() {
        List<CasoExitoEntity> list = casoExitoPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (CasoExitoEntity ent : list) {
            boolean found = false;
            for (CasoExitoEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    /**
     * Prueba para consultar un CasoExito.
     */
    @Test
    public void getCasoExitoTest() {
        CasoExitoEntity entity = data.get(0);
        CasoExitoEntity newEntity = casoExitoPersistence.find(entity.getId());
        
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(newEntity.getComentario(), entity.getComentario());
        Assert.assertEquals(newEntity.getTestimonio(), entity.getTestimonio());
        Assert.assertEquals(newEntity.getDieta(), entity.getDieta());
    }
    
    /**
     * Prueba para eliminar un CasoExito.
     */
    @Test
    public void deleteCasoExitoTest() {
        CasoExitoEntity entity = data.get(0);
        casoExitoPersistence.delete(casoExitoPersistence.find(entity.getId()));
        CasoExitoEntity deleted = em.find(CasoExitoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    /**
     * Prueba para actualizar un CasoExito.
     */
    @Test
    public void updateCasoExitoTest() {
        CasoExitoEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        CasoExitoEntity newEntity = factory.manufacturePojo(CasoExitoEntity.class);

        newEntity.setId(entity.getId());

        casoExitoPersistence.update(newEntity);

        CasoExitoEntity resp = em.find(CasoExitoEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getComentario(), resp.getComentario());
        Assert.assertEquals(newEntity.getTestimonio(), resp.getTestimonio());
        Assert.assertEquals(newEntity.getDieta(), resp.getDieta());
    }
}
