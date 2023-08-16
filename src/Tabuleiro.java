import java.util.ArrayList;

public class Tabuleiro {
    private ArrayList<Posicao> listaPosicoes = new ArrayList<>();
    Peca peca;

    public Tabuleiro() {
        for (int i = 0; i < 64; i++) {
            listaPosicoes.add(new Posicao());
            if (i >= 8 && i <= 15) {
                listaPosicoes.get(i).setPeca(new Peao("Preto", listaPosicoes.get(i)));
            }else if (i == 40){
                listaPosicoes.get(i).setPeca(new Peao("Preto", listaPosicoes.get(i)));
            } else if(i == 22){
                listaPosicoes.get(i).setPeca(new Peao("Branco", listaPosicoes.get(i)));
            } else if (i >= 48 && i <= 55) {
                listaPosicoes.get(i).setPeca(new Peao("Branco", listaPosicoes.get(i)));
            } else if (i == 0 || i == 7) {
                listaPosicoes.get(i).setPeca(new Torre("Preto", listaPosicoes.get(i)));
            } else if (i == 56 || i == 63) {
                listaPosicoes.get(i).setPeca(new Torre("Branco", listaPosicoes.get(i)));
            } else if (i == 1 || i == 6) {
                listaPosicoes.get(i).setPeca(new Cavalo("Preto", listaPosicoes.get(i)));
            } else if (i == 57 || i == 62) {
                listaPosicoes.get(i).setPeca(new Cavalo("Branco", listaPosicoes.get(i)));
            } else if (i == 31) {
                listaPosicoes.get(i).setPeca(new Cavalo("Branco", listaPosicoes.get(i)));
            } else if (i == 2 || i == 5) {
                listaPosicoes.get(i).setPeca(new Bispo("Preto", listaPosicoes.get(i)));
            } else if (i == 58 || i == 61) {
                listaPosicoes.get(i).setPeca(new Bispo("Branco", listaPosicoes.get(i)));
            } else if (i == 3) {
                listaPosicoes.get(i).setPeca(new Rainha("Preto", listaPosicoes.get(i)));
            } else if (i == 59) {
                listaPosicoes.get(i).setPeca(new Rainha("Branco", listaPosicoes.get(i)));
            } else if (i == 4) {
                listaPosicoes.get(i).setPeca(new Rei("Preto", listaPosicoes.get(i)));
            } else if (i == 60) {
                listaPosicoes.get(i).setPeca(new Rei("Branco", listaPosicoes.get(i)));
            } else {
                listaPosicoes.get(i).setPeca(null); // Definir como nulo caso nenhuma peça corresponda à posição
            }
        }
    }
    public boolean imprimirTabuleiro() {
        String numerosLinhas = "  + 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 +";
        String linhaDivisoria = "  +----+----+----+----+----+----+----+----+";

        System.out.println(numerosLinhas);
        System.out.println(linhaDivisoria);

        int rowIndex = 8;
        for (int i = 0; i < 64; i += 8) {
            System.out.print(rowIndex + " ");
            for (int j = i; j < i + 8; j++) {
                String pecaSimbolo = " ";
                if (listaPosicoes.get(j).temPeca()) {
                    pecaSimbolo = listaPosicoes.get(j).getPeca().getSimbolo();
                } else {
                    pecaSimbolo = Integer.toString(j); // Mostra o índice da posição
                }
                System.out.print("| " + pecaSimbolo + " ");
            }
            System.out.println("|");
            System.out.println(linhaDivisoria);
            rowIndex--;
        }
        return true;
    }

    public ArrayList<Posicao> getPosicao() {
        return listaPosicoes;
    }

    @Override
    public String toString() {
        return "Tabuleiro{" +
                "listaPosicoes=" + listaPosicoes +
                '}';
    }

}