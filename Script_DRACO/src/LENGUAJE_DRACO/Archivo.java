/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LENGUAJE_DRACO;

import ESTRUCTURAS.Nodo;
import java.util.ArrayList;

/**
 *
 * @author fernando
 */
public class Archivo {
    public String nombre;
    Nodo raiz;
    public ArrayList<Clase> clases;

    public Archivo(String nombre, Nodo raiz) {
        clases = new ArrayList();
        this.nombre = nombre;
        this.raiz = raiz;
        
        Clase clase = new Clase(raiz);
        clase.archivo = nombre;
        clases.add(clase);
    }
    
    
    
}
