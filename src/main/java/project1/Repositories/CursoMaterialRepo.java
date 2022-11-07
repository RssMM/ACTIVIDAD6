package project1.Repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projecte1.Objectes.CourseMaterial;



@Repository
public interface CursoMaterialRepo extends CrudRepository<CourseMaterial, Long>{
	
	public List<CourseMaterial> findAll();
}