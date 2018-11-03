/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LENGUAJE_DRACO;

import ESTRUCTURAS.Nodo;
import LENGUAJE_DRACO.Sentencias.Declaracion;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author fernando
 */
public class Clase {
      public Stack<TablaSimbolo_S> pilaTablas;

    //--------------------------------------
    public String archivo;
    public TablaSimbolo_S global;
    public TablaSimbolo_S tabla;
    public String nombre;
    public String visibilidad;
    public Clase herencia;
    public String nombreHereda;
    public ArrayList<Metodo_S> metodos;
    public ArrayList<Nodo> atributos;
    
    
    public Clase() {
        global = new TablaSimbolo_S();
        tabla = new TablaSimbolo_S();
        atributos = new ArrayList<>();
        metodos = new ArrayList<>();
        pilaTablas = new Stack<>();
    }
    
    public Clase(Nodo raiz) {

        global = new TablaSimbolo_S();
        tabla = new TablaSimbolo_S();
        atributos = new ArrayList<>();
        metodos = new ArrayList<>();
        pilaTablas = new Stack<>();
        
        this.nombre = raiz.valor;
    }
    

    public void ejecutar() {
        Compilador_S.claseActual = this;
        for (Nodo atributo : atributos) {
            /*atributo.nombre = "primitivaG";
            new Declaracion(atributo, global, tabla);*/
        }
    }

    
}
