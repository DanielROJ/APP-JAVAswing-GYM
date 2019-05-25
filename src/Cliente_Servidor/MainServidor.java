/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente_Servidor;
import java.io.IOException;
/**
 * @since 10-05-2017
 * @author Daniel Rojas - danielroj
 */
public class MainServidor {
    public static void main(String[] args) throws IOException {
        Servidor serv = new Servidor();
        System.out.println("iniciando servidor \n");
        serv.vamo();
    }
    
}
