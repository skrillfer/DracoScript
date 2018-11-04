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
public class Si extends Compilador_S{
    public Metodo_S ejecutar(Nodo raiz) {

        Nodo exp = raiz.hijos.get(0);
        Nodo sentenciasSi = raiz.hijos.get(1);
        
        Nodo parte2 = raiz.hijos.get(2);
        
        
        opL = new Operacion_ALR(global, tabla);
        Resultado_S condicion = opL.operar(exp);

        //cambio de ambito
        TablaSimbolo_S tablaTemp = new TablaSimbolo_S();
        tablaTemp.cambiarAmbito(tabla);
        pilaTablas.push(tabla);
        tabla = tablaTemp;

        if (condicion.tipo.equals("entero")) {
            if ((int) condicion.valor == 1) {
                condicion = new Resultado_S("booleano", true);
            } else if ((int) condicion.valor == 0) {
                condicion = new Resultado_S("booleano", false);
            }
        }

        if (condicion.tipo.equalsIgnoreCase("booleano")) {
            if ((Boolean) condicion.valor) {
                metodoActual = ejecutarSentencias(sentenciasSi);
            } else {
                if(parte2.hijos.size()==2)
                {
                    Nodo muchos_sinoSi = parte2.hijos.get(0);
                    for (Nodo sinoSi : muchos_sinoSi.hijos) {
                         Metodo_S retox = SinoSi(sinoSi);
                         if(retox!=null)
                         {
                            //regreso al ambito 
                            tabla = pilaTablas.pop();
                            return metodoActual;
                         }
                    }
                    return Sino(parte2.hijos.get(1));
                }else if(parte2.hijos.size()==1)
                {
                    if(parte2.hijos.get(0).nombre.equals("Sino"))
                    {
                        return Sino(parte2.hijos.get(0));
                    }else
                    {
                        Nodo muchos_sinoSi = parte2.hijos.get(0);
                        for (Nodo sinoSi : muchos_sinoSi.hijos) {
                             Metodo_S retox = SinoSi(sinoSi);
                             if(retox!=null)
                             {
                                //regreso al ambito 
                                tabla = pilaTablas.pop();
                                return metodoActual;
                             }
                        }
                    }
                }
                
            }
        } else {
            Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "Solo se permiten valores booleanos en la condicion de la sentencia si o enteros 0 o 1");
        }

        //regreso al ambito 
        tabla = pilaTablas.pop();
        return metodoActual;
    }
    
    
    public Metodo_S Sino(Nodo sentenciasSino)
    {
        metodoActual = ejecutarSentencias(sentenciasSino.hijos.get(0));
        
        tabla = pilaTablas.pop();
        return metodoActual;    
    }
    
    public Metodo_S SinoSi(Nodo sentenciaSinoSi)
    {
        Nodo exp = sentenciaSinoSi.hijos.get(0);
        Nodo sentencias = sentenciaSinoSi.hijos.get(1);
        
        Resultado_S condicion = opL.operar(exp);
        if (condicion.tipo.equals("entero")) {
            if ((int) condicion.valor == 1) {
                condicion = new Resultado_S("booleano", true);
            } else if ((int) condicion.valor == 0) {
                condicion = new Resultado_S("booleano", false);
            }
        }
        
        if (condicion.tipo.equalsIgnoreCase("booleano")) {
            if ((Boolean) condicion.valor) {
                metodoActual = ejecutarSentencias(sentencias);
                return metodoActual;
            }
        }
        return null;
    }
}
