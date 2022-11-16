package projecte1.Objectes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String title;
	
	@OneToMany(mappedBy = "course",fetch = FetchType.LAZY)
	private List<CourseMaterial> courseMaterial;
	
	@ManyToMany(mappedBy = "cursos")
	@JsonIgnore
	private List<Students> students;
	 
	
	public Course() {
		
	}

	public Course(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	public List<CourseMaterial> getCourseMaterial() {
		return courseMaterial;
	}

	public List<Students> getStudents() {
		return students;
	}

	public void setStudents(List<Students> students) {
		this.students = students;
	}

	public void setCourseMaterial(List<CourseMaterial> courseMaterial) {
		this.courseMaterial = courseMaterial;
	}
	
	public void removeCourseMarerial(CourseMaterial material) {
		courseMaterial.remove(material);
		material.setCourse(null);
	}
	
	
	
}
