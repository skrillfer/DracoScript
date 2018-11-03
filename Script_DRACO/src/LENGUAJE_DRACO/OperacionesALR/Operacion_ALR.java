/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LENGUAJE_DRACO.OperacionesALR;

import ESTRUCTURAS.Nodo;
import LENGUAJE_DRACO.Clase;
import LENGUAJE_DRACO.Compilador_S;
import LENGUAJE_DRACO.Draco_Script_S;
import LENGUAJE_DRACO.Inicio;
import LENGUAJE_DRACO.Resultado_S;
import LENGUAJE_DRACO.Simbolo_S;
import LENGUAJE_DRACO.TablaSimbolo_S;

/**
 *
 * @author fernando
 */
public class Operacion_ALR extends Compilador_S{
    
    public Operacion_ALR(TablaSimbolo_S global, TablaSimbolo_S local) {
        this.tabla = local;
        this.global = global;
    }

    public Resultado_S operar(Nodo raiz)
    {
        Resultado_S resultado1 = null;
        Resultado_S resultado2 = null;
        Simbolo_S simbolo=null;
        
        
        switch(raiz.nombre)
        {
            case "AND":
            case "OR":
            case "NOT":
                resultado1 = operar(raiz.hijos.get(0));
                resultado2 = operar(raiz.hijos.get(1));
                return operaciones_logicas(resultado1, resultado2, simbolo, raiz);
            case "IG_IG":
            case "DIF":
            case "MENIQ":        
            case "MENQ":
            case "MAYQ":
            case "MAYIQ":
                resultado1 = operar(raiz.hijos.get(0));
                resultado2 = operar(raiz.hijos.get(1));
                return operaciones_relacionales(resultado1, resultado2, simbolo, raiz);
            case "MAS":
            case "MENOS":
            case "POR":
            case "DIV":
            case "POT":
            case "MOD": 
                resultado1 = operar(raiz.hijos.get(0));
                resultado2 = operar(raiz.hijos.get(1));
                return operaciones_aritmeticas(resultado1, resultado2, simbolo, raiz);
            case "unitario":
                resultado1 = operar(raiz.hijos.get(0));
                switch (resultado1.tipo) {
                    case "entero":
                        return new Resultado_S(resultado1.tipo, (int) resultado1.valor * -1);
                    case "decimal":
                        return new Resultado_S(resultado1.tipo, (Double) resultado1.valor * -1);
                    case "caracter":
                        Object val = (char) resultado1.valor * -1;
                        return new Resultado_S(getTipo(val), val);
                    case "booleano":
                        if ((boolean) resultado1.valor) {
                            return new Resultado_S("entero", -1);
                        } else {
                            return new Resultado_S("entero", 0);
                        }
                    default:
                        //Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "El operador unitario - no puede aplicarse a cadenas");
                        return new Resultado_S("-1", null);
                }
            case "NUM_LITERAL":
                return new Resultado_S("entero", Integer.parseInt(raiz.valor));
            case "DECIMAL_LITERAL":

                return new Resultado_S("decimal", Double.parseDouble(raiz.valor));
            case "CHAR_LITERAL":
                return new Resultado_S("caracter", (raiz.valor.charAt(0)));
            case "FALSO_LITERAL":
            case "VERDADERO_LITERAL":    
                if (raiz.valor.equals("verdadero") || raiz.valor.equals("1")) {
                    return new Resultado_S("booleano", true);
                } else {
                    return new Resultado_S("booleano", false);
                }
            case "STRING_LITERAL":
                return new Resultado_S("cadena", raiz.valor + "");
            case "simplificada":
                return operacionSimplificada(raiz.valor, raiz.hijos.get(0));
            case "acceso":
                return acceso(raiz);

        }
        return new Resultado_S("-1", null);
    }
    
    public Resultado_S operaciones_logicas(Resultado_S resultado1,Resultado_S resultado2,Simbolo_S simbolo,Nodo raiz)
    {
          switch (raiz.nombre) {
            case "AND":
                if ((Boolean) resultado1.valor && (Boolean) resultado2.valor) {
                    return new Resultado_S("booleano", true);
                } else {
                    return new Resultado_S("booleano", false);
                }
            case "OR":
                if ((Boolean) resultado1.valor || (Boolean) resultado2.valor) {
                    return new Resultado_S("booleano", true);
                } else {
                    return new Resultado_S("booleano", false);
                }
            case "NOT":
                resultado1 = operar(raiz.hijos.get(0));
                if (resultado1.tipo.equals("entero")) {
                    if ((int) resultado1.valor == 1) {
                        resultado1 = new Resultado_S("booleano", true);
                    } else {
                        resultado1 = new Resultado_S("booleano", false);
                    }
                } else if (!resultado1.tipo.equals("booleano")) {
                    Inicio.reporteError.agregar("Sintactico", raiz.linea, raiz.columna, "Se esperaba 0,1,verdadero o falso");
                    resultado1 = new Resultado_S("-1", false);
                }
                if ((Boolean) resultado1.valor) {
                    return new Resultado_S("booleano", false);
                } else {
                    return new Resultado_S("booleano", true);
                }
        }
        return new Resultado_S("-1", false);
    }
    
