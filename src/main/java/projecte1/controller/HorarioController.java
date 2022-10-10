package projecte1.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import projecte1.Objectes.Horario;

@RestController
public class HorarioController {
	
	ArrayList<Horario> horarios;
	public void setHorarioList() {
		horarios = new ArrayList<>();
		String[][] horarioDAM = {
									{"15:20 - 16:20","16:20 - 17:15","17:15 - 18:10", "18:30 - 19:20", "19:20 - 20:10", "20:10 - 21:00"},
									{"15:20 - 16:20","16:20 - 17:15","17:15 - 18:10", "18:30 - 19:20", "19:20 - 20:10", "20:10 - 21:00"},
									{"16:20 - 17:15","17:15 - 18:10", "18:30 - 19:20", "19:20 - 20:10", "20:10 - 21:00"},
									{"15:20 - 16:20","16:20 - 17:15","17:15 - 18:10", "18:30 - 19:20", "19:20 - 20:10", "20:10 - 21:00"},
									{"15:20 - 16:20","16:20 - 17:15","17:15 - 18:10"}
								};
		String[][] horarioDAW = {
									{"16:20 - 17:15","17:15 - 18:10", "18:30 - 19:20", "19:20 - 20:10", "20:10 - 21:00"},
									{"15:20 - 16:20","16:20 - 17:15","17:15 - 18:10", "18:30 - 19:20", "19:20 - 20:10", "20:10 - 21:00"},
									{"16:20 - 17:15","17:15 - 18:10", "18:30 - 19:20", "19:20 - 20:10", "20:10 - 21:00"},
									{"15:20 - 16:20","16:20 - 17:15","17:15 - 18:10", "18:30 - 19:20", "19:20 - 20:10"},
									{"15:20 - 16:20","16:20 - 17:15","17:15 - 18:10"}
								};
		horarios.add(new Horario("DAM", horarioDAM));
		horarios.add(new Horario("DAW", horarioDAW));
	}
	@GetMapping("api/horarios")
	public List<Horario> getHorarios() {
		setHorarioList();
		return horarios;		
	}
	@GetMapping("api/horarios/{group}")
	public List<Horario> getHorarioGroup(@PathVariable(required = true, name = "group") String group) {
		setHorarioList();
		ArrayList<Horario> output = new ArrayList<>();
		for(Horario horario : horarios) {
			if(horario.getClase().equalsIgnoreCase(group)) {
				output.add(horario);
			}
		}
		return output;
	}
}
