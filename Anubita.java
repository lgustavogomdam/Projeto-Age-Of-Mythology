package trabalho01poo;

import java.util.Iterator;
import java.util.LinkedList;

public class Anubita extends Egipcio{
    public Anubita(String nome, int idade, double peso) {
        super(nome, idade, peso, 15);
    }

    @Override
    public void atacar(LinkedList<Guerreiro> listaOponente, LinkedList<Guerreiro> listaGuerreiro) {

        //se não estiver morto e não tiver atacado, então ataca
        if (this.getEnergia() > 0 && this.getAtacou() == false) {

            Guerreiro oponente = listaOponente.get(0);

            Guerreiro ultimoOponente = listaOponente.getLast();

            oponente.setEnergia(oponente.getEnergia() - this.getPoderAtaque());

            if(listaOponente.size() > 1)
                ultimoOponente.setEnergia(ultimoOponente.getEnergia() - this.getPoderAtaque());
        }
    }

    @Override
    public void receberAtaque(LinkedList<Guerreiro> listaOponente,LinkedList<Guerreiro> listaGuerreiro, int energiaPrometeanoAntigo) {

        Guerreiro combatente = listaGuerreiro.get(0);

        //se tiver morrido o objeto se remove da fila
        if(combatente.getEnergia() == 0){
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
    Anubita: possui ataque de 15 pontos de energia, mas ataca 2 vezes. Ataca o primeiro
    guerreiro e depois salta para o final da fila e ataca o último guerreiro da fila adversária
*/