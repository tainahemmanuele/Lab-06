package P2CG;

import java.util.ArrayList;
import java.util.Collections;

import sp2fy.ComparadorDuracao;
import Comparacoes.JogadoVezes;
import Comparacoes.MaiorScore;
import Comparacoes.OrdenaCrescente;

public class CatalogoJogos {
	private ArrayList <Jogo> jogos;
	private MaiorScore score;
	private JogadoVezes vezesJogadas;
	private OrdenaCrescente crescente;
	
	public CatalogoJogos(ArrayList<Jogo> jogos){
		this.jogos = jogos;
		this.score = new MaiorScore();
		this.vezesJogadas = new JogadoVezes();
		this.crescente = new OrdenaCrescente();
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

	public int ordenaScoreCrescente(){
		return Collections.sort(getJogos(), crescente.compareScore(Jogo));
	}
	
	public int ordenaJogadasCrescente(){
		return crescente.compareTo(jogos);
	}
	
	public int ordenaZerouCrescente(){
		return crescente.compareZerou(jogos);
		
	}
	

	public ArrayList<Jogo> getJogos() {
		return jogos;
	}
	
}
