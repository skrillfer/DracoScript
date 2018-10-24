/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interprete;

/**
 *
 * @author fernando
 */
public class Control_Intermedio {
    int etiqueta =1;
    public String codigoDASM  = "";
    
    public String generar_etiqueta()
    {
        String eti= "$label"+(etiqueta++);
        return eti;
    }
    
}
