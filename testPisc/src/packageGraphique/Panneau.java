package packageGraphique;
import java.awt.Graphics;
import javax.swing.JPanel;
 
public class Panneau extends JPanel { 
  
	public void paintComponent(Graphics g){
		//créer une forme ovale dans la fenetre
		g.fillOval(20, 20, 75, 75);
  }               
}