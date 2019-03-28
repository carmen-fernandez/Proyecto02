package spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.dao.I_DAO_Persona;
import spring.model.Persona;

@Service
public class Persona_Services_Impl implements Persona_I_Services{
	
	private static final Logger logger = LogManager.getLogger("Mensaje");
	
	@Autowired
	private I_DAO_Persona repositoryP;
	
	
	/** Método para mostrar todas las personas */
	public List <Persona> findAll() {
		return repositoryP.findAll();
	}
	
	
	/** Método para dar de alta una nueva persona*/
	@Override
	public void save(Persona persona) {
		logger.info("Se guarda la persona en la base de datos");
		repositoryP.save(persona);
	}

	
	/** Método para eliminar una persona*/
	@Override
	public Persona deleteById(int idpersona) {
		logger.info("Si se encuetra el id, borra el campo en la base de datos");
		Persona pers = findById(idpersona);
		logger.info("El idPersona en Services es: " + idpersona);
		logger.info("Persona: " + pers);
		
		if (pers != null) {
			logger.info("---- borrando");
			repositoryP.delete(pers);
		}
		return pers;
	}
	

	
	/** Método para modificar una persona */
	@Override
	public Persona update(int idPersona) {
		logger.info("Modifica el nombre de la persona");
		Persona persona = findById(idPersona);
		
		if (persona != null) {
			repositoryP.save(persona);
		}
		return persona;
	}

	
	/** Método para encontrar una Persona, dado un id */
	@Override
	public Persona findById(int idPersona) {
		logger.info("Se muestra la persona si se encuentra el id");
		return repositoryP.findById(idPersona).orElse(null);
	}
	
}
