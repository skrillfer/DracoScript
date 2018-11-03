/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LENGUAJE_DRACO;

/**
 *
 * @author fernando
 */
public class Resultado_S {
    public String tipo;
    public Object valor;
    public Simbolo_S simbolo;

    public Resultado_S() {

    }

    public Resultado_S(String tipo) {
        this.tipo = tipo;
    }

    public Resultado_S(Object valor) {
        this.valor = valor;
    }

    public Resultado_S(String tipo, Object valor) {
        this.tipo = tipo;
        this.valor = valor;
    }
}
