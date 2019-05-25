package Controlador;

import Modelo.DAO.HistoriaDAO;
import Modelo.Diagnostico;
import Modelo.HistoriaMedica;
import Modelo.Medico;
import Modelo.Persona;
import Modelo.Rutina;
import Vista.VistaBuscaHistorial;
import Vista.VistaDoctor;
import Vista.VistaHistoriaClinica;
import Vista.VistaInicial;
import Vista.VistaRegistro;
import Vista.VistaRegistroR;
import Vista.VistaRutina;
import Vista.VistaUsuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @since 10-05-2017
 * @author Daniel Rojas - danielroj
 */
public class Control {

    static Medico x;
    static HistoriaMedica historia;
    static int i;

    public static void ControladorMed(Medico a) {
        x = a;
        VistaDoctor v = new VistaDoctor();
        ControladorMedico d = new ControladorMedico(v, x);
    }

    public static void ControladorUsuario(HistoriaMedica a) {
        historia = a;
        VistaUsuario d = new VistaUsuario();
        ControladorUsuario c = new ControladorUsuario(d, a);
    }

    public static void ControladorInicial() {
        VistaInicial x = new VistaInicial();
        try {
            ControladorLogin control = new ControladorLogin(x);
        } catch (IOException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void ControladorM() {
        ControladorMed(x);
    }

    public static void ControladorBusqueda() {
        VistaBuscaHistorial v = new VistaBuscaHistorial();
        try {
            ControladorBusqueda c = new ControladorBusqueda(v);
        } catch (IOException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void ControladorRegistro() {
        VistaRegistro v = new VistaRegistro();
        ControladorRegistro c = new ControladorRegistro(v);
    }

    public static void ControladorHistoriaMedica(Persona a) {
        VistaHistoriaClinica c = new VistaHistoriaClinica();
        ControladorHistoriaClinica x = new ControladorHistoriaClinica(c, a);
    }

    public static void ControladorHistoriaM2(HistoriaMedica a, Diagnostico b) {
        VistaHistoriaClinica v = new VistaHistoriaClinica();
        try {
            ControladorHistoriaClinica c = new ControladorHistoriaClinica(v, a, b);
        } catch (IOException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void ControladorRegistroR(Diagnostico z) {
        VistaRegistroR v = new VistaRegistroR();
        try {
            ControladorRegistroRutina c = new ControladorRegistroRutina(v, z);
        } catch (IOException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void NuevaHistoria(HistoriaMedica d) {
        try {
            HistoriaDAO.leerArchivo();
        } catch (IOException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }

        HistoriaDAO.nuevoDiagnostico(d);
        Indice(HistoriaDAO.obtenerProducto(d));

        HistoriaDAO.escribirArchivo();

    }

    public static void Indice(int a) {
        i = a;
    }

    public static void ControladorRutinaUsuario(Rutina a) {
        VistaRutina v = new VistaRutina();
        ControladorRutina c = new ControladorRutina(v, a);
    }

}
