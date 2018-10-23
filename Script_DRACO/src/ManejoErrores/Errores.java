/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejoErrores;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author fernando
 */


public class Errores {
    ArrayList<Error> lista_errores = new ArrayList<>();
    
    public  void add(int linea, int columna, String tipo, String descripcion,String archivo)
    {
        lista_errores.add(new Error(linea,columna,tipo,descripcion,archivo));
    }
    
    public  void generar_reporte() throws IOException
    {
        String str_html = "<html style=\"width:100%\">";
        str_html += "<body>";
        str_html += "<table>";
        str_html +="<tr>";
            str_html +="<th>" +"Linea"+ "</th>";
            str_html +="<th>" +"Columa"+ "</th>";
            str_html +="<th>" +"Tipo Error"+ "</th>";
            str_html +="<th>" +"Descripcion"+ "</th>";
            str_html +="<th>" +"Archivo"+ "</th>";
        str_html +="</tr>";
        
        for (Error item : lista_errores) {
            str_html +="<tr>";
                str_html +="<th>" +item.linea+ "</th>";
                str_html +="<th>" +item.columna+ "</th>";
                str_html +="<th>" +item.tipo_error+ "</th>";
                str_html +="<th>" +item.descripcion+ "</th>";
                str_html +="<th>" +item.archivo+ "</th>";
            str_html +="</tr>";
        }
        
        str_html += "</table>";
        str_html += "</body>";
        str_html += "</html>";
       
        Desktop.getDesktop().open(new File("a.html"));

    }
    
}

