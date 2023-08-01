import java.util.ArrayList;

public class Bispo extends Peca{

    public Bispo(String cor) {
        super(cor);
    }

    @Override

    public ArrayList<Posicao> possiveisMovimentos(Tabuleiro tabuleiro) {
        Posicao posicaoAtual = this.getPosicao();
        int posicaoTabuleiro = tabuleiro.getPosicao().indexOf(posicaoAtual);
        ArrayList<Posicao> possiveisMovimentos = new ArrayList<>();

        //if ternario i=(posicaoTabuleiro%8 == 0?64:posicaoTabuleiro+ 7)
        for(int i=(posicaoTabuleiro%8 == 0?
                64:posicaoTabuleiro+ 7);
            i<tabuleiro.getPosicao().size();
            i += 7) {
            if(verificaPeca(tabuleiro.getPosicao().get(i), possiveisMovimentos)
                    || validaExtremidade(i) ){
                break;
            }
        }
        for(int i=((posicaoTabuleiro+1) %8 == 0? -1:posicaoTabuleiro -7); i>=tabuleiro.getPosicao().size(); i -= 7){
            if(verificaPeca(tabuleiro.getPosicao().get(i +1), possiveisMovimentos)
                    || validaExtremidade(i) ){
                break;
            }
        }
        for(int i=((posicaoTabuleiro +1)%8 == 0?64:posicaoTabuleiro+ 9); i<tabuleiro.getPosicao().size(); i += 9){
            if(validaExtremidade(i+1) ||
                    verificaPeca(tabuleiro.getPosicao().get(i + 1), possiveisMovimentos)){

                break;
            }
        }
        for(int i=(posicaoTabuleiro%8 == 0? -1:posicaoTabuleiro -9); i>= tabuleiro.getPosicao().size(); i -= 9){
            if(
            verificaPeca(tabuleiro.getPosicao().get(i), possiveisMovimentos)
            || validaExtremidade(i) ){


                break;
            }
        }



//        for(Posicao posicao: tabuleiro.getPosicao()) {
//            int cont = tabuleiro.getPosicao().indexOf(posicao);
//                if((cont - posicaoTabuleiro) %7 == 0){
//                    possiveisMovimentos.add(posicao);
//
//                }
//            else if((cont - posicaoTabuleiro) %9 == 0) {
//                possiveisMovimentos.add(posicao);
//            }
//        }
        return possiveisMovimentos;
    }

    @Override
    public String toString() {
        return "Bispo" + super.toString();
    }
}
