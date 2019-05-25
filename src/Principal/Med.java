
package Principal;

import Modelo.DAO.MedicoDAO;
import Modelo.Medico;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author danie
 */
public class Med {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MedicoDAO.leerArchivo();
        Scanner dato =new Scanner(System.in);
        
        System.out.println("nombre");  
        String n=dato.next();
        System.out.println("identificacion");
        long g=dato.nextLong();
        System.out.println("nProfesionla");
        int prto=dato.nextInt();
        System.out.println("especialidad");
        String es=dato.next();
        System.out.println("Correo");
        String b=dato.next();
        
        Medico m=new Medico(prto,es,n,g,b);
        MedicoDAO.nuevoMedico(m);
        MedicoDAO.escribirArchivo();
        
    }
}
