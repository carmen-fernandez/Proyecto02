package spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.dao.I_DAO_Persona;
import spring.model.Persona;

@Service
public class Persona_Services_Impl_REST implements Persona_I_Services_REST{
	
	private static final Logger logger = LogManager.getLogger("Mensaje");
	
	@Autowired
	private I_DAO_Persona repositoryP;
	
	
	/** Método para mostrar todas las persona */
	public List <Persona> findAll() {
		return repositoryP.findAll();
	}
	
	
	/** Método para dar de alta una nueva persona*/
	@Override
	public Persona save(Persona persona) {
		logger.info("Se guarda la provincia en la base de datos");
		return repositoryP.save(persona);
	}


	/** Método para eliminar una persona*/
	@Override
	public Persona deleteById(int idpersona) {
		logger.info("Si se encuetra el id, borra el campo en la base de datos");
		Persona per = findById(idpersona);
		logger.info("El idPersona en Services es: " + idpersona);
		logger.info("Persona: "+per);
		
		if (per != null) {
			logger.info("---- borrando");
			repositoryP.delete(per);
		}else {
			logger.warn("---- Id de persona no encontrada");
		}
		return per;
	}

	
	/** Método para modificar una persona*/
	@Override
	public Persona update(Persona per) {
		return repositoryP.save(per);
	}


	/** Método de buscar persona por id */
	@Override
	public Persona findById(int id) {
		return repositoryP.findById(id).orElse(null);
	}

}