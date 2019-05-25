/*

 */
package Controlador;

import Modelo.DAO.EjercicioDAO;
import Modelo.DAO.HistoriaDAO;
import Modelo.DAO.RutinaDAO;
import Modelo.Diagnostico;
import Modelo.Ejercicio;
import Modelo.HistoriaMedica;
import Modelo.Rutina;
import Vista.VistaRegistroR;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @since 10-05-2017
 * @author Daniel Rojas - danielroj
 */
public class ControladorRegistroRutina implements ActionListener {

    VistaRegistroR vista;
    Diagnostico di;
    DefaultTableModel model;
    Rutina p = new Rutina();
    ArrayList<Ejercicio> x;
    ArrayList<HistoriaMedica> h;
  
    public ControladorRegistroRutina(VistaRegistroR vista, Diagnostico di) throws IOException, ClassNotFoundException {
        HistoriaDAO.leerArchivo();
        RutinaDAO.leerArchivo();
        EjercicioDAO.leerArchivo();
        x = EjercicioDAO.obtenerlistaEjercicio();
        h = HistoriaDAO.obtenerlistaProducto();
        this.vista = vista;
        this.di = di;
        this.model = (DefaultTableModel) vista.tabla.getModel();
        this.vista.guardar.addActionListener(this);
        this.vista.entrda1 = vista.entrda1;
        this.vista.entrada2 = vista.entrada2;
        this.vista.entrada3 = vista.entrada3;
        this.vista.entrada4 = vista.entrada4;
        this.vista.agregar.addActionListener(this);
        this.vista.setVisible(true);
        this.vista.setLocationRelativeTo(null);
        this.vista.check1.addActionListener(this);
        this.vista.check2.addActionListener(this);
        this.vista.area1 = vista.area1;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
 
 
        if (vista.check1.isSelected()) {
            model = ArmaComponent.LlenarTabla(x, model,false);
        } else {
            model = ArmaComponent.LlenarTabla(x, model,true);
        }
        if (ae.getSource().equals(vista.guardar)) {
            if (Exepciones.Blanco(vista.area1.getText(), vista.entrada4.getText(), "eeee")) {
                p.setTipoRutina(vista.entrada4.getText());
                p.setDecripcion(vista.area1.getText());
                RutinaDAO.nuevaRutina(p);
                di.setRutina(p);
                int i = Control.i;
                HistoriaMedica z = h.get(i);
                z.AgregaDiagnostico(di);
                HistoriaDAO.modificarProducto((i), z);
                HistoriaDAO.escribirArchivo();
                this.vista.setVisible(false);
                Control.ControladorM();
            } else {
                JOptionPane.showMessageDialog(null, "Informacion De La Rutina En Blanco");
            }
        }

        if (ae.getSource().equals(vista.agregar)) {
            int a = Exepciones.ValidaInt(vista.entrda1.getText());
            int b = Exepciones.ValidaInt(vista.entrada2.getText());
            int c = Exepciones.ValidaInt(vista.entrada3.getText());
            if (a != 0 && b != 0 && c != 0) {
                if (a <= model.getRowCount() && a > 0 && b > 0 && c > 0) {
                    a = a - 1;
                    Ejercicio l = null;
                    if (vista.check1.isSelected()) {
                        l = x.get(a);
                    } else {
                        a=9-a;
                        l = x.get(a);
                    }
                    l.setnRepeticiones(b);
                    l.setnSerie(c);
                    p.setEjercicio(l);
                    vista.entrda1.setText(null);
                    vista.entrada2.setText(null);
                    vista.entrada3.setText(null);
                    JOptionPane.showMessageDialog(null, "Un Ejercicio Se Agrego A la rutina");
                } else {
                    JOptionPane.showMessageDialog(null, "Error En la Creacion de Ejercicio");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingreso de dato Invalido");
            }
        }
    }
}
