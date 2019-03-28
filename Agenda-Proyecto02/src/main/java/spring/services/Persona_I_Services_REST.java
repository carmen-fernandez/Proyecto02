package spring.services;


import java.util.List;

import spring.model.Persona;


public interface Persona_I_Services_REST {
	
	List<Persona> findAll();
	
	/** ALTA NUEVA PROVINCIA */
	Persona save(Persona persona);
	
	/** BAJA PROVINCIA */
	Persona deleteById(int idPersona);
	
	/** MODIFICAR PROVINCIA */
	Persona update(Persona persona);

	Persona findById(int id);


}
