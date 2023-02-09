package trabalho01poo;

import java.util.Iterator;
import java.util.LinkedList;

public class Mumia extends Egipcio{
    public Mumia(String nome, int idade, double peso) {
        super(nome, idade, peso, 50);
    }

    @Override
    public void atacar(LinkedList<Guerreiro> listaOponente, LinkedList<Guerreiro> listaGuerreiro) {

        if (this.getEnergia() > 0 && this.getAtacou() == false) {

            Guerreiro oponente = listaOponente.get(0);

            oponente.setEnergia(oponente.getEnergia() - this.getPoderAtaque());

            if(oponente.getEnergia() == 0){
                listaGuerreiro.add(new Mumia(oponente.getNome(), oponente.getIdade(), oponente.getPeso()));
                Guerreiro mortoVivo = listaGuerreiro.getLast();
                mortoVivo.setPoderAtaque(5);
            }
        }

    }

    @Override
    public void receberAtaque(LinkedList<Guerreiro> listaOponente,LinkedList<Guerreiro> listaGuerreiro, int energiaPrometeanoAntigo) {

        Guerreiro combatente = listaGuerreiro.get(0);

        //se tiver morrido o objeto se remove da fila
        if(combatente.getEnergia() == 0){
            listaGuerreiro.remove(0);
            for(int i=0; i < 4; i++)
                listaGuerreiro.add(new Anubita("AnubitaAliada" + i, 0, 60));

        //se não tiver morrido, o objeto se remove do inicio da fila e vai para o final
        }else {
            this.setAtacou(false);
            listaGuerreiro.remove(0);
            listaGuerreiro.add(combatente);
        }
    }
}

/*
    Múmia: são antigos faraós mortos. Possuem ataque de 50 pontos de energia. Quando mata
    um adversário gera um morto vivo e acrescenta em sua fila. Esse morto vivo possui ataque
    de 5 pontos de energia e começa com 100 pontos de energia (assim como a maioria dos
    guerreiros). Quando uma Múmia morre ela invoca 4 Anubitas para vinga-la (sendo
    colocadas no final da fila de seus aliados). O morto-vivo “nasce” com o nome, idade e peso
    do guerreiro adversário morto. Já os Anubitas vingadores “nascem” com o nome da múmia
    morta, idade = 0 e peso = 60.
 */