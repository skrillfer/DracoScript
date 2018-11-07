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
public class Genericas extends Interprete.Interpretacion {

    public String OUT_STR() {
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

        codigo_tmp += "eqz\n";

        codigo_tmp += "not\n";

        codigo_tmp += "br_if " + etF + "\n";
        codigo_tmp += "br " + etV + "\n";

        codigo_tmp += etF + "\n";
        codigo_tmp += "br " + etS + "\n";

        codigo_tmp += etV + "\n";
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

        codigo_tmp += "br " + etC + "\n";

        codigo_tmp += etS + "\n";

        codigo_tmp += "End\n";

        return codigo_tmp;
    }

    public String menor() {
        String eti18 = control.generar_etiqueta();
        String eti20 = control.generar_etiqueta();
        String eti19 = control.generar_etiqueta();
        String eti28 = control.generar_etiqueta();
        String eti30 = control.generar_etiqueta();
        String eti39 = control.generar_etiqueta();
        String etiV = control.generar_etiqueta();
        String etiF = control.generar_etiqueta();
        String etiS = control.generar_etiqueta();
        String codigo_tmp = "\n\nfunction $$_menor\n";
        codigo_tmp += "0\n";
        codigo_tmp += "get_local 0\n";
        codigo_tmp += "1\n";
        codigo_tmp += "add\n";
        codigo_tmp += "get_local $calc\n";
        codigo_tmp += eti18 + "\n";
        codigo_tmp += "get_global $calc\n";
        codigo_tmp += "0\n";
        codigo_tmp += "diff\n";
        codigo_tmp += "eqz\n";
        codigo_tmp += "not\n";
        codigo_tmp += "br_if " + eti20 + "\n";
        codigo_tmp += "br " + eti19 + "\n\n";
        codigo_tmp += eti20 + "\n";
        codigo_tmp += "0\n";
        codigo_tmp += "get_local 0\n";
        codigo_tmp += "2\n";
        codigo_tmp += "add\n";
        codigo_tmp += "get_local $calc\n";
        codigo_tmp += eti28 + "\n";
        codigo_tmp += "get_global $calc\n";
        codigo_tmp += "0\n";
        codigo_tmp += "diff\n";
        codigo_tmp += "eqz\n";
        codigo_tmp += "not\n";
        codigo_tmp += "br_if " + eti30 + "\n";
        codigo_tmp += "br " + eti39 + "\n";
        codigo_tmp += eti30 + "\n";
        codigo_tmp += "lt\n";
        codigo_tmp += "br_if " + etiF + "\n";
        codigo_tmp += "br " + etiV + "\n";
        codigo_tmp += etiF + "\n";
        codigo_tmp += "get_local 0\n";
        codigo_tmp += "0\n";
        codigo_tmp += "set_local $calc\n";
        codigo_tmp += "br " + etiS + "\n";
        codigo_tmp += etiV + "\n";
        codigo_tmp += "get_local 0\n";
        codigo_tmp += "1\n";
        codigo_tmp += "set_local $calc\n";
        codigo_tmp += "br " + etiS + "\n";
        codigo_tmp += eti39 + "\n";
        codigo_tmp += "get_local 0\n";
        codigo_tmp += "2\n";
        codigo_tmp += "add\n";
        codigo_tmp += "get_local $calc\n";
        codigo_tmp += "get_global $calc\n";
        codigo_tmp += "add\n";

        codigo_tmp += "get_local 0\n";
        codigo_tmp += "2\n";
        codigo_tmp += "add\n";

        codigo_tmp += "get_local 0\n";
        codigo_tmp += "2\n";
        codigo_tmp += "add\n";
        codigo_tmp += "get_local $calc\n";
        codigo_tmp += "1\n";
        codigo_tmp += "add\n";
        codigo_tmp += "set_local $calc\n";

        codigo_tmp += "get_local 0\n";
        codigo_tmp += "2\n";
        codigo_tmp += "add\n";
        codigo_tmp += "get_local $calc\n";
        codigo_tmp += "br " + eti28 + "\n";

        codigo_tmp += eti19 + "\n";
        codigo_tmp += "get_local 0\n";
        codigo_tmp += "1\n";
        codigo_tmp += "add\n";
        codigo_tmp += "get_local $calc\n";
        codigo_tmp += "get_global $calc\n";
        codigo_tmp += "add\n";

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

        codigo_tmp += "get_local 0\n";
        codigo_tmp += "1\n";
        codigo_tmp += "add\n";
        codigo_tmp += "get_local $calc\n";
        codigo_tmp += "br " + eti18 + "\n";
        codigo_tmp += etiS + "\n";

        codigo_tmp += "End\n";

        return codigo_tmp;
    }

