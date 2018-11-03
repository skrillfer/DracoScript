/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LENGUAJE_DRACO;

import java.io.File;

/**
 *
 * @author fernando
 */
public class Inicio {
    public static ReporteError reporteError;//errores del lenguaje graphik

    public void analizar_archivo(String ruta)
    {
        reporteError = new ReporteError();

        File file = new File(ruta);
        Draco_Script_S draco = new Draco_Script_S(file, ruta);
        
    }
    
    public static void main(String[] args) {
        new Inicio().analizar_archivo("DRACO_ENTRADA.djs");
    }
}
