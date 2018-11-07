/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interprete.Sentencias;

import ESTRUCTURAS.Nodo;
import ESTRUCTURAS.Resultado;
import Interprete.ALR.Logica;

/**
 *
 * @author fernando
 */
public class PowerFull extends Interprete.Interpretacion{
    public void WHILE(Nodo RAIZ)
    {   
        String codigo_Tmp = "//inicia ciclo while\n";
        String eti_entrada = control.generar_etiqueta();
        codigo_Tmp  +=  eti_entrada+"\n";
        
        Xblockes.agregar(codigo_Tmp, RAIZ);
        
        XopL = new Logica();
        Resultado condicion = XopL.OPERAR(RAIZ.hijos.get(0));
        
        codigo_Tmp  = condicion.ETV+"\n";
        Xblockes.agregar_AlUltimoBloque(codigo_Tmp);
        
        pilaSalidas.push(condicion.ETF);
        pilaEntradas.push(eti_entrada);
        
        ejecutarSentencias(RAIZ.hijos.get(1));
        
        codigo_Tmp = "br " + eti_entrada +"\n";
        codigo_Tmp += "//fin del ciclo while\n";
        codigo_Tmp += condicion.ETF+"\n";
        Xblockes.agregar_AlUltimoBloque(codigo_Tmp);
        
        pilaSalidas.pop();
        pilaEntradas.pop();
    }
    
    
    public void SI(Nodo RAIZ)
    {
        Nodo parte_final_If = RAIZ.hijos.get(2);
        String codigo_tmp = "";
        String eti_Salida =  control.generar_etiqueta();
        
        XopL = new Logica();
        Resultado condicion_si = XopL.OPERAR(RAIZ.hijos.get(0));
        
        if(condicion_si.valor.equals("AND") || condicion_si.valor.equals("OR"))
        {
            codigo_tmp = "br_if " + condicion_si.ETF + "\n";
            codigo_tmp += "br " + condicion_si.ETV + "\n";
        }else
        {
            codigo_tmp = "";
        }
        codigo_tmp += condicion_si.ETV+"\n";
            Xblockes.agregar(codigo_tmp,RAIZ);
            ejecutarSentencias(RAIZ.hijos.get(1)); //Sentencias del IF
            codigo_tmp = "br "+eti_Salida+"\n";
            Xblockes.agregar_AlUltimoBloque(codigo_tmp);
            
        if(parte_final_If.hijos.size()==1)
        {
            codigo_tmp = "//**----------------Inicia else\n";
            codigo_tmp += condicion_si.ETF+"\n";
            Xblockes.agregar(codigo_tmp,parte_final_If);
            
            ejecutarSentencias(parte_final_If.hijos.get(0).hijos.get(0));//Sentencias del Sino
            codigo_tmp = "//**----------------Finaliza else\n";
            Xblockes.agregar_AlUltimoBloque(codigo_tmp);
        }else if(parte_final_If.hijos.size()==2)
        {
            Nodo muchos_sino = parte_final_If.hijos.get(0);
            codigo_tmp = condicion_si.ETF+"\n";
            Xblockes.agregar(codigo_tmp, muchos_sino);
            
            Resultado  cond_sino = null;
            for (Nodo un_sino : muchos_sino.hijos) {
                cond_sino = XopL.OPERAR(un_sino.hijos.get(0));
                
                codigo_tmp = cond_sino.ETV+"\n";
                Xblockes.agregar(codigo_tmp,un_sino);
                
                ejecutarSentencias(un_sino.hijos.get(1));//Sentencias del SinoSi
                
                codigo_tmp = "br "+eti_Salida+"\n";
                codigo_tmp += cond_sino.ETF+"\n";
                Xblockes.agregar_AlUltimoBloque(codigo_tmp);
            }
            ejecutarSentencias(parte_final_If.hijos.get(1).hijos.get(0));//Sentencias del Sino
            
        }
        codigo_tmp = eti_Salida+"\n";
        Xblockes.agregar_AlUltimoBloque(codigo_tmp);
    }
}
