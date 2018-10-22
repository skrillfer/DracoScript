/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LEXICOX;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author fernando
 */
public class Lexicox {

    public void ejecutar() {
        try {
            // Asignación del nombre de archivo por defecto que usará la aplicación
            String archivo = "prueba.txt";

            // Se trata de leer el archivo y analizarlo en la clase que se ha creado con JFlex
            BufferedReader buffer = new BufferedReader(new FileReader(archivo));
            LexicoSolo analizadorJFlex = new LexicoSolo(buffer);

            while (true) {

                // Obtener el token analizado y mostrar su información
                TokenPersonalizado token = analizadorJFlex.yylex();

                if (!analizadorJFlex.existenTokens()) {
                    break;
                }

                System.out.println(token.toString());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}

