/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ESTRUCTURAS;

/**
 *
 * @author fernando
 */
public class Blocke{
    public int linea = 0;
    public int columna = 0;
    public String codigo_asm = "";

    public Blocke() {
    }
    
    public Blocke(int linea, int columna, String codigo_asm)
    {
        this.linea = linea;
        this.columna = columna;
        this.codigo_asm =  codigo_asm;
    }
    
}
