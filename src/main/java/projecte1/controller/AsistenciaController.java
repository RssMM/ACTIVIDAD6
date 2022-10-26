package projecte1.controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import projecte1.Objectes.Alumnos;



@RestController
public class AsistenciaController {
	
	HashMap<String, HashMap<Integer, HashMap<Alumnos, HashMap<LocalTime, String>>>> asistente1 = new HashMap<String, HashMap<Integer, HashMap<Alumnos, HashMap<LocalTime, String>>>>();
	
	@Autowired
	AlumnoController c;
	@Autowired
	HorarioController h;
	@Autowired
	CursoController cur;
	
	
	
	
	
	
	@GetMapping("api/alumnos/{id}/asistencia")
	public HashMap<String, HashMap<Integer, HashMap<Alumnos, HashMap<LocalTime, String>>>> setAsistenciaAlumno(@PathVariable(required = true, name = "id") int id,
			@RequestParam("aula") int aula,
			@RequestParam("time") String ms, 
			@RequestParam("day") int day,
			@RequestParam("estat") String status) {
		
		
		h.setHorarioList();
		c.setClientList();
		cur.setCursoList();
		ms = (ms.equalsIgnoreCase("now")) ? LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")).toString() : LocalTime.parse(ms).toString();
		status = (status.equals("entrada")) ? "entrada" : (status.equals("sortida")) ? "sortida" : null;
		for(int i = 0; i < cur.getCursos().size() ; i++) {
			if(asistente1.get(cur.getCursos().get(i).getAula()) == null ) {
				 
				asistente1.put(cur.getCursos().get(i).getAula(), new HashMap<Integer, HashMap<Alumnos, HashMap<LocalTime, String>>>());
				if (asistente1.get(cur.getCursos().get(i).getAula()).isEmpty()) { 
					asistente1.get(cur.getCursos().get(i).getAula()).remove(aula);
					};
			}
			if(cur.getCursos().get(i).getGrup().equalsIgnoreCase(c.alumnos.get(id).getGrup())) {
				if(asistente1.get(cur.getCursos().get(i).getAula()).get(day) == null) {
					asistente1.get(cur.getCursos().get(i).getAula()).put(day, new HashMap<Alumnos, HashMap<LocalTime, String>>());
				}
				if(asistente1.get(cur.getCursos().get(i).getAula()).get(day).get(c.alumnos.get(id)) == null) {
					asistente1.get(cur.getCursos().get(i).getAula()).get(day).put(c.alumnos.get(id), new HashMap<LocalTime, String>());
				}
				if(asistente1.get(cur.getCursos().get(i).getAula()).get(day).get(c.alumnos.get(id)).get(LocalTime.parse(ms)) == null) {
					asistente1.get(cur.getCursos().get(i).getAula()).get(day).get(c.alumnos.get(id)).put(LocalTime.parse(ms), status);
				}
				
			}
		}
		
		return asistente1;
	}
	
}
