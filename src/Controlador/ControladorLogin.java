/*
 *Permite evaluar el ingreso de usuario o medicos si existen para dejar su Ingreso
 */
package Controlador;

import Modelo.DAO.HistoriaDAO;
import Modelo.DAO.MedicoDAO;
import Modelo.Diagnostico;
import Modelo.HistoriaMedica;
import Modelo.Medico;
import Modelo.Persona;
import Vista.VistaInicial;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * @since 10-05-2017
 * @author Daniel Rojas - danielroj
 */
public class ControladorLogin implements ActionListener {
    
    VistaInicial vista;
    Persona persona;
    
    public ControladorLogin(VistaInicial vista) throws IOException, ClassNotFoundException {
        MedicoDAO.leerArchivo();
        HistoriaDAO.leerArchivo();
        this.vista = vista;
        this.vista.boton.addActionListener(this);
        this.vista.entrada1 = vista.entrada1;
        this.vista.exit.addActionListener(this);
        this.vista.entradaC = vista.entradaC;
        this.vista.radio1.addActionListener(this);
        this.vista.radio2.addActionListener(this);
        this.vista.grupo1 = vista.grupo1;
        this.vista.setVisible(true);
        this.vista.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (vista.boton.equals(ae.getSource())) {
            
            if (Exepciones.EspacioBlanco(vista.entrada1.getText(), vista.entradaC.getPassword()) != true) {
                vista.entrada1.setText(null);
                vista.entradaC.setText(null);
            } else if (vista.radio1.isSelected()) {
                String usuario = vista.entrada1.getText();
                persona = MedicoDAO.buscarMedico(usuario);
                if (persona.getNombre().equals(usuario) == false) {
                    JOptionPane.showMessageDialog(null, "Medico No Registrado");
                    vista.entrada1.setText(null);
                    vista.entradaC.setText(null);
                } else if (Exepciones.ValidarPassword(vista.entradaC.getPassword(), persona)) {
                    vista.setVisible(false);
                    Control.ControladorMed((Medico) persona);
                } else {
                    JOptionPane.showMessageDialog(null, "Password Incorrecta");
                    vista.entradaC.setText(null);
                }
            } else if (vista.radio2.isSelected()) {
                String usuario = vista.entrada1.getText();
              HistoriaMedica z=HistoriaDAO.buscarProducto(0,usuario );    
                if (z==null) {
               JOptionPane.showMessageDialog(null, "Persona No Registrada,Un medico tiene que registrarla");
               vista.entrada1.setText(null);
               vista.entradaC.setText(null);
                }else{    
                Diagnostico x=z.getDiagsnostico().get(0);
              
                if (x.getPersona().getNombre()==(usuario)) {
                    JOptionPane.showMessageDialog(null, "Persona No Registrada,Un medico tiene que registrarla");
                    vista.entrada1.setText(null);
                    vista.entradaC.setText(null);
                } else {
                    persona = x.getPersona();
                    
                    if (Exepciones.ValidarPassword(vista.entradaC.getPassword(), persona)) {
                        vista.setVisible(false);
                        Control.ControladorUsuario(z);
                    } else {
                        JOptionPane.showMessageDialog(null, "Password Incorrecta");
                        vista.entradaC.setText(null);
                    }
                }
                
                }
            } else {
                JOptionPane.showMessageDialog(null, "No ha seleccionado Rol de usuario");
            }
        }
        
        if (ae.getSource().equals(vista.exit)) {
            System.exit(0);
        }
        
    }
    
}
