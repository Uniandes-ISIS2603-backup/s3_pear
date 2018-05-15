/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.test.logic;

import co.edu.uniandes.csw.pear.ejb.CuentaCobroLogic;
import co.edu.uniandes.csw.pear.entities.CuentaCobroEntity;
import co.edu.uniandes.csw.pear.entities.PagoEntity;
import co.edu.uniandes.csw.pear.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.pear.persistence.CuentaCobroPersistence;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author jp.campos
 */
@RunWith(Arquillian.class)
public class CuentaCobroLogicTest {
     
    private PodamFactory factory = new PodamFactoryImpl();  
    
    @Inject
    private CuentaCobroLogic cuentaCobroLogic; 
    
    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<CuentaCobroEntity> data = new ArrayList<>();
    
    private PagoEntity pagoEntity; 
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CuentaCobroEntity.class.getPackage())
                .addPackage(CuentaCobroLogic.class.getPackage())
                .addPackage(CuentaCobroPersistence.class.getPackage())
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
        } catch (IllegalStateException | SecurityException | HeuristicMixedException | HeuristicRollbackException | NotSupportedException | RollbackException | SystemException e) {
            try {
                utx.rollback();
            } catch (IllegalStateException | SecurityException | SystemException e1) {
            }
        }
    }
    
    
    /**
     * Limpia las tablas que están implicadas en la prueba.
     *
     *
     */
    private void clearData() {
        em.createQuery("delete from CuentaCobroEntity").executeUpdate();
        em.createQuery("delete from PagoEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {

        pagoEntity = factory.manufacturePojo(PagoEntity.class);
        
        for (int i = 0; i < 3; i++) {
            CuentaCobroEntity entity = factory.manufacturePojo(CuentaCobroEntity.class);
            
            if(i == 0)
            {
                entity.setPagoEntity(pagoEntity);
            } 
            
           em.persist(entity);
           data.add(entity);
            
        }
         

    }

    /**
     * Prueba para crear uan cuenta 
     *
     */
    @Test
    public void createCuentaTest() {
        CuentaCobroEntity newEntity = factory.manufacturePojo(CuentaCobroEntity.class);
        CuentaCobroEntity result;
        try {
            result = cuentaCobroLogic.createCuenta(newEntity);
         Assert.assertNotNull(result);
        CuentaCobroEntity entity = em.find(CuentaCobroEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getValorAPagar(),entity.getValorAPagar(), 0.1 );
        Assert.assertEquals(newEntity.getCantidadProductos(),entity.getCantidadProductos());
        Assert.assertEquals(newEntity.getNumeroFacturaDeVenta(), entity.getNumeroFacturaDeVenta());
        Assert.assertEquals(newEntity.getDieta(), entity.getDieta()); 
        Assert.assertEquals(newEntity.getPagoEntity(),entity.getPagoEntity());
        
        } catch (BusinessLogicException ex) {
            Logger.getLogger(CuentaCobroLogicTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
    }

    /**
     * Prueba para consultar la lista de las cuentas
     *
     *
     */
    @Test
    public void getCuentasTest() {
        List<CuentaCobroEntity> list = cuentaCobroLogic.getCuentas();
        Assert.assertEquals(data.size(), list.size());
        for (CuentaCobroEntity entity : list) {
            boolean found = false;
            for (CuentaCobroEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    @Test
    public void getPagoTest()
    {
        Assert.assertEquals(pagoEntity, cuentaCobroLogic.getPago(data.get(0).getId()));
    }
    
    @Test
    public void addPagoTest()
    {
        CuentaCobroEntity cuenta = data.get(1); 
        
        PagoEntity pago =  cuentaCobroLogic.addPago(cuenta.getId(), pagoEntity); 
        
        Assert.assertEquals(pago, pagoEntity);
    }
    

    
    /**
     * Prueba para consultar una cuenta
     *
     */
    @Test
    public void getCuentaTest() {
        CuentaCobroEntity entity = data.get(0);
        CuentaCobroEntity resultEntity = cuentaCobroLogic.getCuenta(entity.getId());
        Assert.assertNotNull(resultEntity); 
    }

    /**
     * Prueba para eliminar una cuenta
     *
     *
     */
    @Test
    public void deleteCuentaCobroTest() {
        CuentaCobroEntity entity = data.get(0);
        cuentaCobroLogic.delete(entity.getId());
        CuentaCobroEntity deleted = em.find(CuentaCobroEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar una cuenta
     *
     *
     */
    @Test
    public void updateCuentaoTest() {
        CuentaCobroEntity entity = data.get(0);
        CuentaCobroEntity pojoEntity = factory.manufacturePojo(CuentaCobroEntity.class);

        pojoEntity.setId(entity.getId());

        cuentaCobroLogic.updateCuenta( pojoEntity);

        CuentaCobroEntity resp = em.find(CuentaCobroEntity.class, entity.getId());
        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getName(), resp.getName());
       
    }
    
    
    
}
