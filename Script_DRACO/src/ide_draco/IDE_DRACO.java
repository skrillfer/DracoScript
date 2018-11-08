/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ide_draco;

import INTERPRETE_PILA.Ejecutor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernando
 */
public class IDE_DRACO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        
        
        Interprete.Interpretacion ttt = new Interprete.Interpretacion();
        ttt.iniciar_interpretacion();
        
        
    }
    
    public void potencia(double base, double exponente)
    {
        double resultado = 0;
        if(exponente%1==0)
        {
            resultado = base;
            for (int i = 1; i < exponente; i++) {
                resultado *= base;
            }
        }else 
        {
            double tmp = base;
            while(tmp%1!=0)
            {
                tmp = tmp * 10;
            }
            //ya extraje el numero
            System.out.println("tmp:"+tmp);
        }
        System.out.println("resultado:"+resultado);
    }
}
