package project1.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import projecte1.Objectes.Cursos;

@Repository
public interface CursosRepo extends CrudRepository<Cursos, Long>{
	
	public List<Cursos> findAll();
	
	@Query(value = "select count(c.id) = 1 from Cursos c where lower(c.grup) like lower(:grup)", nativeQuery = true)
	boolean existsByGrup(@Param("grup") String grup);
	
	@Transactional
	@Modifying  
	@Query(value = "DELETE from Cursos c where lower(c.grup) = lower(:grup)", nativeQuery = true )
	int deleteByGrup(@Param("grup") String grup);
}
