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
    ArrayList<Nodo> dimension = null;
    //tabla
    Nodo nodo = null;
    boolean inicializado = false;
    boolean declarado = false;
    Object retornado = null;

    String archivo = "";
    public Simbolo() {
    }

    public Simbolo(String nombre, String tipo, String ambito, String rol, int direccion, int tamanio, ArrayList<Nodo> dimension,String archivo) 
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
        this.archivo = archivo;
        this.retornado = null;//resultado Retornado
    }

}
