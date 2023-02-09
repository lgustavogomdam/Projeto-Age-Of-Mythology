package trabalho01poo;

import java.util.Iterator;
import java.util.LinkedList;

public class Hidra extends Grego{

    private int cabecas;

    public Hidra(String nome, int idade, double peso) {
        super(nome, idade, peso, 50);
        this.cabecas = 5;
    }

    public int getCabecas() {
        return this.cabecas;
    }

    public void setCabecas(int cabecasGerada) {
        this.cabecas = cabecasGerada;
    }

    @Override
    public void atacar(LinkedList<Guerreiro> listaOponente, LinkedList<Guerreiro> listaGuerreiro) {

        //se estiver vivo e não tiver atacado ainda
        if (this.getEnergia() > 0 && this.getAtacou() == false) {

            Guerreiro oponente = listaOponente.get(0);

            //realiza o ataque
            oponente.setEnergia(oponente.getEnergia() - this.getPoderAtaque());

            //Se matar o adversário, então ganha um buff no ataque, energia e numero de cabeças
            if(oponente.getEnergia() == 0){

                this.setCabecas(this.getCabecas() + 1);
                this.setPoderAtaque(this.getPoderAtaque() + 10);

                if((this.getEnergia() + 10) >= 100)
                    this.setEnergia(100);
                else
                    this.setEnergia(this.getEnergia() + 10);
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
    Hidra: parece um dinossauro aquático, ganha uma cabeça para cada inimigo que mata. Seu
    ataque inicial é de 50 pontos de energia, mas ganha mais 10 pontos de ataque para cada
    cabeça nova gerada, além de mais 10 pontos de recuperação de energia para si mesmo (se a
    hidra não tiver sido atacada ainda, ou seja, tiver os 100 pontos de energia, nada acontece).
 */