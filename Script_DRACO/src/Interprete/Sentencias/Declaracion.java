/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interprete.Sentencias;

import ESTRUCTURAS.Blocke;
import ESTRUCTURAS.Nodo;
import ESTRUCTURAS.Resultado;
import ESTRUCTURAS.Simbolo;
import Interprete.ALR.Aritmetica;
import Interprete.ALR.Logica;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author fernando
 */
public class Declaracion extends Interprete.Interpretacion {

    public int declaracionEstructuraD(Nodo RAIZ) {
        Nodo listaids = RAIZ.hijos.get(1);
        for (Nodo nodo : listaids.hijos) {
            Simbolo simbolo = Interprete.Interpretacion.tabla.obtener_Simbolo(nodo.valor, Interprete.Interpretacion.ambito);
            if (simbolo == null) {
                return 0;
            }
            Simbolo sim_declarado = Interprete.Interpretacion.tabla.HacerSimboloDeclarado(simbolo);
            if (sim_declarado == null) {
                return 0;
            }

            Simbolo estructura = Interprete.Interpretacion.tabla.obtener_Estructura(simbolo, new ArrayList<>());

            if (estructura == null) {
                return 0;
            }

            simbolo.inicializado = true;

            String codigo_tmp = "get_local 0\n";
            codigo_tmp += simbolo.direccion + "\n";
            codigo_tmp += "add\n";
            codigo_tmp += "get_global 0\n";
            codigo_tmp += "set_local $calc\n\n\n";

            codigo_tmp += "get_local 0\n";
            codigo_tmp += De$pl4z4r() + "\n";
            codigo_tmp += "add\n";
            codigo_tmp += "1\n";
            codigo_tmp += "add\n\n";
            codigo_tmp += "get_global 0\n";
            codigo_tmp += "set_local $calc\n";

            codigo_tmp += "get_global 0\n";
            codigo_tmp += estructura.tamanio + "\n";
            codigo_tmp += "add\n";
            codigo_tmp += "set_global 0\n\n";

            codigo_tmp += "0\n";
            codigo_tmp += "get_local 0\n";
            codigo_tmp += De$pl4z4r() + "\n";
            codigo_tmp += "add\n";
            codigo_tmp += "set_local $calc\n\n";

            codigo_tmp += "call struct_" + estructura.nombre + "\n";

            codigo_tmp += "0\n";
            codigo_tmp += "get_local 0\n";
            codigo_tmp += De$pl4z4r() + "\n";
            codigo_tmp += "diff\n";
            codigo_tmp += "set_local $calc\n\n";

            Xblockes.agregar(codigo_tmp, nodo);
        }
        return 0;
    }

    public int declaracionEstructuraGlobal(Nodo RAIZ) {
        Nodo listaids = RAIZ.hijos.get(1);
        for (Nodo nodo : listaids.hijos) {
            Simbolo simbolo = Interprete.Interpretacion.tabla.obtener_Simbolo(nodo.valor, Interprete.Interpretacion.ambito);
            if (simbolo == null) {
                return 0;
            }
            Simbolo sim_declarado = Interprete.Interpretacion.tabla.HacerSimboloDeclarado(simbolo);
            if (sim_declarado == null) {
                return 0;
            }

            Simbolo estructura = Interprete.Interpretacion.tabla.obtener_Estructura(simbolo, new ArrayList<>());

            if (estructura == null) {
                return 0;
            }

            simbolo.inicializado = true;

            String codigo_tmp = "\n\n\nget_local 0\n";
            codigo_tmp += "1\n";
            codigo_tmp += "add\n";
            codigo_tmp += "get_local $calc\n";
            codigo_tmp += simbolo.direccion + "//direccion de " + simbolo.nombre + "\n";
            codigo_tmp += "add\n";
            codigo_tmp += "get_global 0\n";
            codigo_tmp += "set_global $calc\n\n\n";

            codigo_tmp += "get_local 0\n";
            codigo_tmp += De$pl4z4r() + "\n";
            codigo_tmp += "add\n";
            codigo_tmp += "1\n";
            codigo_tmp += "add\n\n";
            codigo_tmp += "get_global 0\n";
            codigo_tmp += "set_local $calc\n";

            codigo_tmp += "get_global 0\n";
            codigo_tmp += estructura.tamanio + "\n";
            codigo_tmp += "add\n";
            codigo_tmp += "set_global 0\n\n";

            codigo_tmp += "0\n";
            codigo_tmp += "get_local 0\n";
            codigo_tmp += De$pl4z4r() + "\n";
            codigo_tmp += "add\n";
            codigo_tmp += "set_local $calc\n\n";

            codigo_tmp += "call struct_" + estructura.nombre + "\n";

            codigo_tmp += "0\n";
            codigo_tmp += "get_local 0\n";
            codigo_tmp += De$pl4z4r() + "\n";
            codigo_tmp += "diff\n";
            codigo_tmp += "set_local $calc\n\n";

            Xblockes.agregar(codigo_tmp, nodo);
        }
        return 0;
    }

