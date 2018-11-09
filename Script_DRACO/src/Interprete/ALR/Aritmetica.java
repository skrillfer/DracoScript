/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interprete.ALR;

import ESTRUCTURAS.Blocke;
import ESTRUCTURAS.Nodo;
import ESTRUCTURAS.Resultado;
import ESTRUCTURAS.Simbolo;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author fernando
 */
public class Aritmetica extends Interprete.Interpretacion{
    Blocke blq1 = null;
    Blocke blq2 = null;
    int    i1   = -1;
    int    i2   = -1;
    
    int    d1   = -1;
    int    d2   = -1;
    public Resultado OPERAR(Nodo raiz)
    {
        String codigotmp ="";
        Resultado r1=null;
        Resultado r2=null;
        switch(raiz.nombre)
        {
            case "MAS":
            case "MENOS":
            case "POR":
            case "DIV":
            case "POT":
                //--------------------------------------------------------------
                Xblockes.seniaLuego();
                Xblockes.agregar("", raiz);
                r1 = this.OPERAR(raiz.hijos.get(0));
                
                
                
                blq1 = Xblockes.get_Next();
                i1   = Xblockes.getII();
                //d1   = blq1.Hacer_Senia();
                
                //--------------------------------------------------------------
                Xblockes.seniaLuego();
                Xblockes.agregar("", raiz);
                r2 = this.OPERAR(raiz.hijos.get(1));
                
                
                blq2 = Xblockes.get_Next();
                i2   = Xblockes.getII();
                //d2   = blq2.Hacer_Senia();
                
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
                String codigo_tmp = "\n\nget_global 0 //obtener el puntero de h3ap\n";
                //raiz.valor = raiz.valor.substring(1, raiz.valor.length()-1);
                for (char c : raiz.valor.toCharArray()) {
                    codigo_tmp   += "get_global 0 //obtener el valor puntero de heap\n";
                    codigo_tmp   += (int)c +" //ascii de caracter:"+c+"\n";
                    codigo_tmp   += "set_global $calc //setear valor en heap\n";
                    codigo_tmp   += "//incremento el valor de puntero h=h+1\n";
                    codigo_tmp   += "0\n";
                    codigo_tmp   += "get_global 0 //obtener el valor puntero de heap\n";
                    codigo_tmp   += "1\n";
                    codigo_tmp   += "add\n";
                    codigo_tmp   += "set_global $calc //setear valor del ptr de heap\n";
                }
                codigo_tmp   += "get_global 0 //obtener el valor puntero de heap\n";
                codigo_tmp   += "0 //ascii de caracter final\n";
                codigo_tmp   += "set_global $calc //setear valor en heap\n";
                
                codigo_tmp   += "//incremento el valor de puntero h=h+1\n";
                codigo_tmp   += "0\n";
                codigo_tmp   += "get_global 0 //obtener el valor puntero de heap\n";
                codigo_tmp   += "1\n";
                codigo_tmp   += "add\n";
                codigo_tmp   += "set_global $calc //setear valor del ptr de heap\n\n\n\n\n";
                
                return Retorno("cadena", "", codigo_tmp, raiz);
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
            case "Acceso":
                return acceso(raiz);
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
                                
                                codigotmp = "\n\n\n\n//PARAM1 Concantenado a string con "+r2.tipo+"\n";
                                codigotmp += "get_local 0\n";
                                codigotmp += De$pl4z4r()+"\n";
                                codigotmp += "add\n";
                                codigotmp += "1\n";
                                codigotmp += "add\n";
                                
                                
                                blq1.intercalar(i1, codigotmp);
                                
                                codigotmp = "";
                                if(r1.ref && r1.tipo.equals("cadena"))
                                {
                                    codigotmp += "get_global $calc\n";
                                    
                                }
                                codigotmp +="set_local $calc//C4RAK\n";
                                String cod12= codigotmp;
                                
                                
                                codigotmp = "\n\n\nget_local 0//PARAM2\n";
                                codigotmp += De$pl4z4r()+"\n";
                                codigotmp += "add\n";
                                codigotmp += "2\n";
                                codigotmp += "add\n";
                                
                                codigotmp += "//Castendo numero a string\n";
                                codigotmp += "get_local 0\n";
                                codigotmp += De$pl4z4r()+"\n";
                                codigotmp += "add\n";
                                codigotmp += "1\n";
                                codigotmp += "add\n";
                                
                                blq2.intercalar(i2, codigotmp);
                                
                                codigotmp = "set_local $calc\n";
                                blq2.add(codigotmp);
                                
                                /*
                                */
                                codigotmp = "//CAMBIO de AMBITO REAL\n" +
                                            "0\n" +
                                            "get_local 0\n" +
                                             De$pl4z4r() + "\n" +
                                            "add\n" +
                                            "set_local $calc\n" +
                                            "//________________________\n";
                                
                                codigotmp += "call $$_getStr\n";
                                
                                codigotmp += "\n\n//Obtengo el retorno de outstr\n\n"+
                                             "get_local 0\n" +
                                             "0\n" +
                                             "add\n" +
                                             "get_local $calc\n"+
                                             "//Obtengo el retorno de outstr\n";
                                
                                codigotmp += "\n\n//REGRESO de AMBITO REAL\n" +
                                            "0\n" +
                                            "get_local 0\n" +
                                             De$pl4z4r() + "\n" +
                                            "diff\n" +
                                            "set_local $calc\n" +
                                            "//________________________\n\n\n\n\n\n\n";
                                
                                codigotmp += cod12;
                                codigotmp += "set_local $calc//C4RAK\n";
                                codigotmp += "\n\n//CAMBIO de AMBITO REAL\n" +
                                            "0\n" +
                                            "get_local 0\n" +
                                             De$pl4z4r() + "\n" +
                                            "add\n" +
                                            "set_local $calc\n" +
                                            "//________________________\n";
                                
                                codigotmp += "call $$_concat\n";
                                
                                codigotmp += "\n\n//Obtengo el retorno de concat\n\n"+
                                             "get_local 0\n" +
                                             "0\n" +
                                             "add\n" +
                                             "get_local $calc\n"+
                                             "//Obtengo el retorno de concat\n";
                                
                                codigotmp += "\n\n//REGRESO de AMBITO REAL\n" +
                                            "0\n" +
                                            "get_local 0\n" +
                                             De$pl4z4r() + "\n" +
                                            "diff\n" +
                                            "set_local $calc\n" +
                                            "//________________________\n\n\n\n\n\n\n";
                                
                                blq2.add(codigotmp);
                                return new Resultado("cadena", "");
                                //return Retorno("cadena","",codigotmp,raiz);
                                
                            case "cadena":
                                codigotmp = "\n\n\n\n//Concantenado a string con string\n";
                                codigotmp += "get_local 0\n";
                                codigotmp += De$pl4z4r()+"\n";
                                codigotmp += "add\n";
                                codigotmp += "1\n";
                                codigotmp += "add\n";
                                
                                
                                blq1.intercalar(i1, codigotmp);
                                
                                codigotmp = "";
                                if(r1.ref && r1.tipo.equals("cadena"))
                                {
                                    codigotmp += "get_global $calc\n";
                                    
                                }
                                codigotmp +="set_local $calc//C4RAK\n";
                                String cod2= codigotmp;
                                //blq1.intercalarF(d1,codigotmp);
                                
                                

                                codigotmp = "\n\n\nget_local 0\n";
                                codigotmp += De$pl4z4r()+"\n";
                                codigotmp += "add\n";
                                codigotmp += "2\n";
                                codigotmp += "add\n";
                                
                                blq2.intercalar(i2, codigotmp);
                                
                                codigotmp = cod2;
                                if(r2.ref && r2.tipo.equals("cadena"))
                                {
                                    codigotmp += "get_global $calc\n";
                                    
                                }
                                codigotmp +="set_local $calc//C4RAK\n";
                                //blq2.intercalarF(d2,codigotmp);
                                
                                
                                
                                codigotmp += "\n\n//CAMBIO de AMBITO REAL\n" +
                                            "0\n" +
                                            "get_local 0\n" +
                                             De$pl4z4r() + "\n" +
                                            "add\n" +
                                            "set_local $calc\n" +
                                            "//________________________\n";
                                
                                codigotmp += "call $$_concat\n";
                                
                                codigotmp += "\n\n//Obtengo el retorno de concat\n\n"+
                                             "get_local 0\n" +
                                             "0\n" +
                                             "add\n" +
                                             "get_local $calc\n"+
                                             "//Obtengo el retorno de concat\n";
                                
                                codigotmp += "\n\n//REGRESO de AMBITO REAL\n" +
                                            "0\n" +
                                            "get_local 0\n" +
                                             De$pl4z4r() + "\n" +
                                            "diff\n" +
                                            "set_local $calc\n" +
                                            "//________________________\n\n\n\n\n\n\n";
                                
                                return Retorno("cadena","",codigotmp,raiz);
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
        Xblockes.agregar(cod_operacion, nodo);
        return new Resultado(tipo, valor);
    }
    
    
    public Resultado acceso(Nodo RAIZ)
    {
        JOptionPane.showMessageDialog(null, "joli");
        String codigo_tmp = "";
        ArrayList<String> ambitoTMP = ambito;
        Simbolo simbolo = null;
        Simbolo aux = null;
        ArrayList<String> ambito_tmp = ambito;
        Resultado resultado1  = new Resultado("-1", null);
        for (int i = 0; i < RAIZ.hijos.size(); i++) {
            Nodo nodo_acc = RAIZ.hijos.get(i);
            codigo_tmp="";
            switch(nodo_acc.nombre)
            {
                case "AccesoId":
                    simbolo = tabla.ObtenerSimboloDeclarado(nodo_acc.hijos.get(0).valor, ambito);
                    if(simbolo==null)
                    {
                        JOptionPane.showMessageDialog(null, "joliSHITG:"+nodo_acc.hijos.get(0).valor);

                        Lista_Errores.add(nodo_acc.hijos.get(0).linea, nodo_acc.hijos.get(0).columna, "Semantico","La variable "+nodo_acc.hijos.get(0).valor+" no existe", nodo_acc.hijos.get(0).archivo);
                        return new Resultado("-1",null);	
                    }

                    if(simbolo.ambito.equals("global"))
                    {
                        constructor = true;
                    }
                    if(Xnivel==0)
                    {
                        if(simbolo.ambito.equals("global"))
                        {
                            constructor = true;
                            codigo_tmp  += simbolo.direccion+"\n";
                        }else
                        {
                            if(constructor)
                            {
                                codigo_tmp  += "get_local 0\n";
                                codigo_tmp  += "1\n";
                                codigo_tmp  += "add\n";
                                codigo_tmp  += "get_local $calc\n";
                                codigo_tmp  += "add\n";
                                
                            }else
                            {
                                codigo_tmp += "get_local 0\n";
                                codigo_tmp += simbolo.direccion+"\n";
                                codigo_tmp += "add\n";
                            }
                        }
                        if(constructor)
                        {
                            codigo_tmp  += "get_global $calc\n";
                        }else
                        {
                            codigo_tmp  += "get_local $calc\n";
                          
                        }
                        resultado1 = new Resultado(simbolo.tipo, "",true);
                        resultado1.simbolo = simbolo;
                    }else
                    {
                        if(constructor)
                        {
                        }else
                        {
                            codigo_tmp  += simbolo.direccion+"\n";
                            codigo_tmp  += "add\n";
                            
                            if(!simbolo.tipo.equals("cadena") || !simbolo.dimension.isEmpty())
                            {
                                codigo_tmp  += "get_global $calc\n";
                            }
                        }
                        resultado1 = new Resultado(simbolo.tipo, "",true);
                        resultado1.simbolo = simbolo;
                    }
                    if(i==0)
                    {
                        ambito = new ArrayList<>();
                    }

                    if(!es_primitivo(simbolo.tipo) && i!=RAIZ.hijos.size()-1)
                    {
                        Xnivel++;
                        Simbolo struct = tabla.obtener_Estructura(simbolo, ambito);
                        ambito = new ArrayList<>();
                        if(struct ==null)
                        {
                            Lista_Errores.add(nodo_acc.linea, nodo_acc.columna, "Semantico", "La estructura "+ simbolo.tipo + " no existe", nodo_acc.archivo);
                            return new Resultado("-1", null);
                        }
                        ambito.add(simbolo.tipo);
                    }
                    Xblockes.agregar("\n\n\n"+codigo_tmp+"\n\n\n", nodo_acc);
                    break;
                case "llamada":
                    resultado1 = llamada_metodo(nodo_acc);
                    Simbolo metodo_sim = resultado1.simbolo;
                    
                    ambito = new ArrayList<>();
                    if(!es_primitivo(metodo_sim.tipo) && !metodo_sim.tipo.equals("vacio") )
                    {
                        Xnivel++;
                        
                        Simbolo simbolo_struct = tabla.obtener_Estructura(metodo_sim, ambito);
                        if(simbolo_struct==null)
                        {   
                            Lista_Errores.add(nodo_acc.linea, nodo_acc.columna, "Semantico", "No existe la estructura:"+metodo_sim.tipo, nodo_acc.archivo);
                            return new Resultado("-1", null);
                        }
                        ambito.add(metodo_sim.tipo);
                        resultado1.ref = true;
                    }
                    break;    
                case "AccesoArray":
                    break;    
            }
        }
        //JOptionPane.showMessageDialog(null, codigo_tmp);
        

        ambito = ambito_tmp;
        Xnivel = 0;
        return resultado1;
    }
    
    public Resultado llamada_metodo(Nodo RAIZ)
    {
        String id_metodo = generarId(RAIZ);
        Simbolo metodo_call = tabla.obtener_Simbolo(id_metodo, new ArrayList<>());
        if(metodo_call==null)
        {
            Lista_Errores.add(RAIZ.linea, RAIZ.columna,"Semantico", "El metodo "+id_metodo + " no existe", RAIZ.archivo);
            return new Resultado("-1", null);
        }
        String codigo_tmp ="\n\n";//"\n\n//*********************Llamada a metodo:" + metodo_call.nombre+"\n";
        Xblockes.agregar_AlUltimoBloque(codigo_tmp);
        
        ArrayList<Nodo> Parametros = metodo_call.nodo.hijos.get(2).hijos;
        ArrayList<Nodo> valorParametros = RAIZ.hijos.get(1).hijos;
        
        ArrayList<String> ambito_Auxiliar = new ArrayList<>();
        ambito_Auxiliar.add(id_metodo);
        
        for (int i=0; i < Parametros.size() ; i++) {
            Nodo Parametro = Parametros.get(i);
            
            Simbolo simboloParam = tabla.obtener_Simbolo(Parametro.hijos.get(1).valor, ambito_Auxiliar);
            XopA = new Aritmetica();

            codigo_tmp = "get_local 0"+"\n";
            codigo_tmp += De$pl4z4r()+"\n";
            codigo_tmp += "add\n";
            
            if(simboloParam.tipo.equals("cadena"))
            {
                
            }else
            {
                codigo_tmp += simboloParam.direccion + "\n";
                codigo_tmp += "add\n";
                
            }
            
            Xblockes.agregar(codigo_tmp, valorParametros.get(i));
            
            XopA.OPERAR(valorParametros.get(i));

            codigo_tmp = "set_local $calc"+"\n";
            Xblockes.agregar_AlUltimoBloque(codigo_tmp);
           
        }
        
        codigo_tmp = "\n//CAMBIO de AMBITO REAL\n";
        codigo_tmp +=  "0"+"\n";
        codigo_tmp +=  "get_local 0"+"\n";
        codigo_tmp += De$pl4z4r()+"\n";
        codigo_tmp += "add\n";
        codigo_tmp +=  "set_local $calc"+"\n";
        codigo_tmp += "//________________________\n";
        
        codigo_tmp += "call " + id_metodo + "\n";
        if(!metodo_call.tipo.equals("vacio"))
        {
            codigo_tmp += "get_local $ret" + "\n";
        }
        
        codigo_tmp += "\n//REGRESO de AMBITO ACTUAL\n";
        codigo_tmp +=  "0"+"\n";
        codigo_tmp +=  "get_local 0"+"\n";
        codigo_tmp += De$pl4z4r()+"\n";
        codigo_tmp += "diff\n";
        codigo_tmp +=  "set_local $calc"+"\n";
        codigo_tmp += "//________________________\n";
        
        codigo_tmp += "//FIN DE LLAMADA METODO********\n\n";
        Xblockes.agregar_AlUltimoBloque(codigo_tmp);

        Resultado ret_res = new Resultado(metodo_call.tipo, "");
        ret_res.simbolo = metodo_call;
        return ret_res;
    }
    
    public String generarId(Nodo nodo)
    {
        String nombre = nodo.hijos.get(0).valor;
        ArrayList<Nodo> parametros = nodo.hijos.get(1).hijos;
        for (Nodo parametro : parametros) {
            XopA = new Aritmetica();
            Resultado resultado = XopA.op_entreTipos(parametro);
            nombre += "$"+resultado.tipo;
        }
        return nombre;
    }
    
    
    public Resultado op_entreTipos(Nodo raiz)
    {
        Resultado r1 = null;
        Resultado r2 = null;
        switch(raiz.nombre)
        {   
            case "MAS":
            case "MENOS":
            case "POR":
            case "DIV":
            case "POT":
                r1 = this.op_entreTipos(raiz.hijos.get(0));
                r2 = this.op_entreTipos(raiz.hijos.get(1));
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
            case "==":
            case "!=":
            case ">":
            case ">=":
            case "<":
            case "<=":
            case "&&":
            case "||":
            case "??":
            case "!": 
             break;
            case "unario":
                r1 = this.op_entreTipos(raiz.hijos.get(0));
                switch(r1.tipo)
                {
                    case "entero":
                        return new Resultado("entero", "");
                    case "decimal":
                        return new Resultado("decimal", "");
                    default:
                        break;
                }
                break;
            case "simplificada":
                r1 = this.op_entreTipos(raiz.hijos.get(0));
                switch(r1.tipo)
                {
                    case "entero":
                        return new Resultado("entero", "");
                    case "decimal":
                        return new Resultado("decimal", "");
                    case "caracter":
                        return new Resultado("entero", "");
                    default:
                        break;
                }
                break;
            case "NULO_LITERAL":
                return new Resultado("nulo", "");
            case "DECIMAL_LITERAL":
                return new Resultado("decimal", "");
            case "NUM_LITERAL":
                return new Resultado("entero", "");    
            case "VERDADERO_LITERAL":
            case "FALSO_LITERAL":    
                return new Resultado("booleano", "");        
            case "CHAR_LITERAL":    
                return new Resultado("caracter", "");  
            default:
                break;
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
                                return new Resultado("entero","");
                            case "decimal":
                                return new Resultado("decimal","");
                            case "cadena":
                                //return Retorno("cadena","","Add\n",raiz);
                            default:
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
                                return new Resultado("decimal","");
                            case "cadena":
                                //return Retorno("cadena","","Add\n",raiz);
                            default:
                                break;
                        }
                    break;
                    case "caracter":
                        switch(r2.tipo)
                        {
                            case "entero":
                                return new Resultado("entero","");
                            case "decimal":
                                return new Resultado("decimal","");
                            case "cadena":
                                //return Retorno("cadena","","Add\n",raiz);
                            default:
                                break;
                        }
                    break;
                    case "booleano":
                        switch(r2.tipo)
                        {
                            case "entero":
                                return new Resultado("entero","");
                            case "decimal":
                                return new Resultado("decimal","");
                            case "booleano":
                                return new Resultado("booleano","");
                            default:
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
                                break;
                        }
                    break;
                    default:
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
                                return new Resultado("entero","");
                            case "decimal":
                                return new Resultado("decimal","");
                            default:
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
                                return new Resultado("decimal","");
                            default:
                                break;
                        }
                    break;
                    case "caracter":
                        switch(r2.tipo)
                        {
                            case "entero":
                                return new Resultado("entero","");
                            case "decimal":
                                return new Resultado("decimal","");
                            default:
                                break;
                        }
                    break;
                    case "booleano":
                        switch(r2.tipo)
                        {
                            case "entero":
                                return new Resultado("entero","");
                            case "decimal":
                                return new Resultado("decimal","");
                            default:
                                break;
                        }
                    break;
                    
                    default:
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
                                return new Resultado("entero","");
                            case "decimal":
                                return new Resultado("decimal","");
                            default:
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
                                return new Resultado("decimal","");
                            default:
                                break;
                        }
                    break;
                    case "caracter":
                        switch(r2.tipo)
                        {
                            case "entero":
                                return new Resultado("entero","");
                            case "decimal":
                                return new Resultado("decimal","");
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
                                return new Resultado("entero","");
                            case "decimal":
                                return new Resultado("decimal","");
                            default:
                                break;
                        }
                    break;
                    
