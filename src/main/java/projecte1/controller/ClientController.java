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

import projecte1.Objectes.Client;


@RestController
public class ClientController {

	ArrayList<Client> clients;
	
	public void setClientList() {
		clients = new ArrayList<>();
		//Añadir clientes:
		clients.add(new Client("Joana", "Fernandez","DAM",
				LocalDate.of(2001, Month.APRIL, 11)));
		clients.add(new Client("Juan", "Jimenez","DAM",
				LocalDate.of(2002, Month.JANUARY, 22)));
		clients.add(new Client("Paul", "Ferrer","DAM",
				LocalDate.of(1998, Month.DECEMBER, 29)));
		clients.add(new Client("David", "Sanchez","DAM",
				LocalDate.of(1999, Month.MARCH, 15)));
		clients.add(new Client("Sara", "Gonzalez","DAM",
				LocalDate.of(2000, Month.MARCH, 13)));
		clients.add(new Client("Carmen", "Perez","DAW",
				LocalDate.of(2000, Month.MAY, 26)));
		clients.add(new Client("Ellie", "Martin","DAW",
				LocalDate.of(2002, Month.OCTOBER, 1)));
		clients.add(new Client("Marco", "Garcia","DAW",
				LocalDate.of(2002, Month.AUGUST, 12)));
		clients.add(new Client("Jose", "Rodriguez","DAW",
				LocalDate.of(2001, Month.MARCH, 10)));
		
	}
	@GetMapping("api/clients")
	public List<Client> getClients() {
		setClientList();
		return clients;
	}
	
	@GetMapping("api/clients/{id}")
	public Client getClient(@PathVariable(required = true, name = "id") int id) {
		setClientList();
		return clients.get(id);
	}
	
	@GetMapping("api/clients/{id}/{sub}")
	public String getClientinfo(@PathVariable(required = true, name = "id") int id,
			@PathVariable(required = true, name = "sub") String sub) {
		setClientList();
		String output = "err";
		if(sub.equals("name")) {
			 output = clients.get(id).getNom();
		}else if(sub.equals("lastname")) {
			 output = clients.get(id).getCognoms();
		}else if(sub.equals("birthday")) {
			 output = clients.get(id).getDataNaixement().toString();
		}else if(sub.equals("class")) {
			 output = clients.get(id).getClase();
		}
		
		return output;
	}
	
	@GetMapping("api/clients/group/{group}")
	public List<Client> getClassGroup(@PathVariable(required = true, name = "group") String group) {
		setClientList();
		ArrayList<Client> output = new ArrayList<>();
		for (Client client : clients) {
           if(client.getClase().equalsIgnoreCase(group)) {
            	output.add(client);
           }
        }
	    
		return output;
	}
	
	@GetMapping("api/clients/search/name")
	public List<Client> getMatchNames(@RequestParam("match") String ms) {
		setClientList();
		ArrayList<Client> output = new ArrayList<>();
		for (Client client : clients) {
           if(client.getNom().toUpperCase().contains(ms.toUpperCase())) {
            	output.add(client);
           }
        }
	    return output;
	}
	
	@GetMapping("api/clients/search/lastname")
	public List<Client> getMatchLastNames(@RequestParam("match") String ms) {
		setClientList();
		ArrayList<Client> output = new ArrayList<>();
		for (Client client : clients) {
           if(client.getCognoms().toUpperCase().contains(ms.toUpperCase())) {
            	output.add(client);
           }
        }
	    return output;
	}
	
	
	@GetMapping("api/clients/search/birthday")
	public List<Client> getMatchBirthday(@RequestParam("startAt") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate start, 
										@RequestParam("endAt")  @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
		setClientList();
		ArrayList<Client> output = new ArrayList<>();
		for (Client client : clients) {
			LocalDate ne = client.getDataNaixement();
           if((ne.isAfter(start) && ne.isBefore(end)) || ne.equals(start) || ne.equals(end)) {
            	output.add(client);
           }
        }
	    return output;
	}
	
}
