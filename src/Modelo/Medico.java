/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 * @since 10-05-2017
 * @author Daniel Rojas - danielroj
 */
public class Medico extends Persona implements Serializable {
   private  int idProfesional;
   private String especialidad;

    public Medico(int idProfesional, String especialidad, String nombre, long identificacion, String correo) {
        super(nombre, identificacion, correo);
        this.idProfesional = idProfesional;
        this.especialidad = especialidad;
    }
   
   
   
    public int getIdProfesional() {
        return idProfesional;
    }

  

    public void setIdProfesional(int idProfesional) {
        this.idProfesional = idProfesional;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    
}
