import java.util.ArrayList;

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

        for(Posicao posicao: tabuleiro.getPosicao()){
            int indice = tabuleiro.getPosicao().indexOf(posicao);
            if(indice == posicaoTabuleiro -9 ||
            indice == posicaoTabuleiro -8 ||
                    indice == posicaoTabuleiro -7 ||
                    indice == posicaoTabuleiro -1 ||
                    indice == posicaoTabuleiro +1 ||
                    indice == posicaoTabuleiro +7 ||
                    indice == posicaoTabuleiro +8 ||
                    indice == posicaoTabuleiro +9){

            }
            if (validaExtremidade(posicaoTabuleiro + 1) &&(
                    indice == posicaoTabuleiro - 7 ||
                            indice == posicaoTabuleiro - 1 ||
                            indice == posicaoTabuleiro - 9 )) {
                verificaPeca(posicao, possiveisMovimentos);
            }

            //coluna A
            else if (validaExtremidade(posicaoTabuleiro) && (
                    indice == posicaoTabuleiro - 9 ||
                            indice == posicaoTabuleiro - 1 ||
                            indice == posicaoTabuleiro + 7 )) {
                verificaPeca(posicao, possiveisMovimentos);
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
}
