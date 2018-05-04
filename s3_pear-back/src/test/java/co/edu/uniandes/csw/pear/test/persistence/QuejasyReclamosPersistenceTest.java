/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.test.persistence;

/**
 *
 * @author ga.bejarano10
 */
import co.edu.uniandes.csw.pear.entities.DietaTipoEntity;
import co.edu.uniandes.csw.pear.entities.QuejasyReclamosEntity;
import co.edu.uniandes.csw.pear.persistence.QuejasyReclamosPersistence;
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
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 */
@RunWith(Arquillian.class)
public class QuejasyReclamosPersistenceTest 
{
    /**
     *
     * @return Devuelve el jar que Arquillian va a desplegar en el Glassfish
     * embebido. El jar contiene las clases de Employee, el descriptor de la
     * base de datos y el archivo benas.xml para resolver la inyección de
     * dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(QuejasyReclamosEntity.class.getPackage())
                .addPackage(QuejasyReclamosPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    /**
     * Inyección de la dependencia a la clase CalificacionPersistence cuyos métodos
     * se van a probar.
     */
    @Inject
    private QuejasyReclamosPersistence quejasyreclamosPersistence;

    /**
     * Contexto de Persistencia que se va autilizar para acceder a la Base de
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
        em.createQuery("delete from QuejasyReclamosEntity").executeUpdate();
        em.createQuery("delete from DietaTipoEntity").executeUpdate();
    }
    /**
     *
     */
    private List<QuejasyReclamosEntity> data = new ArrayList<QuejasyReclamosEntity>();
    
    private List<DietaTipoEntity> dataDieta = new ArrayList<DietaTipoEntity>();

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
            dataDieta.add(entity);
        }
        for (int i = 0; i < 3; i++) {
            QuejasyReclamosEntity entity = factory.manufacturePojo(QuejasyReclamosEntity.class);
            if (i == 0) {
                entity.setDieta(dataDieta.get(0));
            }
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear una calificacion.
     *
     *
     */
    @Test
    public void createQuejasyReclamosTest() {
        PodamFactory factory = new PodamFactoryImpl();
        QuejasyReclamosEntity newEntity = factory.manufacturePojo(QuejasyReclamosEntity.class);
        QuejasyReclamosEntity result = quejasyreclamosPersistence.create(newEntity);

        Assert.assertNotNull(result);

        QuejasyReclamosEntity entity = em.find(QuejasyReclamosEntity.class, result.getId());

        Assert.assertEquals(newEntity.getAsunto(), entity.getAsunto());
        Assert.assertEquals(newEntity.getComentario(), entity.getComentario());
       
    }
    /**
     * Prueba para consultar la lista de quejas y empleados.
     *
     *
     */
    @Test
    public void getQuejasyReclamosTest() {
        List<QuejasyReclamosEntity> list = quejasyreclamosPersistence.findAll(dataDieta.get(1).getId());
        Assert.assertEquals(data.size(), list.size());
        for (QuejasyReclamosEntity ent : list) {
            boolean found = false;
            for (QuejasyReclamosEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    /**
     * Prueba para consultar una queja.
     *
     * 
     */
    @Test
    public void getQuejayReclamoTest() {
        QuejasyReclamosEntity entity = data.get(0);
        QuejasyReclamosEntity newEntity = quejasyreclamosPersistence.find(dataDieta.get(0).getId(), entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getAsunto(), newEntity.getAsunto());
        Assert.assertEquals(entity.getComentario(), newEntity.getComentario());
    }
    /**
     * Prueba para eliminar una queja.
     *
     *
     */
    @Test
    public void deleteQuejayReclamoTest() {
        QuejasyReclamosEntity entity = data.get(0);
        quejasyreclamosPersistence.delete(entity.getId());
        QuejasyReclamosEntity deleted = em.find(QuejasyReclamosEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    /**
     * Prueba para actualizar una queja.
     *
     *
     */
    @Test
    public void updateQuejasyReclamoTest() {
        QuejasyReclamosEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        QuejasyReclamosEntity newEntity = factory.manufacturePojo(QuejasyReclamosEntity.class);

        newEntity.setId(entity.getId());

        quejasyreclamosPersistence.update(newEntity);

      QuejasyReclamosEntity resp = em.find(QuejasyReclamosEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getAsunto(), resp.getAsunto());
        
    }
    
}
