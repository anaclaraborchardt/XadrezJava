import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tabuleiro tabuleiro = new Tabuleiro();

        Jogador jogador = new Jogador("Jorge", "Senh@123");
        Jogador jogador2 = new Jogador("Wilson", "wilson");


        jogador.setCor("Branco", tabuleiro);
        jogador2.setCor("Preto", tabuleiro);


        System.out.println(jogador.getPecas());
        System.out.println("\n"+jogador2.getPecas());
        System.out.println(tabuleiro.imprimirTabuleiro());

        //pergunta ao usuário qual a peça que deseja mover
        System.out.println("\nVamos começar o jogo\n");
        System.out.println("Escolha índice da peça");
        int escolhaPeca = sc.nextInt();
        Peca peca = tabuleiro.getPosicao().get(escolhaPeca).getPeca();

//        if (!jogador.getPecas().contains(peca)) {
//            System.out.println("Essa peça não pertence ao jogador ");
//        }

        System.out.println(peca);

        System.out.println(peca.possiveisMovimentos(tabuleiro));
        ArrayList<Posicao> posicoes = peca.possiveisMovimentos(tabuleiro);
        System.out.println(posicoes);
        System.out.println("Digite para qual índice deseja ir");
        int escolhaPosicao = sc.nextInt();

        if(peca instanceof Cavalo) {

        }
        System.out.println(validarVitoria(jogador2));
        System.out.println();

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
