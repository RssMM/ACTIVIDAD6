package projecte1.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import project1.Repositories.CursosRepo;
import project1.Repositories.StudentsRepo;
import projecte1.Objectes.Course;
import projecte1.Objectes.Students;



@RestController
public class StudentsController {
	ArrayList<Students> students;
	
	@Autowired    
	StudentsRepo studentsRep; 
	
	public void setCursoList() {
		students = (ArrayList<Students>) studentsRep.findAll();
		
	}
	
	@GetMapping("api/students")
	public List<Students> getCursos() {
		setCursoList();
		return students;
	}
	@GetMapping("api/students/{id}")
	public Students getClient(@PathVariable(required = true, name = "id") int id) {
		setCursoList();
		return students.get(id);
	}
}