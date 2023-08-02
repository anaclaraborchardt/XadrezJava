import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int jogadorAtual = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tabuleiro tabuleiro = new Tabuleiro();

        Jogador jogador = new Jogador("Jorge", "Senh@123");
        Jogador jogador2 = new Jogador("Wilson", "wilson");


        jogador.setCor("Branco", tabuleiro);
        jogador2.setCor("Preto", tabuleiro);


        System.out.println(jogador.getPecas());
        System.out.println("\n" + jogador2.getPecas());

        do {
            System.out.println("Jogador " + jogadorAtual);
            System.out.println(tabuleiro.imprimirTabuleiro());

            //pergunta ao usuário qual a peça que deseja mover
            System.out.println("\nVamos começar o jogo\n");
            System.out.println("Escolha índice da peça");
            int escolhaPeca = sc.nextInt();

            Peca peca = tabuleiro.getPosicao().get(escolhaPeca).getPeca();
            System.out.println(peca);

//        if (!jogador.getPecas().contains(peca)) {
//            System.out.println("Essa peça não pertence ao jogador ");
//        }


            System.out.println("Digite para qual índice deseja ir");
            int escolhaPosicao = sc.nextInt();

            //aqui ele analisa os possíveis movimentos das peças
            ArrayList<Posicao> posicoes = peca.possiveisMovimentos(tabuleiro);

//            ArrayList<Integer> indicesValidos = jogador.pegaIndice(jogadorAtual);
//            if (!indicesValidos.contains(escolhaPeca)){
//                System.out.println("não");
//            }else {
                //aqui ele verifica se aquele movimento é válido
                if (posicoes.contains(tabuleiro.getPosicao().get(escolhaPosicao))) {
                    //aqui ele move a peça baseando-se na posição escolhida
                    tabuleiro.getPosicao().get(escolhaPosicao).setPeca(peca);
                    //aqui ele remove a peça baseando-se na posição inicial
                    tabuleiro.getPosicao().get(escolhaPeca).setPeca(null);
                    jogador.atualizaIndices(jogadorAtual, escolhaPeca, escolhaPosicao);
                } else {
                    System.out.println("Movimento inválido");
                }
//            }
            System.out.println(validarVitoria(jogador2));
//            if (jogadorAtual == 1) {
//                jogadorAtual = 2;
//            } else if (jogadorAtual == 2) {
//                jogadorAtual = 1;
//            }

        }while(true);

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