    public int declaracionPrimitivaDA(Nodo RAIZ) {
        Nodo listaids = RAIZ.hijos.get(1);
        for (Nodo nodo : listaids.hijos) {
            Simbolo simbolo = Interprete.Interpretacion.tabla.obtener_Simbolo(nodo.valor, Interprete.Interpretacion.ambito);
            if (simbolo == null) {
                return 0;
            }
            Simbolo sim_declarado = Interprete.Interpretacion.tabla.HacerSimboloDeclarado(simbolo);
            if (sim_declarado == null) {
                return 0;
            }

            XopL = new Logica();
            Resultado r1 = XopL.OPERAR(RAIZ.hijos.get(RAIZ.hijos.size() - 1));
            Xcastear.castear(simbolo, r1, nodo);

        }
        return 0;
    }

    public int declaracionPrimitivaDA_GLOBAL(Nodo RAIZ) {
        Nodo listaids = RAIZ.hijos.get(1);
        for (Nodo nodo : listaids.hijos) {
            Simbolo simbolo = Interprete.Interpretacion.tabla.obtener_Simbolo(nodo.valor, Interprete.Interpretacion.ambito);
            if (simbolo == null) {
                return 0;
            }
            Simbolo sim_declarado = Interprete.Interpretacion.tabla.HacerSimboloDeclarado(simbolo);
            if (sim_declarado == null) {
                return 0;
            }

            XopL = new Logica();
            Resultado r1 = XopL.OPERAR(RAIZ.hijos.get(RAIZ.hijos.size() - 1));
            Xcastear.castear_atributo(simbolo, r1, nodo);
        }
        return 0;
    }

    public int declaracionPrimitivaD(Nodo RAIZ) {
        Nodo listaids = RAIZ.hijos.get(1);
        for (Nodo nodo : listaids.hijos) {
            Simbolo simbolo = Interprete.Interpretacion.tabla.obtener_Simbolo(nodo.valor, Interprete.Interpretacion.ambito);
            if (simbolo == null) {
                return 0;
            }
            Simbolo sim_declarado = Interprete.Interpretacion.tabla.HacerSimboloDeclarado(simbolo);
            if (sim_declarado == null) {
                return 0;
            }

            String codigo_tmp = "\n\nget_local 0\n";
            codigo_tmp += simbolo.direccion + " //Posicion de la variable:" + simbolo.nombre + "\n";
            codigo_tmp += "Add \n";

            switch (simbolo.tipo) {
                case "decimal":
                case "booleano":
                case "entero":
                    codigo_tmp += "0\n";
                    break;
                default:
                    codigo_tmp += (int) nulo + "\n";
                    break;
            }
            codigo_tmp += "set_local $calc //Asignacion a la variable:" + simbolo.nombre + "\n\n";
            Xblockes.agregar(codigo_tmp, nodo);
        }
        return 0;
    }

