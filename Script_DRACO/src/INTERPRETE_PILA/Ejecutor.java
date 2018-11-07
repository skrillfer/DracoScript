/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INTERPRETE_PILA;

import ESTRUCTURAS.Nodo;
import INTERPRETE_PILA.GRAMATICA.LexicoDasm;
import INTERPRETE_PILA.GRAMATICA.SintacticaDasm;
import ManejoErrores.Errores;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author fernando
 */
public class Ejecutor {
    boolean ya=false;
    String MI_SALIDA = "";
    Nodo raizX = null;
    String archivo ="";
    public static  Errores Lista_Errores = new Errores();
    Nodo metodo_actual =null;
    Heap heap = new Heap();
    XStack stack = new XStack();
    PilaAuxiliar pilaaux = new PilaAuxiliar();
    
    public void ejecutar_dasm(String codigo) throws FileNotFoundException
    {
        /*codigo = "function principal\n" 
                + "4\n"
                + "5\n"
                + "add\n"
                + "end";*/
        //escribir("intermedio.txt", codigo);
        LexicoDasm lex = new LexicoDasm(new FileReader("intermedio.txt"));//se le pasa al analizador lexico lo que se escribio
        SintacticaDasm parser = new SintacticaDasm(lex);
        Nodo RAIZ=null;
        
        try {
            parser.parse();
            Nodo raiz = parser.dema_Raiz();
            if(raiz!=null){
                RAIZ  = raiz;
                raizX = raiz;    
            }
        } catch (Exception e) {
            System.out.println("error DASM:"+e.getMessage());
        }
        if(RAIZ!=null)
        {
            EJECUCION_PRINCIPAL(RAIZ);
            
            heap.imprimir();
            stack.imprimir();
            pilaaux.imprimir();
            System.out.println("=====================================");
            System.out.println(MI_SALIDA);
        }
    }
    
    public void EJECUCION_PRINCIPAL(Nodo raiz)
    {
        Nodo metodo_principal = getPrincipal(raiz);
        if(metodo_principal!=null)
        {
            metodo_actual = metodo_principal;
            ejecutar(metodo_actual.hijos.get(0));
        }else 
        {
            System.out.println("No existe el metodo principal");
        }
    }
    
    public void ejecutar(Nodo sentencias)
    {
        
        for (int x =0; x< sentencias.hijos.size();x++) {
            Nodo sentencia = sentencias.hijos.get(x);
            //if(metodo_actual.valor.equalsIgnoreCase("$$_outStr"))
            //{
                //JOptionPane.showMessageDialog(null, sentencia.nombre);
            //}
            
            if(ya)
            {
                //mostrarGrafico("Antes:  "+sentencia.nombre);
                //System.out.println("|"+sentencia.nombre+"|");
            
            }
            switch(sentencia.nombre)
            {   
                case "f_char":
                    pilaaux.push(1.0);
                    break;
                case "set_global":
                    try {
                        set_global(sentencia);
                    } catch (Exception e) {
                        
                    }
                    
                    break;
                case "get_global":
                    try {
                        get_global(sentencia);
                    } catch (Exception e) {
                        
                    }
                    break;    
                case "set_local":
                    try {
                        //mostrarGrafico();
                        set_local(sentencia);
                        //mostrarGrafico();
                    } catch (Exception e) {
                    }
                    
                    break;
                case "get_local":
                    try {
                        get_local(sentencia);
                    } catch (Exception e) {
                        
                    }
                    break;        
                case "br":
                    x = saltar_a_etiqueta(sentencia.valor);
                    //JOptionPane.showMessageDialog(null, "Salto br");
                    System.out.println("\n");
                    break;
                case "br_if":
                    if(pilaaux.pop()==0.0)
                    {
                       x = saltar_a_etiqueta(sentencia.valor);
                    }
                    break;    
                case "print":
                    try {
                        Print();
                    } catch (Exception e) {
                    }
                    break;
                
                case "unario":
                    pilaaux.push(Double.valueOf(sentencia.valor)*-1);
                    break;
                
                case "numero":
                    pilaaux.push(Double.valueOf(sentencia.valor));
                    break;
                case "decimal":
                    pilaaux.push(Double.valueOf(sentencia.valor));
                    break;    
                case "add":
                case "diff":
                case "mult":
                case "div":
                case "pot":
                case "mod":    
                    operaciones_aritmeticas(sentencia.nombre,sentencia);
                    break;
                case "lt":
                case "lte":    
                case "gt":
                case "gte":    
                case "eqz":
                    operaciones_relacionales(sentencia.nombre,sentencia);
                    break;    
                case "and":
                case "not":
                case "or":
                    operaciones_logicas(sentencia.nombre,sentencia);
                    break;
                case "llamada":
                    Nodo metodoAux =  metodo_actual;
                    Nodo metodo = getMetodo(sentencia.valor);
                    metodo_actual = metodo;
                    
                    switch(metodo.valor)
                    {
                        case "$$_outStr":
                            //heap.imprimir();
                            //stack.imprimir();
                            JOptionPane.showMessageDialog(null, "LLAMANDO A:"+metodo.valor);
                            mostrarGrafico("");
                            ejecutar(metodo.hijos.get(0));
                            JOptionPane.showMessageDialog(null, "FINALIZA LLAMADA A:"+metodo.valor);
                            mostrarGrafico("");

                            //mostrarGrafico();
                            //JOptionPane.showMessageDialog(null, "HE SALIDO");
                            break;
                        default:
                            //heap.imprimir();
                            //stack.imprimir();
                            
                            
                            
                            
                            JOptionPane.showMessageDialog(null, "LLAMANDO A:"+metodo.valor);
                            mostrarGrafico("");
                            ejecutar(metodo.hijos.get(0));
                            JOptionPane.showMessageDialog(null, "FINALIZA LLAMADA A:"+metodo.valor);
                            mostrarGrafico("");
                            
                            if(metodo_actual.valor.equalsIgnoreCase("$$_getStr"))
                            {
                                ya=true;
                            }
                            break;
                    }
                    metodo_actual =metodoAux;
                    break;
            }
            if(ya)
            {
                //mostrarGrafico("Despues:  "+sentencia.nombre);
            }
            
        }
    }
    
