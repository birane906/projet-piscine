package prog.fichiers.Config;
public class TimerThread {

	public static void main(String[] args){
	    Thread thread = new Thread(new Timer());
	    thread.run();
	  }
}