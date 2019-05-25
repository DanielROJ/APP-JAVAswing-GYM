package Controlador;

/*
 */
import Modelo.Persona;
import javax.swing.JOptionPane;

/**
 * @since 10-05-2017
 * @author Daniel Rojas - danielroj
 */
public class Exepciones extends Exception{

    
    public static boolean ValidarPassword(char[] a,Persona c){
        String pass=String.valueOf(c.getIdentificacion());
        
        if((a.length==0)||(a.length!=pass.length())){
            return false;
        }
        
        for (int i = 0; i < pass.length(); i++) {
            if(a[i]!=pass.charAt(i)){
             return false;   
            }
                
                }     
            
      return true;  
    }
    
    
    public static int  ValidaInt(String numero) {
        int a=0;
        
        try {
         
            a=Integer.parseInt(numero.replaceAll(" ","").trim());
            

        } catch (NumberFormatException e) {
          
            return 0;
        }

        return a;
    }

 public static float ValidaFloat(String numero){
           float a=0;
        
        try {
         
            a=Float.parseFloat(numero.replaceAll(" ","").trim());
            

        } catch (NumberFormatException e) {
    
            return 0;
        }

        return a;
        
        
    }
 
 
 public static long ValidaLong(String numero){
       long a=0;
        
        try {
         
            a=Long.parseLong(numero.replaceAll(" ","").trim());
            

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error De Entrada");
            return 0;
            
        }

        return a;
        
        
    }



public static boolean EspacioBlanco(String a,char[] v){
    if(a==null){
        JOptionPane.showMessageDialog(null,"ESPACIO ENCONTRADO EN BLANCO");
        return false;
    }else{
        if(v.length<=0){
             JOptionPane.showMessageDialog(null,"ESPACIO ENCONTRADO EN BLANCO");
            return false;
        }
    }
    
 
    
   return true; 
}

 public static boolean Blanco(String a,String b,String c){
     if(a.equals("")||b.equals("")||c.equals("")){
         JOptionPane.showMessageDialog(null,"ESPACIO ENCONTRADO EN BLANCO");
         return false;
     }
    return true;   
 }
 
    public static boolean Blanco2(String a,String b,String c,String d){
     if(a.equals("")||b.equals("")||c.equals("")||d.equals("")){
         JOptionPane.showMessageDialog(null,"ESPACIO ENCONTRADO EN BLANCO");
         return false;
     }
    return true;   
 }
    
    
}
