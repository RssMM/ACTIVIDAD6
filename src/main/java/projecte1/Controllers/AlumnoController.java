package projecte1.controller;

import java.beans.FeatureDescriptor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project1.repo.AlumnosRepo;
import projecte1.Objectes.Alumnos;


@RestController
public class AlumnoController {
	ArrayList<Alumnos> alumnos;
	
	@Autowired     
	AlumnosRepo clientRep; 
	
	
	public void setClientList() {
		
		alumnos = (ArrayList<Alumnos>) clientRep.findAll();

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
		}else if(sub.equals("email")) {
			 output = alumnos.get(id).getEmail();
		}else if(sub.equals("grup")) {
			output = alumnos.get(id).getGrup();
		}
		return output;
	}
	
	@GetMapping("api/alumnos/group/{group}")
	public List<Alumnos> getClassGroup(@PathVariable(required = true, name = "group") String group) {
		setClientList();
		ArrayList<Alumnos> output = new ArrayList<>();
		for (Alumnos client : alumnos) {
           if(client.getGrup().equalsIgnoreCase(group)) {
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
			LocalDate ne = client.getDataNaixement().toLocalDate();
           if((ne.isAfter(start) && ne.isBefore(end)) || ne.equals(start) || ne.equals(end)) {
            	output.add(client);
           }
        }
	    return output;
	}
	@DeleteMapping("api/alumnos/{id}/delete")
    public ResponseEntity<Integer> deleteAlumno(@PathVariable int id) {
        if (clientRep.existsById((long) id)) {
        	clientRep.deleteById((long) id);
        	return new ResponseEntity<>(id, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       
    }
	
	@PostMapping("api/alumnos/{id}/modify")
    public ResponseEntity<Alumnos> putModify(@PathVariable int id, @RequestBody Alumnos details)  {
		final BeanWrapper wrap = new BeanWrapperImpl(details);
		String[] ignoredProperties = Stream.of(wrap.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> wrap.getPropertyValue(propertyName) == null)
                .toArray(String[]::new);
		
		Alumnos updateAlumnos = clientRep.findById((long) id).orElseThrow();	
		BeanUtils.copyProperties(details, updateAlumnos, ignoredProperties);
		clientRep.save(updateAlumnos);
		return ResponseEntity.ok(updateAlumnos);
    }
	
	
}
