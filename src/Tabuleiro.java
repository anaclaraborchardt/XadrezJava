import java.util.ArrayList;

public class Tabuleiro {
    private ArrayList<Posicao> listaPosicoes = new ArrayList<>();

    public Tabuleiro() {
        for(int i =0; i<64; i++) {
            listaPosicoes.add(new Posicao());
            if(i>= 8 && 1<=15){
                listaPosicoes.get(i).setPeca(new Peao("Preto"));
            }
            if(i>= 48 && 1<=55){
                listaPosicoes.get(i).setPeca(new Peao("Branco"));
            }
            if(i == 0 || i == 7){
                listaPosicoes.get(i).setPeca(new Torre("Preto"));
            }
            if(i == 56 || i == 63){
                listaPosicoes.get(i).setPeca(new Torre("Branco"));
            }
            if(i == 1 || i == 6){
                listaPosicoes.get(i).setPeca(new Cavalo("Preto"));
            }
            if(i == 57 || i == 62){
                listaPosicoes.get(i).setPeca(new Cavalo("Branco"));
            }
            if(i == 2 || i == 5){
                listaPosicoes.get(i).setPeca(new Bispo("Preto"));
            }
            if(i == 58 || i == 61){
                listaPosicoes.get(i).setPeca(new Bispo("Branco"));
            }
            if(i == 3){
                listaPosicoes.get(i).setPeca(new Rainha("Preto"));
            }
            if(i == 59){
                listaPosicoes.get(i).setPeca(new Rainha("Branco"));
            }
            if(i == 4){
                listaPosicoes.get(i).setPeca(new Rei("Preto"));
            }
            if(i == 60){
                listaPosicoes.get(i).setPeca(new Rei("Branco"));
            }
        }
    }
//    public void imprimirTabuleiro() {
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                int indice = i * 8 + j;
//                Posicao posicao = listaPosicoes.get(indice);
//
//                String pecaString = " ";
//                    Peca peca = posicao.getPeca();
//                    pecaString = obterSimboloPeca(peca);
//
//
//                String corFundo = (i + j) % 2 == 0 ? "|" : "  ";
//                System.out.print(corFundo + pecaString + corFundo);
//            }
//            System.out.println();
//        }
//    }
//
//    public String obterSimboloPeca(Peca peca) {
//        if (peca instanceof Peao) {
//            return "P";
//        } else if (peca instanceof Torre) {
//            return "T";
//        } else if (peca instanceof Cavalo) {
//            return "C";
//        } else if (peca instanceof Bispo) {
//            return "B";
//        } else if (peca instanceof Rainha) {
//            return "Q";
//        } else if (peca instanceof Rei) {
//            return "K";
//        }
//        return " ";
//    }


    public void removerPeca(Posicao posicao){

    }

    public ArrayList<Posicao> getPosicao() {
        return listaPosicoes;
    }

    @Override
    public String toString() {
        return "Tabuleiro{" +
                "listaPosicoes=" + listaPosicoes +
                '}';
    }
}