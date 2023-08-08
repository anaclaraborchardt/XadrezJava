import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static boolean vitoria = false;
    static int jogador = 1;
    static boolean empate = false;
    static Scanner sc = new Scanner(System.in);
    static Tabuleiro tabuleiro = new Tabuleiro();

    static Jogador jogador1 = new Jogador("Jorge", "Senh@123");
    static Jogador jogador2 = new Jogador("Wilson", "wilson");
    static Jogador jogadorAtual = jogador1;

    public static void main(String[] args) {

        jogador1.setCor("Branco", tabuleiro);
        jogador2.setCor("Preto", tabuleiro);

        do {
            if (jogadorAtual == jogador1) {
                System.out.println("Jogador 1: é sua vez!");
                System.out.println(jogador1.getPecas());
            } else {
                System.out.println("Jogador 2: é sua vez");
                System.out.println(jogador2.getPecas());
            }
            System.out.println(tabuleiro.imprimirTabuleiro());
            menu();

        } while (!vitoria);
        System.out.println("Jogo acabou");

    }

    private static void partida(){
        boolean pecaValida;
        Peca peca = null;

        do {
            System.out.println("Qual posição deseja mover? (Digite o índice da peça).");
            int escolhaPeca = sc.nextInt();

            peca = tabuleiro.getPosicao().get(escolhaPeca).getPeca();

            if ((escolhaPeca >= 8 && escolhaPeca <= 15) ||
                    ((escolhaPeca >= 48 && escolhaPeca <= 55))
                            && peca instanceof Peao) {
                Peao peao = (Peao) peca;
                peao.setPrimeiroMovimento(true);
            }

            if (jogadorAtual.getPecas().contains(peca)) {
                pecaValida = true;
            } else {
                System.out.println("Não é sua peça");
                pecaValida = false;
            }

        }
        while (!pecaValida) ;

        ArrayList<Posicao> listaPosicoes = peca.possiveisMovimentos(tabuleiro);
        String posicoesMover = "\n";
        int indice = 0;
        for (Posicao posicao : listaPosicoes) {
            posicoesMover += indice + "-" + posicao + " " + tabuleiro.getPosicao().indexOf(posicao) + "\n";
            indice++;
        }

        Posicao posicao;

        System.out.println("Digite para qual posição deseja ir");
        System.out.println(posicoesMover);
        int escolhaPosicao = sc.nextInt();

        //verifica se o índice escolhido é válido
        if (escolhaPosicao > (listaPosicoes.size()) - 1) {
            System.out.println("Essa posição não é válida");
        } else {
            posicao = listaPosicoes.get(escolhaPosicao);

            ArrayList<Posicao> posicoes = peca.possiveisMovimentos(tabuleiro);
            System.out.println(posicoes);
            jogador1.moverPeca(peca, posicao, tabuleiro, jogador2);

            alternaJogador();

            validarVitoria(jogadorAtual);
            mostraVencedor(jogadorAtual);
        }
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

    public static void proporEmpate(){
        empate = true;
        System.out.println("Propor empate");
            if((jogadorAtual == jogador1) && (empate == true)){
                System.out.println("Jogador " + jogador + " propôs empate");
            }
            else if((jogadorAtual == jogador2) && (empate == true)){
                System.out.println("Jogador 2 propôs empate");
            }
            aceitarEmpate();
    }

    public static void aceitarEmpate(){
        alternaJogador();
        System.out.println("Jogador "+ jogador);
        System.out.println("\nDeseja aceitar o empate?\n" +
                "- [1] SIM\n" +
                "- [2] NÃO");
        int empateDecisao = sc.nextInt();

            switch(empateDecisao) {
                case 1:
                    System.out.println("Jogo finalizado ");
                    vitoria = true;
                    break;
                case 2:
                    System.out.println("Continue o jogo. O empate não foi aceito");

            }
    }

    public static void desistir(){
        System.out.println("Jogador " + jogador + " desistiu da partida");
        System.exit(0);
    }

    public static void menu(){
        int indice = 0;
        System.out.println("Selecione a opção desejada:\n" +
                "[1] - Escolher Peça\n" +
                "[2] - Propor Empate\n" +
                "[3] - Desistir");
       indice= sc.nextInt();

       if(indice == 1){
           partida();
       }else if(indice == 2){
           proporEmpate();
       }else if(indice == 3){
            desistir();
       }

    }

    public static void alternaJogador(){
        if (jogadorAtual == jogador1) {
            jogadorAtual = jogador2;
            jogador = 1;
        } else if (jogadorAtual == jogador2) {
            jogadorAtual = jogador1;
            jogador = 2;
        }
    }


}




