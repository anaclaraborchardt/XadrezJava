import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Tabuleiro tabuleiro = new Tabuleiro();
        Jogador jogador = new Jogador("Jorge", "Senh@123");
        Jogador jogador2 = new Jogador("Wilson", "wilson");


        jogador.setCor("Branco", tabuleiro);
        jogador2.setCor("Branco", tabuleiro);


        System.out.println(jogador.getPecas());
        System.out.println("\n"+jogador2.getPecas());
 
        int escolhaPeca = sc.nextInt();
        Peca peca = jogador.getPecas().get(escolhaPeca);
        System.out.println(peca);
        System.out.println(peca.possiveisMovimentos(tabuleiro));
        ArrayList<Posicao> posicoes = peca.possiveisMovimentos(tabuleiro);
        System.out.println(posicoes);
        int escolhaPosicao = sc.nextInt();
        Posicao posicao = posicoes.get(escolhaPosicao);
        jogador.moverPeca(peca,posicao, tabuleiro, jogador2 );
        System.out.println(validarVitoria(jogador2));

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
