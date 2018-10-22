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
public class Generador_lexicoD {
    public static void main(String[] args) {
        JFlex.Main.generate(new File(
                "src"+File.separator+"ANALIZADORES"+File.separator+"LenguajeD_PP"
                + File.separator + "DLexico.flex"));
    }
}
