/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ANALIZADORES.LenguajeDracoScript;

/**
 *
 * @author fernando
 */
public class token {
     
    public int columna;
    public int linea;
    public String cadena;
    
    public token(){
    }
    
    public token(int columna, int linea, String cadena ) {
        this.columna = columna+1;
        this.linea = linea+1;
        this.cadena = cadena;
    }
      
    
}