/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interprete;

import ANALIZADORES.LenguajeD_PP.Analizador_LD;
import ANALIZADORES.LenguajeD_PP.Analizador_SD;
import ESTRUCTURAS.Nodo;
import ESTRUCTURAS.TablaSimbolo;
import ManejoErrores.Errores;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author fernando
 */
public class Interpretacion {
    public static String Archivo_Actual ="";
    
    public static  Errores Lista_Errores = new Errores();
    
    public void iniciar_interpretacion() throws FileNotFoundException, IOException
    {
        
        
        Analizador_LD lex = new Analizador_LD(new FileReader("prueba11.txt"));//se le pasa al analizador lexico lo que se escribio
        Analizador_SD parser = new Analizador_SD(lex);
        Nodo retorno=null;
        Archivo_Actual = "prueba11.txt";
        try {
            

            parser.parse();
            Nodo raiz = parser.getRoot();
            
            //Arbol_CCSS gen_arbol = new Arbol_CCSS();
            if(raiz!=null){
                System.out.println("RAIZ NO NULA");
                //gen_arbol.generacion_arbolCCSS(raiz);
            }
            retorno=raiz;
        } catch (Exception e) {
            System.out.println("error:"+e.getMessage());
        }
        
        
        if(retorno!=null)
        {
            TablaSimbolo tabla = new TablaSimbolo();
            tabla.generar_codigo(retorno);
            tabla.generar_reporte();
        }
        
    }
    
}
