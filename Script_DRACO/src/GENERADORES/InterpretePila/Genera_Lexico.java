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
public class Genera_Lexico {
     public static void main(String[] args) {
        JFlex.Main.generate(new File(
                "src"+File.separator+"INTERPRETE_PILA"+File.separator+"GRAMATICA"
                + File.separator + "Lexico.flex"));
    }
}
