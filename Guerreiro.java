/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho01poo;

import java.util.LinkedList;

/**
 *
 * @author GustavoGomdam
 */
public abstract class Guerreiro {

    private String nome;
    private int idade;
    private double peso;
    private int energia = 100;
    private int poderAtaque;
    private boolean atacou;

    public Guerreiro(String nome, int idade,  double peso, int poderAtaque){
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.poderAtaque = poderAtaque;
        this.atacou = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int setaEnergia) {
        if(setaEnergia <= 0)
            this.energia = 0;
        else
            this.energia = setaEnergia;
    }

    public int getPoderAtaque(){
        return this.poderAtaque;
    }

    public void setPoderAtaque(int incrementaPoderAtaque){
        this.poderAtaque = incrementaPoderAtaque;
    }

    public boolean getAtacou() {
        return atacou;
    }

    public void setAtacou(boolean atacou) {
        this.atacou = atacou;
    }

    public abstract void atacar(LinkedList<Guerreiro> listaOponente, LinkedList<Guerreiro> listaGuerreiro);

    public abstract void receberAtaque(LinkedList<Guerreiro> listaOponente, LinkedList<Guerreiro> listaGuerreiro, int energiaPrometeanoAntigo);

}
