/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LENGUAJE_DRACO;

import ESTRUCTURAS.Nodo;
import LENGUAJE_DRACO.OperacionesALR.Operacion_ALR;
import LENGUAJE_DRACO.Sentencias.Asignacion;
import LENGUAJE_DRACO.Sentencias.Declaracion;
import LENGUAJE_DRACO.Sentencias.Mientras;
import LENGUAJE_DRACO.Sentencias.Para;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author fernando
 */
public  class Compilador_S {
    //--
    public int  nivelCondicion = 0;
      //archivos
    public static ArrayList<Archivo> archivos;
    public String archivoActual;
    public static ArrayList<Simbolo_S> reporteSimbolos;

    //public static ArrayList<Clase> clases;
    public static Clase claseActual;
    public static Stack<Clase> pilaClases;
    public static Stack<Metodo_S> pilaMetodos;
    public static Metodo_S metodoActual;
    public static Stack<TablaSimbolo_S> pilaTablas;

    //sirven para el controlar las sentencias continuar y terminar
    public static int nivelCiclo = 0;
    public static Stack<Integer> pilaNivelCiclo;
    public Operacion_ALR opL;
    public static TablaSimbolo_S tabla;
    public static TablaSimbolo_S global;
    protected Nodo raiz;
    
    
    protected Metodo_S ejecutarSentencias(Nodo sentencias) 
    {   
        Nodo lista_expr;
        Resultado_S result;

        for (Nodo sentencia : sentencias.hijos) 
        {
            switch (sentencia.nombre) 
            {
                case "primitiva":
                    try {
                        if(nivelCiclo==0 && nivelCondicion==0)
                        {
                            sentencia.nombre += "G";
                        }
                        new Declaracion(sentencia, global, tabla);
                    } catch (Exception e) {
                        Inicio.reporteError.agregar("Ejecucion", sentencia.linea, sentencia.columna,"Declaracion variable:"+ e.getMessage());
                    }
                    break;
                case "imprimir":
                    try {
                        opL = new Operacion_ALR(global, tabla);
                        Resultado_S imprimir = opL.operar(sentencia.hijos.get(0));
                        System.out.println(imprimir.valor+"");
                    } catch (Exception e) {
                        Inicio.reporteError.agregar("Ejecucion", sentencia.linea, sentencia.columna, "Sentencia imprimir:"+e.getMessage());
                    }
                    break;
                case "mientras":
                    try {
                        Mientras mientras = new Mientras();
                        nivelCiclo++;
                        
                        metodoActual = mientras.ejecutar(sentencia);
                        if (metodoActual.estadoRetorno) {
                            nivelCiclo--;
                            return metodoActual;
                        }
                        nivelCiclo--;
                    } catch (Exception e) {
                        Inicio.reporteError.agregar("Ejecucion", sentencia.linea, sentencia.columna, "Sentencia Mientras:"+e.getMessage());
                    }
                    break; 
                case "para":
                    try {
                        nivelCiclo++;
                        Para para = new Para();
                        metodoActual = para.ejecutar(sentencia);
                        if (metodoActual.estadoRetorno) {
                            nivelCiclo--;
                            return metodoActual;
                        }
                        nivelCiclo--;
                    } catch (Exception e) {
                        Inicio.reporteError.agregar("Ejecucion", sentencia.linea, sentencia.columna, "Sentencia Mientras:"+e.getMessage());
                    }
                    
                    break;    
                case "simplificada":
                    opL = new Operacion_ALR(global, tabla);
                    opL.operar(sentencia);
                    break;
                case "asignacion":
                    try {
                        new Asignacion(sentencia, global, tabla);
                    } catch (Exception e) {
                        Inicio.reporteError.agregar("Ejecucion", sentencia.linea, sentencia.columna, "Sentencia Mientras:"+e.getMessage());
                    }
                    break;
                case "terminar":
                    if (nivelCiclo > 0) {
                        metodoActual.estadoTerminar = true;
                        return metodoActual;
                    } else {
                        Inicio.reporteError.agregar("Semantico", sentencia.linea, sentencia.columna, "La sentencia terminar solo puede estar detro de ciclos");
                    }
                    break;    
                case "importar_dasm":
                    lista_expr = sentencia.hijos.get(0);
                    for (Nodo expr : lista_expr.hijos) {
                        opL = new Operacion_ALR(global, tabla);
                        result = opL.operar(expr);
                        if(result.valor!=null && result.tipo.equals("cadena"))
                        {
                            //result.valor tiene la por ejemplo "compilado.dasm"
                        }
                    }
                    break;        
                case "pintarpunto":
                    lista_expr = sentencia.hijos.get(0);
                    for (Nodo expr : lista_expr.hijos) {
                        opL = new Operacion_ALR(global, tabla);
                        result = opL.operar(expr);
                        if(result.valor!=null)
                        {
                            //result.valor tiene la por ejemplo "compilado.dasm"
                            /*
                                Aca se debe revisar semanticamente que vengan todos los parametros para pintar punto
                                y que sean del tipo conveniente
                            */
                        }
                    }
                    break;        
                case "pintarcuadrado":
                    lista_expr = sentencia.hijos.get(0);
                    for (Nodo expr : lista_expr.hijos) {
                        opL = new Operacion_ALR(global, tabla);
                        result = opL.operar(expr);
                        if(result.valor!=null)
                        {
                            //result.valor tiene la por ejemplo "compilado.dasm"
                            /*
                                Aca se debe revisar semanticamente que vengan todos los parametros para pintar punto
                                y que sean del tipo conveniente
                            */
                        }
                    }
                    break;
                case "pintarovalo":
                    lista_expr = sentencia.hijos.get(0);
                    for (Nodo expr : lista_expr.hijos) {
                        opL = new Operacion_ALR(global, tabla);
                        result = opL.operar(expr);
                        if(result.valor!=null)
                        {
                            //result.valor tiene la por ejemplo "compilado.dasm"
                            /*
                                Aca se debe revisar semanticamente que vengan todos los parametros para pintar punto
                                y que sean del tipo conveniente
                            */
                        }
                    }
                    break;
                case "pintarcadena":
                    lista_expr = sentencia.hijos.get(0);
                    for (Nodo expr : lista_expr.hijos) {
                        opL = new Operacion_ALR(global, tabla);
                        result = opL.operar(expr);
                        if(result.valor!=null)
                        {
                            //result.valor tiene la por ejemplo "compilado.dasm"
                            /*
                                Aca se debe revisar semanticamente que vengan todos los parametros para pintar punto
                                y que sean del tipo conveniente
                            */
                        }
                    }
                    break;  
                case "pintarlinea":
                    lista_expr = sentencia.hijos.get(0);
                    for (Nodo expr : lista_expr.hijos) {
                        opL = new Operacion_ALR(global, tabla);
                        result = opL.operar(expr);
                        if(result.valor!=null)
                        {
                            //result.valor tiene la por ejemplo "compilado.dasm"
                            /*
                                Aca se debe revisar semanticamente que vengan todos los parametros para pintar punto
                                y que sean del tipo conveniente
                            */
                        }
                    }
                    break;      
            }
        }
        return metodoActual;
    }
    
    
    public  String getTipo(Object objeto) {
        String tipo = objeto.getClass().getSimpleName();
        switch (tipo) {
            case "Integer":
                return "entero";
            case "String":
                return "cadena";
            case "Character":
                return "caracter";
            case "Double":
                return "decimal";
            case "Boolean":
                return "booleano";
            default:
                return tipo;
        }
    }
    
    public int getCharValor(Object objeto, Nodo raiz) {
        String valor = (char) objeto + "";
        try {
            return Integer.parseInt(valor);
        } catch (Exception e) {
            Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se pudo castear el caracter a tipo Bool");
            return -1;
        }
    }

    public int getStringValor(Object objeto, Nodo raiz) {
        String valor = (String) objeto;
        try {
            return Integer.parseInt(valor);
        } catch (Exception e) {
            Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se pudo castear la cadena a tipo Bool");
            return -1;
        }
    }
    
    public int getBoolValor(Object objeto) {
        Boolean valor = (Boolean) objeto;
        if (valor) {
            return 1;
        } else {
            return 0;
        }
    }
}
