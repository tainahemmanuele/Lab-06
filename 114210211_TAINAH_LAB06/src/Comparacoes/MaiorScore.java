package Comparacoes;

import java.util.ArrayList;

import P2CG.Jogo;


public class MaiorScore implements Comparable<ArrayList <Jogo>>{
	private int score;
	public int compareTo(ArrayList <Jogo> jogos) {
		for(Jogo jogo: jogos){
        if (this.score < jogo.getScore()) {
            return -1;
        }
        if (this.score > jogo.getScore()) {
            return 1;
        }
        return 0;
    }
		return score;
	}

}
