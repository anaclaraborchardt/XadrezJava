import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tabuleiro tabuleiro = new Tabuleiro();

        Jogador jogador1 = new Jogador("Jorge", "Senh@123");
        Jogador jogador2 = new Jogador("Wilson", "wilson");


        jogador1.setCor("Branco", tabuleiro);
        jogador2.setCor("Preto", tabuleiro);
        Jogador jogadorAtual = jogador1;

        do {
            boolean pecaValida;
            if(jogadorAtual == jogador1){
                System.out.println("Jogador 1: é sua vez!");
            }else{
                System.out.println("Jogador 2: é sua vez");
            }
            System.out.println(tabuleiro.imprimirTabuleiro());
            Peca peca = null;

            do {
                System.out.println("Qual posição deseja mover? (Digite o índice da peça).");
                int escolhaPeca = sc.nextInt();
                peca = tabuleiro.getPosicao().get(escolhaPeca).getPeca();
                System.out.println(peca);

                if (jogadorAtual.getPecas().contains(peca)) {
                    pecaValida = true;
                } else {
                    System.out.println("Não é sua peça");
                    pecaValida = false;
                }
            } while (!pecaValida);

            ArrayList<Posicao> listaPosicoes = peca.possiveisMovimentos(tabuleiro);
            String posicoesMover = "\n";
            int indice = 0;
            for (Posicao posicao : listaPosicoes) {
                posicoesMover += indice + "-" + posicao + " " + tabuleiro.getPosicao().indexOf(posicao)+ "\n";
                indice++;
            }

            Posicao posicao;
            Peca pecaEscolhida = null;

                System.out.println("Digite para qual índice deseja ir");
                System.out.println(posicoesMover);
                int escolhaPosicao = sc.nextInt();
            posicao = listaPosicoes.get(escolhaPosicao);
                pecaEscolhida = tabuleiro.getPosicao().get(escolhaPosicao).getPeca();


                    ArrayList<Posicao> posicoes = peca.possiveisMovimentos(tabuleiro);
                    System.out.println(posicoes);
                    jogador1.moverPeca(peca, posicao, tabuleiro, jogador2);

                    if (jogadorAtual == jogador1) {
                        jogadorAtual = jogador2;
                    } else if (jogadorAtual == jogador2) {
                        jogadorAtual = jogador1;
                    }
                    validarVitoria(jogadorAtual);
        } while (true) ;

    }

    private static boolean validarVitoria(Jogador adversario){
        for(Peca peca: adversario.getPecas()){
            if(peca instanceof Rei){
                return false;
            }
        }
        return true;
    }

}




