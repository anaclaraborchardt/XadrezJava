import java.util.ArrayList;

public class Cavalo extends Peca{
    public Cavalo(String cor, Posicao posicao) {
        super(cor, posicao);
    }

    @Override
    public ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro) {
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();

        Posicao posicaoAtual = this.getPosicao();

        int posicaoTabuleiro = tabuleiro.getPosicao().indexOf(posicaoAtual);

        for (Posicao posicao : tabuleiro.getPosicao()) {
            int indice = tabuleiro.getPosicao().indexOf(posicao);
            if (indice == posicaoTabuleiro - 15 ||
                    indice == posicaoTabuleiro - 6 ||
                    indice == posicaoTabuleiro - 17 ||
                    indice == posicaoTabuleiro - 10 ||
                    indice == posicaoTabuleiro + 15 ||
                    indice == posicaoTabuleiro + 10 ||
                    indice == posicaoTabuleiro + 17 ||
                    indice == posicaoTabuleiro + 6) {

                //coluna H
                if (validaExtremidade(posicaoTabuleiro + 1)){
                       if (!(indice == posicaoTabuleiro - 15 ||
                                indice == posicaoTabuleiro - 6 ||
                                indice == posicaoTabuleiro + 17 ||
                                indice == posicaoTabuleiro + 10)){
                        verificaPeca(posicao, possiveisMovimentos);
                    }
                }

                //coluna A
                else if (validaExtremidade(posicaoTabuleiro)) {
                        if (!(indice == posicaoTabuleiro + 15 ||
                        indice == posicaoTabuleiro + 6 ||
                        indice == posicaoTabuleiro - 17 ||
                        indice == posicaoTabuleiro - 10)){
                    verificaPeca(posicao, possiveisMovimentos);
                }
            }

                //coluna B
                else if (validaExtremidade(posicaoTabuleiro - 1)){
                        if(!(indice == posicaoTabuleiro + 6 ||
                                indice == posicaoTabuleiro - 10)) {
                    verificaPeca(posicao, possiveisMovimentos);
                    }
                }

                //coluna G
                else if (validaExtremidade(posicaoTabuleiro + 2)){
                        if(!(indice == posicaoTabuleiro - 15 ||
                                indice == posicaoTabuleiro + 17)){
                        verificaPeca(posicao, possiveisMovimentos);
                    }
                }

                // não pertence a conta
                else {
                    verificaPeca(posicao, possiveisMovimentos);
                }
            }
        }
        return possiveisMovimentos;
    }

    @Override
    public String toString() {
        return "Cavalo" + super.toString();
    }

    @Override
    public String getSimbolo() {
        return "C";
    }
}
