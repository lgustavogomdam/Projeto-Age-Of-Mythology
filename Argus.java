package trabalho01poo;

import java.util.Iterator;
import java.util.LinkedList;

public class Argus extends Atlante{
    public Argus(String nome, int idade, double peso) {
        super(nome, idade, peso, 10000);
        super.setEnergia(60);
    }

    @Override
    public void atacar(LinkedList<Guerreiro> listaOponente, LinkedList<Guerreiro> listaGuerreiro) {

        if (this.getEnergia() > 0 && this.getAtacou() == false) {

            Guerreiro oponente = listaOponente.get(0);

            oponente.setEnergia(0);
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
    Argus: guerreiro atlante monstruoso, ele ataca com uma bolha de ácido que mata o inimigo
    imediatamente independente da energia do inimigo. Argus também é frágil e sua energia
    começa em 60 pontos.
*/