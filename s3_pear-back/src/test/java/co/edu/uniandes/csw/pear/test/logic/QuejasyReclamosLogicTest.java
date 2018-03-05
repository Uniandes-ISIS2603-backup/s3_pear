/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.pear.test.logic;
import co.edu.uniandes.csw.pear.ejb.QuejasyReclamosLogic;
import co.edu.uniandes.csw.pear.entities.QuejasyReclamosEntity;
import co.edu.uniandes.csw.pear.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.pear.persistence.QuejasyReclamosPersistence;
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
 * @author ga.bejarano10
 */
@RunWith(Arquillian.class)
public class QuejasyReclamosLogicTest {
    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private QuejasyReclamosLogic quejasLogic;
    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;
    
     private List<QuejasyReclamosEntity> data = new ArrayList<QuejasyReclamosEntity>();
     
     
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(QuejasyReclamosEntity.class.getPackage())
                .addPackage(QuejasyReclamosLogic.class.getPackage())
                .addPackage(QuejasyReclamosPersistence.class.getPackage())
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
        em.createQuery("delete from QuejasyReclamosEntity").executeUpdate();
    }
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {

        for (int i = 0; i < 3; i++) {
            QuejasyReclamosEntity entity = factory.manufacturePojo(QuejasyReclamosEntity.class);
            entity.setAsunto("queja");
            em.persist(entity);
            data.add(entity);
         
        }

    }
     /**
     * Prueba para crear una queja y reclamo
     *
     *
     */
    @Test
    public void createQuejayReclamoTest() throws BusinessLogicException {
        QuejasyReclamosEntity newEntity = factory.manufacturePojo(QuejasyReclamosEntity.class);
        newEntity.setAsunto("queja");
        QuejasyReclamosEntity result = quejasLogic.createQuejasyReclamos(newEntity);
        Assert.assertNotNull(result);
        QuejasyReclamosEntity entity = em.find(QuejasyReclamosEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getAsunto(), entity.getAsunto());
        Assert.assertEquals(newEntity.getComentario(), entity.getComentario());
    }
    /**
     * Prueba para consultar la lista de quejas y reclamos
     *
     *
     */
    @Test
    public void getQuejasyReclamosTest() {
        List<QuejasyReclamosEntity> list = quejasLogic.getQuejasyReclamos();
        Assert.assertEquals(data.size(), list.size());
        for (QuejasyReclamosEntity entity : list) {
            boolean found = false;
            for (QuejasyReclamosEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    /**
     * Prueba para consultar una queja y reclamo
     *
     *
     */
    @Test
    public void getQuejayReclamoTest() {
        QuejasyReclamosEntity entity = data.get(0);
        QuejasyReclamosEntity resultEntity = quejasLogic.getQuejayReclamo(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(resultEntity.getAsunto(), entity.getAsunto());
        Assert.assertEquals(resultEntity.getComentario(), entity.getComentario());
        
    }
     /**
     * Prueba para eliminar una queja y reclamo
     *
     *
     */
    @Test
    public void deleteQuejayReclamoTest() throws BusinessLogicException {
        QuejasyReclamosEntity entity = data.get(0);
        quejasLogic.deleteQuejayReclamo(entity);
        QuejasyReclamosEntity deleted = em.find(QuejasyReclamosEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    /**
     * Prueba para actualizar una queja y reclamo
     *
     *
     */
    @Test
    public void updateQuejayReclamoTest() throws BusinessLogicException {
        QuejasyReclamosEntity entity = data.get(0);
        QuejasyReclamosEntity pojoEntity = factory.manufacturePojo(QuejasyReclamosEntity.class);

        pojoEntity.setId(entity.getId());

        quejasLogic.updateQuejayReclamo(pojoEntity);

        QuejasyReclamosEntity resp = em.find(QuejasyReclamosEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getAsunto(), resp.getAsunto());
        Assert.assertEquals(pojoEntity.getComentario(), resp.getComentario());
    }
    
}
