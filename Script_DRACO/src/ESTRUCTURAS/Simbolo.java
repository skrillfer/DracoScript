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

    public String nombre = "";
    public String tipo = "";
    public String tipo2 = "";
    public String ambito = "";
    public String rol = "";
    public int direccion = -1;
    public int tamanio = 0;
    public ArrayList<Nodo> dimension = null;
    //tabla
    public Nodo nodo = null;
    public boolean inicializado = false;
    public boolean declarado = false;
    public Object retornado = null;
    public boolean posicion_arreglo = false;

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
