/*
        Trabalho de POO I
        Aluno: Luiz Gustavo Gomes Damasceno & Pedro Caliman Cecato
        Instituto Federal do Espírito Santo - Campus Colatina
*/

package trabalho01poo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Trabalho01POO {

    public static LinkedList<Guerreiro> lerListaX() throws FileNotFoundException{

        LinkedList<Guerreiro> listaX = new LinkedList();

        try{

            FileInputStream file = new FileInputStream("listaX.txt");

            Scanner scan = new Scanner(file);

            int tipoElemento;
            String nomeElemento;
            int idadeElemento;
            double pesoElemento;

            while(scan.hasNext()){

                tipoElemento = scan.nextInt();
                nomeElemento = scan.next();
                idadeElemento = scan.nextInt();
                pesoElemento = scan.nextDouble();

                Guerreiro guerreiro;

                switch(tipoElemento){

                    case 1:
                        guerreiro = new Ciclope(nomeElemento,idadeElemento,pesoElemento);
                    break;

                    case 2:
                        guerreiro = new LeaoDaNemeia(nomeElemento,idadeElemento,pesoElemento);
                    break;

                    case 3:
                        guerreiro = new Hidra(nomeElemento,idadeElemento,pesoElemento);
                    break;

                    case 4:
                        guerreiro = new Valquiria(nomeElemento,idadeElemento,pesoElemento);
                    break;

                    default:
                        guerreiro = new LoboDeFenris(nomeElemento,idadeElemento,pesoElemento);
                    break;
                }

                listaX.add(guerreiro);
            }

            scan.close();
            file.close();

        }catch(FileNotFoundException ex){
            System.out.println("Tentativa falha de leitura de arquivo lado X");
        } catch (IOException e) {
            System.out.println("Houve um erro na Entrada e Saída dos dados (Arquivo não pôde ser fechado");
        }


        return listaX;
    }

    public static LinkedList<Guerreiro> lerListaY() throws FileNotFoundException{

        LinkedList<Guerreiro> listaY = new LinkedList();

        try{

            FileInputStream file = new FileInputStream("listaY.txt");

            Scanner scan = new Scanner(file);

            int tipoElemento;
            String nomeElemento;
            int idadeElemento;
            double pesoElemento;

            Guerreiro guerreiro;

            while(scan.hasNext()){

                tipoElemento = scan.nextInt();
                nomeElemento = scan.next();
                idadeElemento = scan.nextInt();
                pesoElemento = scan.nextDouble();

                switch(tipoElemento){

                    case 1:
                        guerreiro = new Prometeano(nomeElemento,idadeElemento,pesoElemento, 0);
                    break;

                    case 2:
                        guerreiro = new Satiro(nomeElemento,idadeElemento,pesoElemento);
                    break;

                    case 3:
                        guerreiro = new Argus(nomeElemento,idadeElemento,pesoElemento);
                    break;

                    case 4:
                        guerreiro = new Anubita(nomeElemento,idadeElemento,pesoElemento);
                    break;

                    default:
                        guerreiro = new Mumia(nomeElemento,idadeElemento,pesoElemento);
                    break;
                }

                listaY.add(guerreiro);
            }

            scan.close();
            file.close();

        }catch(FileNotFoundException ex){
            System.out.println("Tentativa falha de leitura de arquivo lado Y");
        } catch (IOException e) {
            System.out.println("Houve um erro na Entrada e Saída dos dados (Arquivo não pôde ser fechado");
        }

        return listaY;
    }

    public static double somaPesoElementos(LinkedList<Guerreiro> lista){

        Guerreiro guerreiro;
        double soma = 0;
        int i = 0;

        Iterator it = lista.iterator();

        while(it.hasNext()){

            guerreiro = (Guerreiro) it.next();
            soma += guerreiro.getPeso();

        }

        return soma;
    }

    public static Guerreiro maisVelhoDaBatalha(LinkedList<Guerreiro> listaX, LinkedList<Guerreiro> listaY) {

        Iterator it = listaX.iterator();

        Guerreiro maisVelho = (Guerreiro) it.next();
        Guerreiro indiceAtual = null;

        while(it.hasNext()){

            indiceAtual = (Guerreiro) it.next();
            if(indiceAtual.getIdade() >= maisVelho.getIdade())
                maisVelho = indiceAtual;

        }

        it = listaY.iterator();

        while(it.hasNext()){

            indiceAtual = (Guerreiro) it.next();
            if(indiceAtual.getIdade() >= maisVelho.getIdade())
                maisVelho = indiceAtual;

        }

        return maisVelho;
    }

    public static void SaídaListas(LinkedList<Guerreiro> listaX, LinkedList<Guerreiro> listaY,
                                                Guerreiro combatenteX, Guerreiro combatenteY){

        int tamX, tamY, j = 0, i = 0;

        tamX = listaX.size();
        tamY = listaY.size();

        while(i < tamX || j < tamY){

            if(i < tamX){

                combatenteX = listaX.get(i);
                System.out.print("\t" + combatenteX.getClass().getSimpleName() + "--");
                System.out.print(combatenteX.getNome() + " "); //nome
                System.out.print(combatenteX.getPoderAtaque() + " "); //poder de ataque
                System.out.print(combatenteX.getEnergia() + " "); // energia
                System.out.print(combatenteX.getIdade() + " "); //idade
                System.out.print(combatenteX.getPeso() + " "); //peso
                System.out.print("\tV/S\t");

            }else{
                System.out.println("\tOponente Inexistente");
            }

            if(j < tamY){

                combatenteY = listaY.get(j);

                if(i < tamX)
                    System.out.print("\t" + combatenteY.getClass().getSimpleName() + "--");
                else
                    System.out.print("\t\t\t\t\t\t\t\t\t" + combatenteY.getClass().getSimpleName() + "--");

                System.out.print(combatenteY.getNome() + " "); //nome
                System.out.print(combatenteY.getPoderAtaque() + " "); //poder de ataque
                System.out.print(combatenteY.getEnergia() + " "); //energia
                System.out.print(combatenteY.getIdade() + " "); //idade
                System.out.print(combatenteY.getPeso() + "\n" ); //peso

            }else{
                System.out.println("\tOponente Inexistente");
            }

            i++;
            j++;
        }
    }

    public static Guerreiro ladoVencedor(LinkedList<Guerreiro> listaX, LinkedList<Guerreiro> listaY){

        Guerreiro vencedor = null;

        if(listaX.isEmpty()){
            vencedor = listaY.getLast();
            System.out.println("Egípcios e Atlantes venceram.");
        } else {
            vencedor = listaX.getLast();
            System.out.println("Gregos e Nórdicos venceram.");
        }

        return vencedor;
    }

    public static Guerreiro Batalha(LinkedList<Guerreiro> listaX, LinkedList<Guerreiro> listaY){

//        System.out.println("\n================| BATALHA AGE OF MITHOLOGY |================ ");

        Random gerador = new Random();

        int indX = 0, indY = 0;
        int energiaOriginalPrometeano = 0;

        Guerreiro combatenteX = null;
        Guerreiro combatenteY = null;

        while((listaX.isEmpty() != true) && (listaY.isEmpty() != true)){


            //se o gerador randômico der 0 então lista X ataca primeiro
            if(gerador.nextInt(2) % 2 == 0) {

                combatenteX = listaX.get(0);
                combatenteY = listaY.get(0);

//                System.out.println("\n\n======|GREGOS E NÓRDICOS ATACAM PRIMEIRO!");
//
//                System.out.println("\n====|LISTA X VERSUS LISTA Y ANTES DO ATAQUE:\n");
//
//                SaídaListas(listaX, listaY, combatenteX, combatenteY);

                combatenteX.atacar(listaY, listaX);

                if (combatenteY.getClass().getSimpleName().equals("Prometeano")) {
                    if(listaY.get(0).getEnergia() >= 100)
                        energiaOriginalPrometeano = listaY.get(0).getEnergia();
                    else
                        energiaOriginalPrometeano = 100;
                }

                if (combatenteX.getClass().getSimpleName().equals("Ciclope")) {

                    combatenteY.receberAtaque(listaX, listaY, energiaOriginalPrometeano);
                    combatenteX.receberAtaque(listaY, listaX, energiaOriginalPrometeano);

                }else {
                    combatenteY.atacar(listaX, listaY);
                    combatenteY.receberAtaque(listaX, listaY, energiaOriginalPrometeano);
                    combatenteX.receberAtaque(listaY, listaX, energiaOriginalPrometeano);
                }

//                System.out.println("\n\n====|LISTA X VERSUS LISTA Y DEPOIS DO ATAQUE:\n");
//
//                SaídaListas(listaX, listaY, combatenteX, combatenteY);

                indX++;
                indY++;

            }else{

                combatenteX = listaX.get(0);
                combatenteY = listaY.get(0);

//                System.out.println("\n\n======|EGÍPCIOS E ATLANTES ATACAM PRIMEIRO!");
//
//                System.out.println("\n====|LISTA X VERSUS LISTA Y ANTES DO ATAQUE:\n");
//
//                SaídaListas(listaX, listaY, combatenteX, combatenteY);

                if (listaY.get(0).getClass().getSimpleName().equals("Prometeano")) {
                    if(listaY.get(0).getEnergia() >= 100)
                        energiaOriginalPrometeano = listaY.get(0).getEnergia();
                    else
                        energiaOriginalPrometeano = 100;
                }

                combatenteY.atacar(listaX, listaY);
                combatenteX.atacar(listaY, listaX);
                combatenteX.receberAtaque(listaY, listaX, energiaOriginalPrometeano);
                combatenteY.receberAtaque(listaX, listaY, energiaOriginalPrometeano);

//                System.out.println("\n====|LISTA X VERSUS LISTA Y DEPOIS DO ATAQUE:\n");
//
//                SaídaListas(listaX, listaY, combatenteX, combatenteY);

                indX++;
                indY++;

            }

//            if((listaX.isEmpty() != true) && (listaY.isEmpty() != true))
//                System.out.println("\n\n==========================|PRÓXIMA RODADA|==========================");

        }

//        System.out.println("\n\n==========================|FIM DA BATALHA|==========================");

        if(listaX.isEmpty())
            return combatenteX;
        else
            return combatenteY;
    }

    public static void main(String []args) {

        Guerreiro maisVelho;
        double soma;

        try {

            LinkedList<Guerreiro> listaX = lerListaX();
            LinkedList<Guerreiro> listaY = lerListaY();

            //Questão I
                soma = somaPesoElementos(listaX);
                System.out.println("Gregos e Nórdicos pesam - " + soma + " unidades");

                soma = somaPesoElementos(listaY);
            System.out.println("Atlantes e Egípcios pesam - " + soma + " unidades");

            //Questão II

                maisVelho = maisVelhoDaBatalha(listaX,listaY);
                System.out.println(maisVelho.getNome() + " eh o mais velho");

            //Questão III

                Guerreiro perdedor = Batalha(listaX,listaY);
                Guerreiro vencedor = ladoVencedor(listaX,listaY);

            //Questão IV

                System.out.println(perdedor.getNome() + ", " + perdedor.getIdade() + ", " + perdedor.getPeso());

            //Questão V

                System.out.println(vencedor.getNome() + ", " + vencedor.getIdade() + ", " + vencedor.getPeso());

        } catch (NoSuchElementException | FileNotFoundException ex){

            //e.getMessage();
            System.out.println("Arquivo(os) não encontrado(os)");
            System.out.println("O programa não poderá continuar pois depende de arquivos que não puderam ser lidos");

        }
    }
}

