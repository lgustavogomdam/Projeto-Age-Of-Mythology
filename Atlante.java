package trabalho01poo;

import java.util.LinkedList;

public abstract class Atlante extends Guerreiro{

    public Atlante(String nome, int idade, double peso, int poderAtaque) {
        super(nome, idade, peso, poderAtaque);
    }

    @Override
    public abstract void atacar(LinkedList<Guerreiro> listaOponente, LinkedList<Guerreiro> listaGuerreiro);

    @Override
    public abstract void receberAtaque(LinkedList<Guerreiro> listaOponente,LinkedList<Guerreiro> listaGuerreiro, int energiaPrometeanoAntigo);

}
