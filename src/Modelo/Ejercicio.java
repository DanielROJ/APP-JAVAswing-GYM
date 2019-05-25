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
public class Ejercicio implements Serializable{
    private String nombre;
    private String musculo;
    private int nRepeticiones;
    private int nSerie;
    private Maquina maquina;
    private String diImagen;

    public Ejercicio(String nombre, String musculo, String diImagen) {
        this.nombre = nombre;
        this.musculo = musculo;
        this.diImagen = diImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMusculo() {
        return musculo;
    }

    public void setMusculo(String musculo) {
        this.musculo = musculo;
    }

    public int getnRepeticiones() {
        return nRepeticiones;
    }

    public void setnRepeticiones(int nRepeticiones) {
        this.nRepeticiones = nRepeticiones;
    }

    public int getnSerie() {
        return nSerie;
    }

    public void setnSerie(int nSerie) {
        this.nSerie = nSerie;
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    public String getDiImagen() {
        return diImagen;
    }

    public void setDiImagen(String diImagen) {
        this.diImagen = diImagen;
    }
    
    
    
    
    
}
