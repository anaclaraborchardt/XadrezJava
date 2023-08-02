import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int jogadorAtual = 1;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tabuleiro tabuleiro = new Tabuleiro();

        Jogador jogador1 = new Jogador("Jorge", "Senh@123");
        Jogador jogador2 = new Jogador("Wilson", "wilson");


        jogador1.setCor("Branco", tabuleiro);
        jogador2.setCor("Preto", tabuleiro);


        System.out.println(jogador1.getPecas());
        System.out.println("\n" + jogador2.getPecas());

        do {
            System.out.println("Jogador " + jogadorAtual);
            System.out.println(tabuleiro.imprimirTabuleiro());


                System.out.println("Qual posição deseja mover? (Digite o índice da peça).");
                int escolhaPeca = sc.nextInt();

                ArrayList<Integer> indicesValidos = jogador1.pegaIndice(jogadorAtual);

                if (!indicesValidos.contains(escolhaPeca)) {
                    System.out.println("Essa não é uma de suas peças");
                }

            Peca peca = tabuleiro.getPosicao().get(escolhaPeca).getPeca();
            System.out.println(peca);

//            if(conferePecas(jogador, peca)==true) {
                System.out.println("Digite para qual índice deseja ir");
                int escolhaPosicao = sc.nextInt();

                //aqui ele analisa os possíveis movimentos das peças
                ArrayList<Posicao> posicoes = peca.possiveisMovimentos(tabuleiro);

                //aqui ele verifica se aquele movimento é válido
                if (posicoes.contains(tabuleiro.getPosicao().get(escolhaPosicao))) {
                    //aqui ele move a peça baseando-se na posição escolhida
                    tabuleiro.getPosicao().get(escolhaPosicao).setPeca(peca);
                    //aqui ele remove a peça baseando-se na posição inicial
                    tabuleiro.getPosicao().get(escolhaPeca).setPeca(null);
                    if(jogadorAtual == 1) {
                        jogador1.atualizaIndices(jogadorAtual, escolhaPeca, escolhaPosicao);
                    }else{
                        jogador2.atualizaIndices(jogadorAtual, escolhaPeca, escolhaPosicao);
                    }
                } else {
                    System.out.println("Movimento inválido");
                }
//            }
            if (jogadorAtual == 1) {
                jogadorAtual = 2;
            } else if (jogadorAtual == 2) {
                jogadorAtual = 1;
            }
            System.out.println(validarVitoria(jogador2));

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

//    private static boolean conferePecas(Jogador jogador, Peca peca){
//        if(jogador.getPecas().contains(peca)) {
//            return true;
//        }return false;
//    }
}




