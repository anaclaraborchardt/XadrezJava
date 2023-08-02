import java.util.ArrayList;

public class Jogador {

    private String nome;
    private String senha;
    private String cor;
    private double pontos;
    private ArrayList<Peca>pecas ;
    ArrayList<Peca> unidadesJogador1 = new ArrayList<>();
    ArrayList<Peca> unidadesJogador2 = new ArrayList<>();
    private ArrayList<Integer> indicesValidosJogador1 = new ArrayList<>();
    private ArrayList<Integer> indicesValidosJogador2 = new ArrayList<>();

    public Jogador(String nome, String senha){
        this.nome = nome;
        this.senha = senha;
        this.pecas = new ArrayList<>();;
    }

    public boolean moverPeca(
            Peca peca,
            Posicao posicao,Tabuleiro tabuleiro, Jogador adversario){

        Peca pecaAdversaria = posicao.getPeca();
        boolean valida = peca.mover(tabuleiro,posicao);

        if(posicao.getPeca()!=null && valida) {
            adversario.pecas.remove(pecaAdversaria);
        }
        return valida;
    }

    public boolean proporEmpate(
            Jogador jogador){
        return true;
    }

    public void desistir(){

    }

    public void setCor(String cor, Tabuleiro tabuleiro) {
        this.cor = cor;

        for(Posicao posicao: tabuleiro.getPosicao()) {
            if(posicao.getPeca()!=null &&
                    posicao.getPeca().getCor().equals(this.cor)){
                this.pecas.add(posicao.getPeca());
            }
        }
    }


    public ArrayList<Peca> getPecas() {
        return pecas;
    }

    public ArrayList<Integer> pegaIndice(int jogadorAtual) {
        return jogadorAtual == 1 ? indicesValidosJogador1 : indicesValidosJogador2;
    }

    public void atualizaIndices(int jogadorAtual, int posicaoOrigem, int posicaoDestino) {
        ArrayList<Integer> indicesValidos = pegaIndice(jogadorAtual);
        indicesValidos.remove(Integer.valueOf(posicaoOrigem));
        indicesValidos.add(posicaoDestino);
    }


}