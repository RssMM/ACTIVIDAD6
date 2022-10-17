package projecte1.controller;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import projecte1.Objectes.Alumnos;


@RestController
public class AlumnoController {

	ArrayList<Alumnos> alumnos;
	
	public void setClientList() {
		alumnos = new ArrayList<>();
		//Añadir alumnos:
		alumnos.add(new Alumnos("Joana", "Fernandez","DAM",
				LocalDate.of(2001, Month.APRIL, 11)));
		alumnos.add(new Alumnos("Juan", "Jimenez","DAM",
				LocalDate.of(2002, Month.JANUARY, 22)));
		alumnos.add(new Alumnos("Paul", "Ferrer","DAM",
				LocalDate.of(1998, Month.DECEMBER, 29)));
		alumnos.add(new Alumnos("David", "Sanchez","DAM",
				LocalDate.of(1999, Month.MARCH, 15)));
		alumnos.add(new Alumnos("Sara", "Gonzalez","DAM",
				LocalDate.of(2000, Month.MARCH, 13)));
		alumnos.add(new Alumnos("Carmen", "Perez","DAW",
				LocalDate.of(2000, Month.MAY, 26)));
		alumnos.add(new Alumnos("Ellie", "Martin","DAW",
				LocalDate.of(2002, Month.OCTOBER, 1)));
		alumnos.add(new Alumnos("Marco", "Garcia","DAW",
				LocalDate.of(2002, Month.AUGUST, 12)));
		alumnos.add(new Alumnos("Jose", "Rodriguez","DAW",
				LocalDate.of(2001, Month.MARCH, 10)));
		
	}
	@GetMapping("api/alumnos")
	public List<Alumnos> getClients() {
		setClientList();
		return alumnos;
	}
	
	@GetMapping("api/alumnos/{id}")
	public Alumnos getClient(@PathVariable(required = true, name = "id") int id) {
		setClientList();
		return alumnos.get(id);
	}
	
	@GetMapping("api/alumnos/{id}/{sub}")
	public String getClientinfo(@PathVariable(required = true, name = "id") int id,
			@PathVariable(required = true, name = "sub") String sub) {
		setClientList();
		String output = "err";
		if(sub.equals("name")) {
			 output = alumnos.get(id).getNom();
		}else if(sub.equals("lastname")) {
			 output = alumnos.get(id).getCognoms();
		}else if(sub.equals("birthday")) {
			 output = alumnos.get(id).getDataNaixement().toString();
		}else if(sub.equals("class")) {
			 output = alumnos.get(id).getClase();
		}else if(sub.equals("email")) {
			 output = alumnos.get(id).getEmail();
		}
		return output;
	}
	
	@GetMapping("api/alumnos/group/{group}")
	public List<Alumnos> getClassGroup(@PathVariable(required = true, name = "group") String group) {
		setClientList();
		ArrayList<Alumnos> output = new ArrayList<>();
		for (Alumnos client : alumnos) {
           if(client.getClase().equalsIgnoreCase(group)) {
            	output.add(client);
           }
        }
	    
		return output;
	}
	
	@GetMapping("api/alumnos/search/name")
	public List<Alumnos> getMatchNames(@RequestParam("match") String ms) {
		setClientList();
		ArrayList<Alumnos> output = new ArrayList<>();
		for (Alumnos client : alumnos) {
           if(client.getNom().toUpperCase().contains(ms.toUpperCase())) {
            	output.add(client);
           }
        }
	    return output;
	}
	
	@GetMapping("api/alumnos/search/lastname")
	public List<Alumnos> getMatchLastNames(@RequestParam("match") String ms) {
		setClientList();
		ArrayList<Alumnos> output = new ArrayList<>();
		for (Alumnos client : alumnos) {
           if(client.getCognoms().toUpperCase().contains(ms.toUpperCase())) {
            	output.add(client);
           }
        }
	    return output;
	}
	
	
	@GetMapping("api/alumnos/search/birthday")
	public List<Alumnos> getMatchBirthday(@RequestParam("startAt") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate start, 
										@RequestParam("endAt")  @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
		setClientList();
		ArrayList<Alumnos> output = new ArrayList<>();
		for (Alumnos client : alumnos) {
			LocalDate ne = client.getDataNaixement();
           if((ne.isAfter(start) && ne.isBefore(end)) || ne.equals(start) || ne.equals(end)) {
            	output.add(client);
           }
        }
	    return output;
	}
	
}
