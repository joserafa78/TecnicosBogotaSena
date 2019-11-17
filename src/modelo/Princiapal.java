
package modelo;

import controlador.ControladorTecnico;
import vistas.VistaTecnico;


public class Princiapal {

 
    public static void main(String[] args) {
      VistaTecnico vt=new VistaTecnico();
    ControladorTecnico ct=new ControladorTecnico(vt);
      ct.inicia();
    
    }
    
}
