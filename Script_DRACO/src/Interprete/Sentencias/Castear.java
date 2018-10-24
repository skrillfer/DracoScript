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
import static Interprete.Interpretacion.XopA;

/**
 *
 * @author fernando
 */
public class Castear extends Interprete.Interpretacion{
    public void castear (Simbolo simbolo, Resultado resultado, Nodo RAIZ)
    {
            
        String codigo_tpm = "";
        switch(simbolo.tipo)
        {
            case "entero":
                switch(resultado.tipo)
                {
                    case "entero":
                    case "decimal":    
                    case "caracter":  
                    case "booleano":      
                        codigo_tpm = "\n\n//Declaracion Y Asignacion: " + simbolo.tipo+"-"+resultado.tipo+"\n";
                        codigo_tpm += "get_local 0"+"\n";
                        codigo_tpm += simbolo.direccion+"\n";
                        codigo_tpm += "Add\n";
                        
                        
                        Xblockes.agregar_AlInicio(codigo_tpm, RAIZ);
                        
                        codigo_tpm = "set_local $calc"+"\n";
                        Xblockes.agregar(codigo_tpm, RAIZ);
                        break;
                    default:
                        //error
                        break;
                }
                break;
            case "decimal":
                switch(resultado.tipo)
                {
                    case "entero":
                    case "decimal":    
                    case "caracter": 
                    case "booleano":     
                        codigo_tpm = "\n\n//Declaracion Y Asignacion: " + simbolo.tipo+"-"+resultado.tipo+"\n";
                        codigo_tpm += "get_local 0"+"\n";
                        codigo_tpm += simbolo.direccion+"\n";
                        codigo_tpm += "Add\n";
                        
                        
                        Xblockes.agregar_AlInicio(codigo_tpm, RAIZ);
                        
                        codigo_tpm = "set_local $calc"+"\n";
                        Xblockes.agregar(codigo_tpm, RAIZ);
                        break;
                    default:
                        //error
                        break;
                }
                break;   
            case "caracter":
                switch(resultado.tipo)
                {
                    case "entero":
                    case "decimal":    
                    case "caracter": 
                    case "booleano":    
                        codigo_tpm = "\n\n//Declaracion Y Asignacion: " + simbolo.tipo+"-"+resultado.tipo+"\n";
                        codigo_tpm += "get_local 0"+"\n";
                        codigo_tpm += simbolo.direccion+"\n";
                        codigo_tpm += "Add\n";
                        
                        
                        Xblockes.agregar_AlInicio(codigo_tpm, RAIZ);
                        
                        codigo_tpm = "set_local $calc"+"\n";
                        Xblockes.agregar(codigo_tpm, RAIZ);
                        break;
                    default:
                        //error
                        break;
                }
                break;
            case "booleano":
                switch(resultado.tipo)
                {
                    case "entero":
                    case "decimal":    
                    case "caracter":
                    case "booleano":    
                        codigo_tpm = "\n\n//Declaracion Y Asignacion: " + simbolo.tipo+"-"+resultado.tipo+"\n";
                        codigo_tpm += "get_local 0"+"\n";
                        codigo_tpm += simbolo.direccion+"\n";
                        codigo_tpm += "Add\n";
                        
                        
                        Xblockes.agregar_AlInicio(codigo_tpm, RAIZ);
                        
                        codigo_tpm = "set_local $calc"+"\n";
                        Xblockes.agregar(codigo_tpm, RAIZ);
                        break;
                    default:
                        //error
                        break;
                }
                break;       
        }
    }
}
