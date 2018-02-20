
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.test.persistence;


import co.edu.uniandes.csw.pear.entities.CuentaCobroEntity;
import co.edu.uniandes.csw.pear.persistence.CuentaCobroPersistence;
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
 * @author jp.campos
 */

@RunWith(Arquillian.class)
public class CuentaCobroPersistenceTest {
    
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
                .addPackage(CuentaCobroEntity.class.getPackage())
                .addPackage(CuentaCobroEntity.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Inyección de la dependencia a la clase  CuentaCobroPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private CuentaCobroPersistence cuentaCobroPersistence;

    /**
     * Contexto de Persistencia que se va a utilizar para acceder a la Base de
     * datos por fuera de los métodos que se están probando.
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * Variable para marcar las transacciones del em anterior cuando se
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
        em.createQuery("delete from CuentaCobroEntity").executeUpdate();
    }

    /**
     *
     */
    private List<CuentaCobroEntity> data = new ArrayList<CuentaCobroEntity>();

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            CuentaCobroEntity entity = factory.manufacturePojo(CuentaCobroEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear una cuenta de cobro.
     *
     *
     */
    @Test
    public void createCuentaCobroTest() {
        PodamFactory factory = new PodamFactoryImpl();
        CuentaCobroEntity newEntity = factory.manufacturePojo(CuentaCobroEntity.class);
        CuentaCobroEntity result = cuentaCobroPersistence.create(newEntity);

        Assert.assertNotNull(result);

        CuentaCobroEntity entity = em.find(CuentaCobroEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
    }

    /**
     * Prueba para consultar la lista de las cuentas de cobro.
     *
     *
     */
    @Test
    public void getCuentasCobroTest() {
        List<CuentaCobroEntity> list = cuentaCobroPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (CuentaCobroEntity ent : list) {
            boolean found = false;
            for (CuentaCobroEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar una cuenta de cobro.
     *
     *
     */
    @Test
    public void getCuentaCobroTest() {
        CuentaCobroEntity entity = data.get(0);
        CuentaCobroEntity newEntity = cuentaCobroPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
    }

    /**
     * Prueba para eliminar una cuenta de cobro.
     *
     *
     */
    @Test
    public void deleteCuentaCobroTest() {
        CuentaCobroEntity entity = data.get(0);
        cuentaCobroPersistence.delete(entity.getId());
        CuentaCobroEntity deleted = em.find(CuentaCobroEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar una cuenta de cobro .
     *
     *
     */
    @Test
    public void updateCuentaCobroTest() {
        CuentaCobroEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        CuentaCobroEntity newEntity = factory.manufacturePojo(CuentaCobroEntity.class);

        newEntity.setId(entity.getId());

        cuentaCobroPersistence.update(newEntity);

        CuentaCobroEntity resp = em.find(CuentaCobroEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
    }
}
