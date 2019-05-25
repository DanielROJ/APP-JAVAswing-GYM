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
public class Persona implements Serializable {
    protected String nombre;
    protected long identificacion;
    protected String correo;
    private String Carrera;

    public Persona(String nombre, long identificacion, String correo) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.correo = correo;
    }

   
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(long identificacion) {
        this.identificacion = identificacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String Carrera) {
        this.Carrera = Carrera;
    }
    
    
    
    
    
}