    public String menorIgual() {
        String eti18 = control.generar_etiqueta();
        String eti20 = control.generar_etiqueta();
        String eti19 = control.generar_etiqueta();
        String eti28 = control.generar_etiqueta();
        String eti30 = control.generar_etiqueta();
        String eti39 = control.generar_etiqueta();
        String etiV = control.generar_etiqueta();
        String etiF = control.generar_etiqueta();
        String etiS = control.generar_etiqueta();
        String codigo_tmp = "\n\nfunction $$_menorIgual\n";
        codigo_tmp += "0\n";
        codigo_tmp += "get_local 0\n";
        codigo_tmp += "1\n";
        codigo_tmp += "add\n";
        codigo_tmp += "get_local $calc\n";
        codigo_tmp += eti18 + "\n";
        codigo_tmp += "get_global $calc\n";
        codigo_tmp += "0\n";
        codigo_tmp += "diff\n";
        codigo_tmp += "eqz\n";
        codigo_tmp += "not\n";
        codigo_tmp += "br_if " + eti20 + "\n";
        codigo_tmp += "br " + eti19 + "\n\n";
        codigo_tmp += eti20 + "\n";
        codigo_tmp += "0\n";
        codigo_tmp += "get_local 0\n";
        codigo_tmp += "2\n";
        codigo_tmp += "add\n";
        codigo_tmp += "get_local $calc\n";
        codigo_tmp += eti28 + "\n";
        codigo_tmp += "get_global $calc\n";
        codigo_tmp += "0\n";
        codigo_tmp += "diff\n";
        codigo_tmp += "eqz\n";
        codigo_tmp += "not\n";
        codigo_tmp += "br_if " + eti30 + "\n";
        codigo_tmp += "br " + eti39 + "\n";
        codigo_tmp += eti30 + "\n";
        codigo_tmp += "lte\n";
        codigo_tmp += "br_if " + etiF + "\n";
        codigo_tmp += "br " + etiV + "\n";
        codigo_tmp += etiF + "\n";
        codigo_tmp += "get_local 0\n";
        codigo_tmp += "0\n";
        codigo_tmp += "set_local $calc\n";
        codigo_tmp += "br " + etiS + "\n";
        codigo_tmp += etiV + "\n";
        codigo_tmp += "get_local 0\n";
        codigo_tmp += "1\n";
        codigo_tmp += "set_local $calc\n";
        codigo_tmp += "br " + etiS + "\n";
        codigo_tmp += eti39 + "\n";
        codigo_tmp += "get_local 0\n";
        codigo_tmp += "2\n";
        codigo_tmp += "add\n";
        codigo_tmp += "get_local $calc\n";
        codigo_tmp += "get_global $calc\n";
        codigo_tmp += "add\n";

        codigo_tmp += "get_local 0\n";
        codigo_tmp += "2\n";
        codigo_tmp += "add\n";

        codigo_tmp += "get_local 0\n";
        codigo_tmp += "2\n";
        codigo_tmp += "add\n";
        codigo_tmp += "get_local $calc\n";
        codigo_tmp += "1\n";
        codigo_tmp += "add\n";
        codigo_tmp += "set_local $calc\n";

        codigo_tmp += "get_local 0\n";
        codigo_tmp += "2\n";
        codigo_tmp += "add\n";
        codigo_tmp += "get_local $calc\n";
        codigo_tmp += "br " + eti28 + "\n";

        codigo_tmp += eti19 + "\n";
        codigo_tmp += "get_local 0\n";
        codigo_tmp += "1\n";
        codigo_tmp += "add\n";
        codigo_tmp += "get_local $calc\n";
        codigo_tmp += "get_global $calc\n";
        codigo_tmp += "add\n";

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

        codigo_tmp += "get_local 0\n";
        codigo_tmp += "1\n";
        codigo_tmp += "add\n";
        codigo_tmp += "get_local $calc\n";
        codigo_tmp += "br " + eti18 + "\n";
        codigo_tmp += etiS + "\n";

        codigo_tmp += "End\n";

        return codigo_tmp;
    }

    public String mayor() {
        String eti18 = control.generar_etiqueta();
        String eti20 = control.generar_etiqueta();
        String eti19 = control.generar_etiqueta();
        String eti28 = control.generar_etiqueta();
        String eti30 = control.generar_etiqueta();
        String eti39 = control.generar_etiqueta();
        String etiV = control.generar_etiqueta();
        String etiF = control.generar_etiqueta();
        String etiS = control.generar_etiqueta();
        String codigo_tmp = "\n\nfunction $$_mayor\n";
        codigo_tmp += "0\n";
        codigo_tmp += "get_local 0\n";
        codigo_tmp += "1\n";
        codigo_tmp += "add\n";
        codigo_tmp += "get_local $calc\n";
        codigo_tmp += eti18 + "\n";
        codigo_tmp += "get_global $calc\n";
        codigo_tmp += "0\n";
        codigo_tmp += "diff\n";
        codigo_tmp += "eqz\n";
        codigo_tmp += "not\n";
        codigo_tmp += "br_if " + eti20 + "\n";
        codigo_tmp += "br " + eti19 + "\n\n";
        codigo_tmp += eti20 + "\n";
        codigo_tmp += "0\n";
        codigo_tmp += "get_local 0\n";
        codigo_tmp += "2\n";
        codigo_tmp += "add\n";
        codigo_tmp += "get_local $calc\n";
        codigo_tmp += eti28 + "\n";
        codigo_tmp += "get_global $calc\n";
        codigo_tmp += "0\n";
        codigo_tmp += "diff\n";
        codigo_tmp += "eqz\n";
        codigo_tmp += "not\n";
        codigo_tmp += "br_if " + eti30 + "\n";
        codigo_tmp += "br " + eti39 + "\n";
        codigo_tmp += eti30 + "\n";
        codigo_tmp += "gt\n";
        codigo_tmp += "br_if " + etiF + "\n";
        codigo_tmp += "br " + etiV + "\n";
        codigo_tmp += etiF + "\n";
        codigo_tmp += "get_local 0\n";
        codigo_tmp += "0\n";
        codigo_tmp += "set_local $calc\n";
        codigo_tmp += "br " + etiS + "\n";
        codigo_tmp += etiV + "\n";
        codigo_tmp += "get_local 0\n";
        codigo_tmp += "1\n";
        codigo_tmp += "set_local $calc\n";
        codigo_tmp += "br " + etiS + "\n";
        codigo_tmp += eti39 + "\n";
        codigo_tmp += "get_local 0\n";
        codigo_tmp += "2\n";
        codigo_tmp += "add\n";
        codigo_tmp += "get_local $calc\n";
        codigo_tmp += "get_global $calc\n";
        codigo_tmp += "add\n";

        codigo_tmp += "get_local 0\n";
        codigo_tmp += "2\n";
        codigo_tmp += "add\n";

        codigo_tmp += "get_local 0\n";
        codigo_tmp += "2\n";
        codigo_tmp += "add\n";
        codigo_tmp += "get_local $calc\n";
        codigo_tmp += "1\n";
        codigo_tmp += "add\n";
        codigo_tmp += "set_local $calc\n";

        codigo_tmp += "get_local 0\n";
        codigo_tmp += "2\n";
        codigo_tmp += "add\n";
        codigo_tmp += "get_local $calc\n";
        codigo_tmp += "br " + eti28 + "\n";

        codigo_tmp += eti19 + "\n";
        codigo_tmp += "get_local 0\n";
        codigo_tmp += "1\n";
        codigo_tmp += "add\n";
        codigo_tmp += "get_local $calc\n";
        codigo_tmp += "get_global $calc\n";
        codigo_tmp += "add\n";

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

        codigo_tmp += "get_local 0\n";
        codigo_tmp += "1\n";
        codigo_tmp += "add\n";
        codigo_tmp += "get_local $calc\n";
        codigo_tmp += "br " + eti18 + "\n";
        codigo_tmp += etiS + "\n";

        codigo_tmp += "End\n";

        return codigo_tmp;
    }

