package trabalho01poo;

import java.util.LinkedList;

public class Prometeano extends Atlante{
    public Prometeano(String nome, int idade, double peso, int QT_Mortes) {
        super(nome, idade, peso,10);
        this.QT_Mortes = QT_Mortes;
    }

    private static int QT_Mortes;

    public int getQT_Mortes() {
        return this.QT_Mortes;
    }

    public void setQT_Mortes(int novoParticionamento) {
        this.QT_Mortes = novoParticionamento;
    }

    @Override
    public void atacar(LinkedList<Guerreiro> listaOponente, LinkedList<Guerreiro> listaGuerreiro) {

        if (this.getEnergia() > 0 && this.getAtacou() == false) {

            Guerreiro oponente = listaOponente.get(0);

            oponente.setEnergia(oponente.getEnergia() - this.getPoderAtaque()) ;
        }
    }

    @Override
    public void receberAtaque(LinkedList<Guerreiro> listaOponente,LinkedList<Guerreiro> listaGuerreiro, int energiaOriginal) {

        Guerreiro combatente = listaGuerreiro.get(0);

        //se tiver morrido o objeto se remove da fila
        if(this.getEnergia() == 0){

            this.setQT_Mortes(getQT_Mortes() + 1);

            for(int j = 0;j < this.getQT_Mortes(); j++) {
                energiaOriginal *= 0.5;
            }

            for(int i = 1;i < 3;i++) {

                if (energiaOriginal >= 1) {

                    listaGuerreiro.addLast(new Prometeano("Lan" + i, listaGuerreiro.getLast().getIdade(), listaGuerreiro.getLast().getPeso(),this.getQT_Mortes()));
                    combatente = listaGuerreiro.getLast();
                    combatente.setEnergia(energiaOriginal);

                }
            }

            listaGuerreiro.remove(0);


        //se não tiver morrido, o objeto se remove do inicio da fila e vai para o final
        }else {

//            if (listaOponente.get(0).getClass().getSimpleName().equals("Ciclope")) {
//                listaGuerreiro.remove(0);
//                this.setAtacou(false);
//                listaGuerreiro.addFirst(combatente);
//            } else {
//
                listaGuerreiro.remove(0);
                this.setAtacou(false);
                listaGuerreiro.addLast(combatente);

        }
    }
}
/*
    Prometeano: são guerreiros de barro que se dividem em 2 quando morrem (cada um com
    50% da energia original do prometeano e ambos colocados no final da fila do prometeano
    original). Quando um prometeano chega a 1 ponto de energia, quando morre ele
    efetivamente é eliminado. O ataque de um prometeano é de 10 unidades de energia. Peso e
    idade passam do prometado morto para seus descendentes.
*/
