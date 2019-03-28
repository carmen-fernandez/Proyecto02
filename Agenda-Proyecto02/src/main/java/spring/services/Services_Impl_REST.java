package spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.dao.I_DAO_Provincia;
import spring.model.Provincia;

@Service
public class Services_Impl_REST implements I_Services_REST{
	
	private static final Logger logger = LogManager.getLogger("Mensaje");
	
	@Autowired
	private I_DAO_Provincia repository;
	
	
	/** Método para mostrar todas las provincias */
	public List <Provincia> findAll() {
		return repository.findAll();
	}
	
	
	/** Método para dar de alta una nueva provincia*/
	@Override
	public Provincia save(Provincia provincia) {
		logger.info("Se guarda la provincia en la base de datos");
		return repository.save(provincia);
	}


	/** Método para eliminar una provincia*/
	@Override
	public Provincia deleteById(int idprovincia) {
		logger.info("Si se encuetra el id, borra el campo en la base de datos");
		Provincia p = findById(idprovincia);
		logger.info("El idProvincia en Services es: " + idprovincia);
		logger.info("Provincia: "+p);
		
		if (p != null) {
			logger.info("---- borrando");
			repository.delete(p);
		}else {
			logger.warn("---- Id de provincia no encontrada");
		}
		return p;
	}

	
	/** Método para modificar una provincia*/
	@Override
	public Provincia update(Provincia p) {
		return repository.save(p);
	}



	@Override
	public Provincia findById(int id) {
		return repository.findById(id).orElse(null);
	}

}