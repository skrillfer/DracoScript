/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManejoErrores;

/**
 *
 * @author fernando
 */
public class Error {
    int linea=0;
    int columna=0;
    String tipo_error = "";
    String archivo    = "";
    String descripcion = "";

    public Error(int linea, int columna, String tipo, String descripcion,String archivo) {
        this.linea       = linea;
        this.columna     = columna;
        this.tipo_error  = tipo;
        this.descripcion =descripcion;
        this.archivo=archivo;
    }
    
}
