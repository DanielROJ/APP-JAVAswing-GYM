/*
Permite el manejo de la funciones que tiene el medico con la respectiva informacion de los usuarios
 */
package Controlador;

import Modelo.Medico;
import Vista.VistaDoctor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @since 10-05-2017
 * @author Daniel Rojas - danielroj
 */
public class ControladorMedico implements ActionListener {

    VistaDoctor vista;
    Medico medico;

    public ControladorMedico(VistaDoctor vista, Medico medico) {
        this.vista = vista;
        this.medico = medico;
        this.vista.setVisible(true);
        this.vista.menuP1.addActionListener(this);
        this.vista.menuItem1.addActionListener(this);
        this.vista.menuItem3.addActionListener(this);
        this.vista.menuP2.addActionListener(this);
        this.vista.menuBar = vista.menuBar;
        this.vista.entrada1.setText(medico.getNombre());
        this.vista.entrada3.setText(String.valueOf(medico.getIdentificacion()));
        this.vista.entrada2.setText(medico.getCorreo());
        this.vista.entrada4.setText(String.valueOf(medico.getIdProfesional()));
        this.vista.entrada5.setText(medico.getEspecialidad());
        this.vista.entrada1.setEditable(false);
        this.vista.entrada3.setEditable(false);
        this.vista.entrada4.setEditable(false);
        this.vista.entrada5.setEditable(false);
        this.vista.entrada2.setEnabled(false);
        this.vista.salir.addActionListener(this);
        this.vista.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(vista.menuItem1)) {
            this.vista.setVisible(false);
          Control.ControladorRegistro();
        }
          
        if (ae.getSource().equals(vista.menuItem3)) {
            this.vista.setVisible(false);
            Control.ControladorBusqueda();
        }
        if (ae.getSource().equals(vista.salir)) {
            this.vista.setVisible(false);
            Control.ControladorInicial();
        }
    }
}

