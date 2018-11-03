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
    public int declaracionEstructuraD(Nodo RAIZ)
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
            
            String codigo_tmp = "get_local 0\n";
            codigo_tmp += simbolo.direccion + " //Posicion de la variable:"+simbolo.nombre+"\n";
            codigo_tmp +=  "Add \n";
            
            codigo_tmp += (int)nulo+"\n";
            
            codigo_tmp += "set_local $calc //Asignacion a la variable:"+simbolo.nombre+"\n";
            Xblockes.agregar(codigo_tmp, nodo);
        }
        return 0;
    }
    
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
            //r1 = Val_Rel_Logic(r1);
            Xcastear.castear(simbolo, r1, nodo);
            
        }
        return 0;
    }
    
    public int declaracionPrimitivaDA_GLOBAL(Nodo RAIZ)
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
            Xcastear.castear_atributo(simbolo, r1, nodo);
        }
        return 0;
    }
    
    public int declaracionPrimitivaD(Nodo RAIZ)
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
            
            String codigo_tmp = "get_local 0\n";
            codigo_tmp += simbolo.direccion + " //Posicion de la variable:"+simbolo.nombre+"\n";
            codigo_tmp +=  "Add \n";
            
            switch(simbolo.tipo)
            {
                case "decimal":
                case "booleano":
                case "entero":
                    codigo_tmp += "0\n";
                    break;    
                default:
                    codigo_tmp += (int)nulo+"\n";
                    break;        
            }
            codigo_tmp += "set_local $calc //Asignacion a la variable:"+simbolo.nombre+"\n";
            Xblockes.agregar(codigo_tmp, nodo);
        }
        return 0;
    }
    
    public int declaracionPrimitivaDGlobal(Nodo RAIZ)
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
            
            String codigo_tmp  = "\n//Inicializacion\n";
            codigo_tmp += "get_local 0\n";
            codigo_tmp +=  "1\n";
            codigo_tmp +=  "Add \n";
            codigo_tmp +=  "get_local $calc \n";
            
            codigo_tmp += simbolo.direccion + " //direccion del atributo:"+simbolo.nombre+"\n";
            codigo_tmp +=  "Add \n";
            
            switch(simbolo.tipo)
            {
                case "decimal":
                case "booleano":
                case "entero":
                    codigo_tmp += "0\n";
                    break;    
                default:
                    codigo_tmp += (int)nulo+"\n";
                    break;        
            }
            codigo_tmp += "set_global $calc\n";
            codigo_tmp += "//Fin inicializacion\n";
            Xblockes.agregar(codigo_tmp, nodo);
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
