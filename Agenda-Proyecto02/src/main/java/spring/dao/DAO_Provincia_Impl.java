package spring.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;


/**	Clase que genera el repositorio */

//Añadir el interfaz
@Repository
public class DAO_Provincia_Impl implements I_DAO_Provincia {
	
	private static final Logger logger = LogManager.getLogger("Mensaje");
	
	/** Unidad de persistencia*/
	@PersistenceContext
	private EntityManager entityManager;
	
	public DAO_Provincia_Impl () {}
	
	

	
	
	
	
	
}
