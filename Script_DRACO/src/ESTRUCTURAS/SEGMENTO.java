/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ESTRUCTURAS;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fernando
 */
public class SEGMENTO {
    public ArrayList<String> lineas = new ArrayList<>();
    public String identificador = "";

    public SEGMENTO() {
    }
    
    public SEGMENTO(String id,String cod) {
        this.identificador = id;
        this.lineas.add(cod);
    }
    
    
    public void add_Ini(String codigo)
    {
        lineas.add(0, codigo);
    }
    
    public void add_Fin(String codigo)
    {
        lineas.add(lineas.size()-1, codigo);
    }
}
