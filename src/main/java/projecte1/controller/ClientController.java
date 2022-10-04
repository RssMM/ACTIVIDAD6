package projecte1.controller;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import projecte1.Objectes.Client;

@RestController
public class ClientController {
	
	@GetMapping("hola")
	public String bonaTarda() {
		return "<h1>bona tarda</h1>";
	}
	
	@GetMapping("client")
	public Client getClient() {
		return new Client("Joana", "Petita", 
				LocalDate.of(2000, Month.APRIL, 23));
	}
	
	@GetMapping("clients")
	public List<Client> getClients(){
		ArrayList<Client> clients = new ArrayList<>();
		
		clients.add(new Client("Joana", "Petita", 
				LocalDate.of(2000, Month.APRIL, 23)));
		clients.add(new Client("Joan", "Petit", 
				LocalDate.of(2000, Month.MARCH, 22)));
		
		return clients;
	}

}
