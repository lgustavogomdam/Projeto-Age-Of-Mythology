package trabalho01poo;

import java.util.Iterator;
import java.util.LinkedList;

public class LoboDeFenris extends Nordico{

    public LoboDeFenris(String nome, int idade, double peso) {
        super(nome, idade, peso, 40);
    }

    @Override
    public void atacar(LinkedList<Guerreiro> listaOponente, LinkedList<Guerreiro> listaGuerreiro) {

        Guerreiro combatente = listaGuerreiro.get(0);
        int i = 1;

        if(this.getEnergia() > 0 && this.getAtacou() == false) {

            int lobosAliados = 0;
            Guerreiro oponente = listaOponente.get(0);

            //conta quantos lobos existem na fila do combatente
            while (i < listaGuerreiro.size() && i >= 0) {
                if (listaGuerreiro.get(i).getClass().getSimpleName().equals("LoboDeFenris")) {
                    lobosAliados++;
                    i++;
                }else
                    i = -1;

            }
            //seta o poder de ataque baseado no numero de lobos aliados, caso exista lobos aliados

            this.setPoderAtaque(combatente.getPoderAtaque() + (lobosAliados * (int)(0.2 * combatente.getPoderAtaque())));

            //realiza o ataque
            oponente.setEnergia(oponente.getEnergia() - combatente.getPoderAtaque());

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
    Lobo de Fenris: são lobos gigantes ferozes. Seu ataque é de 40 pontos de energia. Entretanto
    seu ataque aumenta em 20% para cada Lobo de Fenris que estiver atrás dele. Ou seja, se
    houverem 2 lobos na sequência na fila, o Lobo atual ganha mais 16 pontos de ataque (8 para
    cada lobo) totalizando 56 pontos de ataque.
 */
