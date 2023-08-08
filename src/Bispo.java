import java.util.ArrayList;

public class Bispo extends Peca{

    public Bispo(String cor, Posicao posicao) {
        super(cor, posicao);
    }

    @Override

    public ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro) {
        Posicao posicaoAtual = this.getPosicao();
        int posicaoTabuleiro = tabuleiro.getPosicao().indexOf(posicaoAtual);
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();


        for (int i = posicaoTabuleiro + 9; i % 8 != 0 && i < tabuleiro.getPosicao().size(); i += 9) {
            if (verificaPeca(tabuleiro.getPosicao().get(i), possiveisMovimentos) || validaExtremidade(i)) {
                break;
            }
        }

        for (int i = posicaoTabuleiro + 7; (i + 1) % 8 != 0 && i < tabuleiro.getPosicao().size(); i += 7) {
            if (verificaPeca(tabuleiro.getPosicao().get(i), possiveisMovimentos) || validaExtremidade(i)) {
                break;
            }
        }

        for (int i = posicaoTabuleiro - 7; i % 8 != 0 && i >= 0; i -= 7) {
            if (verificaPeca(tabuleiro.getPosicao().get(i), possiveisMovimentos) || validaExtremidade(i)) {
                break;
            }
        }

        for (int i = posicaoTabuleiro - 9; (i + 1) % 8 != 0 && i >= 0; i -= 9) {
            if (verificaPeca(tabuleiro.getPosicao().get(i), possiveisMovimentos) || validaExtremidade(i)) {
                break;
            }
        }

        return possiveisMovimentos;
    }

    @Override
    public String toString() {
        return "Bispo" + super.toString();
    }

    @Override
    public String getSimbolo() {
        return "B ";
    }
}
