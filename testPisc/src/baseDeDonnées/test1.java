package baseDeDonn�es;
import java.sql.*; //il faut telecharger mysqlconnector.jar et l'ajouter au PATH


public class test1 {

public static void main(String[] args) {
  try {
    Class.forName("com.mysql.cj.jdbc.Driver");
       
    String url = "jdbc:mysql://mysql-projetpiscine.alwaysdata.net/projetpiscine_bdd?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
    String user = "197173_tiffany";
    String passwd = "piscine2019";
       
    Connection conn = DriverManager.getConnection(url, user, passwd);
       
    //Cr�ation d'un objet Statement
    Statement state = conn.createStatement();
    
    
    /*String sqlInsert = "INSERT INTO Utilisateur VALUES (20303090,'Dupond','Albert','dupond.alb@etu.umontpellier.fr','mdp',False,'IG 4', '2018')";
    System.out.println("The SQL statement is: " + sqlInsert + "\n");
    int countInserted = state.executeUpdate(sqlInsert);
    System.out.println(countInserted + " records inserted.\n");*/
    
    //L'objet ResultSet contient le r�sultat de la requ�te SQL
    ResultSet result = state.executeQuery("SELECT * FROM Utilisateur");
    //On r�cup�re les MetaData
    ResultSetMetaData resultMeta = result.getMetaData();
       
    System.out.println("\n**********************************");
    //On affiche le nom des colonnes
    for(int i = 1; i <= resultMeta.getColumnCount(); i++)
      System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
       
    System.out.println("\n**********************************");
       
    while(result.next()){         
      for(int i = 1; i <= resultMeta.getColumnCount(); i++)
        System.out.print("\t" + result.getObject(i).toString() + "\t |");
          
      System.out.println("\n---------------------------------");

    }

    //result.close();
    //state.close();
       
  } catch (Exception e) {
    e.printStackTrace();
  }      
}
}