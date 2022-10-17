package projecte1.Objectes;

import java.time.LocalDate;
import java.util.Objects;

public class Alumnos {
	private String nom;
	private String cognoms;
        private String clase;
	private LocalDate dataNaixement;

    public Alumnos(String nom, String cognoms, String clase, LocalDate dataNaixement) {
        this.nom = nom;
        this.cognoms = cognoms;
        this.clase = clase;
        this.dataNaixement = dataNaixement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public LocalDate getDataNaixement() {
        return dataNaixement;
    }

    public void setDataNaixement(LocalDate dataNaixement) {
        this.dataNaixement = dataNaixement;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.nom);
        hash = 73 * hash + Objects.hashCode(this.cognoms);
        hash = 73 * hash + Objects.hashCode(this.clase);
        hash = 73 * hash + Objects.hashCode(this.dataNaixement);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alumnos other = (Alumnos) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.cognoms, other.cognoms)) {
            return false;
        }
        if (!Objects.equals(this.clase, other.clase)) {
            return false;
        }
        return Objects.equals(this.dataNaixement, other.dataNaixement);
    }
    
	
}