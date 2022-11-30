package sample.models;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexion {

    private static String server = "127.0.0.1";
    private static String user   = "root";
    private static String pwd    = "portal23456";
    private static String bd     = "hospital";
    //qweasdzxc123
    public static Connection conexion;
    public static void crearConexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://"+server+":3306/"+bd,user,pwd);
            System.out.println("Conexion a la bd establecida....");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
