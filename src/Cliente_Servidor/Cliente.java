/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente_Servidor;


import java.io.DataInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
        
/**
 * @since 10-05-2017
 * @author Daniel Rojas - danielroj
 */
public class Cliente extends Conexion implements Runnable{
  
    public Cliente() throws IOException{
        super("cliente");
    }
    
synchronized public void startClient() throws IOException{
    try{
        salidaCliente= new DataInputStream(cs.getInputStream());
  
    }
    catch(Exception e){
        System.out.println(e.getMessage());
    }
}

    @Override
    public void run() {
        try {
            startClient();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public void Hilo(){
        new Thread(Cliente.this).start();
    }
    
}
