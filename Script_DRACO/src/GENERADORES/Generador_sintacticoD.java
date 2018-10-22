/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GENERADORES;

import java.io.File;

/**
 *
 * @author fernando
 */
public class Generador_sintacticoD {
    public static void main(String[] args) {
        String opciones[] = new String[5];
        opciones[0]="-destdir";
        opciones[1]="src"
                +File.separator+
                "ANALIZADORES"+
                File.separator+
                "LenguajeD_PP";
        opciones[2]="-parser";
        opciones[3]="Analizador_SD";
        opciones[4]="src"
                +File.separator+
                "ANALIZADORES"
                +File.separator+
                "LenguajeD_PP"+
                File.separator+
                "DSintactico.cup";
        try {
            java_cup.Main.main(opciones);
            }
        catch (Exception e) {
            System.out.print(e.getMessage().toString());
            }
    }
}
