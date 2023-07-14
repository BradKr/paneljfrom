
package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class ConsultaClientes extends Conexion {
    
    public boolean registrar(Clientes cli){
    //preparar nuestra conexion
    
    PreparedStatement ps =null;
    Connection con = getConexion();
    
    //senetencia de interaccion sql
    String sql = "INSERT INTO clientes(codigo, nombre, apellido, dni, sexo, distrito) VALUES (?,?,?,?,?,?)";
   
    // TRY y catch para insertar en cada campo
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, cli.getCodigo());
            ps.setString(2, cli.getNombre());
            ps.setString(3, cli.getApellido());
            ps.setInt(4,cli.getDni());
            ps.setString(5, cli.getSexo());
            ps.setString(6, cli.getDistrito());
            
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
    
    
    public boolean modificar(Clientes cli){
    //preparar nuestra conexion
    Connection con = getConexion();
    PreparedStatement ps =null;
    
    //senetencia de interaccion sql
    String sql = "UPDATE productos SET codigo=?, nombre=?, apellido=?,dni=? id=?, sexo=?, distrito=?";
   
    // TRY y catch para insertar en cada campo
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1, cli.getId());
            ps.setString(2, cli.getCodigo());
            ps.setString(3, cli.getNombre());
            ps.setString(4, cli.getApellido());
            ps.setInt(5,cli.getDni());
            ps.setString(6, cli.getSexo());
            ps.setString(7, cli.getDistrito());
            
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
    
        
    public boolean eliminar(Clientes cli){
    //preparar nuestra conexion
    Connection con = getConexion();
    PreparedStatement ps =null;
    
    //senetencia de interaccion sql
    String sql = "DELET FROM clientes WHERE id=?";
   
    // TRY y catch para insertar en cada campo
        try {
            ps=con.prepareStatement(sql);
            ps.setInt(4, cli.getId());
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
             
             
    public boolean buscar(Clientes cli){
    //preparar nuestra conexion
    Connection con = getConexion();
    PreparedStatement ps =null;
    ResultSet rs = null;   
    
    //senetencia de interaccion sql
    String sql = "SELECT FROM clientes WHERE codigo=?";
   
    // TRY y catch para insertar en cada campo
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, cli.getCodigo());
            ps.executeQuery();
            
            if(rs.next()){
               cli.setId(Integer.parseInt(rs.getString("id")));
               cli.setCodigo(rs.getString("codigo"));
               cli.setNombre(rs.getString("nombre"));
               cli.setApellido(rs.getString("apellido"));
               cli.setDni(Integer.parseInt(rs.getString("dni")));
               cli.setSexo(rs.getString("sexo"));
               cli.setDistrito(rs.getString("distrito"));
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
