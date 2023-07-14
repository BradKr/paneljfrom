package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConsultasProductos extends Conexion{
    //Creamos el procedimiento 
    public boolean registrar(Productos pro){
    //prepraramos la conexion con nuestra base de datos 
        PreparedStatement ps =null;
        Connection con = getConexion();
    // Creamos la sentencia sql para insertar registros
   String sql = "INSERT INTO productos(codigo,nombre,precio,cantidad) VALUES (?,?,?,?)";
   
   //A traves de un try catch insertamos  cada campo en la bd
        try {
          ps=con.prepareStatement(sql);
          ps.setString(1,pro.getCodigo());
          ps.setString(2,pro.getNombre());
          ps.setDouble(3,pro.getPrecio());
          ps.setInt(4,pro.getCantidad());
          ps.execute();
          return true;
        } catch (Exception e) {
            System.out.println("Error a la hora de la conexion ");
            return false;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexion");
            }
        }
        
    }
    
    public boolean modificar(Productos pro){
    //prepraramos la conexion con nuestra base de datos 
        PreparedStatement ps =null;
        Connection con = getConexion();
    // Creamos la sentencia sql para insertar registros
   String sql = "UPDATE productos SET codigo=?, nombre=?, precio=?, cantidad=? WHERE id=?";
   
   //A traves de un try catch insertamos  cada campo en la bd
        try {
          ps=con.prepareStatement(sql);
          ps.setString(1,pro.getCodigo());
          ps.setString(2,pro.getNombre());
          ps.setDouble(3,pro.getPrecio());
          ps.setInt(4,pro.getCantidad());
          ps.setInt(5,pro.getId());
          ps.execute();
          return true;
        } catch (Exception e) {
            System.out.println("Error a la hora de la conexion ");
            return false;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexion");
            }
        }
        
    }
     
    public boolean eliminar(Productos pro){
    //prepraramos la conexion con nuestra base de datos 
        PreparedStatement ps =null;
        Connection con = getConexion();
    // Creamos la sentencia sql para insertar registros
   String sql = "DELETE FROM productos WHERE id=?";
   
   //A traves de un try catch insertamos  cada campo en la bd
        try {
          ps=con.prepareStatement(sql);
          ps.setInt(1,pro.getId());
          ps.execute();
          return true;
        } catch (Exception e) {
            System.out.println("Error a la hora de la conexion ");
            return false;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexion");
            }
        }
        
    }
    
    public boolean buscar(Productos pro){
    //prepraramos la conexion con nuestra base de datos 
        PreparedStatement ps =null;
        ResultSet rs =null;
        Connection con = getConexion();
    // Creamos la sentencia sql para insertar registros
   String sql = "SELECT * FROM productos WHERE codigo=?";
   
   //A traves de un try catch insertamos  cada campo en la bd
        try {
          ps=con.prepareStatement(sql);
          ps.setString(1,pro.getCodigo());
          rs= ps.executeQuery(); 

// se realiza busqueda
           if(rs.next()){
           pro.setId(Integer.parseInt(rs.getString("id")));
           pro.setCodigo(rs.getString("codigo"));
           pro.setNombre(rs.getString("nombre"));
           pro.setPrecio(Double.parseDouble(rs.getString("precio")));
           pro.setCantidad(Integer.parseInt(rs.getString("cantidad")));
           
           }
          return true;
        } catch (Exception e) {
            System.out.println("Error a la hora de la conexion ");
            return false;
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexion");
            }
        }
        
    }
      
}
