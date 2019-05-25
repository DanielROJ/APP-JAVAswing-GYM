
package Modelo.DAO;

import Modelo.Ejercicio;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 * @since 10-05-2017
 * @author Daniel Rojas - danielroj
 */
public class EjercicioDAO {

    private static Ejercicio ejercicio;
    private static final String path = "EJERCICIO.obj";
    private static ArrayList<Ejercicio> listaEjercicio;

    //Carga el archivo de contactos de el dispositivo de almacenamiento a la memoria dinamica
    public static void leerArchivo() throws IOException, ClassNotFoundException {

        try {
            listaEjercicio = new ArrayList<>();
            ObjectInputStream fileIn = new ObjectInputStream(new FileInputStream(path));
         listaEjercicio = (ArrayList) fileIn.readObject();
            fileIn.close();
        } catch (FileNotFoundException e) {
            listaEjercicio = new ArrayList<Ejercicio>();
        }
    }

    public static void nuevoEjercicio(Ejercicio ejercicio) {
        listaEjercicio.add(ejercicio);
        JOptionPane.showMessageDialog(null, "Se agrego un Ejercicio Al archivo");
    }

    public static Ejercicio buscarEjercicio(String nombre) {
        ejercicio = null;

        Iterator<Ejercicio> ClienteIterator = listaEjercicio.iterator();

        while (ClienteIterator.hasNext()) {

            ejercicio = ClienteIterator.next();

            if (ejercicio.getNombre() == nombre) {
                break;
            }

        }
        return ejercicio;
    }

    public static void modificarEjercicio(int indice, Ejercicio ejercicio) {
      listaEjercicio.set(indice, ejercicio);
        JOptionPane.showMessageDialog(null, "Un Ejercicio se ha Modificado");
    }

    public static void borrarEjercicio(Ejercicio ejercicio) {
        listaEjercicio.remove(ejercicio);
        JOptionPane.showMessageDialog(null, "Un Ejercicio  se ha Eliminado");
    }

    public static int obtenerEjercicio(Ejercicio ejercicio) {
        return listaEjercicio.indexOf(ejercicio);
    }

    public static ArrayList<Ejercicio> obtenerlistaEjercicio() {
        return listaEjercicio;
    }

    public static void escribirArchivo() throws IOException {
        ObjectOutputStream fileO = new ObjectOutputStream(new FileOutputStream(path));
        fileO.writeObject(listaEjercicio);

    }
}
