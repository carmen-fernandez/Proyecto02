package spring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import junit.framework.TestCase;
import spring.dao.I_DAO_Provincia;
import spring.model.Provincia;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests  extends TestCase{
    
    /*
     * Dato que se pasara en una prueba unitaria
     *  */
    private String dato1 = "prueba" ;
    /*
     * Id a pasar para borrar un elemento
     * */
    private int id = 43;
    
    /*
     * Definimos un objeto de clase provincia
     * */
    @Autowired
    I_DAO_Provincia autentiaDAO;
    

    
    private static Logger logger;

    static {
        try {
            logger = LogManager.getLogger(DemoApplication.class);
        } catch (Throwable e) {
            System.out.println("Don't work");
        }
    }
    
    /*
     *Test
     * */
    
    
    /*
     * Probando que no existe una provincia dentro de la base de datos
     * */
    @Test
    public void testAdd() {
        Provincia p = new Provincia();
        logger.info("Test::testAdd(): Comprobar que no existe dentro de la base de datos");
        assertEquals(dato1,p.getProvincia());
    }
        
    /*
     * Probamos que se puede borrar,
     * pero en la base de datos no se vera,
     * por que hace un roller back y es como si no lo hubiera borrado
     * */
    @Test
    @Transactional
    public void testDelete1() {
        logger.info("Test::testDelete1(): Comprobar que se puede borrar");
        autentiaDAO.deleteById(id);
        assertTrue(autentiaDAO.findAll().size() == 51);
    }
    
    /*
     *  Probando que tiene datos la Base de datos para poder mostrar
     * */
    @Test
    public void testMostrar() {
        Provincia p = new Provincia();
        logger.info("Test::testAdd(): Comprobar que tiene datos para mostrar");
        assertNotNull(p.getIdprovincia());
    }
}