
package Modelo;
 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class ConsultaVendedor extends Conexion {
    
    public boolean registrar(Vendedor vend){
    
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO vendedor(nombre, apellido, edad, genero, distrito) VALUES (?,?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, vend.getNombre());
            ps.setString(2, vend.getApellido());
            ps.setInt(3, vend.getEdad());
            ps.setString(4, vend.getGenero());
            ps.setString(5, vend.getDistrito());
            ps.execute();
            return true;
           
        } catch (Exception e) {
            System.out.println("Error a la hora de conectar con la BD");
            return false;
        } finally {
            try {
               con.close();
            } catch (Exception e) {
                System.out.println("Error a la hora de cerrar la conexion");
            }
        }
    }
    
        
      public boolean modificar(Vendedor vend){
    
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "UPDATE vendedor SET nombre=?, apellido=?, edad=?, genero=?, distrito=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, vend.getNombre());
            ps.setString(2, vend.getApellido());
            ps.setInt(3, vend.getEdad());
            ps.setString(4, vend.getGenero());
            ps.setString(5, vend.getDistrito());
            ps.execute();
            return true;
           
        } catch (Exception e) {
            System.out.println("Error a la hora de conectar con la BD");
            return false;
        } finally {
            try {
               con.close();
            } catch (Exception e) {
                System.out.println("Error a la hora de cerrar la conexion");
            }
        }
    }
      
      
      public boolean eliminar(Vendedor vend){
    
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "DELETE FROM vendedor WHERE id=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,vend.getId());
            ps.execute();
            return true;
           
        } catch (Exception e) {
            System.out.println("Error a la hora de conectar con la BD");
            return false;
        } finally {
            try {
               con.close();
            } catch (Exception e) {
                System.out.println("Error a la hora de cerrar la conexion");
            }
        }
    }
      
      
    public boolean buscar(Vendedor vend){
    
        PreparedStatement ps = null;
        Connection con = getConexion();
        ResultSet rs = null;
        
        String sql = "SELECT*FROM vendedor WHERE apellido=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,vend.getApellido());
            rs = ps.executeQuery();
            ps.execute();
          
            if(rs.next()){
             vend.setNombre(rs.getString("nombre"));
             vend.setApellido(rs.getString("apellido"));
             vend.setEdad(Integer.parseInt(rs.getString("edad")));
             vend.setGenero(rs.getString("genero"));
             vend.setDistrito(rs.getString("distrito"));
            }
           return true;
        } catch (Exception e) {
            System.out.println("Error a la hora de conectar con la BD");
            return false;
        } finally {
            try {
               con.close();
            } catch (Exception e) {
                System.out.println("Error a la hora de cerrar la conexion");
            }
        }
    }
}