    public String mayorIgual() {
        String eti18 = control.generar_etiqueta();
        String eti20 = control.generar_etiqueta();
        String eti19 = control.generar_etiqueta();
        String eti28 = control.generar_etiqueta();
        String eti30 = control.generar_etiqueta();
        String eti39 = control.generar_etiqueta();
        String etiV = control.generar_etiqueta();
        String etiF = control.generar_etiqueta();
        String etiS = control.generar_etiqueta();
        String codigo_tmp = "\n\nfunction $$_mayorIgual\n";
        codigo_tmp += "0\n";
        codigo_tmp += "get_local 0\n";
        codigo_tmp += "1\n";
        codigo_tmp += "add\n";
        codigo_tmp += "get_local $calc\n";
        codigo_tmp += eti18 + "\n";
        codigo_tmp += "get_global $calc\n";
        codigo_tmp += "0\n";
        codigo_tmp += "diff\n";
        codigo_tmp += "eqz\n";
        codigo_tmp += "not\n";
        codigo_tmp += "br_if " + eti20 + "\n";
        codigo_tmp += "br " + eti19 + "\n\n";
        codigo_tmp += eti20 + "\n";
        codigo_tmp += "0\n";
        codigo_tmp += "get_local 0\n";
        codigo_tmp += "2\n";
        codigo_tmp += "add\n";
        codigo_tmp += "get_local $calc\n";
        codigo_tmp += eti28 + "\n";
        codigo_tmp += "get_global $calc\n";
        codigo_tmp += "0\n";
        codigo_tmp += "diff\n";
        codigo_tmp += "eqz\n";
        codigo_tmp += "not\n";
        codigo_tmp += "br_if " + eti30 + "\n";
        codigo_tmp += "br " + eti39 + "\n";
        codigo_tmp += eti30 + "\n";
        codigo_tmp += "gte\n";
        codigo_tmp += "br_if " + etiF + "\n";
        codigo_tmp += "br " + etiV + "\n";
        codigo_tmp += etiF + "\n";
        codigo_tmp += "get_local 0\n";
        codigo_tmp += "0\n";
        codigo_tmp += "set_local $calc\n";
        codigo_tmp += "br " + etiS + "\n";
        codigo_tmp += etiV + "\n";
        codigo_tmp += "get_local 0\n";
        codigo_tmp += "1\n";
        codigo_tmp += "set_local $calc\n";
        codigo_tmp += "br " + etiS + "\n";
        codigo_tmp += eti39 + "\n";
        codigo_tmp += "get_local 0\n";
        codigo_tmp += "2\n";
        codigo_tmp += "add\n";
        codigo_tmp += "get_local $calc\n";
        codigo_tmp += "get_global $calc\n";
        codigo_tmp += "add\n";

        codigo_tmp += "get_local 0\n";
        codigo_tmp += "2\n";
        codigo_tmp += "add\n";

        codigo_tmp += "get_local 0\n";
        codigo_tmp += "2\n";
        codigo_tmp += "add\n";
        codigo_tmp += "get_local $calc\n";
        codigo_tmp += "1\n";
        codigo_tmp += "add\n";
        codigo_tmp += "set_local $calc\n";

        codigo_tmp += "get_local 0\n";
        codigo_tmp += "2\n";
        codigo_tmp += "add\n";
        codigo_tmp += "get_local $calc\n";
        codigo_tmp += "br " + eti28 + "\n";

        codigo_tmp += eti19 + "\n";
        codigo_tmp += "get_local 0\n";
        codigo_tmp += "1\n";
        codigo_tmp += "add\n";
        codigo_tmp += "get_local $calc\n";
        codigo_tmp += "get_global $calc\n";
        codigo_tmp += "add\n";

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

        codigo_tmp += "get_local 0\n";
        codigo_tmp += "1\n";
        codigo_tmp += "add\n";
        codigo_tmp += "get_local $calc\n";
        codigo_tmp += "br " + eti18 + "\n";
        codigo_tmp += etiS + "\n";

        codigo_tmp += "End\n";

        return codigo_tmp;
    }

    public String concat() {
        String eti55 = control.generar_etiqueta();
        String eti66 = control.generar_etiqueta();
        String eti67 = control.generar_etiqueta();
        String eti68 = control.generar_etiqueta();

        String eti97 = control.generar_etiqueta();
        String eti98 = control.generar_etiqueta();

        String etiS = control.generar_etiqueta();

        String codigo_tmp = "\n\nfunction $$_concat\n";

        codigo_tmp += "get_local 0\n";
        codigo_tmp += "get_global 0\n";
        codigo_tmp += "set_local $calc\n";

        codigo_tmp += "get_local 0\n";
        codigo_tmp += "1\n";
        codigo_tmp += "add\n";
        codigo_tmp += "get_local $calc\n";
        codigo_tmp += eti66 + "\n";
        codigo_tmp += "get_global $calc\n";
        codigo_tmp += "0\n";
        codigo_tmp += "diff\n";
        codigo_tmp += "eqz\n";
        codigo_tmp += "not\n";
        codigo_tmp += "br_if " + eti68 + "\n";
        codigo_tmp += "br " + eti67 + "\n";
        codigo_tmp += eti68 + "\n";
        codigo_tmp += "get_local 0\n";
        codigo_tmp += "2\n";
        codigo_tmp += "add\n";
        codigo_tmp += "get_local $calc\n";

        codigo_tmp += eti55 + "\n";
        codigo_tmp += "get_global $calc\n";
        codigo_tmp += "0\n";
        codigo_tmp += "diff\n";
        codigo_tmp += "eqz\n";
        codigo_tmp += "not\n";
        codigo_tmp += "br_if " + eti98 + "\n";
        codigo_tmp += "br " + eti97 + "\n";
        codigo_tmp += eti98 + "\n";
        
        codigo_tmp += "get_global 0\n" +
"                0\n" +
"                set_global $calc\n" +
"                \n" +
"                get_global 0\n" +
"                1\n" +
"                add\n" +
"                set_global 0\n" ;
        codigo_tmp += "br " + etiS + "\n";
        codigo_tmp += eti97 + "\n";
        codigo_tmp += "get_global 0\n";

        codigo_tmp += "get_local 0\n";
        codigo_tmp += "2\n";
        codigo_tmp += "add\n";
        codigo_tmp += "get_local $calc\n";
        codigo_tmp += "get_global $calc\n";

        codigo_tmp += "set_global $calc\n";

        codigo_tmp += "get_global 0\n";
        codigo_tmp += "1\n";
        codigo_tmp += "add\n";
        codigo_tmp += "set_global 0\n";

        codigo_tmp += "get_local 0\n";
        codigo_tmp += "2\n";
        codigo_tmp += "add\n";
        codigo_tmp += "get_local 0\n";
        codigo_tmp += "2\n";
        codigo_tmp += "add\n";
        codigo_tmp += "get_local $calc\n";
        codigo_tmp += "1\n";
        codigo_tmp += "add\n";
        codigo_tmp += "set_local $calc\n";

        codigo_tmp += "get_local 0\n";
        codigo_tmp += "2\n";
        codigo_tmp += "add\n";
        codigo_tmp += "get_local $calc\n";
        codigo_tmp += "br " + eti55 + "\n";

        codigo_tmp += eti67 + "\n";
        codigo_tmp += "get_global 0\n";

        codigo_tmp += "get_local 0\n";
        codigo_tmp += "1\n";
        codigo_tmp += "add\n";
        codigo_tmp += "get_local $calc\n";
        codigo_tmp += "get_global $calc\n";

        codigo_tmp += "set_global $calc\n";

        codigo_tmp += "get_global 0\n";
        codigo_tmp += "1\n";
        codigo_tmp += "add\n";
        codigo_tmp += "set_global 0\n";

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

        codigo_tmp += "get_local 0\n";
        codigo_tmp += "1\n";
        codigo_tmp += "add\n";
        codigo_tmp += "get_local $calc\n";
        codigo_tmp += "br " + eti66 + "\n";
        codigo_tmp += etiS + "\n";
        codigo_tmp += "End\n";

        return codigo_tmp;
    }

