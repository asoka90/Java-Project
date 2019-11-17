/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkingslot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Win10
 */
public class ParkingSlot {
    public static Connection con;
    public static Statement st;
    
    public static Statement connectDB()
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:C:\\Users\\Win10\\Documents\\NetBeansProjects\\ParkingSlot\\db\\systemDB.db";
            con = DriverManager.getConnection(url);
            st = con.createStatement();
            System.out.println("Success");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return st;
    }
    
    
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        connectDB();
//        Sample query
//        String query = "SELECT * FROM Student";
//        ResultSet rs = st.executeQuery(query);
//        while (rs.next())
//        {
//            int id = rs.getInt("id");
//            System.out.println(id);
//        }
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
    }
    
}
