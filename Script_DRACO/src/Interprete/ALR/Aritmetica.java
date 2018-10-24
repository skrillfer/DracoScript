/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interprete.ALR;

import ESTRUCTURAS.Nodo;
import ESTRUCTURAS.Resultado;

/**
 *
 * @author fernando
 */
public class Aritmetica extends Interprete.Interpretacion{
    public Resultado OPERAR(Nodo raiz)
    {
        Resultado r1=null;
        Resultado r2=null;
        switch(raiz.nombre)
        {
            case "MAS":
            case "MENOS":
            case "POR":
            case "DIV":
            case "POT":
                r1 = this.OPERAR(raiz.hijos.get(0));
                r2 = this.OPERAR(raiz.hijos.get(1));
                break;    
            case "MENQ":
            case "MENIQ":
            case "MAYQ":
            case "MAYIQ":
            case "IG_IG":
            case "DIF":
            case "AND":
            case "OR":
            case "NOT":    
                XopL = new Logica();
                return XopL.OPERAR(raiz);
                
            case "STRING_LITERAL":
                for (char c : raiz.valor.toCharArray()) {
                    
                }
                break;    
            case "CHAR_LITERAL":
                return Retorno("caracter", "", (int)((char)raiz.valor.charAt(1))+"\n", raiz);
            case "NUM_LITERAL":
                return Retorno("entero", "", raiz.valor+"\n", raiz);
            case "DECIMAL_LITERAL":
                return Retorno("decimal", "", raiz.valor+"\n", raiz);
            case "VERDADERO_LITERAL":
                return Retorno("booleano", "", "1\n", raiz);
            case "FALSO_LITERAL":
                return Retorno("booleano", "", "0\n", raiz);
            case "NULO_LITERAL":
                return Retorno("nulo", "", String.valueOf((int)nulo)+"\n", raiz);
        }
        
        switch(raiz.nombre)
        {
            case "MAS":
                switch(r1.tipo)
                {
                    case "entero":
                        switch(r2.tipo)
                        {
                            case "entero":
                            case "booleano":
                            case "caracter":    
                                return Retorno("entero","","Add\n",raiz);
                            case "decimal":
                                return Retorno("decimal","","Add\n",raiz);
                            case "cadena":
                                //return Retorno("cadena","","Add\n",raiz);
                            default:
                                Interprete.Interpretacion.Lista_Errores.add(raiz.linea, raiz.columna, "Semantico", "Error de tipos entre:" + r1.tipo+"-"+r2.tipo + " operacion:"+raiz.nombre, raiz.archivo);
                                break;
                        }
                    break;    
                    case "decimal":
                        switch(r2.tipo)
                        {
                            case "entero":
                            case "booleano":
                            case "caracter":    
                            case "decimal":
                                return Retorno("decimal","","Add\n",raiz);
                            case "cadena":
                                //return Retorno("cadena","","Add\n",raiz);
                            default:
                                Interprete.Interpretacion.Lista_Errores.add(raiz.linea, raiz.columna, "Semantico", "Error de tipos entre:" + r1.tipo+"-"+r2.tipo + " operacion:"+raiz.nombre, raiz.archivo);
                                break;
                        }
                    break;
                    case "caracter":
                        switch(r2.tipo)
                        {
                            case "entero":
                                return Retorno("entero","","Add\n",raiz);
                            case "decimal":
                                return Retorno("decimal","","Add\n",raiz);
                            case "cadena":
                                //return Retorno("cadena","","Add\n",raiz);
                            default:
                                Interprete.Interpretacion.Lista_Errores.add(raiz.linea, raiz.columna, "Semantico", "Error de tipos entre:" + r1.tipo+"-"+r2.tipo + " operacion:"+raiz.nombre, raiz.archivo);
                                break;
                        }
                    break;
                    case "booleano":
                        switch(r2.tipo)
                        {
                            case "entero":
                                return Retorno("entero","","Add\n",raiz);
                            case "decimal":
                                return Retorno("decimal","","Add\n",raiz);
                            case "booleano":
                                return Retorno("booleano","","Add\n",raiz);
                            default:
                                Interprete.Interpretacion.Lista_Errores.add(raiz.linea, raiz.columna, "Semantico", "Error de tipos entre:" + r1.tipo+"-"+r2.tipo + " operacion:"+raiz.nombre, raiz.archivo);
                                break;
                        }
                    break;
                    case "cadena":
                        switch(r2.tipo)
                        {
                            case "entero":
                            case "decimal":
                            case "caracter":    
                                //return Retorno("cadena","","Add\n",raiz);
                            
                            case "cadena":
                                //return Retorno("cadena","","Add\n",raiz);
                            default:
                                Interprete.Interpretacion.Lista_Errores.add(raiz.linea, raiz.columna, "Semantico", "Error de tipos entre:" + r1.tipo+"-"+r2.tipo + " operacion:"+raiz.nombre, raiz.archivo);
                                break;
                        }
                    break;
                    default:
                          Interprete.Interpretacion.Lista_Errores.add(raiz.linea, raiz.columna, "Semantico", "Error de tipos entre:" + r1.tipo+"-"+r2.tipo + " operacion:"+raiz.nombre, raiz.archivo);
                        break;
                }
                break;
            case "MENOS":
                switch(r1.tipo)
                {
                    case "entero":
                        switch(r2.tipo)
                        {
                            case "entero":
                            case "booleano":
                            case "caracter":    
                                return Retorno("entero","","Diff\n",raiz);
                            case "decimal":
                                return Retorno("decimal","","Diff\n",raiz);
                            default:
                                Interprete.Interpretacion.Lista_Errores.add(raiz.linea, raiz.columna, "Semantico", "Error de tipos entre:" + r1.tipo+"-"+r2.tipo + " operacion:"+raiz.nombre, raiz.archivo);
                                break;
                        }
                    break;    
                    case "decimal":
                        switch(r2.tipo)
                        {
                            case "entero":
                            case "booleano":
                            case "caracter":    
                            case "decimal":
                                return Retorno("decimal","","Diff\n",raiz);
                            default:
                                Interprete.Interpretacion.Lista_Errores.add(raiz.linea, raiz.columna, "Semantico", "Error de tipos entre:" + r1.tipo+"-"+r2.tipo + " operacion:"+raiz.nombre, raiz.archivo);
                                break;
                        }
                    break;
                    case "caracter":
                        switch(r2.tipo)
                        {
                            case "entero":
                                return Retorno("entero","","Diff\n",raiz);
                            case "decimal":
                                return Retorno("decimal","","Diff\n",raiz);
                            default:
                                Interprete.Interpretacion.Lista_Errores.add(raiz.linea, raiz.columna, "Semantico", "Error de tipos entre:" + r1.tipo+"-"+r2.tipo + " operacion:"+raiz.nombre, raiz.archivo);
                                break;
                        }
                    break;
                    case "booleano":
                        switch(r2.tipo)
                        {
                            case "entero":
                                return Retorno("entero","","Diff\n",raiz);
                            case "decimal":
                                return Retorno("decimal","","Diff\n",raiz);     
                            default:
                                Interprete.Interpretacion.Lista_Errores.add(raiz.linea, raiz.columna, "Semantico", "Error de tipos entre:" + r1.tipo+"-"+r2.tipo + " operacion:"+raiz.nombre, raiz.archivo);
                                break;
                        }
                    break;
                    
                    default:
                          Interprete.Interpretacion.Lista_Errores.add(raiz.linea, raiz.columna, "Semantico", "Error de tipos entre:" + r1.tipo+"-"+r2.tipo + " operacion:"+raiz.nombre, raiz.archivo);
                        break;
                }
                break;    
            //------------------------------------------------------------------
            case "POR":
                switch(r1.tipo)
                {
                    case "entero":
                        switch(r2.tipo)
                        {
                            case "entero":
                            case "booleano":
                            case "caracter":    
                                return Retorno("entero","","Mult\n",raiz);
                            case "decimal":
                                return Retorno("decimal","","Mult\n",raiz);
                            default:
                                Interprete.Interpretacion.Lista_Errores.add(raiz.linea, raiz.columna, "Semantico", "Error de tipos entre:" + r1.tipo+"-"+r2.tipo + " operacion:"+raiz.nombre, raiz.archivo);
                                break;
                        }
                    break;    
                    case "decimal":
                        switch(r2.tipo)
                        {
                            case "entero":
                            case "booleano":
                            case "caracter":    
                            case "decimal":
                                return Retorno("decimal","","Mult\n",raiz);
                            default:
                                Interprete.Interpretacion.Lista_Errores.add(raiz.linea, raiz.columna, "Semantico", "Error de tipos entre:" + r1.tipo+"-"+r2.tipo + " operacion:"+raiz.nombre, raiz.archivo);
                                break;
                        }
                    break;
                    case "caracter":
                        switch(r2.tipo)
                        {
                            case "entero":
                                return Retorno("entero","","Mult\n",raiz);
                            case "decimal":
                                return Retorno("decimal","","Mult\n",raiz);
                            default:
                                Interprete.Interpretacion.Lista_Errores.add(raiz.linea, raiz.columna, "Semantico", "Error de tipos entre:" + r1.tipo+"-"+r2.tipo + " operacion:"+raiz.nombre, raiz.archivo);
                                break;
                        }
                    break;
                    case "booleano":
                        switch(r2.tipo)
                        {
                            case "booleano":
                                //return Retorno("booleano","","Mult\n",raiz);
                            
                            case "entero":
                                return Retorno("entero","","Mult\n",raiz);
                            case "decimal":
                                return Retorno("decimal","","Mult\n",raiz);     
                            default:
                                Interprete.Interpretacion.Lista_Errores.add(raiz.linea, raiz.columna, "Semantico", "Error de tipos entre:" + r1.tipo+"-"+r2.tipo + " operacion:"+raiz.nombre, raiz.archivo);
                                break;
                        }
                    break;
                    
                    default:
                          Interprete.Interpretacion.Lista_Errores.add(raiz.linea, raiz.columna, "Semantico", "Error de tipos entre:" + r1.tipo+"-"+r2.tipo + " operacion:"+raiz.nombre, raiz.archivo);
                        break;
                }
                break;        
                //------------------------------------------------------------------
            case "DIV":
                switch(r1.tipo)
                {
                    case "entero":
                        switch(r2.tipo)
                        {
                            case "entero":
                            case "booleano":
                            case "caracter":    
                            case "decimal":
                                return Retorno("decimal","","Div\n",raiz);
                            default:
                                Interprete.Interpretacion.Lista_Errores.add(raiz.linea, raiz.columna, "Semantico", "Error de tipos entre:" + r1.tipo+"-"+r2.tipo + " operacion:"+raiz.nombre, raiz.archivo);
                                break;
                        }
                    break;    
                    case "decimal":
                        switch(r2.tipo)
                        {
                            case "entero":
                            case "booleano":
                            case "caracter":    
                            case "decimal":
                                return Retorno("decimal","","Div\n",raiz);
                            default:
                                Interprete.Interpretacion.Lista_Errores.add(raiz.linea, raiz.columna, "Semantico", "Error de tipos entre:" + r1.tipo+"-"+r2.tipo + " operacion:"+raiz.nombre, raiz.archivo);
                                break;
                        }
                    break;
                    case "caracter":
                        switch(r2.tipo)
                        {
                            case "entero":
                            case "decimal":
                                return Retorno("decimal","","Div\n",raiz);
                            default:
                                Interprete.Interpretacion.Lista_Errores.add(raiz.linea, raiz.columna, "Semantico", "Error de tipos entre:" + r1.tipo+"-"+r2.tipo + " operacion:"+raiz.nombre, raiz.archivo);
                                break;
                        }
                    break;
                    case "booleano":
                        switch(r2.tipo)
                        {
                            case "entero":
                            case "decimal":
                                return Retorno("decimal","","Mult\n",raiz);     
                            default:
                                Interprete.Interpretacion.Lista_Errores.add(raiz.linea, raiz.columna, "Semantico", "Error de tipos entre:" + r1.tipo+"-"+r2.tipo + " operacion:"+raiz.nombre, raiz.archivo);
                                break;
                        }
                    break;
                    
                    default:
                          Interprete.Interpretacion.Lista_Errores.add(raiz.linea, raiz.columna, "Semantico", "Error de tipos entre:" + r1.tipo+"-"+r2.tipo + " operacion:"+raiz.nombre, raiz.archivo);
                        break;
                }
                break;   
                //------------------------------------------------------------------
            case "POT":
                switch(r1.tipo)
                {
                    case "entero":
                        switch(r2.tipo)
                        {
                            case "entero":
                            case "booleano":
                            case "caracter": 
                                return Retorno("entero","","POT\n",raiz);

                            case "decimal":
                                return Retorno("decimal","","POT\n",raiz);
                            default:
                                Interprete.Interpretacion.Lista_Errores.add(raiz.linea, raiz.columna, "Semantico", "Error de tipos entre:" + r1.tipo+"-"+r2.tipo + " operacion:"+raiz.nombre, raiz.archivo);
                                break;
                        }
                    break;    
                    case "decimal":
                        switch(r2.tipo)
                        {
                            case "entero":
                            case "booleano":
                            case "caracter":    
                            case "decimal":
                                return Retorno("decimal","","POT\n",raiz);
                            default:
                                Interprete.Interpretacion.Lista_Errores.add(raiz.linea, raiz.columna, "Semantico", "Error de tipos entre:" + r1.tipo+"-"+r2.tipo + " operacion:"+raiz.nombre, raiz.archivo);
                                break;
                        }
                    break;
                    case "caracter":
                        switch(r2.tipo)
                        {
                            case "entero":
                                return Retorno("entero","","POT\n",raiz);
                            case "decimal":
                                return Retorno("decimal","","POT\n",raiz);
                            default:
                                Interprete.Interpretacion.Lista_Errores.add(raiz.linea, raiz.columna, "Semantico", "Error de tipos entre:" + r1.tipo+"-"+r2.tipo + " operacion:"+raiz.nombre, raiz.archivo);
                                break;
                        }
                    break;
                    case "booleano":
                        switch(r2.tipo)
                        {
                            case "entero":
                                return Retorno("entero","","POT\n",raiz);
                            case "decimal":
                                return Retorno("decimal","","POT\n",raiz);
                            default:
                                Interprete.Interpretacion.Lista_Errores.add(raiz.linea, raiz.columna, "Semantico", "Error de tipos entre:" + r1.tipo+"-"+r2.tipo + " operacion:"+raiz.nombre, raiz.archivo);
                                break;
                        }
                    break;
                    default:
                          Interprete.Interpretacion.Lista_Errores.add(raiz.linea, raiz.columna, "Semantico", "Error de tipos entre:" + r1.tipo+"-"+r2.tipo + " operacion:"+raiz.nombre, raiz.archivo);
                        break;
                }
                break;      
            
        }
        return new Resultado("-1", null, "", "");
    }
    
    
    public Resultado Retorno(String tipo, Object valor,String cod_operacion, Nodo nodo)
    {
        //control.codigoDASM += cod_operacion;
        Xblockes.agregar(cod_operacion, nodo);
        return new Resultado(tipo, valor);
    }
}
