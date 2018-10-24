/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ESTRUCTURAS;

/**
 *
 * @author fernando
 */
public class Resultado {
    public String tipo = "";
    public Object valor = null;
    public String ETV = "";
    public String ETF = "";
    public Simbolo simbolo = null;
    public int tamanio = 0;

    public Resultado(String tipo , Object valor, String ETV, String ETF) {
        this.tipo = tipo;
        this.valor = valor;
        this.ETF =  ETF;
        this.ETV = ETV;
        
    }

    public Resultado(String tipo, Object valor) {
        this.tipo = tipo;
        this.valor = valor;
    }
    
    
    
    
}
