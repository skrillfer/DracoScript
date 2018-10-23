/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ide_draco;

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
        try {
            // TODO code application logic here

            new Interprete.Interpretacion().iniciar_interpretacion();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IDE_DRACO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
