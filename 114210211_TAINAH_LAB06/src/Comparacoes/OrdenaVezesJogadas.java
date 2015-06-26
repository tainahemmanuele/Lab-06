package Comparacoes;

import java.util.Comparator;

import P2CG.Jogo;

public class OrdenaVezesJogadas implements Comparator  <Jogo>{

	@Override
	public int compare(Jogo jogo1, Jogo jogo2) {
		return jogo1.getVezesjogadas().compareTo(jogo2.getVezesjogadas());
	}

}
