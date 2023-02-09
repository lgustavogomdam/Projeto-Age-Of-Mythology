/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho01poo;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author GustavoGomdam
 */

public class Ciclope extends Grego{

    public Ciclope(String nome, int idade, double peso) {
        super(nome, idade, peso, 40);
    }

    @Override
    public void atacar(LinkedList<Guerreiro> listaOponente, LinkedList<Guerreiro> listaGuerreiro) {

        if(this.getEnergia() > 0 && this.getAtacou() == false){

            Guerreiro oponente = listaOponente.get(0);

            //realiza o ataque
            oponente.setEnergia(oponente.getEnergia() - this.getPoderAtaque());
            this.setAtacou(true);

            //se o oponente ainda não atacou, remove o oponente do inicio da fila e
            // lança para o fim dela e não o permite atacar
        }
    }

    @Override
    public void receberAtaque(LinkedList<Guerreiro> listaOponente,LinkedList<Guerreiro> listaGuerreiro, int energiaPrometeanoAntigo){

        Guerreiro combatente = listaGuerreiro.get(0);

        //se tiver morrido o objeto se remove da fila
        if(this.getEnergia() == 0){
            listaGuerreiro.remove(0);

        //se não tiver morrido, o objeto se remove do inicio da fila e vai para o final
        }else {
            this.setAtacou(false);
            listaGuerreiro.remove(0);
            listaGuerreiro.add(combatente);
        }
    }

}

/*
    Ciclope: um gigante de um olho só. Promove um ataque que retira 40 pontos de energia e
    depois “joga” o adversário para o final de sua fila

    DUVIDA: (na prática se for o primeiro a atacar não
    vai permitir que o adversário ataque, se for o segundo, esse efeito não terá qualquer impacto
    no que refere a dano ao adversário).
*/