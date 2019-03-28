package spring.services;


import java.util.List;

import spring.model.Provincia;


public interface I_Services_REST {
	
	List<Provincia> findAll();
	
	/** ALTA NUEVA PROVINCIA */
	Provincia save(Provincia provincia);
	
	/** BAJA PROVINCIA */
	Provincia deleteById(int idProvincia);
	
	/** MODIFICAR PROVINCIA */
	Provincia update(Provincia provincia);

	Provincia findById(int id);


}
