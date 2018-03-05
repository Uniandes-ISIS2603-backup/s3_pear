/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.test.logic;

import co.edu.uniandes.csw.pear.ejb.PersonaLogic;
import co.edu.uniandes.csw.pear.entities.PersonaEntity;
import co.edu.uniandes.csw.pear.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.pear.persistence.PersonaPersistence;
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
 * @author pa.suarezm
 */
@RunWith(Arquillian.class)
public class PersonaLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private UserTransaction utx;
    
    private List<PersonaEntity> data = new ArrayList<PersonaEntity>();
      
    @Inject 
    private PersonaLogic logic;
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PersonaEntity.class.getPackage())
                .addPackage(PersonaLogic.class.getPackage())
                .addPackage(PersonaPersistence.class.getPackage())
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
        em.createQuery("delete from PersonaEntity").executeUpdate();
    }
    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            PersonaEntity entity = factory.manufacturePojo(PersonaEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
    
    /**
     * Prueba para crear una Persona
     * @throws BusinessLogicException
     */
    @Test
    public void createTest() throws BusinessLogicException {
        PersonaEntity newEntity = factory.manufacturePojo(PersonaEntity.class);
        PersonaEntity result = logic.createPersona(newEntity);
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
     * Prueba para consultar la lista de Personas
     */
    @Test
    public void getListTest() {
        List<PersonaEntity> list = logic.getPersonas();
        Assert.assertEquals( data.size(), list.size());
        for (PersonaEntity entity : list) {
            boolean found = false;
            for (PersonaEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    /**
     * Prueba para consultar una Persona
     */
    @Test
    public void getPersonaTest() {
        PersonaEntity entity = data.get(0);
        PersonaEntity resultEntity = logic.getPersona(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(resultEntity.getNombre(), entity.getNombre());
        Assert.assertEquals(resultEntity.getApellido(), entity.getApellido());
        Assert.assertEquals(resultEntity.getEdad(), entity.getEdad());
        Assert.assertEquals(resultEntity.getDireccion(),entity.getDireccion());
        Assert.assertEquals(resultEntity.getCorreo(),entity.getCorreo());
        Assert.assertEquals(resultEntity.isSubscrito(),entity.isSubscrito());
        Assert.assertEquals(resultEntity.getIdentificacion(),entity.getIdentificacion());
        Assert.assertEquals(resultEntity.getCalificacion(),entity.getCalificacion());
        Assert.assertEquals(resultEntity.getDieta(),entity.getDieta());  
    }
    
    /**
     * Prueba para eliminar una Persona
     */
    @Test
    public void deletePersonaTest(){
        PersonaEntity entity = data.get(0);
        logic.deletePersona(entity.getId());
        PersonaEntity deleted = em.find(PersonaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    /**
     * Prueba para actualizar una Persona
     */
    @Test
    public void updateBookTest() throws BusinessLogicException{
        PersonaEntity entity = data.get(0);
        PersonaEntity pojoEntity = factory.manufacturePojo(PersonaEntity.class);

        pojoEntity.setId(entity.getId());

        logic.updatePersona(pojoEntity);

        PersonaEntity resp = em.find(PersonaEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getNombre(), resp.getNombre());
        Assert.assertEquals(pojoEntity.getApellido(), resp.getApellido());
        Assert.assertEquals(pojoEntity.getEdad(), resp.getEdad());
        Assert.assertEquals(pojoEntity.getDireccion(),resp.getDireccion());
        Assert.assertEquals(pojoEntity.getCorreo(),resp.getCorreo());
        Assert.assertEquals(pojoEntity.isSubscrito(),resp.isSubscrito());
        Assert.assertEquals(pojoEntity.getIdentificacion(),resp.getIdentificacion());
        Assert.assertEquals(pojoEntity.getCalificacion(),resp.getCalificacion());
        Assert.assertEquals(pojoEntity.getDieta(),resp.getDieta());  
    }
    
}
