package spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

 /** Entidad para asociar tabla provincia con la clase provincia */
@Entity
@Table(name = "provincia")
public class Provincia {
	
	private static final Logger logger = LogManager.getLogger("Mensaje");
	
	private int idprovincia;
	private String provincia;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idprovincia")
	public int getIdprovincia() {
		logger.info ("Obtener provincia");
		return idprovincia;
	}
	public void setIdprovincia(int idprovincia) {
		this.idprovincia = idprovincia;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	
	


}
