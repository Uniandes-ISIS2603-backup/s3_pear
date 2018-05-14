/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.test.persistence;

import co.edu.uniandes.csw.pear.entities.CocinaEntity;
import co.edu.uniandes.csw.pear.entities.DietaTipoEntity;
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
 * Clase Test Cocina Persistence
 * @author js.garcial1
 */
@RunWith(Arquillian.class)
public class CocinaPersistenceTest {
    
    
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
                .addPackage(CocinaEntity.class.getPackage())
                .addPackage(CocinaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Inyección de la dependencia a la clase CocinaPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private CocinaPersistence persistence;

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
        em.createQuery("delete from CocinaEntity").executeUpdate();
    }

    /**
     *
     */
    private List<CocinaEntity> data = new ArrayList<>();

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            CocinaEntity entity = factory.manufacturePojo(CocinaEntity.class);
            DietaTipoEntity dietaEntity = factory.manufacturePojo(DietaTipoEntity.class); 
            ArrayList <DietaTipoEntity> dietas = new ArrayList<>(); 
            dietas.add(dietaEntity);
            entity.setDietas(dietas);
            
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear una Cocina.
     *
     *
     */
    @Test
    public void createCocinaTest() {
        PodamFactory factory = new PodamFactoryImpl();
        CocinaEntity newEntity = factory.manufacturePojo(CocinaEntity.class);
        CocinaEntity result = persistence.create(newEntity);

        Assert.assertNotNull(result);

        CocinaEntity entity = em.find(CocinaEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
    }

    /**
     * Prueba para consultar la lista de Cocinas.
     *
     *
     */
    @Test
    public void getCocinasTest() {
        List<CocinaEntity> list = persistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (CocinaEntity ent : list) {
            boolean found = false;
            for (CocinaEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar una Cocina.
     *
     *
     */
    @Test
    public void getCocinaTest() {
        CocinaEntity entity = data.get(0);
        CocinaEntity newEntity = persistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
    }


    /**
     * Prueba para eliminar una Cocina.
     *
     *
     */
    @Test
    public void deleteCocinaTest() {
        CocinaEntity entity = data.get(0);
        persistence.delete(entity.getId());
        CocinaEntity deleted = em.find(CocinaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar una Cocina.
     *
     *
     */
    @Test
    public void updateCocinaTest() {
        CocinaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        CocinaEntity newEntity = factory.manufacturePojo(CocinaEntity.class);

        newEntity.setId(entity.getId());

        persistence.update(newEntity);

        CocinaEntity resp = em.find(CocinaEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
    }
    
    
}
