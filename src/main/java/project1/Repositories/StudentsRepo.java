package project1.Repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projecte1.Objectes.Students;
@Repository
public interface StudentsRepo extends CrudRepository<Students, Long>{
	
	public List<Students> findAll();
	
}