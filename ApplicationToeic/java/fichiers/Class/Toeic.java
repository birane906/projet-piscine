package java.fichiers.Class;
import java.time.LocalDate;

public class TOEIC {

	private int NumTOEIC;
	
	private String LibelleTOEIC;
	
	private int Enseignant;
	
//getters et setters
	
	public int getNumTOEIC(){
		return NumTOEIC;
	}

	public void setNumTOEIC(int numTOEIC) {
		this.NumTOEIC = numTOEIC;
	}

	public String getLibelleTOEIC() {
		return LibelleTOEIC;
	}

	public void setLibelleTOEIC(String libelleTOEIC) {
		this.LibelleTOEIC = libelleTOEIC;
	}
	
	public int getEnseignant(){
		return this.Enseignant;
	}

	public void setEnseignant(int idEnseignant){
		this.Enseignant = idEnseignant;
	}
	
//constructeur Toeic	
	public TOEIC(int numTOEIC,String libelleTOEIC, int idEnseignant) {
		this.NumTOEIC= numTOEIC;
		this.LibelleTOEIC= libelleTOEIC;
		this.Enseignant=idEnseignant; 
	}


}