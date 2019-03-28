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

import spring.model.Persona;
import spring.services.Persona_Services_Impl_REST;

@RestController
@RequestMapping("/PersonaRest")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PersonaController_REST {

	private static final Logger logger = LogManager.getLogger("Mensaje");

	@Autowired
	private Persona_Services_Impl_REST P_service_R;
	
	/** ---- BORRAR PERSONA POR ID ---- */
	@DeleteMapping(path = {"/{id}"})
	public Persona borrar(@PathVariable("id") int id) {
		logger.info("------Controller_Rest, en método Borrar");
		return P_service_R.deleteById(id);
	}
	
	/** ---- ACTUALIZAR PERSONA ---- */
	@PutMapping(path = { "/{id}" })
	public Persona update(@PathVariable("id") int id, @RequestBody Persona per) {
		logger.info("------Controller_Rest, en método Actualizar");
		per.setIdpersona(id); 
		return P_service_R.update(per);
	}

	/** ----- LISTA PERSONA -----*/
	@GetMapping
	public List<Persona> buscarTodas(){
		logger.info("------Controller_Rest, en método Mostrar Lista");
		return P_service_R.findAll();
	}
	
	/** ---- ALTA NUEVA PERSONA ---- */
	@PostMapping
	public Persona guardar(@RequestBody Persona per) {
		logger.info("------Controller_Rest, en método Alta Provincia");
		return P_service_R.save(per);
	}
	
}