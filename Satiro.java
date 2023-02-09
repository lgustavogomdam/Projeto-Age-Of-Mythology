package trabalho01poo;

import java.util.Iterator;
import java.util.LinkedList;

public class Satiro extends Atlante{
    public Satiro(String nome, int idade, double peso) {
        super(nome, idade, peso, 5);
    }

    @Override
    public void atacar(LinkedList<Guerreiro> listaOponente, LinkedList<Guerreiro> listaGuerreiro) {

        int i = 0;
        int tam = listaOponente.size();
        Guerreiro oponente = listaOponente.get(i);

        //se não estiver morto e não tiver atacado, então ataca
        if (this.getEnergia() > 0 && this.getAtacou() == false) {

            while(i < tam) {
                oponente = listaOponente.get(i);
                oponente.setEnergia(oponente.getEnergia() - this.getPoderAtaque());
                i++;
            }
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
    Sátiro: são guerreiros que utilizam lanças para atacar a distância. Quando atacam tiram
    apenas 5 pontos de energia, entretanto acertam todos os guerreiros da fila adversária
 */