    public Resultado_S operaciones_relacionales(Resultado_S resultado1,Resultado_S resultado2,Simbolo_S simbolo,Nodo raiz)
    {        int valComp;

        switch (raiz.nombre) {
            case "IG_IG":
                switch (resultado1.tipo) {
                    case "entero":
                        switch (resultado2.tipo) {
                            case "entero":
                                if ((int) resultado1.valor == (int) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "decimal":
                                if ((int) resultado1.valor == (double) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "booleano":
                                if ((int) resultado1.valor == getBoolValor(resultado2.valor)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "caracter":
                                if ((int) resultado1.valor == (char) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "cadena":
                                Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No es posible comparar datos numericos con cadenas");
                                break;
                            default:
                                break;
                        }
                        break;
                    case "decimal":
                        switch (resultado2.tipo) {
                            case "entero":
                                if ((double) resultado1.valor == (int) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "decimal":
                                if ((double) resultado1.valor == (double) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "booleano":
                                if ((double) resultado1.valor == getBoolValor(resultado2.valor)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "caracter":
                                if ((double) resultado1.valor == (char) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "cadena":
                                Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No es posible comparar datos numericos con cadenas");
                                break;
                            default:
                                break;
                        }
                        break;
                    case "booleano":
                        switch (resultado2.tipo) {
                            case "entero":
                                if (getBoolValor(resultado1.valor) == (int) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "decimal":
                                if (getBoolValor(resultado1.valor) == (double) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "booleano":
                                if ((boolean) resultado1.valor == (boolean) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "caracter":
                                if (getBoolValor(resultado1.valor) == getCharValor(resultado2.valor, raiz)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "cadena":
                                if (getBoolValor(resultado1.valor) == getStringValor(resultado2.valor, raiz)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            default:
                                break;
                        }
                        break;
                    case "caracter":
                        switch (resultado2.tipo) {
                            case "entero":
                                if ((char) resultado1.valor == (int) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "decimal":
                                if ((char) resultado1.valor == (double) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "booleano":
                                if (getCharValor(resultado1.valor, raiz) == getBoolValor(resultado2.valor)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "caracter":
                                if ((char) resultado1.valor == (char) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "cadena":
                                if (((char) resultado1.valor + "").equals((String) resultado2.valor)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            default:
                                break;
                        }
                        break;
                    case "cadena":
                        switch (resultado2.tipo) {
                            case "entero":
                            case "decimal":
                                Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No es posible comparar datos de tipo numerico con cadenas");
                                break;
                            case "booleano":
                                if (getStringValor(resultado1.valor, raiz) == getBoolValor(resultado2.valor)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "caracter":
                                if (((String) resultado1.valor).equals((char) resultado2.valor + "")) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "cadena":
                                if (((String) resultado1.valor).equals((String) resultado2.valor)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
                break;

            case "DIF":
                switch (resultado1.tipo) {
                    case "entero":
                        switch (resultado2.tipo) {
                            case "entero":
                                if ((int) resultado1.valor != (int) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "decimal":
                                if ((int) resultado1.valor != (double) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "booleano":
                                if ((int) resultado1.valor != getBoolValor(resultado2.valor)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "caracter":
                                if ((int) resultado1.valor != (char) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "cadena":
                                Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No es posible comparar datos numericos con cadenas");
                                break;
                            default:
                                break;
                        }
                        break;
                    case "decimal":
                        switch (resultado2.tipo) {
                            case "entero":
                                if ((double) resultado1.valor != (int) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "decimal":
                                if ((double) resultado1.valor != (double) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "booleano":
                                if ((double) resultado1.valor != getBoolValor(resultado2.valor)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "caracter":
                                if ((double) resultado1.valor != (char) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "cadena":
                                Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No es posible comparar datos numericos con cadenas");
                                break;
                            default:
                                break;
                        }
                        break;
                    case "booleano":
                        switch (resultado2.tipo) {
                            case "entero":
                                if (getBoolValor(resultado1.valor) != (int) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "decimal":
                                if (getBoolValor(resultado1.valor) != (double) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "booleano":
                                if ((boolean) resultado1.valor != (boolean) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "caracter":
                                if (getBoolValor(resultado1.valor) != getCharValor(resultado2.valor, raiz)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "cadena":
                                if (getBoolValor(resultado1.valor) != getStringValor(resultado2.valor, raiz)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            default:
                                break;
                        }
                        break;
                    case "caracter":
                        switch (resultado2.tipo) {
                            case "entero":
                                if ((char) resultado1.valor != (int) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "decimal":
                                if ((char) resultado1.valor != (double) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "booleano":
                                if (getCharValor(resultado1.valor, raiz) != getBoolValor(resultado2.valor)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "caracter":
                                if ((char) resultado1.valor != (char) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "cadena":
                                if (!((char) resultado1.valor + "").equals((String) resultado2.valor)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            default:
                                break;
                        }
                        break;
                    case "cadena":
                        switch (resultado2.tipo) {
                            case "entero":
                            case "decimal":
                                Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No es posible comparar datos de tipo numerico con cadenas");
                                break;
                            case "booleano":
                                if (getStringValor(resultado1.valor, raiz) != getBoolValor(resultado2.valor)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "caracter":
                                if (!((String) resultado1.valor).equals((char) resultado2.valor + "")) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "cadena":
                                if (!((String) resultado1.valor).equals((String) resultado2.valor)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
                break;

            case "MAYQ":
                switch (resultado1.tipo) {
                    case "entero":
                        switch (resultado2.tipo) {
                            case "entero":
                                if ((int) resultado1.valor > (int) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "decimal":
                                if ((int) resultado1.valor > (double) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "booleano":
                                if ((int) resultado1.valor > getBoolValor(resultado2.valor)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "caracter":
                                if ((int) resultado1.valor > (char) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "cadena":
                                Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No es posible comparar valores tipo numerico con cadenas");
                                break;
                            default:
                                break;
                        }
                        break;
                    case "decimal":
                        switch (resultado2.tipo) {
                            case "entero":
                                if ((double) resultado1.valor > (int) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "decimal":
                                if ((double) resultado1.valor > (double) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "booleano":
                                if ((double) resultado1.valor > getBoolValor(resultado2.valor)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "caracter":
                                if ((double) resultado1.valor > (char) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "cadena":
                                Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No es posible comparar valores tipo numerico con cadenas");
                                break;
                            default:
                                break;
                        }
                        break;
                    case "booleano":
                        switch (resultado2.tipo) {
                            case "entero":
                                if (getBoolValor(resultado1.valor) > (int) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "decimal":
                                if (getBoolValor(resultado1.valor) > (double) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "booleano":
                                if (getBoolValor(resultado1.valor) > getBoolValor(resultado2.valor)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "caracter":
                                if (getBoolValor(resultado1.valor) > getCharValor(resultado2.valor, raiz)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "cadena":
                                if (getBoolValor(resultado1.valor) > getStringValor(resultado2.valor, raiz)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            default:
                                break;
                        }
                        break;
                    case "caracter":
                        switch (resultado2.tipo) {
                            case "entero":
                                if ((char) resultado1.valor > (int) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "decimal":
                                if ((char) resultado1.valor > (double) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "booleano":
                                if (getCharValor(resultado1.valor, raiz) > getBoolValor(resultado2.valor)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "caracter":
                                if ((char) resultado1.valor > (char) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "cadena":
                                valComp = ((char) resultado1.valor + "").compareTo((String) resultado2.valor);
                                if (valComp > 0) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            default:
                                break;
                        }
                        break;
                    case "cadena":
                        switch (resultado2.tipo) {
                            case "entero":
                            case "decimal":
                                Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No es posible comparar valores tipo numerico con cadenas");
                                break;
                            case "booleano":
                                if (getStringValor(resultado1.valor, raiz) > getBoolValor(resultado2.valor)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "caracter":
                                valComp = ((String) resultado1.valor).compareTo((char) resultado2.valor + "");
                                if (valComp > 0) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "cadena":
                                valComp = ((String) resultado1.valor).compareTo((String) resultado2.valor);
                                if (valComp > 0) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
                break;

            case "MAYIQ":
                switch (resultado1.tipo) {
                    case "entero":
                        switch (resultado2.tipo) {
                            case "entero":
                                if ((int) resultado1.valor >= (int) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "decimal":
                                if ((int) resultado1.valor >= (double) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "booleano":
                                if ((int) resultado1.valor >= getBoolValor(resultado2.valor)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "caracter":
                                if ((int) resultado1.valor >= (char) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "cadena":
                                Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No es posible comparar valores tipo numerico con cadenas");
                                break;
                            default:
                                break;
                        }
                        break;
                    case "decimal":
                        switch (resultado2.tipo) {
                            case "entero":
                                if ((double) resultado1.valor >= (int) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "decimal":
                                if ((double) resultado1.valor >= (double) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "booleano":
                                if ((double) resultado1.valor >= getBoolValor(resultado2.valor)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "caracter":
                                if ((double) resultado1.valor >= (char) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "cadena":
                                Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No es posible comparar valores tipo numerico con cadenas");
                                break;
                            default:
                                break;
                        }
                        break;
                    case "booleano":
                        switch (resultado2.tipo) {
                            case "entero":
                                if (getBoolValor(resultado1.valor) >= (int) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "decimal":
                                if (getBoolValor(resultado1.valor) >= (double) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "booleano":
                                if (getBoolValor(resultado1.valor) >= getBoolValor(resultado2.valor)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "caracter":
                                if (getBoolValor(resultado1.valor) >= getCharValor(resultado2.valor, raiz)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "cadena":
                                if (getBoolValor(resultado1.valor) >= getStringValor(resultado2.valor, raiz)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            default:
                                break;
                        }
                        break;
                    case "caracter":
                        switch (resultado2.tipo) {
                            case "entero":
                                if ((char) resultado1.valor >= (int) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "decimal":
                                if ((char) resultado1.valor >= (double) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "booleano":
                                if (getCharValor(resultado1.valor, raiz) >= getBoolValor(resultado2.valor)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "caracter":
                                if ((char) resultado1.valor >= (char) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "cadena":
                                valComp = ((char) resultado1.valor + "").compareTo((String) resultado2.valor);
                                if (valComp >= 0) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            default:
                                break;
                        }
                        break;
                    case "cadena":
                        switch (resultado2.tipo) {
                            case "entero":
                            case "decimal":
                                Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No es posible comparar valores tipo numerico con cadenas");
                                break;
                            case "booleano":
                                if (getStringValor(resultado1.valor, raiz) >= getBoolValor(resultado2.valor)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "caracter":
                                valComp = ((String) resultado1.valor).compareTo((char) resultado2.valor + "");
                                if (valComp >= 0) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "cadena":
                                valComp = ((String) resultado1.valor).compareTo((String) resultado2.valor);
                                if (valComp >= 0) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
                break;

            case "MENQ":
                Resultado_S aux = resultado1;
                resultado1 = resultado2;
                resultado2 = aux;
                switch (resultado1.tipo) {
                    case "entero":
                        switch (resultado2.tipo) {
                            case "entero":
                                if ((int) resultado1.valor > (int) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "decimal":
                                if ((int) resultado1.valor > (double) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "booleano":
                                if ((int) resultado1.valor > getBoolValor(resultado2.valor)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "caracter":
                                if ((int) resultado1.valor > (char) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "cadena":
                                Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No es posible comparar valores tipo numerico con cadenas");
                                break;
                            default:
                                break;
                        }
                        break;
                    case "decimal":
                        switch (resultado2.tipo) {
                            case "entero":
                                if ((double) resultado1.valor > (int) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "decimal":
                                if ((double) resultado1.valor > (double) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "booleano":
                                if ((double) resultado1.valor > getBoolValor(resultado2.valor)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "caracter":
                                if ((double) resultado1.valor > (char) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "cadena":
                                Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No es posible comparar valores tipo numerico con cadenas");
                                break;
                            default:
                                break;
                        }
                        break;
                    case "booleano":
                        switch (resultado2.tipo) {
                            case "entero":
                                if (getBoolValor(resultado1.valor) > (int) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "decimal":
                                if (getBoolValor(resultado1.valor) > (double) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "booleano":
                                if (getBoolValor(resultado1.valor) > getBoolValor(resultado2.valor)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "caracter":
                                if (getBoolValor(resultado1.valor) > getCharValor(resultado2.valor, raiz)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "cadena":
                                if (getBoolValor(resultado1.valor) > getStringValor(resultado2.valor, raiz)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            default:
                                break;
                        }
                        break;
                    case "caracter":
                        switch (resultado2.tipo) {
                            case "entero":
                                if ((char) resultado1.valor > (int) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "decimal":
                                if ((char) resultado1.valor > (double) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "booleano":
                                if (getCharValor(resultado1.valor, raiz) > getBoolValor(resultado2.valor)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "caracter":
                                if ((char) resultado1.valor > (char) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "cadena":
                                valComp = ((char) resultado1.valor + "").compareTo((String) resultado2.valor);
                                if (valComp > 0) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            default:
                                break;
                        }
                        break;
                    case "cadena":
                        switch (resultado2.tipo) {
                            case "entero":
                            case "decimal":
                                Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No es posible comparar valores tipo numerico con cadenas");
                                break;
                            case "booleano":
                                if (getStringValor(resultado1.valor, raiz) > getBoolValor(resultado2.valor)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "caracter":
                                valComp = ((String) resultado1.valor).compareTo((char) resultado2.valor + "");
                                if (valComp > 0) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "cadena":
                                valComp = ((String) resultado1.valor).compareTo((String) resultado2.valor);
                                if (valComp > 0) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
                break;

            case "MENIQ":
                Resultado_S aux2 = resultado1;
                resultado1 = resultado2;
                resultado2 = aux2;
                switch (resultado1.tipo) {
                    case "entero":
                        switch (resultado2.tipo) {
                            case "entero":
                                if ((int) resultado1.valor >= (int) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "decimal":
                                if ((int) resultado1.valor >= (double) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "booleano":
                                if ((int) resultado1.valor >= getBoolValor(resultado2.valor)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "caracter":
                                if ((int) resultado1.valor >= (char) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "cadena":
                                Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No es posible comparar valores tipo numerico con cadenas");
                                break;
                            default:
                                break;
                        }
                        break;
                    case "decimal":
                        switch (resultado2.tipo) {
                            case "entero":
                                if ((double) resultado1.valor >= (int) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "decimal":
                                if ((double) resultado1.valor >= (double) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "booleano":
                                if ((double) resultado1.valor >= getBoolValor(resultado2.valor)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "caracter":
                                if ((double) resultado1.valor >= (char) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "cadena":
                                Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No es posible comparar valores tipo numerico con cadenas");
                                break;
                            default:
                                break;
                        }
                        break;
                    case "booleano":
                        switch (resultado2.tipo) {
                            case "entero":
                                if (getBoolValor(resultado1.valor) >= (int) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "decimal":
                                if (getBoolValor(resultado1.valor) >= (double) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "booleano":
                                if (getBoolValor(resultado1.valor) >= getBoolValor(resultado2.valor)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "caracter":
                                if (getBoolValor(resultado1.valor) >= getCharValor(resultado2.valor, raiz)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "cadena":
                                if (getBoolValor(resultado1.valor) >= getStringValor(resultado2.valor, raiz)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            default:
                                break;
                        }
                        break;
                    case "caracter":
                        switch (resultado2.tipo) {
                            case "entero":
                                if ((char) resultado1.valor >= (int) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "decimal":
                                if ((char) resultado1.valor >= (double) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "booleano":
                                if (getCharValor(resultado1.valor, raiz) >= getBoolValor(resultado2.valor)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "caracter":
                                if ((char) resultado1.valor >= (char) resultado2.valor) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "cadena":
                                valComp = ((char) resultado1.valor + "").compareTo((String) resultado2.valor);
                                if (valComp >= 0) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            default:
                                break;
                        }
                        break;
                    case "cadena":
                        switch (resultado2.tipo) {
                            case "entero":
                            case "decimal":
                                Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No es posible comparar valores tipo numerico con cadenas");
                                break;
                            case "booleano":
                                if (getStringValor(resultado1.valor, raiz) >= getBoolValor(resultado2.valor)) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "caracter":
                                valComp = ((String) resultado1.valor).compareTo((char) resultado2.valor + "");
                                if (valComp >= 0) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "cadena":
                                valComp = ((String) resultado1.valor).compareTo((String) resultado2.valor);
                                if (valComp >= 0) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
        return new Resultado_S("-1", false);

    }
    public Resultado_S operaciones_aritmeticas(Resultado_S resultado1,Resultado_S resultado2,Simbolo_S simbolo,Nodo raiz)
    {
        //------------------------operaciones-------------------------
        Object valor = new Object();
        switch (raiz.nombre) {
            case "MAS":
                switch (resultado1.tipo) {
                    case "entero":
                        switch (resultado2.tipo) {
                            case "entero":
                                valor = (int) resultado1.valor + (int) resultado2.valor;
                                return new Resultado_S(getTipo(valor), valor);
                            case "decimal":
                                valor = (int) resultado1.valor + (Double) resultado2.valor;
                                return new Resultado_S(getTipo(valor), valor);
                            case "booleano":
                                valor = (int) resultado1.valor + getBoolValor(resultado2.valor);
                                return new Resultado_S(getTipo(valor), valor);
                            case "caracter":
                                valor = (int) resultado1.valor + (char) resultado2.valor;
                                return new Resultado_S(getTipo(valor), valor);
                            case "cadena":
                                valor = (int) resultado1.valor + (String) resultado2.valor;
                                return new Resultado_S(getTipo(valor), valor);
                            default:
                        }
                        break;
                    case "decimal":
                        switch (resultado2.tipo) {
                            case "entero":
                                valor = (Double) resultado1.valor + (int) resultado2.valor;
                                return new Resultado_S(getTipo(valor), valor);
                            case "decimal":
                                valor = (Double) resultado1.valor + (Double) resultado2.valor;
                                return new Resultado_S(getTipo(valor), valor);
                            case "booleano":
                                valor = (Double) resultado1.valor + getBoolValor(resultado2.valor);
                                return new Resultado_S(getTipo(valor), valor);
                            case "caracter":
                                valor = (Double) resultado1.valor + (char) resultado2.valor;
                                return new Resultado_S(getTipo(valor), valor);
                            case "cadena":
                                valor = (double) resultado1.valor + (String) resultado2.valor;
                                return new Resultado_S(getTipo(valor), valor);
                            default:
                        }
                        break;
                    case "booleano":
                        switch (resultado2.tipo) {
                            case "entero":
                                valor = getBoolValor(resultado1.valor) + (int) resultado2.valor;
                                return new Resultado_S(getTipo(valor), valor);
                            case "decimal":
                                valor = getBoolValor(resultado1.valor) + (Double) resultado2.valor;
                                return new Resultado_S(getTipo(valor), valor);
                            case "booleano":
                                valor = getBoolValor(resultado1.valor) + getBoolValor(resultado2.valor);
                                if ((int) valor == 2 || (int) valor == 1) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }

                            case "caracter":
                            case "cadena":
                                Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede sumar datos tipo Bool con Cadenas y Caracteres");
                                break;
                            default:
                        }
                        break;
                    case "caracter":
                        switch (resultado2.tipo) {
                            case "entero":
                                valor = (char) resultado1.valor + (int) resultado2.valor;
                                return new Resultado_S(getTipo(valor), valor);
                            case "decimal":
                                valor = (char) resultado1.valor + (Double) resultado2.valor;
                                return new Resultado_S(getTipo(valor), valor);
                            case "booleano":
                            case "caracter":
                                Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede sumar datos tipo Caracter con Caracteres y Booleanos");
                                break;
                            case "cadena":
                                valor = (char) resultado1.valor + (String) resultado2.valor;
                                return new Resultado_S(getTipo(valor), valor);
                            default:
                        }
                        break;
                    case "cadena":
                        switch (resultado2.tipo) {
                            case "entero":
                                valor = (String) resultado1.valor + (int) resultado2.valor;
                                return new Resultado_S(getTipo(valor), valor);
                            case "decimal":
                                valor = (String) resultado1.valor + (Double) resultado2.valor;
                                return new Resultado_S(getTipo(valor), valor);
                            case "booleano":
                                valor = (String) resultado1.valor + getBoolValor(resultado2.valor);
                                //Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede sumar datos tipo Cadena con Booleanos");
                                return new Resultado_S(getTipo(valor), valor);
                            case "caracter":
                                valor = (String) resultado1.valor + (char) resultado2.valor;
                                return new Resultado_S(getTipo(valor), valor);
                            case "cadena":
                                valor = (String) resultado1.valor + (String) resultado2.valor;
                                return new Resultado_S(getTipo(valor), valor);
                            default:
                        }
                    default:
                }

                break;
            case "MENOS":
                switch (resultado1.tipo) {
                    case "entero":
                        switch (resultado2.tipo) {
                            case "entero":
                                valor = (int) resultado1.valor - (int) resultado2.valor;
                                return new Resultado_S(getTipo(valor), valor);
                            case "decimal":
                                valor = (int) resultado1.valor - (Double) resultado2.valor;
                                return new Resultado_S(getTipo(valor), valor);
                            case "booleano":
                                valor = (int) resultado1.valor - getBoolValor(resultado2.valor);
                                return new Resultado_S(getTipo(valor), valor);
                            case "caracter":
                                valor = (int) resultado1.valor - (char) resultado2.valor;
                                return new Resultado_S(getTipo(valor), valor);
                            case "cadena":
                                Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede restar datos tipo entero con Cadenas");
                                break;
                            default:
                        }
                        break;
                    case "decimal":
                        switch (resultado2.tipo) {
                            case "entero":
                                valor = (Double) resultado1.valor - (int) resultado2.valor;
                                return new Resultado_S(getTipo(valor), valor);
                            case "decimal":
                                valor = (Double) resultado1.valor - (Double) resultado2.valor;
                                return new Resultado_S(getTipo(valor), valor);
                            case "booleano":
                                valor = (Double) resultado1.valor - getBoolValor(resultado2.valor);
                                return new Resultado_S(getTipo(valor), valor);
                            case "caracter":
                                valor = (Double) resultado1.valor - (char) resultado2.valor;
                                return new Resultado_S(getTipo(valor), valor);
                            case "cadena":
                                Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede restar datos tipo Decimal con Cadenas");
                                break;
                            default:
                        }
                        break;
                    case "booleano":
                        switch (resultado2.tipo) {
                            case "entero":
                                valor = getBoolValor(resultado1.valor) - (int) resultado2.valor;
                                return new Resultado_S(getTipo(valor), valor);
                            case "decimal":
                                valor = getBoolValor(resultado1.valor) - (Double) resultado2.valor;
                                return new Resultado_S(getTipo(valor), valor);
                            case "booleano":
                            case "caracter":
                            case "cadena":
                                Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede restar datos tipo Bool con Cadenas,Booleanos y Caracteres");
                                break;
                            default:
                        }
                        break;
                    case "caracter":
                        switch (resultado2.tipo) {
                            case "entero":
                                valor = (char) resultado1.valor - (int) resultado2.valor;
                                return new Resultado_S(getTipo(valor), valor);
                            case "decimal":
                                valor = (char) resultado1.valor - (Double) resultado2.valor;
                                return new Resultado_S(getTipo(valor), valor);
                            case "caracter":
                                valor = (char) resultado1.valor - (char) resultado2.valor;
                                return new Resultado_S(getTipo(valor), valor);
                            case "booleano":
                            case "cadena":
                                Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede restar datos tipo Caracter con Cadenas y Booleanos");
                                break;
                            default:
                        }
                        break;
                    case "cadena":
                        switch (resultado2.tipo) {
                            case "entero":
                            case "decimal":
                            case "booleano":
                            case "caracter":
                            case "cadena":
                                Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede restar datos tipo Cadena con cualquier otro tipo de dato");
                                break;
                            default:
                        }
                    default:
                }

                break;
            case "POR":
                switch (resultado1.tipo) {
                    case "entero":
                        switch (resultado2.tipo) {
                            case "entero":
                                valor = (int) resultado1.valor * (int) resultado2.valor;
                                return new Resultado_S(getTipo(valor), valor);
                            case "decimal":
                                valor = (int) resultado1.valor * (Double) resultado2.valor;
                                return new Resultado_S(getTipo(valor), valor);
                            case "booleano":
                                valor = (int) resultado1.valor * getBoolValor(resultado2.valor);
                                return new Resultado_S(getTipo(valor), valor);
                            case "caracter":
                                valor = (int) resultado1.valor * (char) resultado2.valor;
                                return new Resultado_S(getTipo(valor), valor);
                            case "cadena":
                                Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede multiplicar datos tipo entero con Cadenas");
                                break;
                            default:
                        }
                        break;
                    case "decimal":
                        switch (resultado2.tipo) {
                            case "entero":
                                valor = (Double) resultado1.valor * (int) resultado2.valor;
                                return new Resultado_S(getTipo(valor), valor);
                            case "decimal":
                                String tip = resultado1.valor.getClass().getSimpleName();
                                valor = (Double) resultado1.valor * (Double) resultado2.valor;
                                return new Resultado_S(getTipo(valor), valor);
                            case "booleano":
                                valor = (Double) resultado1.valor * getBoolValor(resultado2.valor);
                                return new Resultado_S(getTipo(valor), valor);
                            case "caracter":
                                valor = (Double) resultado1.valor * (char) resultado2.valor;
                                return new Resultado_S(getTipo(valor), valor);
                            case "cadena":
                                Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede multiplicar datos tipo Decimal con Cadenas");
                                break;
                            default:
                        }
                        break;
                    case "booleano":
                        switch (resultado2.tipo) {
                            case "entero":
                                valor = getBoolValor(resultado1.valor) * (int) resultado2.valor;
                                return new Resultado_S(getTipo(valor), valor);
                            case "decimal":
                                valor = getBoolValor(resultado1.valor) * (Double) resultado2.valor;
                                return new Resultado_S(getTipo(valor), valor);
                            case "booleano":
                                valor = getBoolValor(resultado1.valor) * getBoolValor(resultado2.valor);
                                if ((int) valor == 1) {
                                    return new Resultado_S("booleano", true);
                                } else {
                                    return new Resultado_S("booleano", false);
                                }
                            case "caracter":
                            case "cadena":
                                Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede multiplicar datos tipo Bool con Cadenas y Caracteres");
                                break;
                            default:
                        }
                        break;
                    case "caracter":
                        switch (resultado2.tipo) {
                            case "entero":
                                valor = (char) resultado1.valor * (int) resultado2.valor;
                                return new Resultado_S(getTipo(valor), valor);
                            case "decimal":
                                valor = (char) resultado1.valor * (Double) resultado2.valor;
                                return new Resultado_S(getTipo(valor), valor);
                            case "caracter":
                                valor = (char) resultado1.valor * (char) resultado2.valor;
                                return new Resultado_S(getTipo(valor), valor);
                            case "booleano":
                            case "cadena":
                                Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede multiplicar datos tipo Caracter con Cadenas y Booleanos");
                                break;
                            default:
                        }
                        break;
                    case "cadena":
                        switch (resultado2.tipo) {
                            case "entero":
                            case "decimal":
                            case "booleano":
                            case "caracter":
                            case "cadena":
                                Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede multiplicar datos tipo Cadena con cualquier otro tipo de dato");
                                break;
                            default:
                        }
                    default:
                }

                break;
            case "DIV":
                try {
                    switch (resultado1.tipo) {
                        case "entero":
                            switch (resultado2.tipo) {
                                case "entero":
                                    try {
                                        valor = (int) resultado1.valor / (int) resultado2.valor;
                                    } catch (Exception e) {
                                        Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede dividir un numero por 0 (" + e.toString() + ")");
                                        return new Resultado_S("-1", valor);
                                    }
                                    return new Resultado_S(getTipo(valor), valor);
                                case "decimal":
                                    try {
                                        valor = (int) resultado1.valor / (Double) resultado2.valor;
                                    } catch (Exception e) {
                                        Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede dividir un numero por 0 (" + e.toString() + ")");
                                        return new Resultado_S("-1", valor);
                                    }
                                    return new Resultado_S(getTipo(valor), valor);
                                case "booleano":
                                    try {
                                        valor = (int) resultado1.valor / getBoolValor(resultado2.valor);
                                    } catch (Exception e) {
                                        Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede dividir un numero por 0 (" + e.toString() + ")");
                                        return new Resultado_S("-1", valor);
                                    }
                                    return new Resultado_S(getTipo(valor), valor);
                                case "caracter":
                                    try {
                                        valor = (int) resultado1.valor / (char) resultado2.valor;
                                    } catch (Exception e) {
                                        Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede dividir un numero por 0 (" + e.toString() + ")");
                                        return new Resultado_S("-1", valor);
                                    }
                                    return new Resultado_S(getTipo(valor), valor);
                                case "cadena":
                                    Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede dividir datos tipo entero con Cadenas");
                                    break;
                                default:
                            }
                            break;
                        case "decimal":
                            switch (resultado2.tipo) {
                                case "entero":
                                    try {
                                        valor = (Double) resultado1.valor / (int) resultado2.valor;
                                    } catch (Exception e) {
                                        Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede dividir un numero por 0 (" + e.toString() + ")");
                                        return new Resultado_S("-1", valor);
                                    }
                                    return new Resultado_S(getTipo(valor), valor);
                                case "decimal":
                                    try {
                                        valor = (Double) resultado1.valor / (Double) resultado2.valor;
                                    } catch (Exception e) {
                                        Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede dividir un numero por 0 (" + e.toString() + ")");
                                        return new Resultado_S("-1", valor);
                                    }
                                    return new Resultado_S(getTipo(valor), valor);
                                case "booleano":
                                    try {
                                        valor = (Double) resultado1.valor / getBoolValor(resultado2.valor);
                                    } catch (Exception e) {
                                        Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede dividir un numero por 0 (" + e.toString() + ")");
                                        return new Resultado_S("-1", valor);
                                    }
                                    return new Resultado_S(getTipo(valor), valor);
                                case "caracter":
                                    try {
                                        valor = (Double) resultado1.valor / (char) resultado2.valor;
                                    } catch (Exception e) {
                                        Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede dividir un numero por 0 (" + e.toString() + ")");
                                        return new Resultado_S("-1", valor);
                                    }
                                    return new Resultado_S(getTipo(valor), valor);
                                case "cadena":
                                    Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede dividir datos tipo Decimal con Cadenas");
                                    break;
                                default:
                            }
                            break;
                        case "booleano":
                            switch (resultado2.tipo) {
                                case "entero":
                                    try {
                                        valor = getBoolValor(resultado1.valor) / (int) resultado2.valor;
                                    } catch (Exception e) {
                                        Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede dividir un numero por 0 (" + e.toString() + ")");
                                        return new Resultado_S("-1", valor);
                                    }
                                    return new Resultado_S(getTipo(valor), valor);
                                case "decimal":
                                    try {
                                        valor = getBoolValor(resultado1.valor) / (Double) resultado2.valor;
                                    } catch (Exception e) {
                                        Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede dividir un numero por 0 (" + e.toString() + ")");
                                        return new Resultado_S("-1", valor);
                                    }
                                    return new Resultado_S(getTipo(valor), valor);
                                case "booleano":
                                case "caracter":
                                case "cadena":
                                    Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede dividir datos tipo Bool con Cadenas,Booleanos y Caracteres");
                                    break;
                                default:
                            }
                            break;
                        case "caracter":
                            switch (resultado2.tipo) {
                                case "entero":
                                    try {
                                        valor = (char) resultado1.valor / (int) resultado2.valor;
                                    } catch (Exception e) {
                                        Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede dividir un numero por 0 (" + e.toString() + ")");
                                        return new Resultado_S("-1", valor);
                                    }
                                    return new Resultado_S(getTipo(valor), valor);
                                case "decimal":
                                    try {
                                        valor = (char) resultado1.valor / (Double) resultado2.valor;
                                    } catch (Exception e) {
                                        Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede dividir un numero por 0 (" + e.toString() + ")");
                                        return new Resultado_S("-1", valor);
                                    }
                                    return new Resultado_S(getTipo(valor), valor);
                                case "caracter":
                                    try {
                                        valor = (char) resultado1.valor / (char) resultado2.valor;
                                    } catch (Exception e) {
                                        Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede dividir un numero por 0 (" + e.toString() + ")");
                                        return new Resultado_S("-1", valor);
                                    }
                                    return new Resultado_S(getTipo(valor), valor);
                                case "booleano":
                                case "cadena":
                                    Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede dividir datos tipo Caracter con Cadenas y Booleanos");
                                    break;
                                default:
                            }
                            break;
                        case "cadena":
                            switch (resultado2.tipo) {
                                case "entero":
                                case "decimal":
                                case "booleano":
                                case "caracter":
                                case "cadena":
                                    Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede dividir datos tipo Cadena con cualquier otro tipo de dato");
                                    break;
                                default:
                            }
                        default:
                    }
                } catch (Exception e) {
                    Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede dividir un numero con 0");
                }

                break;
            case "MOD":
                try {
                    switch (resultado1.tipo) {
                        case "entero":
                            switch (resultado2.tipo) {
                                case "entero":
                                    try {
                                        valor = (int) resultado1.valor % (int) resultado2.valor;
                                    } catch (Exception e) {
                                        Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede dividir un numero por 0 (" + e.toString() + ")");
                                        return new Resultado_S("-1", valor);
                                    }
                                    return new Resultado_S(getTipo(valor), valor);
                                case "decimal":
                                    try {
                                        valor = (int) resultado1.valor % (Double) resultado2.valor;
                                    } catch (Exception e) {
                                        Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede dividir un numero por 0 (" + e.toString() + ")");
                                        return new Resultado_S("-1", valor);
                                    }
                                    return new Resultado_S(getTipo(valor), valor);
                                case "booleano":
                                    try {
                                        valor = (int) resultado1.valor % getBoolValor(resultado2.valor);
                                    } catch (Exception e) {
                                        Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede dividir un numero por 0 (" + e.toString() + ")");
                                        return new Resultado_S("-1", valor);
                                    }
                                    return new Resultado_S(getTipo(valor), valor);
                                case "caracter":
                                    try {
                                        valor = (int) resultado1.valor % (char) resultado2.valor;
                                    } catch (Exception e) {
                                        Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede dividir un numero por 0 (" + e.toString() + ")");
                                        return new Resultado_S("-1", valor);
                                    }
                                    return new Resultado_S(getTipo(valor), valor);
                                case "cadena":
                                    Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede usar el operador Modulo en datos tipo entero con Cadenas");
                                    break;
                                default:
                            }
                            break;
                        case "decimal":
                            switch (resultado2.tipo) {
                                case "entero":
                                    try {
                                        valor = (Double) resultado1.valor % (int) resultado2.valor;
                                    } catch (Exception e) {
                                        Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede dividir un numero por 0 (" + e.toString() + ")");
                                        return new Resultado_S("-1", valor);
                                    }
                                    return new Resultado_S(getTipo(valor), valor);
                                case "decimal":
                                    try {
                                        valor = (Double) resultado1.valor % (Double) resultado2.valor;
                                    } catch (Exception e) {
                                        Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede dividir un numero por 0 (" + e.toString() + ")");
                                        return new Resultado_S("-1", valor);
                                    }
                                    return new Resultado_S(getTipo(valor), valor);
                                case "booleano":
                                    try {
                                        valor = (Double) resultado1.valor % getBoolValor(resultado2.valor);
                                    } catch (Exception e) {
                                        Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede dividir un numero por 0 (" + e.toString() + ")");
                                        return new Resultado_S("-1", valor);
                                    }
                                    return new Resultado_S(getTipo(valor), valor);
                                case "caracter":
                                    try {
                                        valor = (Double) resultado1.valor % (char) resultado2.valor;
                                    } catch (Exception e) {
                                        Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede dividir un numero por 0 (" + e.toString() + ")");
                                        return new Resultado_S("-1", valor);
                                    }
                                    return new Resultado_S(getTipo(valor), valor);
                                case "cadena":
                                    Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede usar el operador Modulo en datos tipo Decimal con Cadenas");
                                    break;
                                default:
                            }
                            break;
                        case "booleano":
                            switch (resultado2.tipo) {
                                case "entero":
                                    try {
                                        valor = getBoolValor(resultado1.valor) % (int) resultado2.valor;
                                    } catch (Exception e) {
                                        Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede dividir un numero por 0 (" + e.toString() + ")");
                                        return new Resultado_S("-1", valor);
                                    }
                                    return new Resultado_S(getTipo(valor), valor);
                                case "decimal":
                                    try {
                                        valor = getBoolValor(resultado1.valor) % (Double) resultado2.valor;
                                    } catch (Exception e) {
                                        Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede dividir un numero por 0 (" + e.toString() + ")");
                                        return new Resultado_S("-1", valor);
                                    }
                                    return new Resultado_S(getTipo(valor), valor);
                                case "booleano":
                                case "caracter":
                                case "cadena":
                                    Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede usar el operador Modulo en datos tipo Bool con Cadenas,Booleanos y Caracteres");
                                    break;
                                default:
                            }
                            break;
                        case "caracter":
                            switch (resultado2.tipo) {
                                case "entero":
                                    try {
                                        valor = (char) resultado1.valor % (int) resultado2.valor;
                                    } catch (Exception e) {
                                        Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede dividir un numero por 0 (" + e.toString() + ")");
                                        return new Resultado_S("-1", valor);
                                    }
                                    return new Resultado_S(getTipo(valor), valor);
                                case "decimal":
                                    try {
                                        valor = (char) resultado1.valor % (Double) resultado2.valor;
                                    } catch (Exception e) {
                                        Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede dividir un numero por 0 (" + e.toString() + ")");
                                        return new Resultado_S("-1", valor);
                                    }
                                    return new Resultado_S(getTipo(valor), valor);
                                case "caracter":
                                    try {
                                        valor = (char) resultado1.valor % (char) resultado2.valor;
                                    } catch (Exception e) {
                                        Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede dividir un numero por 0 (" + e.toString() + ")");
                                        return new Resultado_S("-1", valor);
                                    }
                                    return new Resultado_S(getTipo(valor), valor);
                                case "booleano":
                                case "cadena":
                                    Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede usar el operador Modulo en datos tipo Caracter con Cadenas y Booleanos");
                                    break;
                                default:
                            }
                            break;
                        case "cadena":
                            switch (resultado2.tipo) {
                                case "entero":
                                case "decimal":
                                case "booleano":
                                case "caracter":
                                case "cadena":
                                    Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede usar el operador Modulo  en datos tipo Cadena con cualquier otro tipo de dato");
                                    break;
                                default:
                            }
                        default:
                    }
                } catch (Exception e) {
                    Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede dividir un numero con 0");
                }

                break;
            case "POT":
                Double doubleVal;
                switch (resultado1.tipo) {
                    case "entero":
                        switch (resultado2.tipo) {
                            case "entero":
                                if ((int) resultado1.valor == 0 && (int) resultado2.valor < 0) {
                                    doubleVal = 0.0;
                                    Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede dividir un numero con 0");
                                    return new Resultado_S("-1", doubleVal);
                                } else {
                                    doubleVal = Math.pow((int) resultado1.valor, (int) resultado2.valor);
                                }
                                valor = doubleVal.intValue();
                                return new Resultado_S(getTipo(valor), valor);
                            case "decimal":
                                if ((int) resultado1.valor == 0 && (Double) resultado2.valor < 0) {
                                    doubleVal = 0.0;
                                    Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede dividir un numero con 0");
                                    return new Resultado_S("-1", doubleVal);
                                } else {
                                    valor = Math.pow((int) resultado1.valor, (Double) resultado2.valor);
                                }
                                //valor = Math.pow((int) resultado1.valor, (Double) resultado2.valor);
                                return new Resultado_S(getTipo(valor), valor);
                            case "booleano":
                                if ((int) resultado1.valor == 0 && getBoolValor(resultado2.valor) < 0) {
                                    doubleVal = 0.0;
                                    Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede dividir un numero con 0");
                                    return new Resultado_S("-1", doubleVal);
                                } else {
                                    doubleVal = Math.pow((int) resultado1.valor, getBoolValor(resultado2.valor));
                                }
                                //doubleVal = Math.pow((int) resultado1.valor, getBoolValor(resultado2.valor));
                                valor = doubleVal.intValue();
                                return new Resultado_S(getTipo(valor), valor);
                            case "caracter":
                                doubleVal = Math.pow((int) resultado1.valor, (char) resultado2.valor);
                                valor = doubleVal.intValue();
                                return new Resultado_S(getTipo(valor), valor);
                            case "cadena":
                                Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede usar el operador Potencia en datos tipo entero con Cadenas");
                                break;
                            default:
                        }
                        break;
                    case "decimal":
                        switch (resultado2.tipo) {
                            case "entero":
                                if ((Double) resultado1.valor == 0 && (int) resultado2.valor < 0) {
                                    doubleVal = 0.0;
                                    Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede dividir un numero con 0");
                                    return new Resultado_S("-1", doubleVal);
                                } else {
                                    valor = Math.pow((Double) resultado1.valor, (int) resultado2.valor);
                                }
                                //valor = Math.pow((Double) resultado1.valor, (int) resultado2.valor);
                                return new Resultado_S(getTipo(valor), valor);
                            case "decimal":
                                if ((Double) resultado1.valor == 0 && (Double) resultado2.valor < 0) {
                                    doubleVal = 0.0;
                                    Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede dividir un numero con 0");
                                    return new Resultado_S("-1", doubleVal);
                                } else {
                                    valor = Math.pow((Double) resultado1.valor, (Double) resultado2.valor);
                                }
                                //valor = Math.pow((Double) resultado1.valor, (Double) resultado2.valor);
                                return new Resultado_S(getTipo(valor), valor);
                            case "booleano":
                                valor = Math.pow((Double) resultado1.valor, getBoolValor(resultado2.valor));
                                return new Resultado_S(getTipo(valor), valor);
                            case "caracter":
                                valor = Math.pow((Double) resultado1.valor, (char) resultado2.valor);
                                return new Resultado_S(getTipo(valor), valor);
                            case "cadena":
                                Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede usar el operador Potencia en datos tipo Decimal con Cadenas");
                                break;
                            default:
                        }
                        break;
                    case "booleano":
                        switch (resultado2.tipo) {
                            case "entero":
                                doubleVal = Math.pow(getBoolValor(resultado1.valor), (int) resultado2.valor);
                                valor = doubleVal.intValue();
                                return new Resultado_S(getTipo(valor), valor);
                            case "decimal":
                                valor = Math.pow(getBoolValor(resultado1.valor), (Double) resultado2.valor);
                                return new Resultado_S(getTipo(valor), valor);
                            case "booleano":
                            case "caracter":
                            case "cadena":
                                Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede usar el operador Potencia en datos tipo Bool con Cadenas,Booleanos y Caracteres");
                                break;
                            default:
                        }
                        break;
                    case "caracter":
                        switch (resultado2.tipo) {
                            case "entero":
                                doubleVal = Math.pow((char) resultado1.valor, (int) resultado2.valor);
                                valor = doubleVal.intValue();
                                return new Resultado_S(getTipo(valor), valor);
                            case "decimal":
                                valor = Math.pow((char) resultado1.valor, (Double) resultado2.valor);
                                return new Resultado_S(getTipo(valor), valor);
                            case "caracter":
                                doubleVal = Math.pow((char) resultado1.valor, (char) resultado2.valor);
                                valor = doubleVal.intValue();
                                return new Resultado_S(getTipo(valor), valor);
                            case "booleano":
                            case "cadena":
                                Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede usar el operador Potencia en datos tipo Caracter con Cadenas y Booleanos");
                                break;
                            default:
                        }
                        break;
                    case "cadena":
                        switch (resultado2.tipo) {
                            case "entero":
                            case "decimal":
                            case "booleano":
                            case "caracter":
                            case "cadena":
                                Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se puede usar el operador Potencia en datos tipo Cadena con cualquier otro tipo de dato");
                                break;
                            default:
                        }
                    default:
                }

            default:
                break;
        }
        return new Resultado_S("-1", null);
    }
    
    private Resultado_S operacionSimplificada(String tipo, Nodo raiz) {

        Simbolo_S simbolo = null;
        if (raiz.nombre.equals("acceso")) {
            int ent = 0;
            double doble;
            char c;
            simbolo = getSimbolo(raiz, tipo);
            if (simbolo != null) {
                if (tipo.equals("incremento")) {
                    switch (simbolo.tipo) {
                        case "entero":
                            ent = (int) simbolo.valor;
                            simbolo.valor = (int) simbolo.valor + 1;
                            return new Resultado_S(simbolo.tipo, ent);
                        case "decimal":
                            doble = (double) simbolo.valor;
                            simbolo.valor = (double) simbolo.valor + 1;
                            return new Resultado_S(simbolo.tipo, doble);
                        case "caracter":
                            c = (char) simbolo.valor;
                            simbolo.valor = (char) ((char) simbolo.valor + 1);
                            return new Resultado_S(simbolo.tipo, c);
                        default:
                            Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "Las operaciones simplificadas solo son validas con datos tipo entero,decimal y caracter");
                            break;
                    }
                } else {
                    switch (simbolo.tipo) {
                        case "entero":
                            ent = (int) simbolo.valor;
                            simbolo.valor = (int) simbolo.valor - 1;
                            return new Resultado_S(simbolo.tipo, ent);
                        case "decimal":
                            doble = (double) simbolo.valor;
                            simbolo.valor = (double) simbolo.valor - 1;
                            return new Resultado_S(simbolo.tipo, doble);
                        case "caracter":
                            c = (char) simbolo.valor;
                            simbolo.valor = (char) ((char) simbolo.valor - 1);
                            return new Resultado_S(simbolo.tipo, c);
                        default:
                            Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "Las operaciones simplificadas solo son validas con datos tipo entero,decimal y caracter");
                            return new Resultado_S("-1", null);
                    }
                }
            }
        } else {
            Resultado_S resultado = operar(raiz);
            Object valor = resultado.valor;
            if (resultado.tipo.equals("entero") || resultado.tipo.equals("decimal") || resultado.tipo.equals("caracter")) {
                if (tipo.equals("incremento")) {
                    switch (resultado.tipo) {
                        case "entero":
                            valor = (int) resultado.valor + 1;
                            break;
                        case "decimal":
                            valor = (Double) resultado.valor + 1;
                            break;
                        case "caracter":
                            valor = (char) resultado.valor + 1;
                    }
                    return new Resultado_S(getTipo(valor), valor);
                } else {//si es --
                    switch (resultado.tipo) {
                        case "entero":
                            valor = (int) resultado.valor - 1;
                            break;
                        case "decimal":
                            valor = (Double) resultado.valor - 1;
                            break;
                        case "caracter":
                            valor = (char) resultado.valor - 1;
                    }
                    return new Resultado_S(getTipo(valor), valor);
                }
            } else {
                Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "No se pueden realizar operaciones simplificadas sobre datos tipo cadena y bool");
                return new Resultado_S("-1", null);
            }
        }
        return new Resultado_S("-1", null);
    }
    
    private Simbolo_S getSimbolo(Nodo raiz, String tipo) {

        Clase aux = Draco_Script_S.claseActual;
        TablaSimbolo_S tablaAux = tabla;
        Simbolo_S sim = null;

        
        Resultado_S retorno;
        for (Nodo acceso : raiz.hijos) {
            String nombre;
            Simbolo_S simbolo;
            switch (acceso.nombre) {
                
                case "id":
                    nombre = acceso.valor;
                    simbolo = tabla.getSimbolo(nombre, aux);

                    if (simbolo != null) {
                        if (!simbolo.inicializado) {
                            Inicio.reporteError.agregar("Semantico",acceso.linea,acceso.columna,"La variable "+nombre+" no ha sido inicializada");
                        }
                    }
                    if (simbolo != null) {
                        if (simbolo.inicializado) {
                            
                            switch (simbolo.tipo) {
                                case "entero":
                                case "cadena":
                                case "booleano":
                                case "caracter":
                                case "decimal":
                                    sim = simbolo;
                                    break;                    
                            }
                        } else {
                            Inicio.reporteError.agregar("Semantico", acceso.linea, acceso.columna, "La variable " + nombre + " no ha sido inicializada");
                            return null;
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

    private Resultado_S acceso(Nodo raiz) {
        Clase aux = Draco_Script_S.claseActual;
        TablaSimbolo_S tablaAux = tabla;
        
        int nivel = 0;
        Resultado_S retorno = new Resultado_S("-1", null);
        for (Nodo acceso : raiz.hijos) {
            String nombre;
            Simbolo_S simbolo;
            switch (acceso.nombre) {
                
                case "id":

                    nombre = acceso.valor;
                    simbolo = tabla.getSimbolo(nombre, aux);

                    if (simbolo != null) {
                        if (!simbolo.inicializado) {
                            Inicio.reporteError.agregar("Semantico",acceso.linea,acceso.columna,"La variable "+nombre+" no ha sido inicializada");
                        }
                    }
                    
                    if (simbolo != null) {
                        if (simbolo.inicializado) {
                            switch (simbolo.tipo) {
                                case "entero":
                                case "cadena":
                                case "booleano":
                                case "caracter":
                                case "decimal":
                                    retorno.valor = simbolo.valor;
                                    retorno.tipo = simbolo.tipo;
                                    retorno.simbolo = simbolo;
                                    break;
                                
                            }
                        } else {
                            retorno.tipo = "-1";
                            retorno.valor = null;
                            Inicio.reporteError.agregar("Semantico", acceso.linea, acceso.columna, "La variable " + nombre + " no ha sido inicializada");
                            return retorno;
                        }
                    } else {
                        retorno.tipo = "-1";
                        retorno.valor = null;
                        Inicio.reporteError.agregar("Semantico", acceso.linea, acceso.columna, "La variable " + nombre + " no existe en el ambito donde fue invocada");
                        return retorno;
                    }
                    break;
            }

        }
        tabla = tablaAux;
        return retorno;
    }
    
    
}
