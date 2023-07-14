/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ConsultaDistrito;
import Modelo.Distrito;
import Vista.FmDistrito;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CtrlDistrito implements ActionListener {
    private final Distrito modelo;
    private final ConsultaDistrito consulta;
    private final FmDistrito fmv;

    public CtrlDistrito(Distrito modelo, ConsultaDistrito consulta, FmDistrito fmv) {
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
        fmv.setTitle("Distrito");
        fmv.setLocationRelativeTo(null);
        fmv.txtId.setVisible(false);
    }
    

    
    @Override
    public void actionPerformed(ActionEvent e){
    
        if (e.getSource()== fmv.btnGuardar){
            modelo.setNombre(fmv.txtnombre.getText());
            modelo.setDescripcion(fmv.txtdes.getText());
            
            
            if(consulta.registrar(modelo)){
               JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            }else{
               JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
           }
        
            if (e.getSource()== fmv.btnModificar){
            modelo.setNombre(fmv.txtnombre.getText());
            modelo.setDescripcion(fmv.txtdes.getText());

            
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
          
            modelo.setNombre(fmv.txtnombre.getText());
          
            
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
        fmv.txtnombre.setText(null);
        fmv.txtdes.setText(null);

    }
}