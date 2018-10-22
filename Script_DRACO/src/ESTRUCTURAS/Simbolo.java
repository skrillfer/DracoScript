/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ESTRUCTURAS;

import java.util.ArrayList;

/**
 *
 * @author fernando
 */
public class Simbolo {

    String nombre = "";
    String tipo = "";
    String tipo2 = "";
    String ambito = "";
    String rol = "";
    int direccion = -1;
    int tamanio = 0;
    int dimension = 0;
    //tabla
    Nodo nodo = null;
    boolean inicializado = false;
    boolean declarado = false;
    Object retornado = null;

    public Simbolo() {
    }

    public Simbolo(String nombre, String tipo, String ambito, String rol, int direccion, int tamanio, int dimension) 
    {
        this.nombre = nombre;
        this.tipo = tipo;
        this.tipo2 = null;
        this.ambito = ambito;
        this.rol = rol;
        this.direccion = direccion;
        this.tamanio = tamanio;
        this.dimension = dimension;
        this.nodo = null;
        this.inicializado = false;
        this.declarado = false;

        this.retornado = null;//resultado Retornado
    }

}
