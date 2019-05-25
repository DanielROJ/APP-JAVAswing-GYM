/*
 Permite crear las especificaciones medicas de cada usuario. 
 */
package Controlador;

import Modelo.DAO.HistoriaDAO;
import Modelo.Diagnostico;
import Modelo.HistoriaMedica;
import Modelo.Persona;
import Vista.VistaHistoriaClinica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * @since 10-05-2017
 * @author Daniel Rojas - danielroj
 */
public class ControladorHistoriaClinica implements ActionListener {

    HistoriaMedica p;
    Diagnostico c;
    VistaHistoriaClinica vista;
    Persona persona;
    String[] k = {"O+", "O-", "A+", "A-", "B+", "AB-", "AB+"};

    public ControladorHistoriaClinica(VistaHistoriaClinica vista, Persona persona) {
        this.vista = vista;
        this.persona = persona;
        this.vista.area1 = vista.area1;
        this.vista.area2 = vista.area2;
        this.vista.comboGrupo.setModel(ArmaComponent.LLemarCombo(k, null));
        this.vista.entradaCarrera.setText(persona.getCarrera());
        this.vista.entradaCarrera.setEditable(false);
        this.vista.entradaEmail.setText(persona.getCorreo());
        this.vista.entradaEmail.setEditable(false);
        this.vista.entradaIdentifi.setText(String.valueOf(persona.getIdentificacion()));
        this.vista.entradaIdentifi.setEditable(false);
        this.vista.entradaPeso = vista.entradaPeso;
        this.vista.entradaPeso.setEditable(true);
        this.vista.entradaAltura = vista.entradaAltura;
        this.vista.entradaEdad = vista.entradaEdad;
        this.vista.entradaNombre.setText(persona.getNombre());
        this.vista.entradaNombre.setEditable(false);
        this.vista.menuBar = vista.menuBar;
        this.vista.menu3.setEnabled(false);
        this.vista.guardar.addActionListener(this);
        this.vista.volver.addActionListener(this);
        this.vista.setVisible(true);
        this.vista.setLocationRelativeTo(null);
    }

    public ControladorHistoriaClinica(VistaHistoriaClinica vista, HistoriaMedica a, Diagnostico di) throws IOException, ClassNotFoundException {
        HistoriaDAO.leerArchivo();
        this.p = a;
        this.c = di;
        Persona x = di.getPersona();
        this.vista = vista;
        String[] z = {di.getGrupoSanguineo()};
        this.vista.comboGrupo.setModel(ArmaComponent.LLemarCombo(z, null));
        this.vista.entradaNombre.setText(x.getNombre());
        this.vista.entradaNombre.setEditable(false);
        this.vista.entradaIdentifi.setText(String.valueOf(x.getIdentificacion()));
        this.vista.entradaIdentifi.setEditable(false);
        this.vista.entrdaFecha.setText(di.getFecha());
        this.vista.entrdaFecha.setEditable(false);
        this.vista.entradaCarrera.setText(x.getCarrera());
        this.vista.entradaCarrera.setEditable(false);
        this.vista.entradaEdad.setText(String.valueOf(di.getEdad()));
        this.vista.entradaAltura.setText(String.valueOf(di.getAltura()));
        this.vista.entradaAltura.setEditable(false);
        this.vista.entradaEdad.setEditable(false);
        this.vista.entradaEmail.setText(x.getCorreo());
        this.vista.entradaEmail.setEditable(false);
        this.vista.entradaPeso.setText(String.valueOf(di.getPeso()));
        this.vista.entradaPeso.setEditable(false);
        this.vista.area2.setText(di.getObservacion() + "\n" + "Genero Paciente: " + di.getGenero());
        this.vista.area2.setEditable(false);
        this.vista.area1.setText(di.getLesionesEnfermedad());
        this.vista.area1.setEditable(false);
        this.vista.comboGrupo.setEnabled(false);
        this.vista.l.setEnabled(false);
        this.vista.mn.setEnabled(false);
        this.vista.item1.addActionListener(this);
        this.vista.item2.addActionListener(this);
        this.vista.setEnabled(true);
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }

    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(vista.guardar)) {
            float altura = Exepciones.ValidaFloat(vista.entradaAltura.getText());
            float peso = Exepciones.ValidaFloat(vista.entradaPeso.getText());
            int edad = Exepciones.ValidaInt(vista.entradaEdad.getText());
            String fecha = vista.entrdaFecha.getText();
            String sangre = (String) vista.comboGrupo.getSelectedItem();
            char g = 0;
            if (vista.radio1.isSelected()) {
                g = 'F';
            } else {
                if (vista.radio2.isSelected()) {
                g = 'M';
            } else {
                JOptionPane.showMessageDialog(null, "Escojer Algun genero");
            }
            }
            if (altura == 0 || peso == 0 || edad == 0 || fecha.equals("")) {
                JOptionPane.showMessageDialog(null, "Dato Encontrado Invalido :(Fecha,Edad,Altura,Peso");
                vista.entradaEdad.setText(null);
                vista.entradaAltura.setText(null);
                vista.entradaPeso.setText(null);
                vista.entrdaFecha.setText(null);
            } else {
                Diagnostico d = new Diagnostico(persona, vista.area1.getText(), edad, sangre, vista.area2.getText(), peso, altura, g, vista.entrdaFecha.getText());
                this.vista.setVisible(false);            
                    Control.ControladorRegistroR(d);
            }
        }
        if (ae.getSource().equals(vista.item1)) {
           p.BorrarDiagnostico(c);
            JOptionPane.showMessageDialog(null, "Se borro el diagnostico ya puede salir");
            HistoriaDAO.modificarProducto((Control.i), p);
            HistoriaDAO.escribirArchivo();  
            vista.item1.setEnabled(false);
        }
        if (ae.getSource().equals(vista.volver)) {
            this.vista.setVisible(false);
            Control.ControladorRegistro();
        }
        
        if(ae.getSource().equals(vista.item2)){
            this.vista.setVisible(false);
            Control.ControladorM();
        }
        
        
    }
}
