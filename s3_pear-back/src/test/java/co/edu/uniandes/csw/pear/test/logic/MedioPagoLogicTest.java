/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.test.logic;

import co.edu.uniandes.csw.pear.ejb.MedioPagoLogic;
import co.edu.uniandes.csw.pear.entities.MedioPagoEntity;
import co.edu.uniandes.csw.pear.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.pear.persistence.MedioPagoPersistence;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author jp.campos
 */
@RunWith(Arquillian.class)
public class MedioPagoLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();  
    
    @Inject
    private MedioPagoLogic medioPagoLogic; 
    
    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<MedioPagoEntity> data = new ArrayList<MedioPagoEntity>();
    
      @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(MedioPagoEntity.class.getPackage())
                .addPackage(MedioPagoLogic.class.getPackage())
                .addPackage(MedioPagoPersistence.class.getPackage())
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
        em.createQuery("delete from MedioPagoEntity").executeUpdate();
      //  em.createQuery("delete from PersonaEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {

        for (int i = 0; i < 3; i++) {
            MedioPagoEntity entity = factory.manufacturePojo(MedioPagoEntity.class);
            em.persist(entity);
            data.add(entity);
         
        }

    }

    /**
     * Prueba para crear un medio de  Pago
     *
     *
     */
    @Test
    public void createMedioPagoTest() {
        MedioPagoEntity newEntity = factory.manufacturePojo(MedioPagoEntity.class);
        MedioPagoEntity result;
        try {
            result = medioPagoLogic.createMedioPago(newEntity);
         Assert.assertNotNull(result);
        MedioPagoEntity entity = em.find(MedioPagoEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getMedioActual(),entity.getMedioActual() );
        Assert.assertEquals(newEntity.getPersonas(), entity.getPersonas());
        
        } catch (BusinessLogicException ex) {
            Logger.getLogger(PagoLogicTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
    }

    /**
     * Prueba para consultar la lista de medios de pago
     *
     *
     */
    @Test
    public void getMedioPagosTest() {
        List<MedioPagoEntity> list = medioPagoLogic.getMediosPago();
        Assert.assertEquals(data.size(), list.size());
        for (MedioPagoEntity entity : list) {
            boolean found = false;
            for (MedioPagoEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un medio de pago
     *
     *
     */
    @Test
    public void getMedioPagoTest() {
        MedioPagoEntity entity = data.get(0);
        MedioPagoEntity resultEntity = medioPagoLogic.getMedioPago(entity.getId());
        Assert.assertNotNull(resultEntity);
        
        
      
    }

    /**
     * Prueba para eliminar un medio de pago
     *
     *
     */
    @Test
    public void deleteMedioPagoTest() {
        MedioPagoEntity entity = data.get(0);
        medioPagoLogic.delete(entity.getId());
        MedioPagoEntity deleted = em.find(MedioPagoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un medio de pago
     *
     *
     */
    @Test
    public void updateMedioPagoTest() {
        MedioPagoEntity entity = data.get(0);
        MedioPagoEntity pojoEntity = factory.manufacturePojo(MedioPagoEntity.class);

        pojoEntity.setId(entity.getId());

        medioPagoLogic.updatePago(pojoEntity.getId(), pojoEntity);

        MedioPagoEntity resp = em.find(MedioPagoEntity.class, entity.getId());
        resp = em.find(MedioPagoEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getName(), resp.getName());
       
    }
    
    
}