                    default:
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
                                return new Resultado("decimal","");
                            default:
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
                                return new Resultado("decimal","");
                            default:
                                break;
                        }
                    break;
                    case "caracter":
                        switch(r2.tipo)
                        {
                            case "entero":
                            case "decimal":
                                return new Resultado("decimal","");
                            default:
                                break;
                        }
                    break;
                    case "booleano":
                        switch(r2.tipo)
                        {
                            case "entero":
                            case "decimal":
                                return new Resultado("decimal","");
                            default:
                                break;
                        }
                    break;
                    
                    default:
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
                                return new Resultado("entero","");
                            case "decimal":
                                return new Resultado("decimal","");
                            default:
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
                                return new Resultado("decimal","");
                            default:
                                break;
                        }
                    break;
                    case "caracter":
                        switch(r2.tipo)
                        {
                            case "entero":
                                return new Resultado("entero","");
                            case "decimal":
                                return new Resultado("decimal","");
                            default:
                                break;
                        }
                    break;
                    case "booleano":
                        switch(r2.tipo)
                        {
                            case "entero":
                                return new Resultado("entero","");
                            case "decimal":
                                return new Resultado("decimal","");
                            default:
                                break;
                        }
                    break;
                    default:
                        break;
                }
                break;      
            
        }
        return new Resultado("-1",null);
    }
}
