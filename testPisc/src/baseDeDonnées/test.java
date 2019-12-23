package baseDeDonnées;
import java.sql.*; //il faut telecharger postgresql.jar et l'ajouter au PATH


public class test {

public static void main(String[] args) {
  try {
    Class.forName("org.postgresql.Driver");
       
    String url = "jdbc:postgresql://localhost:5432/piscine";
    String user = "postgres";
    String passwd = "motdepasse";
    
    //permet la connection à la bdd   
    Connection conn = DriverManager.getConnection(url, user, passwd);
       
    //Création d'un objet Statement
    Statement state = conn.createStatement();
    
    //Ajout d'un élement dans une table
    String sqlInsert = "INSERT INTO utilisateur VALUES (5, 'test.test@gmail.com', 'pass', false, 'IG3')";
    //System.out.println("The SQL statement is: " + sqlInsert + "\n");  // Echo for debugging
    /*int countInserted = */ state.executeUpdate(sqlInsert);
    //System.out.println(countInserted + " records inserted.\n");
    
    
    //On recupere le resultat d'une requete 
    ResultSet result = state.executeQuery("SELECT * FROM utilisateur");
    //On récupère les MetaData (les colonnes)
    ResultSetMetaData resultMeta = result.getMetaData();
       
    System.out.println("\n**********************************");
    //On affiche le nom des colonnes
    for(int i = 1; i <= resultMeta.getColumnCount(); i++)
      System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
       
    System.out.println("\n**********************************");
    
    //On affiche les elements d'une table
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