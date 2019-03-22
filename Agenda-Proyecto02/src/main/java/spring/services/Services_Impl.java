package spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.dao.I_DAO_Provincia;
import spring.model.Provincia;

@Service
public class Services_Impl implements I_Services{
	
	private static final Logger logger = LogManager.getLogger("Mensaje");
	
	@Autowired
	private I_DAO_Provincia repository;
	
	
	/** Método para mostrar todas las provincias */
	public List <Provincia> findAll() {
		return repository.findAll();
	}

	
	/** Método para dar de alta una nueva provincia*/
	@Override
	public Provincia create(Provincia provincia) {
		logger.info("Se guarda la provincia en la base de datos");
		return repository.save(provincia);
	}

	
	/** Método para eliminar una provincia*/
	@Override
	public Provincia deleteById(int idProvincia) {
		logger.info("Si se encuetra el id, borra el campo en la base de datos");
		Provincia provincia = findById(idProvincia);
		
		if (provincia != null) {
			repository.delete(provincia);
		}
		return provincia;
	}
	
	
	/** Método para modificar una provincia */
	@Override
	public Provincia update(int idProvincia1) {
		logger.info("Modifica el nombre de la provincia");
		Provincia provincia = findById(idProvincia1);
		if (provincia != null) {
			repository.save(provincia);
		}
		return provincia;
	}


	@Override
	public Provincia findById(int idProvincia) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/** Método para mostrar provincia */

	/*public Provincia findById(int idProvincia) {
		logger.info("Se muestra la provincia si se encuentra el id");
		return repository.findById(idProvincia).orElse(null);
	}*/
	
	
}