    public void mostrarGrafico(String title)
    {
        
        JPanel pan = new JPanel();
        for (int i = 0; i < 3; i++) {
            JTextArea area = new JTextArea(30,10);
            if(i==0)
            {
                area.setText(stack.imprimir());
                area.setBackground(Color.yellow);
            }else if(i==1)
            {
                area.setText(heap.imprimir());
                area.setBackground(Color.blue);
            }else
            {
                area.setText(pilaaux.imprimir());
            }
            
            JScrollPane scroll = new JScrollPane(area);
            pan.add(scroll);
        }
        
        
        JOptionPane.showMessageDialog(null,pan, title, JOptionPane.INFORMATION_MESSAGE);
        
    }
    public void Print()
    {
        Double v1,v2;
        v1=pilaaux.pop();
        v2=pilaaux.pop();
        
        //mostrarGrafico();
        
        MI_SALIDA+=Character.toString((char)v1.intValue());
        JOptionPane.showMessageDialog(null, MI_SALIDA);
        //System.out.println("\t\t\t\t<"+Character.toString((char)v1.intValue())+">");
    }
    
    
    public void set_local(Nodo raiz)
    {
        Double direccion,valor;
        Nodo hijo = raiz.hijos.get(0);
        if(hijo.nombre.equals("calc"))
        {
            valor     = pilaaux.pop();
            direccion = pilaaux.pop();
            stack.set(direccion, valor);
        }else if(hijo.nombre.equals("numero"))
        {   
            valor     = pilaaux.pop();
            direccion = Double.valueOf(hijo.valor);
            stack.set(direccion, valor);
        }else if(hijo.nombre.equals("ret"))
        {
            valor     = pilaaux.pop();
            direccion = stack.get(0.0) + 0;
            stack.set(direccion, valor);
        }
    }
    
    public void set_global(Nodo raiz)
    {
        Double direccion,valor;
        Nodo hijo = raiz.hijos.get(0);
        if(hijo.nombre.equals("calc"))
        {
            valor     = pilaaux.pop();
            direccion = pilaaux.pop();
            heap.set(direccion, valor);
        }else if(hijo.nombre.equals("numero"))
        {
            valor     = pilaaux.pop();
            direccion = Double.valueOf(hijo.valor);
            heap.set(direccion, valor);
        }else 
        {
            
        }
    }
    
    public void get_local(Nodo raiz)
    {
        Double direccion,valor;
        Nodo hijo = raiz.hijos.get(0);
        if(hijo.nombre.equals("calc"))
        {
            direccion = pilaaux.pop();
            valor     = stack.get(direccion);
            pilaaux.push(valor);
        }else if(hijo.nombre.equals("numero"))
        {
            direccion = Double.valueOf(hijo.valor);
            valor     = stack.get(direccion);
            pilaaux.push(valor);
        }else if(hijo.nombre.equals("ret"))
        {
            direccion = stack.get(0.0) + 0;
            valor     = stack.get(direccion);
            pilaaux.push(valor);
        }
    }
    
    public void get_global(Nodo raiz)
    {
        Double direccion,valor;
        Nodo hijo = raiz.hijos.get(0);
        if(hijo.nombre.equals("calc"))
        {
            direccion = pilaaux.pop();
            valor     = heap.get(direccion);
            pilaaux.push(valor);
        }else if(hijo.nombre.equals("numero"))
        {
            direccion = Double.valueOf(hijo.valor);
            valor     = heap.get(direccion);
            pilaaux.push(valor);
        }else 
        {
            
        }
    }
    
