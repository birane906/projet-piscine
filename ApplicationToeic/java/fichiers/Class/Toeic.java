package piscine;
import java.time.LocalDate;

public class TOEIC {

	private int NumTOEIC;
	
	private String LibelleTOEIC;
	
	private int Enseignant;
	
//getters et setters
	
	public int getNumTOEIC(){
		return numTOEIC;
	}

	public void setNumTOEIC(int numTOEIC) {
		this.numTOEIC = numTOEIC;
	}

	public String getLibelleTOEIC() {
		return libelleTOEIC;
	}

	public void setLibelleTOEIC(String libelleTOEIC) {
		this.libelleTOEIC = libelleTOEIC;
	}
	
	public int getEnseignant(){
		return this.Enseignant;
	}

	public void setEnseignant(int idEnseignant){
		this.Enseignant = idEnseignant;
	}
	
//constructeur Toeic	
	public TOEIC(int numTOEIC,String libelleTOEIC, int idEnseignant) {
		this.numTOEIC= numTOEIC;
		this.libelleTOEIC= libelleTOEIC;
		this.Enseignant=idEnseignant; 
	}


}