package packageGraphique;
import javax.swing.JFrame;

public class Fenetre extends JFrame {
  
	public Fenetre(){
    this.setTitle("Ma première fenêtre Java");
    this.setSize(400, 500); //taille de la fenetre
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //permet de configurer la fermeture de la fenetre
    this.setContentPane(new Panneau()); //ajoute un objet (cf. classe Panneau)
    this.setVisible(true); // rend la fenetre visible
  }
}