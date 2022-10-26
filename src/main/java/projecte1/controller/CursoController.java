package projecte1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import project1.repo.CursosRepo;
import projecte1.Objectes.Cursos;

@RestController
public class CursoController {
	ArrayList<Cursos> cursos;
	
	@Autowired    
	CursosRepo cursoRep; 
	
	
	
	public void setCursoList() {
		cursos = (ArrayList<Cursos>) cursoRep.findAll();
	}
	
	@GetMapping("api/cursos")
	public List<Cursos> getCursos() {
		setCursoList();
		return cursos;
	}
	@GetMapping("api/cursos/{grup}/delete")
    public ResponseEntity<String> delete(@PathVariable String grup) {

        if (cursoRep.existsByGrup(grup)) {
        	cursoRep.deleteByGrup(grup);
        	return new ResponseEntity<>(grup, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       
    }
	
}
