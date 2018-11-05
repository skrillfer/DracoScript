/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interprete.ALR;

import ESTRUCTURAS.Blocke;
import ESTRUCTURAS.Nodo;
import ESTRUCTURAS.Resultado;

/**
 *
 * @author fernando
 */
public class Relacional extends Interprete.Interpretacion {
    Blocke blq1 = null;
    Blocke blq2 = null;
    int    i1   = -1;
    int    i2   = -1;
    public Resultado OPERAR(Nodo RAIZ) {
        Resultado r1 = null;
        Resultado r2 = null;
        switch (RAIZ.nombre) {
            case "MAS":
            case "MENOS":
            case "POR":
            case "DIV":
            case "POT":
                XopA = new Aritmetica();
                return XopA.OPERAR(RAIZ);
            case "IG_IG":
            case "DIF":
            case "MENQ":
            case "MENIQ":
            case "MAYQ":
            case "MAYIQ":
                XopA = new Aritmetica();
                //--------------------------------------------------------------
                Xblockes.seniaLuego();
                
                r1 = XopA.OPERAR(RAIZ.hijos.get(0));
                blq1 = Xblockes.get_Next();
                i1 = Xblockes.ii;

                //--------------------------------------------------------------
                Xblockes.seniaLuego();
                
                r2 = XopA.OPERAR(RAIZ.hijos.get(1));
                blq2 = Xblockes.get_Next();
                i2 = Xblockes.ii;

                //--------------------------------------------------------------
                
                break;
            default:
                XopA = new Aritmetica();
                r1=XopA.OPERAR(RAIZ);
                return r1;

        }

        switch (RAIZ.nombre) {
            case "IG_IG":
            case "DIF":
            case "MENQ":
            case "MENIQ":
            case "MAYQ":
            case "MAYIQ":    
                switch(r1.tipo)
                {
                    case "entero":
                        switch(r2.tipo)
                        {
                            case "entero":
                                return operacionSimple(r1, getTIPOREL(RAIZ.nombre), r2, "booleano", RAIZ);
                        }
                        break;
                    case "decimal":
                        switch(r2.tipo)
                        {
                            case "decimal":
                                return operacionSimple(r1, getTIPOREL(RAIZ.nombre), r2, "booleano", RAIZ);
                        }
                        break;
                    case "caracter":
                        switch(r2.tipo)
                        {
                            case "caracter":
                                return operacionSimple(r1, getTIPOREL(RAIZ.nombre), r2, "booleano", RAIZ);
                        }
                        break;
                    case "booleano":
                        switch(r2.tipo)
                        {
                            case "booleano":
                                return operacionSimple(r1, getTIPOREL(RAIZ.nombre), r2, "booleano", RAIZ);
                        }
                        break;
                    case "cadena":
                        switch(r2.tipo)
                        {
                            case "cadena":
                                return operacionCadenas(r1, RAIZ.nombre, r2, "booleano", RAIZ);
                        }
                        break;
                    default:
                        //error
                        break;
                }
            
                
              break;
        }
        return new Resultado("-1", "");
    }
    
    
    public Resultado operacionSimple(Resultado r1,String operador, Resultado r2,String tipo,Nodo nodo)
    {
        String codigo_tmp = "";
        String etqV = control.generar_etiqueta();
        String etqF = control.generar_etiqueta();
        if(operador.equals("IG_IG") || operador.equals("DIF"))
        {
            if(operador.equals("IG_IG"))
            {
                codigo_tmp += "diff\n";
                codigo_tmp += "eqz\n";
            }else
            {
                codigo_tmp += "diff\n";
                codigo_tmp += "eqz\n";
                codigo_tmp += "not\n";
            }
        }
        else
        {
            codigo_tmp += operador+"\n";
        }
        
        codigo_tmp += "br_if " + etqF + "\n";
        codigo_tmp += "br " + etqV + "\n";
        
        Xblockes.agregar(codigo_tmp, nodo);
        return new Resultado("booleano", "",etqV,etqF);
    }
    
