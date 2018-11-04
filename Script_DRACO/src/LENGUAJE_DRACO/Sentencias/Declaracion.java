/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LENGUAJE_DRACO.Sentencias;

import ESTRUCTURAS.Nodo;
import ESTRUCTURAS.Resultado;
import LENGUAJE_DRACO.Casteo;
import LENGUAJE_DRACO.Compilador_S;
import LENGUAJE_DRACO.Inicio;
import LENGUAJE_DRACO.OperacionesALR.Operacion_ALR;
import LENGUAJE_DRACO.Resultado_S;
import LENGUAJE_DRACO.Simbolo_S;
import LENGUAJE_DRACO.TablaSimbolo_S;

/**
 *
 * @author fernando
 */
public class Declaracion extends Compilador_S{
    TablaSimbolo_S tabla;
    TablaSimbolo_S global;
    
    public Declaracion(Nodo raiz, TablaSimbolo_S global, TablaSimbolo_S tabla) {
        this.raiz = raiz;
        this.global = global;
        this.tabla = tabla;
        opL = new Operacion_ALR(global, tabla);
        declarar();
    }
    
    public Declaracion(Nodo raiz, TablaSimbolo_S global, TablaSimbolo_S tabla, String tipo) {
        this.raiz = raiz;
        this.global = global;
        this.tabla = tabla;
        opL = new Operacion_ALR(global, tabla);
    }
    
    public Simbolo_S declarar()
    {
        switch (raiz.nombre) {
            case "primitivaG":
                return primitivaG();
            case "primitiva":
                return primitiva();
            case "primitivaUna":
                return primitivaUna();    
        }
        return null;
    }
    
    private Simbolo_S primitivaG()
    {
        for (Nodo id_hijo : raiz.hijos.get(0).hijos) {
            String nombre = id_hijo.hijos.get(0).valor;
            Nodo exp = id_hijo.hijos.get(1);
            
            if(exp.nombre.equals(""))
            {
                Simbolo_S simbolo = new Simbolo_S("", nombre,"", "");
                simbolo.inicializado = false;
                if (!global.setSimbolo(simbolo)) {
                    Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "La variable " + nombre + " ya existe");
                }
                continue;
            }
            
            Resultado_S resultado = opL.operar(exp);
            if (resultado != null) {
                Simbolo_S simbolo = new Simbolo_S(resultado.tipo, nombre,"", resultado.valor);
                simbolo.inicializado = true;
                if (!global.setSimbolo(simbolo)) {
                    Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "La variable " + nombre + " ya existe");
                }
            }
            
        }
        return null;
    }
     
    private Simbolo_S primitiva()
    {
        for (Nodo id_hijo : raiz.hijos.get(0).hijos) {
            String nombre = id_hijo.hijos.get(0).valor;
            Nodo exp = id_hijo.hijos.get(1);
            
            if(exp.nombre.equals(""))
            {
                Simbolo_S simbolo = new Simbolo_S("", nombre,"", "");
                simbolo.inicializado = false;
                if (!tabla.setSimbolo(simbolo)) {
                    Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "La variable " + nombre + " ya existe");
                }
                
            }
            
            Resultado_S resultado = opL.operar(exp);
            
            if (resultado != null) {
                Simbolo_S simbolo = new Simbolo_S(resultado.tipo, nombre,"", resultado.valor);
                simbolo.inicializado = true;
                if (!tabla.setSimbolo(simbolo)) {
                    Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "La variable " + nombre + " ya existe");
                }
            }
            
        }
        return null;
    }
    
    private Simbolo_S primitivaUna()
    {
        for (Nodo id_hijo : raiz.hijos.get(0).hijos) {
            String nombre = id_hijo.hijos.get(0).valor;
            Nodo exp = id_hijo.hijos.get(1);
            
            Resultado_S resultado = opL.operar(exp);
            
            if (resultado != null) {
                Simbolo_S simbolo = new Simbolo_S(resultado.tipo, nombre, resultado.valor);
                simbolo.inicializado = true;
                if (!tabla.setSimbolo(simbolo)) {
                    Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "La variable " + nombre + " ya existe");
                }else
                {
                    return simbolo;
                }
            }
        }
        return null;
    }
   
}
