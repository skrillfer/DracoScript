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
public class TablaSimbolo {
    ArrayList<Simbolo> metodos = new  ArrayList<>();
    ArrayList<Simbolo> simbolos = new  ArrayList<>();
    ArrayList<Simbolo> globales = new  ArrayList<>();
    ArrayList<Simbolo> constructores = new  ArrayList<>();
    ArrayList<String> ambito = new  ArrayList<>();
    int direccion = 0;
    
    
    
    public void generar_codigo(Nodo raiz)
    {
        for (Nodo hijo : raiz.hijos) {
            switch(hijo.nombre)
            {
                case "estructura":
                    String nombre_estructura =  hijo.hijos.get(0).valor;
                    ArrayList<String>  ambito_tmp = this.ambito;
                    int direccion_tmp     = this.direccion;
                    this.direccion = 0;
                    this.ambito = new ArrayList<>();
                    this.ambito.add(nombre_estructura);
                    generar_codigo(hijo.hijos.get(1));
                    this.ambito.remove(this.ambito.size()-1);
                    this.ambito = ambito_tmp;
                    
                    String ambito_generado = generarAmbito(ambito);
                    Simbolo sim_struct = new Simbolo(nombre_estructura, "struct", ambito_generado, "struct", -1, this.direccion, 0);
                    
                    
                    this.direccion = direccion_tmp;
                    break;
            }
        }
    }
    
    public String generarAmbito(ArrayList<String> ambito_lista)
    {
        String str_ambito = "";
        if(ambito_lista.isEmpty())
        {
            return "global";
        }else
        {
            for (String cad : ambito_lista) {
                str_ambito +=cad+"/"; 
            }
            str_ambito = str_ambito.substring(0, str_ambito.length()-1);
        }
        return str_ambito;
    }
    
    
    public void agregar_Simbolo(Simbolo sim, Nodo nodo)
    {
        if(!si_existe(sim))
        {
            this.simbolos.add(sim);
            this.direccion++;
            
            if(sim.ambito.equals("global")  && sim.rol.equals("variable"))
            {
                this.globales.add(sim);
            }
            
            if(sim.rol.equals("metodo"))
            {
                this.metodos.add(sim);
            }
            
            if(sim.rol.equals("constructor"))
            {
                this.constructores.add(sim);
            }
            
        }
    }
    
    public  boolean si_existe(Simbolo sim)
    {
        for (Simbolo simbolo : simbolos) {
            if(simbolo.nombre.equals(sim.nombre))
            {
                if(es_primitivo(simbolo.tipo))
                {
                
                }else
                {
                    if(simbolo.ambito==sim.ambito)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean es_primitivo(String tipo)
    {
        switch(tipo)
        {
            case "entero":
            case "decimal":
            case "booleano":
            case "caracter":
            case "cadena":
                return true;
                default:
                    return false;
        }
    }
}
