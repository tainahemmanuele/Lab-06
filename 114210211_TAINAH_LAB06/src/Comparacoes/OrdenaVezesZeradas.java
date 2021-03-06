/* 114210211 - Tainah Emmanuele Silva: LAB 6 - Turma 3 */
package Comparacoes;

import java.util.Comparator;

import P2CG.Jogo;

/**
 * Classe criada utilizando a interface Comparator com o objetivo de comparar dois jogos
 * pela quantidade de vezes zeradas e assim ordenar a lista de jogos, utilizando esse criterio.
 * @author tainahemmanuele
 *
 */
public class OrdenaVezesZeradas implements Comparator <Jogo>{

	@Override
	public int compare(Jogo jogo1, Jogo jogo2) {
		return jogo1.getZerajogo().compareTo(jogo2.getZerajogo());
	}

}
