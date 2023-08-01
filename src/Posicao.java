import java.util.ArrayList;

public class Posicao {
    private Peca peca;

    public Peca getPeca() {

        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    public void moverPeca(Tabuleiro tabuleiro, Posicao posicao){

    }

    @Override
    public String toString() {
        return "Posicao{" +
                "peca=" + peca +
                '}';
    }
}
