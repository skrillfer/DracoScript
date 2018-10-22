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
public class Genera_SoloLexico {
    public static void main(String[] args) {
        JFlex.Main.generate(new File(
                "src"+File.separator+"LEXICOX"+File.separator//+"LenguajeCJS"
                + File.separator + "lex.flex"));
    }
}
