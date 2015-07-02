/* 114210211 - Tainah Emmanuele Silva: LAB 6 - Turma 3 */
package P2CG;

import java.util.ArrayList;
import java.util.Collections;

import Comparacoes.OrdenaScore;
import Comparacoes.OrdenaVezesJogadas;
import Comparacoes.OrdenaVezesZeradas;

/**
 * Classe criada com o objetivo de ordenar a lista de jogos.
 * @author tainahemmanuele
 *
 */
public class ComparacoesFactory {
	private OrdenaScore score ;
	private OrdenaVezesJogadas vezesJogadas;
	private OrdenaVezesZeradas vezesZeradas;
	
	
	/**
	 * Construtor da classe ComparacoesFactory.
	 */
	public ComparacoesFactory(){
		this.score = new OrdenaScore();
		this.vezesJogadas = new OrdenaVezesJogadas();
		this.vezesZeradas = new OrdenaVezesZeradas();
	}
	
	/**
	 *Metodo criado para receber a lista de jogos do usuario e o tipo de ordenacao que deve ser feito.
	 *A partir disso, chama o metodo corresponde para a ordenacao.
	 * @param jogos - lista de jogos do usuario;
	 * @param tipos - tipo de ordenacao que deve ser feita. Segue os tipos definidos no enum TiposOrdenacao.
	 */
	public void ordena(ArrayList <Jogo> jogos, TiposOrdenacao tipos){
		if(tipos.equals(TiposOrdenacao.VICIO)){
			OrdenaVezesJogadas(jogos);
		}
		if(tipos.equals(TiposOrdenacao.DESEMPENHO)){
			OrdenaScore(jogos);
		}
		if(tipos.equals(TiposOrdenacao.EXPERIENCIA)){
			OrdenaVezesZeradas(jogos);
		}
		if(tipos.equals(TiposOrdenacao.DEFAULT)){
			OrdenaNome(jogos);
		}
	}
	
	/**
	 * Metodo criado para ordenar a lista de jogos , em ordem crescente, pelo maior score.
	 * @param jogos - lista de jogos.
	 */
	public void OrdenaScore(ArrayList <Jogo> jogos){
	     Collections.sort(jogos,score);
	}
	
	/**
	 * Metodo criado para ordenar a lista de jogos , em ordem crescente, pela quantidade de vezes
	 * jogadas.
	 * @param jogos - lista de jogos.
	 */
	public void OrdenaVezesJogadas(ArrayList <Jogo> jogos){
		Collections.sort(jogos, vezesJogadas);
	}

	/**
	 * Metodo criado para ordenar a lista de jogos , em ordem crescente, pelo quantidade de vezes zeradas.
	 * @param jogos - lista de jogos.
	 */
	public void OrdenaVezesZeradas(ArrayList <Jogo> jogos){
		Collections.sort(jogos, vezesZeradas);
	}
	
	/**
	 * Metodo criado para ordenar a lista de jogos , em ordem crescente, por ordem alfabetica.
	 * @param jogos - lista de jogos.
	 */
	public void OrdenaNome(ArrayList <Jogo> jogos){
		Collections.sort(jogos);
	}
}
