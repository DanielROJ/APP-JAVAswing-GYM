/*
 Esta clase me permite buscar los diagnosticos de un usuario agragarle un diagnostico y eliminar.
 */
package Controlador;

import Modelo.DAO.HistoriaDAO;
import Modelo.HistoriaMedica;
import Vista.VistaBuscaHistorial;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Rojas - danielroj
 */
public class ControladorBusqueda implements ActionListener {

    VistaBuscaHistorial vista;
    HistoriaMedica x;

    public ControladorBusqueda(VistaBuscaHistorial vista) throws IOException, ClassNotFoundException {
        HistoriaDAO.leerArchivo();
        this.vista = vista;
        this.vista.boton.addActionListener(this);
        this.vista.exit.addActionListener(this);
        this.vista.entrada1 = vista.entrada1;
        this.vista.combo.addActionListener(this);
        this.vista.setVisible(true);
        this.vista.setLocationRelativeTo(null);
        this.vista.nuevo.addActionListener(this);
   this.vista.nuevo.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(vista.boton)) {
            long a = Exepciones.ValidaLong(vista.entrada1.getText());
            if (a != 0) {
                x = HistoriaDAO.buscarProducto(a,null);
       this.vista.nuevo.setEnabled(false);
                if (x != null) {
                    if (x.BuscarP() != null) {
                        if (x.BuscarP().getPersona().getIdentificacion() == a) {
                          Control.i=HistoriaDAO.obtenerProducto(x);
                            String[] f = new String[x.getDiagsnostico().size()];
                            for (int i = 0; i < x.getDiagsnostico().size(); i++) {
                                f[i] = x.getDiagsnostico().get(i).getFecha();
                            }
                            this.vista.combo.setModel(ArmaComponent.LLemarCombo(f, null));
                            vista.nuevo.setEnabled(true);
                        } 
                }
                }else {
                    vista.entrada1.setText(null);
                    JOptionPane.showMessageDialog(null, "No se encuertra el Paciente");
                }
                }else {
                JOptionPane.showMessageDialog(null, "Ingrese Dato Numerico");
                   this.vista.nuevo.setEnabled(false);
                vista.entrada1.setText(null);
            }
            } 
        


        if (ae.getSource().equals(vista.exit)) {
            this.vista.setVisible(false);
            Control.ControladorM();
        }

        if (ae.getSource().equals(vista.combo)) {
            int a = vista.combo.getSelectedIndex();
            this.vista.setVisible(false);
            Control.ControladorHistoriaM2(x, x.getDiagsnostico().get(a));
        }
        
        if(ae.getSource().equals(vista.nuevo)){
            this.vista.setVisible(false);
            Control.ControladorHistoriaMedica(x.getDiagsnostico().get(0).getPersona());
        }
        }
}




