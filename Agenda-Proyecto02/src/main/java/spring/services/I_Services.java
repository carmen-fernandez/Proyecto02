package spring.services;


import java.util.List;

import spring.model.Provincia;


public interface I_Services {
	
	List<Provincia> findAll();
	
	/** ALTA NUEVA PROVINCIA */
	Provincia create(Provincia provincia);
	
	/** BAJA PROVINCIA */
	Provincia deleteById(int idProvincia);
	
	/** MODIFICAR PROVINCIA */
	Provincia update (Provincia provincia);
	
	/** MOSTRAR PROVINCIA */
	Provincia findById (int idProvincia);

}
