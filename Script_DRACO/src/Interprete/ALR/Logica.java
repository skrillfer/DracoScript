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
public class Logica extends Interprete.Interpretacion{
    
    public Resultado OPERAR(Nodo RAIZ)
    {   Resultado res = null;
        String ETQ_SALIDA="";
        Resultado r1=null;
        Resultado r2=null;
        String codigo_tmp = "";
        switch(RAIZ.nombre)
        {
            case "MAS":
            case "MENOS":
            case "POR":
            case "DIV":
            case "POT":
                XopR = new Relacional();
                return XopR.OPERAR(RAIZ);
            case "IG_IG":
            case "DIF":
            case "MENQ":
            case "MENIQ":
            case "MAYQ":
            case "MAYIQ": 
                XopR = new Relacional();
                return XopR.OPERAR(RAIZ);
            case "AND":
                r1 = this.OPERAR(RAIZ.hijos.get(0));
                
                ETQ_SALIDA = control.generar_etiqueta();
                
                codigo_tmp = r1.ETV+" //----> ETV\n";
                codigo_tmp += "1\n";
                codigo_tmp += "br "+ETQ_SALIDA+"\n";
                
                codigo_tmp += r1.ETF+" //----> ETF\n";
                codigo_tmp += "0\n";
                codigo_tmp += ETQ_SALIDA+"\n";
                
                Xblockes.agregar(codigo_tmp, RAIZ);
                
                
                
                r2 = this.OPERAR(RAIZ.hijos.get(1));
                
                ETQ_SALIDA = control.generar_etiqueta();
                
                codigo_tmp = r2.ETV+" //----> ETV\n";
                codigo_tmp += "1\n";
                codigo_tmp += "br "+ETQ_SALIDA+"\n";
                
                codigo_tmp += r2.ETF+" //----> ETF\n";
                codigo_tmp += "0\n";
                codigo_tmp += ETQ_SALIDA+"\n";
                codigo_tmp += "AND \n";
                
                Xblockes.agregar_AlUltimoBloque(codigo_tmp);
                
                res =new Resultado("booleano", "AND",control.generar_etiqueta(),control.generar_etiqueta());
                return res;
                
               
            case "OR":
                
                r1 = this.OPERAR(RAIZ.hijos.get(0));
                
                ETQ_SALIDA = control.generar_etiqueta();
                
                codigo_tmp = r1.ETV+" //----> ETV\n";
                codigo_tmp += "1\n";
                codigo_tmp += "br "+ETQ_SALIDA+"\n";
                
                codigo_tmp += r1.ETF+" //----> ETF\n";
                codigo_tmp += "0\n";
                codigo_tmp += ETQ_SALIDA+"\n";
                
                Xblockes.agregar(codigo_tmp, RAIZ);
                
                
                
                r2 = this.OPERAR(RAIZ.hijos.get(1));
                
                ETQ_SALIDA = control.generar_etiqueta();
                
                codigo_tmp = r2.ETV+" //----> ETV\n";
                codigo_tmp += "1\n";
                codigo_tmp += "br "+ETQ_SALIDA+"\n";
                
                codigo_tmp += r2.ETF+" //----> ETF\n";
                codigo_tmp += "0\n";
                codigo_tmp += ETQ_SALIDA+"\n";
                codigo_tmp += "OR \n";
                
                Xblockes.agregar_AlUltimoBloque(codigo_tmp);
                
                res =new Resultado("booleano", "OR",control.generar_etiqueta(),control.generar_etiqueta());
                return res;
            case "NOT":
                r1 = this.OPERAR(RAIZ.hijos.get(0));
                
                ETQ_SALIDA = control.generar_etiqueta();
                
                codigo_tmp = r1.ETV+" //----> ETV\n";
                codigo_tmp += "1\n";
                codigo_tmp += "br "+ETQ_SALIDA+"\n";
                
                codigo_tmp += r1.ETF+" //----> ETF\n";
                codigo_tmp += "0\n";
                codigo_tmp += ETQ_SALIDA+"\n";
                codigo_tmp += "NOT \n";

                Xblockes.agregar(codigo_tmp, RAIZ);
                res =new Resultado("booleano", "OR",control.generar_etiqueta(),control.generar_etiqueta());
                return res;

                /*r1 = this.OPERAR(RAIZ.hijos.get(0));
                return new Resultado("booleano", "",r1.ETF,r1.ETV);*/
            default:
                XopR = new Relacional();
                return XopR.OPERAR(RAIZ);
        }
    }
}
