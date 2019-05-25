package Modelo.DAO;

import Controlador.ControladorBusqueda;
import Modelo.HistoriaMedica;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @since 10-05-2017
 * @author Daniel Rojas - danielroj
 */
public class HistoriaDAO {

    private static HistoriaMedica diag;
    private static int indice;
    private static final String path = "Historias.obj";
    private static ArrayList<HistoriaMedica> listaDiagnostico;

    //Carga el archivo de contactos de el dispositivo de almacenamiento a la memoria dinamica
    public static void leerArchivo() throws IOException, ClassNotFoundException {

        try {
            listaDiagnostico = new ArrayList<HistoriaMedica>();
            ObjectInputStream fileIn = new ObjectInputStream(new FileInputStream(path));
            listaDiagnostico = (ArrayList) fileIn.readObject();
            fileIn.close();
        } catch (FileNotFoundException e) {
            listaDiagnostico = new ArrayList<HistoriaMedica>();
        }
    }

    public static void nuevoDiagnostico(HistoriaMedica dig) {
        listaDiagnostico.add(dig);
    }

    public static HistoriaMedica buscarProducto(long id, String s) {
        diag = null;
        indice = 0;
        int i = 0;

        for (i = 0; i < listaDiagnostico.size(); i++) {
            try {
                if (listaDiagnostico.get(i).BuscarP().getPersona().getIdentificacion() == id) {
                    diag = listaDiagnostico.get(i);
                    break;
                }
                if (listaDiagnostico.get(i).BuscarP().getPersona().getNombre() == null ? s == null : listaDiagnostico.get(i).BuscarP().getPersona().getNombre().equals(s)) {
                    diag = listaDiagnostico.get(i);
                    break;
                }
            } catch (NullPointerException e) {
                i++;
            }
        }
        return diag;
    }

    public static void modificarProducto(int indice, HistoriaMedica diag) {
        listaDiagnostico.set(indice, diag);

    }

    public static void borrarProducto(HistoriaMedica diag) {
        listaDiagnostico.remove(diag);
        JOptionPane.showMessageDialog(null, "Una Historia se ha Eliminado");
    }

    public static int obtenerProducto(HistoriaMedica dia) {
        return listaDiagnostico.indexOf(dia);
    }

    public static ArrayList<HistoriaMedica> obtenerlistaProducto() {
        return listaDiagnostico;
    }

    public static void escribirArchivo() {
        try {
            ObjectOutputStream fileO = new ObjectOutputStream(new FileOutputStream(path));
            fileO.writeObject(listaDiagnostico);
        } catch (IOException ex) {
            Logger.getLogger(ControladorBusqueda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
