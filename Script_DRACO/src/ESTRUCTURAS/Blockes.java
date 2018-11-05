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
    Blocke next = null;
    boolean g_next = false;
    boolean g_nextLuego = false;
    public int     ii = -1;
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
                block.agregarAl_Inicio(cod);
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
                bloque_actual.agregarAl_Inicio(codigoASM);
            }
        }
    }
    
    public void agregar_AlUltimoBloque(String codigoASM)
    {
        if(!Lista.isEmpty())
        {
            bloque_actual.add(codigoASM);   
        }
    }
    
    public void agregar(String codigoASM, Nodo nodo)
    {
        if(Lista.isEmpty())
        {
            
            if(g_nextLuego)
            {
                ii= bloque_actual.Hacer_Senia();
                g_nextLuego=false;
                g_next = true;
            }
            
            linea_actual = nodo.linea;
            bloque_actual = new Blocke(nodo.linea,nodo.columna,codigoASM);
            Lista.add(bloque_actual);
        }else
        {
            if(nodo.linea > linea_actual)
            {
                if(g_nextLuego)
                {
                    ii= bloque_actual.Hacer_Senia();
                    g_nextLuego=false;
                    g_next = true;
                }
                
                linea_actual = nodo.linea;
                bloque_actual = new Blocke(nodo.linea,nodo.columna,codigoASM);
                Lista.add(bloque_actual);
                
                
            }else
            {
                if(g_nextLuego)
                {
                    ii= bloque_actual.Hacer_Senia();
                    g_nextLuego=false;
                    g_next = true;
                }
                bloque_actual.add(codigoASM);
            }
        }
        
        if (g_next)
        {
            next=bloque_actual;
            g_next=false;
        }
    }
    
    public  Blocke get_Next()
    {
        return this.next;
    }
    
    
    
    public String imprimirBlockes()
    {
        String cad = "";
        for (Blocke block : Lista) {
            //System.out.println("\n\nLinea:"+block.linea);
            for (String linea : block.lineas) {
                cad +=  linea;
                System.out.println(linea);
            }
        }
        return cad;
    }
    
    public void senia()
    {
        this.g_next=true;
    }
    
    public void seniaLuego()
    {
        this.g_nextLuego=true;
    }
}


