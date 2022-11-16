package projecte1.Objectes;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Students {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String lastName;
	private String firstName;
	private Date Birth_Date;
	private boolean wantsNewsLetter;
	
	@ManyToMany
	@JoinTable(
			  name = "course_students", 
			  joinColumns = @JoinColumn(name = "ID"), 
			  inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))		
	List<Course> cursos;
	
	public Students() {}

	public Students(String lastName, String firstName, Date Birth_Date, boolean wantsNewsLetter) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.Birth_Date = Birth_Date;
		this.wantsNewsLetter = wantsNewsLetter;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getBirthDate() {
		return Birth_Date;
	}

	public void setBirthDate(Date birthDate) {
		this.Birth_Date = birthDate;
	}

	public boolean isWantsNewsLetter() {
		return wantsNewsLetter;
	}

	public void setWantsNewsLetter(boolean wantsNewsLetter) {
		this.wantsNewsLetter = wantsNewsLetter;
	}

	public List<Course> getCursos() {
		return cursos;
	}

	public void setCursos(List<Course> cursos) {
		this.cursos = cursos;
	}
	
	
	
}