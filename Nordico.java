package trabalho01poo;

import java.util.LinkedList;

public abstract class Nordico extends Guerreiro{

    public Nordico(String nome, int idade, double peso, int poderAtaque) {
        super(nome, idade, peso, poderAtaque);
    }

    public abstract void atacar(LinkedList<Guerreiro> listaOponente, LinkedList<Guerreiro> listaGuerreiro);

    public abstract void receberAtaque(LinkedList<Guerreiro> listaOponente,LinkedList<Guerreiro> listaGuerreiro, int energiaPrometeanoAntigo);
}
