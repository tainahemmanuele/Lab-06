/* 114210211 - Tainah Emmanuele Silva: LAB 6 - Turma 3 */
package P2CG;

import java.util.ArrayList;

import P2CG.Exceptions.SaldoException;
import P2CG.Exceptions.UsuarioException;
/**
 * Classe do tipo abstrata. Classe criada para permitir que um usuario se torne um jogador.
 * Possui metodos para compra de jogos, para que um usuario jogue um jogo, etc.
 * @author tainahemmanuele
 *
 */
public abstract class Jogador {
	private double desconto;
	private int pontos;
	private double dinheiro;
	private double dinheiroDesconto;
	private ArrayList <Jogo> jogos;
	
	/**
	 * Construtor da classe Jogador.
	 * @param jogos - lista de jogos do usuarios;
	 * @param dinheiro - dinheiro do usuario.
	 */
	public Jogador(ArrayList<Jogo> jogos, double dinheiro){
		this.jogos = jogos;
		this.dinheiro = dinheiro;
		this.desconto = 0;
		this.dinheiroDesconto = 0;
		
	}
	
	/**
	 * Metodo criado para a compra do jogo. E do tipo abstrato. Cada classe que
	 * herda Jogador(Noob e Veterano)possuem suas proprias condicoes de
	 * manipulacao dos argumentos.
	 * 
	 * @param jogo
	 *            , jogo criado
	 * @throws UsuarioException
	 *             , excecao lancada caso o dinheiro do usuario seja menor que o
	 *             valor do jogo
	 */
	public abstract void compraJogo(Jogo jogo) throws UsuarioException;

	
	/**
	 * Metodo criado para recompensar o jogador de acordo com as jogabilidades
	 * dos jogos que ele jogou . E do tipo abstrato. Cada classe que herda
	 * Jogador(Noob e Veterano)possuem suas proprias condicoes de manipulacao
	 * dos argumentos.
	 * 
	 * @param nomeJogo
	 *            , nome do jogo que o usuario jogou e deve ser recompensado por
	 *            isso
	 * @param scoreObtido
	 *            , o score obtido no jogo
	 * @param zerou
	 *            , se o uzuario zerou ou nao o jogo
	 */
	public abstract void ganhouPartida(String nomeJogo, int scoreObtido,
			boolean zerou);

	/**
	 * Metodo criado para punir o jogador de acordo com as jogabilidades dos
	 * jogos que ele jogou . E do tipo abstrato. Cada classe que herda
	 * Jogador(Noob e Veterano)possuem suas proprias condicoes de manipulacao
	 * dos argumentos.
	 * 
	 * @param nomeJogo
	 *            , nome do jogo que o usuario jogou e deve ser punido por isso
	 * @param scoreObtido
	 *            , o score obtido no jogo
	 * @param zerou
	 *            , se o uzuario zerou ou nao o jogo
	 */
	public abstract int perdeuPartida(String nomeJogo, int scoreObtido, boolean zerou);
	
	/**
	 * Metodo criado para subtrair do dinheiro do jogador o valor do jogo
	 * comprado (com desconto a partir do tipo de jogador) Esse metodo e chamado
	 * dentro do metodo compraJogo
	 * 
	 * @param dinheiro
	 *            , dinheiro do jogador
	 * @return , retorna o total que o usuario gastou com desconto nos jogos
	 * @throws UsuarioException
	 *             , excecao lancada caso o dinheiro do jogador seja menor que o
	 *             valor do jogo
	 */
	public double subtraiDinheiro(double preco) throws UsuarioException {
		if (this.dinheiro < preco) {
			throw new SaldoException("Saldo insuficiente");
		} else {
			dinheiroDesconto += preco;
			this.dinheiro -= preco;
			return dinheiroDesconto;
		}
	}

	/**
	 * Metodo criado para adicionar pontos ao jogador de acordo com o valor dos jogos comprados.
	 * @param preco - preco do jogo;
	 * @return - quantidade de pontos gerados com a compra do jogo.
	 */
	public int adicionaPontos(double preco) {
		this.pontos += (preco * 10);
		return this.pontos;
	}

	/**
	 * Metodo criado para calcular o desconto que o jogador tem direito de acordo com o seu tipo
	 * (Noob ou veterano). E do tipo abstrato. Cada classe que herda Jogador (Noob e Veterano)
	 * possuem suas proprias condicoes de  manipulacao dos argumentos.
	 * @param precoJogo - preco do jogo;
	 * @return - retorna o valor do jogo com desconto.
	 */
	public abstract double calculaDesconto(double precoJogo);
	
	/**
	 * Desconto que o jogador teve ao comprar o jogo.
	 * @return - retorna o desconto.
	 */
	public double getDesconto() {
		return desconto;
	}


	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public double getDinheiro() {
		return dinheiro;
	}

	public void setDinheiro(double dinheiro) {
		this.dinheiro = dinheiro;
	}

	public double getDinheiroDesconto() {
		return dinheiroDesconto;
	}

	public ArrayList<Jogo> getJogos() {
		return jogos;
	}
	
	
	

	
}
