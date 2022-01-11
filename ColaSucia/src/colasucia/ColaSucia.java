/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colasucia;

/**
 *
 * @author iaoco
 */
public class ColaSucia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        VistaJuego ventana = new VistaJuego("Cola Sucia");
        Mazo mazo = new Mazo();
        FinDelJuego fin = new FinDelJuego();
        Logica logi = new Logica(ventana, mazo,fin);
        logi.iniciar();
    }
    
}
