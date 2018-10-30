/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ESTRUCTURAS;

import java.util.ArrayList;

/**
 *
 * @author fernando
 */


public class Blockes {
    
    int linea_actual = 0;
    Blocke bloque_actual = null;
    ArrayList<Blocke> Lista = new ArrayList<>();

    public Blockes() {
    }
    
    public void agregar_A_Bloque_AlInicio(String cod , Nodo raiz)
    {
        for (Blocke block : Lista) {
            if(block.linea==raiz.linea)
            {
                String tmp = block.codigo_asm;
                block.codigo_asm = cod;
                block.codigo_asm += tmp;
                break;
            }
        }
    }
    
    public Blocke obtener_UltimoBlock()
    {
        if(!Lista.isEmpty())
        {
            return Lista.get(Lista.size()-1);
        }else
        {
            return null;
        }
    }
    
    public void agregar_AlInicio(String codigoASM, Nodo nodo)
    {
        if(Lista.isEmpty())
        {
            
            linea_actual = nodo.linea;
            bloque_actual = new Blocke(nodo.linea,nodo.columna,codigoASM);
            Lista.add(bloque_actual);
        }else
        {
            if(nodo.linea > linea_actual)
            {
                linea_actual = nodo.linea;
                bloque_actual = new Blocke(nodo.linea,nodo.columna,codigoASM);
                Lista.add(bloque_actual);
            }else
            {
                String bloque_tmp = bloque_actual.codigo_asm;
                bloque_actual.codigo_asm = codigoASM;
                bloque_actual.codigo_asm += bloque_tmp;
            }
        }
    }
    
    public void agregar_AlUltimoBloque(String codigoASM)
    {
        if(!Lista.isEmpty())
        {
            bloque_actual.codigo_asm += codigoASM;   
        }
    }
    
    public void agregar(String codigoASM, Nodo nodo)
    {
        if(Lista.isEmpty())
        {
            
            linea_actual = nodo.linea;
            bloque_actual = new Blocke(nodo.linea,nodo.columna,codigoASM);
            Lista.add(bloque_actual);
        }else
        {
            if(nodo.linea > linea_actual)
            {
                linea_actual = nodo.linea;
                bloque_actual = new Blocke(nodo.linea,nodo.columna,codigoASM);
                Lista.add(bloque_actual);
            }else
            {
                bloque_actual.codigo_asm += codigoASM;
            }
        }
    }
    
    public void imprimirBlockes()
    {
        for (Blocke block : Lista) {
            //System.out.println("\n\nLinea:"+block.linea);
            System.out.println(block.codigo_asm);

        }
    }
}


