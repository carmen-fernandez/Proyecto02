package spring.services;


import java.util.List;

import spring.model.Persona;


public interface Persona_I_Services {
	
	List<Persona> findAll();
	
	/** ALTA NUEVA PERSONA */
	void save(Persona persona);
	
	/** BAJA PERSONA */
	Persona deleteById(int idPersona);
	
	/** MODIFICAR PERSONA */
	Persona update (int idPersona);
	
	/** ENCONTRAR LA PERSONA DADO UN ID */
	Persona findById (int idPersona);

}
