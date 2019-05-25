/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @since 10-05-2017
 * @author Daniel Rojas - danielroj
 */
public class Rutina implements Serializable {
   private String TipoRutina;
   private String decripcion;
   private ArrayList<Ejercicio> ejercicio=new ArrayList<Ejercicio>();

    public Rutina() {
    }

    public Rutina(String TipoRutina, String decripcion) {
        this.TipoRutina = TipoRutina;
        this.decripcion = decripcion;
    }

    public String getTipoRutina() {
        return TipoRutina;
    }

    public void setTipoRutina(String TipoRutina) {
        this.TipoRutina = TipoRutina;
    }

    public String getDecripcion() {
        return decripcion;
    }

    public void setDecripcion(String decripcion) {
        this.decripcion = decripcion;
    }

    public ArrayList<Ejercicio> getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Ejercicio ej) {
        ejercicio.add(ej);
    }

  
      
}