    public String Concatenacion()
    {
        String eti55 = control.generar_etiqueta();
        
        String eti66 = control.generar_etiqueta();
        String eti67 = control.generar_etiqueta();
        String eti68 = control.generar_etiqueta();
        
        String eti97 = control.generar_etiqueta();
        String eti98 = control.generar_etiqueta();
        
        String etiS = control.generar_etiqueta();
        String cad1 = "";
        cad1 += "get_local  0\n" ;
        cad1 += "get_global 0\n" ;
        cad1 += "set_local  $calc";
        
        cad1 += "get_local 0\n" ;
        cad1 += "1\n" ;
        cad1 += "add\n" ;
        cad1 += "get_local $calc";
        
        cad1 += eti66+"\n" ;
        cad1 += "get_global $calc\n" ;
        cad1 += "0\n" ;
        cad1 += "diff\n" ;
        cad1 += "eqz\n" ;
        cad1 += "not\n" ;
        cad1 += "br_if "+eti68+"\n" ;
        cad1 += "br "+eti67+"\n";
        
        cad1 += eti68+"\n";
        
        cad1 += "get_local 0\n" ;
        cad1 += "2\n" ;
        cad1 += "add\n" ;
        cad1 += "get_local $calc\n" ;
        
        cad1 += eti55+"\n";
        cad1 += "get_global $calc\n" ;
        cad1 += "0\n" ;
        cad1 += "diff\n" ;
        cad1 += "eqz\n" ;
        cad1 += "not\n" ;
        cad1 += "br_if "+eti98+"\n" ;
        cad1 += "br "+eti97+"L97\n" ;
        cad1 += eti98+"\n" ;
        cad1 += "br "+etiS+"\n" ;
        
        cad1 += eti97+"\n" ;
        cad1 += "get_global 0\n" ;
        cad1 += "get_local 0\n" ;
        cad1 += "2\n" ;
        cad1 += "add\n" ;
        cad1 += "get_local $calc\n" ;
        cad1 += "get_global $calc\n" ;
        
        cad1 += "set_global $calc\n" ;
        
        cad1 += "get_global 0\n" ;
        cad1 += "1\n" ;
        cad1 += "add\n" ;
        cad1 += "set_global 0\n" ;
        cad1 += "get_local 0\n" ;
        cad1 += "2\n" ;
        cad1 += "add\n" ;
        cad1 += "get_local 0\n" ;
        cad1 += "2\n" ;
        cad1 += "add\n" ;
        cad1 += "get_local $calc\n" ;
        cad1 += "1\n" ;
        cad1 += "add\n" ;
        cad1 += "set_local $calc\n" ;
        cad1 += "get_local 0\n" ;
        cad1 += "2\n" ;
        cad1 += "add\n" ;
        cad1 += "get_local $calc\n" ;
        cad1 += "br "+eti55+"\n" ;
        cad1 += eti67+"\n" ;
        cad1 += "get_global 0\n" ;
        
        cad1 += "get_local 0\n" ;
        cad1 += "1\n" ;
        cad1 += "add\n" ;
        cad1 += "get_local $calc\n" ;
        cad1 += "get_global $calc\n" ;
        cad1 += "set_global $calc\n" ;
        
        cad1 += "get_global 0\n" ;
        cad1 += "1\n" ;
        cad1 += "add\n" ;
        cad1 += "set_global 0\n" ;
        cad1 += "get_local 0\n" ;
        cad1 += "1\n" ;
        cad1 += "add\n" ;
        cad1 += "get_local 0\n" ;
        cad1 += "1\n" ;
        cad1 += "add\n" ;
        cad1 += "get_local $calc\n" ;
        cad1 += "1\n" ;
        cad1 += "add\n" ;
        cad1 += "set_local $calc\n" ;
        cad1 += "get_local 0\n" ;
        cad1 += "1\n" ;
        cad1 += "add\n" ;
        
        cad1 += "br "+eti66+"\n" ;
        cad1 += ""+etiS+"\n" ;
        cad1 += "End";
        
        return cad1;
    }
    
