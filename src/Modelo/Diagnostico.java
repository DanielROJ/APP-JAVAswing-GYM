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
public class Diagnostico implements Serializable{
    private Rutina rutina;
    private Persona persona;
    private String lesionesEnfermedad;
    private int edad;
    private String grupoSanguineo;
    private String Observacion;
    private float peso;
    private float altura;    
    private char genero;
    private String fecha;

    public Diagnostico(Persona persona, String lesionesEnfermedad, int edad, String grupoSanguineo, String Observacion, float peso, float altura, char genero,String fecha) {
        this.fecha=fecha;
        this.persona = persona;
        this.lesionesEnfermedad = lesionesEnfermedad;
        this.edad = edad;
        this.grupoSanguineo = grupoSanguineo;
        this.Observacion = Observacion;
        this.peso = peso;
        this.altura = altura;
        this.genero = genero;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }


    public String getLesionesEnfermedad() {
        return lesionesEnfermedad;
    }

    public void setLesionesEnfermedad(String lesionesEnfermedad) {
        this.lesionesEnfermedad = lesionesEnfermedad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }

   

    public Rutina getRutina() {
        return rutina;
    }

    public void setRutina(Rutina rutina) {
        this.rutina = rutina;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
    
    
    
}
