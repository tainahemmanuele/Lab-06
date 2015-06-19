package Comparacoes;

import java.util.ArrayList;

import P2CG.Jogo;

public class JogadoVezes implements Comparable<ArrayList <Jogo>>{

		private int vezesJogadas;
		public int compareTo(ArrayList <Jogo> jogos) {
			for(Jogo jogo: jogos){
	        if (this.vezesJogadas < jogo.getVezesjogadas()) {
	            return -1;
	        }
	        if (this.vezesJogadas > jogo.getScore()) {
	            return 1;
	        }
	        return 0;
	    }
			return vezesJogadas;
		}

}
