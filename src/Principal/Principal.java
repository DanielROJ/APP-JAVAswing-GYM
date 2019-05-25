
package Principal;

import Controlador.ControladorLogin;
import Vista.VistaInicial;
import java.io.IOException;

/**
 * @since 10-05-2017
 * @author Daniel Rojas - danielroj
 */
public class Principal {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        VistaInicial s=new VistaInicial();
        ControladorLogin d=new ControladorLogin(s);
    }
}
