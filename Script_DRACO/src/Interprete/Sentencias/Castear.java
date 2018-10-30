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
                        Interprete.Interpretacion.Lista_Errores.add(RAIZ.linea, RAIZ.columna, "Semantico", "Error de asignacion la variable ["+simbolo.nombre + "] es de tipo"+simbolo.tipo+" y no acepta" +resultado.tipo, RAIZ.archivo);
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
                        Interprete.Interpretacion.Lista_Errores.add(RAIZ.linea, RAIZ.columna, "Semantico", "Error de asignacion la variable ["+simbolo.nombre + "] es de tipo"+simbolo.tipo+" y no acepta" +resultado.tipo, RAIZ.archivo);
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
                    case "nulo":    
                        codigo_tpm = "\n\n//Declaracion Y Asignacion: " + simbolo.tipo+"-"+resultado.tipo+"\n";
                        codigo_tpm += "get_local 0"+"\n";
                        codigo_tpm += simbolo.direccion+"\n";
                        codigo_tpm += "Add\n";
                        
                        
                        Xblockes.agregar_AlInicio(codigo_tpm, RAIZ);
                        
                        codigo_tpm = "set_local $calc"+"\n";
                        Xblockes.agregar(codigo_tpm, RAIZ);
                        break;
                    default:
                        Interprete.Interpretacion.Lista_Errores.add(RAIZ.linea, RAIZ.columna, "Semantico", "Error de asignacion la variable ["+simbolo.nombre + "] es de tipo"+simbolo.tipo+" y no acepta" +resultado.tipo, RAIZ.archivo);
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
                        Interprete.Interpretacion.Lista_Errores.add(RAIZ.linea, RAIZ.columna, "Semantico", "Error de asignacion la variable ["+simbolo.nombre + "] es de tipo"+simbolo.tipo+" y no acepta" +resultado.tipo, RAIZ.archivo);
                        break;
                }
                break;       
            case "cadena":
                switch(resultado.tipo)
                {
                    case "cadena":
                    case "nulo":    
                        codigo_tpm = "\n\n//Declaracion Y Asignacion: " + simbolo.tipo+"-"+resultado.tipo+"\n";
                        codigo_tpm += "get_local 0"+"\n";
                        codigo_tpm += simbolo.direccion+"\n";
                        codigo_tpm += "Add//suma de p+simbolo.posicion\n";
                        
                        
                        Xblockes.agregar_AlInicio(codigo_tpm, RAIZ);
                        
                        codigo_tpm = "set_local $calc"+"//setear el valor de la variable\n";
                        Xblockes.agregar(codigo_tpm, RAIZ);
                        break;
                    default:
                        Interprete.Interpretacion.Lista_Errores.add(RAIZ.linea, RAIZ.columna, "Semantico", "Error de asignacion la variable ["+simbolo.nombre + "] es de tipo"+simbolo.tipo+" y no acepta" +resultado.tipo, RAIZ.archivo);
                        break;
                }
                break; 
            
            default:
                if(es_primitivo(resultado.tipo))
                {
                    Interprete.Interpretacion.Lista_Errores.add(RAIZ.linea, RAIZ.columna, "Semantico", "Error de asignacion la variable ["+simbolo.nombre + "] es de tipo"+simbolo.tipo+" y no acepta" +resultado.tipo, RAIZ.archivo);
                }else if(resultado.tipo.equals("nulo"))
                {
                    codigo_tpm = "\n\n//Declaracion Y Asignacion: " + simbolo.tipo+"-"+resultado.tipo+"\n";
                    codigo_tpm += "get_local 0"+"\n";
                    codigo_tpm += simbolo.direccion+"\n";
                    codigo_tpm += "Add//suma de p+simbolo.posicion\n";


                    Xblockes.agregar_AlInicio(codigo_tpm, RAIZ);

                    codigo_tpm = "set_local $calc"+"//setear el valor de la variable\n";
                    Xblockes.agregar(codigo_tpm, RAIZ);
                }else
                {
                    if(simbolo.tipo.equals(resultado.tipo))
                    {
                        codigo_tpm = "\n\n//Declaracion Y Asignacion: " + simbolo.tipo+"-"+resultado.tipo+"\n";
                        codigo_tpm += "get_local 0"+"\n";
                        codigo_tpm += simbolo.direccion+"\n";
                        codigo_tpm += "Add//suma de p+simbolo.posicion\n";


                        Xblockes.agregar_AlInicio(codigo_tpm, RAIZ);

                        codigo_tpm = "set_local $calc"+"//setear el valor de la variable\n";
                        Xblockes.agregar(codigo_tpm, RAIZ);
                        simbolo.inicializado = true;
                    }else
                    {
                        Interprete.Interpretacion.Lista_Errores.add(RAIZ.linea, RAIZ.columna, "Semantico", "Error de asignacion la variable ["+simbolo.nombre + "] es de tipo"+simbolo.tipo+" y no acepta" +resultado.tipo, RAIZ.archivo);
                    }
                    break;

                }
                break;    
        }
    }
    
    
    public void castear_atributo(Simbolo simbolo, Resultado resultado, Nodo RAIZ)
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
                        codigo_tpm = "\n\n//Declaracion Atributo Y Asignacion: " + simbolo.tipo+"-"+resultado.tipo+"\n";
                        codigo_tpm += "get_local 0"+"\n";
                        codigo_tpm += "1"+"\n";
                        codigo_tpm += "Add"+"\n";
                        codigo_tpm += "get_local $calc"+"\n";
                        
                        codigo_tpm += simbolo.direccion+"//direccion de la variable\n";
                        codigo_tpm += "Add\n";
                        
                        
                        Xblockes.agregar_AlInicio(codigo_tpm, RAIZ);
                        
                        codigo_tpm = "set_global $calc"+"\n";
                        Xblockes.agregar(codigo_tpm, RAIZ);
                        break;
                    default:
                        Interprete.Interpretacion.Lista_Errores.add(RAIZ.linea, RAIZ.columna, "Semantico", "Error de asignacion la variable ["+simbolo.nombre + "] es de tipo"+simbolo.tipo+" y no acepta" +resultado.tipo, RAIZ.archivo);
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
                        codigo_tpm = "\n\n//Declaracion Atributo Y Asignacion: " + simbolo.tipo+"-"+resultado.tipo+"\n";
                        codigo_tpm += "get_local 0"+"\n";
                        codigo_tpm += "1"+"\n";
                        codigo_tpm += "Add"+"\n";
                        codigo_tpm += "get_local $calc"+"\n";
                        
                        
                        codigo_tpm += simbolo.direccion+"//direccion de la variable\n";
                        codigo_tpm += "Add\n";
                        
                        
                        Xblockes.agregar_AlInicio(codigo_tpm, RAIZ);
                        
                        codigo_tpm = "set_global $calc"+"\n";
                        Xblockes.agregar(codigo_tpm, RAIZ);
                        break;
                    default:
                        Interprete.Interpretacion.Lista_Errores.add(RAIZ.linea, RAIZ.columna, "Semantico", "Error de asignacion la variable ["+simbolo.nombre + "] es de tipo"+simbolo.tipo+" y no acepta" +resultado.tipo, RAIZ.archivo);
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
                    case "nulo":    
                        codigo_tpm = "\n\n//Declaracion Atributo Y Asignacion: " + simbolo.tipo+"-"+resultado.tipo+"\n";
                        codigo_tpm += "get_local 0"+"\n";
                        codigo_tpm += "1"+"\n";
                        codigo_tpm += "Add"+"\n";
                        codigo_tpm += "get_local $calc"+"\n";
                        
                        
                        codigo_tpm += simbolo.direccion+"//direccion de la variable\n";
                        codigo_tpm += "Add\n";
                        
                        
                        Xblockes.agregar_AlInicio(codigo_tpm, RAIZ);
                        
                        codigo_tpm = "set_global $calc"+"\n";
                        Xblockes.agregar(codigo_tpm, RAIZ);
                        break;
                    default:
                        Interprete.Interpretacion.Lista_Errores.add(RAIZ.linea, RAIZ.columna, "Semantico", "Error de asignacion la variable ["+simbolo.nombre + "] es de tipo"+simbolo.tipo+" y no acepta" +resultado.tipo, RAIZ.archivo);
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
                        codigo_tpm = "\n\n//Declaracion Atributo Y Asignacion: " + simbolo.tipo+"-"+resultado.tipo+"\n";
                        codigo_tpm += "get_local 0"+"\n";
                        codigo_tpm += "1"+"\n";
                        codigo_tpm += "Add"+"\n";
                        codigo_tpm += "get_local $calc"+"\n";
                        
                        
                        
                        codigo_tpm += simbolo.direccion+"//direccion de la variable\n";
                        codigo_tpm += "Add\n";
                        
                        
                        Xblockes.agregar_AlInicio(codigo_tpm, RAIZ);
                        
                        codigo_tpm = "set_global $calc"+"\n";
                        Xblockes.agregar(codigo_tpm, RAIZ);
                        break;
                    default:
                        Interprete.Interpretacion.Lista_Errores.add(RAIZ.linea, RAIZ.columna, "Semantico", "Error de asignacion la variable ["+simbolo.nombre + "] es de tipo"+simbolo.tipo+" y no acepta" +resultado.tipo, RAIZ.archivo);
                        break;
                }
                break; 
            case "cadena":
                switch(resultado.tipo)
                {
                    case "cadena":
                    case "nulo":    
                        codigo_tpm = "\n\n//Declaracion Atributo Y Asignacion: " + simbolo.tipo+"-"+resultado.tipo+"\n";
                        codigo_tpm += "get_local 0"+"\n";
                        codigo_tpm += "1"+"\n";
                        codigo_tpm += "Add"+"\n";
                        codigo_tpm += "get_local $calc"+"\n";
                        
                        
                        
                        codigo_tpm += simbolo.direccion+"//direccion de la variable\n";
                        codigo_tpm += "Add\n";
                        
                        
                        Xblockes.agregar_AlInicio(codigo_tpm, RAIZ);
                        
                        codigo_tpm = "set_global $calc"+"//setear el valor de la variable\n";
                        Xblockes.agregar(codigo_tpm, RAIZ);
                        break;
                    default:
                        Interprete.Interpretacion.Lista_Errores.add(RAIZ.linea, RAIZ.columna, "Semantico", "Error de asignacion la variable ["+simbolo.nombre + "] es de tipo"+simbolo.tipo+" y no acepta" +resultado.tipo, RAIZ.archivo);
                        break;
                }
                break;  
            default:
                if(es_primitivo(resultado.tipo))
                {
                    Interprete.Interpretacion.Lista_Errores.add(RAIZ.linea, RAIZ.columna, "Semantico", "Error de asignacion la variable ["+simbolo.nombre + "] es de tipo"+simbolo.tipo+" y no acepta" +resultado.tipo, RAIZ.archivo);
                }else if(resultado.tipo.equals("nulo"))
                {
                    codigo_tpm = "\n\n//Declaracion Atributo Y Asignacion: " + simbolo.tipo+"-"+resultado.tipo+"\n";
                    codigo_tpm += "get_local 0"+"\n";
                    codigo_tpm += "1"+"\n";
                    codigo_tpm += "Add"+"\n";
                    codigo_tpm += "get_local $calc"+"\n";
                        
                        
                        
                    codigo_tpm += simbolo.direccion+"\n";
                    codigo_tpm += "Add\n";


                    Xblockes.agregar_AlInicio(codigo_tpm, RAIZ);

                    codigo_tpm = "set_global $calc"+"//setear el valor de la variable\n";
                    Xblockes.agregar(codigo_tpm, RAIZ);
                }else
                {
                    if(simbolo.tipo.equals(resultado.tipo))
                    {
                        codigo_tpm = "\n\n//Declaracion Atributo Y Asignacion: " + simbolo.tipo+"-"+resultado.tipo+"\n";
                        codigo_tpm += "get_local 0"+"\n";
                        codigo_tpm += "1"+"\n";
                        codigo_tpm += "Add"+"\n";
                        codigo_tpm += "get_local $calc"+"\n";
                        
                        
                        codigo_tpm += simbolo.direccion+"\n";
                        codigo_tpm += "Add\n";


                        Xblockes.agregar_AlInicio(codigo_tpm, RAIZ);

                        codigo_tpm = "set_global $calc"+"//setear el valor de la variable\n";
                        Xblockes.agregar(codigo_tpm, RAIZ);
                        simbolo.inicializado = true;
                    }else
                    {
                        Interprete.Interpretacion.Lista_Errores.add(RAIZ.linea, RAIZ.columna, "Semantico", "Error de asignacion la variable ["+simbolo.nombre + "] es de tipo"+simbolo.tipo+" y no acepta" +resultado.tipo, RAIZ.archivo);
                    }
                    break;
                }
                break;       
        }
    }
}
