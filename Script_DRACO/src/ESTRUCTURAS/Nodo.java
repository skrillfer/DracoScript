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
public class Nodo {
    public String archivo = "";
    public int index;
    public String nombre;
    public String valor;
    public int linea;
    public int columna;
    public ArrayList<Nodo> hijos;

    public Nodo(int index, String nombre, String valor, int linea, int columna) {
        this.index = index;
        this.nombre = nombre;
        this.valor = valor;
        this.linea = linea;
        this.columna = columna;
        this.hijos = new ArrayList<>();
        this.archivo =Interprete.Interpretacion.Archivo_Actual;
    }
    
    public void add(int index,String nombre, String valor, int linea, int columna){
        this.hijos.add(new Nodo(index,nombre,valor,linea,columna));
    }
    
    public void add(Nodo h)
    {
        this.hijos.add(h);
    }
    
}
