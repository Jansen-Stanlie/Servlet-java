package exam06.controllers;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionPro {
    private static Connection con;

    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam06","root","Jansen24");
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}


