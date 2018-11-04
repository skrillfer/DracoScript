/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LENGUAJE_DRACO.Sentencias;

import ESTRUCTURAS.Nodo;
import LENGUAJE_DRACO.Clase;
import LENGUAJE_DRACO.Compilador_S;
import LENGUAJE_DRACO.Draco_Script_S;
import LENGUAJE_DRACO.Inicio;
import LENGUAJE_DRACO.OperacionesALR.Operacion_ALR;
import LENGUAJE_DRACO.Resultado_S;
import LENGUAJE_DRACO.Simbolo_S;
import LENGUAJE_DRACO.TablaSimbolo_S;

/**
 *
 * @author fernando
 */
public class Asignacion extends Compilador_S{
    Nodo valorIndice;

    public Asignacion(Nodo raiz, TablaSimbolo_S global, TablaSimbolo_S tabla) {
        this.raiz = raiz;
        this.global = global;//tabla de sibolos de una clase
        this.tabla = tabla;//tabla de simbolos de un metodo
        opL = new Operacion_ALR(global, tabla);
        asignar();
    }
    
    
    public Asignacion(Nodo raiz, TablaSimbolo_S global, TablaSimbolo_S tabla, String tipo) {
        this.raiz = raiz;
        this.global = global;
        this.tabla = tabla;
        opL = new Operacion_ALR(global, tabla);
    }
    
    public Simbolo_S asignar() {
        switch (raiz.nombre) {
            case "asignacion"://asignacion de objetos,variables y arreglos
                return asignacion();   
        }
        return null;
    }

    private Simbolo_S asignacion() {
        valorIndice = raiz.hijos.get(1);
        Simbolo_S simbolo = acceso(raiz.hijos.get(0));
        
        Resultado_S resultado = opL.operar(raiz.hijos.get(1));
        if (resultado.valor != null) {
            if (simbolo != null) {   
                simbolo.tipo = resultado.tipo;
                simbolo.valor = resultado.valor;
                simbolo.inicializado = true;
                return simbolo;
                
            } else {
                Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "La variable " + raiz.valor + " no existe");
            }
        } else {
            Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "Tipo de dato invalido");
        }
        return null;
    }
    
    
    private Simbolo_S acceso(Nodo raiz) {
        Clase aux = Draco_Script_S.claseActual;
        TablaSimbolo_S tablaAux = tabla;
        int nivel = 0;
        Simbolo_S sim = null;
        for (Nodo acceso : raiz.hijos) {
            String nombre;
            Simbolo_S simbolo;
            switch (acceso.nombre) {
                
                case "id":
                    nombre = acceso.valor;
                    simbolo = tabla.getSimbolo(nombre, aux);
                
                    if (simbolo != null) {

                        switch (simbolo.tipo) {
                            case "entero":
                            case "cadena":
                            case "booleano":
                            case "caracter":
                            case "decimal":
                            default:    
                                sim = simbolo;
                                break;
                        }

                    } else {
                        Inicio.reporteError.agregar("Semantico", acceso.linea, acceso.columna, "La variable " + nombre + " no existe en el ambito donde fue invocada");
                        return null;
                    }
                    break;
                
            }

        }
        tabla = tablaAux;
        return sim;
    }

}
