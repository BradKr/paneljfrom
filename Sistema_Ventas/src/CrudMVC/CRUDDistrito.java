package CrudMVC;

import Controlador.CtrlDistrito;
import Modelo.Distrito;
import Modelo.ConsultaDistrito;
import Vista.FmDistrito;


public class CRUDDistrito {

  
    public static void main(String[] args) {
        
        Distrito dis = new Distrito();
        ConsultaDistrito disC = new ConsultaDistrito();
        FmDistrito fmD = new FmDistrito();
        
        CtrlDistrito ctrlDis = new CtrlDistrito(dis, disC, fmD);
        ctrlDis.iniciar();
        fmD.setVisible(true);
        
    }
    
}

