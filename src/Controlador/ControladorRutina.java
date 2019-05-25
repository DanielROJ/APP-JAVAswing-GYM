/*
 Permite que el usuario pueda ver la los ejercicios asignados a la rutina determinda. 
 */
package Controlador;

import Modelo.Ejercicio;
import Modelo.Rutina;
import Vista.VistaRutina;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

/**
 * @since 10-05-2017
 * @author Daniel Rojas - danielroj
 */
public class ControladorRutina implements ActionListener {
VistaRutina vista;
Rutina rutina;

    public ControladorRutina(VistaRutina vista, Rutina rutina) {
        this.vista = vista;
        this.rutina = rutina;
        this.vista.comboX.addActionListener(this);
        this.vista.comboX.setModel(ArmaComponent.LLemarCombo(null, rutina.getEjercicio()));
        this.vista.entrada1=vista.entrada1;
        this.vista.entrada2=vista.entrada2;
        this.vista.entrada3=vista.entrada3;
        this.vista.entrada4=vista.entrada4;
        this.vista.label=vista.label;
        this.vista.texto=vista.texto;
        this.vista.jButton1.addActionListener(this);
        this.vista.setVisible(true);
        this.vista.setLocationRelativeTo(null);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
      if(ae.getSource().equals(vista.comboX)){
          int a =vista.comboX.getSelectedIndex();
          Ejercicio e=rutina.getEjercicio().get(a);
        this.vista.entrada1.setText(e.getNombre());
        this.vista.entrada2.setText(e.getMusculo());
        this.vista.entrada3.setText(String.valueOf(e.getnRepeticiones()));
        this.vista.entrada4.setText(String.valueOf(e.getnSerie()));
        this.vista.texto.setText(rutina.getDecripcion());
        ImageIcon i=new ImageIcon(e.getDiImagen());
        this.vista.label.setIcon(i);
      }
      
      if(ae.getSource().equals(vista.jButton1)){
          this.vista.setVisible(false);
          Control.ControladorUsuario(Control.historia);
      }
      
      
    }
    
}
