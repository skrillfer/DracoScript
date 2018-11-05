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
            
            codigo_tmp += "eqz\n";
            
            codigo_tmp += "not\n";


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
    
    public String menor()
    {
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
        codigo_tmp += eti18+"\n";
            codigo_tmp += "get_global $calc\n";
            codigo_tmp += "0\n";
            codigo_tmp += "diff\n";
            codigo_tmp += "eqz\n";
            codigo_tmp += "not\n";
            codigo_tmp += "br_if "+eti20+"\n";
            codigo_tmp += "br "+eti19+"\n\n";
            codigo_tmp += eti20+"\n";
                codigo_tmp +="0\n";
                codigo_tmp +="get_local 0\n";
                codigo_tmp +="2\n";
                codigo_tmp +="add\n";
                codigo_tmp +="get_local $calc\n";
                codigo_tmp += eti28+"\n";
                codigo_tmp += "get_global $calc\n";
                codigo_tmp +="0\n";
                codigo_tmp +="diff\n";
                codigo_tmp +="eqz\n";
                codigo_tmp +="not\n";
                codigo_tmp +="br_if "+eti30+"\n";
                codigo_tmp +="br "+eti39+"\n";
                codigo_tmp +=eti30+"\n";
                codigo_tmp +="lt\n";
                codigo_tmp +="br_if "+etiF+"\n";
                codigo_tmp +="br "+etiV+"\n";
                codigo_tmp +=etiF+"\n";
                    codigo_tmp += "get_local 0\n";
                    codigo_tmp += "0\n";
                    codigo_tmp += "set_local $calc\n";
                    codigo_tmp += "br "+etiS+"\n";
                codigo_tmp +=etiV+"\n";
                    codigo_tmp += "get_local 0\n";
                    codigo_tmp += "1\n";
                    codigo_tmp += "set_local $calc\n";
                    codigo_tmp += "br "+etiS+"\n";
                codigo_tmp +=eti39+"\n";
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
                codigo_tmp += "br "+eti28+"\n";
                
        codigo_tmp += eti19+"\n";
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
            codigo_tmp += "br "+eti18+"\n";
        codigo_tmp += etiS+"\n";
            
               
        codigo_tmp += "End\n";
        
        return codigo_tmp;
    }
    
    public String menorIgual()
    {
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
        codigo_tmp += eti18+"\n";
            codigo_tmp += "get_global $calc\n";
            codigo_tmp += "0\n";
            codigo_tmp += "diff\n";
            codigo_tmp += "eqz\n";
            codigo_tmp += "not\n";
            codigo_tmp += "br_if "+eti20+"\n";
            codigo_tmp += "br "+eti19+"\n\n";
            codigo_tmp += eti20+"\n";
                codigo_tmp +="0\n";
                codigo_tmp +="get_local 0\n";
                codigo_tmp +="2\n";
                codigo_tmp +="add\n";
                codigo_tmp +="get_local $calc\n";
                codigo_tmp += eti28+"\n";
                codigo_tmp += "get_global $calc\n";
                codigo_tmp +="0\n";
                codigo_tmp +="diff\n";
                codigo_tmp +="eqz\n";
                codigo_tmp +="not\n";
                codigo_tmp +="br_if "+eti30+"\n";
                codigo_tmp +="br "+eti39+"\n";
                codigo_tmp +=eti30+"\n";
                codigo_tmp +="lte\n";
                codigo_tmp +="br_if "+etiF+"\n";
                codigo_tmp +="br "+etiV+"\n";
                codigo_tmp +=etiF+"\n";
                    codigo_tmp += "get_local 0\n";
                    codigo_tmp += "0\n";
                    codigo_tmp += "set_local $calc\n";
                    codigo_tmp += "br "+etiS+"\n";
                codigo_tmp +=etiV+"\n";
                    codigo_tmp += "get_local 0\n";
                    codigo_tmp += "1\n";
                    codigo_tmp += "set_local $calc\n";
                    codigo_tmp += "br "+etiS+"\n";
                codigo_tmp +=eti39+"\n";
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
                codigo_tmp += "br "+eti28+"\n";
                
        codigo_tmp += eti19+"\n";
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
            codigo_tmp += "br "+eti18+"\n";
        codigo_tmp += etiS+"\n";
            
               
        codigo_tmp += "End\n";
        
        return codigo_tmp;
    }
    
    public String mayor()
    {
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
        codigo_tmp += eti18+"\n";
            codigo_tmp += "get_global $calc\n";
            codigo_tmp += "0\n";
            codigo_tmp += "diff\n";
            codigo_tmp += "eqz\n";
            codigo_tmp += "not\n";
            codigo_tmp += "br_if "+eti20+"\n";
            codigo_tmp += "br "+eti19+"\n\n";
            codigo_tmp += eti20+"\n";
                codigo_tmp +="0\n";
                codigo_tmp +="get_local 0\n";
                codigo_tmp +="2\n";
                codigo_tmp +="add\n";
                codigo_tmp +="get_local $calc\n";
                codigo_tmp += eti28+"\n";
                codigo_tmp += "get_global $calc\n";
                codigo_tmp +="0\n";
                codigo_tmp +="diff\n";
                codigo_tmp +="eqz\n";
                codigo_tmp +="not\n";
                codigo_tmp +="br_if "+eti30+"\n";
                codigo_tmp +="br "+eti39+"\n";
                codigo_tmp +=eti30+"\n";
                codigo_tmp +="gt\n";
                codigo_tmp +="br_if "+etiF+"\n";
                codigo_tmp +="br "+etiV+"\n";
                codigo_tmp +=etiF+"\n";
                    codigo_tmp += "get_local 0\n";
                    codigo_tmp += "0\n";
                    codigo_tmp += "set_local $calc\n";
                    codigo_tmp += "br "+etiS+"\n";
                codigo_tmp +=etiV+"\n";
                    codigo_tmp += "get_local 0\n";
                    codigo_tmp += "1\n";
                    codigo_tmp += "set_local $calc\n";
                    codigo_tmp += "br "+etiS+"\n";
                codigo_tmp +=eti39+"\n";
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
                codigo_tmp += "br "+eti28+"\n";
                
        codigo_tmp += eti19+"\n";
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
            codigo_tmp += "br "+eti18+"\n";
        codigo_tmp += etiS+"\n";
            
               
        codigo_tmp += "End\n";
        
        return codigo_tmp;
    }
    
    public String mayorIgual()
    {
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
        codigo_tmp += eti18+"\n";
            codigo_tmp += "get_global $calc\n";
            codigo_tmp += "0\n";
            codigo_tmp += "diff\n";
            codigo_tmp += "eqz\n";
            codigo_tmp += "not\n";
            codigo_tmp += "br_if "+eti20+"\n";
            codigo_tmp += "br "+eti19+"\n\n";
            codigo_tmp += eti20+"\n";
                codigo_tmp +="0\n";
                codigo_tmp +="get_local 0\n";
                codigo_tmp +="2\n";
                codigo_tmp +="add\n";
                codigo_tmp +="get_local $calc\n";
                codigo_tmp += eti28+"\n";
                codigo_tmp += "get_global $calc\n";
                codigo_tmp +="0\n";
                codigo_tmp +="diff\n";
                codigo_tmp +="eqz\n";
                codigo_tmp +="not\n";
                codigo_tmp +="br_if "+eti30+"\n";
                codigo_tmp +="br "+eti39+"\n";
                codigo_tmp +=eti30+"\n";
                codigo_tmp +="gte\n";
                codigo_tmp +="br_if "+etiF+"\n";
                codigo_tmp +="br "+etiV+"\n";
                codigo_tmp +=etiF+"\n";
                    codigo_tmp += "get_local 0\n";
                    codigo_tmp += "0\n";
                    codigo_tmp += "set_local $calc\n";
                    codigo_tmp += "br "+etiS+"\n";
                codigo_tmp +=etiV+"\n";
                    codigo_tmp += "get_local 0\n";
                    codigo_tmp += "1\n";
                    codigo_tmp += "set_local $calc\n";
                    codigo_tmp += "br "+etiS+"\n";
                codigo_tmp +=eti39+"\n";
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
                codigo_tmp += "br "+eti28+"\n";
                
        codigo_tmp += eti19+"\n";
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
            codigo_tmp += "br "+eti18+"\n";
        codigo_tmp += etiS+"\n";
            
               
        codigo_tmp += "End\n";
        
        return codigo_tmp;
    }
    
    
    public String concat()
    {
        String eti55 = control.generar_etiqueta();
        String eti66 = control.generar_etiqueta();
        String eti67 = control.generar_etiqueta();
        String eti68 = control.generar_etiqueta();
        
        String eti97 = control.generar_etiqueta();
        String eti98 = control.generar_etiqueta();

        String etiS = control.generar_etiqueta();
        
        String codigo_tmp= "\n\nfunction $$_concat\n";
        
        codigo_tmp +=   "get_local 0\n";
        codigo_tmp +=   "get_global 0\n";
        codigo_tmp +=   "set_local $calc\n";
        
        codigo_tmp +=   "get_local 0\n" ;
        codigo_tmp +=   "1\n";
        codigo_tmp +=   "add\n" ;
        codigo_tmp +=   "get_local $calc\n";
        codigo_tmp +=   eti66+"\n";
            codigo_tmp +=   "get_global $calc\n";
            codigo_tmp +=   "0\n";
            codigo_tmp +=   "diff\n";
            codigo_tmp +=   "eqz\n";
            codigo_tmp +=   "not\n";
            codigo_tmp +=   "br_if "+eti68+"\n";
            codigo_tmp +=   "br "+eti67+"\n";
            codigo_tmp +=   eti68+"\n";
                codigo_tmp +=   "get_local 0\n";
                codigo_tmp +=   "2\n";
                codigo_tmp +=   "add\n";
                codigo_tmp +=   "get_local $calc\n";
                
                codigo_tmp +=   eti55+"\n";
                codigo_tmp +=   "get_global $calc\n";
                codigo_tmp +=   "0\n";
                codigo_tmp +=   "diff\n";
                codigo_tmp +=   "eqz\n";
                codigo_tmp +=   "not\n";
                codigo_tmp +=   "br_if "+eti98+"\n";
                codigo_tmp +=   "br "+eti97+"\n";
                codigo_tmp +=   eti98+"\n";
                    codigo_tmp +=   "br "+etiS+"\n";
                codigo_tmp +=   eti97+"\n";
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
                    codigo_tmp += "br "+eti55+"\n";
            
            codigo_tmp +=   eti67+"\n";
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
                codigo_tmp += "br "+eti66+"\n";   
        codigo_tmp += etiS + "\n";        
        codigo_tmp += "End\n";
        
        return codigo_tmp;
    }
   
}
