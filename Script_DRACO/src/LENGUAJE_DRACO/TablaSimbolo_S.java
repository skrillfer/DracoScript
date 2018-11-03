/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LENGUAJE_DRACO;

import java.util.Hashtable;

/**
 *
 * @author fernando
 */
public class TablaSimbolo_S {
    public Hashtable<String, Simbolo_S> tabla;

    public TablaSimbolo_S() {
        tabla = new Hashtable<>();
    }

    public Boolean existe(String nombre) {
        nombre = nombre.toLowerCase();
        return tabla.containsKey(nombre);
    }

    public Simbolo_S getSimbolo(String nombre, Clase claseActual) {
        Simbolo_S buscado = null;
        TablaSimbolo_S principal = claseActual.global;
        nombre = nombre.toLowerCase();
        if (existe(nombre)) {
            return tabla.get(nombre);
        } else//si no existe en el ambito local se busca en el ambito global
        {
            if (principal.existe(nombre)) {
                return principal.tabla.get(nombre);
            } else {
                Clase hereda = claseActual.herencia;

                if (hereda != null) {
                    buscado = hereda.global.getSimbolo(nombre, hereda);
                } else {
                    return null;
                }
            }
        }
        if (buscado != null) {
            if (buscado.visibilidad.equalsIgnoreCase("publico") || buscado.visibilidad.equalsIgnoreCase("protegido")) {
                return buscado;
            } else {
                return null;
            }
        }
        return buscado;
    }

    public boolean setSimbolo(Simbolo_S simbolo) {
        simbolo.nombre = simbolo.nombre.toLowerCase();
        if (!existe(simbolo.nombre)) {
            tabla.put(simbolo.nombre, simbolo);
            if (Draco_Script_S.metodoActual != null) {
                simbolo.ambito = Draco_Script_S.claseActual.nombre + "_" + Draco_Script_S.metodoActual.nombre;
            } else {
                simbolo.ambito = Draco_Script_S.claseActual.nombre;
            }
            simbolo.rol = "Variable";
            Draco_Script_S.reporteSimbolos.add(simbolo);
            return true;//se agrego correctamente
        } else {
            return false;//no se agrego a la global
        }
    }

    public void cambiarAmbito(TablaSimbolo_S actual) {
        for (Simbolo_S simbolo : actual.tabla.values()) {
            tabla.put(simbolo.nombre, simbolo);
        }
    }
}
