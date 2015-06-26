package P2CG;

import java.util.ArrayList;
import java.util.Collections;


public class CatalogoJogos  {
	private ArrayList <Jogo> jogos;
	private int maiorScore;
	private int jogadoVezes;
	private int zeradoVezes;
	private Jogo jogoEscolhido;
	private ComparacoesFactory comparacoes;


	
	public CatalogoJogos(ArrayList<Jogo> jogos){
		this.jogos = jogos;
		this.comparacoes = new ComparacoesFactory();


	}
	
	public void adicionaJogo(Jogo jogo){
		jogos.add(jogo);
	}
	
	public void remove(Jogo jogo){
	    jogos.remove(jogo);
	}
	
	public Jogo pesquisaJogo(String nome){
		for (Jogo jogo : jogos) {
			if(jogo.getNome().equals(nome)){
				return jogo;
			}
		}
		return null;
	}

	
	

	public ArrayList<Jogo> getJogos() {
		return jogos;
	}

	public Jogo maiorScore(){
		for(Jogo jogo:jogos){
			if(jogo.getScore()>=maiorScore){
				maiorScore = jogo.getScore();
				jogoEscolhido = jogo;
				
			}
			return jogoEscolhido;
		}
		return jogoEscolhido;
	}
	
	public Jogo maisJogado(){
		for(Jogo jogo:jogos){
			if(jogo.getVezesjogadas()>=jogadoVezes){
				jogadoVezes = jogo.getVezesjogadas();
				jogoEscolhido = jogo;
				
			}
			return jogoEscolhido;
		}
		return jogoEscolhido;
	}
	public Jogo maisZerado(){
		for(Jogo jogo:jogos){
			if(jogo.getZerajogo()>=zeradoVezes){
				zeradoVezes = jogo.getZerajogo();
				jogoEscolhido = jogo;
				
			}
			return jogoEscolhido;
		}
		return jogoEscolhido;

	}
	
	public Jogo jogabilidadeEspecifica(String jogabilidade){
		for(Jogo jogo: jogos){
			if(jogo.getJogabilidade().contains(jogabilidade)){
				jogoEscolhido = jogo;
			}
			return jogoEscolhido;
		}
		return jogoEscolhido;
	}
	
	public void OrdenaJogo(TiposOrdenacao tipos){
         comparacoes.ordena(jogos, tipos);
			
		}
	
}
