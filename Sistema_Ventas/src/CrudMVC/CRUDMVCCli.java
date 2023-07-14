
package CrudMVC;

import Controlador.CtrlClientes;
import Modelo.Clientes;
import Modelo.ConsultaClientes;
import Vista.FmClientes;


public class CRUDMVCCli {

  
    public static void main(String[] args) {
        
        Clientes cli = new Clientes();
        ConsultaClientes cliC = new ConsultaClientes();
        FmClientes fmc = new FmClientes();
        
        CtrlClientes ctrlCli = new CtrlClientes(cli, cliC, fmc);
        ctrlCli.iniciar();
        fmc.setVisible(true);
        
    }
    
}