    public int declaracionPrimitivaDGlobal(Nodo RAIZ) {
        Nodo listaids = RAIZ.hijos.get(1);
        for (Nodo nodo : listaids.hijos) {
            Simbolo simbolo = Interprete.Interpretacion.tabla.obtener_Simbolo(nodo.valor, Interprete.Interpretacion.ambito);
            if (simbolo == null) {
                return 0;
            }
            Simbolo sim_declarado = Interprete.Interpretacion.tabla.HacerSimboloDeclarado(simbolo);
            if (sim_declarado == null) {
                return 0;
            }

            String codigo_tmp = "";

            codigo_tmp += "\n\nget_local 0\n";
            codigo_tmp += "1\n";
            codigo_tmp += "Add \n";
            codigo_tmp += "get_local $calc \n\n";

            codigo_tmp += simbolo.direccion + " //direccion del atributo:" + simbolo.nombre + "\n";
            codigo_tmp += "Add \n\n";

            switch (simbolo.tipo) {
                case "decimal":
                case "booleano":
                case "entero":
                    codigo_tmp += "0\n";
                    break;
                default:
                    codigo_tmp += (int) nulo + "\n";
                    break;
            }
            codigo_tmp += "\n\nset_global $calc\n\n";

            Xblockes.agregar(codigo_tmp, nodo);
        }
        return 0;
    }

