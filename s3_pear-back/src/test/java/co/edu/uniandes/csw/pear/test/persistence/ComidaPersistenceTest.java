/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.test.persistence;

import co.edu.uniandes.csw.pear.entities.ComidaEntity;
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
public class ComidaPersistenceTest {
    
    
    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Employee, el descriptor de la
     * base de datos y el archivo beans.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ComidaEntity.class.getPackage())
                .addPackage(ComidaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Inyección de la dependencia a la clase ComidaPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private ComidaPersistence comidaPersistence;

    /**
     * Contexto de Persistencia que se va a utilizar para acceder a la Base de
     * datos por fuera de los métodos que se están probando.
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * Variable para martcar las transacciones del em anterior cuando se
     * crean/borran datos para las pruebas.
     */
    @Inject
    UserTransaction utx;

    /**
     * Configuración inicial de la prueba.
     *
     *
     */
    
    @Before
    public void setUp() {
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
     *
     *
     */
    private void clearData() {
        em.createQuery("delete from ComidaEntity").executeUpdate();
    }

    /**
     *
     */
    private List<ComidaEntity> data = new ArrayList<ComidaEntity>();

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            ComidaEntity entity = factory.manufacturePojo(ComidaEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear una Comida.
     *
     *
     */
    @Test
    public void createComidaTest() {
        PodamFactory factory = new PodamFactoryImpl();
        ComidaEntity newEntity = factory.manufacturePojo(ComidaEntity.class);
        ComidaEntity result = comidaPersistence.create(newEntity);

        Assert.assertNotNull(result);

        ComidaEntity entity = em.find(ComidaEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
         Assert.assertEquals(newEntity.getId(), entity.getId());
          Assert.assertEquals(newEntity.getCantidad(), entity.getCantidad());
         Assert.assertEquals(newEntity.getAlimentos(), entity.getAlimentos());
    }

    /**
     * Prueba para consultar la lista de Comidas.
     *
     *
     */
    @Test
    public void getComidasTest() {
        List<ComidaEntity> list = comidaPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (ComidaEntity ent : list) {
            boolean found = false;
            for (ComidaEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar una Comida.
     *
     *
     */
    @Test
    public void getComidaTest() {
        ComidaEntity entity = data.get(0);
        ComidaEntity newEntity = comidaPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
                 Assert.assertEquals(newEntity.getId(), entity.getId());
          Assert.assertEquals(newEntity.getCantidad(), entity.getCantidad());
         Assert.assertEquals(newEntity.getAlimentos(), entity.getAlimentos());
    }

    /**
     * Prueba para eliminar una Comida.
     *
     *
     */
    @Test
    public void deleteComidaeTest() {
        ComidaEntity entity = data.get(0);
        comidaPersistence.delete(entity.getId());
        ComidaEntity deleted = em.find(ComidaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar una Comida.
     *
     *
     */
    @Test
    public void updateComidaTest() {
        ComidaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ComidaEntity newEntity = factory.manufacturePojo(ComidaEntity.class);

        newEntity.setId(entity.getId());

        comidaPersistence.update(newEntity);

        ComidaEntity resp = em.find(ComidaEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
    }
    
}
