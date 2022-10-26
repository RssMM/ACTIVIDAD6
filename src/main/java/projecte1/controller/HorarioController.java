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
									{"15:20 - 21:00"},
									{"15:20 - 21:00"},
									{"16:20 - 21:00"},
									{"15:20 - 21:00"},
									{"15:20 - 18:10"}
								};
		String[][] horarioDAW = {
									{"16:20 - 21:00"},
									{"15:20 - 21:00"},
									{"16:20 - 21:00"},
									{"15:20 - 20:10"},
									{"15:20 - 18:10"}
								};
		horarios.add(new Horario("DAM1", horarioDAM));
		horarios.add(new Horario("DAW1", horarioDAW));
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
