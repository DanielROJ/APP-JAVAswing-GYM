/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente_Servidor;

import Controlador.ControladorLogin;
import Vista.VistaInicial;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @since 10-05-2017
 * @author Daniel Rojas - danielroj
 */
public class Servidor extends Conexion implements Runnable {

    public Servidor() throws IOException {
        super("servidor");
    }

    synchronized public void startServer() throws IOException {
        while (true) {
            try {

                cs = ss.accept();
                salidaServidor = new  DataOutputStream(cs.getOutputStream());
                VistaInicial s = new VistaInicial();
                ControladorLogin d = new ControladorLogin(s);
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    @Override
    public void run() {
        try {
            startServer();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void vamo() {
        new Thread(Servidor.this).start();
    }

}
