/*
 * Esta clase permite LLenar los componentes (coboBox- Tables) de la aplicacion
 */
package Controlador;

import Modelo.Ejercicio;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 * @since 10-05-2017
 * @author Daniel Rojas - danielroj
 */
public class ArmaComponent {

    public static DefaultComboBoxModel LLemarCombo(Object[] a, ArrayList<Ejercicio> b) {

        DefaultComboBoxModel d = new DefaultComboBoxModel();

        if (a != null) {
            for (int i = 0; i < a.length; i++) {
                d.addElement(a[i]);
            }
            return d;
        } else {
            for (Ejercicio ejercicio : b) {
                d.addElement(ejercicio.getNombre());
            }
            return d;
        }

    }

    public static DefaultTableModel LlenarTabla(ArrayList<Ejercicio> b, DefaultTableModel z, boolean x) {
        System.out.println("nombreee oculto " + b.get(0).getNombre());

        if (x) {
            while (z.getRowCount() != 0) {
                z.removeRow(0);
            }
            int o = 0;
            for (Ejercicio ejercicio : b) {
                if (ejercicio.getMaquina() == null) {
                    o++;
                    Object[] fila = {ejercicio.getNombre(), o};
                    z.addRow(fila);
                }

            }
        } else {
            while (z.getRowCount() != 0) {
                z.removeRow(0);
            }
            int o = 0;
            for (Ejercicio ejercicio : b) {
                if (ejercicio.getMaquina() != null) {
                    o++;
                    Object[] fila = {ejercicio.getNombre(), o};
                    z.addRow(fila);
                }

            }
        }

        return z;
    }

}
