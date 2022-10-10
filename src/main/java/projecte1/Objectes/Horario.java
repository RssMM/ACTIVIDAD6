package projecte1.Objectes;

import java.time.LocalTime;
import java.util.ArrayList;

public class Horario {
	private String clase;
	//String [] columns = {"Lunes","Martes","Miercoles","Jueves","Viernes"};
	ArrayList<ArrayList<LocalTime>> horario = new ArrayList<ArrayList<LocalTime>>();
	
	public Horario(String clase, String[][] hora) {
		this.clase = clase;
		for(int i = 0; i< hora.length ; i++) {
			ArrayList<LocalTime> horariosDia = new ArrayList<LocalTime>();
			for(int j = 0; j< hora[i].length ; j++) {
				 String[] h = hora[i][j].split(" - ");
				 horariosDia.add(LocalTime.parse(h[0]));
				
				 horariosDia.add(LocalTime.parse(h[1]));
			}
			horario.add(horariosDia);
		}
	}

	
	
	
	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public ArrayList<ArrayList<LocalTime>> getHorario() {
		return horario;
	}

	public void setHorario(ArrayList<ArrayList<LocalTime>> horario) {
		this.horario = horario;
	}
	
	
}
