package trabalho01poo;

import java.util.Iterator;
import java.util.LinkedList;

public class LeaoDaNemeia extends Grego{

    public LeaoDaNemeia(String nome, int idade, double peso) {
        super(nome, idade, peso, 30);
    }

    @Override
    public void atacar(LinkedList<Guerreiro> listaOponente, LinkedList<Guerreiro> listaGuerreiro) {

        int tam = listaOponente.size();

        Guerreiro combatente = listaGuerreiro.get(0);

        if(combatente.getEnergia() > 0 && combatente.getAtacou() == false) {

            Guerreiro oponente = listaOponente.get(0);

            //realiza o ataque
            oponente.setEnergia(oponente.getEnergia() - this.getPoderAtaque());

            int subAtaque = 15;

            //verifica duas vezes se há aliados após o oponente na fila, se houver então promove os sub-ataques

            for(int j = 1; j <= 2;j++){

                if(listaOponente.size() >= 3){

                    oponente = listaOponente.get(j);
                    oponente.setEnergia(oponente.getEnergia() - subAtaque);
                    subAtaque = 5;

                }else if(listaOponente.size() >= 2){
                    oponente = listaOponente.get(j);
                    oponente.setEnergia(oponente.getEnergia() - subAtaque);
                    j = 3;
                }
            }

            this.setAtacou(true);
        }
    }

    @Override
    public void receberAtaque(LinkedList<Guerreiro> listaOponente,LinkedList<Guerreiro> listaGuerreiro, int energiaPrometeanoAntigo) {

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
    Leão da Nemeia: um leão muito forte e com rugido poderoso. Seu ataque é um grande
    rugido que não afeta apenas o adversário sendo atacado, mas também seu sucessor e quem
    sucedê-lo. Esse rugido afeta em 30 pontos de energia o adversário atacado, em 15 quem
    estiver atrás dele na fila e em 5 quem estiver na terceira posição.
*/
