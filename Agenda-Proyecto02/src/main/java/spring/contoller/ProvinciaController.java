package spring.contoller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.model.Provincia;
import spring.services.Services_Impl;


@Controller
public class ProvinciaController {

	private static final Logger logger = LogManager.getLogger("ProvinciaController");
	
	
	@Autowired
	private Services_Impl service;
	
	
	
	@GetMapping ("/")
	public ModelAndView listaProvincia() {
		List<Provincia> listaProvincias = service.findAll();
		ModelAndView model = new ModelAndView("ListaProvincias");
		model.addObject("listaProvincias", listaProvincias);
		logger.info("Se recoge el listado de Provincias para mostrar");
		return model;
	}
	
	@GetMapping ("/insertarProvincia")
	public ModelAndView insertarProvincia() {
		Provincia p = new Provincia();
		ModelAndView model = new ModelAndView("CrearProvincia");
		model.addObject("crearProvincia", service.create(p));
		logger.info("Se recoge el nombre de Provincias para añadirlo");
		return model;
	}
	
	@GetMapping ("/insertarProvincia")
	public ModelAndView modificarProvincia(int id) {
		Provincia p = service.update(id);
		ModelAndView model = new ModelAndView("ModificarProvincia");
		model.addObject("modificarProvincia", p); 
		logger.info("Se recoge el nombre de Provincias para editarlo");
		return model;
	}
	
	@GetMapping ("/")
	public ModelAndView borrarProvincia(int id2) {
		Provincia p = service.deleteById(id2);
		ModelAndView model = new ModelAndView("ListaProvincias");
		model.addObject("listaProvincias", p);
		logger.info("Se recoge el listado de Provincias para mostrar");
		return model;
	}
}

