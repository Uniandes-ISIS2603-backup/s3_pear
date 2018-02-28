/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.test.persistence;

import co.edu.uniandes.csw.pear.entities.CasoExitoEntity;
import co.edu.uniandes.csw.pear.entities.PersonaEntity;
import co.edu.uniandes.csw.pear.persistence.CasoExitoPersistence;
import co.edu.uniandes.csw.pear.persistence.PersonaPersistence;
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
public class PersonaPersistenceTest {
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PersonaEntity.class.getPackage())
                .addPackage(PersonaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private PersonaPersistence personaPersistence;
    
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
        em.createQuery("delete from PersonaEntity").executeUpdate();
    }
    
    
    private List<PersonaEntity> data = new ArrayList<PersonaEntity>();
    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            PersonaEntity entity = factory.manufacturePojo(PersonaEntity.class);
            
            em.persist(entity);
            data.add(entity);
        }
    }
    
    /**
     * Prueba para crear una Persona.
     */
    @Test
    public void createPersonaTest() {
        PodamFactory factory = new PodamFactoryImpl();
        PersonaEntity newEntity = factory.manufacturePojo(PersonaEntity.class);
        PersonaEntity result = personaPersistence.create(newEntity);

        Assert.assertNotNull(result);

        PersonaEntity entity = em.find(PersonaEntity.class, result.getId());

        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
        Assert.assertEquals(newEntity.getApellido(), entity.getApellido());
        Assert.assertEquals(newEntity.getEdad(), entity.getEdad());
        Assert.assertEquals(newEntity.getDireccion(),entity.getDireccion());
        Assert.assertEquals(newEntity.getCorreo(),entity.getCorreo());
        Assert.assertEquals(newEntity.isSubscrito(),entity.isSubscrito());
        Assert.assertEquals(newEntity.getIdentificacion(),entity.getIdentificacion());
        Assert.assertEquals(newEntity.getCalificacion(),entity.getCalificacion());
        Assert.assertEquals(newEntity.getDieta(),entity.getDieta());        
    }
    
    /**
     * Prueba para consultar la lista de Personas.
     */
    @Test
    public void getPersonasTest() {
        List<PersonaEntity> list = personaPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (PersonaEntity ent : list) {
            boolean found = false;
            for (PersonaEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    /**
     * Prueba para consultar una Persona.
     */
    @Test
    public void getPersonaTest() {
        PersonaEntity entity = data.get(0);
        PersonaEntity newEntity = personaPersistence.find(entity.getId());
        
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
        Assert.assertEquals(newEntity.getApellido(), entity.getApellido());
        Assert.assertEquals(newEntity.getEdad(), entity.getEdad());
        Assert.assertEquals(newEntity.getDireccion(),entity.getDireccion());
        Assert.assertEquals(newEntity.getCorreo(),entity.getCorreo());
        Assert.assertEquals(newEntity.isSubscrito(),entity.isSubscrito());
        Assert.assertEquals(newEntity.getIdentificacion(),entity.getIdentificacion());
        Assert.assertEquals(newEntity.getCalificacion(),entity.getCalificacion());
        Assert.assertEquals(newEntity.getDieta(),entity.getDieta());
        
    }
    
    /**
     * Prueba para eliminar una Persona.
     */
    @Test
    public void deletePersonaTest() {
        PersonaEntity entity = data.get(0);
        personaPersistence.delete(entity.getId());
        PersonaEntity deleted = em.find(PersonaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    /**
     * Prueba para actualizar una Persona.
     */
    @Test
    public void updatePersonaTest() {
        PersonaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        PersonaEntity newEntity = factory.manufacturePojo(PersonaEntity.class);

        newEntity.setId(entity.getId());

        personaPersistence.update(newEntity);

        PersonaEntity resp = em.find(PersonaEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getNombre(), resp.getNombre());
        Assert.assertEquals(newEntity.getApellido(), resp.getApellido());
        Assert.assertEquals(newEntity.getEdad(), resp.getEdad());
        Assert.assertEquals(newEntity.getDireccion(),resp.getDireccion());
        Assert.assertEquals(newEntity.getCorreo(),resp.getCorreo());
        Assert.assertEquals(newEntity.isSubscrito(),resp.isSubscrito());
        Assert.assertEquals(newEntity.getIdentificacion(),resp.getIdentificacion());
        //Assert.assertEquals(newEntity.getCalificacion(),resp.getCalificacion());
        //Assert.assertEquals(newEntity.getDieta(),resp.getDieta());
    }
    
}
