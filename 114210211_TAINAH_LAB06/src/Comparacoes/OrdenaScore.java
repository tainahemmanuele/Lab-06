package Comparacoes;

import java.util.Comparator;

import P2CG.Jogo;

public class OrdenaScore implements Comparator <Jogo>{

	@Override
	public int compare(Jogo jogo1, Jogo jogo2) {
		return jogo1.getScore().compareTo(jogo2.getScore());
	}

}
