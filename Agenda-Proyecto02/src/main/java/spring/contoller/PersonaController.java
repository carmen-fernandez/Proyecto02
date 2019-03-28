package spring.contoller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.model.Persona;
import spring.services.Persona_Services_Impl;

@Controller
public class PersonaController {

	private static final Logger logger = LogManager.getLogger("Mensaje");

	@Autowired
	private Persona_Services_Impl serviceP;

	
	/** ---- LISTADO DE PERSONAS ---- */
	
	/** Método que muestra el MENÚ con la LISTA DE PERSONAS y las opciones
	  	disponibles */
	
	@GetMapping("/Persona")
	public ModelAndView listaPersona() {
		System.out.println("---Controller: ListaPersona. Entrando");
		List<Persona> listaPersonas = serviceP.findAll();
		ModelAndView model = new ModelAndView("ListaPersonas");
		model.addObject("listaPersonas", listaPersonas);
		logger.info("Se recoge el listado de Personas para mostrar");
		return model;
	}

	
	/** ---- ALTA NUEVA PERSONA ---- */
	
	/** Método que que llama al FORMULARIO DE ALTA para introducir los datos 
	  	de la nueva persona */
	
	@GetMapping("/Persona/form2")
	public ModelAndView formularioAlta() {
		ModelAndView model = new ModelAndView("AltaPersona");
		model.addObject("perso", new Persona());
		System.out.println(model);
		return model;
	}
	
	/** Método para GUARDAR la persona, con los datos del formulario anterior  */
	
	@PostMapping("/Persona/save2")
	public String altaPersona(@ModelAttribute("form") Persona persona) {
		logger.info("--- Control: Dentro de salvar");
		serviceP.save(persona);
		logger.info("--- Control: antes de terminarAltaPersona");
		return "redirect:/Persona";
	}

	
	/** ---- BORRAR PERSONA ---- */
	
	/** Método para BORRAR una persona, recogiendo el id de la persona en el
	  	menú principal */
	
	@GetMapping("/Persona/delete/{idpersona}")
	public String borrarPersona(@PathVariable("idpersona") int idpersona, Model model) {
		logger.info("El valor del idPersona que llega al Controlador para BORRAR: " + idpersona);
		serviceP.deleteById(idpersona);
		return "redirect:/Persona";
	}

	
	/** ---- MODIFICAR PERSONA ---- */
	
	/** Método para acceder al CUESTIONARIO DE MODIFICACIÓN, recogiendo el id de la persona en
	    el menú principal*/
	
	@GetMapping("Persona/modificar")
	public String modificarPersona(ModelMap model, @RequestParam("idpersona") int idpersona) {
		logger.info("El valor del idPersona que llega al Controlador para MODIFICAR: " + idpersona);
		model.addAttribute("pers", serviceP.findById(idpersona));
		logger.info("Persona a modificar en el controlador: " + idpersona);
		return "ModificarPersona";		
	}
	
	/** Método para MODIFICAR la persona, con los datos recogidos en el formulario anterior  */
	
	@PostMapping("/Persona/mod")
	public ModelAndView guardarModific(@ModelAttribute ("form2") Persona pers) {
		logger.info("--- Control: Dentro de modificar");
		serviceP.save(pers);
		logger.info("El valor guardado de la provincia es: " + pers);
		return new ModelAndView ("redirect:/Persona");
	}
	
}
