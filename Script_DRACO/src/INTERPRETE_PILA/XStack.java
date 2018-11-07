/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INTERPRETE_PILA;

import java.util.ArrayList;

/**
 *
 * @author fernando
 */
public class XStack {
    private ArrayList<Double> lista = new ArrayList<>();
    private int tope = 0;

    public XStack() {
        for (int i = 0; i < 10000; i++) {
            lista.add(null);
        }
        set(0.0,1.0);
    }
    
    
    public Double pop()
    {
        if(!lista.isEmpty())
        {   
            Double ret = lista.remove(lista.size()-1);
            System.out.println("XStack_pop->"+ret);
            return ret;
        }else
        {
            System.out.println("Error ---> XStack pop()");     
            return null;
        }
    }
    
    public void push(Double v)
    {
        System.out.println("XStack_push->"+v);
        lista.add(v);
    }
    
    public Double get(Double i)
    {
        if(!lista.isEmpty() && i<lista.size())
        {   
            Double ret = lista.get(i.intValue());
            System.out.println("XStack_get->"+ret);
            return ret;
        }else
        {
            System.out.println("Error ---> XStack get("+i+")");
            return null;
        }
    }
    
    public void set(Double i, Double v)
    {
        try {
            System.out.println("XStack_set->"+i+","+v);
            lista.set(i.intValue(), v);
            if(i.intValue()> tope)
            {
                tope = i.intValue();
            }
        } catch (Exception e) {
            System.out.println("Error ---> XStack set("+i+","+v+")");
        }
    }
    
    public int Size()
    {
        return this.tope;
    }
    
    public String imprimir()
    {
        String cad="";
        System.out.println(">-------------------Imprimiendo Stack--------------------<");
        
        for (int i = tope; i >= 0 ; i--) {
            if(lista.get(i)!=null)
            {
                cad += "["+lista.get(i)+"]{"+i+"}\n"; 
                System.out.println("["+lista.get(i)+"]");
            }else
            {
                cad += "[]{"+i+"}\n";
                System.out.println("[]");
            }
        }
        return cad;
    }
}
