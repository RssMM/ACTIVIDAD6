package projecte1.controller;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import projecte1.Objectes.Client;

@RestController
public class ClientController {
	
	ArrayList<Client> clients;
	
	@GetMapping("client/{id}")
	public Client getClient(@PathVariable(required=false,name="id") int id) {
		return clients.get(id);
	}
	
	@GetMapping("clients")
	public List<Client> getClients(){
		clients = new ArrayList<>();
		
		clients.add(new Client("Joana", "Fernando", 
				LocalDate.of(2000, Month.APRIL, 23)));
		clients.add(new Client("Juan", "Giemenez", 
				LocalDate.of(2000, Month.MARCH, 22)));
		clients.add(new Client("Paul", "Teresa", 
				LocalDate.of(2000, Month.MARCH, 22)));
		clients.add(new Client("David", "Sánchez", 
				LocalDate.of(2000, Month.MARCH, 22)));
		clients.add(new Client("Sara", "Gonozales", 
				LocalDate.of(2000, Month.MARCH, 22)));
		clients.add(new Client("Carmen", "Perez", 
				LocalDate.of(2000, Month.MARCH, 22)));
		clients.add(new Client("Ellie", "Martin", 
				LocalDate.of(2000, Month.MARCH, 22)));
		clients.add(new Client("Marco", "Garcia", 
				LocalDate.of(2000, Month.MARCH, 22)));
		clients.add(new Client("Jose", "Rordriguez", 
				LocalDate.of(2000, Month.MARCH, 22)));
		return clients;
	}

}
