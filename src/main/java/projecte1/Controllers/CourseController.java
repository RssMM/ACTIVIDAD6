package projecte1.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import project1.Repositories.CursosRepo;
import projecte1.Objectes.Course;



@RestController
public class CourseController {
ArrayList<Course> cursos;
	
	@Autowired    
	CursosRepo cursoRep; 
	
	public void setCursoList() {
		cursos = (ArrayList<Course>) cursoRep.findAll();
		
	}
	
	@GetMapping("api/cursos")
	public List<Course> getCursos() {
		setCursoList();
		return cursos;
	}
	@GetMapping("api/cursos/{id}")
	public Course getClient(@PathVariable(required = true, name = "id") int id) {
		setCursoList();
		return cursos.get(id);
	}
}
