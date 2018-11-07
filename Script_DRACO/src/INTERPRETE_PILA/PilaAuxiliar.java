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
public class PilaAuxiliar {
    ArrayList<Double> lista = new ArrayList<>();
    private int tope = 0;

    public PilaAuxiliar() {
        
    }
    
    
    public Double pop()
    {
        if(!lista.isEmpty())
        {   
            Double ret = lista.remove(lista.size()-1);
            System.out.println("PilaAux_pop->"+ret);
            return ret;
        }else
        {
            System.out.println("Error ---> PilaAuxiliar pop()");     
            return null;
        }
    }
    
    public void push(Double v)
    {
        
        System.out.println("PilaAux_push->"+v);
        lista.add(v);
    }
    
    public Double get(Double i)
    {
        if(!lista.isEmpty() && i<lista.size())
        {   
            Double ret = lista.get(i.intValue());
            System.out.println("PilaAux_get->"+ret);
            return ret;
        }else
        {
            System.out.println("Error ---> PilaAuxiliar get("+i+")");
            return null;
        }
    }
    
    public void set(Double i, Double v)
    {
        try {
            System.out.println("PilaAux_set->"+i+","+v);
            lista.set(i.intValue(), v);
            if(i.intValue()> tope)
            {
                tope = i.intValue();
            }
        } catch (Exception e) {
            System.out.println("Error ---> PilaAuxiliar set("+i+","+v+")");
        }
    }
    
    public String imprimir()
    {
        System.out.println(">-------------------Imprimiendo Pila Auxiliar--------------------<");
        String cad="";
        for (int i = lista.size()-1; i >= 0 ; i--) {
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
