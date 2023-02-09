/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho01poo;

import java.util.LinkedList;

/**
 *
 * @author GustavoGomdam
 */

public abstract class Grego extends Guerreiro{

    public Grego(String nome, int idade, double peso, int poderAtaque) {
        super(nome, idade, peso, poderAtaque);
    }

    @Override
    public void setEnergia(int setaEnergia) {

        if(super.getEnergia() + 20 >= 100) {
            super.setEnergia(100);
        } else
            super.setEnergia(this.getEnergia() + 20);
    }

    public abstract void atacar(LinkedList<Guerreiro> listaOponente, LinkedList<Guerreiro> listaGuerreiro);
    public abstract void receberAtaque(LinkedList<Guerreiro> listaOponente,LinkedList<Guerreiro> listaGuerreiro, int energiaPrometeanoAntigo);
}
