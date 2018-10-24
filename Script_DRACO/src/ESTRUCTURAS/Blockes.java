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

class Block{
    public int linea = 0;
    public int columna = 0;
    String codigo_asm = "";

    public Block() {
    }
    
    public Block(int linea, int columna, String codigo_asm)
    {
        this.linea = linea;
        this.columna = columna;
        this.codigo_asm =  codigo_asm;
    }
    
}

public class Blockes {
    
    int linea_actual = 0;
    Block bloque_actual = null;
    ArrayList<Block> Lista = new ArrayList<>();

    public Blockes() {
    }
    
    
    public void agregar_AlInicio(String codigoASM, Nodo nodo)
    {
        if(Lista.isEmpty())
        {
            
            linea_actual = nodo.linea;
            bloque_actual = new Block(nodo.linea,nodo.columna,codigoASM);
            Lista.add(bloque_actual);
        }else
        {
            if(nodo.linea > linea_actual)
            {
                linea_actual = nodo.linea;
                bloque_actual = new Block(nodo.linea,nodo.columna,codigoASM);
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
            bloque_actual = new Block(nodo.linea,nodo.columna,codigoASM);
            Lista.add(bloque_actual);
        }else
        {
            if(nodo.linea > linea_actual)
            {
                linea_actual = nodo.linea;
                bloque_actual = new Block(nodo.linea,nodo.columna,codigoASM);
                Lista.add(bloque_actual);
            }else
            {
                bloque_actual.codigo_asm += codigoASM;
            }
        }
    }
    
    public void imprimirBlockes()
    {
        for (Block block : Lista) {
            //System.out.println("\n\nLinea:"+block.linea);
            System.out.println(block.codigo_asm);

        }
    }
}


