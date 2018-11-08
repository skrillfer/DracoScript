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
public class PilaGenerica {
    public int ii1= 0;
    public int ii2= 0;
    public int ii3= 0;
    
    private ArrayList<Double> heap = new ArrayList<>();
    private ArrayList<Double> stack = new ArrayList<>();
    private ArrayList<Double> pilaaux = new ArrayList<>();

    public PilaGenerica() {
        for (int i = 0; i < 10000; i++) {
            heap.add(null);
        }
        set(0.0,1.0,2);
        
        for (int i = 0; i < 10000; i++) {
            stack.add(null);
        }
        set(0.0,1.0,1);
    }
    
    
    public Double get(Double i, int numero)
    {
        if(numero ==1)
        {
            if(!stack.isEmpty() && i<stack.size())
            {   
                Double ret = stack.get(i.intValue());
                System.out.println("Get de Stack->"+ret);
                return ret;
            }else
            {
                System.out.println("Error al obtener en Stack get("+i+")");
                return null;
            }
        }else if(numero==2)
        {
            if(!heap.isEmpty() && i<heap.size())
            {   
                Double ret = heap.get(i.intValue());
                System.out.println("Get de Heap->"+ret);
                return ret;
            }else
            {
                System.out.println("Error al obtener en Heap get("+i+")");
                return null;
            }
        }else
        {
            if(!pilaaux.isEmpty() && i<pilaaux.size())
            {   
                Double ret = pilaaux.get(i.intValue());
                System.out.println("Get de pilaaux ->"+ret);
                return ret;
            }else
            {
                System.out.println("Error al obtener en Spilaauxtack get("+i+")");
                return null;
            }
        }
        
    }
    
    public void set(Double i, Double v,int numero)
    {
        ArrayList<Double> aux  = null;
        
        if(numero==1)//stack
        {
            try {
                System.out.println("En stack set ->"+i+","+v);
                stack.set(i.intValue(), v);
            if(i.intValue()> ii1)
            {
                ii1 = i.intValue();
            }
            } catch (Exception e) {
                System.out.println("Error en Stack al setear("+i+","+v+")");
            }
        }else if(numero==2)//heap
        {
            try {
                System.out.println("En heap set ->"+i+","+v);
                heap.set(i.intValue(), v);
            if(i.intValue()> ii2)
            {
                ii2 = i.intValue();
            }
            } catch (Exception e) {
                System.out.println("Error en heap al setear("+i+","+v+")");
            }
        }else
        {
            try {
                System.out.println("Set en pila aux->"+i+","+v);
                pilaaux.set(i.intValue(), v);
                if(i.intValue()> ii3)
                {
                    ii3 = i.intValue();
                }
            } catch (Exception e) {
                System.out.println("Error al Set en pila aux ("+i+","+v+")");
            }
        }
        
    }
    
    public String print(int numero)
    {
        String cad="";

        if(numero==1)
        {
            System.out.println(">-------------------Imprimiendo Stack--------------------<");
            for (int i = ii1; i >= 0 ; i--) {
                if(stack.get(i)!=null)
                {
                    cad += "["+stack.get(i)+"]{"+i+"}\n"; 
                    System.out.println("["+stack.get(i)+"]");
                }else
                {
                    cad += "[]{"+i+"}\n";
                    System.out.println("[]");
                }
            }
        }else if(numero==2)
        {   
            System.out.println(">=====================Imprimiendo Heap=====================<");
            for (int i = ii2; i >= 0 ; i--) {
                if(heap.get(i)!=null)
                {
                    cad += "["+heap.get(i)+"]{"+i+"}\n"; 
                    System.out.println("["+heap.get(i)+"]");
                }else
                {
                    cad += "[]{"+i+"}\n";
                    System.out.println("[]");
                }
            }
        }else
        {
            System.out.println(">=====================Imprimiendo Pila Aux =====================<");
            for (int i = ii3; i >= 0 ; i--) {
                if(pilaaux.get(i)!=null)
                {
                    cad += "["+pilaaux.get(i)+"]{"+i+"}\n"; 
                    System.out.println("["+pilaaux.get(i)+"]");
                }else
                {
                    cad += "[]{"+i+"}\n";
                    System.out.println("[]");
                }
            }
        }
        
        return cad;
    }
}
