/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente_Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @since 10-05-2017
 * @author Daniel Rojas - danielroj
 */
public class Conexion {
private final int PUERTO = 1027;
private final String HOST = "localhost";
protected String mensajeservidor;
protected ServerSocket ss;
protected Socket cs;
protected DataOutputStream salidaServidor;
protected DataInputStream salidaCliente;
      

public Conexion (String tipo) throws IOException {
    if (tipo.equalsIgnoreCase("servidor")) {
   ss = new ServerSocket(PUERTO);
   cs = new Socket();
}
    else{
        cs= new Socket(HOST, PUERTO);
    }
}
}