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
    {
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
                
                codigo_tmp = r1.ETV+" \\....ETV \n";
                Xblockes.agregar(codigo_tmp, RAIZ);
                
                r2 = this.OPERAR(RAIZ.hijos.get(1));
                

                return new Resultado("booleano", "AND",r2.ETV,r1.ETF+"\n0\n"+r2.ETF);
                
            case "OR":
                r1 = this.OPERAR(RAIZ.hijos.get(0));
                codigo_tmp = r1.ETF+" \\....ETF \n";
                
                Xblockes.agregar(codigo_tmp, RAIZ);
                
                r2 = this.OPERAR(RAIZ.hijos.get(1));
                return new Resultado("booleano", "OR",r1.ETV+"\n1\n"+r2.ETV,r2.ETF);
            case "NOT":
                r1 = this.OPERAR(RAIZ.hijos.get(0));
                return new Resultado("booleano", "",r1.ETF,r1.ETV);
            default:
                XopR = new Relacional();
                return XopR.OPERAR(RAIZ);

        }
    }
}
