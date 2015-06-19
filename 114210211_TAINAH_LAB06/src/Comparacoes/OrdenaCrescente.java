package Comparacoes;

import java.util.ArrayList;

import P2CG.Jogo;

public class OrdenaCrescente implements Comparable<Jogo>{
	private int score;
	private int vezesJogadas;
	private int zerou;
	private Jogo jogo;
	
	public int compareTo(Jogo jogo) {

        if (this.vezesJogadas < jogo.getVezesjogadas()) {
            return -1;
        }
        if (this.vezesJogadas > jogo.getScore()) {
            return 1;
        }
        return 0;
    
	}
	
	public int compareScore(Jogo jogo) {
        if (this.score < jogo.getScore()) {
            return -1;
        }
        if (this.score > jogo.getScore()) {
            return 1;
        }
        return 0;
  
	}

	public int compareZerou(Jogo jogo) {
        if (this.zerou < jogo.getZerajogo()) {
            return -1;
        }
        if (this.zerou > jogo.getZerajogo()) {
            return 1;
        }
        return 0;

	}
	
	
}
