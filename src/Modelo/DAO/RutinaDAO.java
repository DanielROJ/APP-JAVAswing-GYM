
package Modelo.DAO;;


import Modelo.Rutina;
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
public class RutinaDAO {

    private static Rutina rutina;
    private static final String path = "RUTINAS.obj";
    private static ArrayList<Rutina> listaRutina;

    //Carga el archivo de contactos de el dispositivo de almacenamiento a la memoria dinamica
    public static void leerArchivo() throws IOException, ClassNotFoundException {

        try {
             listaRutina = new ArrayList<Rutina>();
            ObjectInputStream fileIn = new ObjectInputStream(new FileInputStream(path));
            listaRutina = (ArrayList) fileIn.readObject();
            fileIn.close();
        } catch (FileNotFoundException e) {
             listaRutina= new ArrayList<Rutina>();
        }
    }

    public static void nuevaRutina(Rutina rutina) {
         listaRutina.add(rutina);
        JOptionPane.showMessageDialog(null, "Una nueva Rutina se ha Agregado");
    }

    public static Rutina buscarRutina(String tipo) {
        rutina = null;
        Iterator<Rutina> ciudadIterator =  listaRutina.iterator();
        while (ciudadIterator.hasNext()) {

            rutina = ciudadIterator.next();

            if (rutina.getTipoRutina().equals(tipo)) {
                break;
            }
        }
        return rutina;
    }

    public static void modificarRutina(int indice, Rutina rutina) {
         listaRutina.set(indice, rutina);
        JOptionPane.showMessageDialog(null, "Una Rutina fue Modificada");
    }

    public static void borrarRutina(Rutina rutina) {
         listaRutina.remove(rutina);
        JOptionPane.showMessageDialog(null, "Una Rutina fue Eliminada");
    }

    public static int obtenerRutina(Rutina rutina) {
        return  listaRutina.indexOf(rutina);
    }

    public static ArrayList<Rutina> obtenerlistaRutina() {
        return  listaRutina;
    }

    public static void escribirArchivo() throws IOException {
      
        ObjectOutputStream fileO = new ObjectOutputStream(new FileOutputStream(path));
        fileO.writeObject(listaRutina);
      
    }
}