    public int declaracionArreglo(Nodo RAIZ) {
        Nodo listaids = RAIZ.hijos.get(1);
        for (Nodo nodo : listaids.hijos) {
            Simbolo simbolo = Interprete.Interpretacion.tabla.obtener_Simbolo(nodo.valor, Interprete.Interpretacion.ambito);
            if (simbolo == null) {
                return 0;
            }
            Simbolo sim_declarado = Interprete.Interpretacion.tabla.HacerSimboloDeclarado(simbolo);
            if (sim_declarado == null) {
                return 0;
            }
            
            Xblockes.agregar("\n", nodo);
            
            Blocke last = Xblockes.obtener_UltimoBlock();
            
            String cod = "\n\n\n";
            cod += "get_local 0\n";
            cod += simbolo.direccion+"\n";
            cod += "add\n";
            
            cod += "get_global 0\n";
            cod += "set_local $calc\n";
            
            
            
            cod += "get_local 0\n";
            cod += simbolo.direccion+"\n";
            cod += "add\n";
            cod += "get_local $calc\n";
                
            cod += "\n\n\n1\n";
            
            String cod2 = "";
            XopL = new Logica();
            Resultado rr=null;
            for (Nodo nodo1 : simbolo.dimension) {
                rr=XopL.OPERAR(nodo1);
                if(!R_IS_NULL(rr))
                {
                    if(rr.tipo.equals("entero"))
                    {
                        cod2 += "MULT\n";
                    }else
                    {
                        cod2 = "";
                        break;
                    }
                }
            }
            if(!cod2.equals(""))
            {
                cod2 += "2\n";
                cod2 += "add\n";
                
                cod2 += "set_global $calc\n\n";
                last.add(cod2);
                
                last.agregarAl_Inicio(cod);
                
                cod2 = "\n\n\nget_local 0\n";
                cod2 += simbolo.direccion+"\n";
                cod2 += "add\n";
                cod2 += "get_local $calc\n";
                cod2 += "get_global $calc\n\n";
                
                
                cod2 += "set_global 0\n\n\n";
                last.add(cod2);
                
                
                if(!RAIZ.hijos.get(3).hijos.isEmpty())
                {
                    
                    if(RAIZ.hijos.get(3).nombre.equals("dimension_valores"))
                    {
                        Nodo dimension = RAIZ.hijos.get(3);
                        for (Nodo nod1 : dimension.hijos) {
                            XopL = new Logica();
                            cod2 = "\n\n\nget_local 0\n";
                            cod2 += simbolo.direccion+"\n";
                            cod2 += "add\n";
                            cod2 += "get_local $calc\n";
                            
                            cod2 += "\n\n\nget_local 0\n";
                            cod2 += simbolo.direccion+"\n";
                            cod2 += "add\n";
                            cod2 += "get_local $calc\n";
                            cod2 += "1\n";
                            cod2 += "add\n";
                            cod2 += "get_global $calc\n\n";
                            cod2 += "add\n";
                            last.add(cod2);
                            
                            XopL.OPERAR(nod1);
                            
                            cod2 = "set_global $calc\n\n";
                            
                            cod2 += "\n\n\nget_local 0\n";
                            cod2 += simbolo.direccion+"\n";
                            cod2 += "add\n";
                            cod2 += "get_local $calc\n";
                            cod2 += "1\n";
                            cod2 += "add\n";
                            
                            cod2 += "\n\n\nget_local 0\n";
                            cod2 += simbolo.direccion+"\n";
                            cod2 += "add\n";
                            cod2 += "get_local $calc\n";
                            cod2 += "1\n";
                            cod2 += "add\n";
                            cod2 += "get_global $calc\n\n";
                            
                            cod2 += "1\n";
                            cod2 += "add\n";
                            
                            cod2 += "set_global $calc\n\n";
                            last.add(cod2);
                            //JOptionPane.showMessageDialog(null, nod1.nombre+":"+.valor);
                        }
                    }
                }else
                {
                        cod2 = "\n\n\nget_local 0\n";
                        cod2 += simbolo.direccion+"\n";
                        cod2 += "add\n";
                        cod2 += "get_local $calc\n";
                        
                        cod2 += "1\n";
                        cod2 += "add\n";
                        
                        cod2 += "2\n";
                        cod2 += "set_global $calc\n";
                        
                        cod2 += "$l1";
                        cod2 += "\n\n\nget_local 0\n";
                        cod2 += simbolo.direccion+"\n";
                        cod2 += "add\n";
                        cod2 += "get_local $calc\n";
                        cod2 += "1\n";
                        cod2 += "add\n";
                        cod2 += "get_global $calc\n\n";
                        
                        cod2 += "\n\n\nget_local 0\n";
                        cod2 += simbolo.direccion+"\n";
                        cod2 += "add\n";
                        cod2 += "get_local $calc\n";
                        cod2 += "get_global $calc\n\n";
                        
                        cod2 += "lt\n";
                        cod2 += "br_if $l3\n";
                        cod2 += "br $l2\n";
                        cod2 += "$l2\n";
                            
                            cod2 += "\n\n\nget_local 0\n";
                            cod2 += simbolo.direccion+"\n";
                            cod2 += "add\n";
                            cod2 += "get_local $calc\n";
                            
                            cod2 += "\n\n\nget_local 0\n";
                            cod2 += simbolo.direccion+"\n";
                            cod2 += "add\n";
                            cod2 += "get_local $calc\n";
                            cod2 += "1\n";
                            cod2 += "add\n";
                            cod2 += "get_global $calc\n\n";
                            cod2 += "add\n";
                            cod2 += (int)nulo+"\n\n";
                            cod2 += "set_global $calc\n\n";
                            
                            cod2 += "\n\n\nget_local 0\n";
                            cod2 += simbolo.direccion+"\n";
                            cod2 += "add\n";
                            cod2 += "get_local $calc\n";
                            cod2 += "1\n";
                            cod2 += "add\n";
                            
                            cod2 += "\n\n\nget_local 0\n";
                            cod2 += simbolo.direccion+"\n";
                            cod2 += "add\n";
                            cod2 += "get_local $calc\n";
                            cod2 += "1\n";
                            cod2 += "add\n";
                            cod2 += "get_global $calc\n\n";
                            
                            cod2 += "1\n";
                            cod2 += "add\n";
                            
                            cod2 += "set_global $calc\n\n";
                            cod2 += "br $l1\n\n";
                        cod2 += "$l3\n\n";
                        cod2 += "\n\n\nget_local 0\n";
                        cod2 += simbolo.direccion+"\n";
                        cod2 += "add\n";
                        cod2 += "get_local $calc\n";
                        
                        cod2 += "1\n";
                        cod2 += "add\n";
                        
                        cod2 += "2\n";
                        cod2 += "set_global $calc\n";
                        
                        last.add(cod2);
                }
            }
            
            
        }
        return 0;
    }

}
