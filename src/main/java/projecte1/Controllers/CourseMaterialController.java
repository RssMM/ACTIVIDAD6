package projecte1.Controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import project1.Repositories.CursoMaterialRepo;
import projecte1.Objectes.CourseMaterial;


@RestController
public class CourseMaterialController {
ArrayList<CourseMaterial> cursos;
	
	@Autowired    
	CursoMaterialRepo cursoMaterialRep; 
	
	public void setCursoMaterialList() {
		cursos = (ArrayList<CourseMaterial>) cursoMaterialRep.findAll();
		
	}
	
	@GetMapping("api/cm")
	public List<CourseMaterial> getCursos() {
		setCursoMaterialList();
		return cursos;
	}
}
