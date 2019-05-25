/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Modelo.DAO.EjercicioDAO;
import Modelo.Ejercicio;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class ActualizaDir {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner dato=new Scanner(System.in);
       
        EjercicioDAO.leerArchivo();
        ArrayList<Ejercicio> ejr=EjercicioDAO.obtenerlistaEjercicio();
        for (int i = 0; i < ejr.size(); i++) {
             System.out.println("Ingrese dir");
             System.out.println("direccion actual = "+ejr.get(i).getDiImagen());
            ejr.get(i).setDiImagen(dato.next());
            EjercicioDAO.modificarEjercicio(i,ejr.get(i));
        }
        EjercicioDAO.escribirArchivo();        
    }
}
