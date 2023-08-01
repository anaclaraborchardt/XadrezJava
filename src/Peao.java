import java.util.ArrayList;

public class Peao extends Peca{

    private boolean primeiroMovimento = true;

    public Peao(String cor, Posicao posicao) {
        super(cor, posicao);
    }

    @Override
    public ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro) {
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();
        Posicao posicaoAtual = this.getPosicao();
        int posicaoTabuleiro = tabuleiro.getPosicao().indexOf(posicaoAtual);
        ArrayList<Posicao> posicoesTabuleiro = tabuleiro.getPosicao();

        //preto +8 e +16
        if (this.getCor().equals("Preto")) {
            if (posicoesTabuleiro.get(posicaoTabuleiro + 8).getPeca() == null) {
                possiveisMovimentos.add(posicoesTabuleiro.get(
                        posicaoTabuleiro + 8
                ));
                if (this.primeiroMovimento) {
                    if (posicoesTabuleiro.get(posicaoTabuleiro + 16).getPeca() == null) {
                        possiveisMovimentos.add(posicoesTabuleiro.get(
                                posicaoTabuleiro + 16
                        ));
                    }
                }
            }   //verifica cor para ataque
            if (posicoesTabuleiro.get(posicaoTabuleiro + 9)
                    .getPeca().getCor().equals("Branco")
            && !validaExtremidade(posicaoTabuleiro + 1)) {
                possiveisMovimentos.add(posicoesTabuleiro.get(posicaoTabuleiro + 9));

            }
            if (posicoesTabuleiro.get(posicaoTabuleiro + 7)
                    .getPeca().getCor().equals("Branco")
                    && !validaExtremidade(posicaoTabuleiro)) {
                possiveisMovimentos.add(posicoesTabuleiro.get(posicaoTabuleiro + 7));

            }
        }
        //preto -8 e -16
        else {
            if (posicoesTabuleiro.get(posicaoTabuleiro - 8).getPeca() == null) {
                possiveisMovimentos.add(posicoesTabuleiro.get(
                        posicaoTabuleiro - 8
                ));
                if (this.primeiroMovimento) {
                    if (posicoesTabuleiro.get(posicaoTabuleiro - 16).getPeca() == null) {
                        possiveisMovimentos.add(posicoesTabuleiro.get(
                                posicaoTabuleiro - 8
                        ));
                    }
                }
            }
            if (posicoesTabuleiro.get(posicaoTabuleiro - 9)
                    .getPeca().getCor().equals("Preto")
                    && !validaExtremidade(posicaoTabuleiro)){
                possiveisMovimentos.add(posicoesTabuleiro.get(posicaoTabuleiro - 9));

            }
            if (posicoesTabuleiro.get(posicaoTabuleiro - 7)
                    .getPeca().getCor().equals("Preto")
                    && !validaExtremidade(posicaoTabuleiro + 1)){
                possiveisMovimentos.add(posicoesTabuleiro.get(posicaoTabuleiro - 7));
            }

        }
        return possiveisMovimentos;
    }

    @Override
    public String toString() {
        return "Peao{" +
                "primeiroMovimento=" + primeiroMovimento +
                "} " + super.toString();
    }

    @Override
    public String getSimbolo() {
        return "P";
    }
}
