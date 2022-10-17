package projecte1.controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import projecte1.Objectes.Alumnos;



@RestController
public class AsistenciaController {
	AlumnoController c = new AlumnoController();
	HorarioController h = new HorarioController();
	
	
	HashMap<String,HashMap<Integer, HashMap<LocalTime,List<Alumnos>>>> asistente1 = new HashMap<String,HashMap<Integer, HashMap<LocalTime,List<Alumnos>>>>();
	
	
	
	
	@GetMapping("api/alumnos/{id}/asistencia")
	public HashMap<String, HashMap<Integer, HashMap<LocalTime, List<Alumnos>>>> setAsistenciaAlumno(@PathVariable(required = true, name = "id") int id,
			@RequestParam("day") int day,
			@RequestParam("time") String ms) {
		
		c.setClientList();
		h.setHorarioList();
		
		ms = (ms.equalsIgnoreCase("now")) ? LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")).toString() : LocalTime.parse(ms).toString() ;
		
		
		
		for(int i = 0; i < h.horarios.size() ; i++) {
			if(asistente1.get(c.alumnos.get(id).getClase()) == null) {
				asistente1.put(c.alumnos.get(id).getClase(), new HashMap<Integer, HashMap<LocalTime,List<Alumnos>>>());
			}
			
			if(c.alumnos.get(id).getClase().equalsIgnoreCase(h.horarios.get(i).getClase())) {
				for(int j = 0; j < h.horarios.get(i).getHorario().size() ; j++) {
					//clia.put(day,null);
					
					ArrayList<LocalTime> rh = h.horarios.get(i).getHorario().get(j);
					for(int k = 0; k < rh.size() ; k +=2) {
						//if(asistente1.get(c.clients.get(id).getClase()).put(day, cli))
						 if(asistente1.get(c.alumnos.get(id).getClase()).get(day) == null) {
							 	asistente1.get(c.alumnos.get(id).getClase()).put(day, new HashMap<LocalTime,List<Alumnos>>());
						 }
						
						if(day - 1== j && LocalTime.parse(ms).isAfter(rh.get(k)) && LocalTime.parse(ms).isBefore(rh.get(k).plusMinutes(30))) {
							 if(asistente1.get(c.alumnos.get(id).getClase()).get(day).get(rh.get(k)) == null) {
								 asistente1.get(c.alumnos.get(id).getClase()).get(day).put(rh.get(k), new ArrayList<Alumnos>());
							 }
							 
							     if(!asistente1.get(c.alumnos.get(id).getClase()).get(day).get(rh.get(k)).contains(c.alumnos.get(id))) {
							    	 asistente1.get(c.alumnos.get(id).getClase()).get(day).get(rh.get(k)).add(c.alumnos.get(id));
							     }
							
						}		
					}	
				}			 
			}
		}
		
		return asistente1;
	}
	
}
