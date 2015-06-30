package P2CG;

import java.util.ArrayList;
import java.util.Collections;

import Comparacoes.OrdenaScore;
import Comparacoes.OrdenaVezesJogadas;
import Comparacoes.OrdenaVezesZeradas;

public class ComparacoesFactory {
	private OrdenaScore score ;
	private OrdenaVezesJogadas vezesJogadas;
	private OrdenaVezesZeradas vezesZeradas;
	
	
	public ComparacoesFactory(){
		this.score = new OrdenaScore();
		this.vezesJogadas = new OrdenaVezesJogadas();
		this.vezesZeradas = new OrdenaVezesZeradas();
	}
	
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
	public void OrdenaScore(ArrayList <Jogo> jogos){
	     Collections.sort(jogos,score);
	}
	
	public void OrdenaVezesJogadas(ArrayList <Jogo> jogos){
		Collections.sort(jogos, vezesJogadas);
	}

	public void OrdenaVezesZeradas(ArrayList <Jogo> jogos){
		Collections.sort(jogos, vezesZeradas);
	}
	
	public void OrdenaNome(ArrayList <Jogo> jogos){
		Collections.sort(jogos);
	}
}
