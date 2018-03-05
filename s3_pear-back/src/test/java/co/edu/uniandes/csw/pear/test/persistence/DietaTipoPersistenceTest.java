/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.test.persistence;

import co.edu.uniandes.csw.pear.entities.DietaTipoEntity;
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
 * Clase Test Dieta Persistence
 * @author js.garcial1
 */
@RunWith(Arquillian.class)
public class DietaTipoPersistenceTest {
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
                .addPackage(DietaTipoEntity.class.getPackage())
                .addPackage(DietaTipoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Inyección de la dependencia a la clase DietaTipoPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private DietaTipoPersistence persistence;

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
        em.createQuery("delete from DietaTipoEntity").executeUpdate();
    }

    /**
     *
     */
    private List<DietaTipoEntity> data = new ArrayList<>();

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            DietaTipoEntity entity = factory.manufacturePojo(DietaTipoEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear una Dieta.
     *
     *
     */
    @Test
    public void createDietaTest() {
        PodamFactory factory = new PodamFactoryImpl();
        DietaTipoEntity newEntity = factory.manufacturePojo(DietaTipoEntity.class);
        DietaTipoEntity result = persistence.create(newEntity);

        Assert.assertNotNull(result);

        DietaTipoEntity entity = em.find(DietaTipoEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
    }

    /**
     * Prueba para consultar la lista de Dietas.
     *
     *
     */
    @Test
    public void getDietasTest() {
        List<DietaTipoEntity> list = persistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (DietaTipoEntity ent : list) {
            boolean found = false;
            for (DietaTipoEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar una Dieta.
     *
     *
     */
    @Test
    public void getDietaTest() {
        DietaTipoEntity entity = data.get(0);
        DietaTipoEntity newEntity = persistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
    }

    /**
     * Prueba para eliminar una Dieta.
     *
     *
     */
    @Test
    public void deleteDietaTest() {
        DietaTipoEntity entity = data.get(0);
        persistence.delete(entity.getId());
        DietaTipoEntity deleted = em.find(DietaTipoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar una Dieta.
     *
     *
     */
    @Test
    public void updateDietaTest() {
        DietaTipoEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        DietaTipoEntity newEntity = factory.manufacturePojo(DietaTipoEntity.class);

        newEntity.setId(entity.getId());

        persistence.update(newEntity);

        DietaTipoEntity resp = em.find(DietaTipoEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
    }
}
