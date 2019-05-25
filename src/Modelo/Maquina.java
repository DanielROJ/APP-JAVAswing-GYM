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
public class Maquina implements Serializable {
    private String nombre;

    public Maquina(String nombre) {
        this.nombre = nombre;
    }
   
}
