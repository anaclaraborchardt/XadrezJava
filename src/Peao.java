import java.util.ArrayList;

public class Peao extends Peca{

    private boolean primeiroMovimento = true;

    public Peao(String cor, Posicao posicao) {
        super(cor, posicao);
    }

    public Peao() {
        super();
    }

    @Override
    public ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro) {
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();
        Posicao posicaoAtual = this.getPosicao();
        int posicaoNoTabuleiro = tabuleiro.getPosicao().indexOf(posicaoAtual);

        ArrayList<Posicao> posicoesTabuleiro = tabuleiro.getPosicao();


        if (this.getCor().equals("Preto")) {
            if (posicoesTabuleiro.get(posicaoNoTabuleiro + 8).getPeca() == null) {
                possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro + 8));
                    if (isPrimeiroMovimento() && posicoesTabuleiro.get(posicaoNoTabuleiro + 16).getPeca() == null) {
                        possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro + 16));

                }
            }
            if (posicoesTabuleiro.get(posicaoNoTabuleiro + 9).getPeca()!=null && posicoesTabuleiro.get(posicaoNoTabuleiro + 9)
                    .getPeca().getCor().equals("Branco") && !validaExtremidade(posicaoNoTabuleiro+1)) {
                possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro + 9));
            }
            if (posicoesTabuleiro.get(posicaoNoTabuleiro + 7).getPeca()!=null && posicoesTabuleiro.get(posicaoNoTabuleiro + 7)
                    .getPeca().getCor().equals("Branco") && !validaExtremidade(posicaoNoTabuleiro)) {
                possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro + 7));
            }
        } else {

            if (posicoesTabuleiro.get(posicaoNoTabuleiro - 8).getPeca() == null) {
                possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro - 8));
                    if (isPrimeiroMovimento() && posicoesTabuleiro.get(posicaoNoTabuleiro - 16).getPeca() == null)
                        possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro - 16));
                    //Após o primeiro movimento, ele não pode mais andar duas casas
            }
            if (posicoesTabuleiro.get(posicaoNoTabuleiro - 9).getPeca()!=null && posicoesTabuleiro.get(posicaoNoTabuleiro - 9)
                    .getPeca().getCor().equals("Preto") && !validaExtremidade(posicaoNoTabuleiro)) {
                possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro - 9));
            }
            if (posicoesTabuleiro.get(posicaoNoTabuleiro - 7).getPeca()!=null && posicoesTabuleiro.get(posicaoNoTabuleiro - 7)
                    .getPeca().getCor().equals("Preto") && !validaExtremidade(posicaoNoTabuleiro+1)) {
                possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro - 7));
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

    public boolean isPrimeiroMovimento() {
        return primeiroMovimento;
    }

    public void setPrimeiroMovimento(boolean primeiroMovimento) {
        this.primeiroMovimento = true;
    }
}
