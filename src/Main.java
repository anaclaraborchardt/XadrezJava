import java.util.ArrayList;
import java.util.Scanner;

public class Main<peca> {

    static boolean vitoria = false;
    static int jogador = 1;
    static boolean empate = false;
    static Scanner sc = new Scanner(System.in);
    static Tabuleiro tabuleiro = new Tabuleiro();
    static Peca peca;
    static boolean xeque = false;
    static int escolhaPeca;

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
            partida();

        } while (!vitoria);

        System.out.println("Jogo acabou");

    }

    private static void partida() {
        Jogador jogadorAdversario = jogadorAtual == jogador2 ? jogador1 : jogador2;

        boolean pecaValida = false;
        do {

            System.out.println("Qual posição deseja mover? (Digite o índice da peça).");
            System.out.println("Selecione o índice da peça ou digite:\n" +
                    "[-1]  Propor Empate\n" +
                    "[-2]  Desistir");
            escolhaPeca = sc.nextInt();

            if (escolhaPeca == -1) {
                proporEmpate();
            } else if (escolhaPeca == -2) {
                desistir();
            }
            peca = tabuleiro.getPosicao().get(escolhaPeca).getPeca();

            if (jogadorAtual.getPecas().contains(peca)) {
                pecaValida = true;
            } else {
                System.out.println("Não é sua peça");
            }

        }
        while (!pecaValida);

        ArrayList<Posicao> movimentosValidos = new ArrayList<>();

        for(Posicao posicao : peca.possiveisMovimentos(tabuleiro)){
            if(!verificaMovimento(peca, posicao)){
                movimentosValidos.add(posicao);
            }
        }


        String posicoesMover = "\n";
        int indice = 0;

        for (Posicao posicao : movimentosValidos) {

            posicoesMover += indice + "-" + posicao + " " + tabuleiro.getPosicao().indexOf(posicao) + "\n";
            indice++;

        }

        Posicao posicao;

        System.out.println("Digite para qual posição deseja ir");
//        System.out.println(movimentosValidos);
        System.out.println(posicoesMover);
        int escolhaPosicao = sc.nextInt();

        //verifica se o índice escolhido é válido
        if (escolhaPosicao > (movimentosValidos.size()) - 1) {
            System.out.println("Essa posição não é válida");
        } else {
            posicao = movimentosValidos.get(escolhaPosicao);
            if(movimentosValidos.size() == 0){
                System.out.println("Não há movimentos possíveis");
            }

            if (peca instanceof Peao) {
                promoverPeca();
            }

            jogador1.moverPeca(peca, posicao, tabuleiro, jogador2);

            alternaJogador();
            validarVitoria(jogadorAdversario);

        }
    }

    private static boolean verificaMovimento(Peca peca, Posicao posicao){
        //alterna entre o jogador atual e o adversario
        Jogador jogadorAdversario = jogadorAtual == jogador2 ? jogador1 : jogador2;
        Peca pecaTemp = posicao.getPeca();
        Posicao posicaoAtual = peca.getPosicao();

        //novo mover = simulação do movimento
        posicao.setPeca(peca);
        peca.getPosicao().setPeca(null);
        peca.setPosicao(posicao);

        //verifica se o movimento coloca o rei em xeque
        for(Peca pecaAdversaria: jogadorAdversario.getPecas()){
            if(pecaAdversaria != pecaTemp){
                for(Posicao posicaoPossivel : pecaAdversaria.possiveisMovimentos(tabuleiro)) {
                    if (posicaoPossivel.getPeca() instanceof Rei){
                        xeque = true;
                    }
                }
            }
        }

        //volta ao estado anterior
        posicao.setPeca(pecaTemp);
        posicaoAtual.setPeca(peca);
        peca.setPosicao(posicaoAtual);

        //caso a peça esteja em xeque, ele retorna true
        if (xeque){
            System.out.println("Você está em xeque");
            //aqui precisa voltar ao xeque = false, pois caso contrário,
            //qualquer peça conseguirá executar o movimento
            xeque = false;
            return true;
        }

        //caso a peça não esteja em xeque, ele vai retornar false
        //ele irá adicionar nos movimentos válidos
        //ele só deixará o usuário mover se for um movimento válido, já verificado
        return false;
    }

    private static void validarVitoria(Jogador jogadorAdversario) {
        //lista de boolean que irá retornar true or false
        ArrayList<Boolean> verificaXeque = new ArrayList<>();
        for(Peca pecaAdversario : jogadorAdversario.getPecas()){
            for(Posicao posicao : pecaAdversario.possiveisMovimentos(tabuleiro)){
                //armazena true or false, dependendo do que foi retornado
                verificaXeque.add(verificaMovimento(pecaAdversario, posicao));
            }
        }
        boolean vitoria = false;
        //percorre a lista de booleanos(t ou f)
        for (boolean boleano : verificaXeque) {
            //caso seja diferente de true, não há vencedor
            if(!boleano){
                vitoria = false;
            }
        }
        //caso contrário, será xeque-mate pois não haverá mais possíveis movimentos
        if (vitoria){
            System.out.println("Xeque-mate");
            System.exit(0);
        }
    }

    public static void proporEmpate() {
        empate = true;
        System.out.println("Propor empate");
        if ((jogadorAtual == jogador1) && (empate == true)) {
            System.out.println("Jogador " + jogador + " propôs empate");
        } else if ((jogadorAtual == jogador2) && (empate == true)) {
            System.out.println("Jogador 2 propôs empate");
        }
        aceitarEmpate();
    }

    public static void aceitarEmpate() {
        alternaJogador();
        System.out.println("Jogador " + jogador);
        System.out.println("\nDeseja aceitar o empate?\n" +
                "- [1] SIM\n" +
                "- [2] NÃO");
        int empateDecisao = sc.nextInt();

        switch (empateDecisao) {
            case 1:
                System.out.println("Jogo finalizado ");
                vitoria = true;
                System.exit(0);
                break;
            case 2:
                System.out.println("Continue o jogo. O empate não foi aceito");

        }
    }

    public static void desistir() {
        System.out.println("Jogador " + jogador + " desistiu da partida");
        System.exit(0);
    }

    public static void alternaJogador() {
        if (jogadorAtual == jogador1) {
            jogadorAtual = jogador2;
            jogador = 1;
        } else if (jogadorAtual == jogador2) {
            jogadorAtual = jogador1;
            jogador = 2;
        }
    }

    public static void promoverPeca() {
        ArrayList<Posicao> movimentosValidos = peca.possiveisMovimentos(tabuleiro);
        for (Posicao posicao : movimentosValidos) {
            if ((escolhaPeca > 7) && (escolhaPeca <= 15)) {
                if (jogadorAtual == jogador1) {
                    peca.promocaoPeca(tabuleiro, posicao);
                    System.out.println("Você pode mudar de peça\n" +
                            "1- Rainha\n" +
                            "2- Torre\n" +
                            "3- Bispo\n" +
                            "4- Cavalo\n");
                    int escolhaPromocao = sc.nextInt();

                    switch (escolhaPromocao) {
                        case 1:
                            if (movimentosValidos.size() > 1)
                                System.out.println(movimentosValidos);
                            if (posicao.getPeca().getCor().equals("Branco")) {
                                posicao.setPeca(new Rainha("Branco", posicao));
                                System.out.println("Para qual posição quer ir?");
                                break;
                            }
                        case 2:
                            if (posicao.getPeca().getCor().equals("Branco")) {
                                posicao.setPeca(new Torre("Branco", posicao));
                                break;
                            }
                        case 3:
                            if (posicao.getPeca().getCor().equals("Branco")) {
                                posicao.setPeca(new Bispo("Branco", posicao));
                                break;
                            }
                        case 4:
                            if (posicao.getPeca().getCor().equals("Branco")) {
                                posicao.setPeca(new Cavalo("Branco", posicao));
                                break;
                            }
                    }
                }
            } else if ((escolhaPeca > 47) && (escolhaPeca <= 55)) {
                if (jogadorAtual == jogador2) {

                    System.out.println("Você pode mudar de peça\n" +
                            "1- Rainha\n" +
                            "2- Torre\n" +
                            "3- Bispo\n" +
                            "4- Cavalo\n");
                    int escolhaPromocao = sc.nextInt();
                    switch (escolhaPromocao) {
                        case 1:
                            if (posicao.getPeca().getCor().equals("Preto")) {
                                posicao.setPeca(new Rainha("Preto", posicao));
                                break;
                            }
                        case 2:
                            if (posicao.getPeca().getCor().equals("Preto")) {
                                posicao.setPeca(new Torre("Preto", posicao));
                                break;
                            }
                        case 3:
                            if (posicao.getPeca().getCor().equals("Preto")) {
                                posicao.setPeca(new Bispo("Preto", posicao));
                                break;
                            }
                        case 4:
                            if (posicao.getPeca().getCor().equals("Preto")) {
                                posicao.setPeca(new Cavalo("Preto", posicao));
                                break;
                            }
                    }
                }
            }
        }

    }


}