import java.util.ArrayList;

public class Rainha extends Peca {
    public Rainha(String cor, Posicao posicao) {
        super(cor, posicao);
    }

    @Override
    public ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro) {
        Posicao posicaoAtual = this.getPosicao();
        int posicaoTabuleiro = tabuleiro.getPosicao().indexOf(posicaoAtual);
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();

        //if ternario i=(posicaoTabuleiro%8 == 0?64:posicaoTabuleiro+ 7)
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

        for (int i = posicaoTabuleiro + 8;
             i < tabuleiro.getPosicao().size();
             i += 8) {
            if (verificaPeca(tabuleiro.getPosicao().get(i), possiveisMovimentos)) {
                break;
            }
        }
        for (int i = ((posicaoTabuleiro + 1) % 8 == 0 ?
                -1 : posicaoTabuleiro - 8);
             i >= 0;
             i -= 8) {
            if (verificaPeca(tabuleiro.getPosicao().get(i), possiveisMovimentos)) {
                break;
            }
        }
        for (int i = (validaExtremidade(posicaoTabuleiro + 1) ? 64 : posicaoTabuleiro + 1);
             i < tabuleiro.getPosicao().size();
             i++) {
            if (validaExtremidade(i + 1) ||
                    verificaPeca(tabuleiro.getPosicao().get(i), possiveisMovimentos)
            ) {

                break;
            }
        }
        for (int i = (validaExtremidade(posicaoTabuleiro) ? -1 : posicaoTabuleiro - 1);
             i >= 0;
             i--) {
            if (validaExtremidade(i)
                    || verificaPeca(tabuleiro.getPosicao().get(i), possiveisMovimentos)
            ) {


                break;
            }

        }
        return possiveisMovimentos;
    }

    @Override
    public String toString() {
        return "Rainha " + super.toString();
    }

    @Override
    public String getSimbolo() {
        return "Q ";
    }
}
