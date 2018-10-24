/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interprete.Sentencias;

import ESTRUCTURAS.Nodo;
import ESTRUCTURAS.Resultado;
import ESTRUCTURAS.Simbolo;
import Interprete.ALR.Aritmetica;
import Interprete.ALR.Logica;

/**
 *
 * @author fernando
 */
public class Declaracion extends Interprete.Interpretacion{
    
    public int declaracionPrimitivaDA(Nodo RAIZ)
    {
        Nodo listaids = RAIZ.hijos.get(1);
        for (Nodo nodo : listaids.hijos) {
            Simbolo simbolo = Interprete.Interpretacion.tabla.obtener_Simbolo(nodo.valor, Interprete.Interpretacion.ambito);
            if(simbolo==null)
            {
                return 0;
            }            
            Simbolo sim_declarado = Interprete.Interpretacion.tabla.HacerSimboloDeclarado(simbolo);
            if(sim_declarado==null)
            {
                return 0;
            }
            
            XopL = new Logica();
            Resultado r1 = XopL.OPERAR(RAIZ.hijos.get(RAIZ.hijos.size()-1));
            r1 = Val_Rel_Logic(r1);
            Xcastear.castear(simbolo, r1, nodo);
            
        }
        
        return 0;
    }
    
    public void declaracionYasignacion1_MANU(Nodo RAIZ)
    {
        for (int i = 0; i < RAIZ.hijos.get(1).hijos.size(); i++) {
            Nodo nodo = RAIZ.hijos.get(1).hijos.get(i);
            Simbolo simbolo = Interprete.Interpretacion.tabla.obtener_Simbolo(nodo.valor, Interprete.Interpretacion.ambito);
            if(simbolo!=null)
            {   
                if(Interprete.Interpretacion.tabla.HacerSimboloDeclarado(simbolo)!=null)
                {
                    System.out.println("Todo bien");
                }
            }
        }
    }
}
