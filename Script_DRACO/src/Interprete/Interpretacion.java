/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interprete;

import ANALIZADORES.LenguajeD_PP.Analizador_LD;
import ANALIZADORES.LenguajeD_PP.Analizador_SD;
import ESTRUCTURAS.Blockes;
import ESTRUCTURAS.Nodo;
import ESTRUCTURAS.Resultado;
import ESTRUCTURAS.Simbolo;
import ESTRUCTURAS.TablaSimbolo;
import Interprete.Sentencias.Declaracion;
import Interprete.ALR.Aritmetica;
import Interprete.ALR.Logica;
import Interprete.ALR.Relacional;
import Interprete.Sentencias.Castear;
import ManejoErrores.Errores;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author fernando
 */
public class Interpretacion {
    public ArrayList<Nodo> metodos;
    public ArrayList<Nodo> estructuras;
    public ArrayList<Nodo> sentencias_globales;
    public static String Archivo_Actual ="";
    public static boolean constructor = false;
    public static Simbolo Metodo_Actual = null;
    public static Control_Intermedio control = new Control_Intermedio();
    
    public static Declaracion Xdeclaracion = new Declaracion();
    public static Aritmetica XopA;
    public static Relacional XopR;
    public static Logica XopL;
    
    public static Blockes Xblockes = new Blockes();
    public static Castear Xcastear = new Castear();
    
    public static Object      nulo  = 201213562;
    public static  Errores Lista_Errores = new Errores();
    public static  TablaSimbolo tabla ;
    public static  ArrayList<String> ambito =  new ArrayList<>();

    public void iniciar_interpretacion() throws FileNotFoundException, IOException
    {
        metodos = new ArrayList<>();
        estructuras = new ArrayList<>();
        sentencias_globales = new ArrayList<>();
        tabla = new TablaSimbolo();
        
        Analizador_LD lex = new Analizador_LD(new FileReader("prueba11.txt"));//se le pasa al analizador lexico lo que se escribio
        Analizador_SD parser = new Analizador_SD(lex);
        Nodo RAIZ=null;
        Archivo_Actual = "prueba11.txt";
        try {
            

            parser.parse();
            Nodo raiz = parser.getRoot();
            
            //Arbol_CCSS gen_arbol = new Arbol_CCSS();
            if(raiz!=null){
                System.out.println("RAIZ NO NULA");
                //gen_arbol.generacion_arbolCCSS(raiz);
            }
            RAIZ=raiz;
        } catch (Exception e) {
            System.out.println("error:"+e.getMessage());
        }
        
        
        if(RAIZ!=null)
        {
            tabla = new TablaSimbolo();
            tabla.generar_codigo(RAIZ);
            tabla.generar_reporte();
            
            for (Nodo nodo : RAIZ.hijos) {
                if(nodo.nombre.equals("metodo")  || nodo.nombre.equals("metodoArray"))
                {
                    metodos.add(nodo);
                }else if(nodo.nombre.equals("declaracion_estructura")  )
                {
                    estructuras.add(nodo);
                }else
                {
                    sentencias_globales.add(nodo);
                }
            }
        }
        this.codigo_Intemerdio_globales();//se genera el codigo intermedio para las globales
        constructor=true;
        //crearconstructores;
        constructor=false;
        ejecutar_metodos();
        System.out.println("*****************************************");
        //System.out.println(control.codigoDASM);
        Xblockes.imprimirBlockes();
        System.out.println("*****************************************");
        
        
    }
    
    
    public void codigo_Intemerdio_globales()
    {
        /*for (Nodo sent_globales : sentencias_globales) {
            
        }*/
    }
    
    public void ejecutar_metodos()
    {
        boolean existe_metodo_principal = false;
        for (Nodo metodo : metodos) {
            ambito =  new ArrayList<>();
            String id_metodo = tabla.generar_Id(metodo);
            Metodo_Actual = tabla.obtener_Simbolo(id_metodo, ambito);
            
            String etqRetorno = control.generar_etiqueta();
            
            if(id_metodo.toLowerCase().equals("principal"))
            {
                String codigo_tmp= "";
                /*control.codigoDASM*/codigo_tmp += "function principal\n";
                /*control.codigoDASM*/codigo_tmp += "$$_globales();\n";
                
                Xblockes.agregar(codigo_tmp, metodo);
                
                ambito.add("principal");
                //ejecuto las sentencias del metodo
                ejecutarSentencias(metodo.hijos.get(3));
                
                //control.codigoDASM += etqRetorno+"\n";
                codigo_tmp = "End\n";
                Xblockes.agregar_AlUltimoBloque(codigo_tmp);
                
                //control.codigoDASM += "End\n";
                existe_metodo_principal = true;
                /*
                codigo3D+="void Principal(){\n";
					codigo3D+="$$_globales();\n";
					ambito.push("Principal");
					this.ejecutar(metodo.hijos[3]);

					codigo3D+=etiquetaReturn+":  ; \n";
					codigo3D+="}\n\n";
					existePrincipal=true;
                */
                ambito.remove(ambito.size()-1);
            }
            
        }  
        if(!existe_metodo_principal)
        {
            Interprete.Interpretacion.Lista_Errores.add(0, 0, "Semantico", "No se ha encontrado un metodo principal","");
        }
    }
    
    public void ejecutarSentencias(Nodo RAIZ)
    {   
        for (Nodo sentencia : RAIZ.hijos) {
            switch(sentencia.nombre)
            {
                case "primitivaDA":
                    Xdeclaracion.declaracionPrimitivaDA(sentencia);
                    break;
            }
        }
    }
    
    public boolean es_primitivo(String tipo) {
        switch (tipo) {
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
    
    public Resultado Val_Rel_Logic(Resultado r1)
    {
        String codigo_tmp = "";
        if(!r1.ETF.equals("") && !r1.ETV.equals(""))
        {
            String ETQ_SALIDA = control.generar_etiqueta();
            codigo_tmp += "\n\n" + r1.ETV + " //ETV\n";
            if(r1.valor.equals("AND"))
            {
                codigo_tmp+="and\n";
                codigo_tmp+="br "+ETQ_SALIDA+" //ETQ_Salida\n";

            }
            if(r1.valor.equals("OR"))
            {
                codigo_tmp+="or\n";
                codigo_tmp+="br "+ETQ_SALIDA+" //ETQ_Salida\n";
            }
            //codigo_tmp += "1\n";
            //codigo_tmp += "br "+ETQsalida+ " //Salto a la etiqueta "+ETQsalida +"\n";
            codigo_tmp += "\n\n" + r1.ETF + " //ETF\n";
            if(r1.valor.equals("OR"))
            {
                codigo_tmp+="or\n";
            }
            if(r1.valor.equals("AND"))
            {
                codigo_tmp+="and\n";
                //codigo_tmp+="br "+ETQ_SALIDA+" //ETQ_Salida\n";

            }
           //codigo_tmp += "0\n";
            //codigo_tmp += ETQsalida+"\n";
            codigo_tmp += "\n\n"+ETQ_SALIDA+"\n";
            Xblockes.agregar_AlUltimoBloque(codigo_tmp);
            return new Resultado("booleano", "");
        }
        return r1;
    }
}
