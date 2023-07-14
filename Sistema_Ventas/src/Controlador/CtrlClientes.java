
package Controlador;
import Modelo.ConsultaClientes;
import Modelo.Clientes;
import Vista.FmClientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class CtrlClientes implements ActionListener{
    private final Clientes modelo;
    private final ConsultaClientes consultas;
    private final FmClientes vista;

    public CtrlClientes(Clientes modelo, ConsultaClientes consultas, FmClientes vista) {
        this.modelo = modelo;
        this.consultas = consultas;
        this.vista = vista;
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnModificar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnLimpiar.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);
        this.vista.txtId.addActionListener(this);
        
    }
    public void iniciar(){
     vista.setTitle("Clientes");
     vista.setLocationRelativeTo(null);
     vista.txtId.setVisible(true);
     
    }

    @Override
    public void actionPerformed(ActionEvent e) {
                if (e.getSource() == vista.btnGuardar) {
            modelo.setCodigo(vista.txtCodigo.getText());
            modelo.setNombre(vista.txtNombre.getText());
            modelo.setApellido(vista.txtApellido.getText());
            modelo.setDni(Integer.parseInt(vista.txtDni.getText()));
            modelo.setSexo(vista.txtSexo.getText());
            modelo.setDistrito(vista.txtDistrito.getText());
            modelo.setId(Integer.parseInt(vista.txtId.getText()));

            if (consultas.registrar(modelo)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }
        }

        if (e.getSource() == vista.btnModificar) {
            modelo.setId(Integer.parseInt(vista.txtId.getText()));
            modelo.setCodigo(vista.txtCodigo.getText());
            modelo.setNombre(vista.txtNombre.getText());
            modelo.setApellido(vista.txtApellido.getText());
            modelo.setDni(Integer.parseInt(vista.txtDni.getText()));
            modelo.setSexo(vista.txtSexo.getText());
            modelo.setDistrito(vista.txtDistrito.getText());


            if (consultas.modificar(modelo)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }

        if (e.getSource() == vista.btnEliminar) {
            modelo.setId(Integer.parseInt(vista.txtId.getText()));

            if (consultas.eliminar(modelo)) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
        }

        if (e.getSource() == vista.btnBuscar) {
            modelo.setCodigo(vista.txtCodigo.getText());

            if (consultas.buscar(modelo)) {
                vista.txtId.setText(String.valueOf(modelo.getId()));
                vista.txtCodigo.setText(modelo.getCodigo());
                vista.txtNombre.setText(modelo.getNombre());
                modelo.setApellido(vista.txtApellido.getText());
                modelo.setDni(Integer.parseInt(vista.txtDni.getText()));
                modelo.setSexo(vista.txtSexo.getText());
                modelo.setDistrito(vista.txtDistrito.getText());

            } else {
                JOptionPane.showMessageDialog(null, "No se encontro registro");
                limpiar();
            }
        }

        if (e.getSource() == vista.btnLimpiar) {
            limpiar();
        }
    }

    public void limpiar() {
        vista.txtId.setText(null);
        vista.txtCodigo.setText(null);
        vista.txtNombre.setText(null);
        vista.txtApellido.setText(null);
        vista.txtDni.setText(null);
        vista.txtSexo.setText(null);
        vista.txtDistrito.setText(null);
       
    }
    
    
}
