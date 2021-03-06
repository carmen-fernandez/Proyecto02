package spring.services;


import java.util.List;

import spring.model.Provincia;


public interface I_Services {
	
	List<Provincia> findAll();
	
	/** ALTA NUEVA PROVINCIA */
	void save(Provincia provincia);
	
	/** BAJA PROVINCIA */
	Provincia deleteById(int idProvincia);
	
	/** MODIFICAR PROVINCIA */
	Provincia update (int idProvincia);
	
	/** ENCONTRAR LA PROVINCIA DADO UN ID */
	Provincia findById (int idProvincia);

}
