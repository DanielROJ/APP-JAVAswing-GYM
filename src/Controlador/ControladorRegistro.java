/*
 Permite el registro de los datos basicos del usuario
 */
package Controlador;

import Modelo.HistoriaMedica;
import Modelo.Persona;
import Vista.VistaRegistro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @since 10-05-2017
 * @author Daniel Rojas - danielroj
 */
public class ControladorRegistro implements ActionListener {

    VistaRegistro vista;
    Persona persona;
    
    String[] s = {"Derecho", "Ingenieria", "Conaduria publica", "Psicologia", "Comunicacion"};

    public ControladorRegistro(VistaRegistro vista) {
        this.vista = vista;
        this.vista.entrada1 = vista.entrada1;
        this.vista.entrada2 = vista.entrada2;
        this.vista.entrada3 = vista.entrada3;
        this.vista.historia.addActionListener(this);
        this.vista.salir.addActionListener(this);
        this.vista.combo.addActionListener(this);
        this.vista.combo.setModel(ArmaComponent.LLemarCombo(s,null));
        this.vista.setVisible(true);
        this.vista.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(vista.salir)) {
            this.vista.setVisible(false);
            Control.ControladorM();
        }
        
        if (ae.getSource().equals(vista.historia)) {
            
            if (Exepciones.Blanco(vista.entrada1.getText(), vista.entrada2.getText(), vista.entrada3.getText())) {
                String nombre = vista.entrada1.getText();
                long id=Exepciones.ValidaLong(vista.entrada2.getText());
                if(id==0){
                    vista.entrada2.setText(null);
                }else{
                    String correo=vista.entrada3.getText();
                    String carrera=(String) vista.combo.getSelectedItem();
                    persona=new Persona(nombre,id,correo);
                    persona.setCarrera(carrera);
                   HistoriaMedica d=new HistoriaMedica(Control.x);
                    Control.NuevaHistoria(d);
                    this.vista.setVisible(false);
                    Control.ControladorHistoriaMedica(persona);
                }
            } else {
                vista.entrada1.setText(null);
                vista.entrada2.setText(null);
                vista.entrada3.setText(null);}
            } 
    }
}
