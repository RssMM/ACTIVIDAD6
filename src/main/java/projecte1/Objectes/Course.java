package projecte1.Objectes;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String title;
	
	@OneToMany(mappedBy = "course")
	private List<CourseMaterial> courseMaterial;
	
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

	public void setCourseMaterial(List<CourseMaterial> courseMaterial) {
		this.courseMaterial = courseMaterial;
	}
	
	
	
}
