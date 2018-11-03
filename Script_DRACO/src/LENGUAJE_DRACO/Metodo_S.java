/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LENGUAJE_DRACO;

import ESTRUCTURAS.Nodo;
import java.util.ArrayList;

/**
 *
 * @author fernando
 */
public class Metodo_S {
    public String nombre;
    public String id;
    public String tipo;
    public String visibilidad;
    public Nodo sentencias;
    public ArrayList<Nodo> parametros;
    public Resultado_S retorno;

    public boolean estadoRetorno = false;
    public boolean estadoTerminar = false;
    public boolean estadoContinuar = false;

    public Metodo_S() {

    }

    public Metodo_S(Nodo raiz) {
        this.tipo = "vacio";
        this.nombre = "principal";
        this.sentencias = raiz.hijos.get(0);
        this.id = nombre;
        this.visibilidad = "privado";
        this.parametros = new ArrayList();

    }
}
