package prog.fichiers.Config;

public class Timer implements java.lang.Runnable{

    @Override
    public void run() {
        this.runTimer();
    }

    public void runTimer(){
    	
        int i;
        int j=74; //start � 74 minutes and 59 seconds
        while(j>-1) {
        	i=59;
        	while (i>-1){
        		if (i<10) {
        			System.out.println(j+":0"+i);
        		}
        		else {
        			System.out.println(j+":"+i);
        		}
        		try {
        			i--;
        			Thread.sleep(1000L);    // 1000L = 1000ms = 1 second
        		}
        		catch (InterruptedException e) {
        			
        		}
        	}
        	j--;
        }
    }
}