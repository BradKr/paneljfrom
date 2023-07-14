package CrudMVC;
import Controlador.CtrlVendedor;
import Modelo.ConsultaVendedor;
import Modelo.Vendedor;
import Vista.FmVendedor;


public class CRUDMVCVend {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Vendedor vend = new Vendedor();
        ConsultaVendedor clvend = new ConsultaVendedor();
        FmVendedor fmvend = new FmVendedor();
        
        CtrlVendedor ctrlvend = new CtrlVendedor(vend, clvend, fmvend);
        ctrlvend.iniciar();
        fmvend.setVisible(true);
    }
    
}
