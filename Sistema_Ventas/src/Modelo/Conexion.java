package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    Connection con = null;
    String base = "ventas_tienda";
    String url = "jdbc:mysql://localhost:3310/" + base;
    String user = "root";
    String password = "";
    
    public Connection getConexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.err.println(e);
        }
        return con;
    } 
}

