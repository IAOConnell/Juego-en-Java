/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colasucia;

import java.util.ArrayList;

/**
 *
 * @author iaoco
 */
public class Mazo {
    
    private ArrayList<Carta> cartas;
    
    public Mazo()
    {
        this.cartas=new ArrayList<Carta>();
        llenarMazo();
    }
    
    public void llenarMazo()
    {
    this.cartas.add(new CartaComodin(TipoCarta.COMODIN));
    this.cartas.add(new CartaComodin(TipoCarta.COMODIN));

    for(int i=1; i<=12; i++)
    {
     this.cartas.add(new CartaNormal(TipoCarta.BASTO,i));
    }
    for(int i=1; i<=12; i++)
    {
     this.cartas.add(new CartaNormal(TipoCarta.ORO,i));
    }
    for(int i=1; i<=12; i++)
    {
     this.cartas.add(new CartaNormal(TipoCarta.ESPADAS,i));
    }
    for(int i=1; i<=12; i++)
    {
     this.cartas.add(new CartaNormal(TipoCarta.COPAS,i));
    }
    }
    
    public Carta getCarta(int numero)
    {
        return this.cartas.get(numero);
    }
    
    public TipoCarta chequeoTipo(int numero)
    {
        return this.cartas.get(numero).getTipo();
    }
    public String getTipoCarta(int numero)
    {
        String tipo = this.cartas.get(numero).getTipo().name();
        return tipo;
    }
    
    public String getValor(int numero)
    {
        String num = "";
        if (this.cartas.get(numero).getTipo() != TipoCarta.COMODIN)
        {
        CartaNormal cn = (CartaNormal)this.cartas.get(numero);
        num= String.valueOf(cn.getNumero());
        }
        Carta carta = new Carta(this.cartas.get(numero).getTipo());

        return num;
    }
    
    public void vaciarMazo()
    {
        this.cartas.clear();
    }
    
    public void quitarCarta(int numero)
    {
        this.cartas.remove(numero);
    }
}
