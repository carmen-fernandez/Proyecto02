package spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

 /** Entidad para asociar tabla provincia con la clase provincia */
@Entity
@Table(name = "provincia")
public class Provincia {
	
	private static final Logger logger = LogManager.getLogger("Mensaje");
	
	@Id
	@Column(name = "idprovincia")
	private int idprovincia;
	
	@Column(name = "provincia")
	private String provincia;
	
	
	public Provincia () {}
	
	public Provincia (String provincia) {
		this.provincia = provincia;
	}
	
	public Provincia (int idprovincia, String provincia) {
		this.idprovincia = idprovincia;
		this.provincia = provincia;
	}

	
	public int getIdprovincia() {
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

	@Override
	public String toString() {
		logger.info("Convierte los datos a String para ser mostrados correctamente");
		return "Provincia [idprovincia=" + idprovincia + ", provincia=" + provincia + "]";
	}

}
