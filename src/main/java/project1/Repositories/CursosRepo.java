package project1.Repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projecte1.Objectes.Course;
@Repository
public interface CursosRepo extends CrudRepository<Course, Long>{
	
	public List<Course> findAll();
}