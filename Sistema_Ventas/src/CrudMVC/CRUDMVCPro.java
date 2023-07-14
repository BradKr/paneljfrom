package CrudMVC;

import Controlador.CtrlProducto;
import Modelo.ConsultasProductos;
import Modelo.Productos;
import Vista.FmProductos;

/**
 *
 * @author MRoblesDev
 */
public class CRUDMVCPro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Productos mod = new Productos();
        ConsultasProductos modC = new ConsultasProductos();
        FmProductos frm = new FmProductos();

        CtrlProducto ctrl = new CtrlProducto(mod, modC, frm);
        ctrl.iniciar();
        frm.setVisible(true);
    }
}

