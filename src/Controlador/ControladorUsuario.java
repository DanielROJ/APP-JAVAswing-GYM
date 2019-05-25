/*
 Permite el manejo de la vista usuario ,tambien el manejo de las rutina que posea para cargarlas
 */
package Controlador;

import Modelo.HistoriaMedica;
import Vista.VistaUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @since 10-05-2017
 * @author Daniel Rojas - danielroj
 */
public class ControladorUsuario implements ActionListener {

    VistaUsuario vista;
    HistoriaMedica histo;

    public ControladorUsuario(VistaUsuario vista, HistoriaMedica h) {
        this.vista = vista;
        this.histo = h;
        this.vista.ingresar.addActionListener(this);
        this.vista.combo.addActionListener(this);
        this.vista.jButtonSallir.addActionListener(this);
        this.vista.area1 = vista.area1;
        this.vista.jTextFieldNombre.setText(h.getDiagsnostico().get(0).getPersona().getNombre());
        this.vista.setVisible(true);
        this.vista.setLocationRelativeTo(null);
        String[] c = new String[histo.getDiagsnostico().size()];
        for (int i = 0; i < histo.getDiagsnostico().size(); i++) {
            c[i] = histo.getDiagsnostico().get(i).getRutina().getTipoRutina();
        }
        this.vista.combo.setModel(ArmaComponent.LLemarCombo(c, null));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource().equals(vista.combo)) {
            int a = vista.combo.getSelectedIndex();
            vista.area1.setText(histo.getDiagsnostico().get(a).getRutina().getDecripcion());
        }

        if (ae.getSource().equals(vista.ingresar)) {
         int a=vista.combo.getSelectedIndex();
         this.vista.setVisible(false);
         Control.ControladorRutinaUsuario(histo.getDiagsnostico().get(a).getRutina());
        }
        
        if(ae.getSource().equals(vista.jButtonSallir)){
            this.vista.setVisible(false);
            Control.ControladorInicial();
        }

    }

}
