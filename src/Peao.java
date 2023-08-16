import java.util.ArrayList;

public class Peao extends Peca {

    private boolean primeiroMovimento = true;
    boolean primMov = true;
    private Object Bispo;

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
            if((posicaoNoTabuleiro + 8) <=63 ){
            if (posicoesTabuleiro.get(posicaoNoTabuleiro + 8).getPeca() == null) {
                possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro + 8));
                if (this.primeiroMovimento) {
                    if (posicoesTabuleiro.get(posicaoNoTabuleiro + 16).getPeca() == null) {
                        possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro + 16));
                        //Após o primeiro movimento, ele não pode mais andar duas casas
                    }
                    }

                }
            }
            if((posicaoNoTabuleiro + 8) <=63){
            if (posicoesTabuleiro.get(posicaoNoTabuleiro + 9).getPeca() != null && posicoesTabuleiro.get(posicaoNoTabuleiro + 9)
                    .getPeca().getCor().equals("Branco") && !validaExtremidade(posicaoNoTabuleiro + 1)) {
                possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro + 9));
            }
            }
            if((posicaoNoTabuleiro + 8) <=63){
            if (posicoesTabuleiro.get(posicaoNoTabuleiro + 7).getPeca() != null && !validaExtremidade(posicaoNoTabuleiro)) {
                if (posicoesTabuleiro.get(posicaoNoTabuleiro + 7).getPeca().getCor().equals("Branco")) {
                    possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro + 7));
                }
                }
            }
        } else {
            if((posicaoNoTabuleiro - 8) >=0){
            if (posicoesTabuleiro.get(posicaoNoTabuleiro - 8).getPeca() == null) {
                possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro - 8));
                if (this.primeiroMovimento) {
                    if (posicoesTabuleiro.get(posicaoNoTabuleiro - 16).getPeca() == null) {
                        possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro - 16));
                        //Após o primeiro movimento, ele não pode mais andar duas casas
                    }
                    }
                }
            }
            if((posicaoNoTabuleiro - 8) >=0){
            if (posicoesTabuleiro.get(posicaoNoTabuleiro - 9).getPeca() != null && !validaExtremidade(posicaoNoTabuleiro)) {
                if (posicoesTabuleiro.get(posicaoNoTabuleiro - 9).getPeca().getCor().equals("Preto") && !validaExtremidade(posicaoNoTabuleiro)) {
                    possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro - 9));
                }
                }
            }
            if((posicaoNoTabuleiro - 8) >=0){
            if (posicoesTabuleiro.get(posicaoNoTabuleiro - 7).getPeca() != null && !validaExtremidade(posicaoNoTabuleiro + 1)) {
                if (posicoesTabuleiro.get(posicaoNoTabuleiro - 7).getPeca().getCor().equals("Preto")) {
                    possiveisMovimentos.add(posicoesTabuleiro.get(posicaoNoTabuleiro - 7));
                }
                }
            }
        }
        return possiveisMovimentos;
    }

    @Override
    public String toString() {
        return "Peao{" +
                "primeiroMovimento=" + primeiroMovimento +
                "posicaoNoTabuleiro=" +
                "} " + super.toString();
    }

    @Override
    public String getSimbolo() {
        return "P ";
    }

    public boolean isPrimeiroMovimento() {
        return primeiroMovimento;
    }

    public void setPrimeiroMovimento(boolean primeiroMovimento) {
        this.primeiroMovimento = primeiroMovimento;
    }


}
