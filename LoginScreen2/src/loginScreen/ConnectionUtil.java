package loginScreen;
import java.sql.*;
import javax.swing.*;


public class ConnectionUtil {
    Connection conn = null;
    public static Connection connectdb()
    {
        try
        {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/piscine";
            String user = "postgres";
            String passwd = "motdepasse";
            Connection conn = DriverManager.getConnection(url, user, passwd);
            return conn;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}