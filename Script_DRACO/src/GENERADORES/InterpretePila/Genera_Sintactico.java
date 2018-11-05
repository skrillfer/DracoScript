/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GENERADORES.InterpretePila;

import java.io.File;

/**
 *
 * @author fernando
 */
public class Genera_Sintactico {
     public static void main(String[] args) {
        String opciones[] = new String[5];
        opciones[0]="-destdir";
        opciones[1]="src"
                +File.separator+
                "INTERPRETE_PILA"+
                File.separator+
                "GRAMATICA";
        opciones[2]="-parser";
        opciones[3]="SintacticaDasm";
        opciones[4]="src"
                +File.separator+
                "INTERPRETE_PILA"
                +File.separator+
                "GRAMATICA"+
                File.separator+
                "Sintactico.cup";
        try {
            java_cup.Main.main(opciones);
            }
        catch (Exception e) {
            System.out.print(e.getMessage().toString());
            }
    }
}
