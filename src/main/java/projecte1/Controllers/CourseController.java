package projecte1.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project1.Repositories.CursoMaterialRepo;
import project1.Repositories.CursosRepo;
import projecte1.Objectes.Course;



@RestController
public class CourseController {
ArrayList<Course> cursos;
	
	@Autowired    
	CursosRepo cursoRep; 
	@Autowired    
	CursoMaterialRepo cursoMaterialRep; 
	
	public void setCursoList() {
		cursos = (ArrayList<Course>) cursoRep.findAll();
		
	}
	
	@GetMapping("api/cursos")
	public List<Course> getCursos() {
		setCursoList();
		return cursos;
	}
	@GetMapping("api/cursos/{id}")
	public Optional<Course> getCurso(@PathVariable(required = true, name = "id") int id) {
		setCursoList();
		Optional<Course> curso = cursoRep.findById((long) id);
		System.out.println("EAGER o LAZY");
		return  curso;
		
	}
	@DeleteMapping("api/cursos/{id}/delete")
    public ResponseEntity<String> deleteCurso(@PathVariable int id) {
        if (cursoRep.existsById((long) id)) {

        	
        	if(!cursoRep.findById((long) id).get().getCourseMaterial().isEmpty()) {
        		int size = cursoRep.findById((long) id).get().getCourseMaterial().size();
	        	for(int j = 0; j < size; j++ ) {
	        		int r = (int) cursoRep.findById((long) id).get().getCourseMaterial().get(j).getId();
	        		cursoMaterialRep.findAll().get(r).setCourse(null);
	        	}
	        	
        	}
        	cursoRep.findById((long) id).get().setCourseMaterial(null);
            cursoRep.deleteById((long) id);
        	return new ResponseEntity<>("Deleted course " + id, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
