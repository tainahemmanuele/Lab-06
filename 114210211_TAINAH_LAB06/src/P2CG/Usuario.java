/* 114210211 - Tainah Emmanuele Silva: LAB 5 - Turma 3 */
package P2CG;

import java.util.ArrayList;

import P2CG.Exceptions.CriacaoUsuarioException;
import P2CG.Exceptions.SaldoException;
import P2CG.Exceptions.UsuarioException;

/**
 * Classe criada para criar o usuario.Possui o construtor do Jogo. Possui
 * metodos que permite que o usuario jogue o jogo comprado na loja, que adiciona
 * pontos ao usuario conforme o tipo de jogo que o mesmo jogou, que subtrai
 * pontos do usuario conforme o tipo de jogo que o mesmo jogou.
 * 
 * @author tainahemmanuele
 *
 */
public class Usuario implements Comparable <Usuario> {
	private String nome;
	private String login;
	protected ArrayList<Jogo> jogos;
	private double dinheiro;
	private int pontos;
	public double desconto;
	private CatalogoJogos catalogo;
	private Jogador jogador;

	/**
	 * Construtor usado para criar um usuario
	 * 
	 * @param nome
	 *            , nome do usuario
	 * @param login
	 *            , login do usuario
	 * @param dinheiro
	 *            , dinheiro do usuario
	 * @throws CriacaoUsuarioException
	 *             , excecao lan�ada caso o nome do usuario seja vazio, o
	 *             login do usuario seja vazio ou o dinheiro do usuario seja
	 *             negativo.
	 */

	public Usuario(String nome, String login, double dinheiro)
			throws CriacaoUsuarioException {
		if (nome.equals("")) {
			throw new CriacaoUsuarioException(
					"Nome do usuario nao pode ser vazio");
		}
		if (login.equals("")) {
			throw new CriacaoUsuarioException(
					"Login do usuario nao pode ser vazio");
		}
		if (dinheiro < 0) {
			throw new CriacaoUsuarioException(
					"Dinheiro do usuario nao pode ser negativo");
		}

		this.nome = nome;
		this.login = login;
		this.jogos = new ArrayList<Jogo>();
		this.dinheiro = dinheiro;
		this.pontos = 0;
		this.catalogo = new CatalogoJogos(this.jogos);
		this.jogador = new Noob(this.jogos,this.dinheiro);

	}

	/**
	 * Metodo que permite que adicione mais dinheiro ao usuario
	 * 
	 * @param dinheiro
	 *            , dinheiro do usuario
	 */
	public void adicionaDinheiro(double dinheiro) {
		jogador.setDinheiro(dinheiro);
	}

	

	public void upgrade(){
		jogador = new Veterano(jogos, dinheiro);
	}
	
	public void downgrade(){
		jogador = new Noob(jogos, dinheiro);
	}
	
	public void perdeuPartida(String nomeJogo, int scoreObtido, boolean zerou){
		jogador.perdeuPartida(nomeJogo, scoreObtido, zerou);
		setPontos(jogador.getPontos());
		mudaUsuario(this.pontos);
	}
	
	public void ganhouPartida(String nomeJogo, int scoreObtido, boolean zerou){
		jogador.ganhouPartida(nomeJogo, scoreObtido, zerou);
		setPontos(jogador.getPontos());
		mudaUsuario(this.pontos);
	}
	
	public double getDesconto() {
		return desconto;
	}

	public void compraJogo(Jogo jogo) throws UsuarioException{
		jogador.compraJogo(jogo);
		this.pontos += jogador.getPontos();
		descontoTotal(jogador.getDinheiroDesconto());
		catalogo.adicionaJogo(jogo);
		mudaUsuario(this.pontos);
		
		}
		
	
	
	
    private void mudaUsuario(int pontos){
    	if(pontos>=1000){
			upgrade();
		}else{
			downgrade();
		}
    }
	
	/**
	 * Metodo que adiciona o jogo criado e comprado pelo usuario na sua lista de
	 * jogos.
	 * 
	 * @param jogo
	 *            , jogo que foi comprado pelo usuario.
	 */
	
	
	public void adicionaJogo(Jogo jogo){
		catalogo.adicionaJogo(jogo);
	}

	public void removeJogo(Jogo jogo){
		catalogo.remove(jogo);
	}
	
	public String tipoJogador(){
		return jogador.getClass().getSimpleName();
	}

	public Jogo pesquisaJogo(String nome){
		return catalogo.pesquisaJogo(nome);
	}
	
	public Jogo maiorScore(){
		return catalogo.maiorScore();
	}
	
	public Jogo maisJogado(){
		return catalogo.maisJogado();
	}
	
	public Jogo maisZerado(){
		return catalogo.maisZerado();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public ArrayList<Jogo> getJogos() {
		return jogos;
	}

	public void setJogos(ArrayList<Jogo> jogos) {
		this.jogos = jogos;
	}

	public int getPontos() {
		return pontos;
	}

	public int setPontos(int pontos) {
		return this.pontos += pontos;
	}

	

	public double getDinheiro() {
		return jogador.getDinheiro();
	}


	public double descontoTotal(double descontoJogo){
		desconto += descontoJogo;
		return desconto;
	}

	
	

	@Override
	public String toString() {
		return "Usuario [getDesconto()="  + ", getDinheiro()="
				+ getDinheiro() + ", getAdiciona()=" + getPontos()
				+ ", getDinheiroDesconto()=" 
				+ ", getNome()=" + getNome() + ", getLogin()=" + getLogin()
				+ ", getJogos()=" + getJogos() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	 * Equals criado para indicar que dois usuarios sao iguais quando tiverem
	 * o mesmo nome e login.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Usuario) {

			Usuario usuario = (Usuario) obj;
			if (usuario.getNome().equals(this.getNome())
					&& usuario.getLogin() == this.getLogin()) {
				return true;

			} else {

				return false;
			}
		}
		return false;
	}
	public int compareTo(Usuario usuario) {
	       if(this.pontos < usuario.getPontos()){
	    	   return -1;
	       }
	       if(this.pontos > usuario.getPontos()){
	    	   return 1;
	       }
	       return 0;
		}
}
