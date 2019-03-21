package spring.services;


import spring.model.Provincia;


public interface I_Services {
	
	/** ALTA NUEVA PROVINCIA */
	Provincia create(Provincia provincia);
	
	/** BAJA PROVINCIA */
	Provincia deleteById(int idProvincia);
	
	/** MODIFICAR PROVINCIA */
	Provincia update (Provincia provincia);
	
	/** MOSTRAR PROVINCIA */
	Provincia findById (int idProvincia);

}
