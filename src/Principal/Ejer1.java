/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Modelo.DAO.EjercicioDAO;
import Modelo.Ejercicio;
import Modelo.Maquina;
import java.io.IOException;
import java.util.Scanner;

/**
 * @since 10-05-2017
 * @author Daniel Rojas - danielroj
 */
public class Ejer1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner dato=new Scanner(System.in);
        EjercicioDAO.leerArchivo();
       boolean a=false;
        while(a==false){
        System.out.println("nombre ejercicio");
        String nombre=dato.nextLine();
        System.out.println("Muculo que trabaja");
        String mus=dato.next();
        System.out.println("direccion de archivo");
        String path=dato.next();
        Ejercicio ejer=new Ejercicio(nombre,mus,path);
        System.out.println("Tiene maquina 1 si  2 no");
        int c=dato.nextInt();
       if(c==1){
           System.out.println("Ingrese el nombre de la Maquina");
           String x=dato.next();
           Maquina m=new Maquina(x);
           ejer.setMaquina(m);
       }
        EjercicioDAO.nuevoEjercicio(ejer);
           
        System.out.println("salir");
           
        int r=dato.nextInt();
            
            if(r==1){
                a=true;
            }else{
                a=false;
            }
        }
        
        
        EjercicioDAO.escribirArchivo();
        
    }
}