/*
    Questões:

        a) (5 pontos) Determine a soma dos pesos dos lados:
            Ex: Gregos e Nórdicos pesam - 302 unidades
                Atlantes e Egípcios pesam - 80 unidades

        b) (5 pontos) A maior idade dentre todos os guerreiros (de ambos lados)
            Ex: Tark é o mais velho (60 unidades)

        c) (10 pontos) O lado vencedor.
            Ex: Gregos e Nórdicos venceram.

        d) (10 pontos) Os dados do ultimo membro do lado perdedor.
            Ex: Lan, 40, 30

        e) (10 pontos) Os dados do guerreiro, do lado vencedor, que transferiu o último
        ataque no último guerreiro do lado perdedor.
            Ex: Full, 23, 77

    Saída de dados:

        Gregos e Nórdicos pesam - <x> unidades
        Atlantes e Egípcios pesam - <y> unidades
        <nome> é o mais velho
        <lado1 ou lado2> venceram
        <nome perdedor >,<idade perdedor >,<peso perdedor >
        <nome vencedor >,<idade vencedor >,<peso vencedor >

    Exemplo:

        Gregos e Nórdicos pesam - 302 unidades
        Atlantes e Egípcios pesam - 80 unidades
        Tark é o mais velho (60 unidades)
        Gregos e Nórdicos venceram.
        Lan, 40, 30
        Full, 23, 77

    Os dados da saída não são necessariamente compatíveis com os dados da entrada, ambos são
    apenas para facilitar a visualização do que é desejado.

    Data de Entrega: 20/10/2022 (23:55)

    Componentes por Grupo: 2

    Valor: 40 pontos (40 % da nota final) - Será feita entrevista para validação da
    implementação, a nota atribuída à dupla é a menor nota da dupla na entrevista.

    OBS1. NÃO SERÃO ACEITOS trabalhos entregues após essa data, sendo computado para
    tanto o VALOR 0 à nota.

    OBS2. Os códigos devem ser feitos na Linguagem Java.

 */