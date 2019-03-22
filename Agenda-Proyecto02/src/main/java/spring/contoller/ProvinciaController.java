package spring.contoller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring.model.Provincia;
import spring.services.Services_Impl;


@Controller
public class ProvinciaController {

	private static final Logger logger = LogManager.getLogger("ProvinciaController");
	
	
	@Autowired
	private Services_Impl service;
	
	
	
	@GetMapping ("/")
	public ModelAndView lista() {
		System.out.println("----- He entrado a la primera pagina");
		List<Provincia> listaProvincias = service.findAll();
		ModelAndView model = new ModelAndView("ListaProvincias");
		model.addObject("listaProvincias", listaProvincias);
		logger.info("Se recoge el listado de Provincias para mostrar");
		System.out.println("Listado Provincias");
		return model;
	}
	
	
}

