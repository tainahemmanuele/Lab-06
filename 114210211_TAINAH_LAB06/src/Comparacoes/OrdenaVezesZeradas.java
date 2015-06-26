package Comparacoes;

import java.util.Comparator;

import P2CG.Jogo;

public class OrdenaVezesZeradas implements Comparator <Jogo>{

	@Override
	public int compare(Jogo jogo1, Jogo jogo2) {
		return jogo1.getZerajogo().compareTo(jogo2.getZerajogo());
	}

}
