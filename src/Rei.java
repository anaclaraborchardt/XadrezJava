import java.util.ArrayList;
import java.util.List;

public class Rei extends Peca{

    private boolean primeiroMovimento;

    public Rei(String cor, Posicao posicao) {
        super(cor, posicao);
    }

    @Override
    public ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro) {
        Posicao posicaoAtual = this.getPosicao();
        int posicaoTabuleiro = tabuleiro.getPosicao().indexOf(posicaoAtual);
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();

        for(Posicao posicao: tabuleiro.getPosicao()) {
            int indice = tabuleiro.getPosicao().indexOf(posicao);
            if (indice == posicaoTabuleiro - 9 ||
                    indice == posicaoTabuleiro - 8 ||
                    indice == posicaoTabuleiro - 7 ||
                    indice == posicaoTabuleiro - 1 ||
                    indice == posicaoTabuleiro + 1 ||
                    indice == posicaoTabuleiro + 7 ||
                    indice == posicaoTabuleiro + 8 ||
                    indice == posicaoTabuleiro + 9) {


                if (validaExtremidade(posicaoTabuleiro + 1) && !(
                        indice == posicaoTabuleiro - 7 ||
                                indice == posicaoTabuleiro - 1 ||
                                indice == posicaoTabuleiro - 9)) {
                    verificaPeca(posicao, possiveisMovimentos);
                }

                //coluna A
                else if (validaExtremidade(posicaoTabuleiro) && !(
                        indice == posicaoTabuleiro - 9 ||
                                indice == posicaoTabuleiro - 1 ||
                                indice == posicaoTabuleiro + 7)) {
                    verificaPeca(posicao, possiveisMovimentos);
                }
                verificaPeca(posicao, possiveisMovimentos);
//                xequeMate(tabuleiro);
            }
        }

     return possiveisMovimentos;
    }

    @Override
    public String toString() {
        return "Rei{" +
                "primeiroMovimento=" + primeiroMovimento +
                "} " + super.toString();
    }

    @Override
    public String getSimbolo() {
        return "K ";
    }

//    public static void xequeMate(Tabuleiro tabuleiro){
//        Peca peca = null;
//        ArrayList<Posicao> listaPosicoes = peca.possiveisMovimentos(tabuleiro);
//        List<Posicao> movimentosRei = null ;
//        Torre torre;
//
//        for(Posicao posicao: tabuleiro.getPosicao()) {
//                movimentosRei.add(posicao);
//                System.out.println(movimentosRei);
//            }
//        }
}
