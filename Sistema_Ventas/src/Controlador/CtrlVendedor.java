
package Controlador;

import Modelo.ConsultaVendedor;
import Modelo.Vendedor;
import Vista.FmVendedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CtrlVendedor implements ActionListener {
    private final Vendedor modelo;
    private final ConsultaVendedor consulta;
    private final FmVendedor fmv;

    public CtrlVendedor(Vendedor modelo, ConsultaVendedor consulta, FmVendedor fmv) {
        this.modelo = modelo;
        this.consulta = consulta;
        this.fmv = fmv;
        this.fmv.btnBuscar.addActionListener(this);
        this.fmv.btnLimpiar.addActionListener(this);
        this.fmv.btnGuardar.addActionListener(this);
        this.fmv.btnModificar.addActionListener(this);
        this.fmv.btnEliminar.addActionListener(this);
       
    }
    
    public void iniciar(){
        fmv.setTitle("Vendedor");
        fmv.setLocationRelativeTo(null);
        fmv.txtId.setVisible(false);
    }
    

    
    @Override
    public void actionPerformed(ActionEvent e){
    
        if (e.getSource()== fmv.btnGuardar){
            modelo.setNombre(fmv.txtNombre.getText());
            modelo.setApellido(fmv.txtApellido.getText());
            modelo.setEdad(Integer.parseInt(fmv.txtEdad.getText()));
            modelo.setGenero(fmv.txtGenero.getText());
            modelo.setDistrito(fmv.txtDistrito.getText());
            
            if(consulta.registrar(modelo)){
               JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            }else{
               JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
           }
        
            if (e.getSource()== fmv.btnModificar){
            modelo.setNombre(fmv.txtNombre.getText());
            modelo.setApellido(fmv.txtApellido.getText());
            modelo.setEdad(Integer.parseInt(fmv.txtEdad.getText()));
            modelo.setGenero(fmv.txtGenero.getText());
            modelo.setDistrito(fmv.txtDistrito.getText());
            
            if(consulta.registrar(modelo)){
               JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            }else{
               JOptionPane.showMessageDialog(null, "Error al Modificado");
                limpiar();
            }
           }
            
            if (e.getSource()== fmv.btnEliminar){
            
            modelo.setId(Integer.parseInt(fmv.txtId.getText()));
          
            
            if(consulta.registrar(modelo)){
               JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            }else{
               JOptionPane.showMessageDialog(null, "Error al eliminado");
                limpiar();
            }
           }
            
           if (e.getSource()== fmv.btnBuscar){
          
            modelo.setApellido(fmv.txtApellido.getText());
          
            
            if(consulta.registrar(modelo)){
               JOptionPane.showMessageDialog(null, "Registro encontrado");
                limpiar();
            }else{
               JOptionPane.showMessageDialog(null, "Error al encontrar");
                limpiar();
            }
           }
           
           if(e.getSource()==fmv.btnLimpiar){
             limpiar();
             
             
           }
           
           
    }
    
     public void limpiar() {
        fmv.txtId.setText(null);
        fmv.txtNombre.setText(null);
        fmv.txtApellido.setText(null);
        fmv.txtEdad.setText(null);
        fmv.txtGenero.setText(null);
        fmv.txtDistrito.setText(null);
    }
}
