package P2CG;

import java.util.ArrayList;

import P2CG.Exceptions.SaldoException;
import P2CG.Exceptions.UsuarioException;

public abstract class Jogador {
	private double desconto;
	private int pontos;
	private double dinheiro;
	private double dinheiroDesconto;
	private ArrayList <Jogo> jogos;
	
	public Jogador(ArrayList<Jogo> jogos, double dinheiro){
		this.jogos = jogos;
		this.dinheiro = dinheiro;
		
	}
	
	/**
	 * Metodo criado para a compra do jogo. E do tipo abstrato. Cada classe que
	 * herda Usuario(Noob e Veterano)possuem suas proprias condicoes de
	 * manipulacao dos argumentos
	 * 
	 * @param jogo
	 *            , jogo criado
	 * @throws UsuarioException
	 *             , excecao lancada caso o dinheiro do usuario seja menor que o
	 *             valor do jogo
	 */
	public abstract void compraJogo(Jogo jogo) throws UsuarioException;

	
	/**
	 * Metodo criado para recompensar o usuario de acordo com as jogabilidades
	 * dos jogos que ele jogou . E do tipo abstrato. Cada classe que herda
	 * Usuario(Noob e Veterano)possuem suas proprias condicoes de manipulacao
	 * dos argumentos
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
	 * Metodo criado para punir o usuario de acordo com as jogabilidades dos
	 * jogos que ele jogou . E do tipo abstrato. Cada classe que herda
	 * Usuario(Noob e Veterano)possuem suas proprias condicoes de manipulacao
	 * dos argumentos
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
	 * Metodo criado para subtrair do dinheiro do usuario o valor do jogo
	 * comprado (com desconto a partir do tipo de usuario) Esse metodo e chamado
	 * dentro do metodo compraJogo
	 * 
	 * @param dinheiro
	 *            , dinheiro do usuario
	 * @return , retorna o total que o usuario gastou com desconto nos jogos
	 * @throws UsuarioException
	 *             , excecao lancada caso o dinheiro do usuario seja menor que o
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

	public int adicionaPontos(double preco) {
		this.pontos += (preco * 10);
		return this.pontos;
	}

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
