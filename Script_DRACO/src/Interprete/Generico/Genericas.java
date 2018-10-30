/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interprete.Generico;

/**
 *
 * @author fernando
 */
public class Genericas extends Interprete.Interpretacion{
    
    public String OUT_STR()
    {
        String etV = control.generar_etiqueta();
        String etF = control.generar_etiqueta();
        
        String etS = control.generar_etiqueta();
        String etC = control.generar_etiqueta();
        String codigo_tmp = "\n\nfunction $$_outStr\n";
        
        codigo_tmp += etC + "\n";
            codigo_tmp += "get_local 0 //obtengo el puntero de stack\n";
            codigo_tmp += "1\n";
            codigo_tmp += "add\n";

            codigo_tmp += "get_local $calc\n";

            codigo_tmp += "get_global $calc\n";

            codigo_tmp += "0\n";


            codigo_tmp += "diff\n";

            codigo_tmp += "not\n";

            codigo_tmp += "eqz\n";


            codigo_tmp += "br_if "+etF+"\n";
            codigo_tmp += "br "+etV+"\n";

        codigo_tmp += etF+"\n";
        codigo_tmp += "br "+etS+"\n";
        
        codigo_tmp += etV+"\n";
            codigo_tmp += "%c\n";

            codigo_tmp += "get_local 0\n";
            codigo_tmp += "1\n";
            codigo_tmp += "add\n";

            codigo_tmp += "get_local $calc\n";
            codigo_tmp += "get_global $calc\n";

            codigo_tmp += "print\n";

            codigo_tmp += "get_local 0\n";
            codigo_tmp += "1\n";
            codigo_tmp += "add\n";
            
            codigo_tmp += "get_local 0\n";
            codigo_tmp += "1\n";
            codigo_tmp += "add\n";
            codigo_tmp += "get_local $calc\n";
            
            codigo_tmp += "1\n";
            codigo_tmp += "add\n";

            codigo_tmp += "set_local $calc\n";
            
            codigo_tmp += "br " + etC +"\n";
        
        codigo_tmp += etS+"\n";
        
        codigo_tmp += "End\n";
        
        return codigo_tmp;
    }
}
