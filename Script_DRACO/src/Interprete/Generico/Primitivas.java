/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interprete.Generico;

import ESTRUCTURAS.Blocke;
import ESTRUCTURAS.Nodo;
import ESTRUCTURAS.Resultado;
import Interprete.ALR.Logica;
import jdk.nashorn.internal.ir.Block;

/**
 *
 * @author fernando
 */
public class Primitivas extends Interprete.Interpretacion{
    public void Imprimir(Nodo RAIZ)
    {
        String codigo_tmp = "";
        String codigo_2 = "";
        XopL = new Logica();
        
        Blocke last = Xblockes.obtener_UltimoBlock();
        //last.codigo_asm += "//<><><><><><><><><><><><><><>\n";
        Resultado r1 = XopL.OPERAR(RAIZ.hijos.get(0));
        
        
        
        if(r1.tipo.equals("cadena"))
        {
            if(r1.ref)
            {
                codigo_tmp = "//LLAMANDO A IMPRIMIR\n";
                codigo_tmp +=  "get_global $calc\n";
                last.add(codigo_tmp);
                //last.codigo_asm  += codigo_tmp;
                
                codigo_tmp = "0\n";
                codigo_tmp += "get_local 0\n";
                codigo_tmp += De$pl4z4r()+"\n";
                codigo_tmp += "add\n";
                codigo_tmp += "set_local $calc\n";
                
                
                codigo_tmp += "get_local 0\n";
                codigo_tmp += "1\n";
                codigo_tmp += "add\n";
                
                //codigo_2 = last.codigo_asm;
                
                last.agregarAl_Inicio(codigo_tmp);
                
                //last.codigo_asm = codigo_tmp;
                
                //last.codigo_asm += codigo_2;
                
                codigo_tmp = "set_local $calc\n";
                
                codigo_tmp += "call $$_outStr\n";
                
                
                codigo_tmp += "0\n";
                codigo_tmp += "get_local 0\n";
                codigo_tmp += De$pl4z4r()+"\n";
                codigo_tmp += "diff\n";
                codigo_tmp += "set_local $calc\n";
                
                last.add(codigo_tmp);
            }else
            {
                codigo_tmp = "//LLAMANDO A IMPRIMIR\n";
                codigo_tmp += "get_local 0\n";
                codigo_tmp += De$pl4z4r()+"\n";
                codigo_tmp += "add\n";
                codigo_tmp += "1\n";
                codigo_tmp += "add\n";
                
                
                last.add(codigo_tmp);
                //last.codigo_asm += codigo_tmp;
                
                
                codigo_tmp = "set_local $calc\n";
                
                codigo_tmp += "0\n";
                codigo_tmp += "get_local 0\n";
                codigo_tmp += De$pl4z4r()+"\n";
                codigo_tmp += "add\n";
                codigo_tmp += "set_local $calc\n\n";
                
                
                codigo_tmp += "call $$_outStr\n";

                codigo_tmp += "0\n";
                codigo_tmp += "get_local 0\n";
                codigo_tmp += De$pl4z4r()+"\n";
                codigo_tmp += "diff\n";
                codigo_tmp += "set_local $calc\n\n";
                
                Xblockes.agregar_AlUltimoBloque(codigo_tmp);
            }
        }
    }
}
