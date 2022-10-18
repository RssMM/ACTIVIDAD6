package projecte1.Objectes;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Value;

@Entity
public class Alumnos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nom;
	private String cognoms;
    private String clase;
	private Date dataNaixement;
	private String email;
	
	public Alumnos() {}

	public Alumnos(String nom, String cognoms, String clase, LocalDate dataNaixement) {
		super();
		this.nom = nom;
		this.cognoms = cognoms;
		this.clase = clase;
		this.dataNaixement =  Date.valueOf(dataNaixement);
		this.email = AssignEmail(nom, cognoms);
	}
	
    public Alumnos(String nom, String cognoms, String clase, LocalDate dataNaixement, String email) {
		super();
		this.nom = nom;
		this.cognoms = cognoms;
		this.clase = clase;
		this.dataNaixement = Date.valueOf(dataNaixement);
		this.email = email;
	}
    public String AssignEmail(String nombre, String apellido){
		String SName = (nombre.length() < apellido.length()) ? nombre.toLowerCase() : apellido.toLowerCase();
		String LName = (nombre.length() < apellido.length()) ? apellido.toLowerCase() : nombre.toLowerCase();
		String Email = LName.toCharArray()[0] + SName + "@jaumebalmes.net";
		return Email;
    }
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCognoms() {
		return cognoms;
	}

	public void setCognoms(String cognoms) {
		this.cognoms = cognoms;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public Date getDataNaixement() {
		return dataNaixement;
	}

	public void setDataNaixement(LocalDate dataNaixement) {
		this.dataNaixement = Date.valueOf(dataNaixement);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(clase, cognoms, dataNaixement, email, nom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumnos other = (Alumnos) obj;
		return Objects.equals(clase, other.clase) && Objects.equals(cognoms, other.cognoms)
				&& Objects.equals(dataNaixement, other.dataNaixement) && Objects.equals(email, other.email)
				&& Objects.equals(nom, other.nom);
	}
	
}