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
public class CartaNormal extends Carta{

    private int numero;
    
     public CartaNormal(TipoCarta tipo, int numero) {
        super(tipo);
        this.numero=numero;
    }
    

    public int getNumero() {
        return numero;
    }
     
}
