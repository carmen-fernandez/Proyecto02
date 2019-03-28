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

import spring.model.Provincia;
import spring.services.Services_Impl;

@Controller
public class ProvinciaController {

	private static final Logger logger = LogManager.getLogger("Mensaje");

	@Autowired
	private Services_Impl service;
	
	
	@GetMapping("/")
    public ModelAndView menuPrincipal() {
        ModelAndView model = new ModelAndView("Menu");
        return model;
    }

	
	/** ---- LISTA DE PROVINCIAS ---- */
	
	/** Método que muestra el MENÚ con la LISTA DE PROVINCIAS y las opciones
	  	disponibles */
	
	@GetMapping("/Provincia")
	public ModelAndView listaProvincia() {
		System.out.println("---Controller: ListaProvincia. Entrando");
		List<Provincia> listaProvincias = service.findAll();
		ModelAndView model = new ModelAndView("ListaProvincias");
		model.addObject("listaProvincias", listaProvincias);
		logger.info("Se recoge el listado de Provincias para mostrar");
		return model;
	}

	
	/** ---- ALTA NUEVA PROVINCIA ---- */
	
	/** Método que que llama al FORMULARIO DE ALTA para introducir los datos 
	  	de la nueva provincia */
	
	@GetMapping("/Provincia/form1")
	public ModelAndView formularioAlta() {
		ModelAndView model = new ModelAndView("AltaProvincia");
		model.addObject("provi", new Provincia());
		System.out.println(model);
		return model;
	}
	
	/** Método para GUARDAR la provincia, con los datos del formulario anterior  */
	
	@PostMapping("/Provincia/save")
	public String altaProvincia(@ModelAttribute("form") Provincia provincia) {
		logger.info("--- Control: Dentro de salvar");
		service.save(provincia);
		logger.info("--- Control: antes de terminarAltaProvincia");
		return "redirect:/Provincia";
	}

	
	/** ---- BORRAR PROVINCIA ---- */
	
	/** Método para BORRAR una provincia, recogiendo el id de la provincia en el
	  	menú principal */
	
	@GetMapping("/Provincia/delete/{idprovincia}")
	public String borrarProvincia(@PathVariable("idprovincia") int idprovincia, Model model) {
		logger.info("El valor del idProvincia que llega al Controlador para BORRAR: " + idprovincia);
		service.deleteById(idprovincia);
		return "redirect:/Provincia";
	}

	
	/** ---- MODIFICAR PROVINCIA ---- */
	
	/** Método para acceder al CUESTIONARIO DE MODIFICACIÓN, recogiendo el id de la provincia en
	    el menú principal*/
	
	@GetMapping("Provincia/modificar")
	public String modificarProvincia(ModelMap model, @RequestParam("idprovincia") int idprovincia) {
		logger.info("El valor del idProvincia que llega al Controlador para MODIFICAR: " + idprovincia);
		model.addAttribute("prov", service.findById(idprovincia));
		logger.info("Provincia a modificar en el controlador: " + idprovincia);
		return "ModificarProvincia";		
	}
	
	/** Método para MODIFICAR la provincia, con los datos recogidos en el formulario anterior  */
	
	@PostMapping("/Provincia/mod")
	public ModelAndView guardarModific(@ModelAttribute ("form2") Provincia prov) {
		logger.info("--- Control: Dentro de modificar");
		service.save(prov);
		logger.info("El valor guardado de la provincia es: " + prov);
		return new ModelAndView ("redirect:/Provincia");
	}
	
	

}
