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
import LENGUAJE_DRACO.TablaSimbolo_S;

/**
 *
 * @author fernando
 */
public class Mientras extends Compilador_S{
      public Metodo_S ejecutar(Nodo raiz) {
        Nodo exp = raiz.hijos.get(0);
        Nodo sentencias = raiz.hijos.get(1);

        opL = new Operacion_ALR(global, tabla);
        Resultado_S condicion = opL.operar(exp);
        if (condicion.tipo.equals("entero")) {
            if ((int) condicion.valor == 1) {
                condicion = new Resultado_S("booleano", true);
            } else if ((int) condicion.valor == 0) {
                condicion = new Resultado_S("booleano", false);
            }
        }
        if (condicion.tipo.equalsIgnoreCase("booleano")) {
            while ((Boolean) condicion.valor) {
                //se cambia el ambito
                TablaSimbolo_S tablaTemp = new TablaSimbolo_S();
                tablaTemp.cambiarAmbito(tabla);
                pilaTablas.push(tabla);
                tabla = tablaTemp;
                metodoActual = ejecutarSentencias(sentencias);
                //regresamos al ambito
                tabla = pilaTablas.pop();
                opL = new Operacion_ALR(global, tabla);
                condicion = opL.operar(exp);

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

            }
        } else {
            Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "El tipo de dato de la condicion no es Bool");
        }
        return metodoActual;
    }
}
