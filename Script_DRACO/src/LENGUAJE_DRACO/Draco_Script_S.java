/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LENGUAJE_DRACO;

import ANALIZADORES.LenguajeDracoScript.Analizador_LexSR;
import ANALIZADORES.LenguajeDracoScript.Analizador_SintSR;
import ESTRUCTURAS.Arbol;
import ESTRUCTURAS.Nodo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author fernando
 */
public class Draco_Script_S extends Compilador_S{
    
    public Draco_Script_S(File file, String archivoActual) {
        Nodo RAIX =null;
        archivos = new ArrayList();
        reporteSimbolos = new ArrayList();
        this.archivoActual = archivoActual;
        
        String nombre = file.getName();  
        String tipo = nombre.substring(nombre.length() - 3, nombre.length());
        if (tipo.equalsIgnoreCase("djs")) {
            String cadena = obtenerTextoArchivo(file);
            try {
                Analizador_SintSR sin = new Analizador_SintSR(new Analizador_LexSR(new BufferedReader(new StringReader(cadena))));
                sin.parse();
                Nodo raiz = sin.getRoot();
                if (raiz != null) {
                    RAIX = raiz;
                    raiz.valor = nombre;
                    Archivo archivo = new Archivo(nombre, raiz);
                    archivos.add(archivo);
                }
            } catch (Exception ex) {
                System.err.println(ex.toString());
            }
        }

        //------------------------------
        pilaNivelCiclo = new Stack<>();
        pilaClases = new Stack<>();
        pilaMetodos = new Stack<>();
        pilaTablas = new Stack<>();
        claseActual = getClasePrincipal();
        if (claseActual == null) {
            Inicio.reporteError.agregar("Semantico", 0, 0, "Metodo_S inicio no encontrado");
            return;
        }
        tabla = claseActual.tabla;
        global = claseActual.global;
        
        if (claseActual != null) {
            new Arbol().generacion_arbol(RAIX);
            metodoActual = getInicio(RAIX);
            pilaTablas = claseActual.pilaTablas;
            global = claseActual.global;
            tabla = claseActual.tabla;
            ejecutarSentencias(metodoActual.sentencias);
            System.out.println("");
        }
        
    }

    public void imprimirArbol(Nodo raiz)
    {
        System.out.println("Padre:"+raiz.nombre);
        for (Nodo hijo : raiz.hijos) {
            System.out.println("\thijo:"+hijo.nombre);
        }
        
        for (Nodo hijo : raiz.hijos) {
            imprimirArbol(hijo);
        }
    }

    private Clase getClasePrincipal() {
        ArrayList<Clase> clases;
        Archivo archivo = getArchivoPrincipal();
        if (archivo == null) {
            return null;
        }
        clases = archivo.clases;
        if(clases.size()>0)
        {
            return clases.get(0);
        }
        return null;
    }

    private Archivo getArchivoPrincipal() {
        if(archivos.size()>0)
        {
            return archivos.get(0);
        }else
        {
            return null;
        }
    }

    private Metodo_S getInicio(Nodo raiz) {
        Metodo_S metodo = new Metodo_S(raiz);
        claseActual.metodos.add(metodo);
        return metodo;
    }
    
    
    String obtenerTextoArchivo(File file) {
        String texto = "";
        try {
            BufferedReader bufer = new BufferedReader(
                    new InputStreamReader(new FileInputStream((String) file.getAbsolutePath())));
            String temp = "";
            while (temp != null) {
                temp = bufer.readLine();
                if (temp != null) {
                    texto = texto + temp + "\n";
                    temp = "";
                } else {
                }
            }
            bufer.close();
        } catch (Exception e) {
        }
        return texto;
    }
}
