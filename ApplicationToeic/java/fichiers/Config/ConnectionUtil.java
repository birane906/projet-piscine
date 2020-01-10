package java.fichiers.Config;

import java.sql.*;
import javax.swing.*;


public class ConnectionUtil {
    Connection conn = null;
    public static Connection connectdb()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://mysql-projetpiscine.alwaysdata.net/projetpiscine_bdd?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
            String user = "197173_tiffany";
            String passwd = "piscine2019";
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