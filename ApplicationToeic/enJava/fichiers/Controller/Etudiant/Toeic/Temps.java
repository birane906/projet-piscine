package enJava.fichiers.Controller.Etudiant.Toeic;

public class Temps {

	int min;
	int sec;
	
	public Temps(int x,int y) {
		this.min=x;
		this.sec=y;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getSec() {
		return sec;
	}

	public void setSec(int sec) {
		this.sec = sec;
	}
	
}