    public int saltar_a_etiqueta(String etiqueta)
    {
        for (int i = 0; i < metodo_actual.hijos.get(0).hijos.size(); i++) {
            Nodo sentencia = metodo_actual.hijos.get(0).hijos.get(i);
            switch(sentencia.nombre)
            {
                case "etiqueta":
                    if(sentencia.valor.equals(etiqueta))
                    {
                        return i;
                    }
                    break;
                default:
                    break;
            }
        }
        return metodo_actual.hijos.get(0).hijos.size()-1;
    }
    public void operaciones_aritmeticas(String tipo,Nodo raiz)
    {
        Double v1,v2;
        switch(tipo)
        {
            
            case "add":
                v1 = pilaaux.pop();
                v2 = pilaaux.pop();
                pilaaux.push(v2+v1);
                break;
            case "diff":
                v1 = pilaaux.pop();
                v2 = pilaaux.pop();
                pilaaux.push(v2-v1);
                break;
            case "mult":
                v1 = pilaaux.pop();
                v2 = pilaaux.pop();
                pilaaux.push(v2*v1);
                break;    
            case "div":
                v1 = pilaaux.pop();
                v2 = pilaaux.pop();
                if(v1!=0.0)
                {
                    pilaaux.push(v2/v1);
                }else
                {
                    Lista_Errores.add(raiz.linea, raiz.columna,"Ejecucion","Error en ejecutor DASM division entre 0 invalida",archivo);
                }
                
                break;
            case "pot":
                v1 = pilaaux.pop();
                v2 = pilaaux.pop();
                pilaaux.push(Math.pow(v2, v1));
                break;
            case "mod":
                v1 = pilaaux.pop();
                v2 = pilaaux.pop();
                pilaaux.push(v2%v1);
                break;    
        }
    }
    
    public void operaciones_relacionales(String tipo,Nodo raiz)
    {
        Double v1,v2;
        switch(tipo)
        {
            case "lt":
                v1 = pilaaux.pop();
                v2 = pilaaux.pop();
                if(v2 < v1)
                {
                    pilaaux.push(1.0);
                }else
                {
                    pilaaux.push(0.0);
                }
                break;
            case "lte":
                v1 = pilaaux.pop();
                v2 = pilaaux.pop();
                if(v2 <= v1)
                {
                    pilaaux.push(1.0);
                }else
                {
                    pilaaux.push(0.0);
                }
                break;  
            case "gt":
                v1 = pilaaux.pop();
                v2 = pilaaux.pop();
                if(v2 > v1)
                {
                    pilaaux.push(1.0);
                }else
                {
                    pilaaux.push(0.0);
                }
                break;
            case "gte":
                v1 = pilaaux.pop();
                v2 = pilaaux.pop();
                if(v2 >= v1)
                {
                    pilaaux.push(1.0);
                }else
                {
                    pilaaux.push(0.0);
                }
                break;
            case "eqz":
                v1 = pilaaux.pop();
                
                if(v1 == 0.0)
                {
                    pilaaux.push(1.0);
                }else
                {
                    pilaaux.push(0.0);
                }
                break;    
        }
    }
    
    
    public void operaciones_logicas(String tipo,Nodo raiz)
    {
        Double v1,v2;
        switch(tipo)
        {
            case "and":
                v1 = pilaaux.pop();
                v2 = pilaaux.pop();
                if(v1.intValue() >= 1 && v2.intValue() >= 1)
                {
                    pilaaux.push(1.0);
                }else
                {
                    pilaaux.push(0.0);
                }
                break;
            case "or":
                v1 = pilaaux.pop();
                v2 = pilaaux.pop();
                if(v1.intValue() >= 1 || v2.intValue() >= 1)
                {
                    pilaaux.push(1.0);
                }else
                {
                    pilaaux.push(0.0);
                }
            case "not":
                v1 = pilaaux.pop();
                if(v1.intValue() >= 1)
                {
                    pilaaux.push(0.0);
                }else
                {
                    pilaaux.push(1.0);
                }
                break;    
            
        }
    }
    
    
    
    public Nodo getPrincipal(Nodo raiz)
    {
        for (Nodo hijo : raiz.hijos) {
            if(hijo.valor.equalsIgnoreCase("principal"))
            {
                return hijo;
            }
        }
        return null;
    }
    
    public Nodo getMetodo(String nombre)
    {
        for (Nodo hijo : raizX.hijos) {
            if(hijo.valor.equalsIgnoreCase(nombre))
            {
                return hijo;
            }
        }
        return null;
    }
    
    public void escribir(String direccion,String texto) {
        //metodo que guarda lo que esta escrito en un archivo de texto
        try {
            FileWriter writer = new FileWriter(direccion);
            PrintWriter print = new PrintWriter(writer);
            print.print(texto);
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
