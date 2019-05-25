package Modelo.DAO;

import Modelo.Medico;
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
public class MedicoDAO {

    private static Medico medico;
    private static final String path = "MEDICOS.obj";
    private static ArrayList<Medico> listaMedico;

    //Carga el archivo de contactos de el dispositivo de almacenamiento a la memoria dinamica
    public static void leerArchivo() throws IOException, ClassNotFoundException {

        try {
            listaMedico = new ArrayList<Medico>();
            ObjectInputStream fileIn = new ObjectInputStream(new FileInputStream(path));
            listaMedico = (ArrayList) fileIn.readObject();
            fileIn.close();
        } catch (FileNotFoundException e) {
            listaMedico = new ArrayList<Medico>();
        }
    }

    public static void nuevoMedico(Medico medico) {
        listaMedico.add(medico);
        JOptionPane.showMessageDialog(null, "Un Medico fue registrado");
    }

    public static Medico buscarMedico(String nombre) {
        medico = null;
        Iterator<Medico> contactoIterator = listaMedico.iterator();
        while (contactoIterator.hasNext()) {

            medico = contactoIterator.next();

            if (medico.getNombre().equals(nombre)) {
                break;
            }
        }
        return medico;
    }

    public static void modificarMedico(int indice, Medico medico) {
        listaMedico.set(indice, medico);
        JOptionPane.showMessageDialog(null, "Un Medico se ha Modificado");
    }

    public static void borrarMedico(Medico medico) {
        listaMedico.remove(medico);
        JOptionPane.showMessageDialog(null, "Un Medico se ha Eliminado");
    }

    public static int obtenerProveedor(Medico medico) {
        return listaMedico.indexOf(medico);
    }

    public static ArrayList<Medico> obtenerlistaMedico() {
        return listaMedico;
    }

    public static void escribirArchivo() throws IOException {
        ObjectOutputStream fileO = new ObjectOutputStream(new FileOutputStream(path));
        fileO.writeObject(listaMedico);

    }
}
