package project1.repo;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projecte1.Objectes.Alumnos;

@Repository
public interface AlumnosRepo extends CrudRepository<Alumnos, Long>{
	
	public List<Alumnos> findAll();
}