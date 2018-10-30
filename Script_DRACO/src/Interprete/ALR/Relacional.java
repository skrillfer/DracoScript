/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interprete.ALR;

import ESTRUCTURAS.Nodo;
import ESTRUCTURAS.Resultado;

/**
 *
 * @author fernando
 */
public class Relacional extends Interprete.Interpretacion {

    public Resultado OPERAR(Nodo RAIZ) {
        Resultado r1 = null;
        Resultado r2 = null;
        switch (RAIZ.nombre) {
            case "MAS":
            case "MENOS":
            case "POR":
            case "DIV":
            case "POT":
                XopA = new Aritmetica();
                return XopA.OPERAR(RAIZ);
            case "IG_IG":
            case "DIF":
            case "MENQ":
            case "MENIQ":
            case "MAYQ":
            case "MAYIQ":
                XopA = new Aritmetica();
                r1 = XopA.OPERAR(RAIZ.hijos.get(0));
                r2 = XopA.OPERAR(RAIZ.hijos.get(1));
                break;
            default:
                XopA = new Aritmetica();
                r1=XopA.OPERAR(RAIZ);
                return r1;

        }

        switch (RAIZ.nombre) {
            case "IG_IG":
            case "DIF":
            case "MENQ":
            case "MENIQ":
            case "MAYQ":
            case "MAYIQ":    
                switch(r1.tipo)
                {
                    case "entero":
                        switch(r2.tipo)
                        {
                            case "entero":
                                return operacionSimple(r1, getTIPOREL(RAIZ.nombre), r2, "booleano", RAIZ);
                        }
                        break;
                    case "decimal":
                        switch(r2.tipo)
                        {
                            case "decimal":
                                return operacionSimple(r1, getTIPOREL(RAIZ.nombre), r2, "booleano", RAIZ);
                        }
                        break;
                    case "caracter":
                        switch(r2.tipo)
                        {
                            case "caracter":
                                return operacionSimple(r1, getTIPOREL(RAIZ.nombre), r2, "booleano", RAIZ);
                        }
                        break;
                    case "booleano":
                        switch(r2.tipo)
                        {
                            case "booleano":
                                return operacionSimple(r1, getTIPOREL(RAIZ.nombre), r2, "booleano", RAIZ);
                        }
                        break;
                    case "cadena":
                        switch(r2.tipo)
                        {
                            case "cadena":
                                return operacionSimple(r1, getTIPOREL(RAIZ.nombre), r2, "booleano", RAIZ);
                        }
                        break;
                    default:
                        //error
                        break;
                }
            
                
              break;
        }
        return new Resultado("-1", "");
    }
    
    
    public Resultado operacionSimple(Resultado r1,String operador, Resultado r2,String tipo,Nodo nodo)
    {
        String codigo_tmp = "";
        String etqV = control.generar_etiqueta();
        String etqF = control.generar_etiqueta();
        codigo_tmp += operador+"\n";
        codigo_tmp += "br_if " + etqF + "\n";
        codigo_tmp += "br " + etqV + "\n";
        
        Xblockes.agregar(codigo_tmp, nodo);
        return new Resultado("booleano", "",etqV,etqF);
    }
    
    public String getTIPOREL(String str)
    {
        switch(str)
        {
            case "IG_IG":
                return "Eqz";
            case "DIF":
                return "Eqz";
            case "MENQ":
                return "Lt";
            case "MENIQ":
                return "Lte";
            case "MAYQ":
                return "Gt";
            case "MAYIQ":
                return "Gte";
            default:
                return "";
        }
    }
}
