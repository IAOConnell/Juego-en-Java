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
public class Carta {
    
    private TipoCarta tipo;
    
    public Carta (TipoCarta tipo)
    {
        this.tipo=tipo;
    }

    public TipoCarta getTipo() {
        return tipo;
    }

    public void setTipo(TipoCarta tipo) {
        this.tipo = tipo;
    }
    

    
}