    public Resultado operacionCadenas(Resultado r1,String operador, Resultado r2,String tipo,Nodo nodo)
    {   
        String codigo_tmp = "";
        String etqV = control.generar_etiqueta();
        String etqF = control.generar_etiqueta();
        
        codigo_tmp = "\n\n\n//---->INTERCALADO\n";
        codigo_tmp += "get_local 0\n";
        codigo_tmp += De$pl4z4r()+"\n";
        codigo_tmp += "add\n";
        codigo_tmp += "1\n";
        codigo_tmp += "add\n";
        codigo_tmp += "//Fin---->INTERCALADO\n\n\n";
        
        blq1.intercalar(i1, codigo_tmp);
        
        codigo_tmp = "";
        if(r1.ref && r1.tipo.equals("cadena"))
        {
            codigo_tmp = "get_global $calc\n";
        }
        codigo_tmp += "set_local $calc\n";
        blq1.add(codigo_tmp);
        
        
        
        
        
        codigo_tmp = "\n\n\n//---->INTERCALADO\n";
        codigo_tmp += "get_local 0\n";
        codigo_tmp += De$pl4z4r()+"\n";
        codigo_tmp += "add\n";
        codigo_tmp += "2\n";
        codigo_tmp += "add\n";
        codigo_tmp += "//Fin---->INTERCALADO\n\n\n";

        blq2.intercalar(i2, codigo_tmp);
        
        codigo_tmp = "";
        if(r2.ref && r2.tipo.equals("cadena"))
        {
            codigo_tmp = "get_global $calc\n";
        }
        codigo_tmp += "set_local $calc";
        blq1.add(codigo_tmp);

        //
        codigo_tmp = "\n//CAMBIO de AMBITO REAL\n";
        codigo_tmp +=  "0"+"\n";
        codigo_tmp +=  "get_local 0"+"\n";
        codigo_tmp += De$pl4z4r()+"\n";
        codigo_tmp += "add\n";
        codigo_tmp +=  "set_local $calc"+"\n";
        codigo_tmp += "//________________________\n\n";        
        //
        
        
        switch(operador)
        {
            case "IG_IG":
                codigo_tmp +="call $$_noIgual\n";
                break;
            case "DIF":
                codigo_tmp +="call $$_igualIgual\n";
                break;
            case "MENQ":
                codigo_tmp +="call $$_menor\n";
                break; 
            case "MENIQ":
                codigo_tmp +="call $$_menorIgual\n";
                break; 
            case "MAYQ":
                codigo_tmp +="call $$_mayor\n";
                break;
            case "MAYIQ":
                codigo_tmp +="call $$_mayorIgual\n";
                break; 
        }
        
        codigo_tmp += "\n\nget_local 0\n";
        codigo_tmp += "0\n";
        codigo_tmp += "add\n";
        codigo_tmp += "get_local $calc\n";
        
        //
        codigo_tmp += "\n//REGRESO de AMBITO REAL\n";
        codigo_tmp +=  "0"+"\n";
        codigo_tmp +=  "get_local 0"+"\n";
        codigo_tmp += De$pl4z4r()+"\n";
        codigo_tmp += "diff\n";
        codigo_tmp +=  "set_local $calc"+"\n";
        codigo_tmp += "//________________________\n";        
        //
        
        
        codigo_tmp += "br_if " + etqF + "\n";
        codigo_tmp += "br " + etqV + "\n";
        
        Xblockes.agregar(codigo_tmp, nodo);
        
        return new Resultado("booleano", "",etqV,etqF);
    }
    
    public String getTIPOREL(String str)
    {
        switch(str)
        {
            case "IG_IG":
                return "IG_IG";
            case "DIF":
                return "DIF";
            case "MENQ":
                return "Lt";
            case "MENIQ":
                return "Lte";
            case "MAYQ":
                return "Gt";
            case "MAYIQ":
                return "Gte";
            default:
                return "";
        }
    }
}
