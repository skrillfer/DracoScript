/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LENGUAJE_DRACO;

import ESTRUCTURAS.Nodo;
import LENGUAJE_DRACO.OperacionesALR.Operacion_ALR;
import java.util.ArrayList;

/**
 *
 * @author fernando
 */
public class Arreglo {
    public ArrayList<Integer> dimensiones;
    private ArrayList<Object> datos;
    private TablaSimbolo_S global;
    private TablaSimbolo_S tabla;
    public boolean estado = true;
    private Operacion_ALR opL;

    public Arreglo() {
        dimensiones = new ArrayList<>();
        datos = new ArrayList<>();
    }
    
    public ArrayList<Object> getDatos() {
        return datos;
    }

    public Arreglo(Nodo raiz, TablaSimbolo_S global, TablaSimbolo_S tabla, int n) {
        dimensiones = new ArrayList<>();
        datos = new ArrayList<>();
        this.global = global;
        this.tabla = tabla;
        opL = new Operacion_ALR(global, tabla);
        guardarDimensiones(raiz);
        for (int i = 0; i < dimensiones.size(); i++) {
            int tam = dimensiones.get(i);
            for (int j = 0; j < tam; j++) {
                datos.add(null);
            }
        }
    }

    public Arreglo(Nodo raiz, TablaSimbolo_S global, TablaSimbolo_S tabla, ArrayList<Integer> dimensiones) {
        this.dimensiones = dimensiones;
        datos = new ArrayList<>();
        this.global = global;
        this.tabla = tabla;
        opL = new Operacion_ALR(global, tabla);
        guardarValores(raiz);
    }

    public Arreglo(Nodo raiz, TablaSimbolo_S global, TablaSimbolo_S tabla) {
        dimensiones = new ArrayList<>();
        datos = new ArrayList<>();
        this.global = global;
        this.tabla = tabla;
        opL = new Operacion_ALR(global, tabla);
        guardarValores(raiz);
    }

    private void guardarDimensiones(Nodo raiz) {
        ArrayList<Nodo> dim = raiz.hijos.get(1).hijos;
        int total = 1;
        for (Nodo hijo : dim) {
            Resultado_S dimension = opL.operar(hijo);
            if (dimension.tipo.equalsIgnoreCase("entero")) {
                total *= (int) dimension.valor;
                dimensiones.add((int) dimension.valor);
            } else {
                //Inicio.reporteError.agregar("Semantico", hijo.linea, hijo.columna, "Solo se permiten valores enteros para los indices de un arreglo");
                estado = false;
            }
        }
    }

    private void guardarValores(Nodo raiz) {
        ArrayList<Nodo> dim = null;
        ArrayList<Nodo> val = null;
        String tipo = "";
        switch (raiz.hijos.size()) {
            case 4:
                dim = raiz.hijos.get(1).hijos;
                val = raiz.hijos.get(3).hijos;
                tipo = raiz.hijos.get(0).valor;
                break;
            case 3:
                dim = raiz.hijos.get(1).hijos;
                val = raiz.hijos.get(2).hijos;
                tipo = raiz.hijos.get(0).valor;
                break;
            case 2:
                val = raiz.hijos.get(1).hijos;//modifique para la nueva version
                tipo = raiz.valor;
                break;
            default:
                break;
        }

        int total = 1;
        if (raiz.hijos.size() > 2) {
            for (Nodo hijo : dim) {
                Resultado_S dimension = opL.operar(hijo);
                if (dimension.tipo.equalsIgnoreCase("entero")) {
                    total *= (int) dimension.valor;
                    dimensiones.add((int) dimension.valor);
                } else {
                    //Inicio.reporteError.agregar("Semantico", hijo.linea, hijo.columna, "Solo se permiten valores enteros para los indices de un arreglo");
                    estado = false;
                }
            }
        } else {
            for (int t1 : dimensiones) {
                total *= t1;
            }
        }

        for (Nodo hijo : val) {
            Resultado_S resultado = opL.operar(hijo);
            Casteo casteo = new Casteo();
            resultado = casteo.castear(hijo, tipo, resultado);
            if (resultado != null) {
                datos.add(resultado.valor);
            }
        }

        if (total != datos.size()) {
            //Inicio.reporteError.agregar("Semantico", raiz.linea, raiz.columna, "La cantidad de datos del arreglo no concuerdan con sus indices");
            estado = false;
        }
    }

    public Object getValor(ArrayList<Integer> indices) {
        int indice = getIndice(indices);
        if ((indice + 1) <= datos.size() && indice >= 0) {
            return datos.get(indice);
        } else {
            //indice incorrecto
            return null;
        }
    }

    public boolean setValor(ArrayList<Integer> indices, Resultado_S dato) {
        int indice = getIndice(indices);
        if ((indice + 1) <= datos.size() && indice >= 0) {
            datos.set(indice, dato.valor);
            return true;
        }
        return false;
    }

    public int getSize() {
        return datos.size();
    }

    private int getIndice(ArrayList<Integer> indices) {
        int indice;
        ArrayList<Integer> inf = new ArrayList<>();
        ArrayList<Integer> sup = new ArrayList<>();
        for (Integer d : dimensiones) {
            inf.add(0);
            sup.add(d);
        }
        indice = indices.get(0) - inf.get(0);
        for (int i = 1; i < dimensiones.size(); i++) {
            int n = sup.get(i) - inf.get(i);
            indice = indice * n;
            indice = indice + indices.get(i);
            indice = indice - inf.get(i);
        }
        return indice;
    }
}
