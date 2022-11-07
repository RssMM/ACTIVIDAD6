package projecte1.Controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import project1.Repositories.CursoMaterialRepo;
import projecte1.Objectes.CourseMaterial;


@RestController
public class CourseMaterialController {
ArrayList<CourseMaterial> cursosMaterial;
	
	@Autowired    
	CursoMaterialRepo cursoMaterialRep; 
	
	public void setCursoMaterialList() {
		cursosMaterial = (ArrayList<CourseMaterial>) cursoMaterialRep.findAll();
		
	}
	
	@GetMapping("api/cursomaterial")
	public List<CourseMaterial> getCursos() {
		setCursoMaterialList();
		return cursosMaterial;
	}
	@GetMapping("api/cursomaterial/{id}")
	public CourseMaterial getClient(@PathVariable(required = true, name = "id") int id) {
		setCursoMaterialList();
		return cursosMaterial.get(id);
	}
}
