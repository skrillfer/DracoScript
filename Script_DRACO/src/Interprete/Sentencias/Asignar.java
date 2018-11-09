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
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author fernando
 */
public class Asignar extends Interprete.Interpretacion{
    
    
    public void asignacion(Nodo raiz)
    {
        XopL  = new Logica();
        Resultado result = null;
        Resultado var = null;
        
        
        ArrayList<String> auxiliar_ambito  = ambito;
        var = accediendo(raiz.hijos.get(0));
        
        int nivelTmp = Xnivel;
        ambito = auxiliar_ambito;
        
        
        Xnivel = 0;
        result = XopL.OPERAR(raiz.hijos.get(1));
        
        Xnivel = nivelTmp;
        ambito = auxiliar_ambito;
        
        Xcastear.castearAsignacion(var,result,raiz);
        
        Xnivel=0;
    }
    
    
    public Resultado accediendo(Nodo raiz)
    {
        Simbolo simbolo=null;
        Resultado resultado = new Resultado("-1", null);
        
        String cod = "";
        for (int i = 0; i < raiz.hijos.size(); i++) {
            Nodo acceso = raiz.hijos.get(i);
            
            switch(acceso.nombre)
            {
                case "AccesoId":
                    simbolo = tabla.obtener_Simbolo(acceso.hijos.get(0).valor, ambito);
                    
                    if(simbolo==null)
                    {
                        Lista_Errores.add(raiz.linea, raiz.columna, "Semantico","La variable "+ acceso.hijos.get(0).valor + " no existe", raiz.archivo);
                        return new Resultado("-1", null);
                    }
                    
                    if(Xnivel == 0)
                    {
                        if(simbolo.ambito.equals("global"))
                        {
                            cod +="get_local 0\n";
                            cod +="1\n";
                            cod +="add\n";
                            cod +=simbolo.direccion+"\n";
                            cod +="add\n";
                        }else
                        {
                            cod +="get_local 0\n";
                            cod +=simbolo.direccion+"\n";
                            cod +="add\n";
                        }
                        
                        
                        if(i!=raiz.hijos.size()-1)
                        {
                            cod +="get_local $calc\n";
                        }
                       
                        resultado = new Resultado(simbolo.tipo, "", true);
                        resultado.simbolo = simbolo;
                    }else
                    {
                        cod +=simbolo.direccion+"\n";
                        cod +="add\n";
                        if(i!=raiz.hijos.size()-1)
                        {
                            cod +="get_global $calc\n";
                        }
                        resultado = new Resultado(simbolo.tipo, "", true);
                        resultado.simbolo = simbolo;

                    }
                    
                    if(i==0)
                    {
                        ambito = new ArrayList<>();
                    }
                    
                    if(!es_primitivo(simbolo.tipo) && i!=raiz.hijos.size()-1)
                    {
                        Xnivel++;
                        
                        Simbolo estructura = tabla.obtener_Estructura(simbolo, ambito);
                        ambito = new ArrayList<>();
                        if(estructura==null)
                        {
                            Lista_Errores.add(acceso.linea, acceso.columna, "Semantico", "No existe la estructura " + simbolo.tipo, acceso.archivo);
                        }
                        ambito.add(simbolo.tipo);
                    }
                    break;
                    
                case "llamada":
                    XopA= new Aritmetica();
                    resultado = XopA.llamada_metodo(acceso);
                    Simbolo metodo = resultado.simbolo;
                    ambito = new ArrayList<>();
                    if(!es_primitivo(metodo.tipo))
                    {
                        Xnivel++;
                        
                        Simbolo estructura = tabla.obtener_Estructura(metodo, ambito);
                        ambito = new ArrayList<>();
                        if(estructura==null)
                        {
                            Lista_Errores.add(acceso.linea, acceso.columna, "Semantico", "No existe la estructura " + metodo.tipo, acceso.archivo);
                        }
                        ambito.add(metodo.tipo);
                        resultado.ref = true;
                    }
                    break;
                case "AccesoArray":
                    break;
            }
        }
        JOptionPane.showMessageDialog(null, cod,"STR",JOptionPane.INFORMATION_MESSAGE);
        Xblockes.agregar(cod, raiz);
        return resultado;
    }
}
