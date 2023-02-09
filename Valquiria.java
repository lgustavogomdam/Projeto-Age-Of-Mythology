package trabalho01poo;

import java.util.Iterator;
import java.util.LinkedList;

public class Valquiria extends Nordico{

    public Valquiria(String nome, int idade, double peso) {
        super(nome, idade, peso, 20);
    }

    @Override
    public void atacar(LinkedList<Guerreiro> listaOponente, LinkedList<Guerreiro> listaGuerreiro) {

        if (this.getEnergia() > 0 && this.getAtacou() == false) {

            Guerreiro oponente = listaOponente.get(0);

            //realiza o ataque
            oponente.setEnergia(oponente.getEnergia() - this.getPoderAtaque());

            if(listaGuerreiro.size() >= 2) {

                Guerreiro aliado = listaGuerreiro.get(1);

                aliado.setEnergia(aliado.getEnergia() + 20);
            }

            this.setAtacou(true);
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
    Valquíria: é uma espécie de amazona montada num cavalo branco. Possuem poder de cura e
    seu ataque retira 20 pontos de energia. Após atacar, o aliado que estiver após ela, na fila,
    recupera 20 pontos de energia.
 */