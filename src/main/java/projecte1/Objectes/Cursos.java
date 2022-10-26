package projecte1.Objectes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Cursos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String cicle;
	private String curs;
	private String grup;
	private String aula;
	
	public Cursos() {}
	
	public Cursos(String cicle, String curs, String grup, String aula) {
		this.cicle = cicle;
		this.curs = curs;
		this.grup = grup;
		this.aula = aula;
		
	}

	public String getCicle() {
		return cicle;
	}
	
	public void setCicle(String cicle) {
		this.cicle = cicle;
	}

	public String getGrup() {
		return grup;
	}
	public void setGrup(String grup) {
		this.grup = grup;
	}
	public String getCurs() {
		return curs;
	}

	public void setCurs(String curs) {
		this.curs = curs;
	}

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}
		
}
