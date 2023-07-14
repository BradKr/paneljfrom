
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ConsultaDistrito extends Conexion {

    public boolean registrar(Distrito dis){
    //preparar nuestra conexion
    
    PreparedStatement ps =null;
    Connection con = getConexion();
    
    //senetencia de interaccion sql
    String sql = "INSERT INTO distrito(nombre, descripcion) VALUES (?,?)";
   
    // TRY y catch para insertar en cada campo
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, dis.getNombre());
            ps.setString(2, dis.getDescripcion());
           ;
            
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error a la hora de conectar a la BD");
            return false;
            
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrrar la conexion");
            }
        }
    
    }
    
    
    public boolean modificar(Distrito dis){
    //preparar nuestra conexion
    Connection con = getConexion();
    PreparedStatement ps =null;
    
    //senetencia de interaccion sql
    String sql = "UPDATE distrito SET nombre=?, descripciob=?";
   
    // TRY y catch para insertar en cada campo
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, dis.getId());
            ps.setString(2, dis.getNombre());
            ps.setString(3, dis.getDescripcion());
            
            
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error a la hora de conectar a la BD");
            return false;
            
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrrar la conexion");
            }
        }
    
    }
    
        
    public boolean eliminar(Distrito dis){
    //preparar nuestra conexion
    Connection con = getConexion();
    PreparedStatement ps =null;
    
    //senetencia de interaccion sql
    String sql = "DELET FROM distrito WHERE id=?";
   
    // TRY y catch para insertar en cada campo
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(4, dis.getId());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error a la hora de conectar a la BD");
            return false;
            
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrrar la conexion");
            }
        }
    
    }
             
             
    public boolean buscar(Distrito dis){
    //preparar nuestra conexion
    Connection con = getConexion();
    PreparedStatement ps =null;
    ResultSet rs = null;   
    
    //senetencia de interaccion sql
    String sql = "SELECT FROM Distrito WHERE id=?";
   
    // TRY y catch para insertar en cada campo
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, dis.getId());
            ps.executeQuery();
            
            if(rs.next()){
               dis.setId(Integer.parseInt(rs.getString("id")));
               dis.setNombre(rs.getString("nombre"));
               dis.setDescripcion(rs.getString("descripcion"));

            }
            return true;
        } catch (Exception e) {
            System.out.println("Error a la hora de conectar a la BD");
            return false;
            
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrrar la conexion");
            }
        }
    
    }
}
