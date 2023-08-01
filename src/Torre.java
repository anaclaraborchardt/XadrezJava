import java.util.ArrayList;

public class Torre extends Peca{
    private boolean primeiroMovimento;

    public Torre(String cor) {
        super(cor);
    }

    @Override
    public ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro) {
        Posicao posicaoAtual = this.getPosicao();
        int posicaoTabuleiro = tabuleiro.getPosicao().indexOf(posicaoAtual);
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();

        //if ternario i=(posicaoTabuleiro%8 == 0?64:posicaoTabuleiro+ 7)
        for(int i=posicaoTabuleiro + 8 ;
            i<tabuleiro.getPosicao().size();
            i += 8) {
            if(verificaPeca(tabuleiro.getPosicao().get(i), possiveisMovimentos)){
                break;
            }
        }
        for(int i=((posicaoTabuleiro+1) %8 == 0?
                -1:posicaoTabuleiro -8);
            i>=0;
            i -= 8){
            if(verificaPeca(tabuleiro.getPosicao().get(i), possiveisMovimentos)){
                break;
            }
        }
        for(int i=(validaExtremidade(posicaoTabuleiro + 1) ?
                64:posicaoTabuleiro+ 1);
            i<tabuleiro.getPosicao().size();
            i ++){
            if(validaExtremidade(i + 1) ||
        verificaPeca(tabuleiro.getPosicao().get(i), possiveisMovimentos)
            ){

                break;
            }
        }
        for(int i=(validaExtremidade(posicaoTabuleiro)?
                -1:posicaoTabuleiro -1);
            i>=0;
            i --){
            if(validaExtremidade(i )
        || verificaPeca(tabuleiro.getPosicao().get(i), possiveisMovimentos)
                     ){


                break;
            }
        }
        return possiveisMovimentos;
    }

    @Override
    public String toString() {
        return "Torre{" +
                "primeiroMovimento=" + primeiroMovimento +
                "} " + super.toString();
    }
}
