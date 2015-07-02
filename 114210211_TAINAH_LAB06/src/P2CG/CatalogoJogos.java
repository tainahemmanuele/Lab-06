/* 114210211 - Tainah Emmanuele Silva: LAB 6 - Turma 3 */
package P2CG;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe criada com o objetivo de organizar a lista de jogo. Funciona como um catalogo.
 * pode adicionar jogos, remover jogos, pesquisa -los, etc.
 * Pode ordenar a lista de jogos de acordo com os criterios estabelecidos no enum TiposOrdenacao.
 * Pode retornar um jogo a partir dos seguintes criterios: o mais zerado, o mais jogado e o maior score.
 * Retorna uma lista de jogos que contem uma determinada jogabilidade.
 * @author tainahemmanuele
 *
 */

public class CatalogoJogos  {
	private ArrayList <Jogo> jogos;
	private int maiorScore;
	private int jogadoVezes;
	private int zeradoVezes;
	private Jogo jogoEscolhido;
	private  ArrayList <Jogo> jogoEspecifico;
	private ComparacoesFactory comparacoes;


	/**
	 * Construtor da classe CatalogoJogos.
	 * @param jogos -  recebe a lista de jogos criada em usuario.
	 */
	
	public CatalogoJogos(ArrayList<Jogo> jogos){
		this.jogos = jogos;
		this.jogoEspecifico = new ArrayList();
		this.comparacoes = new ComparacoesFactory();


	}
	
	/**
	 * Adiciona um jogo na lista de jogos do usuario.
	 * @param jogo - recebe um objeto do tipo jogo.
	 */
	public void adicionaJogo(Jogo jogo){
		jogos.add(jogo);
	}
	
	/**
	 * Remove um jogo dalista de jogos do usuario.
	 * @param jogo - recebe um objeto do tipo jogo.
	 */
	public void remove(Jogo jogo){
	    jogos.remove(jogo);
	}
	
	/**
	 * Pesquisa um jogo na lista de jogo dos usuarios e retorna um objeto do tipo jogo.
	 * @param nome - nome do jogo;
	 * @return - retorna um objeto do tipo jogo.
	 */
	public Jogo pesquisaJogo(String nome){
		for (Jogo jogo : jogos) {
			if(jogo.getNome().equals(nome)){
				return jogo;
			}
		}
		return null;
	}

	

	/**
	 * Metodo que retorna a lista de jogos do usuario.
	 * @return - retorna a lista de jogos.
	 */
	public ArrayList<Jogo> getJogos() {
		return jogos;
	}

	/**
	 * Metodo criado para retornar um jogo do usuario que tenha o maior score, dentre todos
	 * os jogos da lista.
	 * @return - retorna um objeto do tipo jogo.
	 */
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
	
	/**
	  * Metodo criado para retornar um jogo do usuario que tenha sido o mais jogado 
	  * dentre todos os jogos da lista. 
	 * @return - retorna um objeto do tipo jogo.
	 */
	public Jogo maisJogado(){
		for(Jogo jogo:jogos){
			if(jogo.getVezesjogadas()>=jogadoVezes){
				jogadoVezes = jogo.getVezesjogadas();
				jogoEscolhido = jogo;
				
			}
		}
		return jogoEscolhido;
	}
	
	/**
	 * Metodo criado para retornar um jogo do usuario que tenha o mais zerado, dentre todos
	 * os jogos da lista.
	 * @return - retorna um objeto do tipo jogo.
	 */
	public Jogo maisZerado(){
		for(Jogo jogo:jogos){
			if(jogo.getZerajogo()>=zeradoVezes){
				zeradoVezes = jogo.getZerajogo();
				jogoEscolhido = jogo;
				
			}
		}
		return jogoEscolhido;

	}
	
	/**
	 * Metodo criado para retornar uma lista de jogos de acordo com o tipo de jogabilidade
	 * passada como parametro do metodo.
	 * @param jogabilidade - Jogabilidade passada de acordo com os tipos definidos no enum
	 * EstiloJogos.
	 * @return - retorna uma lista do tipo Jogo com os jogos que contem a jogabilidade passada
	 * como parametro.
	 */
	public ArrayList <Jogo> jogabilidadeEspecifica(EstiloJogos jogabilidade){
		for(Jogo jogo: jogos){
			if(jogo.getJogabilidade().contains(jogabilidade)){
				jogoEspecifico.add(jogo);
			}
		}
		return jogoEspecifico;
	}
	
	/**
	 * Metodo que retorna a lista de jogos que contem a jogabilidade especifica.
	 * @return
	 */
	public ArrayList<Jogo> getJogoEspecifico() {
		return jogoEspecifico;
	}

	/**
	 * Metodo criado para ordenar os jogos de acordo com o tipo de ordenacao passado como 
	 * parametro. Chama o metodo ordena da classe ComparacoesFactory, que contem os metodos
	 * necessarios para cada tipo de ordenacao. A lista de jogos e o tipo de ordenacao e passada
	 * como parametro para o metodo ordena da classe ComparacoesFactory.
	 * @param tipos - Tipo passado de acordo com os tipos definidos no enum TiposOrdenacao.
	 */
	public void ordenaJogo(TiposOrdenacao tipos){
         comparacoes.ordena(jogos, tipos);
			
		}

	@Override
	public String toString() {
		return "CatalogoJogos [jogoEspecifico=" + jogoEspecifico + "]";
	}
	
}
