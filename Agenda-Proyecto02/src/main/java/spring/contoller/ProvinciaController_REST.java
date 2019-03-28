package spring.contoller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.model.Provincia;
import spring.services.Services_Impl_REST;

@RestController
@RequestMapping("/ProvinciaRest")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProvinciaController_REST {

	private static final Logger logger = LogManager.getLogger("Mensaje");

	@Autowired
	private Services_Impl_REST service_R;
	
	/** ---- BORRAR POR ID ---- */
	@DeleteMapping(path = {"/{id}"})
	public Provincia borrar(@PathVariable("id") int id) {
		logger.info("------Controller_Rest, en método Borrar");
		return service_R.deleteById(id);
	}
	
	/** ---- ACTUALIZAR PROVINCIA ---- */
	@PutMapping(path = { "/{id}" })
	public Provincia update(@PathVariable("id") int id, @RequestBody Provincia p) {
		logger.info("------Controller_Rest, en método Actualizar");
		p.setIdprovincia(id); 
		return service_R.update(p);
	}

	/** ----- LISTA PROVINCIAS -----*/
	@GetMapping
	public List<Provincia> buscarTodas(){
		logger.info("------Controller_Rest, en método Mostrar Lista");
		return service_R.findAll();
	}
	
	/** ---- ALTA NUEVA PROVINCIA ---- */
	@PostMapping
	public Provincia guardar(@RequestBody Provincia p) {
		logger.info("------Controller_Rest, en método Alta Provincia");
		return service_R.save(p);
	}
	
}