    public String CasteoNumero() {
        String cad = "function $$_getStr\n"
                +"get_local 0\n" 
                +"get_global 0\n" 
                +"set_local $calc\n"
                + "//-----------------seteo el numero a convertir sin modificar\n"
                + "\n"
                + "get_local 0\n"
                + "5\n"
                + "add\n"
                + "\n"
                + "//Obtengo el numero a convertir\n"
                + "get_local 0\n"
                + "1\n"
                + "add\n"
                + "get_local $calc\n"
                + "//Obtengo el numero a convertir\n"
                + "\n"
                + "set_local $calc\n"
                + "\n"
                + "//-----------------seteo el numero a convertir sin modificar\n"
                + "\n"
                + "\n"
                + "//Obtengo el numero a convertir\n"
                + "get_local 0\n"
                + "1\n"
                + "add\n"
                + "get_local $calc\n"
                + "//Obtengo el numero a convertir\n"
                + "0\n"
                + "lt\n"
                + "br_if $L77\n"
                + "br $L76\n"
                + "\n"
                + "    $L77\n"
                + "    //--------------\n"
                + "        //direccion de t78\n"
                + "        get_local 0\n"
                + "        8\n"
                + "        add\n"
                + "        //direccion de t78\n"
                + "\n"
                + "        //Obtengo el numero a convertir\n"
                + "        get_local 0\n"
                + "        1\n"
                + "        add\n"
                + "        get_local $calc\n"
                + "        //>>Obtengo el numero a convertir\n"
                + "\n"
                + "        set_local $calc\n"
                + "        br $L78\n"
                + "    //--------------\n"
                + "    $L76\n"
                + "\n"
                + "        //direccion de t78\n"
                + "        get_local 0\n"
                + "        8\n"
                + "        add\n"
                + "        //direccion de t78\n"
                + "\n"
                + "        //Obtengo el numero a convertir\n"
                + "        get_local 0\n"
                + "        1\n"
                + "        add\n"
                + "        get_local $calc\n"
                + "        //>>Obtengo el numero a convertir\n"
                + "\n"
                + "        set_local $calc\n"
                + "\n"
                + "\n"
                + "        //direccion del numero a convertir\n"
                + "        get_local 0\n"
                + "        1\n"
                + "        add\n"
                + "        //>>direccion del numero a convertir\n"
                + "\n"
                + "        //Obtengo el numero a convertir\n"
                + "        get_local 0\n"
                + "        1\n"
                + "        add\n"
                + "        get_local $calc\n"
                + "        //>>Obtengo el numero a convertir\n"
                + "        -1\n"
                + "        MULT\n"
                + "        set_local $calc\n"
                + "    $L78\n"
                + "        //Obtengo el numero a convertir\n"
                + "        get_local 0\n"
                + "        1\n"
                + "        add\n"
                + "        get_local $calc\n"
                + "        //>>Obtengo el numero a convertir\n"
                + "        0\n"
                + "        diff\n"
                + "        eqz\n"
                + "        br_if $L79\n"
                + "        br $L72\n"
                + "        $L79\n"
                + "            //--------------------\n"
                + "            //Seteando parametro\n"
                + "            get_local 0\n"
                + "            9\n"
                + "            add\n"
                + "            1\n"
                + "            add\n"
                + "            //>seteando parametro\n"
                + "\n"
                + "            //Obtengo el numero a convertir\n"
                + "            get_local 0\n"
                + "            1\n"
                + "            add\n"
                + "            get_local $calc\n"
                + "            //>>Obtengo el numero a convertir\n"
                + "\n"
                + "            set_local $calc\n"
                + "\n"
                + "\n"
                + "            //CAMBIO de AMBITO REAL\n"
                + "            0\n"
                + "            get_local 0\n"
                + "            9\n"
                + "            add\n"
                + "            set_local $calc\n"
                + "            //________________________\n"
                + "\n"
                + "\n"
                + "            call $$_getInt\n"
                + "\n"
                + "\n"
                + "            //-------------------------guardando el return\n"
                + "            get_local 0\n"
                + "            9\n"
                + "            diff\n"
                + "            2\n"
                + "            add\n"
                + "\n"
                + "            //obteniendo el return\n"
                + "            get_local 0\n"
                + "            0\n"
                + "            add\n"
                + "            get_local $calc\n"
                + "            //>>obteniendo return\n"
                + "\n"
                + "            set_local $calc\n"
                + "            //-------------------------guardando el return\n"
                + "\n"
                + "            //REGRESO de AMBITO REAL\n"
                + "            0\n"
                + "            get_local 0\n"
                + "            9\n"
                + "            diff\n"
                + "            set_local $calc\n"
                + "            //________________________\n"
                + "\n"
                + "            //*************\n"
                + "            get_local 0\n"
                + "            2\n"
                + "            add\n"
                + "            get_local $calc\n"
                + "            //*************\n"
                + "\n"
                + "            0\n"
                + "            gt\n"
                + "            br_if $L81\n"
                + "            br $L80\n"
                + "\n"
                + "            $L81\n"
                + "            //------------------\n"
                + "                get_global 0 //obtener el valor puntero de heap\n"
                + "                0 //fin de cadena\n"
                + "                set_global $calc //setear valor en heap\n"
                + "\n"
                + "                //-----------------seteando t89\n"
                + "                get_local 0\n"
                + "                3\n"
                + "                add\n"
                + "                get_global 0\n"
                + "                set_local $calc\n"
                + "                //-----------------seteando t89\n"
                + "\n"
                + "\n"
                + "                //incremento el valor de puntero h=h+1\n"
                + "                0\n"
                + "                get_global 0 //obtener el valor puntero de heap\n"
                + "                1\n"
                + "                add\n"
                + "                set_global $calc //setear valor del ptr de heap\n"
                + "                //>>>incremento el valor de puntero h=h+1\n"
                + "\n"
                + "\n"
                + "                //Seteando parametro\n"
                + "                get_local 0\n"
                + "                9\n"
                + "                add\n"
                + "                1\n"
                + "                add\n"
                + "                //>seteando parametro\n"
                + "\n"
                + "                //Obtengo el numero a convertir\n"
                + "                get_local 0\n"
                + "                1\n"
                + "                add\n"
                + "                get_local $calc\n"
                + "                //>>Obtengo el numero a convertir\n"
                + "\n"
                + "                set_local $calc\n"
                + "\n"
                + "\n"
                + "                //CAMBIO de AMBITO REAL\n"
                + "                0\n"
                + "                get_local 0\n"
                + "                9\n"
                + "                add\n"
                + "                set_local $calc\n"
                + "                //________________________\n"
                + "\n"
                + "\n"
                + "                call $$_getInt\n"
                + "\n"
                + "\n"
                + "                //-------------------------guardando el return\n"
                + "                get_local 0\n"
                + "                9\n"
                + "                diff\n"
                + "                2\n"
                + "                add\n"
                + "\n"
                + "                //obteniendo el return\n"
                + "                get_local 0\n"
                + "                0\n"
                + "                add\n"
                + "                get_local $calc\n"
                + "                //>>obteniendo return\n"
                + "\n"
                + "                set_local $calc\n"
                + "                //-------------------------guardando el return\n"
                + "\n"
                + "                //REGRESO de AMBITO REAL\n"
                + "                0\n"
                + "                get_local 0\n"
                + "                9\n"
                + "                diff\n"
                + "                set_local $calc\n"
                + "                //________________________\n"
                + "\n"
                + "\n"
                + "                //direccion donde ser guardara t101\n"
                + "                get_local 0\n"
                + "                4\n"
                + "                add\n"
                + "                //----------------------------------\n"
                + "\n"
                + "\n"
                + "                //Obtengo el numero a convertir\n"
                + "                get_local 0\n"
                + "                1\n"
                + "                add\n"
                + "                get_local $calc\n"
                + "                //>>Obtengo el numero a convertir\n"
                + "\n"
                + "                2\n"
                + "                pot\n"
                + "\n"
                + "\n"
                + "                1.0\n"
                + "                2.0\n"
                + "                div\n"
                + "\n"
                + "                pot\n"
                + "\n"
                + "                //*************\n"
                + "                get_local 0\n"
                + "                2\n"
                + "                add\n"
                + "                get_local $calc\n"
                + "                //*************\n"
                + "\n"
                + "\n"
                + "                diff //decimal\n"
                + "                2\n"
                + "                pot\n"
                + "\n"
                + "                1.0\n"
                + "                2.0\n"
                + "                div\n"
                + "\n"
                + "                pot\n"
                + "\n"
                + "                10000\n"
                + "                MULT\n"
                + "\n"
                + "                set_local $calc\n"
                + "\n"
                + "                //Obtengo el t101\n"
                + "                get_local 0\n"
                + "                4\n"
                + "                add\n"
                + "                get_local $calc\n"
                + "                //>>Obtengo el t101\n"
                + "\n"
                + "                //-----------------------si != 0\n"
                + "                0\n"
                + "                diff\n"
                + "                eqz\n"
                + "                not\n"
                + "                //-----------------------si != 0\n"
                + "\n"
                + "                br_if $L83\n"
                + "                br $L82\n"
                + "                    $L83\n"
                + "                        get_global 0 //obtener el valor puntero de heap\n"
                + "                        0 //fin de cadena\n"
                + "                        set_global $calc //setear valor en heap\n"
                + "\n"
                + "                        //----------------set t109\n"
                + "                        get_local 0\n"
                + "                        6\n"
                + "                        add\n"
                + "                        get_global 0\n"
                + "                        set_local $calc\n"
                + "                        //----------------set t109\n"
                + "\n"
                + "                        //incremento el valor de puntero h=h+1\n"
                + "                        0\n"
                + "                        get_global 0\n"
                + "                        1\n"
                + "                        add\n"
                + "                        set_global $calc\n"
                + "                        //incremento el valor de puntero h=h+1\n"
                + "\n"
                + "                         //----------------set t110 cadena convertida\n"
                + "                        get_local 0\n"
                + "                        7\n"
                + "                        add\n"
                + "                        get_global 0\n"
                + "                        set_local $calc\n"
                + "                        //----------------set t110 cadena convertida\n"
                + "\n"
                + "                        //-----------------obtengo el valor de t78\n"
                + "                        get_local 0\n"
                + "                        8\n"
                + "                        add\n"
                + "                        get_local $calc\n"
                + "                        //-----------------obtengo el valor de t78\n"
                + "\n"
                + "                        0\n"
                + "                        lt\n"
                + "                        br_if $L87\n"
                + "                        br $L86\n"
                + "                        $L86\n"
                + "                          get_global 0 //obtener el valor puntero de heap\n"
                + "                          45\n"
                + "                          set_global $calc //setear valor en heap\n"
                + "\n"
                + "                          //incremento el valor de puntero h=h+1\n"
                + "                          0\n"
                + "                          get_global 0\n"
                + "                          1\n"
                + "                          add\n"
                + "                          set_global $calc\n"
                + "                          //incremento el valor de puntero h=h+1\n"
                + "                        $L87\n"
                + "                          //----------------- direccion de t89\n"
                + "                          get_local 0\n"
                + "                          3\n"
                + "                          add\n"
                + "                          //----------------- direccion de t89\n"
                + "\n"
                + "                          //----------------- valor de t89\n"
                + "                          get_local 0\n"
                + "                          3\n"
                + "                          add\n"
                + "                          get_local $calc\n"
                + "                          //----------------- valor de t89\n"
                + "                          1\n"
                + "                          diff\n"
                + "\n"
                + "                          set_local $calc\n"
                + "\n"
                + "                          //----------------- valor de t89\n"
                + "                          get_local 0\n"
                + "                          3\n"
                + "                          add\n"
                + "                          get_local $calc\n"
                + "                          //----------------- valor de t89\n"
                + "                          get_global $calc\n"
                + "                          0\n"
                + "                          diff\n"
                + "                          eqz\n"
                + "                          not\n"
                + "\n"
                + "                          br_if $L89\n"
                + "                          br $L88\n"
                + "                                $L89\n"
                + "                              //----------------- direccion de t109\n"
                + "                              get_local 0\n"
                + "                              6\n"
                + "                              add\n"
                + "                              //----------------- direccion de t109\n"
                + "\n"
                + "                              //----------------- valor de t109\n"
                + "                              get_local 0\n"
                + "                              6\n"
                + "                              add\n"
                + "                              get_local $calc\n"
                + "                              //----------------- valor de t109\n"
                + "                              1\n"
                + "                              diff\n"
                + "\n"
                + "                              set_local $calc\n"
                + "\n"
                + "\n"
                + "                              //----------------- valor de t109\n"
                + "                              get_local 0\n"
                + "                              6\n"
                + "                              add\n"
                + "                              get_local $calc\n"
                + "                              //----------------- valor de t109\n"
                + "                              get_global $calc\n"
                + "                              0\n"
                + "                              diff\n"
                + "                              eqz\n"
                + "                              not\n"
                + "\n"
                + "                              br_if $L91\n"
                + "                              br $L90\n"
                + "\n"
                + "                              $L91\n"
                + "                                  get_global 0 //obtener el valor puntero de heap\n"
                + "                                  0//final de cadena\n"
                + "                                  set_global $calc //setear valor en heap\n"
                + "\n"
                + "                                  //incremento el valor de puntero h=h+1\n"
                + "                                  0\n"
                + "                                  get_global 0\n"
                + "                                  1\n"
                + "                                  add\n"
                + "                                  set_global $calc\n"
                + "                                  //incremento el valor de puntero h=h+1\n"
                + "\n"
                + "                                  //direccion del retorno\n"
                + "                                  get_local 0\n"
                + "                                  0\n"
                + "                                  add\n"
                + "                                  //direccion del retorno\n"
                + "\n"
                + "                                  //valor de t110\n"
                + "                                  get_local 0\n"
                + "                                  7\n"
                + "                                  add\n"
                + "                                  get_local $calc\n"
                + "                                  //valor de t110\n"
                + "\n"
                + "                                  set_local $calc\n"
                + "                                  br $L74\n"
                + "                              $L90\n"
                + "                                  get_global 0\n"
                + "                                  //----------------- valor de t109\n"
                + "                                  get_local 0\n"
                + "                                  6\n"
                + "                                  add\n"
                + "                                  get_local $calc\n"
                + "                                  //----------------- valor de t109\n"
                + "                                  get_global $calc\n"
                + "\n"
                + "                                  set_global $calc\n"
                + "\n"
                + "\n"
                + "                                  //incremento el valor de puntero h=h+1\n"
                + "                                  0\n"
                + "                                  get_global 0\n"
                + "                                  1\n"
                + "                                  add\n"
                + "                                  set_global $calc\n"
                + "                                  //incremento el valor de puntero h=h+1\n"
                + "\n"
                + "\n"
                + "                                  br $L89\n"
                + "                            $L88\n"
                + "                                  get_global 0\n"
                + "                                  //----------------- valor de t89\n"
                + "                                  get_local 0\n"
                + "                                  3\n"
                + "                                  add\n"
                + "                                  get_local $calc\n"
                + "                                  //----------------- valor de t89\n"
                + "                                  get_global $calc\n"
                + "\n"
                + "                                  set_global $calc\n"
                + "\n"
                + "\n"
                + "                                  //incremento el valor de puntero h=h+1\n"
                + "                                  0\n"
                + "                                  get_global 0\n"
                + "                                  1\n"
                + "                                  add\n"
                + "                                  set_global $calc\n"
                + "                                  //incremento el valor de puntero h=h+1\n"
                + "                                  br $L87\n"
                + "                    $L82\n"
                + "\n"
                + "                        //Seteando parametro\n"
                + "                        get_local 0\n"
                + "                        9\n"
                + "                        add\n"
                + "                        1\n"
                + "                        add\n"
                + "                        //>seteando parametro\n"
                + "\n"
                + "                        //Obtengo el t101\n"
                + "                        get_local 0\n"
                + "                        4\n"
                + "                        add\n"
                + "                        get_local $calc\n"
                + "                        //>>Obtengo el t101\n"
                + "\n"
                + "                        set_local $calc\n"
                + "\n"
                + "\n"
                + "                        //CAMBIO de AMBITO REAL\n"
                + "                        0\n"
                + "                        get_local 0\n"
                + "                        9\n"
                + "                        add\n"
                + "                        set_local $calc\n"
                + "                        //________________________\n"
                + "\n"
                + "\n"
                + "                        call $$_getInt\n"
                + "\n"
                + "\n"
                + "                        ///-------------------------guardando el return\n"
                + "                        get_local 0\n"
                + "                        9\n"
                + "                        diff\n"
                + "                        2\n"
                + "                        add\n"
                + "\n"
                + "                        //obteniendo el return\n"
                + "                        get_local 0\n"
                + "                        0\n"
                + "                        add\n"
                + "                        get_local $calc\n"
                + "                        //>>obteniendo return\n"
                + "\n"
                + "                        set_local $calc\n"
                + "                        ///-------------------------guardando el return\n"
                + "\n"
                + "                        //REGRESO de AMBITO REAL\n"
                + "                        0\n"
                + "                        get_local 0\n"
                + "                        9\n"
                + "                        diff\n"
                + "                        set_local $calc\n"
                + "                        //________________________\n"
                + "\n"
                + "\n"
                + "\n"
                + "                        //*************\n"
                + "                        get_local 0\n"
                + "                        2\n"
                + "                        add\n"
                + "                        get_local $calc\n"
                + "                        //*************\n"
                + "                        0\n"
                + "                        gt\n"
                + "                        br_if $L85\n"
                + "                        br $L84\n"
                + "                        $L85\n"
                + "\n"
                + "                            get_global 0 //obtener el valor puntero de heap\n"
                + "                            46//simbolo decimal\n"
                + "                            set_global $calc //setear valor en heap\n"
                + "\n"
                + "                            //incremento el valor de puntero h=h+1\n"
                + "                            0\n"
                + "                            get_global 0\n"
                + "                            1\n"
                + "                            add\n"
                + "                            set_global $calc\n"
                + "                            //incremento el valor de puntero h=h+1\n"
                + "\n"
                + "                            br $L83\n"
                + "            //------------------\n"
                + "            $L80\n"
                + "                get_global 0\n"
                + "\n"
                + "                //*************\n"
                + "                get_local 0\n"
                + "                2\n"
                + "                add\n"
                + "                get_local $calc\n"
                + "                //*************\n"
                + "\n"
                + "                10\n"
                + "                MOD\n"
                + "                48\n"
                + "                ADD\n"
                + "                set_global $calc\n"
                + "\n"
                + "\n"
                + "\n"
                + "                //incremento el valor de puntero h=h+1\n"
                + "                0\n"
                + "                get_global 0\n"
                + "                1\n"
                + "                add\n"
                + "                set_global $calc\n"
                + "                //incremento el valor de puntero h=h+1\n"
                + "\n"
                + "\n"
                + "                //direccion del numero a convertir\n"
                + "                get_local 0\n"
                + "                1\n"
                + "                add\n"
                + "                //>>direccion del numero a convertir\n"
                + "\n"
                + "                //Obtengo el numero a convertir\n"
                + "                get_local 0\n"
                + "                1\n"
                + "                add\n"
                + "                get_local $calc\n"
                + "                //>>Obtengo el numero a convertir\n"
                + "\n"
                + "                10\n"
                + "                div\n"
                + "\n"
                + "                set_local $calc\n"
                + "                br $L79\n"
                + "            //--------------------\n"
                + "        $L72\n"
                + "            //direccion del retorno\n"
                + "            get_local 0\n"
                + "            0\n"
                + "            add\n"
                + "            //direccion del retorno\n"
                + "\n"
                + "            get_global 0\n"
                + "\n"
                + "            get_global 0 //obtener el valor puntero de heap\n"
                + "            48 //ascii de numero 0\n"
                + "            set_global $calc //setear valor en heap\n"
                + "\n"
                + "            //incremento el valor de puntero h=h+1\n"
                + "            0\n"
                + "            get_global 0 //obtener el valor puntero de heap\n"
                + "            1\n"
                + "            add\n"
                + "            set_global $calc //setear valor del ptr de heap\n"
                + "            //>>>incremento el valor de puntero h=h+1\n"
                + "\n"
                + "            set_local $calc //seteo el valor a retornar que es el puntero a heap\n"
                + "            br $L73\n"
                + "$L73\n"
                + "  get_global 0 //obtener el valor puntero de heap\n"
                + "  0 //fin de cadena\n"
                + "  set_global $calc //setear valor en heap\n"
                + "\n"
                + "  //incremento el valor de puntero h=h+1\n"
                + "  0\n"
                + "  get_global 0 //obtener el valor puntero de heap\n"
                + "  1\n"
                + "  add\n"
                + "  set_global $calc //setear valor del ptr de heap\n"
                + "  //>>>incremento el valor de puntero h=h+1\n"
                + "$L74\n"
                + "End\n"
                + "\n"
                + "\n"
                + "\n"
                + "\n"
                + "\n"
                + "function $$_getInt\n"
                + "\n"
                + "\n"
                + "  //direccion de t118\n"
                + "  get_local 0\n"
                + "  2\n"
                + "  add\n"
                + "  //direccion de t118\n"
                + "\n"
                + "  //valor del numero\n"
                + "  get_local 0\n"
                + "  1\n"
                + "  add\n"
                + "  get_local $calc\n"
                + "  //valor del numero\n"
                + "\n"
                + "  0.0000000001\n"
                + "  add\n"
                + "\n"
                + "  set_local $calc\n"
                + "\n"
                + "  //direccion de t119\n"
                + "  get_local 0\n"
                + "  3\n"
                + "  add\n"
                + "  //direccion de t119\n"
                + "  0\n"
                + "  set_local $calc\n"
                + "\n"
                + "\n"
                + "  //valor de t118\n"
                + "  get_local 0\n"
                + "  2\n"
                + "  add\n"
                + "  get_local $calc\n"
                + "  //valor de t118\n"
                + "\n"
                + "  0\n"
                + "  lt\n"
                + "  br_if $L93\n"
                + "  br $L92\n"
                + "\n"
                + "  $L93\n"
                + "      //valor de t118\n"
                + "      get_local 0\n"
                + "      2\n"
                + "      add\n"
                + "      get_local $calc\n"
                + "      //valor de t118\n"
                + "\n"
                + "      1\n"
                + "      lte\n"
                + "      br_if $L96\n"
                + "      br $L94\n"
                + "        $L96\n"
                + "            //----------------decremento de t118\n"
                + "            //direccion de t118\n"
                + "            get_local 0\n"
                + "            2\n"
                + "            add\n"
                + "            //direccion de t118\n"
                + "\n"
                + "\n"
                + "            //valor de t118\n"
                + "            get_local 0\n"
                + "            2\n"
                + "            add\n"
                + "            get_local $calc\n"
                + "            //valor de t118\n"
                + "            1\n"
                + "            diff\n"
                + "\n"
                + "            set_local $calc\n"
                + "            //----------------decremento de t118\n"
                + "\n"
                + "\n"
                + "            //----------------incremento de t119\n"
                + "            //direccion de t119\n"
                + "            get_local 0\n"
                + "            3\n"
                + "            add\n"
                + "            //direccion de t119\n"
                + "\n"
                + "\n"
                + "            //valor de t119\n"
                + "            get_local 0\n"
                + "            3\n"
                + "            add\n"
                + "            get_local $calc\n"
                + "            //valor de t119\n"
                + "            1\n"
                + "            add\n"
                + "\n"
                + "            set_local $calc\n"
                + "            //----------------incremento de t119\n"
                + "\n"
                + "            br $L93\n"
                + "\n"
                + "  $L92\n"
                + "      //direccion de t120\n"
                + "      get_local 0\n"
                + "      4\n"
                + "      add\n"
                + "      //direccion de t120\n"
                + "      -1\n"
                + "      set_local $calc\n"
                + "\n"
                + "      //valor de t118\n"
                + "      get_local 0\n"
                + "      2\n"
                + "      add\n"
                + "      get_local $calc\n"
                + "      //valor de t118\n"
                + "\n"
                + "\n"
                + "\n"
                + "      //valor de t120\n"
                + "      get_local 0\n"
                + "      4\n"
                + "      add\n"
                + "      get_local $calc\n"
                + "      //valor de t120\n"
                + "\n"
                + "      gte\n"
                + "      br_if $L95\n"
                + "      br $L94\n"
                + "\n"
                + "      $L95\n"
                + "          //----------------incremento de t118\n"
                + "          //direccion de t118\n"
                + "          get_local 0\n"
                + "          2\n"
                + "          add\n"
                + "          //direccion de t118\n"
                + "\n"
                + "\n"
                + "          //valor de t118\n"
                + "          get_local 0\n"
                + "          2\n"
                + "          add\n"
                + "          get_local $calc\n"
                + "          //valor de t118\n"
                + "          1\n"
                + "          add\n"
                + "\n"
                + "          set_local $calc\n"
                + "          //----------------incremento de t118\n"
                + "\n"
                + "\n"
                + "          //----------------incremento de t119\n"
                + "          //direccion de t119\n"
                + "          get_local 0\n"
                + "          3\n"
                + "          add\n"
                + "          //direccion de t119\n"
                + "\n"
                + "\n"
                + "          //valor de t119\n"
                + "          get_local 0\n"
                + "          3\n"
                + "          add\n"
                + "          get_local $calc\n"
                + "          //valor de t119\n"
                + "          1\n"
                + "          add\n"
                + "\n"
                + "          set_local $calc\n"
                + "          //----------------incremento de t119\n"
                + "\n"
                + "          br $L92\n"
                + "\n"
                + "      $L94\n"
                + "          //----------------set retorno\n"
                + "          get_local 0\n"
                + "          0\n"
                + "          add\n"
                + "\n"
                + "          //valor de t119\n"
                + "          get_local 0\n"
                + "          3\n"
                + "          add\n"
                + "          get_local $calc\n"
                + "          //valor de t119\n"
                + "\n"
                + "          set_local $calc\n"
                + "          //----------------set retorno\n"
                + "End";

        return cad;
    }
}
