import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static boolean vitoria = false;
    static int jogador = 1;

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

                if((escolhaPeca >= 8 && escolhaPeca <=15)||
                        ((escolhaPeca >= 48 && escolhaPeca <=55))
                && peca instanceof Peao){
                    Peao peao = (Peao) peca;
                    peao.setPrimeiroMovimento(true);
                }

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

                System.out.println("Digite para qual posição deseja ir");
                System.out.println(posicoesMover);
                int escolhaPosicao = sc.nextInt();

                //verifica se o índice escolhido é válido
                if(escolhaPosicao > (listaPosicoes.size()) - 1 ){
                    System.out.println("Essa posição não é válida");
                }else {
                    posicao = listaPosicoes.get(escolhaPosicao);

                    ArrayList<Posicao> posicoes = peca.possiveisMovimentos(tabuleiro);
                    System.out.println(posicoes);
                    jogador1.moverPeca(peca, posicao, tabuleiro, jogador2);

                    if (jogadorAtual == jogador1) {
                        jogadorAtual = jogador2;
                        jogador = 1;
                    } else if (jogadorAtual == jogador2) {
                        jogadorAtual = jogador1;
                        jogador = 2;
                    }
                    validarVitoria(jogadorAtual);
                    mostraVencedor(jogadorAtual);
                }
        } while (!vitoria) ;
        System.out.println("Jogo acabou");

    }

    private static boolean validarVitoria(Jogador jogadorAtual){
        for(Peca peca: jogadorAtual.getPecas()){
            if(peca instanceof Rei){
                return false;
            }
        }
        return true;
    }

    //precisa fazer xeque-mate
    private static void mostraVencedor(Jogador jogadorAtual){
        if(validarVitoria(jogadorAtual)== false){
            System.out.println("Ainda não há vencedor!");
            vitoria = false;
        }else{
            System.out.println("O vencedor é o jogador "+ jogador);
            vitoria=true;
        }
    }


}




