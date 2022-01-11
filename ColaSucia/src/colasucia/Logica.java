/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colasucia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author iaoco
 */
public class Logica {
    
    private int puntaje=0;
    private VistaJuego vista;
    private Mazo mazo;
    private int cartasEnMazo=50;
    private FinDelJuego fin;
    
    public Logica (VistaJuego vista, Mazo mazo, FinDelJuego fin)
    {
        this.vista=vista;
        this.mazo=mazo;
        this.fin=fin;
    }
    
        public void iniciar() 
    {
        this.vista.BotonTomarListener(new BotonTomarListener());
        this.fin.BotonFinalListener(new BotonFinalListener());
        this.vista.setVisible(true);
        mostrarPuntaje(puntaje);
    }
    
    public int getPuntaje()
    {
        return puntaje;
    }
    
            public void mostrarPuntaje(int puntaje)
        {
            this.vista.getPuntajeNum().setText(String.valueOf(puntaje));
        }
        
        public void tomarCarta()
        {
            
            Random rnd = new Random();
            int randomNum = rnd.nextInt(cartasEnMazo);
            this.mazo.getCarta(randomNum);
            nombreCarta(randomNum, this.mazo.chequeoTipo(randomNum));
            unoOro(this.mazo.chequeoTipo(randomNum) , this.mazo.getValor(randomNum));
            this.mazo.quitarCarta(randomNum);
            cartasEnMazo = cartasEnMazo - 1;
        }
        
        public void unoOro (TipoCarta tipoQueToco, String valorQueToco)
        {
            if(tipoQueToco == TipoCarta.ORO && valorQueToco.contentEquals("1"))
            {
                this.fin.setVisible(true);
                this.vista.setVisible(false);
                this.mostrarPuntajeFinal(puntaje);
                //JOptionPane.showMessageDialog(null, "Fin del juego! Tu puntuación fue: "+ puntaje);
                puntaje= 0;
                this.mazo.vaciarMazo();
                this.mazo.llenarMazo();
                cartasEnMazo = 50;
            }
            else
            {
                puntaje = puntaje + 1;
                mostrarPuntaje(puntaje);
            }
        }
        
        public void nombreCarta(int numero, TipoCarta tipo)
        {
            if(tipo == TipoCarta.COMODIN)
            {
                this.vista.getCarta().setText("Comodín!");
            }
            else
            {
            this.vista.getCarta().setText(this.mazo.getValor(numero) + " de " + this.mazo.getTipoCarta(numero));
            }
        }
        
           public void mostrarPuntajeFinal (int puntaje)
        {
            this.fin.getPuntajeFinal().setText(String.valueOf(puntaje));
            puntaje = 0;
            mostrarPuntaje(puntaje);
        }
        
        private class BotonTomarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            tomarCarta();
            //puntaje= puntaje + 1;
        }
    }
        
        private class BotonFinalListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            fin.setVisible(false);
            vista.setVisible(true);
            //puntaje= puntaje + 1;
        }
    }
}
