/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LENGUAJE_DRACO.Sentencias;

import ESTRUCTURAS.Nodo;
import LENGUAJE_DRACO.Compilador_S;
import LENGUAJE_DRACO.Inicio;
import LENGUAJE_DRACO.Metodo_S;
import LENGUAJE_DRACO.OperacionesALR.Operacion_ALR;
import LENGUAJE_DRACO.Resultado_S;
import LENGUAJE_DRACO.Simbolo_S;
import LENGUAJE_DRACO.TablaSimbolo_S;

/**
 *
 * @author fernando
 */
public class Para extends Compilador_S{
    public Metodo_S ejecutar(Nodo raiz) {

        Nodo variable = raiz.hijos.get(0);
        Nodo expCondicion = raiz.hijos.get(1);
        Nodo expSimplificada = raiz.hijos.get(2);
        Nodo sentencias = raiz.hijos.get(3);

        TablaSimbolo_S tablaTempPrincipal = new TablaSimbolo_S();
        tablaTempPrincipal.cambiarAmbito(tabla);
        pilaTablas.add(tabla);
        tabla = tablaTempPrincipal;

        Simbolo_S simbolo = null;
        if (variable.nombre.equals("asignacion")) {
            Asignacion asig = new Asignacion(variable, global, tabla, "asignacion");
            simbolo = asig.asignar();
        } else {
            Declaracion declara = new Declaracion(variable, global, tabla, "Declaracion");
            simbolo = (Simbolo_S) declara.declarar();
        }

        if (simbolo != null) {

            opL = new Operacion_ALR(global, tabla);
            Resultado_S condicion = opL.operar(expCondicion);
            if (condicion.tipo.equals("entero")) {
                if ((int) condicion.valor == 1) {
                    condicion = new Resultado_S("boolean", true);
                } else if ((int) condicion.valor == 0) {
                    condicion = new Resultado_S("boolean", false);
                }
            }
            if (condicion.tipo.equals("booleano")) {
                while ((Boolean) condicion.valor) {
                    TablaSimbolo_S tablaTemp = new TablaSimbolo_S();
                    tablaTemp.cambiarAmbito(tabla);
                    pilaTablas.push(tabla);
                    tabla = tablaTemp;
                    metodoActual = ejecutarSentencias(sentencias);
                    tabla = pilaTablas.pop();
                    opL = new Operacion_ALR(global, tabla);
                    opL.operar(expSimplificada);
                    
                    if (metodoActual.estadoRetorno) {
                        break;
                    }
                    if (metodoActual.estadoTerminar) {
                        metodoActual.estadoTerminar = false;
                        break;
                    }

                    if (metodoActual.estadoContinuar) {
                        metodoActual.estadoContinuar = false;
                    }

                    condicion = opL.operar(expCondicion);
                    if (condicion.tipo.equals("entero")) {
                        if ((int) condicion.valor == 1) {
                            condicion = new Resultado_S("booleano", true);
                        } else if ((int) condicion.valor == 0) {
                            condicion = new Resultado_S("booleano", false);
                        }
                    }
                }
            } else {
                Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "La condicion del ciclo para solo permite operaciones que retornan un valor booleano");
            }

        }
        tabla = pilaTablas.pop();
        return metodoActual;
    }
}
